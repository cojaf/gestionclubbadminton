package pojo;
class Equipe {
  private Integer id_Equipe = null;
  private String nom_Equipe = null;
  private Club club;
  private Rencontre rencontre;
  public Equipe(){}
  public Integer getId_Equipe() {
	  return id_Equipe;
  }
  public String getNom_Equipe() {
	  return nom_Equipe;
  }
  public Club getClub() {
	  return club;
  }
  public Rencontre getRencontre() {
	  return rencontre;
  }
  public void setId_Equipe(Integer id_Equipe) {
	  this.id_Equipe = id_Equipe;
  }
  public void setNom_Equipe(String nom_Equipe) {
	  this.nom_Equipe = nom_Equipe;
  }
  public void setClub(Club club) {
	  this.club = club;
  }
  public void setRencontre(Rencontre rencontre) {
	  this.rencontre = rencontre;
  }

}
