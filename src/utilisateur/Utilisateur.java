package utilisateur;
public abstract class Utilisateur {

	protected String nom;
	
	
	/**
	 * @param nom
	 */
	public Utilisateur(String nom) {
		super();
		this.nom = nom;
	}
	
	


	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public void info() {
		
	}

}