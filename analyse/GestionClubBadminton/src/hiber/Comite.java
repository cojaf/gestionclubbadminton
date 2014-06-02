package hiber;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Comite entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comite", catalog = "gestion", uniqueConstraints = @UniqueConstraint(columnNames = "id_Membre"))
public class Comite implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idComite;
	private Membre membre;
	private String nomComite;
	private Date dateDebut;
	private Date dateFin;

	// Constructors

	/** default constructor */
	public Comite() {
	}

	/** full constructor */
	public Comite(Integer idComite, Membre membre, String nomComite,
			Date dateDebut, Date dateFin) {
		this.idComite = idComite;
		this.membre = membre;
		this.nomComite = nomComite;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	// Property accessors
	@Id
	@Column(name = "id_Comite", unique = true, nullable = false)
	public Integer getIdComite() {
		return this.idComite;
	}

	public void setIdComite(Integer idComite) {
		this.idComite = idComite;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Membre", unique = true, nullable = false)
	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@Column(name = "nom_Comite", nullable = false, length = 50)
	public String getNomComite() {
		return this.nomComite;
	}

	public void setNomComite(String nomComite) {
		this.nomComite = nomComite;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_Debut", nullable = false, length = 10)
	public Date getDateDebut() {
		return this.dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_Fin", nullable = false, length = 10)
	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

}