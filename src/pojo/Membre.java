package pojo;


import java.util.Date;
import java.util.List;

class Membre extends Personne {
	
  private Date date_Naissance = null;
  private String conjoint = null;
  private String courriel = null;
  private String telephone = null;
  private Adresse adresse = null;
  private Comite comite = null;
  private List<Cotisation> cotisations = null;
  private Competiteur competiteur = null;
  public Membre(){
	  super();
  }
  public Date getDate_Naissance() {
	  return date_Naissance;
  }
  public String getConjoint() {
	  return conjoint;
  }
  public String getCourriel() {
	  return courriel;
  }
  public String getTelephone() {
	  return telephone;
  }
  public Adresse getAdresse() {
	  return adresse;
  }
  public Comite getComite() {
	  return comite;
  }
  public List<Cotisation> getCotisations() {
	  return cotisations;
  }
  public Competiteur getCompetiteur() {
	  return competiteur;
  }
  public void setDate_Naissance(Date date_Naissance) {
	  this.date_Naissance = date_Naissance;
  }
  public void setConjoint(String conjoint) {
	  this.conjoint = conjoint;
  }
  public void setCourriel(String courriel) {
	  this.courriel = courriel;
  }
  public void setTelephone(String telephone) {
	  this.telephone = telephone;
  }
  public void setAdresse(Adresse adresse) {
	  this.adresse = adresse;
  }
  public void setComite(Comite comite) {
	  this.comite = comite;
  }
  public void setCotisations(List<Cotisation> cotisations) {
	  this.cotisations = cotisations;
  }
  public void setCompetiteur(Competiteur competiteur) {
	  this.competiteur = competiteur;
  }


}
