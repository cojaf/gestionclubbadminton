package pojo;
class Match {
  private Integer id_match = null;
  private String type_Match = null;
  private String score = null;
  private Rencontre rencontres = null;
  private Adversaire adversaires = null;
  private Competiteur competiteur = null;
  public Match(){}
  public Integer getId_match() {
	  return id_match;
  }
  public String getType_Match() {
	  return type_Match;
  }
  public String getScore() {
	  return score;
  }
  public Rencontre getRencontres() {
	  return rencontres;
  }
  public Adversaire getAdversaires() {
	  return adversaires;
  }
  public Competiteur getCompetiteur() {
	  return competiteur;
  }
  public void setId_match(Integer id_match) {
	  this.id_match = id_match;
  }
  public void setType_Match(String type_Match) {
	  this.type_Match = type_Match;
  }
  public void setScore(String score) {
	  this.score = score;
  }
  public void setRencontres(Rencontre rencontres) {
	  this.rencontres = rencontres;
  }
  public void setAdversaires(Adversaire adversaires) {
	  this.adversaires = adversaires;
  }
  public void setCompetiteur(Competiteur competiteur) {
	  this.competiteur = competiteur;
  }

}
