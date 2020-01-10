package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.*;
import model.Compte;
import model.Devis;
import model.Produit;

public class test {

	public static int saisieInt(String msg) {
		Scanner sc= new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}


	public static double saisieDouble(String msg) {
		Scanner sc= new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}


	public static String saisieString(String msg) {
		Scanner sc= new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	private static void menu() throws ClassNotFoundException, SQLException {

		int choix = 0; 

		System.out.println("Bienvenue à la boulangerie Miam !\nQue voulez-vous faire ?");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Creer un compte");

		try 
		{
			choix = saisieInt(""); 

		}
		catch (Exception e) {}

		switch(choix) 
		{
		case 1: menuConnect(); break;
		case 2: menuCreer();break;
		default : System.out.println("Choix invalide");menu();
		}

	}

	private static void menuConnect() throws ClassNotFoundException, SQLException  {
		String nom = "";
		String password = "";

		DAOCompteJDBC daoC = new DAOCompteJDBC();

		nom=saisieString("Saisir votre login");
		password=saisieString("Saisir password");
		Compte connexion=daoC.checkConnect(nom, password);

		if(connexion==null) {System.out.println("Compte invalide");menuConnect();}
		else if(connexion.getType().equals("client")) 
		{
			menuClient();
		}
		else if(connexion.getType().equals("admin")) 
		{
			menuAdmin();
		}
	}

	
	private static void menuCreer() {
		System.out.println("Créez votre compte : ");
		String nom = "";
		String mdp = "";
		String email = "";
		try {
			nom=saisieString("Choisissez votre nom : ");
			mdp=saisieString("Choisissez votre mot de passe : ");
			email=saisieString("Entrez votre adresse mail : ");
			Compte c = new Compte(nom,mdp,email,"client","en_attente");
			DAOCompteJDBC daoC = new DAOCompteJDBC();
			daoC.insert(c);
		}
		catch(Exception e) {
			System.out.println("Problème dans la saisie de nom/mdp/mail");
		}
		System.out.println("Vous êtes inscrit");
		menuClient();
	}	
	
	
	private static void menuClient() {
		System.out.println("T'es client");

		int choix = 0; 
		
		System.out.println("Que souhaitez-vous faire ?");
		System.out.println("1- Commander");
		System.out.println("2- Voir la carte");
		System.out.println("3- Voir sa commande");
		System.out.println("4- Modifier sa commande");
		System.out.println("5- Voir son devis");
		System.out.println("6- Modifier son devis");
		System.out.println("7- Annuler sa commande, uniquement si elle est en attente");
		System.out.println("8- Annuler son devis, uniquement s'il est en attente");
		System.out.println("9- Deconnexion");
		
		try 
		{
			choix = saisieInt(""); 
			
		}
		catch (Exception e)
		{
			System.out.println("Merci de saisir un chiffre");
		}
		
		switch (choix)
		{
		case 1: System.out.println("commander");break;
		case 2: System.out.println("voir carte");break;
		case 3: System.out.println("voir commande :");break;
		case 4: System.out.println("modifier commande");break;
		case 5: System.out.println("voir devis");break;
		case 6: System.out.println("modifier devis");break;
		case 7: System.out.println("annuler commande"); annulerCommande(); break;
		case 8: System.out.println("annuler devis"); annulerDevis(); break;
		case 9: System.out.println("Connexion lost...");break;
		default : System.out.println("Choix invalide");
		}
		
	}

	
	private static void annulerCommande() 
	{
		if () {
			
		}
	}
	
	
	private static void annulerDevis() 
	{
		
	}
	
	
	
	private static void menuAdmin() {
		int choix = 0;
		
		System.out.println("Que voulez vous faire ?");
		System.out.println("1- Modifier le statut d'un compte");
		System.out.println("2- Voir commande");
		System.out.println("3- Modifier l'état d'une commande");
		System.out.println("4- Voir un devis");
		System.out.println("5- Modifier un devis");
		System.out.println("6- Voir un produit");
		System.out.println("7- Modifier un produit");
		System.out.println("8- Se déconnecter");
		
		try 
		{
			choix=saisieInt("");
		}
		catch(InputMismatchException e) {System.out.println("Merci de saisir un chiffre !");}
		
		switch(choix) 
		{
		case 1: System.out.println("modifier compte");break;
		case 2: System.out.println("voir commande");break;
		case 3: System.out.println("modifier etat commande :");break;
		case 4: System.out.println("voir devis");break;
		case 5: System.out.println("modifier devis");break;
		case 6: System.out.println("voir produit");voirProduit();break;
		case 7: System.out.println("modifier produit");modifierProduit();break;
		case 8: System.out.println("Connexion lost...");break;
		default : System.out.println("Choix invalide");
		}
	}
	
	
	private static void voirDevis()  
    {
        System.out.println("Voici la liste des Devis :");
        DAODevisJDBC daoD = new DAODevisJDBC();
        List<Devis> listeDevis= new ArrayList();
        try {
			listeDevis= daoD.selectAll();
			} 
        catch (Exception e) 
        {
			System.out.println("Erreur dans voir produit");
		}
        System.out.println(listeDevis);
        
        menuAdmin();
    }
	
	
	private static void modifierDevis() {
		try {
			DAODevis daoD = new DAODevis();
			int idDevis = saisieInt("Entrer l'id du devis");
			int dEval = saisieInt("Entrez l'évaluation, note entre 0 et 5");
			String dEtat = saisieString("Entrez l'état du produit (en_attente ou valide)");
			double prix = saisieDouble("Entrez le prix");
			String quoi = saisieString("Entrez votre demande de devis");
			
			DAOCompte daoC = new DAOCompte();
			Compte c = null;
			int idCompte=
			c = daoC.selectById(idCompte);
			Devis d = new Devis(dEval, c, dEtat, quoi, prix);
			System.out.println(d);
			daoD.update(d);
		}
		catch (Exception e) {
			System.out.println("Erreur modif devis");
		}
		menuAdmin();
	}
	
	
	private static void modifierProduit() {
		try {
			DAOProduitJDBC daoP = new DAOProduitJDBC();
			System.out.println("------------------------------------------------------");
			System.out.println("Ex de prodit : 1 chocolatine grand 1.5");
			System.out.println("------------------------------------------------------");
			int idProduit = saisieInt("Entrez l'id");
			String type = saisieString("Entrez le type de produit");
			String taille = saisieString("Entrez la taille du produit");
			double prix = saisieDouble("Entrez le prix");
			Produit p = new Produit(idProduit, type, taille, prix);
			System.out.println(p);
			daoP.update(p);
		}
		catch (Exception e) {
			System.out.println("Erreur modif produit");
		}
		
		menuAdmin();
	}
	
	
	private static void voirProduit()  
    {
        System.out.println("Voici la liste des produits :");
        DAOProduitJDBC daoP = new DAOProduitJDBC();
        List<Produit> listeProduit= new ArrayList();
        try {
			listeProduit= daoP.selectAll();
		} catch (Exception e) {
			System.out.println("Erreur dans voir produit");
		}
        System.out.println(listeProduit);
        
        menuAdmin();
    }

	

	








	


public static void main(String[] args) throws ClassNotFoundException, SQLException {






		menu();






	// ------------   TEST de Compte  ------------------------------

	//		DAOCommande daoC = new DAOCommande();
	//		DAOProduit daoP = new DAOProduit();
	//		DAOPanier daoPanier = new DAOPanier();
	//		
	//		// --------------- TEST insert -------------    
	////		Compte c = new Compte("monnom","monmdp","monmail@gmail","client","valide");
	////		Panier p= new Panier(daoC.selectById(1), daoP.selectById(5), 2);
	////		daoPanier.insert(p);
	//
	//		
	//		 //----------- TEST selectById ----------------    
	//		Commande c = daoC.selectById(1);
	//		System.out.println(c);
	//		c=daoC.PanierCommande(c);
	//		
	//		for (Panier p : c.getPanier()) {
	//			System.out.println(p.getIdProd().getType()+"("+p.getQte()+")");
	//		}
	//		//.afficheP();


	// ------------ TEST selectAll -----------------
	//		List<Panier> listPanier = new ArrayList();
	//		listPanier = daoPanier.selectAll();
	//		System.out.println(listPanier);


	//--------------- TEST update ---------------
	//		Compte c = daoC.selectById(5);
	//		System.out.println(c);
	//		c.setType("admin");
	//		daoC.update(c);

	// -------------- TEST delete ---------------
	//daoC.delete(5);







	// ------------   TEST de Commande ------------------------------

	//DAOCommande daoC = new DAOCommande();

	// --------------- TEST insert -------------    
	//		Commande c = new Commande(5, "traite", 21, 4);
	//		daoC.insert(c);
	//		Commande c2 = new Commande(4, "en_attente", 7, 2);
	//		daoC.insert(c2);

	// ----------- TEST selectById ----------------    
	//		Commande c = daoC.selectById(1);
	//		System.out.println(c);


	// ------------ TEST selectAll -----------------
	//		List<Commande> listCommande = new ArrayList();
	//		listCommande = daoC.selectAll();
	//		System.out.println(listCommande);


	//--------------- TEST update ---------------
	//		Commande c = daoC.selectById(7);
	//		c.setcEtat("en_attente");
	//		c.setPrixTot(8);
	//		daoC.update(c);

	// -------------- TEST delete ---------------
	//		daoC.delete(8);

}

	
	
	
	public static void main(String[] args) {



	}

}
