package vue;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import modele.Famille;

public class NavigateurDesVues extends Application {

	private VueAjouterFamille vueAjouterFamille;
	private VueListeFamille vueListeFamille;
	private VueFamille vueFamille;
	
	public  NavigateurDesVues() {
		this.vueAjouterFamille = new VueAjouterFamille();
		this.vueListeFamille = new VueListeFamille();
		this.vueFamille = new VueFamille();
		
		
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
	
	public VueAjouterFamille getVueAjouterFamille() {
		return vueAjouterFamille;
	}

	public VueListeFamille getVueListeFamille() {
		return vueListeFamille;
	}

	public VueFamille getVueFamille() {
		return vueFamille;
	}

	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueAjouterFamille);
		stade.setScene(this.vueListeFamille);
		stade.setScene(this.vueFamille);
		stade.show();
	}

}
