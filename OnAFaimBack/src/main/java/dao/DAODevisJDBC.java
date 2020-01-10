package dao;

import java.sql.*;
import java.util.*;
import model.*;

public class DAODevisJDBC implements DAODevis{

	
	public Devis selectById(Integer id) throws ClassNotFoundException, SQLException {
		
		DAOCompteJDBC daoC=new DAOCompteJDBC();
		
		Class.forName("com.mysql.jdbc.Driver"); 		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", ""); 	
			
		PreparedStatement ps=conn.prepareStatement("select * from devis where idDevis=?");
		
		ps.setInt(1, id); 
		
		ResultSet rs=ps.executeQuery();  
		
		Devis d=null;
		
		while(rs.next()) { 
			
			d=new Devis(rs.getInt("idDevis"), rs.getInt("dEval"), daoC.selectById(rs.getInt("idCompte")), rs.getString("dEtat"), rs.getString("quoi"), rs.getDouble("prix"));
					
		}
				
		ps.close();
		conn.close();
		
		return d;
	}

	
	public List<Devis> selectAll() throws ClassNotFoundException, SQLException {
		
		DAOCompteJDBC daoC=new DAOCompteJDBC();
		
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", ""); 
				
		PreparedStatement ps=conn.prepareStatement("select * from devis");	
		
		ResultSet rs=ps.executeQuery(); 
		
		Devis d=null;
		List<Devis> listeDevis= new ArrayList();
		
		while(rs.next()) { 
			
			d=new Devis(rs.getInt("idDevis"), rs.getInt("dEval"), daoC.selectById(rs.getInt("idCompte")), rs.getString("dEtat"), rs.getString("quoi"), rs.getDouble("prix"));
			listeDevis.add(d);
		}
		
		
		ps.close();
		conn.close();
		
		return listeDevis;
	}

	
	public void insert(Devis d) throws ClassNotFoundException, SQLException {
		
		DAOCompteJDBC daoC=new DAOCompteJDBC();
		
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
		PreparedStatement ps=conn.prepareStatement("insert into devis (idDevis, dEval, dEtat, prix, quoi, idCompte) values (?,?,?,?,?,?)");
		
		ps.setInt(1, d.getIdDevis()); 
		ps.setInt(2, d.getdEval());
		ps.setString(3, d.getdEtat()); 
		ps.setDouble(4, d.getPrix()); 
		ps.setString(5, d.getQuoi()); 
		ps.setInt(6, d.getC().getIdCompte()); 
		
		
				
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}

	
	public void update(Devis d) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");

		PreparedStatement ps=conn.prepareStatement("update devis set dEval=?, dEtat=?, prix=?, quoi=?, idCompte=? where idDevis=?");  
		
		ps.setInt(1, d.getdEval()); 
		ps.setString(2, d.getdEtat());
		ps.setDouble(3, d.getPrix()); 
		ps.setString(4, d.getQuoi());
		ps.setInt(5,d.getC().getIdCompte());
		ps.setInt(6, d.getIdDevis()); 
		
		ps.executeUpdate();
		ps.close();
		conn.close();	
	}

	
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");

		PreparedStatement ps=conn.prepareStatement("delete from devis where idDevis=?");

		ps.setInt(1,id);
		ps.executeUpdate();
		ps.close();
		conn.close();
		
		
	}

}
