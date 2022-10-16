package br.com.uniwork.model.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.uniwork.dao.CurriculoDAO;
import br.com.uniwork.model.vo.CurriculoVO;
import br.com.uniwork.model.vo.HabilidadeVO;

public class CurriculoBO {
	
	private CurriculoVO cv;
	private CurriculoDAO cdao;

	/**
	 * Adiciona uma habilidade
	 * @param idHabilidade
	 */
	public void addHabilidade(HabilidadeVO h) {
		cv.getHabilidades().add(h);
	}
	
	/**
	 * Retorna todos os currículos do banco de dados
	 * @return curriculos
	 * @throws SQLException
	 */
	public List<CurriculoVO> listar() throws SQLException {
		cdao = new CurriculoDAO();
		return cdao.select();
	}
	
	
	/**
	 * Retorna um currículo a partir do id do candidato
	 * @param id do candidato
	 * @return cvo CurriculoVO
	 * @throws SQLException
	 */
	public CurriculoVO listar(int id) throws SQLException {
		cdao = new CurriculoDAO();
		return cdao.select(id);
	}
	
	/**
	 * Insere um novo registro na tabela
	 * @param cvo Curriculo do Candidato
	 * @param idCandidato id do candidato no banco de dados
	 * @return
	 */
	public boolean cadastrar(CurriculoVO cvo, int idCandidato) {
		try {
			cdao = new CurriculoDAO();
			cdao.insert(cvo, idCandidato);
			return true;
		} catch (SQLException e) {
			System.out.println("Erro inserindo o o registro...");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean atualizar(int id, CurriculoVO cvo) {
		try {
			cdao = new CurriculoDAO();
			cdao.update(id, cvo);
			return true;
		} catch (SQLException e) {
			System.out.println("Erro atualizando o o registro...");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deletar(int idUsuario) {
		try {
			cdao = new CurriculoDAO();
			cdao.delete(idUsuario);
			return true;
		} catch (SQLException e) {
			System.out.println("Erro inserindo o o registro...");
			e.printStackTrace();
		}
		return false;
	}
	
}
