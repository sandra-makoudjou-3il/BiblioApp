package state;

import livre.Livre;

public class ReserveState extends LivreState{

	
	public ReserveState(Livre livre) {
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
		System.out.println("Action impossible");
	}
	
	public void reserveState() {
		System.out.println("Action impossible(état actuel)");
	}
	
	public void nonReserveState() {
		livre.setEtat2Livre(new NonReserveState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public String doAction() {
		return ", réservé";
	}
}
