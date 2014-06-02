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
 * Supervise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "supervise", catalog = "gestion")
public class Supervise implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SuperviseId id;
	private Entrainement entrainement;
	private Entraineur entraineur;

	// Constructors

	/** default constructor */
	public Supervise() {
	}

	/** full constructor */
	public Supervise(SuperviseId id, Entrainement entrainement,
			Entraineur entraineur) {
		this.id = id;
		this.entrainement = entrainement;
		this.entraineur = entraineur;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idEntraineur", column = @Column(name = "id_Entraineur", nullable = false)),
			@AttributeOverride(name = "idEntrainement", column = @Column(name = "id_Entrainement", nullable = false)) })
	public SuperviseId getId() {
		return this.id;
	}

	public void setId(SuperviseId id) {
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
	@JoinColumn(name = "id_Entraineur", nullable = false, insertable = false, updatable = false)
	public Entraineur getEntraineur() {
		return this.entraineur;
	}

	public void setEntraineur(Entraineur entraineur) {
		this.entraineur = entraineur;
	}

}