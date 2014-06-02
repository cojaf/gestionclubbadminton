package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SuperviseId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class SuperviseId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEntraineur;
	private Integer idEntrainement;

	// Constructors

	/** default constructor */
	public SuperviseId() {
	}

	/** full constructor */
	public SuperviseId(Integer idEntraineur, Integer idEntrainement) {
		this.idEntraineur = idEntraineur;
		this.idEntrainement = idEntrainement;
	}

	// Property accessors

	@Column(name = "id_Entraineur", nullable = false)
	public Integer getIdEntraineur() {
		return this.idEntraineur;
	}

	public void setIdEntraineur(Integer idEntraineur) {
		this.idEntraineur = idEntraineur;
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
		if (!(other instanceof SuperviseId))
			return false;
		SuperviseId castOther = (SuperviseId) other;

		return ((this.getIdEntraineur() == castOther.getIdEntraineur()) || (this
				.getIdEntraineur() != null
				&& castOther.getIdEntraineur() != null && this
				.getIdEntraineur().equals(castOther.getIdEntraineur())))
				&& ((this.getIdEntrainement() == castOther.getIdEntrainement()) || (this
						.getIdEntrainement() != null
						&& castOther.getIdEntrainement() != null && this
						.getIdEntrainement().equals(
								castOther.getIdEntrainement())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdEntraineur() == null ? 0 : this.getIdEntraineur()
						.hashCode());
		result = 37
				* result
				+ (getIdEntrainement() == null ? 0 : this.getIdEntrainement()
						.hashCode());
		return result;
	}

}