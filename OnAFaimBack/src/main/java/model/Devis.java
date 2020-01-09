package model;

public class Devis {

	private int idDevis;
	private int dEval;
	private Compte c;
	private String dEtat;
	private String quoi;
	private Double prix;
	
	public Devis(int idDevis, int dEval, Compte c, String dEtat, String quoi, Double prix) {
		this.idDevis = idDevis;
		this.dEval = dEval;
		this.c = c;
		this.dEtat = dEtat;
		this.quoi = quoi;
		this.prix = prix;
	}
	
	public Devis(int dEval, Compte c, String dEtat, String quoi, Double prix) {
		this.dEval = dEval;
		this.c = c;
		this.dEtat = dEtat;
		this.quoi = quoi;
		this.prix = prix;
	}

	public int getdEval() {
		return dEval;
	}

	public void setdEval(int dEval) {
		this.dEval = dEval;
	}

	public Compte getC() {
		return c;
	}

	public void setC(Compte c) {
		this.c = c;
	}

	public String getdEtat() {
		return dEtat;
	}

	public void setdEtat(String dEtat) {
		this.dEtat = dEtat;
	}

	public String getQuoi() {
		return quoi;
	}

	public void setQuoi(String quoi) {
		this.quoi = quoi;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getIdDevis() {
		return idDevis;
	}

	@Override
	public String toString() {
		return "Devis [idDevis=" + idDevis + ", dEval=" + dEval + ", dEtat=" + dEtat + ", quoi=" + quoi + ", prix="
				+ prix + "]";
	} 
	
	
	
	
}
