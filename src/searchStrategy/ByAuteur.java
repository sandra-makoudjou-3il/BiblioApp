package searchStrategy;

import java.util.ArrayList;
import java.util.List;

import bibliotheque.Bibliotheque;
import livre.Livre;

public class ByAuteur extends SearchStrategy {

	
	@Override
	public List<Livre> executeStrategy(List<Livre> livres,String auteur) {
		
		List <Livre> livreByAuteur = new ArrayList<>();
		int i=0;
		for(Livre livre: livres) {
			
			if(livre.getAuteur().toUpperCase().equals(auteur.toUpperCase())) {
				System.out.println(livre.toString());
				livreByAuteur.add(livre);
				i++;
			}
			
		}
		
		if (auteur.equals(""))
			livreByAuteur=livres;
		
		if(i==0)
			System.out.println("Aucun livre de " + auteur);
		return livreByAuteur;
	}
}
