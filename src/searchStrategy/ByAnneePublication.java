package searchStrategy;

import java.util.ArrayList;
import java.util.List;

import bibliotheque.Bibliotheque;
import livre.Livre;

public class ByAnneePublication extends SearchStrategy{
	
	@Override
	public List <Livre> executeStrategy(List<Livre> livres, String anneePublication) {
		List <Livre> livreByAnneePublication = new ArrayList<>();
		int i=0;
	    for (Livre livre : livres) {
	        if (livre.getAnneePublication() == Integer.parseInt(anneePublication)) {
	        	livreByAnneePublication.add(livre);
	            System.out.println(livre.toString());
	            i++;
	        }
	    }
	    
	    if (anneePublication.equals(""))
			livreByAnneePublication=livres;
	    
	    if(i==0)
	    	System.out.println("Aucun livre publié en " + anneePublication);
	    
		return livreByAnneePublication;
	}


}
