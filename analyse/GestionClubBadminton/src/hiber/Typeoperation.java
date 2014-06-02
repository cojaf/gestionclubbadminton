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
 * Typeoperation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "typeoperation", catalog = "gestion")
public class Typeoperation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idType;
	private String nomType;
	private Set<Operation> operations = new HashSet<Operation>(0);

	// Constructors

	/** default constructor */
	public Typeoperation() {
	}

	/** minimal constructor */
	public Typeoperation(Integer idType, String nomType) {
		this.idType = idType;
		this.nomType = nomType;
	}

	/** full constructor */
	public Typeoperation(Integer idType, String nomType,
			Set<Operation> operations) {
		this.idType = idType;
		this.nomType = nomType;
		this.operations = operations;
	}

	// Property accessors
	@Id
	@Column(name = "id_Type", unique = true, nullable = false)
	public Integer getIdType() {
		return this.idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	@Column(name = "nom_Type", nullable = false, length = 50)
	public String getNomType() {
		return this.nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "typeoperation")
	public Set<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

}