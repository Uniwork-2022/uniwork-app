package br.com.uniwork.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uniwork.model.factory.ConectionFactory;
import br.com.uniwork.model.vo.CurriculoVO;

/**
 * Classe que gerencia a as operações de CRUD da classe Curriculo
 * @see #CurriculoVO
 * @author Mateus Cabral
 * @version 1.0
 */
public class CurriculoDAO {
	private Connection conn = null;
	
	public CurriculoDAO() throws SQLException {
		this.conn = new ConectionFactory().getConn();
	}
	
	/**
	 * Insere um novo registro na tabela
	 * @param cvo Curriculo do Candidato
	 * @param idCandidato id do candidato no banco de dados
	 * @throws SQLException
	 */
	public void insert(CurriculoVO cvo, int idCandidato) throws SQLException {
		String sql = "INSERT INTO T_UW_CURRICULO "
				+ "(id_curriculo, id_usuario, ds_objetivo_profissional, ds_experiencia_profissional, vl_pretencao_salarial) "
				+ "VALUES (SQ_UW_CURRICULO.NEXTVAL, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, idCandidato);
		ps.setString(2, cvo.getObjetivoProfissional());
		ps.setString(3, cvo.getExperienciaProfissional());
		ps.setInt(4, cvo.getPretensaoSalarial());
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}
	
	/**
	 * GET ALL
	 * Retorna todos os currículos do banco de dados
	 * @return curriculos
	 * @throws SQLException
	 */
	public List<CurriculoVO> select() throws SQLException {
		List<CurriculoVO> curriculos = new ArrayList<CurriculoVO>();
		String sql = "SELECT * FROM T_UW_CURRICULO";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		CurriculoVO cvo = new CurriculoVO();
		
		while(rs.next()) {
			int idCandidato = rs.getInt("id_usuario");
			int idCurriculo = rs.getInt("id_curriculo");
			String objetivo = rs.getString("ds_objetivo_profissional");
			String formacao = rs.getString("ds_formacao_academica");
			String experiencia = rs.getString("ds_experiencia_profissional");
			int pretensao = rs.getInt("vl_pretencao_salarial");
			
			cvo.setExperienciaProfissional(formacao);
			cvo.setId(idCurriculo);
			cvo.setObjetivoProfissional(objetivo);
			cvo.setFormacaoAcademica(formacao);
			cvo.setPretensaoSalarial(pretensao);
			cvo.setExperienciaProfissional(experiencia);
			cvo.setIdCandidato(idCandidato);
			
			curriculos.add(cvo);
		}
		
		ps.close();
		rs.close();
		conn.close();
		
		return curriculos;
	}
	
	/**
	 * GET BY ID
	 * Retorna um currículo a partir do id do candidato
	 * @param id do candidato
	 * @return cvo CurriculoVO
	 * @throws SQLException
	 */
	public CurriculoVO select(int id) throws SQLException {
		String sql = "SELECT * FROM T_UW_CURRICULO WHERE ID_USUARIO = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		CurriculoVO cvo = new CurriculoVO();
		
		while(rs.next()) {
			int idCandidato = rs.getInt("id_usuario");
			int idCurriculo = rs.getInt("id_curriculo");
			String objetivo = rs.getString("ds_objetivo_profissional");
			String formacao = rs.getString("ds_formacao_academica");
			String experiencia = rs.getString("ds_experiencia_profissional");
			int pretensao = rs.getInt("vl_pretencao_salarial");
			
			cvo.setExperienciaProfissional(formacao);
			cvo.setId(idCurriculo);
			cvo.setObjetivoProfissional(objetivo);
			cvo.setFormacaoAcademica(formacao);
			cvo.setPretensaoSalarial(pretensao);
			cvo.setExperienciaProfissional(experiencia);
			cvo.setIdCandidato(idCandidato);
		}
		ps.close();
		rs.close();
		conn.close();
		return cvo;
		
	}
	
	/**
	 * Atualiza um registro de currículo. Obrigatório id do usuário
	 * @param id id do usuário
	 * @param cvo Novo currículo
	 * @throws SQLException
	 */
	public void update(int id, CurriculoVO cvo) throws SQLException {
		String sql = "UPDATE T_UW_CURRICULO SET "
				+ "ds_objetivo_profissional = (?), ds_formacao_academica = (?), ds_experiencia_profissional = (?), "
				+ "vl_pretencao_salarial = (?) WHERE id_curriculo = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, cvo.getObjetivoProfissional());
		ps.setString(2, cvo.getFormacaoAcademica());
		ps.setString(3, cvo.getExperienciaProfissional());
		ps.setInt(4, cvo.getPretensaoSalarial());
		ps.setInt(5, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
		
	}
	
	
	/**
	 * Deleta um currículo a partir do ID do usuário
	 * @param id id do usuário
	 * @throws SQLException
	 */
	public void delete(int id) throws SQLException {
		String sql = "DELETE FROM T_UW_CURRICULO WHERE ID_USUARIO = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}
}
