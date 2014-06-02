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
 * Operation entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Operation
 * @author MyEclipse Persistence Tools
 */
public class OperationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OperationDAO.class);
	// property constants
	public static final String NOM_OPERATION = "nomOperation";
	public static final String DESCRIPTION = "description";
	public static final String MONTANT = "montant";

	public void save(Operation transientInstance) {
		log.debug("saving Operation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Operation persistentInstance) {
		log.debug("deleting Operation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Operation findById(java.lang.Integer id) {
		log.debug("getting Operation instance with id: " + id);
		try {
			Operation instance = (Operation) getSession().get(
					"hiber.Operation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Operation> findByExample(Operation instance) {
		log.debug("finding Operation instance by example");
		try {
			List<Operation> results = (List<Operation>) getSession()
					.createCriteria("hiber.Operation").add(create(instance))
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
		log.debug("finding Operation instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Operation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Operation> findByNomOperation(Object nomOperation) {
		return findByProperty(NOM_OPERATION, nomOperation);
	}

	public List<Operation> findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}

	public List<Operation> findByMontant(Object montant) {
		return findByProperty(MONTANT, montant);
	}

	public List findAll() {
		log.debug("finding all Operation instances");
		try {
			String queryString = "from Operation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Operation merge(Operation detachedInstance) {
		log.debug("merging Operation instance");
		try {
			Operation result = (Operation) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Operation instance) {
		log.debug("attaching dirty Operation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Operation instance) {
		log.debug("attaching clean Operation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}