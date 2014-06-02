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
 * Rencontre entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see hiber.Rencontre
 * @author MyEclipse Persistence Tools
 */
public class RencontreDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(RencontreDAO.class);
	// property constants
	public static final String TYPE_RENCONTRE = "typeRencontre";
	public static final String DIVISION = "division";
	public static final String RESULTAT = "resultat";
	public static final String COMMENTAIRES = "commentaires";

	public void save(Rencontre transientInstance) {
		log.debug("saving Rencontre instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Rencontre persistentInstance) {
		log.debug("deleting Rencontre instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Rencontre findById(java.lang.Integer id) {
		log.debug("getting Rencontre instance with id: " + id);
		try {
			Rencontre instance = (Rencontre) getSession().get(
					"hiber.Rencontre", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Rencontre> findByExample(Rencontre instance) {
		log.debug("finding Rencontre instance by example");
		try {
			List<Rencontre> results = (List<Rencontre>) getSession()
					.createCriteria("hiber.Rencontre").add(create(instance))
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
		log.debug("finding Rencontre instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Rencontre as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Rencontre> findByTypeRencontre(Object typeRencontre) {
		return findByProperty(TYPE_RENCONTRE, typeRencontre);
	}

	public List<Rencontre> findByDivision(Object division) {
		return findByProperty(DIVISION, division);
	}

	public List<Rencontre> findByResultat(Object resultat) {
		return findByProperty(RESULTAT, resultat);
	}

	public List<Rencontre> findByCommentaires(Object commentaires) {
		return findByProperty(COMMENTAIRES, commentaires);
	}

	public List findAll() {
		log.debug("finding all Rencontre instances");
		try {
			String queryString = "from Rencontre";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Rencontre merge(Rencontre detachedInstance) {
		log.debug("merging Rencontre instance");
		try {
			Rencontre result = (Rencontre) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Rencontre instance) {
		log.debug("attaching dirty Rencontre instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Rencontre instance) {
		log.debug("attaching clean Rencontre instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}