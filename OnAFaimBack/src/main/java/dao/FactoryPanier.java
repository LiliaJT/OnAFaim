package dao;

public class FactoryPanier {

	
	static DAOPanier dao=new DAOPanierJDBC();
	

	public static DAOPanier getDAOPanier() 
	{
		return dao;
	}
}