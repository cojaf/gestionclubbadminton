package pojo;

import java.util.Date;



class Comite {
  private Integer id_Comite = null;
  private String nom_Comite = null;
  private Date date_Debut = null;
  private Date date_Fin = null;
  private Membre membre;
  
  public Comite(){
	  
  }
  public Integer getId_Comite() {
	  return id_Comite;
  }
  public String getNom_Comite() {
	  return nom_Comite;
  }
  public Date getDate_Debut() {
	  return date_Debut;
  }
  public Date getDate_Fin() {
	  return date_Fin;
  }
  public Membre getMembre() {
	  return membre;
  }
  public void setId_Comite(Integer id_Comite) {
	  this.id_Comite = id_Comite;
  }
  public void setNom_Comite(String nom_Comite) {
	  this.nom_Comite = nom_Comite;
  }
  public void setDate_Debut(Date date_Debut) {
	  this.date_Debut = date_Debut;
  }
  public void setDate_Fin(Date date_Fin) {
	  this.date_Fin = date_Fin;
  }
  public void setMembre(Membre membre) {
	  this.membre = membre;
  }
  
  

}
