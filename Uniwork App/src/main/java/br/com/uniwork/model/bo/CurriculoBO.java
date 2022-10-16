package br.com.uniwork.model.bo;

import br.com.uniwork.model.vo.CurriculoVO;
import br.com.uniwork.model.vo.HabilidadeVO;

public class CurriculoBO {
	
	private CurriculoVO cv;

	/**
	 * Adiciona uma habilidade
	 * @param idHabilidade
	 */
	public void addHabilidade(HabilidadeVO h) {
		cv.getHabilidades().add(h);
	}
	
}
