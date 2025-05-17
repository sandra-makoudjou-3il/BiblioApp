package state;

import livre.Livre;

public class PerduState extends LivreState{
	
	public PerduState(Livre livre) {
		super(livre);
	}
	public void disponiblestate() {
		System.out.println("Action impossible");
	}

	public void emprunteState() {
		System.out.println("Action impossible");
	}
	
	public void enReparationState() {
		System.out.println("Action impossible");
	}
	
	public void reserveState() {
		livre.setEtat2Livre(new ReserveState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void nonReserveState() {
		livre.setEtat2Livre(new NonReserveState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void neufState() {
		System.out.println("Action impossible");
	}
	
	public void endommageState() {
		System.out.println("Action impossible");
	}
	
	public String doAction() {
		return "Etat: perdu";
	}

}
