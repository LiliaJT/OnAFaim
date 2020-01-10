package dao;

import java.sql.SQLException;
import java.util.*;



public interface DAO <T,K>{

	public T selectById(K id) throws ClassNotFoundException, SQLException;
	public List<T> selectAll() throws ClassNotFoundException, SQLException;
	public void insert(T object) ;
	public void update(T object) throws ClassNotFoundException, SQLException;
	public void delete(K id) throws ClassNotFoundException, SQLException;
	
	
}
