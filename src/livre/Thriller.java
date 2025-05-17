package livre;
public class Thriller extends Livre{
	

	/**
	 * @param nom
	 * @param auteur
	 * @param anneePublication
	 * @param prix
	 */
	public Thriller(String nom, String auteur, int anneePublication, float prix) {
		super(nom, auteur, anneePublication,prix);
	}



	@Override
	public String toString() {
		return "[Thriller]" + super.toString();
		
	}
	

}