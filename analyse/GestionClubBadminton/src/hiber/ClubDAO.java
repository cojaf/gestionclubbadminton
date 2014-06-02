package hiber;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Club
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hiber.Club
 * @author MyEclipse Persistence Tools
 */
public class ClubDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ClubDAO.class);
	// property constants
	public static final String NOM_CLUB = "nomClub";

	public void save(Club transientInstance) {
		log.debug("saving Club instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Club persistentInstance) {
		log.debug("deleting Club instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Club findById(java.lang.Integer id) {
		log.debug("getting Club instance with id: " + id);
		try {
			Club instance = (Club) getSession().get("hiber.Club", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Club> findByExample(Club instance) {
		log.debug("finding Club instance by example");
		try {
			List<Club> results = (List<Club>) getSession()
					.createCriteria("hiber.Club").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Club instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Club as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Club> findByNomClub(Object nomClub) {
		return findByProperty(NOM_CLUB, nomClub);
	}

	public List findAll() {
		log.debug("finding all Club instances");
		try {
			String queryString = "from Club";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Club merge(Club detachedInstance) {
		log.debug("merging Club instance");
		try {
			Club result = (Club) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Club instance) {
		log.debug("attaching dirty Club instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Club instance) {
		log.debug("attaching clean Club instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}