package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueListeFamille extends Application {

	@Override
	public void start(Stage stade) throws Exception {
		
		Pane panneau = new Pane();	
		GridPane grilleFamille = new GridPane();
		
		Label valeurNom = new Label("Dupont");
		Label valeurNom2 = new Label("Tremblay");
		
		grilleFamille.add(new Label("Nom de famille : "), 0, 0);
		grilleFamille.add(valeurNom, 0, 1);
		grilleFamille.add(valeurNom2, 0, 2);
		
		
	
		panneau.getChildren().add(grilleFamille);
		stade.setScene(new Scene(panneau, 400, 400));
		
		
		stade.show();
		
	}

}
