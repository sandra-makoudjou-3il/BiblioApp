package utilisateur;

import notification.Observer;

public class Administrateur extends Utilisateur implements Observer {

	

	/**
	 * @param nom
	 */
	public Administrateur(String nom) {
		super(nom);
		
	}

	@Override
	public void info() {
		System.out.println("Admin:  " + super.nom);
		
	}

	@Override
	public void update(String message) {
		
		System.out.println(super.nom + "vous avez reçcu un nouveau message:" + message);
	}

}