
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

public class VueEditerFamille extends Scene  {

	private int idFamille=0;
	protected TextField valeurNom;
	protected TextField valeurNationnalite;
	protected TextField valeurAdresse;
	protected TextField valeurClasseSociale;
	private ControleurFamille controleur = null;
	protected Button actionEnregistrerFamille = null;
	GridPane grilleListePersonne = new GridPane();
	public VueEditerFamille() {
		super(new VBox(), 800, 400);
		VBox panneau = (VBox) this.getRoot();
		
		GridPane grilleFamille = new GridPane();
		this.actionEnregistrerFamille =new Button("Enregistrer");
		actionEnregistrerFamille.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				controleur.notifierModifierFamille();
				
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
		
		
		
		panneau.getChildren().add(new Label("editer une famille")); 
		panneau.getChildren().add(grilleFamille);
		panneau.getChildren().add(actionEnregistrerFamille);
		panneau.getChildren().add(grilleListePersonne);
	}

	public void setControleur(ControleurFamille controleur) {
		this.controleur=controleur;
	}
	public void afficherFamille(Famille famille) {
		this.idFamille=famille.getId();
		this.valeurNom.setText(famille.getNom());
		this.valeurNationnalite.setText(famille.getNationalite());
		this.valeurAdresse.setText(famille.getAdresse());
		this.valeurClasseSociale.setText(famille.getClasseSociale());
	}
	public Famille demandeFamille() {
		Famille famille= new Famille(this.valeurNom.getText(),this.valeurNationnalite.getText(),this.valeurAdresse.getText(),this.valeurClasseSociale.getText());
		famille.setId(idFamille);
		return famille;
	}
	public void afficherListePersonnes(List<Personne> listePersonnes) {
		this.grilleListePersonne.getChildren().clear();
		int item = 0;
		Button actionAjouterPersonne = new Button("Ajouter une personne");
		actionAjouterPersonne.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				Famille famille =demandeFamille();
				controleur.notifierNaviguerAjouterPersonne(famille.getId());
			}});
		for(Personne individu : listePersonnes)
		{
			Button actionEditerPersonne = new Button("Editer");
			actionEditerPersonne.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					Famille famille =demandeFamille();
					controleur.notifierNaviguerEditerPersonne(individu.getId(),famille.getId());
					
				}});
			Button actionSupprimerPersonne = new Button("Supprimer");
			actionSupprimerPersonne.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					Famille famille =demandeFamille();
					controleur.notifierNaviguerSupprimerPersonne();
				}});
			
			
			this.grilleListePersonne.add(new Label(individu.getPrenom() + ""), 0, item);
			this.grilleListePersonne.add(new Label(individu.getNaissance() + ""), 1, item);
			this.grilleListePersonne.add(new Label(individu.getMail() + ""), 2, item);
			this.grilleListePersonne.add(actionEditerPersonne, 3, item);
			this.grilleListePersonne.add(actionSupprimerPersonne, 4, item);
			item++;
		}this.grilleListePersonne.add(actionAjouterPersonne, 1, item);
	}
}
