package br.com.uniwork.model.bo;

import java.util.ArrayList;

import br.com.uniwork.model.vo.CandidatoVO;
import br.com.uniwork.model.vo.CompatibilidadeVO;
import br.com.uniwork.model.vo.HabilidadeVO;
import br.com.uniwork.model.vo.VagaEmpregoVO;

public class CompatibilidadeBO {
	private CompatibilidadeVO cp;
	
	public CompatibilidadeBO(CandidatoVO cvo, VagaEmpregoVO veo) {
		cp = new CompatibilidadeVO(veo.getIdVaga(), cvo.getId());
		compatibilidade(cvo.getCv().getHabilidades(), veo.getHabilidades());
	}
	
	// Calculando a compatibilidade entre o usuário e a vaga
		public void compatibilidade(ArrayList<HabilidadeVO> habilidadeCandidato, ArrayList<HabilidadeVO> habilidadeVaga) {
			float compat = 0;
			float valor = (100 / habilidadeVaga.size());		
			for (HabilidadeVO i : habilidadeVaga) {
				for (HabilidadeVO i2 : habilidadeCandidato) {
					if(i.getId() == i2.getId()) {
						compat = compat + valor;
					}
				}
			}
			
			cp.setCompatibilidade(Math.round(compat));;
		}
		
		

}
