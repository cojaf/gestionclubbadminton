package hiber;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Matchs entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "matchs", catalog = "gestion")
public class Matchs implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMatch;
	private Rencontre rencontre;
	private String typeMatch;
	private String score;
	private Set<Joue> joues = new HashSet<Joue>(0);
	private Set<JoueUn> joueUns = new HashSet<JoueUn>(0);

	// Constructors

	/** default constructor */
	public Matchs() {
	}

	/** minimal constructor */
	public Matchs(Integer idMatch, Rencontre rencontre, String typeMatch,
			String score) {
		this.idMatch = idMatch;
		this.rencontre = rencontre;
		this.typeMatch = typeMatch;
		this.score = score;
	}

	/** full constructor */
	public Matchs(Integer idMatch, Rencontre rencontre, String typeMatch,
			String score, Set<Joue> joues, Set<JoueUn> joueUns) {
		this.idMatch = idMatch;
		this.rencontre = rencontre;
		this.typeMatch = typeMatch;
		this.score = score;
		this.joues = joues;
		this.joueUns = joueUns;
	}

	// Property accessors
	@Id
	@Column(name = "id_Match", unique = true, nullable = false)
	public Integer getIdMatch() {
		return this.idMatch;
	}

	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Rencontre", nullable = false)
	public Rencontre getRencontre() {
		return this.rencontre;
	}

	public void setRencontre(Rencontre rencontre) {
		this.rencontre = rencontre;
	}

	@Column(name = "type_Match", nullable = false, length = 50)
	public String getTypeMatch() {
		return this.typeMatch;
	}

	public void setTypeMatch(String typeMatch) {
		this.typeMatch = typeMatch;
	}

	@Column(name = "score", nullable = false, length = 15)
	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matchs")
	public Set<Joue> getJoues() {
		return this.joues;
	}

	public void setJoues(Set<Joue> joues) {
		this.joues = joues;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "matchs")
	public Set<JoueUn> getJoueUns() {
		return this.joueUns;
	}

	public void setJoueUns(Set<JoueUn> joueUns) {
		this.joueUns = joueUns;
	}

}