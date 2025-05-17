package operations;

import livre.Livre;
import utilisateur.Adherent;

public class GestionReservation {

	public static void reserverLivre(Adherent adherent, Livre livre) {
		
		adherent.reserveLivre(livre);
		
	}
	public static void main(String[] args) {
		

	}

}
