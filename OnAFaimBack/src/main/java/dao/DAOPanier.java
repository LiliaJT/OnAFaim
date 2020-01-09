package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.*;


public class DAOPanier implements DAO<Panier, Integer> {


	public Panier selectById(Integer id) throws ClassNotFoundException, SQLException {
		DAOCommande daoC=new DAOCommande();
		DAOProduit daoP=new DAOProduit();
		
		Class.forName("com.mysql.jdbc.Driver"); 		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", ""); 	
			
		PreparedStatement ps=conn.prepareStatement("select * from panier where idCom=?");
		
		ps.setInt(1, id); 
		
		ResultSet rs=ps.executeQuery();  
		
		Panier p=null;
		
		while(rs.next()) { 
			
			p=new Panier(daoC.selectById(rs.getInt("idCom")), daoP.selectById(rs.getInt("idProd")), rs.getInt("qte"));
					
		}
				
		ps.close();
		conn.close();
		
		return p;
		
	}

	
	public List<Panier> selectAll() throws ClassNotFoundException, SQLException {
		DAOCommande daoC=new DAOCommande();
		DAOProduit daoP=new DAOProduit();
		
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", ""); 
				
		PreparedStatement ps=conn.prepareStatement("select * from panier");	
		
		ResultSet rs=ps.executeQuery(); 
		
		Panier p=null;
		List<Panier> listePanier= new ArrayList();
		
		while(rs.next()) { 
			
			p=new Panier(daoC.selectById(rs.getInt("idCom")), daoP.selectById(rs.getInt("idProd")), rs.getInt("qte"));
			listePanier.add(p);
		}
		
		
		ps.close();
		conn.close();
		
		return listePanier;
	}

	
	public void insert(Panier p) throws ClassNotFoundException, SQLException {
		//DAOCommande daoC=new DAOCommande(); Pas besoin ? 
		//DAOpanier daoP=new DAOpanier();
		
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
		PreparedStatement ps=conn.prepareStatement("insert into panier (idCom, idProd, qte) values (?,?,?)");
		
		ps.setInt(1, p.getIdCom().getIdCommande()); 
		ps.setInt(2, p.getIdProd().getIdProduit()); 
		ps.setInt(3,p.getQte());
		
		
				
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}

	
	public void update(Panier p) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
		
		
		PreparedStatement ps=conn.prepareStatement("update panier set idProd=?, qte=? where idCom=?");  
		
		ps.setInt(1, p.getIdProd().getIdProduit()); 
		ps.setInt(2,p.getQte());
		ps.setInt(3, p.getIdCom().getIdCommande()); 
		

		ps.executeUpdate();
		ps.close();
		conn.close();
		
		
	}

	
	public void delete(Integer id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver"); 	
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/miam", "root", "");
		
		
			PreparedStatement ps=conn.prepareStatement("delete from panier where idCom="+id);
		
			ps.executeUpdate();
			ps.close();
			conn.close();
	
		
	}
		

}
