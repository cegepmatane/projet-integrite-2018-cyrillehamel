package vue;

import java.util.ArrayList;
import java.util.List;

import action.ControleurFamille;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Famille;

public class NavigateurDesVues extends Application {

	private Stage stade;
	private VueAjouterFamille vueAjouterFamille;
	private VueListeFamille vueListeFamille;
	private VueFamille vueFamille;
	private ControleurFamille controleur;
	
	public  NavigateurDesVues() {
		
		this.vueAjouterFamille = new VueAjouterFamille();
		this.vueListeFamille = new VueListeFamille();
		this.vueFamille = new VueFamille();
		
		
		
		
		
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
		this.controleur = new ControleurFamille(this);
	}
	public void naviguerVersVueListeFamille() {
		stade.setScene(this.vueListeFamille);
		stade.show();
	}
	
	public void naviguerVersVueFamille() {
		stade.setScene(this.vueFamille);
		stade.show();
	}
	
	public void naviguerVersVueAjouterFamille() {
		stade.setScene(this.vueAjouterFamille);
		stade.show();
	}
}
