package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PayeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class PayeId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCotisation;
	private Integer idMembre;

	// Constructors

	/** default constructor */
	public PayeId() {
	}

	/** full constructor */
	public PayeId(Integer idCotisation, Integer idMembre) {
		this.idCotisation = idCotisation;
		this.idMembre = idMembre;
	}

	// Property accessors

	@Column(name = "id_Cotisation", nullable = false)
	public Integer getIdCotisation() {
		return this.idCotisation;
	}

	public void setIdCotisation(Integer idCotisation) {
		this.idCotisation = idCotisation;
	}

	@Column(name = "id_Membre", nullable = false)
	public Integer getIdMembre() {
		return this.idMembre;
	}

	public void setIdMembre(Integer idMembre) {
		this.idMembre = idMembre;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PayeId))
			return false;
		PayeId castOther = (PayeId) other;

		return ((this.getIdCotisation() == castOther.getIdCotisation()) || (this
				.getIdCotisation() != null
				&& castOther.getIdCotisation() != null && this
				.getIdCotisation().equals(castOther.getIdCotisation())))
				&& ((this.getIdMembre() == castOther.getIdMembre()) || (this
						.getIdMembre() != null
						&& castOther.getIdMembre() != null && this
						.getIdMembre().equals(castOther.getIdMembre())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getIdCotisation() == null ? 0 : this.getIdCotisation()
						.hashCode());
		result = 37 * result
				+ (getIdMembre() == null ? 0 : this.getIdMembre().hashCode());
		return result;
	}

}