package hiber;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entrainement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entrainement", catalog = "gestion")
public class Entrainement implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEntrainement;
	private String jour;
	private Date heureDebut;
	private Date heureFin;
	private Set<Supervise> supervises = new HashSet<Supervise>(0);
	private Set<EstDonne> estDonnes = new HashSet<EstDonne>(0);

	// Constructors

	/** default constructor */
	public Entrainement() {
	}

	/** minimal constructor */
	public Entrainement(Integer idEntrainement, String jour, Date heureDebut,
			Date heureFin) {
		this.idEntrainement = idEntrainement;
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
	}

	/** full constructor */
	public Entrainement(Integer idEntrainement, String jour, Date heureDebut,
			Date heureFin, Set<Supervise> supervises, Set<EstDonne> estDonnes) {
		this.idEntrainement = idEntrainement;
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.supervises = supervises;
		this.estDonnes = estDonnes;
	}

	// Property accessors
	@Id
	@Column(name = "id_Entrainement", unique = true, nullable = false)
	public Integer getIdEntrainement() {
		return this.idEntrainement;
	}

	public void setIdEntrainement(Integer idEntrainement) {
		this.idEntrainement = idEntrainement;
	}

	@Column(name = "jour", nullable = false, length = 8)
	public String getJour() {
		return this.jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entrainement")
	public Set<Supervise> getSupervises() {
		return this.supervises;
	}

	public void setSupervises(Set<Supervise> supervises) {
		this.supervises = supervises;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entrainement")
	public Set<EstDonne> getEstDonnes() {
		return this.estDonnes;
	}

	public void setEstDonnes(Set<EstDonne> estDonnes) {
		this.estDonnes = estDonnes;
	}

}