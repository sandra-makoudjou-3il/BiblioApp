package main;

import bibliotheque.Bibliotheque;
import factory.LivreFactory;
import factory.UtilisateurFactory;
import livre.Livre;
import operations.GestionLivres;
import utilisateur.Utilisateur;

public class main {

	public static void main(String[] args) {
		
		try {
			Livre livre1=LivreFactory.createLivre("Thriller", "Alice", "PENLAP", 2010, 15);
			System.out.println(livre1.toString());
			
			livre1.emprunteState();
			livre1.reserveState();
			livre1.disponibleState();
			livre1.nonReserveState();
			livre1.reserveState();
			
			System.out.println(livre1.toString());
		} catch (Exception e) {
			
		}
		
		try {
			Utilisateur user=UtilisateurFactory.createUtilisateur("administrateur", "Alice");
			user.info();
			
			
		} catch (Exception e) {
			
		}
		
	
	}
	

}
