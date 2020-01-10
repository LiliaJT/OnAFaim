package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Compte;

public class DAOCompteJDBC implements DAOCompte {

	
	public Compte selectById(Integer idCompte) throws SQLException, ClassNotFoundException 
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 

		PreparedStatement ps = conn.prepareStatement("select * from compte where idCompte=?");

		ps.setInt(1, idCompte);


		ResultSet rs = ps.executeQuery(); 

		Compte cm = null; 
		while (rs.next())
		{
			cm = new Compte (rs.getInt("idCompte"), rs.getString("nom"), rs.getString("mdp"), rs.getString("email"), rs.getString("type"), rs.getString("compteEtat")); 

		}

		conn.close(); 
		return cm;

	}

	
	public List<Compte> selectAll() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte"); 
		
		ResultSet rs = ps.executeQuery();
		
		Compte cm=null; 
		List<Compte> list= new ArrayList(); 
		while (rs.next())
			{
				cm = new Compte (rs.getInt("idCompte"), rs.getString("nom"), rs.getString("mdp"), rs.getString("email"), rs.getString("type"), rs.getString("compteEtat")); 
				list.add(cm); 
			}
		ps.close();
		conn.close();
		
		return list;

	}

	
	public void insert(Compte cm) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
		
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (nom, mdp, email) VALUES (?,?,?)"); 
		
		ps.setString(1, cm.getNom());
		ps.setString(2, cm.getMdp());
		ps.setString(3, cm.getEmail());
		
		ps.executeUpdate(); 
		ps.close(); 
		conn.close();
	
	}

	public void update(Compte cm) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
			
		PreparedStatement ps = conn.prepareStatement("Update compte set nom=?, mdp=?, email=?, type=?, compteEtat=? where idCompte=?"); 
		
		ps.setString(1, cm.getNom());
		ps.setString(2, cm.getMdp());
		ps.setString(3, cm.getEmail());
		ps.setString(4, cm.getType());
		ps.setString(5, cm.getCompteEtat());
		ps.setInt(6, cm.getIdCompte());
		
		
		ps.executeUpdate(); 
		ps.close(); 
		conn.close();
		
	}

	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 
		
		PreparedStatement ps = conn.prepareStatement("DELETE from compte where idCompte=?"); 
	
		ps.setInt(1,id);
		ps.executeUpdate(); 
		ps.close(); 
		
		conn.close();
		
	}

	public Compte checkConnect(String email,String pass) throws ClassNotFoundException, SQLException 
	{
		
		
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam","root", ""); 

		PreparedStatement ps = conn.prepareStatement("select * from compte where email=? and mdp=?");
		ps.setString(1,email);
		ps.setString(2, pass);


		ResultSet rs = ps.executeQuery(); 

		Compte c= null; 
		
		while (rs.next())
		{
			c = new Compte (rs.getInt("idCompte"), rs.getString("nom"), rs.getString("mdp"), rs.getString("email"), rs.getString("type"), rs.getString("compteEtat")); 

		}

		conn.close(); 
		return c;
		
		
	} 
	
}







