package br.com.uniwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uniwork.model.factory.ConectionFactory;
import br.com.uniwork.model.vo.HabilidadeVO;

public class HabilidadeDAO {
	
	private Connection conn = null;
	
	public HabilidadeDAO() {
		this.conn = new ConectionFactory().getConn();
	}
	
	public void insert(HabilidadeVO hvo) throws SQLException {
		String sql = "INSERT INTO T_UW_HABILIDADE (nm_habilidade, ds_habilidade, tp_habilidade) "
				+ "VALUES (?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, hvo.getNome());
		ps.setString(2, hvo.getDescricao());
		ps.setString(3, hvo.getTipo());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
	
	/**
	 * GET ALL
	 * Retorna todas as habilidades no banco
	 * @throws SQLException
	 * @return habilidades List<HabilidadeVO>
	 */
	public List<HabilidadeVO> select() throws SQLException {
		List<HabilidadeVO> habilidades = new ArrayList<HabilidadeVO>();
		String sql = "SELECT * FROM T_UW_HABILIDADE";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		HabilidadeVO hvo = new HabilidadeVO();
		while(rs.next()) {
			hvo.setNome(rs.getString("nm_habilidade"));
			hvo.setDescricao(rs.getString("ds_habilidade"));
			hvo.setTipo(rs.getString("tp_habilidade"));
			habilidades.add(hvo);
		}
		ps.close();
		rs.close();
		conn.close();
		
		return habilidades;
	}
	
	/**
	 * GET BY ID
	 * Retorna a habilidade do banco a partir do ID
	 * @param id inteiro
	 * @throws SQLException
	 * @return habilidade HabilidadeVO
	 */
	public HabilidadeVO select(int id) throws SQLException {
		String sql = "SELECT * FROM T_UW_HABILIDADE WHERE ID_HABILIDADE = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		HabilidadeVO hvo = new HabilidadeVO();
		while(rs.next()) {
			hvo.setNome(rs.getString("nm_habilidade"));
			hvo.setDescricao(rs.getString("ds_habilidade"));
			hvo.setTipo(rs.getString("tp_habilidade"));
			hvo.setId(id);
		}
		ps.close();
		rs.close();
		conn.close();
		return hvo;
		
	}
	

	/**
	 * UPDATE
	 * Atualiza o nome de uma habilidade, pega a original a partir do ID
	 * @param id
	 * @param novoNome
	 * @throws SQLException
	 */
	public void update(int id, String novoNome) throws SQLException {
		String sql = "UPDATE T_UW_HABILIDADE SET NM_HABILIDADE = (?) WHERE ID = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, novoNome);
		ps.setInt(2, id);
		ps.execute();
		ps.close();
		conn.close();
	}
	
	/**
	 * DELETE
	 * Deleta um registro no banco a partir do ID da habilidade
	 * @param id
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM T_UW_HABILIDADE WHERE ID_HABILIDADE = (?)";	
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.execute();
		ps.close();
		conn.close();
	}
	
	

}
