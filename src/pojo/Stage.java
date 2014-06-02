package pojo;

import java.util.Date;


class Stage {
  private Integer id_Stage = null;
  private String nom_Stage = null;
  private String descriptif = null;
  private Date heure_Debut = null;
  private Date heure_Fin = null;
  private double prix = 0.0d;
  private Entraineur stages;
  private Operation operation;
  public Stage(){
	  
  }
  public Integer getId_Stage() {
	  return id_Stage;
  }
  public String getNom_Stage() {
	  return nom_Stage;
  }
  public String getDescriptif() {
	  return descriptif;
  }
  public Date getHeure_Debut() {
	  return heure_Debut;
  }
  public Date getHeure_Fin() {
	  return heure_Fin;
  }
  public double getPrix() {
	  return prix;
  }
  public Entraineur getStages() {
	  return stages;
  }
  public Operation getOperation() {
	  return operation;
  }
  public void setId_Stage(Integer id_Stage) {
	  this.id_Stage = id_Stage;
  }
  public void setNom_Stage(String nom_Stage) {
	  this.nom_Stage = nom_Stage;
  }
  public void setDescriptif(String descriptif) {
	  this.descriptif = descriptif;
  }
  public void setHeure_Debut(Date heure_Debut) {
	  this.heure_Debut = heure_Debut;
  }
  public void setHeure_Fin(Date heure_Fin) {
	  this.heure_Fin = heure_Fin;
  }
  public void setPrix(double prix) {
	  this.prix = prix;
  }
  public void setStages(Entraineur stages) {
	  this.stages = stages;
  }
  public void setOperation(Operation operation) {
	  this.operation = operation;
  }

}
