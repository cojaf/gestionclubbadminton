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
 * Pays entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "pays", catalog = "gestion")
public class Pays implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPays;
	private String nomPays;
	private String codePays;
	private Set<Adresse> adresses = new HashSet<Adresse>(0);

	// Constructors

	/** default constructor */
	public Pays() {
	}

	/** minimal constructor */
	public Pays(Integer idPays, String nomPays, String codePays) {
		this.idPays = idPays;
		this.nomPays = nomPays;
		this.codePays = codePays;
	}

	/** full constructor */
	public Pays(Integer idPays, String nomPays, String codePays,
			Set<Adresse> adresses) {
		this.idPays = idPays;
		this.nomPays = nomPays;
		this.codePays = codePays;
		this.adresses = adresses;
	}

	// Property accessors
	@Id
	@Column(name = "id_Pays", unique = true, nullable = false)
	public Integer getIdPays() {
		return this.idPays;
	}

	public void setIdPays(Integer idPays) {
		this.idPays = idPays;
	}

	@Column(name = "nom_Pays", nullable = false, length = 50)
	public String getNomPays() {
		return this.nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

	@Column(name = "code_Pays", nullable = false, length = 5)
	public String getCodePays() {
		return this.codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pays")
	public Set<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

}