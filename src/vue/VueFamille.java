package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import modele.Famille;

public class VueFamille extends Application {

	protected Label valeurNom = null ; 
	protected Label valeurNationnalite = null;
	protected Label valeurAdresse = null;
	protected Label valeurClasseSociale = null;
	
	@Override
	public void start(Stage stade) throws Exception {
		
		Pane panneau = new Pane();	
		GridPane grilleFamille = new GridPane();
		
		valeurNom = new Label("");
		grilleFamille.add(new Label("Nom de famille : "), 0, 0);
		grilleFamille.add(valeurNom, 1, 0);
		
		valeurNationnalite = new Label("");
		grilleFamille.add(new Label("Nationnalite : "), 0, 1);
		grilleFamille.add(valeurNationnalite, 1, 1);
		
		valeurAdresse = new Label("");
		grilleFamille.add(new Label("Adresse : "), 0, 2);
		grilleFamille.add(valeurAdresse, 1, 2);
	
		
		valeurClasseSociale = new Label("");
		grilleFamille.add(new Label("Classe Sociale : "), 0, 3);
		grilleFamille.add(valeurClasseSociale, 1, 3);
		
		
		panneau.getChildren().add(grilleFamille);
		stade.setScene(new Scene(panneau, 400, 400));
		
		//test d'affichage d'une famille
		Famille familleTest = new Famille("trembley", "Canadienne", "602 avenu saint redempteur Matane"," classe moyenne");
		afficherFamille(familleTest);
		
		stade.show();
		
	}
	public void afficherFamille(Famille famille)
	{
		this.valeurNom.setText(famille.getNom());
		this.valeurAdresse.setText(famille.getAdresse());
		this.valeurClasseSociale.setText(famille.getClasseSociale());
		this.valeurNationnalite.setText(famille.getNationalite());	
	}
	

}
