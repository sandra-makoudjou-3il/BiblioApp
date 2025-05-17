package amendeStrategy;

import state.EndommageState;
import state.LivreState;

public class LivreEndommage extends Amende{

	@Override
	public float calculAmende(LivreState etat) {
		if(etat instanceof EndommageState) {
			return 20;//20€
		}
		return 0;
	}

}
