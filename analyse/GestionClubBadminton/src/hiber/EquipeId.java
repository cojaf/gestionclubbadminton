package hiber;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EquipeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class EquipeId implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idEquipe;
	private String nomEquipe;
	private Integer idRencontre;
	private Integer idClub;

	// Constructors

	/** default constructor */
	public EquipeId() {
	}

	/** full constructor */
	public EquipeId(Integer idEquipe, String nomEquipe, Integer idRencontre,
			Integer idClub) {
		this.idEquipe = idEquipe;
		this.nomEquipe = nomEquipe;
		this.idRencontre = idRencontre;
		this.idClub = idClub;
	}

	// Property accessors

	@Column(name = "id_Equipe", nullable = false)
	public Integer getIdEquipe() {
		return this.idEquipe;
	}

	public void setIdEquipe(Integer idEquipe) {
		this.idEquipe = idEquipe;
	}

	@Column(name = "nom_Equipe", nullable = false, length = 50)
	public String getNomEquipe() {
		return this.nomEquipe;
	}

	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}

	@Column(name = "id_Rencontre", nullable = false)
	public Integer getIdRencontre() {
		return this.idRencontre;
	}

	public void setIdRencontre(Integer idRencontre) {
		this.idRencontre = idRencontre;
	}

	@Column(name = "id_Club", nullable = false)
	public Integer getIdClub() {
		return this.idClub;
	}

	public void setIdClub(Integer idClub) {
		this.idClub = idClub;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EquipeId))
			return false;
		EquipeId castOther = (EquipeId) other;

		return ((this.getIdEquipe() == castOther.getIdEquipe()) || (this
				.getIdEquipe() != null && castOther.getIdEquipe() != null && this
				.getIdEquipe().equals(castOther.getIdEquipe())))
				&& ((this.getNomEquipe() == castOther.getNomEquipe()) || (this
						.getNomEquipe() != null
						&& castOther.getNomEquipe() != null && this
						.getNomEquipe().equals(castOther.getNomEquipe())))
				&& ((this.getIdRencontre() == castOther.getIdRencontre()) || (this
						.getIdRencontre() != null
						&& castOther.getIdRencontre() != null && this
						.getIdRencontre().equals(castOther.getIdRencontre())))
				&& ((this.getIdClub() == castOther.getIdClub()) || (this
						.getIdClub() != null && castOther.getIdClub() != null && this
						.getIdClub().equals(castOther.getIdClub())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdEquipe() == null ? 0 : this.getIdEquipe().hashCode());
		result = 37 * result
				+ (getNomEquipe() == null ? 0 : this.getNomEquipe().hashCode());
		result = 37
				* result
				+ (getIdRencontre() == null ? 0 : this.getIdRencontre()
						.hashCode());
		result = 37 * result
				+ (getIdClub() == null ? 0 : this.getIdClub().hashCode());
		return result;
	}

}