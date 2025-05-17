package bibliotheque;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import searchStrategy.ByNom;
import searchStrategy.SearchStrategy;
import factory.LivreFactory;
import factory.UtilisateurFactory;
import livre.Livre;
import notification.Observer;
import operations.GestionLivres;
import utilisateur.Utilisateur;

public class Bibliotheque {

	private static Bibliotheque instance;
	public  List<Livre> livres ;
	public List<Utilisateur> utilisateurs;
	private SearchStrategy searchStrategy;
	
	
	/**
	 * @param livres
	 * @param utilisateurs
	 */
	public Bibliotheque() {
		super();
		this.livres = new ArrayList<>();
		this.utilisateurs = new ArrayList<>();
	}
	


	public static Bibliotheque getInstance() {
        if (instance == null) {
        	instance =new Bibliotheque();
        }
        return instance;
	}

	
	public boolean addLivre(String type, String nom, String auteur, int anneePublication, float prix) {
	    Livre livre = LivreFactory.createLivre(type, nom, auteur, anneePublication, prix);
	    if (livre == null) {
	        throw new IllegalArgumentException("La création du livre a échoué : type invalide ou données incorrectes.");
	    }
	    livres.add(livre);
	    return true;
	}

	
	public Boolean isPresentLivre(Livre livre) {
		return livres.contains(livre);
	}
	
	public void removeLivre(Livre livre) {
		
		livres.remove(livre);
	}
	
	
	public void setSearchStrategy(SearchStrategy searchStrategy) {
		this.searchStrategy= searchStrategy;
	}
	
	
	public List <Livre> applySearchStrategy(List<Livre> livres,String string) {
		return searchStrategy.executeStrategy(livres,string);
	}
	
	public void viewLivre() {
		
		for(Livre livre: this.livres) {
			System.out.println(livre.toString());
		}
	}
	
	public void addAdherent(String nom) {
		try {
			utilisateurs.add(UtilisateurFactory.createUtilisateur(nom, "ADHERENT"));
		} catch(Exception e) {
			
		}
	}
	
	public void addAdmin(String nom) {
		try {
			utilisateurs.add(UtilisateurFactory.createUtilisateur(nom, "ADMIN"));
		} catch(Exception e) {
			
		}
	}
	
	public void removeUtilisateur(Utilisateur Utilisateur) {
		
		utilisateurs.remove(Utilisateur);
	}
	
	public static void main(String[] args) throws Exception {
		
		Bibliotheque bibliotheque=Bibliotheque.getInstance();
		bibliotheque.addLivre("THRILLER", "a", "b",1,2);
		bibliotheque.viewLivre();
		
	}
	
	
	

}
