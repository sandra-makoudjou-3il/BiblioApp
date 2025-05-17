package factory;

import livre.Livre;
import livre.Policier;
import livre.Roman;
import livre.ScienceFiction;
import livre.Thriller;
import livre.TypeLivre;

public class LivreFactory {

	/**
	 * 
	 * @param string
	 * @param nom
	 * @param auteur
	 * @param anneePublication
	 */
	public static Livre createLivre(String type, String nom, String auteur, int anneePublication, float prix) {
	    try {
	        TypeLivre typeLivre = TypeLivre.valueOf(type.toUpperCase());
	        switch (typeLivre) {
	            case ROMAN:
	                return new Roman(nom, auteur, anneePublication, prix);
	            case POLICIER:
	                return new Policier(nom, auteur, anneePublication, prix);
	            case THRILLER:
	                return new Thriller(nom, auteur, anneePublication, prix);
	            case SCIENCEFICTION:
	                return new ScienceFiction(nom, auteur, anneePublication, prix);
	            default:
	                throw new IllegalArgumentException("Type non pris en charge. Veuillez utiliser ROMAN, POLICIER, THRILLER, SCIENCEFICTION.");
	        }
	    } catch (IllegalArgumentException e) {
	        
	    	throw new IllegalArgumentException(e.getMessage());
	        
	    }
	}

	
}