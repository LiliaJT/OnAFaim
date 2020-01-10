package dao;

import java.sql.SQLException;

import model.Compte;


public interface DAOCompte extends DAO<Compte,Integer> {

	public Compte checkConnect(String email,String pass) ;
}

