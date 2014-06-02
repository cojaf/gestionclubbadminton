package hiber;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Obtient entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Obtient
 * @author MyEclipse Persistence Tools
 */
public class ObtientDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ObtientDAO.class);

	// property constants

	public void save(Obtient transientInstance) {
		log.debug("saving Obtient instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Obtient persistentInstance) {
		log.debug("deleting Obtient instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Obtient findById(hiber.ObtientId id) {
		log.debug("getting Obtient instance with id: " + id);
		try {
			Obtient instance = (Obtient) getSession().get("hiber.Obtient", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Obtient> findByExample(Obtient instance) {
		log.debug("finding Obtient instance by example");
		try {
			List<Obtient> results = (List<Obtient>) getSession()
					.createCriteria("hiber.Obtient").add(create(instance))
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
		log.debug("finding Obtient instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Obtient as model where model."
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
		log.debug("finding all Obtient instances");
		try {
			String queryString = "from Obtient";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Obtient merge(Obtient detachedInstance) {
		log.debug("merging Obtient instance");
		try {
			Obtient result = (Obtient) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Obtient instance) {
		log.debug("attaching dirty Obtient instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Obtient instance) {
		log.debug("attaching clean Obtient instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}