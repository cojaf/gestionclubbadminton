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
 * JoueUn entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "joue_un", catalog = "gestion")
public class JoueUn implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JoueUnId id;
	private Adversaire adversaire;
	private Matchs matchs;

	// Constructors

	/** default constructor */
	public JoueUn() {
	}

	/** full constructor */
	public JoueUn(JoueUnId id, Adversaire adversaire, Matchs matchs) {
		this.id = id;
		this.adversaire = adversaire;
		this.matchs = matchs;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idMatch", column = @Column(name = "id_Match", nullable = false)),
			@AttributeOverride(name = "idPersonne", column = @Column(name = "id_Personne", nullable = false)) })
	public JoueUnId getId() {
		return this.id;
	}

	public void setId(JoueUnId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Personne", nullable = false, insertable = false, updatable = false)
	public Adversaire getAdversaire() {
		return this.adversaire;
	}

	public void setAdversaire(Adversaire adversaire) {
		this.adversaire = adversaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Match", nullable = false, insertable = false, updatable = false)
	public Matchs getMatchs() {
		return this.matchs;
	}

	public void setMatchs(Matchs matchs) {
		this.matchs = matchs;
	}

}