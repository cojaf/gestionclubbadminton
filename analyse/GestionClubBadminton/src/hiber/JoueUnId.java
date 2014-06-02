package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * JoueUnId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class JoueUnId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMatch;
	private Integer idPersonne;

	// Constructors

	/** default constructor */
	public JoueUnId() {
	}

	/** full constructor */
	public JoueUnId(Integer idMatch, Integer idPersonne) {
		this.idMatch = idMatch;
		this.idPersonne = idPersonne;
	}

	// Property accessors

	@Column(name = "id_Match", nullable = false)
	public Integer getIdMatch() {
		return this.idMatch;
	}

	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}

	@Column(name = "id_Personne", nullable = false)
	public Integer getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JoueUnId))
			return false;
		JoueUnId castOther = (JoueUnId) other;

		return ((this.getIdMatch() == castOther.getIdMatch()) || (this
				.getIdMatch() != null && castOther.getIdMatch() != null && this
				.getIdMatch().equals(castOther.getIdMatch())))
				&& ((this.getIdPersonne() == castOther.getIdPersonne()) || (this
						.getIdPersonne() != null
						&& castOther.getIdPersonne() != null && this
						.getIdPersonne().equals(castOther.getIdPersonne())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdMatch() == null ? 0 : this.getIdMatch().hashCode());
		result = 37
				* result
				+ (getIdPersonne() == null ? 0 : this.getIdPersonne()
						.hashCode());
		return result;
	}

}