package dao;

public class FactoryProduit {

	
	static DAOProduit dao=new DAOProduitJDBC();
	

	public static DAOProduit getDAOProduit() 
	{
		return dao;
	}
}