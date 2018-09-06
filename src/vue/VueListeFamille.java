package vue;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Famille;

public class VueListeFamille extends Scene {

	private GridPane grilleFamille = null ;
	
	
	public VueListeFamille() {
		super(new Pane(), 800,400);
		Pane panneau = (Pane) this.getRoot();

		
		grilleFamille = new GridPane();
		
		
		List<Famille> listeFamilleTest = new ArrayList<Famille>();
		listeFamilleTest.add(new Famille("dupont","FRancaise","62 boulevard perdu, Paris","Classe moyenne"));
		listeFamilleTest.add(new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne"));
		afficherListeFamille(listeFamilleTest);
		
		panneau.getChildren().add(grilleFamille);
		
	}
	
	private void afficherListeFamille(List<Famille> listeFamille) {
		
		grilleFamille.getChildren().clear();
		
		
		grilleFamille.add(new Label("Nom de famille : "), 0, 0);
		grilleFamille.add(new Label("Nationnalite : "), 1, 0);
		grilleFamille.add(new Label("Adresse : "), 2, 0);
		grilleFamille.add(new Label("Classe Sociale : "), 3, 0);
		int position = 1 ;
		for(Famille famille : listeFamille) 
		{
			grilleFamille.add(new Label(famille.getNom()), 0, position);
		grilleFamille.add(new Label(famille.getNationalite()), 1, position);
		grilleFamille.add(new Label(famille.getAdresse()), 2, position);
		grilleFamille.add(new Label(famille.getClasseSociale()), 3, position);
		position++;
		}		

	}

}
