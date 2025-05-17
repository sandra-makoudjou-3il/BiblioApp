package operations;

import java.util.Scanner;

import bibliotheque.Bibliotheque;
import utilisateur.Adherent;
import utilisateur.Utilisateur;

public class GestionAdherents {

	static Bibliotheque bibliotheque=Bibliotheque.getInstance();
	
	public static void inscrireAdherent(String nom) {
		
		bibliotheque.addAdherent(nom);
	}
	
	public static Utilisateur chercherAdherent(String nom) {
		
		for(Utilisateur user: bibliotheque.utilisateurs) {
			
			if((user instanceof Adherent) && user.getNom().equals(nom) )
				return user;
		}
		return null;
	}
	
	public static void mettreAJourAdherent(Adherent user, String nom) {
		
		user.setNom(nom);
	}
	
	public static void supprimerAdherent(Adherent user) {
		
		bibliotheque.removeUtilisateur(user);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("1. Ajouter un adherent");
		System.out.println("2. Supprimer un adherent");
		System.out.println("3. rechercher un adherent");
		System.out.println("4. afficher les adherents");
		System.out.print("\nVeuillez saisir un numéro de menu : ");
		
		int choix = scanner.nextInt();  

        System.out.println("Vous avez choisi l'option : " + choix);
        
        switch (choix) {
        case 1:
            System.out.println("\n\t\t→ Ajouter un livre sélectionné");
           
            break;
        case 2:
            System.out.println("\n\t\t→ Supprimer un livre sélectionné");
            
            
            break;
        case 3:
            System.out.println("\n\t\t→ rechercher un livre sélectionné.");
            
            
            break;
        case 4:
            System.out.println("\n\t\t→afficher un livre sélectionné.");
            
            
            break;
        default:
            System.out.println("→ Option non valide.");
        }
        scanner.close(); 
	}
}