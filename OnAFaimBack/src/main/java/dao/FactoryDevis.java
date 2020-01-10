package dao;

public class FactoryDevis {

	
	static DAODevisJDBC dao=new DAODevisJDBC();
	

	public static DAODevisJDBC getDAODevis() 
	{
		return dao;
	}
}