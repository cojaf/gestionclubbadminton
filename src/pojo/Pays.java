package pojo;
class Pays {
  private int id_Pays = 0;
  private String nom_Pays = null;
  private String code_Pays = null;
  private Adresse adresses;
  public Pays(){}
  public int getId_Pays() {
	  return id_Pays;
  }
  public String getNom_Pays() {
	  return nom_Pays;
  }
  public String getCode_Pays() {
	  return code_Pays;
  }
  public Adresse getAdresses() {
	  return adresses;
  }
  public void setId_Pays(int id_Pays) {
	  this.id_Pays = id_Pays;
  }
  public void setNom_Pays(String nom_Pays) {
	  this.nom_Pays = nom_Pays;
  }
  public void setCode_Pays(String code_Pays) {
	  this.code_Pays = code_Pays;
  }
  public void setAdresses(Adresse adresses) {
	  this.adresses = adresses;
  }
  
}
