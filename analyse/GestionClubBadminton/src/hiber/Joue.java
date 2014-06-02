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
 * Joue entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "joue", catalog = "gestion")
public class Joue implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JoueId id;
	private Matchs matchs;
	private Competiteur competiteur;

	// Constructors

	/** default constructor */
	public Joue() {
	}

	/** full constructor */
	public Joue(JoueId id, Matchs matchs, Competiteur competiteur) {
		this.id = id;
		this.matchs = matchs;
		this.competiteur = competiteur;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idMatch", column = @Column(name = "id_Match", nullable = false)),
			@AttributeOverride(name = "idCompetiteur", column = @Column(name = "id_Competiteur", nullable = false)) })
	public JoueId getId() {
		return this.id;
	}

	public void setId(JoueId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Match", nullable = false, insertable = false, updatable = false)
	public Matchs getMatchs() {
		return this.matchs;
	}

	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Competiteur", nullable = false, insertable = false, updatable = false)
	public Competiteur getCompetiteur() {
		return this.competiteur;
	}

	public void setCompetiteur(Competiteur competiteur) {
		this.competiteur = competiteur;
	}

}