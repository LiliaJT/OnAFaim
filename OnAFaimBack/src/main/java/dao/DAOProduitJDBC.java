package dao;

import java.sql.*;
import java.util.*;
import model.*;

public class DAOProduitJDBC implements DAOProduit{

	public Produit selectById(Integer id) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver"); 		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", ""); 	
			
		PreparedStatement ps=conn.prepareStatement("select * from produit where idProduit=?");
		
		ps.setInt(1, id); 
		
		ResultSet rs=ps.executeQuery();  
		
		Produit p=null;
		
		while(rs.next()) 
		{ 
			
			p=new Produit(rs.getInt("idProduit"), rs.getString("type"), rs.getString("taille"), rs.getDouble("prix"), rs.getString("libelle"));
					
		}
		
		ps.close();
		conn.close();
		
		return p; 
	}

	public List<Produit> selectAll() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", ""); 
			
		
		PreparedStatement ps=conn.prepareStatement("select * from produit");	
		
		ResultSet rs=ps.executeQuery(); 
		
		Produit p=null;
		List<Produit> listeProduit= new ArrayList();
		
		while(rs.next()) { 
			
			p=new Produit(rs.getInt("idProduit"), rs.getString("type"), rs.getString("taille"), rs.getDouble("prix"), rs.getString("libelle"));
			listeProduit.add(p);
		}
		
		
		ps.close();
		conn.close();
		
		return listeProduit;
	}

	public void insert(Produit p) throws ClassNotFoundException, SQLException {
//		DAOCompte daoC=new DAOCompte();
		
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
		
		PreparedStatement ps=conn.prepareStatement("insert into produit (idProduit, type, taille, prix) values (?,?,?,?)");
		
		ps.setInt(1, p.getIdProduit()); 
		ps.setString(2, p.getType());
		ps.setString(3, p.getTaille()); 
		ps.setDouble(4, p.getPrix()); 
	
		
		ps.executeUpdate();
		ps.close();
		conn.close(); 
	}

	public void update(Produit p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
		
		PreparedStatement ps=conn.prepareStatement("update produit set type=?, taille=?, prix=? where idProduit=?");  
		 
		ps.setString(1, p.getType());
		ps.setString(2, p.getTaille()); 
		ps.setDouble(3, p.getPrix()); 
		ps.setInt(4, p.getIdProduit()); 

		ps.executeUpdate();
		conn.close();
		
	}

	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
			PreparedStatement ps=conn.prepareStatement("delete from produit where idProduit=?");
			ps.setInt(1, id); 
			ps.executeUpdate(); 
			conn.close();
		
	}
		
		
		

}

	
