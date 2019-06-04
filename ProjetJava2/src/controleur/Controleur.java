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
			String requete = new String("SELECT `personne`.`id`,`personne`.`nom`, `personne`.`prenom`,  `classe`.`nomclasse`, `niveau`.`nomniveau`\r\n" + 
					"FROM `personne`\r\n" + 
					"JOIN `inscription` \r\n" + 
					"ON `personne`.`id` = `inscription`.`personne_id` \r\n" + 
					"JOIN `classe` \r\n" + 
					"ON `inscription`.`classe_id` = `classe`.`id`\r\n" + 
					"JOIN `niveau`\r\n" + 
					"ON `classe`.`niveau_id` = `niveau`.`id`\r\n" + 
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
	
}
