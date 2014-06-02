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
 * Donne entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "donne", catalog = "gestion")
public class Donne implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DonneId id;
	private Stage stage;
	private Entraineur entraineur;

	// Constructors

	/** default constructor */
	public Donne() {
	}

	/** full constructor */
	public Donne(DonneId id, Stage stage, Entraineur entraineur) {
		this.id = id;
		this.stage = stage;
		this.entraineur = entraineur;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idStage", column = @Column(name = "id_stage", nullable = false)),
			@AttributeOverride(name = "idEntraineur", column = @Column(name = "id_Entraineur", nullable = false)) })
	public DonneId getId() {
		return this.id;
	}

	public void setId(DonneId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_stage", nullable = false, insertable = false, updatable = false)
	public Stage getStage() {
		return this.stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
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