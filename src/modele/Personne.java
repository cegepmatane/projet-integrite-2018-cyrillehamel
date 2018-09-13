package modele;

public class Personne {
	protected int id;
	protected String prenom;
	protected String naissance;
	protected String mail;
	
	public Personne(String prenom, String naissance, String mail) {
		super();
		this.prenom = prenom;
		this.naissance = naissance;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNaissance() {
		return naissance;
	}

	public String getMail() {
		return mail;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNaissance(String naissance) {
		this.naissance = naissance;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	

}
