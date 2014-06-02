package hiber;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Obtient entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "obtient", catalog = "gestion")
public class Obtient implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ObtientId id;
	private Classement classement;
	private Competiteur competiteur;
	private Date date;

	// Constructors

	/** default constructor */
	public Obtient() {
	}

	/** full constructor */
	public Obtient(ObtientId id, Classement classement,
			Competiteur competiteur, Date date) {
		this.id = id;
		this.classement = classement;
		this.competiteur = competiteur;
		this.date = date;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCompetiteur", column = @Column(name = "id_Competiteur", nullable = false)),
			@AttributeOverride(name = "idClassement", column = @Column(name = "id_Classement", nullable = false)) })
	public ObtientId getId() {
		return this.id;
	}

	public void setId(ObtientId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Classement", nullable = false, insertable = false, updatable = false)
	public Classement getClassement() {
		return this.classement;
	}

	public void setClassement(Classement classement) {
		this.classement = classement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Competiteur", nullable = false, insertable = false, updatable = false)
	public Competiteur getCompetiteur() {
		return this.competiteur;
	}

	public void setCompetiteur(Competiteur competiteur) {
		this.competiteur = competiteur;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}