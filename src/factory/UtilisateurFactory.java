package factory;

import utilisateur.Adherent;
import utilisateur.Administrateur;
import utilisateur.TypeUtilisateur;
import utilisateur.Utilisateur;

public class UtilisateurFactory {

	/**
	 * 
	 * @param nom
	 * @param role
	 */
	
	public static Utilisateur createUtilisateur(String role, String nom) {
		
		try {
			TypeUtilisateur typeUtilisateur = TypeUtilisateur.valueOf(role.toUpperCase()); 
			switch(typeUtilisateur) {
			case ADHERENT:
				return new Adherent(nom);
				
			case ADMINISTRATEUR:
				return new Administrateur(nom);
				
			default:
			    throw new IllegalArgumentException("Rôle non pris en charge.");
			}
		} catch (Exception e) {
			System.err.println("Erreur : Entrez un type de livre existant (ADMINISTRATEUR, ADHERENT).");
			return null;
		}
		
		
	}
	
	

}