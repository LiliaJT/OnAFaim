package dao;

public class FactoryProduit {

	
	static DAOProduitJDBC dao=new DAOProduitJDBC();
	

	public static DAOProduitJDBC getDAOProduit() 
	{
		return dao;
	}
}