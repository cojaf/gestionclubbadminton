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
 * Competiteur entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see hiber.Competiteur
 * @author MyEclipse Persistence Tools
 */
public class CompetiteurDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompetiteurDAO.class);
	// property constants
	public static final String NUMERO_LIGUE = "numeroLigue";

	public void save(Competiteur transientInstance) {
		log.debug("saving Competiteur instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Competiteur persistentInstance) {
		log.debug("deleting Competiteur instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Competiteur findById(java.lang.Integer id) {
		log.debug("getting Competiteur instance with id: " + id);
		try {
			Competiteur instance = (Competiteur) getSession().get(
					"hiber.Competiteur", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Competiteur> findByExample(Competiteur instance) {
		log.debug("finding Competiteur instance by example");
		try {
			List<Competiteur> results = (List<Competiteur>) getSession()
					.createCriteria("hiber.Competiteur").add(create(instance))
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
		log.debug("finding Competiteur instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Competiteur as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Competiteur> findByNumeroLigue(Object numeroLigue) {
		return findByProperty(NUMERO_LIGUE, numeroLigue);
	}

	public List findAll() {
		log.debug("finding all Competiteur instances");
		try {
			String queryString = "from Competiteur";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Competiteur merge(Competiteur detachedInstance) {
		log.debug("merging Competiteur instance");
		try {
			Competiteur result = (Competiteur) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Competiteur instance) {
		log.debug("attaching dirty Competiteur instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Competiteur instance) {
		log.debug("attaching clean Competiteur instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}