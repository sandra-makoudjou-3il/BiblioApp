package livre;

import java.time.LocalDate;

import state.DisponibleState;
import state.LivreState;
import state.NeufState;
import state.NonReserveState;

public abstract class Livre {

	private String nom;
	private String auteur;
	private int anneePublication;
	private float prix;
	
	public LivreState[] etatLivre;
	
	
		
	/**
	 * @param etatLivre
	 */
	public Livre(String nom, String auteur, int anneePublication, float prix) {
		super();
		
		this.nom = nom;
		this.auteur = auteur;
		setAnneePublication(anneePublication);
		this.prix=prix;
		this.etatLivre = new LivreState[3];
        
        
        this.etatLivre[0] = new DisponibleState(this); 
        this.etatLivre[1] = new NonReserveState(this); 
        this.etatLivre[2] = new NeufState(this);
		
	}

	
	public String toString() {
		return this.nom +"   " + etatLivre[0].doAction() + etatLivre[1].doAction() +etatLivre[2].doAction();
	}


	
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getAuteur() {
		return auteur;
	}


	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}


	public int getAnneePublication() {
		return anneePublication;
	}


	public void setAnneePublication(int anneePublication) throws IllegalArgumentException{
		
		if(anneePublication> LocalDate.now().getYear())
			throw new IllegalArgumentException("Annee invalide.");
		this.anneePublication = anneePublication;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public void setEtat1Livre(LivreState etatLivre) {
		this.etatLivre[0] = etatLivre;
	}
	
	public void setEtat2Livre(LivreState etatLivre) {
		this.etatLivre[1] = etatLivre;
	}
	
	public void setEtat3Livre(LivreState etatLivre) {
		this.etatLivre[2] = etatLivre;
	}
	
	public LivreState getEtat1Livre() {
		return this.etatLivre[0];
	}
	
	public LivreState getEtat2Livre() {
		return this.etatLivre[1];
	}
	
	public LivreState getEtat3Livre() {
		return this.etatLivre[1];
	}

	public void disponibleState() {
		
		etatLivre[0].disponiblestate();
	}
	
	public void emprunteState() {
		
		etatLivre[0].emprunteState();
	}
	
	public void enReparationState() {
		
		etatLivre[0].enReparationState();
	}
	
	public void reserveState() {
		
		etatLivre[0].reserveState();
	}
	
	public void nonReserveState() {
	
		etatLivre[0].nonReserveState();
	}
	
	

	
}