package hiber;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * JoueUn entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.JoueUn
 * @author MyEclipse Persistence Tools
 */
public class JoueUnDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(JoueUnDAO.class);

	// property constants

	public void save(JoueUn transientInstance) {
		log.debug("saving JoueUn instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(JoueUn persistentInstance) {
		log.debug("deleting JoueUn instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public JoueUn findById(hiber.JoueUnId id) {
		log.debug("getting JoueUn instance with id: " + id);
		try {
			JoueUn instance = (JoueUn) getSession().get("hiber.JoueUn", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<JoueUn> findByExample(JoueUn instance) {
		log.debug("finding JoueUn instance by example");
		try {
			List<JoueUn> results = (List<JoueUn>) getSession()
					.createCriteria("hiber.JoueUn").add(create(instance))
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
		log.debug("finding JoueUn instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from JoueUn as model where model."
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
		log.debug("finding all JoueUn instances");
		try {
			String queryString = "from JoueUn";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public JoueUn merge(JoueUn detachedInstance) {
		log.debug("merging JoueUn instance");
		try {
			JoueUn result = (JoueUn) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(JoueUn instance) {
		log.debug("attaching dirty JoueUn instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(JoueUn instance) {
		log.debug("attaching clean JoueUn instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}