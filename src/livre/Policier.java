package livre;
public class Policier extends Livre{

	

	

	/**
	 * @param nom
	 * @param auteur
	 * @param anneePublication
	 */
	public Policier(String nom, String auteur, int anneePublication,float prix) {
		super(nom, auteur, anneePublication,prix);
	}



	@Override
	public String toString() {
		return "[Policier]" + super.toString();
		
	}



	
	

}