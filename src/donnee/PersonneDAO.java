package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Personne;

public class PersonneDAO {
	private static String BASEDEDONNEES_DRIVER = "org.postgresql.Driver";
	private static String BASEDEDONNEES_URL = "jdbc:postgresql://localhost:5432/bergerie";
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
	
}
