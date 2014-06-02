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
 * Equipe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "equipe", catalog = "gestion")
public class Equipe implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EquipeId id;
	private Rencontre rencontre;
	private Club club;

	// Constructors

	/** default constructor */
	public Equipe() {
	}

	/** full constructor */
	public Equipe(EquipeId id, Rencontre rencontre, Club club) {
		this.id = id;
		this.rencontre = rencontre;
		this.club = club;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idEquipe", column = @Column(name = "id_Equipe", nullable = false)),
			@AttributeOverride(name = "nomEquipe", column = @Column(name = "nom_Equipe", nullable = false, length = 50)),
			@AttributeOverride(name = "idRencontre", column = @Column(name = "id_Rencontre", nullable = false)),
			@AttributeOverride(name = "idClub", column = @Column(name = "id_Club", nullable = false)) })
	public EquipeId getId() {
		return this.id;
	}

	public void setId(EquipeId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Rencontre", nullable = false, insertable = false, updatable = false)
	public Rencontre getRencontre() {
		return this.rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Club", nullable = false, insertable = false, updatable = false)
	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

}