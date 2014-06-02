package pojo;
class Adversaire extends Personne {
  private String  numero_Ligue;
  private Classement classements;
  private Match matchs;
  public Adversaire(){
	  
  }
  public String getNumero_Ligue() {
	  return numero_Ligue;
  }
  public Classement getClassements() {
	  return classements;
  }
  public Match getMatchs() {
	  return matchs;
  }
  public void setNumero_Ligue(String numero_Ligue) {
	  this.numero_Ligue = numero_Ligue;
  }
  public void setClassements(Classement classements) {
	  this.classements = classements;
  }
  public void setMatchs(Match matchs) {
	  this.matchs = matchs;
  }


}
