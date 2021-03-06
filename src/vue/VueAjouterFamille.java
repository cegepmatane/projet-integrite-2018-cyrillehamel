package vue;

import action.ControleurFamille;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modele.Famille;

public class VueAjouterFamille extends Scene  {

	protected TextField valeurNom;
	protected TextField valeurNationnalite;
	protected TextField valeurAdresse;
	protected TextField valeurClasseSociale;
	private ControleurFamille controleur = null;
	protected Button actionEnregistrerFamille = null;
	public VueAjouterFamille() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		
		GridPane grilleFamille = new GridPane();
		this.actionEnregistrerFamille =new Button("Enregistrer");
		actionEnregistrerFamille.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierEnregistrerFamille();
				
			}
			
		});
		
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
		panneau.getChildren().add(actionEnregistrerFamille);
	}

	public void setControleur(ControleurFamille controleur) {
		this.controleur=controleur;
	}
	public Famille demandeFamille() {
		Famille famille= new Famille(this.valeurNom.getText(),this.valeurNationnalite.getText(),this.valeurAdresse.getText(),this.valeurClasseSociale.getText());
		return famille;
	}
}
