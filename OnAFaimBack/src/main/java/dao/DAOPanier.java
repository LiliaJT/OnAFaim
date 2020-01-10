package dao;

import java.sql.SQLException;
import java.util.List;

import model.Panier;

public interface DAOPanier extends DAO<Panier,Integer> {
	public List<Panier> selectAllForClient(Integer idClient) throws ClassNotFoundException, SQLException;
}
