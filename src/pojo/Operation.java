package pojo;

import java.util.Date;



class Operation {
  private Integer id_Operation = null;
  private String nom_Operation = null;
  private String description = null;
  private Date date = null;
  private double montant = 0.0d;
  private Stage stage;
  private Entraineur entraineur;
  private Cotisation cotisation;
  private TypeOperation typeOperation;
  public Operation(){}
  public Integer getId_Operation() {
	  return id_Operation;
  }
  public String getNom_Operation() {
	  return nom_Operation;
  }
  public String getDescription() {
	  return description;
  }
  public Date getDate() {
	  return date;
  }
  public double getMontant() {
	  return montant;
  }
  public Stage getStage() {
	  return stage;
  }
  public Entraineur getEntraineur() {
	  return entraineur;
  }
  public Cotisation getCotisation() {
	  return cotisation;
  }
  public TypeOperation getTypeOperation() {
	  return typeOperation;
  }
  public void setId_Operation(Integer id_Operation) {
	  this.id_Operation = id_Operation;
  }
  public void setNom_Operation(String nom_Operation) {
	  this.nom_Operation = nom_Operation;
  }
  public void setDescription(String description) {
	  this.description = description;
  }
  public void setDate(Date date) {
	  this.date = date;
  }
  public void setMontant(double montant) {
	  this.montant = montant;
  }
  public void setStage(Stage stage) {
	  this.stage = stage;
  }
  public void setEntraineur(Entraineur entraineur) {
	  this.entraineur = entraineur;
  }
  public void setCotisation(Cotisation cotisation) {
	  this.cotisation = cotisation;
  }
  public void setTypeOperation(TypeOperation typeOperation) {
	  this.typeOperation = typeOperation;
  }
}
