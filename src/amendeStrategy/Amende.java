package amendeStrategy;

import java.time.LocalDate;

import state.LivreState;

public abstract class Amende  {
	
	public float calculAmende(LocalDate date) {
		return 0;
	}
	
	public float calculAmende(LivreState etat) {
		return 0;
	}
	

	public float calculAmende(float prix, LivreState etat) {
		
		return 0;
	}

}
