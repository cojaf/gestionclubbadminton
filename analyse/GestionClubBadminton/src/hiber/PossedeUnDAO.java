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
 * PossedeUn entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.PossedeUn
 * @author MyEclipse Persistence Tools
 */
public class PossedeUnDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PossedeUnDAO.class);

	// property constants

	public void save(PossedeUn transientInstance) {
		log.debug("saving PossedeUn instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PossedeUn persistentInstance) {
		log.debug("deleting PossedeUn instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PossedeUn findById(java.lang.Integer id) {
		log.debug("getting PossedeUn instance with id: " + id);
		try {
			PossedeUn instance = (PossedeUn) getSession().get(
					"hiber.PossedeUn", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<PossedeUn> findByExample(PossedeUn instance) {
		log.debug("finding PossedeUn instance by example");
		try {
			List<PossedeUn> results = (List<PossedeUn>) getSession()
					.createCriteria("hiber.PossedeUn").add(create(instance))
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
		log.debug("finding PossedeUn instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PossedeUn as model where model."
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
		log.debug("finding all PossedeUn instances");
		try {
			String queryString = "from PossedeUn";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PossedeUn merge(PossedeUn detachedInstance) {
		log.debug("merging PossedeUn instance");
		try {
			PossedeUn result = (PossedeUn) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PossedeUn instance) {
		log.debug("attaching dirty PossedeUn instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PossedeUn instance) {
		log.debug("attaching clean PossedeUn instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}