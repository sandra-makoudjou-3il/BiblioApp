package state;

import livre.Livre;

public abstract class LivreState {
	
	protected Livre livre;
	public LivreState(Livre livre) {
		this.livre= livre;
	}
	public void disponiblestate() {
	}

	public void emprunteState() {
	}

	public void enReparationState() {
	}
	
	public void reserveState() {
	}
	
	public void nonReserveState() {
	}
	
	public String doAction() {
		return null;
	}

}
