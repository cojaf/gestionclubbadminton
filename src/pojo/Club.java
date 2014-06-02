package pojo;

import java.util.List;

class Club {
  private Integer id_Club = null;
  private String nom_Club = null;
  private List<Equipe> equipe = null;
  public Club(){
	  
  }
  public Integer getId_Club() {
	  return id_Club;
  }
  public String getNom_Club() {
	  return nom_Club;
  }
  public List<Equipe> getEquipe() {
	  return equipe;
  }
  public void setId_Club(Integer id_Club) {
	  this.id_Club = id_Club;
  }
  public void setNom_Club(String nom_Club) {
	  this.nom_Club = nom_Club;
  }
  public void setEquipe(List<Equipe> equipe) {
	  this.equipe = equipe;
  }
  
}
