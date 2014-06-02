package pojo;
class TypeOperation {
  private Integer id_Type = null;
  private String nom_Type = null;
  private Operation operations;
  public TypeOperation(){
	  
  }
  public Integer getId_Type() {
	  return id_Type;
  }
  public String getNom_Type() {
	  return nom_Type;
  }
  public Operation getOperations() {
	  return operations;
  }
  public void setId_Type(Integer id_Type) {
	  this.id_Type = id_Type;
  }
  public void setNom_Type(String nom_Type) {
	  this.nom_Type = nom_Type;
  }
  public void setOperations(Operation operations) {
	  this.operations = operations;
  }

}
