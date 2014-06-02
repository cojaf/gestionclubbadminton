package pojo;
class Classement {
  private Integer id_Classement = null;
  private String discipline = null;
  private String categorie =  null;
  private Adversaire adversaires;
  private Competiteur competiteurs;
  public Classement(){
	  
  }
  public Integer getId_Classement() {
	  return id_Classement;
  }
  public String getDiscipline() {
	  return discipline;
  }
  public String getCategorie() {
	  return categorie;
  }
  public Adversaire getAdversaires() {
	  return adversaires;
  }
  public Competiteur getCompetiteurs() {
	  return competiteurs;
  }
  public void setId_Classement(Integer id_Classement) {
	  this.id_Classement = id_Classement;
  }
  public void setDiscipline(String discipline) {
	  this.discipline = discipline;
  }
  public void setCategorie(String categorie) {
	  this.categorie = categorie;
  }
  public void setAdversaires(Adversaire adversaires) {
	  this.adversaires = adversaires;
  }
  public void setCompetiteurs(Competiteur competiteurs) {
	  this.competiteurs = competiteurs;
  }

}
