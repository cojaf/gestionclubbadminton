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
 * Classement entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "classement", catalog = "gestion")
public class Classement implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idClassement;
	private String discipline;
	private String categorie;
	private Set<PossedeUn> possedeUns = new HashSet<PossedeUn>(0);
	private Set<Obtient> obtients = new HashSet<Obtient>(0);

	// Constructors

	/** default constructor */
	public Classement() {
	}

	/** minimal constructor */
	public Classement(Integer idClassement, String discipline, String categorie) {
		this.idClassement = idClassement;
		this.discipline = discipline;
		this.categorie = categorie;
	}

	/** full constructor */
	public Classement(Integer idClassement, String discipline,
			String categorie, Set<PossedeUn> possedeUns, Set<Obtient> obtients) {
		this.idClassement = idClassement;
		this.discipline = discipline;
		this.categorie = categorie;
		this.possedeUns = possedeUns;
		this.obtients = obtients;
	}

	// Property accessors
	@Id
	@Column(name = "id_Classement", unique = true, nullable = false)
	public Integer getIdClassement() {
		return this.idClassement;
	}

	public void setIdClassement(Integer idClassement) {
		this.idClassement = idClassement;
	}

	@Column(name = "discipline", nullable = false, length = 50)
	public String getDiscipline() {
		return this.discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	@Column(name = "categorie", nullable = false, length = 2)
	public String getCategorie() {
		return this.categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classement")
	public Set<PossedeUn> getPossedeUns() {
		return this.possedeUns;
	}

	public void setPossedeUns(Set<PossedeUn> possedeUns) {
		this.possedeUns = possedeUns;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classement")
	public Set<Obtient> getObtients() {
		return this.obtients;
	}

	public void setObtients(Set<Obtient> obtients) {
		this.obtients = obtients;
	}

}