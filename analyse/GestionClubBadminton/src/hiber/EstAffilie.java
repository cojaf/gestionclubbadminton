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

/**
 * EstAffilie entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "est_affilie", catalog = "gestion")
public class EstAffilie implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCompetiteur;
	private Membre membre;
	private Competiteur competiteur;
	private Date saison;

	// Constructors

	/** default constructor */
	public EstAffilie() {
	}

	/** full constructor */
	public EstAffilie(Integer idCompetiteur, Membre membre,
			Competiteur competiteur, Date saison) {
		this.idCompetiteur = idCompetiteur;
		this.membre = membre;
		this.competiteur = competiteur;
		this.saison = saison;
	}

	// Property accessors
	@Id
	@Column(name = "id_Competiteur", unique = true, nullable = false)
	public Integer getIdCompetiteur() {
		return this.idCompetiteur;
	}

	public void setIdCompetiteur(Integer idCompetiteur) {
		this.idCompetiteur = idCompetiteur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Membre", nullable = false)
	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Competiteur", unique = true, nullable = false, insertable = false, updatable = false)
	public Competiteur getCompetiteur() {
		return this.competiteur;
	}

	public void setCompetiteur(Competiteur competiteur) {
		this.competiteur = competiteur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "saison", nullable = false, length = 10)
	public Date getSaison() {
		return this.saison;
	}

	public void setSaison(Date saison) {
		this.saison = saison;
	}

}