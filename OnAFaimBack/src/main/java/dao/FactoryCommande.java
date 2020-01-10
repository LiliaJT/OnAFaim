package dao;

public class FactoryCommande {

	
	static DAOCommande dao=new DAOCommandeJDBC();
	

	public static DAOCommande getDAOCommande() 
	{
		return dao;
	}
}