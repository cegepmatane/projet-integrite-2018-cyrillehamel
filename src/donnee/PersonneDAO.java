package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Famille;
import modele.Personne;

public class PersonneDAO {
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/integrite";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "test";	
	private Connection connection = null;
	
	public PersonneDAO()
	{
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Personne> listerPersonnes(int idFamille)
	{
		System.out.println("PersonneDAO.listerPersonnes()");
		List<Personne> listePersonnes =  new ArrayList<Personne>();			
		Statement requeteListePersonnes;
		try {
			requeteListePersonnes = connection.createStatement();
			ResultSet curseurListePersonnes = requeteListePersonnes.executeQuery("SELECT * FROM personne WHERE famille = "+idFamille);
			while(curseurListePersonnes.next())
			{
				int id = curseurListePersonnes.getInt("id");
				String prenom = curseurListePersonnes.getString("prenom");
				String naissance = curseurListePersonnes.getString("naissance");
				String mail = curseurListePersonnes.getString("mail");
				System.out.println("personne " + prenom + " ne le " + naissance +" mail : "+ mail);
				Personne personne = new Personne(prenom, naissance, mail);
				personne.setId(id);
				listePersonnes.add(personne);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		
		return listePersonnes;
	}	
	
	public List<Personne> simulerListePersonnes(){
		List<Personne> listePersonnes = new ArrayList<Personne>();
		Personne personne;
		personne = new Personne("jean","07/10/2000","jean@toto.com");
		listePersonnes.add(personne);
		personne = new Personne("jeanne","17/11/1980","jeanne@titi.com");
		listePersonnes.add(personne);
		personne = new Personne("claude","26/06/1995","claude@gmail.com");
		listePersonnes.add(personne);
		return listePersonnes;
	}
	public void ajouterPersonne(Personne personne,int idfamille)
	{
		System.out.println("PersonneDAO.ajouterPersonne()");
		try {
			Statement requeteAjouterPersonne = connection.createStatement();
			
			String sqlAjouterPersonne = "INSERT into personne(prenom, naissance, mail, famille) VALUES('"+personne.getPrenom()+"','"+personne.getNaissance()+"','"+personne.getMail()+"',"+idfamille+")";
			System.out.println("SQL : " + sqlAjouterPersonne);
			requeteAjouterPersonne.execute(sqlAjouterPersonne);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void modifierPersonne(Personne personne) {
		System.out.println("PersonneDAO.modifierPersonne()");
		try {
			Statement requeteModifierPersonne = connection.createStatement();
			
			String sqlModifierPersonne = "UPDATE personne SET prenom = '"+personne.getPrenom()+"', naissance = '"+personne.getNaissance()+"' , mail = '"+personne.getMail()+"'  WHERE id = "+personne.getId();
			System.out.println("SQL : " + sqlModifierPersonne);
			requeteModifierPersonne.execute(sqlModifierPersonne);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void supprimerPersonne(int idPersonne) {
		System.out.println("PersonneDAO.supprimerPersonne()");
		try {
			Statement requeteSupprimerPersonne = connection.createStatement();
			
			String sqlSupprimerPersonne = "DELETE FROM personne WHERE id = "+idPersonne;
			System.out.println("SQL : " + sqlSupprimerPersonne);
			requeteSupprimerPersonne.execute(sqlSupprimerPersonne);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Personne recupererPersonne(int idPersonne) {
		Statement requetePersonne;
		try {
			requetePersonne = connection.createStatement();
			String SQL_RAPPORTER_PERSONNE = "SELECT * FROM personne WHERE id = " + idPersonne;
			System.out.println(SQL_RAPPORTER_PERSONNE);
			ResultSet curseurPersonne = requetePersonne.executeQuery(SQL_RAPPORTER_PERSONNE);
			curseurPersonne.next();
			int id = curseurPersonne.getInt("id");
			String prenom = curseurPersonne.getString("prenom");
			String naissance = curseurPersonne.getString("naissance");
			String mail = curseurPersonne.getString("mail");
			System.out.println("Pesonne " + prenom + " nee le " + naissance + " mail :  " + mail );
			Personne personne = new Personne(prenom, naissance, mail);
			personne.setId(id);
			return personne;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

