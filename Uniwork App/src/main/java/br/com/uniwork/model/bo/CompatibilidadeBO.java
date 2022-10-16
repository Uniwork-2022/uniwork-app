package br.com.uniwork.model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.uniwork.dao.CompatibilidadeDAO;
import br.com.uniwork.model.vo.CandidatoVO;
import br.com.uniwork.model.vo.CompatibilidadeVO;
import br.com.uniwork.model.vo.HabilidadeVO;
import br.com.uniwork.model.vo.VagaEmpregoVO;

public class CompatibilidadeBO {
	private CompatibilidadeDAO cpd;
	private CompatibilidadeVO cpvo;
	
	public CompatibilidadeBO() {
		
	}

	public CompatibilidadeBO(CandidatoVO cvo, VagaEmpregoVO veo) {
		cpvo = new CompatibilidadeVO(veo.getIdVaga(), cvo.getId());
		compatibilidade(cvo.getCv().getHabilidades(), veo.getHabilidades());
	}

	// Calculando a compatibilidade entre o usuário e a vaga
	public void compatibilidade(ArrayList<HabilidadeVO> habilidadeCandidato, ArrayList<HabilidadeVO> habilidadeVaga) {
		float compat = 0;
		float valor = (100 / habilidadeVaga.size());
		for (HabilidadeVO i : habilidadeVaga) {
			for (HabilidadeVO i2 : habilidadeCandidato) {
				if (i.getId() == i2.getId()) {
					compat = compat + valor;
				}
			}
		}

		cpvo.setCompatibilidade(Math.round(compat));
		;
	}

	/**
	 * Retorna todas as compatibilidades armazenadas no sistema
	 * @return compatibilidades
	 * @throws SQLException
	 */
	public List<CompatibilidadeVO> listar() throws SQLException {
		cpd = new CompatibilidadeDAO();
		return cpd.select();
	}

	public CompatibilidadeVO listar(int idCandidato) throws SQLException {
		cpd = new CompatibilidadeDAO();
		return cpd.select(idCandidato);
	}
	
	public boolean cadastrar(CompatibilidadeVO cvo) {
		cpd = new CompatibilidadeDAO();
		try {
			cpd.insert(cvo);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro na operação no banco...");
			e.printStackTrace();
		}
		return false;
	}
	

	
	public boolean deletar(int idProposta, int idCandidato) {
		cpd = new CompatibilidadeDAO();
		try {
			cpd.delete(idProposta, idCandidato);
			return true;
		} catch (SQLException e) {
			System.err.println("Erro na operação no banco...");
			e.printStackTrace();
		}
		return false;
	}

}
