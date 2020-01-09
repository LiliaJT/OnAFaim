package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class DAOCommande implements DAO<Commande,Integer>{

	
	public Commande selectById(Integer id) throws ClassNotFoundException, SQLException {
		DAOPanier daoP=new DAOPanier();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", "");
		
		PreparedStatement ps = conn.prepareStatement("select * from commander where idCommande=?");
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		
		Commande c=null;
		
		while (rs.next()) {
			c = new Commande(rs.getInt("idCommande"),rs.getInt("cEval"),rs.getString("cEtat"),rs.getDouble("prixTot"),rs.getInt("idCompte"),null); 
		}
		conn.close();
		return c;
	}
	
	
	public Commande PanierCommande(Commande commande) throws ClassNotFoundException, SQLException {
		DAOPanier daoP=new DAOPanier();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", "");
		
		PreparedStatement ps = conn.prepareStatement("select * from panier, produit where idCom=? and panier.idProd=produit.idProduit");
		ps.setInt(1,commande.getIdCommande());
		ResultSet rs = ps.executeQuery();
		List<Panier> detail=new ArrayList();
		Panier panier=null;
		Produit prod=null;
		while (rs.next()) {
			
			prod=new Produit(rs.getInt("idProduit"), rs.getString("type"), rs.getString("taille"), rs.getDouble("prix"), rs.getString("libelle"));
			panier=new Panier(commande, prod, rs.getInt("qte"));
			detail.add(panier);
		}
		commande.setPanier(detail);
		conn.close();
		return commande;
	}


	
	public List<Commande> selectAll() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", "");
		
		PreparedStatement ps = conn.prepareStatement("select * from commander");
		ResultSet rs = ps.executeQuery();
		
		Commande c=null;
		List<Commande> listCommande = new ArrayList();
		
		while (rs.next()) {
			c = new Commande(rs.getInt("idCommande"),rs.getInt("cEval"),rs.getString("cEtat"),rs.getDouble("prixTot"),rs.getInt("idCompte"), null);
			listCommande.add(c);
		}
		conn.close();
		return listCommande;
	}
	
	


	public void insert(Commande c) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", "");
		
		PreparedStatement ps = conn.prepareStatement("insert into commander (cEval,cEtat,prixTot,idCompte) values(?,?,?,?)");

		ps.setInt(1,c.getcEval());
		ps.setString(2,c.getcEtat());
		ps.setDouble(3,c.getPrixTot());
		ps.setInt(4,c.getIdCompte());
		ps.executeUpdate();

		conn.close();
	}


	public void update(Commande c) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", "");
		
		PreparedStatement ps = conn.prepareStatement("update commander set cEval=?, cEtat=?, prixTot=?, idCompte=? where idCommande=?");

		ps.setInt(1,c.getcEval());
		ps.setString(2,c.getcEtat());
		ps.setDouble(3,c.getPrixTot());
		ps.setInt(4,c.getIdCompte());
		ps.setInt(5,c.getIdCommande());
		ps.executeUpdate();

		conn.close();
	}


	
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", "");
		
		PreparedStatement ps = conn.prepareStatement("delete from commander where idCommande=?");
		ps.setInt(1,id);
		ps.executeUpdate();
		conn.close();
	}

}
