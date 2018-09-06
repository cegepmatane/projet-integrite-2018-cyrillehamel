package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application {

	private VueAjouterFamille vueAjouterFamille;
	private VueListeFamille vueListeFamille;
	private VueFamille vueFamille;
	
	public  NavigateurDesVues() {
		this.vueAjouterFamille = new VueAjouterFamille();
		this.vueListeFamille = new VueListeFamille();
		this.vueFamille = new VueFamille();
	}
	
	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueAjouterFamille);
		stade.setScene(this.vueListeFamille);
		stade.setScene(this.vueFamille);
		stade.show();
	}

}
