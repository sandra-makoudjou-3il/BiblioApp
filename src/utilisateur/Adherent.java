package utilisateur;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import amendeStrategy.Amende;
import bibliotheque.Bibliotheque;
import livre.Livre;
import searchStrategy.SearchStrategy;
import state.LivreState;

public class Adherent extends Utilisateur{
	public Amende amende;
	List <Livre> livreReserve;
	Map <Livre,LocalDate> livreEmprunt;
	
	float amendes[];
	
	/**
	 * @param nom
	 * @param livreEmprunt
	 * @param livreReserve
	 * @param amendes
	 */
	public Adherent(String nom) {
		super(nom);
		this.livreReserve	= new ArrayList<>();
		this.livreEmprunt	= new HashMap<>();
		this.amendes		= new float[3];
	}
	
	
	
	@Override
	public void info() {
		System.out.println("Adhérent:  " + super.nom);
		
	}
	
	public void emprunteLivre(Livre livre) {
		
		if(livreReserve.contains(livre)) {
			
			livre.nonReserveState();
			livreReserve.remove(livre);
		}
		
		livre.emprunteState();
		LocalDate dateLim = LocalDate.now().plusMonths(2);
		livreEmprunt.put(livre,dateLim);
	}
	
	
	public Map<Livre, LocalDate> getLivreEmprunt() {
		return livreEmprunt;
	}



	public void reserveLivre(Livre livre) {
		
		
		livre.reserveState();
		livreReserve.add(livre);
	}
	
	
	public void rendreLivre(Livre livre) {
		
		livre.disponibleState();
		livreEmprunt.remove(livre);

	}
	
	
	
	public void setAmendeStrategy(Amende amende) {
		this.amende= amende;
	}
	
	public float applyAmendeStrategy(LivreState etat) {
		return amende.calculAmende(etat);
	}
	
	public float applyAmendeStrategy(LocalDate date) {
		return amende.calculAmende(date);
	}
	
	public float applyAmendeStrategy(float prix, LivreState etat) {
		return amende.calculAmende(prix, etat);
	}



	public void setAmendesLivresEndommage(float amende) {
		this.amendes[0]=amende;
	}
	
	public void setAmendesPerteLivre(float amende) {
		this.amendes[1]=amende;
		
	}
	
	public void setAmendesRetardRemise(float amende) {
		this.amendes[2]=amende;
		
	}



}