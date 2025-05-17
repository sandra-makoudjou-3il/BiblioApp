package operations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import bibliotheque.Bibliotheque;
import facadeBibliotheque.Main;
import factory.LivreFactory;
import livre.Livre;
import searchStrategy.ByAnneePublication;
import searchStrategy.ByAuteur;
import searchStrategy.ByNom;
import searchStrategy.ByType;

public class GestionLivres {
	
	@FXML
    private TextField typeField;

    @FXML
    private TextField titreField;

    @FXML
    private TextField auteurField;

    @FXML
    private TextField anneeField;

    @FXML
    private TextField prixField;
    
    @FXML
    private ListView<Livre> listViewLivres;
    
    
    ObservableList<Livre> livresObservable = FXCollections.observableArrayList();

 public static Bibliotheque bibliotheque=Bibliotheque.getInstance();
	
 
	
 
	
	
	public static void supprimerLivre(Livre livre) {
		
		
		bibliotheque.removeLivre(livre);
	}
	
	public static void rechercherLivrebyType(String type) {
		
		ByType strategie= new ByType();
		bibliotheque.setSearchStrategy(strategie);
		bibliotheque.applySearchStrategy(bibliotheque.livres, type);
	}
	
	public static void rechercherLivrebyNom(String nom) {
		
		ByNom strategie= new ByNom();
		bibliotheque.setSearchStrategy(strategie);
		bibliotheque.applySearchStrategy(bibliotheque.livres, nom);
	}
	
	public static void rechercherLivrebyAuteur(String auteur) {
		
		ByAuteur strategie= new ByAuteur();
		bibliotheque.setSearchStrategy(strategie);
		bibliotheque.applySearchStrategy(bibliotheque.livres, auteur);
	}
	
	/*public static void rechercherLivrebyAnneePublication(int anneePublication) {
		
		ByAnneePublication strategie= new ByAnneePublication();
		bibliotheque.setSearchStrategy(strategie);
		bibliotheque.applySearchStrategy(bibliotheque.livres, anneePublication);
	}*/
	
	/*public static void afficherLivre() {
		
		bibliotheque.viewLivre();
	}*/
	
	
	
	@FXML
	public void initialize() {
	    if (listViewLivres != null) {
	        listViewLivres.setItems(livresObservable);
	    } else {
	        System.out.println("DEBUG: livresTableView est null.");
	    }
	}


	
	public void livreAAfficher(List<Livre> livre) {
		this.livresObservable = FXCollections.observableArrayList(livre);
        
	}
	public void afficherLivre(ActionEvent event, List<Livre> livres) {
	    try {
	        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fichiersFXML/AfficherLivresFXML.fxml"));
	        Parent root = loader.load();

	        GestionLivres controller = loader.getController();
	        controller.livreAAfficher(livres);   
	        controller.updateListView(); 

	        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        stage.setScene(new Scene(root));
	        stage.show();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public void updateListView() {
	    if (listViewLivres != null && livresObservable != null) {
	        listViewLivres.setItems(livresObservable);
	    }
	}


	
	
	@FXML
	public void retour(ActionEvent event) {
		
		try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fichiersFXML/MainFXML.fxml"));
			Parent root = loader.load();
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(new Scene(root));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@FXML
	public void supprimerLivre(ActionEvent event) {
		
		
		Livre livre = listViewLivres.getSelectionModel().getSelectedItem();
		bibliotheque.removeLivre(livre);
		
		afficherLivre(event,bibliotheque.livres);
	}
	
	/*
	 * Ajout d'un livre
	 */
	
	@FXML
	public void ajouterLivre(ActionEvent event) {
		
		try {
        	FXMLLoader loader = new FXMLLoader(getClass().getResource("/fichiersFXML/AjouterLivreFXML.fxml"));
			Parent root = loader.load();
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	        stage.setScene(new Scene(root));
	        stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        
	}
	
	
	@FXML
	public void validerAjoutLivre(ActionEvent event) {
		
		
		String type = typeField.getText();
		String nom  = titreField.getText();
		String auteur = auteurField.getText();

		int	   annee	= Integer.parseInt(anneeField.getText());
		float  prix		= Float.parseFloat(prixField.getText());
		
	
		try {
		    boolean succes = bibliotheque.addLivre(type, nom, auteur, annee, prix);
		    
		    if (succes) {
		        Alert alert = new Alert(Alert.AlertType.INFORMATION);
		        alert.setTitle("Succès");
		        alert.setHeaderText("Livre ajouté avec succès !");
		        alert.showAndWait();
		    } else {
		        Alert alert = new Alert(Alert.AlertType.ERROR);
		        alert.setTitle("Erreur");
		        alert.setHeaderText("Impossible d'ajouter le livre");
		        alert.setContentText("Le livre existe déjà ou les données sont invalides.");
		        alert.showAndWait();
		    }
		} catch (Exception e) {
		    Alert alert = new Alert(Alert.AlertType.ERROR);
		    alert.setTitle("Erreur");
		    alert.setHeaderText("Une erreur inattendue est survenue");
		    alert.setContentText(e.getMessage());
		    alert.showAndWait();
		}

		afficherLivre(event,bibliotheque.livres);
	}
	
	@FXML
	public void byType(ActionEvent event) {
		
		bibliotheque.setSearchStrategy(new ByType());
		
		afficherLivre(event, bibliotheque.applySearchStrategy(bibliotheque.livres, typeField.getText()));
		
	}
	
	@FXML
	public void byNom(ActionEvent event) {
		
		bibliotheque.setSearchStrategy(new ByNom());
		
		afficherLivre(event, bibliotheque.applySearchStrategy(bibliotheque.livres, titreField.getText()));
		
	}
	
	@FXML
	public void byAuteur(ActionEvent event) {
		
		bibliotheque.setSearchStrategy(new ByAuteur());
		
		afficherLivre(event, bibliotheque.applySearchStrategy(bibliotheque.livres, auteurField.getText()));
		
	}
	@FXML
	public void byAnneePublication(ActionEvent event) {
		
		bibliotheque.setSearchStrategy(new ByAnneePublication());
		
		afficherLivre(event, bibliotheque.applySearchStrategy(bibliotheque.livres, anneeField.getText()));
		
	}
	
	/*
	 * Affichage des livres
	 */
	
   

    
	
	
	
	
	/*public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); 
		int choix=0;
		do {
			System.out.println("1. Ajouter un livre");
			System.out.println("2. Supprimer un livre");
			System.out.println("3. rechercher un livre");
			System.out.println("4. afficher les livres");
			System.out.print("\nVeuillez saisir un numéro de menu : ");
			
			choix = scanner.nextInt();  

	        System.out.println("Vous avez choisi l'option : " + choix);
	        
	        switch (choix) {
	        case 1:
	            System.out.println("→ Ajouter un livre sélectionné");
	            System.out.println("\n\n*******************Ajouter un livre *******************");
	            
	            System.out.println("\n Entrez le type de votre livre :");
	            String type=scanner.next();
	            
	            System.out.println("\n Entrez le nom de votre livre :");
	            String nom=scanner.next();
	            
	            System.out.println("\n Entrez l'auteur de votre livre :");
	            String auteur=scanner.next();
	            
	            System.out.println("\n Entrez l'année de publication de votre livre :");
	            int annee=scanner.nextInt();
	            
	            System.out.println("\n Entrez le prix de votre livre :");
	            float prix=scanner.nextFloat();
	            
	            ajouterLivre(type,nom,auteur,annee,prix);
	            
	            
	            break;
	        case 2:
	            System.out.println("\n\t\t→ Supprimer un livre sélectionné");
	            System.out.println("\n\n*******************Supprimer un livre *******************");
	            
	            System.out.println("\n Entrez le type du livre que vous voulez supprimer :");
	             type=scanner.next();
	            
	            System.out.println("\n Entrez le nom du livre que vous voulez supprimer :");
	             nom=scanner.next();
	            
	            System.out.println("\n Entrez l'auteur du livre que vous voulez supprimer :");
	             auteur=scanner.next();
	            
	            System.out.println("\n Entrez l'année du livre que vous voulez supprimer :");
	            annee=scanner.nextInt();
	            
	            System.out.println("\n Entrez le prix du livre que vous voulez supprimer :");
	             prix=scanner.nextFloat();
	            
	            Livre livre = LivreFactory.createLivre(type, nom, auteur, annee, prix);
	            
	            if(bibliotheque.isPresentLivre(livre)) {
	            	supprimerLivre(livre);
	            } else {
	            	System.out.println("\n Ce livre n'existe pas \n \nVeuillez vérifier les informations de votre livre en vous rendant dans le menu recherche livre \n");
	            }
	            
	            break;
	        case 3:
	        	int ch=0;
	            do {
	            	System.out.println("\n\t\t→ rechercher un livre sélectionné.");
		            
		            
		            
		            System.out.println("1. Rechercher un livre par son type");
		    		System.out.println("2. Rechercher un livre par son nom");
		    		System.out.println("3. Rechercher un livre par son auteur");
		    		System.out.println("4. Rechercher un livre par son année de publication");
		    		System.out.println("5. Menu précédent");
		    		System.out.print("\nVeuillez saisir un numéro de menu : ");  
		    		
		    		ch = scanner.nextInt();
		            System.out.println("Vous avez choisi l'option : " + ch);
		            
		            switch(ch){
		            
		            	case 1 :
		            		System.out.println("\n Entrez le type du livre recherché : ");
		            		 type=scanner.next();
		            		rechercherLivrebyType(type);
		            		break;
		            	
		            	case 2 :
		            		System.out.println("\n Entrez le nom du livre recherché : ");
		           		 	nom=scanner.next();
		           		 	rechercherLivrebyNom(nom);
		           		 	break;
		           		
		            	case 3 :
		            		System.out.println("\n Entrez l'auteur du livre recherché : ");
		            		auteur=scanner.next();
		            		rechercherLivrebyAuteur(auteur);
		            		break;
		            		
		            	case 4 :
		            		System.out.println("\n Entrez l'année de publication du livre recherché : ");
		            		annee=scanner.nextInt();
		            		rechercherLivrebyAnneePublication(annee);
		            		break;
		            		
		            	case 5:
		            		System.out.println("\n Menu précédent");
		            		break;
		            	
		            	default:
		     	           System.out.println("→ Option non valide.");
		            	
		            	
		            }
		        	
		            
		            
		            break;
	            }while(ch!=5);
	            break;
	            
	        case 4:
	            System.out.println("→afficher un livre sélectionné.\n");
	            System.out.println("\n\n******************* Afficher la liste des livres *******************\n");
	            
	            afficherLivre();
	            break;
	            
	        case 5:
        		System.out.println("\n Menu précédent");
        		break;
        		
	        default:
	            System.out.println("→ Option non valide.");
	        }
	        System.out.println("\n\n");
	       
		}while(choix!=5);
		
		 scanner.close(); 
		}*/
}
