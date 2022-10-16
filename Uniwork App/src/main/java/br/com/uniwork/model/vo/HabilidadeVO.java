package br.com.uniwork.model.vo;
/**
 * Classe que abstrai as habilidades do candidato
 * @author mateus-cabral
 * @version 1.0
 */
public class HabilidadeVO {
	
	/**
	 * Id da habilidade no sistema
	 */
	private int id;
	
	/**
	 * Nome da habilidade
	 */
	private String nome;
	
	/**
	 * Descrição da habilidade
	 */
	private String descricao;
	
	/**
	 * Tipo/Categoria da habilidade
	 */
	private String tipo;
	
	
	/**
	 * Construtor vazio
	 */
	public HabilidadeVO() {
		
	}
	 
	/**
	 * Construtor parâmetrizado 
	 * @param id
	 * @param nome
	 * @param descricao
	 * @param tipo
	 */
	public HabilidadeVO(int id, String nome, String descricao, String tipo) {
		this.setDescricao(descricao);
		this.setId(id);
		this.setNome(nome);
		this.setTipo(tipo);
	}

	
	/**
	 * Método para enviar dados pelo DAO
	 * @param h habilidade
	 */
	public void cadastrarHabilidade(HabilidadeVO h) {
		
	}
	
	//Getters e Setters
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descrição to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
