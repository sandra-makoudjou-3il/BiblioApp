package state;

import livre.Livre;

public class DisponibleState extends LivreState{
	
	public DisponibleState(Livre livre) {
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
		livre.setEtat3Livre(new NeufState(livre));
		System.out.println("Action effectuée avec succès");
	}
	
	public void endommageState() {
		System.out.println("Action impossible");
	}
	
	public String doAction() {
		return "Etat: disponible";
	}

}
