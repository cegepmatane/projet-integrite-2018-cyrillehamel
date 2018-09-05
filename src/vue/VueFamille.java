package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class VueFamille extends Application {

	@Override
	public void start(Stage stade) throws Exception {
		
		Pane panneau = new Pane();	
		GridPane grilleFamille = new GridPane();
		
		Label valeurNom = new Label("Dupont");
		grilleFamille.add(new Label("Nom de famille : "), 0, 0);
		grilleFamille.add(valeurNom, 1, 0);
	
		panneau.getChildren().add(grilleFamille);
		stade.setScene(new Scene(panneau, 400, 400));
		
		stade.show();
		
	}

	

}
