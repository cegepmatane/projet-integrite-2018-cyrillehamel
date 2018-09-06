package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VueAjouterFamille extends Application {

	protected TextField valeurNom;
	protected TextField valeurNationnalite;
	protected TextField valeurAdresse;
	protected TextField valeurClasseSociale;
	
	@Override
	public void start(Stage stade) throws Exception {
		
		VBox panneau = new VBox();	
		GridPane grilleFamille = new GridPane();
		
		valeurNom = new TextField();
		grilleFamille.add(new Label("Nom de famille : "), 0, 0);
		grilleFamille.add(valeurNom,1, 0);
		
		 valeurNationnalite = new TextField();
		grilleFamille.add(new Label("Nationnalite : "), 0, 1);
		grilleFamille.add(valeurNationnalite, 1, 1);
		
		valeurAdresse = new TextField();
		grilleFamille.add(new Label("Adresse : "), 0, 2);
		grilleFamille.add(valeurAdresse, 1, 2);
		
		valeurClasseSociale = new TextField();
		grilleFamille.add(new Label("Classe Sociale : "), 0, 3);
		grilleFamille.add(valeurClasseSociale,1, 3);
		
		panneau.getChildren().add(new Label("Ajouter une famille")); 
		panneau.getChildren().add(grilleFamille);
		panneau.getChildren().add(new Button("Enregistrer"));
		stade.setScene(new Scene(panneau, 400, 400));
		stade.show();		
	}

}
