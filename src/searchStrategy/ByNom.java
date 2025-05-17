package searchStrategy;

import java.util.ArrayList;
import java.util.List;

import bibliotheque.Bibliotheque;
import livre.Livre;

public class ByNom extends SearchStrategy {

	@Override
	public List<Livre> executeStrategy(List<Livre> livres,String nom) {
		
		int i=0;
		List <Livre> livreByNom =  new ArrayList<>();
		for(Livre livre: livres) {
			
			if(livre.getNom().toUpperCase().equals(nom.toUpperCase())) {
				System.out.println(livre.toString());
				livreByNom.add(livre);
				i++;
			}
			
		}
		
		if(nom.equals(""))
			livreByNom = livres;
		
		if(i==0)
			System.out.println("Aucun livre nommé : " + nom);
		
		return livreByNom;
		
	}

	

}
