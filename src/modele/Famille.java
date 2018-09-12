package modele;

public class Famille {
	
	protected int id;
	protected String nom;
	protected String nationalite;
	protected String adresse ;
	protected String classeSociale;
	
	public Famille(String nom, String nationalite, String adresse, String classeSociale) {
		super();
		this.nom = nom;
		this.nationalite = nationalite;
		this.adresse = adresse;
		this.classeSociale = classeSociale;
	}

	public Famille() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public String getAdresse() {
		return adresse;
	}

	public String getClasseSociale() {
		return classeSociale;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setClasseSociale(String classeSociale) {
		this.classeSociale = classeSociale;
	}
	
	
	

}
