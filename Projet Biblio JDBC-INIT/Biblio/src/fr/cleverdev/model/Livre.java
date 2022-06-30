package fr.cleverdev.model;

public class Livre {
	private static long nbLivres=0;
	private long id;
	private Auteur auteur;
	private String titre;
	private int nbPages;
	private String categorie;
	
	public Livre() {};
	
	public Livre(String titre,Auteur auteur,int nbPages,String categorie) { 
    	this.titre = titre;
    	this.auteur = auteur;
    	this.nbPages=nbPages;
    	this.categorie=categorie;
    	Livre.nbLivres++;
    	this.id=Livre.nbLivres;
    }
	
	public void setAuteur(Auteur auteur) {
		this.auteur=auteur;
	}
	
	public void setTitre(String titre) {
		this.titre=titre;
	}
	
	public void setNbPages(int nbPages) {
		this.nbPages=nbPages;
	}
	
	public void setCategorie(String categorie) {
		this.categorie=categorie;
	}
	
	
	public void setId(Long id) {
		this.id=id;
	}
	
	
	public Long getId() {
		return(this.id);
	}
	
	public Auteur getAuteur() {
		return(this.auteur);
	}
	
	public String getTitre() {
		return(this.titre);
	}
	
	public long getNbPages() {
		return(this.nbPages);
	}
	
	public String getCategorie() {
		return(this.categorie);
	}
	
	@Override
	public String toString() {
		String nomAuteur=this.getAuteur().getNom();
		return getId() + " : " + getTitre() +" , nbPages=" + getNbPages() + " / Categorie=" + getCategorie();
	}
	
}
