package br.com.uniwork.model.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.uniwork.dao.VagaEmpregoDAO;
import br.com.uniwork.model.vo.VagaEmpregoVO;

public class VagaEmpregoBO {
	
	private VagaEmpregoDAO ved;
	
	/**
	 * Retorna uma lista com todos os registros de vaga no banco de dados
	 * @return vagas List<Vagas>
	 * @throws SQLException
	 */
	public List<VagaEmpregoVO> listar() throws SQLException {
		ved = new VagaEmpregoDAO();
		return ved.select();
	}
	
	/**
	 * Retorna uma vaga de acordo com o id dela
	 * @param idVaga id da vaga
	 * @return vaga VagaVO
	 * @throws SQLException
	 */
	public VagaEmpregoVO listar(int id) throws SQLException {
		ved = new VagaEmpregoDAO();
		return ved.select(id);
	}
	
	/**
	 * Realiza o update de um registro na tabela
	 * @param id id da Vaga
	 * @param vevo Vaga de emprego
	 * @return boolean De acordo com o sucesso da operação
	 */
	public boolean cadastrar(int id, VagaEmpregoVO veo) {
		ved = new VagaEmpregoDAO();
		
		try {
			ved.insert(id, veo);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro com o banco...");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean atualizar(int idVaga, VagaEmpregoVO vevo) {
		ved = new VagaEmpregoDAO();
		try {
			ved.update(idVaga, vevo);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro com o banco...");
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Deleta um registro na tabela a partir do ID especificado
	 * @param id id da vaga
	 * @return boolean De acordo com o sucesso da operação
	 */
	public boolean deletar(int id) {
		ved = new VagaEmpregoDAO();
		try {
			ved.delete(id);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro com o banco...");
			e.printStackTrace();
		}
		return true;
	}

}
