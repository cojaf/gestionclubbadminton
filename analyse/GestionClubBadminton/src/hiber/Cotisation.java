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
import javax.persistence.UniqueConstraint;

/**
 * Cotisation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "cotisation", catalog = "gestion", uniqueConstraints = @UniqueConstraint(columnNames = "id_Operation"))
public class Cotisation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCotisation;
	private Typecotisation typecotisation;
	private Operation operation;
	private Set<Paye> payes = new HashSet<Paye>(0);

	// Constructors

	/** default constructor */
	public Cotisation() {
	}

	/** minimal constructor */
	public Cotisation(Integer idCotisation, Typecotisation typecotisation,
			Operation operation) {
		this.idCotisation = idCotisation;
		this.typecotisation = typecotisation;
		this.operation = operation;
	}

	/** full constructor */
	public Cotisation(Integer idCotisation, Typecotisation typecotisation,
			Operation operation, Set<Paye> payes) {
		this.idCotisation = idCotisation;
		this.typecotisation = typecotisation;
		this.operation = operation;
		this.payes = payes;
	}

	// Property accessors
	@Id
	@Column(name = "id_Cotisation", unique = true, nullable = false)
	public Integer getIdCotisation() {
		return this.idCotisation;
	}

	public void setIdCotisation(Integer idCotisation) {
		this.idCotisation = idCotisation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_TypeCotisation", nullable = false)
	public Typecotisation getTypecotisation() {
		return this.typecotisation;
	}

	public void setTypecotisation(Typecotisation typecotisation) {
		this.typecotisation = typecotisation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Operation", unique = true, nullable = false)
	public Operation getOperation() {
		return this.operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cotisation")
	public Set<Paye> getPayes() {
		return this.payes;
	}

	public void setPayes(Set<Paye> payes) {
		this.payes = payes;
	}

}