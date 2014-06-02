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
 * Classement entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Classement
 * @author MyEclipse Persistence Tools
 */
public class ClassementDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ClassementDAO.class);
	// property constants
	public static final String DISCIPLINE = "discipline";
	public static final String CATEGORIE = "categorie";

	public void save(Classement transientInstance) {
		log.debug("saving Classement instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Classement persistentInstance) {
		log.debug("deleting Classement instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Classement findById(java.lang.Integer id) {
		log.debug("getting Classement instance with id: " + id);
		try {
			Classement instance = (Classement) getSession().get(
					"hiber.Classement", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Classement> findByExample(Classement instance) {
		log.debug("finding Classement instance by example");
		try {
			List<Classement> results = (List<Classement>) getSession()
					.createCriteria("hiber.Classement").add(create(instance))
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
		log.debug("finding Classement instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Classement as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Classement> findByDiscipline(Object discipline) {
		return findByProperty(DISCIPLINE, discipline);
	}

	public List<Classement> findByCategorie(Object categorie) {
		return findByProperty(CATEGORIE, categorie);
	}

	public List findAll() {
		log.debug("finding all Classement instances");
		try {
			String queryString = "from Classement";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Classement merge(Classement detachedInstance) {
		log.debug("merging Classement instance");
		try {
			Classement result = (Classement) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Classement instance) {
		log.debug("attaching dirty Classement instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Classement instance) {
		log.debug("attaching clean Classement instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}