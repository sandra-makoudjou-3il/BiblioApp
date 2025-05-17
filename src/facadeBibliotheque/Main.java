package facadeBibliotheque;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import operations.GestionLivres;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Image icon = new Image(getClass().getResourceAsStream("/image/logo.png"));
					
			Parent root = FXMLLoader.load(getClass().getResource("/fichiersFXML/MainFXML.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("BIBLIOTHEQUE");
			primaryStage.getIcons().add(icon);
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
