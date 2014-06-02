package hiber;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Competiteur entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "competiteur", catalog = "gestion")
public class Competiteur implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCompetiteur;
	private String numeroLigue;
	private Set<Joue> joues = new HashSet<Joue>(0);
	private Set<Obtient> obtients = new HashSet<Obtient>(0);
	private Set<EstAffilie> estAffilies = new HashSet<EstAffilie>(0);

	// Constructors

	/** default constructor */
	public Competiteur() {
	}

	/** minimal constructor */
	public Competiteur(Integer idCompetiteur, String numeroLigue) {
		this.idCompetiteur = idCompetiteur;
		this.numeroLigue = numeroLigue;
	}

	/** full constructor */
	public Competiteur(Integer idCompetiteur, String numeroLigue,
			Set<Joue> joues, Set<Obtient> obtients, Set<EstAffilie> estAffilies) {
		this.idCompetiteur = idCompetiteur;
		this.numeroLigue = numeroLigue;
		this.joues = joues;
		this.obtients = obtients;
		this.estAffilies = estAffilies;
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

	@Column(name = "numero_Ligue", nullable = false, length = 9)
	public String getNumeroLigue() {
		return this.numeroLigue;
	}

	public void setNumeroLigue(String numeroLigue) {
		this.numeroLigue = numeroLigue;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "competiteur")
	public Set<Joue> getJoues() {
		return this.joues;
	}

	public void setJoues(Set<Joue> joues) {
		this.joues = joues;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "competiteur")
	public Set<Obtient> getObtients() {
		return this.obtients;
	}

	public void setObtients(Set<Obtient> obtients) {
		this.obtients = obtients;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "competiteur")
	public Set<EstAffilie> getEstAffilies() {
		return this.estAffilies;
	}

	public void setEstAffilies(Set<EstAffilie> estAffilies) {
		this.estAffilies = estAffilies;
	}

}