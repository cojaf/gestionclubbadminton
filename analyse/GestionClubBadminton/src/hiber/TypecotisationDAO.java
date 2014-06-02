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
 * Typecotisation entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hiber.Typecotisation
 * @author MyEclipse Persistence Tools
 */
public class TypecotisationDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(TypecotisationDAO.class);
	// property constants
	public static final String NOM_TYPE_COTISATION = "nomTypeCotisation";
	public static final String MONTANT = "montant";

	public void save(Typecotisation transientInstance) {
		log.debug("saving Typecotisation instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Typecotisation persistentInstance) {
		log.debug("deleting Typecotisation instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Typecotisation findById(java.lang.Integer id) {
		log.debug("getting Typecotisation instance with id: " + id);
		try {
			Typecotisation instance = (Typecotisation) getSession().get(
					"hiber.Typecotisation", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Typecotisation> findByExample(Typecotisation instance) {
		log.debug("finding Typecotisation instance by example");
		try {
			List<Typecotisation> results = (List<Typecotisation>) getSession()
					.createCriteria("hiber.Typecotisation")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Typecotisation instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Typecotisation as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Typecotisation> findByNomTypeCotisation(Object nomTypeCotisation) {
		return findByProperty(NOM_TYPE_COTISATION, nomTypeCotisation);
	}

	public List<Typecotisation> findByMontant(Object montant) {
		return findByProperty(MONTANT, montant);
	}

	public List findAll() {
		log.debug("finding all Typecotisation instances");
		try {
			String queryString = "from Typecotisation";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Typecotisation merge(Typecotisation detachedInstance) {
		log.debug("merging Typecotisation instance");
		try {
			Typecotisation result = (Typecotisation) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Typecotisation instance) {
		log.debug("attaching dirty Typecotisation instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Typecotisation instance) {
		log.debug("attaching clean Typecotisation instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}