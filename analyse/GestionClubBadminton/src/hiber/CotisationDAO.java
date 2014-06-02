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
 * Cotisation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Cotisation
 * @author MyEclipse Persistence Tools
 */
public class CotisationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CotisationDAO.class);

	// property constants

	public void save(Cotisation transientInstance) {
		log.debug("saving Cotisation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Cotisation persistentInstance) {
		log.debug("deleting Cotisation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cotisation findById(java.lang.Integer id) {
		log.debug("getting Cotisation instance with id: " + id);
		try {
			Cotisation instance = (Cotisation) getSession().get(
					"hiber.Cotisation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Cotisation> findByExample(Cotisation instance) {
		log.debug("finding Cotisation instance by example");
		try {
			List<Cotisation> results = (List<Cotisation>) getSession()
					.createCriteria("hiber.Cotisation").add(create(instance))
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
		log.debug("finding Cotisation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cotisation as model where model."
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
		log.debug("finding all Cotisation instances");
		try {
			String queryString = "from Cotisation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Cotisation merge(Cotisation detachedInstance) {
		log.debug("merging Cotisation instance");
		try {
			Cotisation result = (Cotisation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cotisation instance) {
		log.debug("attaching dirty Cotisation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cotisation instance) {
		log.debug("attaching clean Cotisation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}