package br.com.uniwork.model.vo;

/**
 * Classe que calcula a compatibilidade de um candidato com uma vaga.
 * @author mateus-cabral
 * @version 1.0
 */

public class CompatibilidadeVO {
	
	/**
	 * Id da proposta no banco de dados
	 */
	private int idProposta;
	
	/**
	 * Id da conta no banco de dados
	 */
	private int idConta;
	
	/**
	 * Valor de compatibilidade entre candidato e vaga. Entre 0 e 100
	 */
	private int compatibilidade;
	
	/**
	 * Construtor vazio
	 */
	public CompatibilidadeVO() {
		
	}
	
	/**
	 * Construtor parâmetrizado 
	 * @param idProposta
	 * @param idUser
	 */
	public CompatibilidadeVO(int idProposta, int idUser) {
		this.setIdConta(idUser);
		this.setIdProposta(idProposta);
	}
	
	
	
	//Getters e Setters
	
	/**
	 * @return the idProposta
	 */
	public int getIdProposta() {
		return idProposta;
	}

	/**
	 * @param idProposta the idProposta to set
	 */
	public void setIdProposta(int idProposta) {
		this.idProposta = idProposta;
	}

	/**
	 * @return the idConta
	 */
	public int getIdConta() {
		return idConta;
	}

	/**
	 * @param idConta the idConta to set
	 */
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}

	/**
	 * @return the compatibilidade
	 */
	public int getCompatibilidade() {
		return compatibilidade;
	}

	/**
	 * @param compatibilidade the compatibilidade to set
	 */
	public void setCompatibilidade(int compatibilidade) {
		this.compatibilidade = compatibilidade;
	}
	
}
