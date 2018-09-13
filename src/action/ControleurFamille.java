package action;

import java.util.ArrayList;
import java.util.List;

import donnee.FamilleDAO;
import modele.Famille;
import vue.NavigateurDesVues;
import vue.VueAjouterFamille;
import vue.VueFamille;
import vue.VueListeFamille;

public class ControleurFamille {
	private NavigateurDesVues navigateur;
	private VueFamille vueFamille;
	private VueListeFamille vueListeFamille;
	private VueAjouterFamille vueAjouterFamille;
	FamilleDAO familleDAO =null;
	public ControleurFamille() {
		
	}
	
	public void activerVues(NavigateurDesVues navigateur){
		
		this.navigateur = navigateur;
		this.vueFamille = navigateur.getVueFamille();
		this.vueListeFamille = navigateur.getVueListeFamille();
		this.vueAjouterFamille = navigateur.getVueAjouterFamille();
		this.familleDAO = new FamilleDAO();
		
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
	public void notifierNaviguerAjouterFamille() {
		System.out.println("ControleurFamille.notifierNaviguerAjouterFamille()");
		this.navigateur.naviguerVersVueAjouterFamille();
	}
		
}
