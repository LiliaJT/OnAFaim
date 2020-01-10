package dao;

public class FactoryPanier {

	
	static DAOPanierJDBC dao=new DAOPanierJDBC();
	

	public static DAOPanierJDBC getDAOPanier() 
	{
		return dao;
	}
}