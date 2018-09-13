package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modele.Famille;

public class FamilleDAO {

	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/integrite";
	private static String BASEDEDONNEES_USAGER = "postgres";
	private static String BASEDEDONNEES_MOTDEPASSE = "test";
	private Connection connection = null;
	
	private List<Famille> simulerListerFamilles()
	{
		List<Famille> listeFamilleTest = new ArrayList<Famille>();
		listeFamilleTest.add(new Famille("dupont","FRancaise","62 boulevard perdu, Paris","Classe moyenne"));
		listeFamilleTest.add(new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne"));
		return listeFamilleTest;
	}
	public FamilleDAO(){
		
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
	public List<Famille> listerfamilles(){	
		List<Famille> listeFamilles=new ArrayList<Famille>();
		Statement requeteListeFamille;
			try {
			requeteListeFamille = connection.createStatement();
			ResultSet curseurListeFamilles = requeteListeFamille.executeQuery("SELECT * FROM famille");
			while(curseurListeFamilles.next()){
			int id= curseurListeFamilles.getInt("id");
			String nom = curseurListeFamilles.getString("nom");
			String nationalite = curseurListeFamilles.getString("nationalite");
			String adresse = curseurListeFamilles.getString("adresse");
			String classeSociale = curseurListeFamilles.getString("classeSociale");
			System.out.println("Famille " + nom + " de nationalite " + nationalite + " residant  " + adresse + " de classe : " + classeSociale);
			Famille famille = new Famille(nom, nationalite, adresse, classeSociale);
			famille.setId(id);
			listeFamilles.add(famille);
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return listeFamilles;
	}
	
	public void ajouterFamille(Famille famille)
	{
		System.out.println("FamilleDAO.ajouterFamille()");
		try {
			Statement requeteAjouterFamille = connection.createStatement();
			
			String sqlAjouterFamille = "INSERT into famille(nom, nationalite, adresse, \"classeSociale\") VALUES('"+famille.getNom()+"','"+famille.getNationalite()+"','"+famille.getAdresse()+"','"+famille.getClasseSociale()+"')";
			System.out.println("SQL : " + sqlAjouterFamille);
			requeteAjouterFamille.execute(sqlAjouterFamille);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void modifierFamille(Famille famille) {
		System.out.println("FamilleDAO.modifierFamille()");
		try {
			Statement requeteAjouterFamille = connection.createStatement();
			
			String sqlModifierFamille = "UPDATE famille SET nom = '"+famille.getNom()+"', nationalite = '"+famille.getNationalite()+"' , adresse = '"+famille.getAdresse()+"' , \"classeSociale\" ='"+famille.getClasseSociale()+"' WHERE id = "+famille.getId();
			System.out.println("SQL : " + sqlModifierFamille);
			requeteAjouterFamille.execute(sqlModifierFamille);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Famille recupererFamille(int idFamille) {
		Statement requeteFamille;
		try {
			requeteFamille = connection.createStatement();
			String SQL_RAPPORTER_FAMILLE = "SELECT * FROM famille WHERE id = " + idFamille;
			System.out.println(SQL_RAPPORTER_FAMILLE);
			ResultSet curseurFamille = requeteFamille.executeQuery(SQL_RAPPORTER_FAMILLE);
			curseurFamille.next();
			int id = curseurFamille.getInt("id");
			String nom = curseurFamille.getString("nom");
			String nationalite = curseurFamille.getString("nationalite");
			String adresse = curseurFamille.getString("adresse");
			String classeSociale = curseurFamille.getString("classeSociale");
			System.out.println("Famille " + nom + " de nationalite " + nationalite + " residant  " + adresse + " de classe : " + classeSociale);
			Famille famille = new Famille(nom, nationalite, adresse, classeSociale);
			famille.setId(id);
			return famille;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

