package action;

import java.util.ArrayList;
import java.util.List;

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
	
	public ControleurFamille(NavigateurDesVues navigateur) {
		super();
		this.navigateur = navigateur;
		this.vueFamille = navigateur.getVueFamille();
		this.vueListeFamille = navigateur.getVueListeFamille();
		this.vueAjouterFamille = navigateur.getVueAjouterFamille();
	
		//test vuelisteFamille
		List<Famille> listeFamilleTest = new ArrayList<Famille>();
		listeFamilleTest.add(new Famille("dupont","FRancaise","62 boulevard perdu, Paris","Classe moyenne"));
		listeFamilleTest.add(new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne"));
		this.vueListeFamille.afficherListeFamille(listeFamilleTest);
				
		//test vueFamille
		//test d'affichage d'une famille
		Famille familleTest = new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne");
		this.vueFamille.afficherFamille(familleTest);
				
	}
	
	
}
