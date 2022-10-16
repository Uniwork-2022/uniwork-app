package br.com.uniwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.uniwork.model.factory.ConectionFactory;
import br.com.uniwork.model.vo.PerguntaVO;

/**
 * Descontinuado
 * @author Mateus Cabral
 * @deprecated
 */
public class PerguntaDAO {
	private Connection conn = null;
	
	public PerguntaDAO() {
		this.conn = new ConectionFactory().getConn();
	}
	
	public void insert(PerguntaVO pvo) throws SQLException{
		String sql = "INSERT INTO T_UW_PERGUNTAS (ds_pergunta, cd_alternativa, ds_alternativa) "
				+ "VALUES (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, pvo.getDescricao());
		ps.setString(2, pvo.getAlternativas());
		ps.setString(3, pvo.getDescricao());
		
		
	}
	
	public void select() throws SQLException{
		
	}
	
	public void select(int ID) throws SQLException{
		
	}
	
	public void update() throws SQLException{
		
	}
	
	public void delete() throws SQLException{
		
	}
	
	
}
