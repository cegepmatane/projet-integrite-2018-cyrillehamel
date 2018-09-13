package action;

import java.util.ArrayList;
import java.util.List;

import donnee.FamilleDAO;
import donnee.PersonneDAO;
import modele.Famille;
import modele.Personne;
import vue.NavigateurDesVues;
import vue.VueAjouterFamille;
import vue.VueEditerFamille;
import vue.VueFamille;
import vue.VueListeFamille;

public class ControleurFamille {
	private NavigateurDesVues navigateur;
	private VueFamille vueFamille;
	private VueListeFamille vueListeFamille;
	private VueAjouterFamille vueAjouterFamille;
	private VueEditerFamille vueEditerFamille;
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
	public void notifierModifierFamille() {
		System.out.println("ControleurFamille.notifierModifierFamille()");
		Famille famille = this.navigateur.getVueEditerFamille().demandeFamille();
		this.familleDAO.modifierFamille(famille);
		this.vueListeFamille.afficherListeFamille(this.familleDAO.listerfamilles());
		this.navigateur.naviguerVersVueListeFamille();
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
	public void notifierNaviguerEditerPersonne()
	{
		System.out.println("ControleurFamille.notifierEditerPersonne()");
		this.navigateur.naviguerVersVueEditerPersonne();
		
	}
	public void notifierNaviguerSupprimerPersonne()
	{
		System.out.println("ControleurFamille.notifierNaviguerSupprimerPersonne()");
		this.navigateur.naviguerVersVueSupprimerPersonne();
		
	}
	public void notifierNaviguerAjouterPersonne()
	{
		System.out.println("ControleurFamille.notifierNaviguerAjouterPersonne()");
		this.navigateur.naviguerVersVueAjouterPersonne();
		
	}
	
	
	
}
