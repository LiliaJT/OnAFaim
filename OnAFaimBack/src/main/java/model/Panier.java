package model;

public class Panier {
	
	private Commande idCom; //Est-ce que c'est juste ? 
	private Produit idProd;
	private int qte;
	
	public Panier(Commande idCom, Produit idProd, int qte) {
		this.idCom = idCom;
		this.idProd = idProd;
		this.qte = qte;
	}
	public Panier() {
		
	}


	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Commande getIdCom() {
		return idCom;
	}

	public Produit getIdProd() {
		return idProd;
	}
	
	

	
	
	@Override
	public String toString() {
		return "Panier [idProd=" + idProd + ", qte=" + qte + "]";
	}
	public void afficheP() {
		System.out.println("Voici le panier:");
		System.out.println("Commande numero" + idCom.getIdCommande());
		System.out.println("Produit" + idProd.getType());
	}
	
	
	
	
	
	
	
	
	
	
}
