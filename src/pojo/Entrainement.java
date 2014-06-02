package pojo;

import java.util.Date;


class Entrainement {
  private Integer id_Entrainement;
  private String jour = null;
  private Date heure_Debut = null;
  private Date heure_Fin = null;
  private Salle salles;
  private Entraineur entraineurs;
  public Entrainement(){

  }
  public Integer getId_Entrainement() {
	  return id_Entrainement;
  }
  public String getJour() {
	  return jour;
  }
  public Date getHeure_Debut() {
	  return heure_Debut;
  }
  public Date getHeure_Fin() {
	  return heure_Fin;
  }
  public Salle getSalles() {
	  return salles;
  }
  public Entraineur getEntraineurs() {
	  return entraineurs;
  }
  public void setId_Entrainement(Integer id_Entrainement) {
	  this.id_Entrainement = id_Entrainement;
  }
  public void setJour(String jour) {
	  this.jour = jour;
  }
  public void setHeure_Debut(Date heure_Debut) {
	  this.heure_Debut = heure_Debut;
  }
  public void setHeure_Fin(Date heure_Fin) {
	  this.heure_Fin = heure_Fin;
  }
  public void setSalles(Salle salles) {
	  this.salles = salles;
  }
  public void setEntraineurs(Entraineur entraineurs) {
	  this.entraineurs = entraineurs;
  }


}
