package dao;

public class FactoryCompte {

	
	static DAOCompteJDBC dao=new DAOCompteJDBC();
	

	public static DAOCompteJDBC getDAOCompte() 
	{
		return dao;
	}
}