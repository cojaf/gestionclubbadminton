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

/**
 * Operation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "operation", catalog = "gestion")
public class Operation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idOperation;
	private Typeoperation typeoperation;
	private Entraineur entraineur;
	private String nomOperation;
	private String description;
	private Date date;
	private String montant;
	private Set<Cotisation> cotisations = new HashSet<Cotisation>(0);
	private Set<Stage> stages = new HashSet<Stage>(0);

	// Constructors

	/** default constructor */
	public Operation() {
	}

	/** minimal constructor */
	public Operation(Integer idOperation, Typeoperation typeoperation,
			String nomOperation, String description, Date date, String montant) {
		this.idOperation = idOperation;
		this.typeoperation = typeoperation;
		this.nomOperation = nomOperation;
		this.description = description;
		this.date = date;
		this.montant = montant;
	}

	/** full constructor */
	public Operation(Integer idOperation, Typeoperation typeoperation,
			Entraineur entraineur, String nomOperation, String description,
			Date date, String montant, Set<Cotisation> cotisations,
			Set<Stage> stages) {
		this.idOperation = idOperation;
		this.typeoperation = typeoperation;
		this.entraineur = entraineur;
		this.nomOperation = nomOperation;
		this.description = description;
		this.date = date;
		this.montant = montant;
		this.cotisations = cotisations;
		this.stages = stages;
	}

	// Property accessors
	@Id
	@Column(name = "id_Operation", unique = true, nullable = false)
	public Integer getIdOperation() {
		return this.idOperation;
	}

	public void setIdOperation(Integer idOperation) {
		this.idOperation = idOperation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Type", nullable = false)
	public Typeoperation getTypeoperation() {
		return this.typeoperation;
	}

	public void setTypeoperation(Typeoperation typeoperation) {
		this.typeoperation = typeoperation;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Entraineur")
	public Entraineur getEntraineur() {
		return this.entraineur;
	}

	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}

	@Column(name = "nom_Operation", nullable = false, length = 50)
	public String getNomOperation() {
		return this.nomOperation;
	}

	public void setNomOperation(String nomOperation) {
		this.nomOperation = nomOperation;
	}

	@Column(name = "description", nullable = false, length = 1024)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "montant", nullable = false, length = 1)
	public String getMontant() {
		return this.montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "operation")
	public Set<Cotisation> getCotisations() {
		return this.cotisations;
	}

	public void setCotisations(Set<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "operation")
	public Set<Stage> getStages() {
		return this.stages;
	}

	public void setStages(Set<Stage> stages) {
		this.stages = stages;
	}

}