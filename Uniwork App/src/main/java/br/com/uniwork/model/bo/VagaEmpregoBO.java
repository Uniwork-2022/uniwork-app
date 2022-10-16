package br.com.uniwork.model.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.uniwork.dao.VagaEmpregoDAO;
import br.com.uniwork.model.vo.VagaEmpregoVO;

public class VagaEmpregoBO {
	
	private VagaEmpregoDAO ved;
	
	public List<VagaEmpregoVO> listar() throws SQLException {
		ved = new VagaEmpregoDAO();
		return ved.select();
	}
	
	public VagaEmpregoVO listar(int id) throws SQLException {
		ved = new VagaEmpregoDAO();
		return ved.select(id);
	}
	
	public boolean cadastrar(int id, VagaEmpregoVO veo) {
		ved = new VagaEmpregoDAO();
		
		try {
			ved.insert(id, veo);
			return true;
		} catch (SQLException e) {
			System.err.println("Impossível se conectar com o banco...");
			e.printStackTrace();
		}
		return false;
	}
	
	public void deletar(int id) {
		ved = new VagaEmpregoDAO();
		try {
			ved.delete(id);
		} catch (SQLException e) {
			System.err.println("Impossível se conectar com o banco...");
			e.printStackTrace();
		}
	}

}
