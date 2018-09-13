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
			Statement requeteAjouterMouton = connection.createStatement();
			
			String sqlAjouterMouton = "INSERT into famille(nom, nationalite, adresse, \"classeSociale\") VALUES('"+famille.getNom()+"','"+famille.getNationalite()+"','"+famille.getAdresse()+"','"+famille.getClasseSociale()+"')";
			System.out.println("SQL : " + sqlAjouterMouton);
			requeteAjouterMouton.execute(sqlAjouterMouton);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

