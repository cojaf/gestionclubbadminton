package hiber;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Matchs entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Matchs
 * @author MyEclipse Persistence Tools
 */
public class MatchsDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MatchsDAO.class);
	// property constants
	public static final String TYPE_MATCH = "typeMatch";
	public static final String SCORE = "score";

	public void save(Matchs transientInstance) {
		log.debug("saving Matchs instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Matchs persistentInstance) {
		log.debug("deleting Matchs instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Matchs findById(java.lang.Integer id) {
		log.debug("getting Matchs instance with id: " + id);
		try {
			Matchs instance = (Matchs) getSession().get("hiber.Matchs", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Matchs> findByExample(Matchs instance) {
		log.debug("finding Matchs instance by example");
		try {
			List<Matchs> results = (List<Matchs>) getSession()
					.createCriteria("hiber.Matchs").add(create(instance))
					.list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Matchs instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Matchs as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Matchs> findByTypeMatch(Object typeMatch) {
		return findByProperty(TYPE_MATCH, typeMatch);
	}

	public List<Matchs> findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all Matchs instances");
		try {
			String queryString = "from Matchs";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Matchs merge(Matchs detachedInstance) {
		log.debug("merging Matchs instance");
		try {
			Matchs result = (Matchs) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Matchs instance) {
		log.debug("attaching dirty Matchs instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Matchs instance) {
		log.debug("attaching clean Matchs instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}