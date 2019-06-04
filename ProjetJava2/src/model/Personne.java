package model;

public class Personne {
	
	private int id;
	private String nom;
	private String prenom;
	private String nomClasse;
	private String nomNivDis;
	
	public Personne() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNomClasse() {
		return nomClasse;
	}
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
	public String getNomNivDis() {
		return nomNivDis;
	}
	public void setNomNivDis(String nomNivDis) {
		this.nomNivDis = nomNivDis;
	}

}
