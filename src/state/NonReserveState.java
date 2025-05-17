package state;

import livre.Livre;

public class NonReserveState extends LivreState {
	
	public NonReserveState(Livre livre) {
		super(livre);
	}
	
	public void disponiblestate() {
		livre.setEtat1Livre(new DisponibleState(livre));
		System.out.println("Action effectuée avec succès");
	}

	public void emprunteState() {
		livre.setEtat1Livre(new EmprunteState(livre));
		System.out.println("Action effectuée avec succès");
	}

	public void enReparationState() {
		livre.setEtat1Livre(new EnReparationState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void reserveState() {
		livre.setEtat2Livre(new ReserveState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void nonReserveState() {
		System.out.println("Action impossible(état actuel)");
	}
	
	public String doAction() {
		return ", non réservé";
	}
}
