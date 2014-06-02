package hiber;

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

/**
 * Adversaire entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adversaire", catalog = "gestion")
public class Adversaire implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPersonne;
	private Personne personne;
	private Integer idAdversaire;
	private String numeroLigue;
	private Set<JoueUn> joueUns = new HashSet<JoueUn>(0);
	private Set<PossedeUn> possedeUns = new HashSet<PossedeUn>(0);

	// Constructors

	/** default constructor */
	public Adversaire() {
	}

	/** minimal constructor */
	public Adversaire(Integer idPersonne, Personne personne,
			Integer idAdversaire, String numeroLigue) {
		this.idPersonne = idPersonne;
		this.personne = personne;
		this.idAdversaire = idAdversaire;
		this.numeroLigue = numeroLigue;
	}

	/** full constructor */
	public Adversaire(Integer idPersonne, Personne personne,
			Integer idAdversaire, String numeroLigue, Set<JoueUn> joueUns,
			Set<PossedeUn> possedeUns) {
		this.idPersonne = idPersonne;
		this.personne = personne;
		this.idAdversaire = idAdversaire;
		this.numeroLigue = numeroLigue;
		this.joueUns = joueUns;
		this.possedeUns = possedeUns;
	}

	// Property accessors
	@Id
	@Column(name = "id_Personne", unique = true, nullable = false)
	public Integer getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Personne", unique = true, nullable = false, insertable = false, updatable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name = "id_Adversaire", nullable = false)
	public Integer getIdAdversaire() {
		return this.idAdversaire;
	}

	public void setIdAdversaire(Integer idAdversaire) {
		this.idAdversaire = idAdversaire;
	}

	@Column(name = "numero_Ligue", nullable = false, length = 9)
	public String getNumeroLigue() {
		return this.numeroLigue;
	}

	public void setNumeroLigue(String numeroLigue) {
		this.numeroLigue = numeroLigue;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adversaire")
	public Set<JoueUn> getJoueUns() {
		return this.joueUns;
	}

	public void setJoueUns(Set<JoueUn> joueUns) {
		this.joueUns = joueUns;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adversaire")
	public Set<PossedeUn> getPossedeUns() {
		return this.possedeUns;
	}

	public void setPossedeUns(Set<PossedeUn> possedeUns) {
		this.possedeUns = possedeUns;
	}

}