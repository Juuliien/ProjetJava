package modele;

public class Niveau {
	private int id;
	private String nomniveau;
	/**
         * Constructeur par défaut 
         */
	public Niveau() {
		
	}
        /**
         * Getter de l'id
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
         * Getter du nom du niveau 
         * @return 
         */
	public String getNomniveau() {
		return nomniveau;
	}
        /**
         * Setter du nom du niveau
         * @param nomniveau 
         */
	public void setNomniveau(String nomniveau) {
		this.nomniveau = nomniveau;
	}
	
	
}
