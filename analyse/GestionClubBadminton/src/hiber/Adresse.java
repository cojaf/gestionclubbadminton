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
 * Adresse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "adresse", catalog = "gestion")
public class Adresse implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idAdresse;
	private Pays pays;
	private String ville;
	private String rue;
	private String numero;
	private String boite;
	private Set<Membre> membres = new HashSet<Membre>(0);
	private Set<Salle> salles = new HashSet<Salle>(0);

	// Constructors

	/** default constructor */
	public Adresse() {
	}

	/** minimal constructor */
	public Adresse(Integer idAdresse, Pays pays, String ville, String rue,
			String numero, String boite) {
		this.idAdresse = idAdresse;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.boite = boite;
	}

	/** full constructor */
	public Adresse(Integer idAdresse, Pays pays, String ville, String rue,
			String numero, String boite, Set<Membre> membres, Set<Salle> salles) {
		this.idAdresse = idAdresse;
		this.pays = pays;
		this.ville = ville;
		this.rue = rue;
		this.numero = numero;
		this.boite = boite;
		this.membres = membres;
		this.salles = salles;
	}

	// Property accessors
	@Id
	@Column(name = "id_Adresse", unique = true, nullable = false)
	public Integer getIdAdresse() {
		return this.idAdresse;
	}

	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Pays", nullable = false)
	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	@Column(name = "ville", nullable = false, length = 50)
	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Column(name = "rue", nullable = false, length = 50)
	public String getRue() {
		return this.rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	@Column(name = "numero", nullable = false, length = 6)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "boite", nullable = false, length = 4)
	public String getBoite() {
		return this.boite;
	}

	public void setBoite(String boite) {
		this.boite = boite;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adresse")
	public Set<Membre> getMembres() {
		return this.membres;
	}

	public void setMembres(Set<Membre> membres) {
		this.membres = membres;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "adresse")
	public Set<Salle> getSalles() {
		return this.salles;
	}

	public void setSalles(Set<Salle> salles) {
		this.salles = salles;
	}

}