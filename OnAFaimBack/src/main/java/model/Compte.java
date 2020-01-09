package model;

public class Compte {

	private int idCompte; 
	private String nom; 
	private String mdp; 
	private String email; 
	private String type; 
	private String compteEtat;
	
	
	public Compte(int idCompte, String nom, String mdp, String email, String type, String compteEtat) {
		this.idCompte = idCompte;
		this.nom = nom;
		this.mdp = mdp;
		this.email = email;
		this.type = type;
		this.compteEtat = compteEtat;
	}

	public Compte(int idCompte, String nom, String email, String type, String compteEtat) {
		this.idCompte = idCompte;
		this.nom = nom;
		this.email = email;
		this.type = type;
		this.compteEtat = compteEtat;
	}

	public Compte(String nom, String mdp, String email, String type, String compteEtat) {
		this.nom = nom;
		this.mdp = mdp;
		this.email = email;
		this.type = type;
		this.compteEtat = compteEtat;
	}
	
	public Compte(String nom, String mdp) {
		this.nom = nom;
		this.mdp = mdp;
	}
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getMdp() {
		return mdp;
	}


	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCompteEtat() {
		return compteEtat;
	}


	public void setCompteEtat(String compteEtat) {
		this.compteEtat = compteEtat;
	}


	public int getIdCompte() {
		return idCompte;
	}


	@Override
	public String toString() {
		return "Compte [idCompte=" + idCompte + ", nom=" + nom + ", mdp=" + mdp + ", email=" + email + ", type="
				+ type + ", compteEtat=" + compteEtat + "]";
	}
}