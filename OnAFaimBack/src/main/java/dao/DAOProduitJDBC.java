package dao;

import java.sql.*;
import java.util.*;
import model.*;

public class DAOProduitJDBC implements DAO<Produit, Integer>{

	public Produit selectById(Integer id) {
	try {	
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
		} catch (Exception e) {return null;}
	}

	public List<Produit> selectAll() {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 	
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", ""); 
			
				PreparedStatement ps=conn.prepareStatement("select * from produit");	
		
				ResultSet rs=ps.executeQuery(); 
		
				Produit p=null;
				List<Produit> listeProduit= new ArrayList();
		
				while(rs.next()) 
				{ 
					p=new Produit(rs.getInt("idProduit"), rs.getString("type"), rs.getString("taille"), rs.getDouble("prix"), rs.getString("libelle"));
					listeProduit.add(p);
				}
		
				ps.close();
				conn.close();
		
				return listeProduit;
		} catch (Exception e) {return null;}
	}

	public void insert(Produit p) {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 	
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
		
				PreparedStatement ps=conn.prepareStatement("insert into produit (type, taille, prix, libelle) values (?,?,?,?)");
		
				ps.setString(1, p.getType());
				ps.setString(2, p.getTaille()); 
				ps.setDouble(3, p.getPrix()); 
				ps.setString(4, p.getLibelle());
	
				ps.executeUpdate();
				ps.close();
				conn.close(); 
		} catch (Exception e) {}
	}

	public void update(Produit p) {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 	
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
				PreparedStatement ps=conn.prepareStatement("update produit set type=?, taille=?, prix=? where idProduit=?");  
		 
				ps.setString(1, p.getType());
				ps.setString(2, p.getTaille()); 
				ps.setDouble(3, p.getPrix()); 
				ps.setInt(4, p.getIdProduit()); 

				ps.executeUpdate();
				conn.close();
		}catch(Exception e) {}
		
	}

	public void delete(Integer id) {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 	
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
				PreparedStatement ps=conn.prepareStatement("delete from produit where idProduit=?");
				ps.setInt(1, id); 
				ps.executeUpdate(); 
				conn.close();
		} catch (Exception e) {}
		
	}
		
		
		

}

	
