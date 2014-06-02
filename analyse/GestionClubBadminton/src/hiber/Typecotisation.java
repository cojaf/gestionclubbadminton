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
 * Typecotisation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "typecotisation", catalog = "gestion")
public class Typecotisation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idTypeCotisation;
	private String nomTypeCotisation;
	private Integer montant;
	private Set<Cotisation> cotisations = new HashSet<Cotisation>(0);

	// Constructors

	/** default constructor */
	public Typecotisation() {
	}

	/** minimal constructor */
	public Typecotisation(Integer idTypeCotisation, String nomTypeCotisation,
			Integer montant) {
		this.idTypeCotisation = idTypeCotisation;
		this.nomTypeCotisation = nomTypeCotisation;
		this.montant = montant;
	}

	/** full constructor */
	public Typecotisation(Integer idTypeCotisation, String nomTypeCotisation,
			Integer montant, Set<Cotisation> cotisations) {
		this.idTypeCotisation = idTypeCotisation;
		this.nomTypeCotisation = nomTypeCotisation;
		this.montant = montant;
		this.cotisations = cotisations;
	}

	// Property accessors
	@Id
	@Column(name = "id_TypeCotisation", unique = true, nullable = false)
	public Integer getIdTypeCotisation() {
		return this.idTypeCotisation;
	}

	public void setIdTypeCotisation(Integer idTypeCotisation) {
		this.idTypeCotisation = idTypeCotisation;
	}

	@Column(name = "nom_TypeCotisation", nullable = false, length = 50)
	public String getNomTypeCotisation() {
		return this.nomTypeCotisation;
	}

	public void setNomTypeCotisation(String nomTypeCotisation) {
		this.nomTypeCotisation = nomTypeCotisation;
	}

	@Column(name = "montant", nullable = false)
	public Integer getMontant() {
		return this.montant;
	}

	public void setMontant(Integer montant) {
		this.montant = montant;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "typecotisation")
	public Set<Cotisation> getCotisations() {
		return this.cotisations;
	}

	public void setCotisations(Set<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

}