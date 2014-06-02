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
 * Paye entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "paye", catalog = "gestion")
public class Paye implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PayeId id;
	private Membre membre;
	private Cotisation cotisation;
	private Date saison;

	// Constructors

	/** default constructor */
	public Paye() {
	}

	/** full constructor */
	public Paye(PayeId id, Membre membre, Cotisation cotisation, Date saison) {
		this.id = id;
		this.membre = membre;
		this.cotisation = cotisation;
		this.saison = saison;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idCotisation", column = @Column(name = "id_Cotisation", nullable = false)),
			@AttributeOverride(name = "idMembre", column = @Column(name = "id_Membre", nullable = false)) })
	public PayeId getId() {
		return this.id;
	}

	public void setId(PayeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Membre", nullable = false, insertable = false, updatable = false)
	public Membre getMembre() {
		return this.membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Cotisation", nullable = false, insertable = false, updatable = false)
	public Cotisation getCotisation() {
		return this.cotisation;
	}

	public void setCotisation(Cotisation cotisation) {
		this.cotisation = cotisation;
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