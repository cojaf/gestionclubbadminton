package pojo;
class TypeCotisation {
  private Integer id_TypeCotisation = null;
  private String nom_TypeCotisation = null;
  private double montant = 0.0d;
  private TypeCotisation type ;
  private Cotisation cotisation;
public TypeCotisation(){}
public Integer getId_TypeCotisation() {
	return id_TypeCotisation;
}
public String getNom_TypeCotisation() {
	return nom_TypeCotisation;
}
public double getMontant() {
	return montant;
}
public TypeCotisation getType() {
	return type;
}
public Cotisation getCotisation() {
	return cotisation;
}
public void setId_TypeCotisation(Integer id_TypeCotisation) {
	this.id_TypeCotisation = id_TypeCotisation;
}
public void setNom_TypeCotisation(String nom_TypeCotisation) {
	this.nom_TypeCotisation = nom_TypeCotisation;
}
public void setMontant(double montant) {
	this.montant = montant;
}
public void setType(TypeCotisation type) {
	this.type = type;
}
public void setCotisation(Cotisation cotisation) {
	this.cotisation = cotisation;
}

}
