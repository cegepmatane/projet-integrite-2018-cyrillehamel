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

	
	private List<Famille> simulerListerFamilles()
	{
		List<Famille> listeFamilleTest = new ArrayList<Famille>();
		listeFamilleTest.add(new Famille("dupont","FRancaise","62 boulevard perdu, Paris","Classe moyenne"));
		listeFamilleTest.add(new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne"));
		return listeFamilleTest;
	}
	public List<Famille> listerfamilles()
	{
		String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
		String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/integrite";
		String BASEDEDONNEES_USAGER = "postgres";
		String BASEDEDONNEES_MOTDEPASSE = "test";
		
		try {
			Class.forName(BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Famille> listeFamilles=new ArrayList<Famille>();
		try {
			Connection connection = DriverManager.getConnection(BASEDEDONNEES_URL, BASEDEDONNEES_USAGER, BASEDEDONNEES_MOTDEPASSE);
			
			Statement requeteListeFamille = connection.createStatement();
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeFamilles;
	}
}

