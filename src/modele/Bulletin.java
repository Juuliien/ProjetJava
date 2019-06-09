package modele;

public class Bulletin {
	private int id;
	private String nom;
	private String prenom;
	private String appreciation;
	
	/**
         * Constructeur par défaut
         */
	public Bulletin() {
		
	}
	
	/**
         * Getter de l'id du bulletin
         * @return un entier
         */
	public int getId() {
		return id;
	}
        /**
         * Setter de l'id du bulletin 
         * @param id un entier 
         */
	public void setId(int id) {
		this.id = id;
	}
        /**
         * Getter du nom de l'élève
         * @return String avec le nom 
         */
	public String getNom() {
		return nom;
	}
        /**
         * Setter du nom 
         * @param nom 
         */
	public void setNom(String nom) {
		this.nom = nom;
	}
        /**
         * Getter du prénom de l'élève
         * @return 
         */
	public String getPrenom() {
		return prenom;
	}
        /**
         * Setter du prénom
         * @param prenom 
         */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
        /**
         * Getter de l'appréciation
         * @return 
         */
	public String getAppreciation() {
		return appreciation;
	}
        /**
         * Setter de l'appréciation 
         * @param appreciation 
         */
	public void setAppreciation(String appreciation) {
		this.appreciation = appreciation;
	}
}
