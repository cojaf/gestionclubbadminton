package hiber;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Entrainement entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hiber.Entrainement
 * @author MyEclipse Persistence Tools
 */
public class EntrainementDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EntrainementDAO.class);
	// property constants
	public static final String JOUR = "jour";

	public void save(Entrainement transientInstance) {
		log.debug("saving Entrainement instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Entrainement persistentInstance) {
		log.debug("deleting Entrainement instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Entrainement findById(java.lang.Integer id) {
		log.debug("getting Entrainement instance with id: " + id);
		try {
			Entrainement instance = (Entrainement) getSession().get(
					"hiber.Entrainement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Entrainement> findByExample(Entrainement instance) {
		log.debug("finding Entrainement instance by example");
		try {
			List<Entrainement> results = (List<Entrainement>) getSession()
					.createCriteria("hiber.Entrainement").add(create(instance))
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
		log.debug("finding Entrainement instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Entrainement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Entrainement> findByJour(Object jour) {
		return findByProperty(JOUR, jour);
	}

	public List findAll() {
		log.debug("finding all Entrainement instances");
		try {
			String queryString = "from Entrainement";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Entrainement merge(Entrainement detachedInstance) {
		log.debug("merging Entrainement instance");
		try {
			Entrainement result = (Entrainement) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Entrainement instance) {
		log.debug("attaching dirty Entrainement instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Entrainement instance) {
		log.debug("attaching clean Entrainement instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}