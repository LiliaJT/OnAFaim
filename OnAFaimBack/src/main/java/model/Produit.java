package model;

public class Produit {

	private int idProduit;
	private String type;
	private String taille;
	private double prix;
	private String libelle;
	

	public Produit(String type, String taille, double prix, String libelle) {
		this.type = type;
		this.taille = taille;
		this.prix = prix;
		this.libelle = libelle;
	}
	
		

	public Produit(int idProduit, String type, String taille, double prix, String libelle) {
		this.idProduit = idProduit;
		this.type = type;
		this.taille = taille;
		this.prix = prix;
		this.libelle = libelle;
	}

	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public int getIdProduit() {
		return idProduit;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaille() {
		return taille;
	}

	public void setTaille(String taille) {
		this.taille = taille;
	}

	public double getPrix() {
		return prix;
	}
	
	public void setPrix() {
		this.prix = prix;
	}



	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", type=" + type + ", taille=" + taille + ", prix=" + prix
				+ ", libelle=" + libelle + "]";
	}

	
	
	
	
	
	
}
