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
 * Club entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "club", catalog = "gestion")
public class Club implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idClub;
	private String nomClub;
	private Set<Equipe> equipes = new HashSet<Equipe>(0);

	// Constructors

	/** default constructor */
	public Club() {
	}

	/** minimal constructor */
	public Club(Integer idClub, String nomClub) {
		this.idClub = idClub;
		this.nomClub = nomClub;
	}

	/** full constructor */
	public Club(Integer idClub, String nomClub, Set<Equipe> equipes) {
		this.idClub = idClub;
		this.nomClub = nomClub;
		this.equipes = equipes;
	}

	// Property accessors
	@Id
	@Column(name = "id_Club", unique = true, nullable = false)
	public Integer getIdClub() {
		return this.idClub;
	}

	public void setIdClub(Integer idClub) {
		this.idClub = idClub;
	}

	@Column(name = "nom_Club", nullable = false, length = 50)
	public String getNomClub() {
		return this.nomClub;
	}

	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "club")
	public Set<Equipe> getEquipes() {
		return this.equipes;
	}

	public void setEquipes(Set<Equipe> equipes) {
		this.equipes = equipes;
	}

}