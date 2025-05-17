package operations;

import utilisateur.Adherent;

import java.time.LocalDate;

import amendeStrategy.LivreEndommage;
import amendeStrategy.PerteLivre;
import amendeStrategy.RetardRemise;
import livre.Livre;

public class GestionAmendes {

	public static void LivreEndommage(Adherent adherent) {
		
		LivreEndommage amende= new LivreEndommage();
		adherent.setAmendeStrategy(amende);
		for(Livre livre:adherent.getLivreEmprunt().keySet()) {
			adherent.setAmendesLivresEndommage(adherent.applyAmendeStrategy(livre.getEtat3Livre()));
		}
	}
	
	public static void PerteLivre(Adherent adherent) {
		
		PerteLivre amende= new PerteLivre();
		adherent.setAmendeStrategy(amende);
		for(Livre livre:adherent.getLivreEmprunt().keySet()) {
			
			adherent.setAmendesPerteLivre(adherent.applyAmendeStrategy(livre.getPrix(), livre.getEtat1Livre()));
		}
		
	}
	
	public static void RetardRemise(Adherent adherent) {
		
		RetardRemise amende= new RetardRemise();
		adherent.setAmendeStrategy(amende);
		for(LocalDate date:adherent.getLivreEmprunt().values()) {
			
			adherent.setAmendesRetardRemise(adherent.applyAmendeStrategy(date));
		}
	}
	public static void main(String[] args) {
		
		
	}

}
