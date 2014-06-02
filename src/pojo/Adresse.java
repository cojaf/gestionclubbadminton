package pojo;

import java.util.List;


class Adresse {
  private Integer id_Adresse = null;
  private String ville = null;
  private String rue = null;
  private String numero = null;
  private String boite = null;
  private Pays pays;
  private List <Membre>membres = null;
  public Adresse(){}
  
  public Integer getId_Adresse() {
	return id_Adresse;
}
  public String getVille() {
	return ville;
}
  public String getRue() {
	  return rue;
  }
  public String getNumero() {
	  return numero;
  }
  public String getBoite() {
	  return boite;
  }
  public Pays getPays() {
	  return pays;
  }
  public List<Membre> getMembres() {
	  return membres;
  }
  public void setId_Adresse(Integer id_Adresse) {
	  this.id_Adresse = id_Adresse;
  }
  public void setVille(String ville) {
	  this.ville = ville;
  }
  public void setRue(String rue) {
	  this.rue = rue;
  }
  public void setNumero(String numero) {
	  this.numero = numero;
  }
  public void setBoite(String boite) {
	  this.boite = boite;
  }
  public void setPays(Pays pays) {
	  this.pays = pays;
  }
  public void setMembres(List<Membre> membres) {
	this.membres = membres;
}

  
  
}
