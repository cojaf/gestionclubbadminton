package hiber;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Membre entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "membre", catalog = "gestion", uniqueConstraints = @UniqueConstraint(columnNames = "id_Personne"))
public class Membre implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMembre;
	private Personne personne;
	private Adresse adresse;
	private Date dateNaissance;
	private String conjoint;
	private String courriel;
	private String telephone;
	private Set<Comite> comites = new HashSet<Comite>(0);
	private Set<EstAffilie> estAffilies = new HashSet<EstAffilie>(0);
	private Set<Paye> payes = new HashSet<Paye>(0);

	// Constructors

	/** default constructor */
	public Membre() {
	}

	/** minimal constructor */
	public Membre(Integer idMembre, Personne personne, Adresse adresse,
			Date dateNaissance, String conjoint, String courriel,
			String telephone) {
		this.idMembre = idMembre;
		this.personne = personne;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.conjoint = conjoint;
		this.courriel = courriel;
		this.telephone = telephone;
	}

	/** full constructor */
	public Membre(Integer idMembre, Personne personne, Adresse adresse,
			Date dateNaissance, String conjoint, String courriel,
			String telephone, Set<Comite> comites, Set<EstAffilie> estAffilies,
			Set<Paye> payes) {
		this.idMembre = idMembre;
		this.personne = personne;
		this.adresse = adresse;
		this.dateNaissance = dateNaissance;
		this.conjoint = conjoint;
		this.courriel = courriel;
		this.telephone = telephone;
		this.comites = comites;
		this.estAffilies = estAffilies;
		this.payes = payes;
	}

	// Property accessors
	@Id
	@Column(name = "id_Membre", unique = true, nullable = false)
	public Integer getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(Integer idMembre) {
		this.idMembre = idMembre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Personne", unique = true, nullable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Adresse", nullable = false)
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_Naissance", nullable = false, length = 10)
	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	@Column(name = "conjoint", nullable = false, length = 50)
	public String getConjoint() {
		return this.conjoint;
	}

	public void setConjoint(String conjoint) {
		this.conjoint = conjoint;
	}

	@Column(name = "courriel", nullable = false, length = 50)
	public String getCourriel() {
		return this.courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	@Column(name = "telephone", nullable = false, length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "membre")
	public Set<Comite> getComites() {
		return this.comites;
	}

	public void setComites(Set<Comite> comites) {
		this.comites = comites;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "membre")
	public Set<EstAffilie> getEstAffilies() {
		return this.estAffilies;
	}

	public void setEstAffilies(Set<EstAffilie> estAffilies) {
		this.estAffilies = estAffilies;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "membre")
	public Set<Paye> getPayes() {
		return this.payes;
	}

	public void setPayes(Set<Paye> payes) {
		this.payes = payes;
	}

}