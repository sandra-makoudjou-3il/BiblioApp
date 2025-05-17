package state;

import livre.Livre;

public class NeufState extends LivreState{
	
	public NeufState(Livre livre) {
		super(livre);
	}
	public void disponiblestate() {
		System.out.println("Action impossible");
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
		System.out.println("Action impossible");
	}
	
	public void nonReserveState() {
		livre.setEtat2Livre(new NonReserveState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void neufState() {
		System.out.println("Action impossible(état actuel)");
	}
	
	
	public String doAction() {
		return ", neuf";
	}

}
