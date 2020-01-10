package dao;

public class FactoryDevis {

	
	static DAODevis dao=new DAODevisJDBC();
	

	public static DAODevis getDAODevis() 
	{
		return dao;
	}
}