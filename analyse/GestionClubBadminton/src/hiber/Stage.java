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
 * Stage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "stage", catalog = "gestion", uniqueConstraints = @UniqueConstraint(columnNames = "id_Operation"))
public class Stage implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idStage;
	private Operation operation;
	private String nomStage;
	private String descriptif;
	private Date date;
	private Date heureDebut;
	private Date heureFin;
	private Integer prix;
	private Set<Donne> donnes = new HashSet<Donne>(0);

	// Constructors

	/** default constructor */
	public Stage() {
	}

	/** minimal constructor */
	public Stage(Integer idStage, Operation operation, String nomStage,
			String descriptif, Date date, Date heureDebut, Date heureFin,
			Integer prix) {
		this.idStage = idStage;
		this.operation = operation;
		this.nomStage = nomStage;
		this.descriptif = descriptif;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.prix = prix;
	}

	/** full constructor */
	public Stage(Integer idStage, Operation operation, String nomStage,
			String descriptif, Date date, Date heureDebut, Date heureFin,
			Integer prix, Set<Donne> donnes) {
		this.idStage = idStage;
		this.operation = operation;
		this.nomStage = nomStage;
		this.descriptif = descriptif;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.prix = prix;
		this.donnes = donnes;
	}

	// Property accessors
	@Id
	@Column(name = "id_stage", unique = true, nullable = false)
	public Integer getIdStage() {
		return this.idStage;
	}

	public void setIdStage(Integer idStage) {
		this.idStage = idStage;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Operation", unique = true, nullable = false)
	public Operation getOperation() {
		return this.operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	@Column(name = "nom_Stage", nullable = false, length = 50)
	public String getNomStage() {
		return this.nomStage;
	}

	public void setNomStage(String nomStage) {
		this.nomStage = nomStage;
	}

	@Column(name = "descriptif", nullable = false, length = 256)
	public String getDescriptif() {
		return this.descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "heure_Debut", nullable = false, length = 10)
	public Date getHeureDebut() {
		return this.heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "heure_Fin", nullable = false, length = 10)
	public Date getHeureFin() {
		return this.heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	@Column(name = "prix", nullable = false)
	public Integer getPrix() {
		return this.prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stage")
	public Set<Donne> getDonnes() {
		return this.donnes;
	}

	public void setDonnes(Set<Donne> donnes) {
		this.donnes = donnes;
	}

}