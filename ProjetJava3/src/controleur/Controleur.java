package controleur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Connexion;
import model.Personne;

public class Controleur {

	public Controleur() {
		
	}
	
	public List<Personne> recherchePersonne(){
		ArrayList<Personne> personneList = new ArrayList<Personne>();
		Connection conn = Connexion.getConnexion();
		
		try
		{
			String requete = new String("SELECT `personne`.`id`,`personne`.`nom`, `personne`.`prenom`,  `classe`.`nomclasse`, `niveau`.`nomniveau`\r\n" + 
					"FROM `personne`\r\n" + 
					"JOIN `inscription` \r\n" + 
					"ON `personne`.`id` = `inscription`.`personne_id` \r\n" + 
					"JOIN `classe` \r\n" + 
					"ON `inscription`.`classe_id` = `classe`.`id`\r\n" + 
					"JOIN `niveau`\r\n" + 
					"ON `classe`.`niveau_id` = `niveau`.`id`\r\n" + 
					"WHERE (( `personne`.`type` = \"eleve\"))");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				Personne personne = new Personne();
				personne.setId(rs.getInt("id"));
				personne.setNom(rs.getString("nom"));
				personne.setPrenom(rs.getString("prenom"));
				personne.setNomClasse(rs.getString("nomclasse"));
				personne.setNomNivDis(rs.getString("nomniveau"));

				personneList.add(personne);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return personneList;
	}
	
	public List<Personne> recherchePersonneEn(){
		ArrayList<Personne> personneList = new ArrayList<Personne>();
		Connection conn = Connexion.getConnexion();
		
		try
		{
			String requete = new String("SELECT `personne`.`id`,`personne`.`nom`, `personne`.`prenom`,  `classe`.`nomclasse`, `discipline`.`nomdiscipline`\r\n" + 
					"FROM `personne`\r\n" + 
					"JOIN `enseignement` \r\n" + 
					"ON `personne`.`id` = `enseignement`.`personne_id` \r\n" + 
					"JOIN `classe` \r\n" + 
					"ON `enseignement`.`classe_id` = `classe`.`id`\r\n" + 
					"JOIN `discipline`\r\n" + 
					"ON `enseignement`.`discipline_id` = `discipline`.`id`\r\n" + 
					"WHERE (( `personne`.`type` = \"enseignant\"))");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				Personne personne = new Personne();
				personne.setId(rs.getInt("id"));
				personne.setNom(rs.getString("nom"));
				personne.setPrenom(rs.getString("prenom"));
				personne.setNomClasse(rs.getString("nomclasse"));
				personne.setNomNivDis(rs.getString("nomdiscipline"));

				personneList.add(personne);
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return personneList;
	}
	
	public ArrayList<String> obtenirNiveau(){
		ArrayList<String> nivListe = new ArrayList<String>();
		Connection conn = Connexion.getConnexion();
		
		try
		{
			String requete = new String("SELECT nomniveau FROM niveau");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				nivListe.add(rs.getString("nomniveau"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return nivListe;
	}
	
	public ArrayList<String> obtenirClasse(String niveau){
		ArrayList<String> classeListe = new ArrayList<String>();
		Connection conn = Connexion.getConnexion();
		
		try
		{
			String requete = new String("SELECT nomclasse FROM niveau JOIN classe on niveau.id = classe.Niveau_id where niveau.nomniveau =\""+niveau+"\"");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				classeListe.add(rs.getString("nomclasse"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return classeListe;
	}
	
	public int ajouterPersonne(String nom, String prenom, String type) {
		Connection conn = Connexion.getConnexion();
		int idPersonne = -1;
		
		try
		{

			String requete = new String("INSERT INTO personne (nom, prenom, type) VALUES (?,?,?);");
			PreparedStatement statement = conn.prepareStatement(requete,Statement.RETURN_GENERATED_KEYS);

			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, type);
			

			statement.executeUpdate();
			ResultSet rs = statement.getGeneratedKeys();
			if (rs.next()) {
				idPersonne = rs.getInt(1);
			}

		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		return idPersonne;
	}
	
	public void ajoutInscription(int idPersonne, int idClasse) {
		Connection conn = Connexion.getConnexion();
		
		try {
			String requete = new String("INSERT INTO inscription (classe_id, personne_id) VALUES (?,?);");
			PreparedStatement statement = conn.prepareStatement(requete);
			
			statement.setInt(1, idClasse);
			statement.setInt(2, idPersonne);
			
			statement.executeUpdate();
			
		}catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}	
	}
	
	public int obtenirIdClasse(String classe){
		Connection conn = Connexion.getConnexion();
		int idClasse = -1;
		
		try
		{
			String requete = new String("SELECT id FROM Classe WHERE nomclasse=\""+classe+"\"");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				idClasse= rs.getInt("id");
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return idClasse;
	}
	
	public ArrayList<String> obtenirDispline(){
		ArrayList<String> disciplineListe = new ArrayList<String>();
		Connection conn = Connexion.getConnexion();
		
		try
		{
			String requete = new String("SELECT nomdiscipline FROM discipline");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				disciplineListe.add(rs.getString("nomdiscipline"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return disciplineListe;
	}
	
	public ArrayList<String> obtenirToutClasse(){
		ArrayList<String> classeListe = new ArrayList<String>();
		Connection conn = Connexion.getConnexion();
		
		try
		{
			String requete = new String("SELECT nomclasse FROM classe");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				classeListe.add(rs.getString("nomclasse"));
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return classeListe;
	}
	
	public int obtenirIdDiscipline(String discipline){
		Connection conn = Connexion.getConnexion();
		int idDis = -1;
		
		try
		{
			String requete = new String("SELECT id FROM discipline WHERE nomdiscipline=\""+discipline+"\"");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				idDis= rs.getInt("id");
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return idDis;
	}
	
	public void ajoutEnseignement(int idDis, int idPersonne, int idClasse) {
		Connection conn = Connexion.getConnexion();
		
		try {
			String requete = new String("INSERT INTO enseignement (classe_id, discipline_id, personne_id) VALUES (?,?,?);");
			PreparedStatement statement = conn.prepareStatement(requete);
			
			statement.setInt(1, idClasse);
			statement.setInt(2, idDis);
			statement.setInt(3, idPersonne);
			
			statement.executeUpdate();
			
		}catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}	
	}
	
	public void supprimerEleve(String id) {
		Connection conn = Connexion.getConnexion();
		
		try {
			String requete = new String("DELETE FROM inscription WHERE inscription.personne_id ="+id);
			PreparedStatement statement = conn.prepareStatement(requete);
			
			statement.executeUpdate();
			
		}catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
	}
	
	public void supprimerEnseignant(String id) {
		Connection conn = Connexion.getConnexion();
		
		try {
			String requete = new String("DELETE FROM enseignement WHERE enseignement.personne_id ="+id);
			PreparedStatement statement = conn.prepareStatement(requete);
			
			statement.executeUpdate();
			
		}catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
	}
	
	public String obtenirNomPersonne(String id){
		Connection conn = Connexion.getConnexion();
		String nom = null;
		
		try
		{
			String requete = new String("SELECT nom FROM personne WHERE id="+id);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				nom = rs.getString("nom");
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return nom;
	}
	
	public String obtenirPrenomPersonne(String id){
		Connection conn = Connexion.getConnexion();
		String prenom = null;
		
		try
		{
			String requete = new String("SELECT prenom FROM personne WHERE id="+id);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			while ( rs.next() )
			{
				prenom = rs.getString("prenom");
			}
		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
		
		
		return prenom;
	}
	
	public void modifierPersonne(String nom, String prenom, String type, String id) {
		Connection conn = Connexion.getConnexion();
		
		try
		{

			String requete = new String("UPDATE personne SET nom = ?, prenom = ?, type = ? WHERE id ="+id);
			PreparedStatement statement = conn.prepareStatement(requete);

			statement.setString(1, nom);
			statement.setString(2, prenom);
			statement.setString(3, type);
			

			statement.executeUpdate();

		}
		catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}
	}
	
	public void modifierInscription(String idPersonne, int idClasse) {
		Connection conn = Connexion.getConnexion();
		
		try {
			String requete = new String("UPDATE inscription SET classe_id = ? where personne_id ="+idPersonne);
			PreparedStatement statement = conn.prepareStatement(requete);
			
			statement.setInt(1, idClasse);
			
			statement.executeUpdate();
			
		}catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}	
	}
	
	public void modifierEnseignement(int idDis, String idPersonne, int idClasse) {
		Connection conn = Connexion.getConnexion();
		
		try {
			String requete = new String("UPDATE enseignement SET classe_id = ?, discipline_id = ? WHERE personne_id="+idPersonne);
			PreparedStatement statement = conn.prepareStatement(requete);
			
			statement.setInt(1, idClasse);
			statement.setInt(2, idDis);
			
			statement.executeUpdate();
			
		}catch (SQLException ex3)
		{
			while (ex3 != null)
			{
				System.out.println(ex3.getSQLState());
				System.out.println(ex3.getMessage());
				System.out.println(ex3.getErrorCode());
				ex3=ex3.getNextException();
			}
		}	
	}
	
}
