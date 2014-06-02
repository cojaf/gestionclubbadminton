package hiber;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Rencontre entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rencontre", catalog = "gestion")
public class Rencontre implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idRencontre;
	private Salle salle;
	private String typeRencontre;
	private Date dateRencontre;
	private String division;
	private String resultat;
	private String commentaires;
	private Set<Matchs> matchses = new HashSet<Matchs>(0);
	private Set<Equipe> equipes = new HashSet<Equipe>(0);

	// Constructors

	/** default constructor */
	public Rencontre() {
	}

	/** minimal constructor */
	public Rencontre(Integer idRencontre, Salle salle, String typeRencontre,
			Date dateRencontre, String division, String resultat,
			String commentaires) {
		this.idRencontre = idRencontre;
		this.salle = salle;
		this.typeRencontre = typeRencontre;
		this.dateRencontre = dateRencontre;
		this.division = division;
		this.resultat = resultat;
		this.commentaires = commentaires;
	}

	/** full constructor */
	public Rencontre(Integer idRencontre, Salle salle, String typeRencontre,
			Date dateRencontre, String division, String resultat,
			String commentaires, Set<Matchs> matchses, Set<Equipe> equipes) {
		this.idRencontre = idRencontre;
		this.salle = salle;
		this.typeRencontre = typeRencontre;
		this.dateRencontre = dateRencontre;
		this.division = division;
		this.resultat = resultat;
		this.commentaires = commentaires;
		this.matchses = matchses;
		this.equipes = equipes;
	}

	// Property accessors
	@Id
	@Column(name = "id_Rencontre", unique = true, nullable = false)
	public Integer getIdRencontre() {
		return this.idRencontre;
	}

	public void setIdRencontre(Integer idRencontre) {
		this.idRencontre = idRencontre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Salle", nullable = false)
	public Salle getSalle() {
		return this.salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	@Column(name = "type_Rencontre", nullable = false, length = 50)
	public String getTypeRencontre() {
		return this.typeRencontre;
	}

	public void setTypeRencontre(String typeRencontre) {
		this.typeRencontre = typeRencontre;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date_Rencontre", nullable = false, length = 10)
	public Date getDateRencontre() {
		return this.dateRencontre;
	}

	public void setDateRencontre(Date dateRencontre) {
		this.dateRencontre = dateRencontre;
	}

	@Column(name = "division", nullable = false, length = 50)
	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	@Column(name = "resultat", nullable = false, length = 50)
	public String getResultat() {
		return this.resultat;
	}

	public void setResultat(String resultat) {
		this.resultat = resultat;
	}

	@Column(name = "commentaires", nullable = false, length = 256)
	public String getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rencontre")
	public Set<Matchs> getMatchses() {
		return this.matchses;
	}

	public void setMatchses(Set<Matchs> matchses) {
		this.matchses = matchses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rencontre")
	public Set<Equipe> getEquipes() {
		return this.equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

}