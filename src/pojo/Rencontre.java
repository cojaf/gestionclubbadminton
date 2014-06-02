package pojo;

import java.util.Date;


class Rencontre {
  private Integer id_Rencontre = null;
  private String type_Rencontre = null;
  private Date date_Rencontre = null;
  private String division = null;
  private String resultat = null;
  private String commentaires = null;
  private Salle rencontre;
  private Match matchs;
  private Equipe equipes;
  public Rencontre(){
	  
  }
  public Integer getId_Rencontre() {
	  return id_Rencontre;
  }
  public String getType_Rencontre() {
	  return type_Rencontre;
  }
  public Date getDate_Rencontre() {
	  return date_Rencontre;
  }
  public String getDivision() {
	  return division;
  }
  public String getResultat() {
	  return resultat;
  }
  public String getCommentaires() {
	  return commentaires;
  }
  public Salle getRencontre() {
	  return rencontre;
  }
  public Match getMatchs() {
	  return matchs;
  }
  public Equipe getEquipes() {
	  return equipes;
  }
  public void setId_Rencontre(Integer id_Rencontre) {
	  this.id_Rencontre = id_Rencontre;
  }
  public void setType_Rencontre(String type_Rencontre) {
	  this.type_Rencontre = type_Rencontre;
  }
  public void setDate_Rencontre(Date date_Rencontre) {
	  this.date_Rencontre = date_Rencontre;
  }
  public void setDivision(String division) {
	  this.division = division;
  }
  public void setResultat(String resultat) {
	  this.resultat = resultat;
  }
  public void setCommentaires(String commentaires) {
	  this.commentaires = commentaires;
  }
  public void setRencontre(Salle rencontre) {
	  this.rencontre = rencontre;
  }
  public void setMatchs(Match matchs) {
	  this.matchs = matchs;
  }
  public void setEquipes(Equipe equipes) {
	  this.equipes = equipes;
  }

}
