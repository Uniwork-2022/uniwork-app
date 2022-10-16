package br.com.uniwork.model.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.uniwork.dao.EmpresaDAO;
import br.com.uniwork.model.vo.EmpresaVO;

public class EmpresaBO {
	private EmpresaDAO ed;

	/**
	 * Retorna todas as empresas cadastradas no banco de dados
	 * 
	 * @param idEmpresa
	 * @return
	 * @throws SQLException
	 */
	public List<EmpresaVO> listar() throws SQLException {
		ed = new EmpresaDAO();
		return ed.select();
	}

	/**
	 * Retorna uma empresa, de acordo com o id
	 * 
	 * @param idEmpresa
	 * @return
	 * @throws SQLException
	 */
	public EmpresaVO listar(int idEmpresa) throws SQLException {
		ed = new EmpresaDAO();
		return ed.select(idEmpresa);
	}

	public boolean cadastrar(EmpresaVO evo) {

		try {
			ed = new EmpresaDAO();
			ed.insert(evo);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro na operação de insert no banco.");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean atualizar(int idEmpresa, String novoNome) {
		try {
			ed = new EmpresaDAO();
			ed.update(idEmpresa, novoNome);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro na operação de atualização no banco.");
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean deletar(int idEmpresa) {
		try {
			ed = new EmpresaDAO();
			ed.delete(idEmpresa);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro na operação de delete no banco.");
			e.printStackTrace();
		}
		return false;
		
	}
}
