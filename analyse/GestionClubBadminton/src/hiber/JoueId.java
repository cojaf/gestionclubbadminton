package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * JoueId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class JoueId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMatch;
	private Integer idCompetiteur;

	// Constructors

	/** default constructor */
	public JoueId() {
	}

	/** full constructor */
	public JoueId(Integer idMatch, Integer idCompetiteur) {
		this.idMatch = idMatch;
		this.idCompetiteur = idCompetiteur;
	}

	// Property accessors

	@Column(name = "id_Match", nullable = false)
	public Integer getIdMatch() {
		return this.idMatch;
	}

	public void setIdMatch(Integer idMatch) {
		this.idMatch = idMatch;
	}

	@Column(name = "id_Competiteur", nullable = false)
	public Integer getIdCompetiteur() {
		return this.idCompetiteur;
	}

	public void setIdCompetiteur(Integer idCompetiteur) {
		this.idCompetiteur = idCompetiteur;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof JoueId))
			return false;
		JoueId castOther = (JoueId) other;

		return ((this.getIdMatch() == castOther.getIdMatch()) || (this
				.getIdMatch() != null && castOther.getIdMatch() != null && this
				.getIdMatch().equals(castOther.getIdMatch())))
				&& ((this.getIdCompetiteur() == castOther.getIdCompetiteur()) || (this
						.getIdCompetiteur() != null
						&& castOther.getIdCompetiteur() != null && this
						.getIdCompetiteur()
						.equals(castOther.getIdCompetiteur())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdMatch() == null ? 0 : this.getIdMatch().hashCode());
		result = 37
				* result
				+ (getIdCompetiteur() == null ? 0 : this.getIdCompetiteur()
						.hashCode());
		return result;
	}

}