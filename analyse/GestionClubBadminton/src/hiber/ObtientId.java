package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ObtientId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ObtientId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCompetiteur;
	private Integer idClassement;

	// Constructors

	/** default constructor */
	public ObtientId() {
	}

	/** full constructor */
	public ObtientId(Integer idCompetiteur, Integer idClassement) {
		this.idCompetiteur = idCompetiteur;
		this.idClassement = idClassement;
	}

	// Property accessors

	@Column(name = "id_Competiteur", nullable = false)
	public Integer getIdCompetiteur() {
		return this.idCompetiteur;
	}

	public void setIdCompetiteur(Integer idCompetiteur) {
		this.idCompetiteur = idCompetiteur;
	}

	@Column(name = "id_Classement", nullable = false)
	public Integer getIdClassement() {
		return this.idClassement;
	}

	public void setIdClassement(Integer idClassement) {
		this.idClassement = idClassement;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ObtientId))
			return false;
		ObtientId castOther = (ObtientId) other;

		return ((this.getIdCompetiteur() == castOther.getIdCompetiteur()) || (this
				.getIdCompetiteur() != null
				&& castOther.getIdCompetiteur() != null && this
				.getIdCompetiteur().equals(castOther.getIdCompetiteur())))
				&& ((this.getIdClassement() == castOther.getIdClassement()) || (this
						.getIdClassement() != null
						&& castOther.getIdClassement() != null && this
						.getIdClassement().equals(castOther.getIdClassement())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdCompetiteur() == null ? 0 : this.getIdCompetiteur()
						.hashCode());
		result = 37
				* result
				+ (getIdClassement() == null ? 0 : this.getIdClassement()
						.hashCode());
		return result;
	}

}