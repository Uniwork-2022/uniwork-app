package br.com.uniwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uniwork.model.factory.ConectionFactory;
import br.com.uniwork.model.vo.CompatibilidadeVO;

public class CompatibilidadeDAO {
	
	private Connection conn = null;
	
	public CompatibilidadeDAO() {
		this.conn = new ConectionFactory().getConn();
	}
	
	/**
	 * Insere um novo registro na tabela
	 * @param cvo
	 * @throws SQLException
	 */
	public void insert(CompatibilidadeVO cvo) throws SQLException{
		String sql = "INSERT INTO T_UW_COMPATIBILIDADE (id_compatibilidade, id_proposta, id_username, nr_compatibilidade) "
				+ "VALUES (SQ_UW_COMPATIBILIDADE.NEXTVAL, ?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cvo.getIdProposta());
		ps.setInt(2, cvo.getIdConta());
		ps.setInt(3, cvo.getCompatibilidade());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	/**
	 * GET ALL
	 * Retorna todas as compatibilidades armazenadas no sistema
	 * @return compatibilidades
	 * @throws SQLException
	 */
	public List<CompatibilidadeVO> select() throws SQLException{
		List<CompatibilidadeVO> compatibilidades = new ArrayList<CompatibilidadeVO>();
		String sql = "SELECT * FROM T_UW_COMPATIBILIDADE";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		CompatibilidadeVO cvo = new CompatibilidadeVO();
		while(rs.next()) {
			cvo.setCompatibilidade(rs.getInt("nr_compatibilidade"));
			cvo.setIdConta(rs.getInt("id_username"));
			cvo.setIdProposta(rs.getInt("id_proposta"));
			compatibilidades.add(cvo);
		}
		ps.close();
		rs.close();
		conn.close();
		return compatibilidades;
	}
	
	/**
	 * GET BY ID
	 * Retorna a compatibilidade de acordo com o id da proposta e do candidato
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public CompatibilidadeVO select(int idCandidato) throws SQLException{
		CompatibilidadeVO cvo = new CompatibilidadeVO();
		String sql = "SELECT * FROM T_UW_COMPATIBILIDADE WHERE ID_USUARIO = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idCandidato);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			cvo.setCompatibilidade(rs.getInt("nr_compatibilidade"));
			cvo.setIdConta(rs.getInt("id_username"));
			cvo.setIdProposta(rs.getInt("id_proposta"));
		}
		ps.close();
		rs.close();
		conn.close();
		return cvo;
	}
	
	/**
	 * Deleta do banco de dados o registro a partir do id do candidato e do id da proposta
	 * @param idProposta
	 * @param idCandidato
	 * @throws SQLException
	 */
	public void delete(int idProposta, int idCandidato) throws SQLException{
		String sql = "DELETE FROM T_UW_COMPATIBILIDADE WHERE ID_PROPOSTA = (?) AND ID_USERNAME = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idProposta);
		ps.setInt(2, idCandidato);
	}

}
