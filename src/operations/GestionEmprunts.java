package operations;

import java.util.Scanner;

import livre.Livre;
import utilisateur.Adherent;

public class GestionEmprunts {

	
	public static void emprunterLivre(Adherent adherent, Livre livre) {
		
		adherent.emprunteLivre(livre);
		
	}
	
	public static void rendreLivre(Adherent adherent, Livre livre) {
		
		adherent.rendreLivre(livre);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1.emprunterLivre");
		System.out.println("2.rendreLivre");
		System.out.print("\nVeuillez saisir un numéro de menu : ");
		
		int choix = scanner.nextInt();  

        System.out.println("Vous avez choisi l'option : " + choix);
        
        switch (choix) {
        case 1:
        	System.out.println("\n\t\t→ Emprunter un livre sélectionné");
        	
        	break;
        case 2:
        	System.out.println("\n\t\t→ Rendre un livre sélectionné");
        	
        	break;
        default:
            System.out.println("→ Option non valide.");
        }
        
        scanner.close();
        	
        	
		

	}

}
