package hiber;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Equipe entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Equipe
 * @author MyEclipse Persistence Tools
 */
public class EquipeDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(EquipeDAO.class);

	// property constants

	public void save(Equipe transientInstance) {
		log.debug("saving Equipe instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Equipe persistentInstance) {
		log.debug("deleting Equipe instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Equipe findById(hiber.EquipeId id) {
		log.debug("getting Equipe instance with id: " + id);
		try {
			Equipe instance = (Equipe) getSession().get("hiber.Equipe", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Equipe> findByExample(Equipe instance) {
		log.debug("finding Equipe instance by example");
		try {
			List<Equipe> results = (List<Equipe>) getSession()
					.createCriteria("hiber.Equipe").add(create(instance))
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
		log.debug("finding Equipe instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Equipe as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Equipe instances");
		try {
			String queryString = "from Equipe";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Equipe merge(Equipe detachedInstance) {
		log.debug("merging Equipe instance");
		try {
			Equipe result = (Equipe) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Equipe instance) {
		log.debug("attaching dirty Equipe instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Equipe instance) {
		log.debug("attaching clean Equipe instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}