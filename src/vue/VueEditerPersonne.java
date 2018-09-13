package vue;

import java.util.ArrayList;
import java.util.List;

import org.omg.CORBA.IdentifierHelper;

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
import modele.Personne;

public class VueEditerPersonne extends Scene  {

	
	protected TextField valeurPrenom;
	protected TextField valeurNaissance;
	protected TextField valeurMail;
	private ControleurFamille controleur = null;
	protected Button actionEnregistrerPersonne = null;
	public VueEditerPersonne() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grillePersonne = new GridPane();
		this.actionEnregistrerPersonne =new Button("Enregistrer");
		actionEnregistrerPersonne.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				//controleur.notifierModifierPersonne();
				
			}
			
		});
		
		valeurPrenom = new TextField();
		grillePersonne.add(new Label("Prenom : "), 0, 0);
		grillePersonne.add(valeurPrenom,1, 0);
		
		 valeurNaissance = new TextField();
		grillePersonne.add(new Label("Date de naissance : "), 0, 1);
		grillePersonne.add(valeurNaissance, 1, 1);
		
		valeurMail = new TextField();
		grillePersonne.add(new Label("Adresse Mail : "), 0, 2);
		grillePersonne.add(valeurMail, 1, 2);
		
		
		
		
		panneau.getChildren().add(new Label("editer une Personne")); 
		panneau.getChildren().add(grillePersonne);
		panneau.getChildren().add(actionEnregistrerPersonne);
	}

	public void setControleur(ControleurFamille controleur) {
		this.controleur=controleur;
	}
	
	
	
}
