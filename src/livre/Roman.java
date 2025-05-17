package livre;
public class Roman extends Livre{


	

	/**
	 * @param nom
	 * @param auteur
	 * @param anneePublication
	 * @param prix
	 */
	public Roman(String nom, String auteur, int anneePublication, float prix) {
		super(nom, auteur, anneePublication,prix);
		
	}



	@Override
	public String toString() {
		return "[Roman]" + super.toString();
		
	}


	

}