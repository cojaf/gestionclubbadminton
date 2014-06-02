package pojo;

import java.util.List;

class Competiteur {
  private Integer id_Competiteur = null;
  private String numero_Ligue = null;
  private Membre membre;
  private List <Classement> classements;
  private Match matchs;
  public Competiteur(){
	  
  }
  public Integer getId_Competiteur() {
	  return id_Competiteur;
  }
  public String getNumero_Ligue() {
	  return numero_Ligue;
  }
  public Membre getMembre() {
	  return membre;
  }
  public List<Classement> getClassements() {
	  return classements;
  }
  public Match getMatchs() {
	  return matchs;
  }
  public void setId_Competiteur(Integer id_Competiteur) {
	  this.id_Competiteur = id_Competiteur;
  }
  public void setNumero_Ligue(String numero_Ligue) {
	  this.numero_Ligue = numero_Ligue;
  }
  public void setMembre(Membre membre) {
	  this.membre = membre;
  }
  public void setClassements(List<Classement> classements) {
	  this.classements = classements;
  }
  public void setMatchs(Match matchs) {
	  this.matchs = matchs;
  }
  
}
