package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DonneId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class DonneId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idStage;
	private Integer idEntraineur;

	// Constructors

	/** default constructor */
	public DonneId() {
	}

	/** full constructor */
	public DonneId(Integer idStage, Integer idEntraineur) {
		this.idStage = idStage;
		this.idEntraineur = idEntraineur;
	}

	// Property accessors

	@Column(name = "id_stage", nullable = false)
	public Integer getIdStage() {
		return this.idStage;
	}

	public void setIdStage(Integer idStage) {
		this.idStage = idStage;
	}

	@Column(name = "id_Entraineur", nullable = false)
	public Integer getIdEntraineur() {
		return this.idEntraineur;
	}

	public void setIdEntraineur(Integer idEntraineur) {
		this.idEntraineur = idEntraineur;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DonneId))
			return false;
		DonneId castOther = (DonneId) other;

		return ((this.getIdStage() == castOther.getIdStage()) || (this
				.getIdStage() != null && castOther.getIdStage() != null && this
				.getIdStage().equals(castOther.getIdStage())))
				&& ((this.getIdEntraineur() == castOther.getIdEntraineur()) || (this
						.getIdEntraineur() != null
						&& castOther.getIdEntraineur() != null && this
						.getIdEntraineur().equals(castOther.getIdEntraineur())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdStage() == null ? 0 : this.getIdStage().hashCode());
		result = 37
				* result
				+ (getIdEntraineur() == null ? 0 : this.getIdEntraineur()
						.hashCode());
		return result;
	}

}