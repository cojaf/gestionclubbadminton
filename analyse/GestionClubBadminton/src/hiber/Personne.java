package hiber;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Personne entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "personne", catalog = "gestion")
public class Personne implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPersonne;
	private String nom;
	private String prenom;
	private String sexe;
	private Set<Membre> membres = new HashSet<Membre>(0);
	private Set<Adversaire> adversaires = new HashSet<Adversaire>(0);
	private Set<Entraineur> entraineurs = new HashSet<Entraineur>(0);

	// Constructors

	/** default constructor */
	public Personne() {
	}

	/** minimal constructor */
	public Personne(Integer idPersonne, String nom, String prenom, String sexe) {
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
	}

	/** full constructor */
	public Personne(Integer idPersonne, String nom, String prenom, String sexe,
			Set<Membre> membres, Set<Adversaire> adversaires,
			Set<Entraineur> entraineurs) {
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.membres = membres;
		this.adversaires = adversaires;
		this.entraineurs = entraineurs;
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

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prenom", nullable = false, length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Column(name = "sexe", nullable = false, length = 1)
	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Membre> getMembres() {
		return this.membres;
	}

	public void setMembres(Set<Membre> membres) {
		this.membres = membres;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Adversaire> getAdversaires() {
		return this.adversaires;
	}

	public void setAdversaires(Set<Adversaire> adversaires) {
		this.adversaires = adversaires;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "personne")
	public Set<Entraineur> getEntraineurs() {
		return this.entraineurs;
	}

	public void setEntraineurs(Set<Entraineur> entraineurs) {
		this.entraineurs = entraineurs;
	}

}