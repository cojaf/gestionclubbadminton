package pojo;
class Cotisation {
  private Integer id_Cotisation = null;
  private Membre membres;
  private TypeCotisation typeCotisation;
  private Operation operation;
  public Cotisation(){
	  
  }
  public Integer getId_Cotisation() {
	  return id_Cotisation;
  }
  public Membre getMembres() {
	  return membres;
  }
  public TypeCotisation getTypeCotisation() {
	  return typeCotisation;
  }
  public Operation getOperation() {
	  return operation;
  }
  public void setId_Cotisation(Integer id_Cotisation) {
	  this.id_Cotisation = id_Cotisation;
  }
  public void setMembres(Membre membres) {
	  this.membres = membres;
  }
  public void setTypeCotisation(TypeCotisation typeCotisation) {
	  this.typeCotisation = typeCotisation;
  }
  public void setOperation(Operation operation) {
	  this.operation = operation;
  }

  

}
