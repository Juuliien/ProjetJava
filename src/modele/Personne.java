package modele;

public class Personne {
	
	private int id;
	private String nom;
	private String prenom;
	private String nomClasse;
	private String nomNivDis;
	/**
         * Constructeur par défaut 
         */
	public Personne() {
		
	}
	/**
         * Getter de l'id de la personne 
         * @return 
         */
	public int getId() {
		return id;
	}
        /**
         * Setter de l'id 
         * @param id 
         */
	public void setId(int id) {
		this.id = id;
	}
        /**
         * Getter du nom
         * @return 
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
         * Getter de prénom 
         * @return 
         */
	public String getPrenom() {
		return prenom;
	}
        /**
         * Setter du prenom
         * @param prenom 
         */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
        /**
         * Getter du nom de la classe 
         * @return 
         */
	public String getNomClasse() {
		return nomClasse;
	}
        /**
         * Setter du nom de la classe 
         * @param nomClasse 
         */
	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
        /**
         * Getter de niveau ou de discipline 
         * @return 
         */
	public String getNomNivDis() {
		return nomNivDis;
	}
        /**
         * Setter du niveau ou de la discipline
         * @param nomNivDis 
         */
	public void setNomNivDis(String nomNivDis) {
		this.nomNivDis = nomNivDis;
	}

}
