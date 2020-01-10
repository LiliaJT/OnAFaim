package dao;

public class FactoryCompte {

	
	static DAOCompte dao=new DAOCompteJDBC();
	

	public static DAOCompte getDAOCompte() 
	{
		return dao;
	}
}