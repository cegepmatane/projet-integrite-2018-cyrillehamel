package action;

import java.util.ArrayList;
import java.util.List;

import donnee.FamilleDAO;
import donnee.PersonneDAO;
import modele.Famille;
import modele.Personne;
import vue.NavigateurDesVues;
import vue.VueAjouterFamille;
import vue.VueAjouterPersonne;
import vue.VueEditerFamille;
import vue.VueEditerPersonne;
import vue.VueFamille;
import vue.VueListeFamille;
import vue.VueSupprimerPersonne;

public class ControleurFamille {
	private NavigateurDesVues navigateur;
	private VueFamille vueFamille;
	private VueListeFamille vueListeFamille;
	private VueAjouterFamille vueAjouterFamille;
	private VueEditerFamille vueEditerFamille;
	private VueEditerPersonne vueEditerPersonne;
	private VueAjouterPersonne vueAjouterPersonne;
	private VueSupprimerPersonne vueSupprimerPersonne;
	FamilleDAO familleDAO =null;
	PersonneDAO personneDAO = null ;
	public ControleurFamille() {
		
	}
	
	public void activerVues(NavigateurDesVues navigateur){
		
		this.navigateur = navigateur;
		this.vueFamille = navigateur.getVueFamille();
		this.vueListeFamille = navigateur.getVueListeFamille();
		this.vueAjouterFamille = navigateur.getVueAjouterFamille();
		this.vueEditerFamille = navigateur.getVueEditerFamille();
		this.vueEditerPersonne = navigateur.getVueEditerPersonne();
		this.vueAjouterPersonne = navigateur.getVueAjouterPersonne();
		this.vueSupprimerPersonne = navigateur.getVueSupprimerPersonne();
		this.familleDAO = new FamilleDAO();
		this.personneDAO = new PersonneDAO();
		
		//test vuelisteFamille
		List<Famille> listeFamilleTest =familleDAO.listerfamilles();
		
		this.vueListeFamille.afficherListeFamille(listeFamilleTest);
				
		//test vueFamille
		//test d'affichage d'une famille
		Famille familleTest = new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne");
		this.vueFamille.afficherFamille(familleTest);
		
		this.navigateur.naviguerVersVueListeFamille();		
		//this.navigateur.naviguerVersVueAjouterFamille();
		
		
				
				
	}
	
	private static ControleurFamille instance = null;
	public static ControleurFamille getInstance()
	{
		if(null == instance) instance = new ControleurFamille();
		return instance;
	}
	public void notifierEnregistrerFamille() {
		System.out.println("ControleurFamille.notifierEnregistrerFamille()");
		Famille famille=this.navigateur.getVueAjouterFamille().demandeFamille();
		this.familleDAO.ajouterFamille(famille);
		this.vueListeFamille.afficherListeFamille(this.familleDAO.listerfamilles());
		this.navigateur.naviguerVersVueListeFamille();
	}
	
	public void notifierEnregistrerPersonne(int idFamille) {
		System.out.println("ControleurFamille.notifierEnregistrerPersonne()");
		Personne personne=this.navigateur.getVueAjouterPersonne().demandePersonne();
		this.personneDAO.ajouterPersonne(personne,idFamille);
		this.vueEditerFamille.afficherListePersonnes(this.personneDAO.listerPersonnes(idFamille));
		this.vueEditerFamille.afficherFamille(this.familleDAO.recupererFamille(idFamille));
		this.navigateur.naviguerVersVueEditerFamille();
	}
	
	public void notifierModifierFamille() {
		System.out.println("ControleurFamille.notifierModifierFamille()");
		Famille famille = this.navigateur.getVueEditerFamille().demandeFamille();
		this.familleDAO.modifierFamille(famille);
		this.vueListeFamille.afficherListeFamille(this.familleDAO.listerfamilles());
		this.navigateur.naviguerVersVueListeFamille();
	}
	public void notifierSupprimerPersonne(int idPersonne,int idFamille) {
		System.out.println("ControleurFamille.notifierSupprimerPersonne()");
		this.personneDAO.supprimerPersonne(idPersonne);
		this.vueEditerFamille.afficherListePersonnes(this.personneDAO.listerPersonnes(idFamille));
		this.vueEditerFamille.afficherFamille(this.familleDAO.recupererFamille(idFamille));
		this.navigateur.naviguerVersVueEditerFamille();
	}
	
	public void notifierModifierPersonne(int idFamille) {
		System.out.println("ControleurFamille.notifierModifierPersonne()");
		Personne personne = this.navigateur.getVueEditerPersonne().demandePersonne();
		this.personneDAO.modifierPersonne(personne);
		this.vueEditerFamille.afficherListePersonnes(this.personneDAO.listerPersonnes(idFamille));
		this.vueEditerFamille.afficherFamille(this.familleDAO.recupererFamille(idFamille));
		this.navigateur.naviguerVersVueEditerFamille();
	}
	
	public void notifierNaviguerAjouterFamille() {
		System.out.println("ControleurFamille.notifierNaviguerAjouterFamille()");
		this.navigateur.naviguerVersVueAjouterFamille();
	}
	public void notifierNaviguerEditerFamille(int idFamille)
	{
		System.out.println("ControleurFamille.notifierEditerFamille()");
		this.vueEditerFamille.afficherListePersonnes(this.personneDAO.listerPersonnes(idFamille));
		this.vueEditerFamille.afficherFamille(this.familleDAO.recupererFamille(idFamille));
		this.navigateur.naviguerVersVueEditerFamille();
		
	}
	
	public void notifierNaviguerEditerPersonne(int idPersonne,int idFamille)
	{
		System.out.println("ControleurFamille.notifierEditerPersonne()");
		this.vueEditerPersonne.recupererIdFamille(idFamille);
		this.vueEditerPersonne.afficherPersonne(this.personneDAO.recupererPersonne(idPersonne));
		this.navigateur.naviguerVersVueEditerPersonne();
		
	}
	public void notifierNaviguerSupprimerPersonne(int idPersonne,int idFamille)
	{
		System.out.println("ControleurFamille.notifierNaviguerSupprimerPersonne()");
		this.vueSupprimerPersonne.recupererId(idPersonne,idFamille);
		this.navigateur.naviguerVersVueSupprimerPersonne();
		
	}
	public void notifierNaviguerAjouterPersonne(int idFamille)
	{
		System.out.println("ControleurFamille.notifierNaviguerAjouterPersonne()");
		this.vueAjouterPersonne.recupererIdFamille(idFamille);
		this.navigateur.naviguerVersVueAjouterPersonne();
		
	}
	
	
	
}
