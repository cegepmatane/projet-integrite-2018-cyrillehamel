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
	
	public ControleurFamille() {
		
	}
	
	public void activerVues(NavigateurDesVues navigateur){
		
		this.navigateur = navigateur;
		this.vueFamille = navigateur.getVueFamille();
		this.vueListeFamille = navigateur.getVueListeFamille();
		this.vueAjouterFamille = navigateur.getVueAjouterFamille();
		
		FamilleDAO familleDAO =new FamilleDAO();
		//test vuelisteFamille
		List<Famille> listeFamilleTest =familleDAO.listerfamilles();
		
		this.vueListeFamille.afficherListeFamille(listeFamilleTest);
				
		//test vueFamille
		//test d'affichage d'une famille
		Famille familleTest = new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne");
		this.vueFamille.afficherFamille(familleTest);
		
		this.navigateur.naviguerVersVueListeFamille();		
		this.navigateur.naviguerVersVueAjouterFamille();		
	}
	
	private static ControleurFamille instance = null;
	public static ControleurFamille getInstance()
	{
		if(null == instance) instance = new ControleurFamille();
		return instance;
	}
	
	
}
