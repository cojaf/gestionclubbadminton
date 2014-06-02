package hiber;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EstDonne entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "est_donne", catalog = "gestion")
public class EstDonne implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EstDonneId id;
	private Entrainement entrainement;
	private Salle salle;

	// Constructors

	/** default constructor */
	public EstDonne() {
	}

	/** full constructor */
	public EstDonne(EstDonneId id, Entrainement entrainement, Salle salle) {
		this.id = id;
		this.entrainement = entrainement;
		this.salle = salle;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idSalle", column = @Column(name = "id_Salle", nullable = false)),
			@AttributeOverride(name = "idEntrainement", column = @Column(name = "id_Entrainement", nullable = false)) })
	public EstDonneId getId() {
		return this.id;
	}

	public void setId(EstDonneId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Entrainement", nullable = false, insertable = false, updatable = false)
	public Entrainement getEntrainement() {
		return this.entrainement;
	}

	public void setEntrainement(Entrainement entrainement) {
		this.entrainement = entrainement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Salle", nullable = false, insertable = false, updatable = false)
	public Salle getSalle() {
		return this.salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

}