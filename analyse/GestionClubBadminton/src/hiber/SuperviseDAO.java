package hiber;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Supervise entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Supervise
 * @author MyEclipse Persistence Tools
 */
public class SuperviseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(SuperviseDAO.class);

	// property constants

	public void save(Supervise transientInstance) {
		log.debug("saving Supervise instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Supervise persistentInstance) {
		log.debug("deleting Supervise instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Supervise findById(hiber.SuperviseId id) {
		log.debug("getting Supervise instance with id: " + id);
		try {
			Supervise instance = (Supervise) getSession().get(
					"hiber.Supervise", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Supervise> findByExample(Supervise instance) {
		log.debug("finding Supervise instance by example");
		try {
			List<Supervise> results = (List<Supervise>) getSession()
					.createCriteria("hiber.Supervise").add(create(instance))
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
		log.debug("finding Supervise instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Supervise as model where model."
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
		log.debug("finding all Supervise instances");
		try {
			String queryString = "from Supervise";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Supervise merge(Supervise detachedInstance) {
		log.debug("merging Supervise instance");
		try {
			Supervise result = (Supervise) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Supervise instance) {
		log.debug("attaching dirty Supervise instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Supervise instance) {
		log.debug("attaching clean Supervise instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}