package pojo;
class Entraineur extends Personne {
  private String diplome = null;
  private Entrainement entrainementsE;
  private Stage entraineursS;
  private Operation operations;
  public Entraineur(){
	  
  }
  public String getDiplome() {
	  return diplome;
  }
  public Entrainement getEntrainementsE() {
	  return entrainementsE;
  }
  public Stage getEntraineursS() {
	  return entraineursS;
  }
  public Operation getOperations() {
	  return operations;
  }
  public void setDiplome(String diplome) {
	  this.diplome = diplome;
  }
  public void setEntrainementsE(Entrainement entrainementsE) {
	  this.entrainementsE = entrainementsE;
  }
  public void setEntraineursS(Stage entraineursS) {
	  this.entraineursS = entraineursS;
  }
  public void setOperations(Operation operations) {
	  this.operations = operations;
  }

}
