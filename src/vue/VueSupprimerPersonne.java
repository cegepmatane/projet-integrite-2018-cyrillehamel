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

public class VueSupprimerPersonne extends Scene  {

	private int idPersonne = 0 ;
	private int idFamille=0;
	private ControleurFamille controleur = null;
	protected Button actionSupprimerPersonne = null;
	protected Button actionAnnulerSuppression = null;
	public VueSupprimerPersonne() {
		super(new VBox(), 400, 400);
		VBox panneau = (VBox) this.getRoot();
		GridPane grillePersonne = new GridPane();
		this.actionSupprimerPersonne =new Button("Enregistrer");
		actionSupprimerPersonne.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierSupprimerPersonne(idPersonne,idFamille);
				
			}
			
		});
		actionAnnulerSuppression = new Button("annuler");
		
		actionAnnulerSuppression.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierNaviguerEditerFamille(idFamille);
				
			}
			
		});
		
		
		
		
		grillePersonne.add(actionSupprimerPersonne, 0, 0);
		
		grillePersonne.add(actionAnnulerSuppression, 0, 1);
		
		
		
		
		
		
		panneau.getChildren().add(new Label("Supprimer une Personne")); 
		panneau.getChildren().add(grillePersonne);
	}

	public void setControleur(ControleurFamille controleur) {
		this.controleur=controleur;
	}
	public void recupererId(int idPersonne,int idFamille) {
		this.idFamille = idFamille;
		this.idPersonne = idPersonne;
	}
	
	
	
}

