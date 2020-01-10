package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Compte;

public class DAOCompteJDBC implements DAO<Compte, Integer> {

	
	public Compte selectById(Integer idCompte) {
	try {
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 

			PreparedStatement ps = conn.prepareStatement("select * from compte where idCompte=?");

			ps.setInt(1, idCompte);

			ResultSet rs = ps.executeQuery(); 

			Compte cm = null; 
			while (rs.next())
			{
			cm = new Compte (rs.getInt("idCompte"), rs.getString("nom"), rs.getString("mdp"), rs.getString("email"), 			rs.getString("type"), rs.getString("compteEtat")); 
			}

			conn.close(); 
			return cm;
	}catch (Exception e) {return null;}
}

	
	public List<Compte> selectAll()  {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
		
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte"); 
		
				ResultSet rs = ps.executeQuery();
		
				Compte cm=null; 
				List<Compte> list= new ArrayList(); 
				while (rs.next())
				{
					cm = new Compte (rs.getInt("idCompte"), rs.getString("nom"), rs.getString("mdp"), 					rs.getString("email"), rs.getString("type"), rs.getString("compteEtat")); 
					list.add(cm); 
				}
				ps.close();
				conn.close();
		
				return list;
		}catch (Exception e) {return null;}
	}

	
	public void insert(Compte cm) {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
		
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (nom, mdp, email) VALUES (?,?,?)"); 
		
				ps.setString(1, cm.getNom());
				ps.setString(2, cm.getMdp());
				ps.setString(3, cm.getEmail());
		
				ps.executeUpdate(); 
				ps.close(); 
				conn.close();
		}catch (Exception e) {}
	}

	public void update(Compte cm) {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
			
				PreparedStatement ps = conn.prepareStatement("Update compte set nom=?, mdp=?, email=?, type=?, 				compteEtat=? where idCompte=?"); 
		
				ps.setString(1, cm.getNom());
				ps.setString(2, cm.getMdp());
				ps.setString(3, cm.getEmail());
				ps.setString(4, cm.getType());
				ps.setString(5, cm.getCompteEtat());
				ps.setInt(6, cm.getIdCompte());
		
		
				ps.executeUpdate(); 
				ps.close(); 
				conn.close();
		}catch (Exception e) {}
	}

	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
		
				PreparedStatement ps = conn.prepareStatement("DELETE from compte where idCompte=?"); 
	
				ps.setInt(1,id);
				ps.executeUpdate(); 
				ps.close(); 
		
				conn.close();
		}catch (Exception e) {}
		
	}

	public Compte checkConnect(String nom,String pass)  {
		try {
				Class.forName("com.mysql.jdbc.Driver"); 
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 

				PreparedStatement ps = conn.prepareStatement("select * from compte where nom=? and mdp=?");
				ps.setString(1,nom);
				ps.setString(2, pass);

				ResultSet rs = ps.executeQuery(); 

				Compte cm= null; 
		
				while (rs.next())
				{
					cm = new Compte (rs.getInt("idCompte"), rs.getString("nom"), rs.getString("mdp"), 					rs.getString("email"), rs.getString("type"), rs.getString("compteEtat")); 
				}

				conn.close(); 
				return cm;
		}catch (Exception e) {return null;}
	} 
	
}







