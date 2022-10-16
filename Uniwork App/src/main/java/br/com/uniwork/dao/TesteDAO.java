package br.com.uniwork.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.uniwork.model.factory.ConectionFactory;

/**
 * Descontinuado
 * @author Mateus Cabral
 * @deprecated
 */
public class TesteDAO {
	private Connection conn = null;
	
	public TesteDAO() {
		this.conn = new ConectionFactory().getConn();
	}
	
	public void insert() throws SQLException{

	}
	
	public void select() throws SQLException{
		
	}
	
	public void select(int id) throws SQLException{
		
	}
	
	public void update() throws SQLException{
		
	}
	
	public void delete() throws SQLException{
		
	}
}
