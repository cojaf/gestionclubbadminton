package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EstDonneId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class EstDonneId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idSalle;
	private Integer idEntrainement;

	// Constructors

	/** default constructor */
	public EstDonneId() {
	}

	/** full constructor */
	public EstDonneId(Integer idSalle, Integer idEntrainement) {
		this.idSalle = idSalle;
		this.idEntrainement = idEntrainement;
	}

	// Property accessors

	@Column(name = "id_Salle", nullable = false)
	public Integer getIdSalle() {
		return this.idSalle;
	}

	public void setIdSalle(Integer idSalle) {
		this.idSalle = idSalle;
	}

	@Column(name = "id_Entrainement", nullable = false)
	public Integer getIdEntrainement() {
		return this.idEntrainement;
	}

	public void setIdEntrainement(Integer idEntrainement) {
		this.idEntrainement = idEntrainement;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstDonneId))
			return false;
		EstDonneId castOther = (EstDonneId) other;

		return ((this.getIdSalle() == castOther.getIdSalle()) || (this
				.getIdSalle() != null && castOther.getIdSalle() != null && this
				.getIdSalle().equals(castOther.getIdSalle())))
				&& ((this.getIdEntrainement() == castOther.getIdEntrainement()) || (this
						.getIdEntrainement() != null
						&& castOther.getIdEntrainement() != null && this
						.getIdEntrainement().equals(
								castOther.getIdEntrainement())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdSalle() == null ? 0 : this.getIdSalle().hashCode());
		result = 37
				* result
				+ (getIdEntrainement() == null ? 0 : this.getIdEntrainement()
						.hashCode());
		return result;
	}

}