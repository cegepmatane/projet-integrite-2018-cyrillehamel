package vue;

import java.util.ArrayList;
import java.util.List;

import action.ControleurFamille;
import javafx.application.Application;
import javafx.stage.Stage;
import modele.Famille;

public class NavigateurDesVues extends Application {

	private Stage stade;
	private VueAjouterFamille vueAjouterFamille = null;
	private VueListeFamille vueListeFamille = null;
	private VueFamille vueFamille =null; 
	private VueEditerFamille vueEditerFamille = null;
	private ControleurFamille controleur =null;
	
	public  NavigateurDesVues() {
		
		this.vueAjouterFamille = new VueAjouterFamille();
		this.vueListeFamille = new VueListeFamille();
		this.vueFamille = new VueFamille();
		this.vueEditerFamille = new VueEditerFamille();
	}
	
	public VueAjouterFamille getVueAjouterFamille() {
		return vueAjouterFamille;
	}
	
	public VueEditerFamille getVueEditerFamille() {
		return vueEditerFamille;
	}
	public VueListeFamille getVueListeFamille() {
		return vueListeFamille;
	}

	public VueFamille getVueFamille() {
		return vueFamille;
	}

	@Override
	public void start(Stage stade) throws Exception {
		this.stade = stade;
		this.stade.setScene(null);
		this.stade.show();
		
		this.controleur = ControleurFamille.getInstance();
		this.controleur.activerVues(this);
		this.vueAjouterFamille.setControleur(controleur);
		this.vueListeFamille.setControleur(controleur);
		this.vueFamille.setControleur(controleur);
		this.vueEditerFamille.setControleur(controleur);
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
	public void naviguerVersVueEditerFamille() {
		stade.setScene(this.vueEditerFamille);
		stade.show();
	}
}
