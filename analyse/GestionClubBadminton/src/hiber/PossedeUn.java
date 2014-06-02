package hiber;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PossedeUn entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "possede_un", catalog = "gestion")
public class PossedeUn implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPersonne;
	private Adversaire adversaire;
	private Classement classement;
	private Date date;

	// Constructors

	/** default constructor */
	public PossedeUn() {
	}

	/** full constructor */
	public PossedeUn(Integer idPersonne, Adversaire adversaire,
			Classement classement, Date date) {
		this.idPersonne = idPersonne;
		this.adversaire = adversaire;
		this.classement = classement;
		this.date = date;
	}

	// Property accessors
	@Id
	@Column(name = "id_Personne", unique = true, nullable = false)
	public Integer getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Personne", unique = true, nullable = false, insertable = false, updatable = false)
	public Adversaire getAdversaire() {
		return this.adversaire;
	}

	public void setAdversaire(Adversaire adversaire) {
		this.adversaire = adversaire;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_Classement", nullable = false)
	public Classement getClassement() {
		return this.classement;
	}

	public void setClassement(Classement classement) {
		this.classement = classement;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}