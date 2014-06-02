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
 * Salle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "salle", catalog = "gestion")
public class Salle implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSalle;
	private Adresse adresse;
	private String nomSalle;
	private String nomResponsable;
	private Set<Rencontre> rencontres = new HashSet<Rencontre>(0);
	private Set<EstDonne> estDonnes = new HashSet<EstDonne>(0);

	// Constructors

	/** default constructor */
	public Salle() {
	}

	/** minimal constructor */
	public Salle(Integer idSalle, Adresse adresse, String nomSalle,
			String nomResponsable) {
		this.idSalle = idSalle;
		this.adresse = adresse;
		this.nomSalle = nomSalle;
		this.nomResponsable = nomResponsable;
	}

	/** full constructor */
	public Salle(Integer idSalle, Adresse adresse, String nomSalle,
			String nomResponsable, Set<Rencontre> rencontres,
			Set<EstDonne> estDonnes) {
		this.idSalle = idSalle;
		this.adresse = adresse;
		this.nomSalle = nomSalle;
		this.nomResponsable = nomResponsable;
		this.rencontres = rencontres;
		this.estDonnes = estDonnes;
	}

	// Property accessors
	@Id
	@Column(name = "id_Salle", unique = true, nullable = false)
	public Integer getIdSalle() {
		return this.idSalle;
	}

	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Adresse", nullable = false)
	public Adresse getAdresse() {
		return this.adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Column(name = "nom_Salle", nullable = false, length = 50)
	public String getNomSalle() {
		return this.nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	@Column(name = "nom_Responsable", nullable = false, length = 50)
	public String getNomResponsable() {
		return this.nomResponsable;
	}

	public void setNomResponsable(String nomResponsable) {
		this.nomResponsable = nomResponsable;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salle")
	public Set<Rencontre> getRencontres() {
		return this.rencontres;
	}

	public void setRencontres(Set<Rencontre> rencontres) {
		this.rencontres = rencontres;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "salle")
	public Set<EstDonne> getEstDonnes() {
		return this.estDonnes;
	}

	public void setEstDonnes(Set<EstDonne> estDonnes) {
		this.estDonnes = estDonnes;
	}

}