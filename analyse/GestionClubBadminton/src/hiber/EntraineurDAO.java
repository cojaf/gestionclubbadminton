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
 * Entraineur entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Entraineur
 * @author MyEclipse Persistence Tools
 */
public class EntraineurDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(EntraineurDAO.class);
	// property constants
	public static final String DIPLOME = "diplome";

	public void save(Entraineur transientInstance) {
		log.debug("saving Entraineur instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Entraineur persistentInstance) {
		log.debug("deleting Entraineur instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Entraineur findById(java.lang.Integer id) {
		log.debug("getting Entraineur instance with id: " + id);
		try {
			Entraineur instance = (Entraineur) getSession().get(
					"hiber.Entraineur", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Entraineur> findByExample(Entraineur instance) {
		log.debug("finding Entraineur instance by example");
		try {
			List<Entraineur> results = (List<Entraineur>) getSession()
					.createCriteria("hiber.Entraineur").add(create(instance))
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
		log.debug("finding Entraineur instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Entraineur as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Entraineur> findByDiplome(Object diplome) {
		return findByProperty(DIPLOME, diplome);
	}

	public List findAll() {
		log.debug("finding all Entraineur instances");
		try {
			String queryString = "from Entraineur";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Entraineur merge(Entraineur detachedInstance) {
		log.debug("merging Entraineur instance");
		try {
			Entraineur result = (Entraineur) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Entraineur instance) {
		log.debug("attaching dirty Entraineur instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Entraineur instance) {
		log.debug("attaching clean Entraineur instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}