package state;

import livre.Livre;

public class EnReparationState extends LivreState{

	public EnReparationState(Livre livre) {
		super(livre);
	}
	public void disponiblestate() {
		livre.setEtat1Livre(new DisponibleState(livre));
		System.out.println("Action effectuée avec succès");
	}

	public void emprunteState() {
		System.out.println("Action impossible");
	}

	public void enReparationState() {
		System.out.println("Action impossible(état actuel)");
	}
	
	public void reserveState() {
		System.out.println("Action impossible");
	}
	
	public void nonReserveState() {
		livre.setEtat2Livre(new NonReserveState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void neufState() {
		livre.setEtat3Livre(new NeufState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void endommageState() {
		livre.setEtat3Livre(new EndommageState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public String doAction() {
		return "Etat: en réparation"; 
	}
}
