package searchStrategy;

import java.util.ArrayList;
import java.util.List;

import bibliotheque.Bibliotheque;
import livre.Livre;
import livre.Policier;
import livre.Roman;
import livre.ScienceFiction;
import livre.Thriller;

public class ByType extends SearchStrategy {

	@Override
	public List<Livre> executeStrategy(List<Livre> livres,String type) {
		
		List <Livre> livreByType= new ArrayList<>(); 
		int i=0;
		if(type.toUpperCase().equals("ROMAN")) {
			for(Livre livre: livres) {
				if(livre instanceof Roman) {
					System.out.println(livre.toString());
					livreByType.add(livre);
					i++;
				}
					
			}
		}
		
		if(type.toUpperCase().equals("POLICIER")) {
			for(Livre livre: livres) {
				if(livre instanceof Policier) {
					System.out.println(livre.toString());
					livreByType.add(livre);
					i++;
				}
					
			}
		}
		
		if(type.toUpperCase().equals("SCIENCEFICTION")) {
			for(Livre livre: livres) {
				if(livre instanceof ScienceFiction) {
					System.out.println(livre.toString());
					livreByType.add(livre);
					i++;
				}
					
			}
		}
		
		if(type.toUpperCase().equals("THRILLER")) {
			for(Livre livre: livres) {
				if(livre instanceof Thriller) {
					System.out.println(livre.toString());
					livreByType.add(livre);
					i++;
				}
					
			}
		}
		
		if(type.equals(""))
			livreByType=livres;
		
		if(i==0)
			System.out.println("Aucun livre dans la catégorie: " + type);
		return livreByType;
		
	}

	

}
