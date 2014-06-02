package hiber;

import java.util.List;
import java.util.Set;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Salle
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see hiber.Salle
 * @author MyEclipse Persistence Tools
 */
public class SalleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SalleDAO.class);
	// property constants
	public static final String NOM_SALLE = "nomSalle";
	public static final String NOM_RESPONSABLE = "nomResponsable";

	public void save(Salle transientInstance) {
		log.debug("saving Salle instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Salle persistentInstance) {
		log.debug("deleting Salle instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Salle findById(java.lang.Integer id) {
		log.debug("getting Salle instance with id: " + id);
		try {
			Salle instance = (Salle) getSession().get("hiber.Salle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Salle> findByExample(Salle instance) {
		log.debug("finding Salle instance by example");
		try {
			List<Salle> results = (List<Salle>) getSession()
					.createCriteria("hiber.Salle").add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Salle instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Salle as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Salle> findByNomSalle(Object nomSalle) {
		return findByProperty(NOM_SALLE, nomSalle);
	}

	public List<Salle> findByNomResponsable(Object nomResponsable) {
		return findByProperty(NOM_RESPONSABLE, nomResponsable);
	}

	public List findAll() {
		log.debug("finding all Salle instances");
		try {
			String queryString = "from Salle";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Salle merge(Salle detachedInstance) {
		log.debug("merging Salle instance");
		try {
			Salle result = (Salle) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Salle instance) {
		log.debug("attaching dirty Salle instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Salle instance) {
		log.debug("attaching clean Salle instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}