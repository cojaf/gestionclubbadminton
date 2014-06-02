package pojo;
class Personne {
  protected Integer id_Personne = null;
  protected String nom = null;
  protected String prenom = null;
  protected boolean sexe = false;
  public Personne(){}
  public Integer getId_Personne() {
	  return id_Personne;
  }
  public String getNom() {
	  return nom;
  }
  public String getPrenom() {
	  return prenom;
  }
  public boolean isSexe() {
	  return sexe;
  }
  public void setId_Personne(Integer id_Personne) {
	  this.id_Personne = id_Personne;
  }
  public void setNom(String nom) {
	  this.nom = nom;
  }
  public void setPrenom(String prenom) {
	  this.prenom = prenom;
  }
  public void setSexe(boolean sexe) {
	  this.sexe = sexe;
  }

}
