package br.com.uniwork.dao;
/**
 * @author Mateus Cabral
 * @version 1.0
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uniwork.model.factory.ConectionFactory;
import br.com.uniwork.model.vo.VagaEmpregoVO;

public class VagaEmpregoDAO {
	private Connection conn;

	public VagaEmpregoDAO() {
		this.conn = new ConectionFactory().getConn();
	}

	/**
	 * Insere um novo registro na tabela, obrigatório um id de empresa para vincular
	 * @param idEmpresa
	 * @param vevo Vaga de emprego
	 * @throws SQLException
	 */
	public void insert(int idEmpresa, VagaEmpregoVO vevo) throws SQLException {
		String sql = "INSERT INTO T_UW_VAGA (id_empresa, sg_local, ds_vaga, ds_beneficios) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idEmpresa);
		ps.setString(2, vevo.getLocal());
		ps.setString(3, vevo.getDescritivo());
		ps.setString(4, vevo.getBeneficios());
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	/**
	 * GET ALL
	 * Retorna uma lista com todos os registros de vaga no banco de dados
	 * @return vagas List<Vagas>
	 * @throws SQLException
	 */
	public List<VagaEmpregoVO> select() throws SQLException {
		List<VagaEmpregoVO> vagas = new ArrayList<VagaEmpregoVO>();
		String sql = "SELECT * FROM T_UW_VAGA";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		VagaEmpregoVO vaga = new VagaEmpregoVO();
		
		while (rs.next()) {
			int idVaga = rs.getInt("id_vaga");
			int idEmpresa = rs.getInt("id_empresa");
			String local = rs.getString("sg_local");
			String descricao = rs.getString("ds_vaga");
			String beneficios = rs.getString("ds_beneficios");
			vaga.setIdVaga(idVaga);
			vaga.setEmpresa(idEmpresa);
			vaga.setLocal(local);
			vaga.setDescritivo(descricao);
			vaga.setBeneficios(beneficios);
			vagas.add(vaga);
		}
		return vagas;
	}

	/**
	 * GET BY ID
	 * Retorna uma vaga de acordo com o id dela
	 * @param idVaga id da vaga
	 * @return vaga VagaVO
	 * @throws SQLException
	 */
	public VagaEmpregoVO select(int idVaga) throws SQLException {
		VagaEmpregoVO vaga = new VagaEmpregoVO();
		String sql = "SELECT * FROM T_UW_VAGA WHERE id_vaga = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idVaga);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			int idEmpresa = rs.getInt("id_empresa");
			String local = rs.getString("sg_local");
			String descricao = rs.getString("ds_vaga");
			String beneficios = rs.getString("ds_beneficios");
			vaga.setIdVaga(idVaga);
			vaga.setEmpresa(idEmpresa);
			vaga.setLocal(local);
			vaga.setDescritivo(descricao);
			vaga.setBeneficios(beneficios);
		}
		ps.close();
		rs.close();
		conn.close();
		return vaga;
	}

	
	/**
	 * Realiza o update de um registro na tabela
	 * @param id
	 * @param vevo
	 * @throws SQLException
	 */
	public void update(int idVaga, VagaEmpregoVO vevo) throws SQLException {
		String sql = "UPDATE T_UW_VAGA SET sg_local = ?, ds_vaga = ?, ds_beneficios = ? WHERE id_vaga = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, vevo.getLocal());
		ps.setString(2, vevo.getDescritivo());
		ps.setString(3, vevo.getBeneficios());
		ps.setInt(4, idVaga);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	/**
	 * Deleta um registro na tabela a partir do ID especificado
	 * @param id id da vaga
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM T_UW_VAGA WHERE id_vaga = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}
}
