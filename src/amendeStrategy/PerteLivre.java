package amendeStrategy;

import state.LivreState;
import state.PerduState;

public class PerteLivre extends Amende{

	@Override
	public float calculAmende(float prix,LivreState etat) {
		if(etat instanceof PerduState ) {
			return prix;
		}
		return 0;
		
	}

}
