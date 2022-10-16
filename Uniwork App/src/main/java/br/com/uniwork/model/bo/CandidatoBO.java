package br.com.uniwork.model.bo;

import java.sql.SQLException;
import java.util.List;

import br.com.uniwork.dao.CandidatoDAO;
import br.com.uniwork.model.exceptions.MenorDeIdadeException;
import br.com.uniwork.model.vo.CandidatoVO;


public class CandidatoBO {
	
	private CandidatoDAO cd;
	
	public List<CandidatoVO> listar() throws SQLException {
		cd = new CandidatoDAO();
		return cd.select();
	}
	
	public CandidatoVO listar(int id) throws SQLException {
		cd = new CandidatoDAO();
		return cd.select(id);
	}
	
	public boolean cadastrar(CandidatoVO cvo) throws MenorDeIdadeException{
		if (cvo.getIdade() <= 16) {
			throw new MenorDeIdadeException("Menores de idade não podem se cadastrar");
		}
		try {
			cd = new CandidatoDAO();
			cd.insert(cvo);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean atualizar(int id, CandidatoVO cvo) {
		try {
			cd = new CandidatoDAO();
			cd.update(id, cvo.getNome());
			return true;
		} catch (SQLException e) {
			System.err.println("Algo deu errado no banco de dados...");
			e.printStackTrace();
		}
		return false;

	}
	
	public boolean deletar(int id) {
		try {
			cd = new CandidatoDAO();
			cd.delete(id);
			return true;
		} catch (SQLException e) {
			System.err.println("Algo deu errado no banco de dados...");
			e.printStackTrace();
		}
		return false;
	}
	
}
