package facadeBibliotheque;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import livre.Livre;

import java.io.IOException;

import bibliotheque.Bibliotheque;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import operations.GestionLivres;
import operations.GestionAdherents;
import operations.GestionEmprunts;
import operations.GestionReservation;
import operations.GestionAmendes;
import operations.GestionReglesPrets;
import operations.GestionReporting;

public class MonController {

	public static Bibliotheque bibliotheque = Bibliotheque.getInstance();

	@FXML
	private void handleLivres( ActionEvent event ) {

		try {
			FXMLLoader	loader	= new FXMLLoader( getClass().getResource( "/fichiersFXML/AfficherLivresFXML.fxml" ) );
			Parent		root	= loader.load();
			Stage		stage	= (Stage) ( (Node) event.getSource() ).getScene().getWindow();
			stage.setScene( new Scene( root ) );
			stage.show();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void handleAdherents( ActionEvent event ) {

		try {
			FXMLLoader	loader	= new FXMLLoader( getClass().getResource( "/fichiersFXML/AdherentFXML.fxml" ) );
			Parent		root	= loader.load();

			Stage stage = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
			stage.setScene( new Scene( root ) );
			stage.show();
		} catch ( IOException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void handleEmprunts( ActionEvent event ) {
		GestionEmprunts.main( new String[0] );
	}

	@FXML
	private void handleReservations( ActionEvent event ) {
		GestionReservation.main( new String[0] );
	}

	@FXML
	private void handleAmendes( ActionEvent event ) {
		GestionAmendes.main( new String[0] );
	}

	@FXML
	private void handleRegles( ActionEvent event ) {
		GestionReglesPrets.main( new String[0] );
	}

	@FXML
	private void handleReporting( ActionEvent event ) {
		GestionReporting.main( new String[0] );
	}

	@FXML
	private void handlePersistence( ActionEvent event ) {

		System.out.println( "Persistence non encore implémentée." );
	}
}
