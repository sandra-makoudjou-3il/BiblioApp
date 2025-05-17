package livre;
public class ScienceFiction extends Livre{

	

	/**
	 * @param nom
	 * @param auteur
	 * @param anneePublication
	 * @param prix
	 */
	public ScienceFiction(String nom, String auteur, int anneePublication, float prix) {
		super(nom, auteur, anneePublication,prix);
	}



	@Override
	public String toString() {
		return "[ScinenceFiction]" + super.toString();
		
	}
	

}