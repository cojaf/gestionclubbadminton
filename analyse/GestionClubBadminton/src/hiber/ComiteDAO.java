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
 * Comite entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Comite
 * @author MyEclipse Persistence Tools
 */
public class ComiteDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ComiteDAO.class);
	// property constants
	public static final String NOM_COMITE = "nomComite";

	public void save(Comite transientInstance) {
		log.debug("saving Comite instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Comite persistentInstance) {
		log.debug("deleting Comite instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Comite findById(java.lang.Integer id) {
		log.debug("getting Comite instance with id: " + id);
		try {
			Comite instance = (Comite) getSession().get("hiber.Comite", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Comite> findByExample(Comite instance) {
		log.debug("finding Comite instance by example");
		try {
			List<Comite> results = (List<Comite>) getSession()
					.createCriteria("hiber.Comite").add(create(instance))
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
		log.debug("finding Comite instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Comite as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Comite> findByNomComite(Object nomComite) {
		return findByProperty(NOM_COMITE, nomComite);
	}

	public List findAll() {
		log.debug("finding all Comite instances");
		try {
			String queryString = "from Comite";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Comite merge(Comite detachedInstance) {
		log.debug("merging Comite instance");
		try {
			Comite result = (Comite) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Comite instance) {
		log.debug("attaching dirty Comite instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Comite instance) {
		log.debug("attaching clean Comite instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}