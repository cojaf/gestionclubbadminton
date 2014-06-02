package pojo;
class Salle {
  private Integer id_Salle = null;
  private String nom_Salle = null;
  private String nom_Responsable = null;
  private Entrainement entrainements;
  private Rencontre sallesR;
  public Salle(){}
  public Integer getId_Salle() {
	  return id_Salle;
  }
  public String getNom_Salle() {
	  return nom_Salle;
  }
  public String getNom_Responsable() {
	  return nom_Responsable;
  }
  public Entrainement getEntrainements() {
	  return entrainements;
  }
  public Rencontre getSallesR() {
	  return sallesR;
  }
  public void setId_Salle(Integer id_Salle) {
	  this.id_Salle = id_Salle;
  }
  public void setNom_Salle(String nom_Salle) {
	  this.nom_Salle = nom_Salle;
  }
  public void setNom_Responsable(String nom_Responsable) {
	  this.nom_Responsable = nom_Responsable;
  }
  public void setEntrainements(Entrainement entrainements) {
	  this.entrainements = entrainements;
  }
  public void setSallesR(Rencontre sallesR) {
	  this.sallesR = sallesR;
  }

}
