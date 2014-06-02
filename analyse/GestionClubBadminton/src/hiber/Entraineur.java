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
import javax.persistence.UniqueConstraint;

/**
 * Entraineur entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entraineur", catalog = "gestion", uniqueConstraints = @UniqueConstraint(columnNames = "id_Personne"))
public class Entraineur implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEntraineur;
	private Personne personne;
	private String diplome;
	private Set<Operation> operations = new HashSet<Operation>(0);
	private Set<Supervise> supervises = new HashSet<Supervise>(0);
	private Set<Donne> donnes = new HashSet<Donne>(0);

	// Constructors

	/** default constructor */
	public Entraineur() {
	}

	/** minimal constructor */
	public Entraineur(Integer idEntraineur, Personne personne, String diplome) {
		this.idEntraineur = idEntraineur;
		this.personne = personne;
		this.diplome = diplome;
	}

	/** full constructor */
	public Entraineur(Integer idEntraineur, Personne personne, String diplome,
			Set<Operation> operations, Set<Supervise> supervises,
			Set<Donne> donnes) {
		this.idEntraineur = idEntraineur;
		this.personne = personne;
		this.diplome = diplome;
		this.operations = operations;
		this.supervises = supervises;
		this.donnes = donnes;
	}

	// Property accessors
	@Id
	@Column(name = "id_Entraineur", unique = true, nullable = false)
	public Integer getIdEntraineur() {
		return this.idEntraineur;
	}

	public void setIdEntraineur(Integer idEntraineur) {
		this.idEntraineur = idEntraineur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Personne", unique = true, nullable = false)
	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Column(name = "diplome", nullable = false, length = 50)
	public String getDiplome() {
		return this.diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entraineur")
	public Set<Operation> getOperations() {
		return this.operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entraineur")
	public Set<Supervise> getSupervises() {
		return this.supervises;
	}

	public void setSupervises(Set<Supervise> supervises) {
		this.supervises = supervises;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "entraineur")
	public Set<Donne> getDonnes() {
		return this.donnes;
	}

	public void setDonnes(Set<Donne> donnes) {
		this.donnes = donnes;
	}

}