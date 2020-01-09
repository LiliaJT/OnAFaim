package model;

import java.util.*;

public class Commande {
	
	private int idCommande; // clé primaire en auto increment
	private int cEval; // null par défaut
	private String cEtat; // "en_attente" par défaut
	private double prixTot; // 0 par défaut
	private int idCompte;
	private List<Panier> panier;
	
	
	public Commande(int idCommande, int cEval, String cEtat, double prixTot, int idCompte, List<Panier> panier) { //
		this.idCommande = idCommande;
		this.cEval = cEval;
		this.cEtat = cEtat;
		this.prixTot = prixTot;
		this.idCompte = idCompte;
		this.panier = panier;
	}


	// Constructeur sans idCommande
	public Commande(int cEval, String cEtat, double prixTot, int idCompte, List<Panier> panier) {
		this.cEval = cEval;
		this.cEtat = cEtat;
		this.prixTot = prixTot;
		this.idCompte = idCompte;
		this.panier = panier;
	}

	
	// Constructeur sans idCommande,cEval 
	public Commande(String cEtat, double prixTot, int idCompte, List<Panier> panier) {
		this.cEtat = cEtat;
		this.prixTot = prixTot;
		this.idCompte = idCompte;
		this.panier = panier;
	}


	public int getcEval() {
		return cEval;
	}


	public void setcEval(int cEval) {
		this.cEval = cEval;
	}


	public double getPrixTot() {
		return prixTot;
	}


	public void setPrixTot(double prixTot) {
		this.prixTot = prixTot;
	}


	public int getIdCompte() {
		return idCompte;
	}


	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}


	public int getIdCommande() {
		return idCommande;
	}


	public String getcEtat() {
		return cEtat;
	}

	public void setcEtat(String cEtat) {
		this.cEtat = cEtat;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}


	public List<Panier> getPanier() {
		return panier;
	}

	public void setPanier(List<Panier> panier) {
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "Commande [idCommande=" + idCommande + ", cEval=" + cEval + ", cEtat=" + cEtat + ", prixTot=" + prixTot
				+ ", idCompte=" + idCompte + ", panier=" + panier + "]";
	}

	
	
	
	
	
	
	
	

}