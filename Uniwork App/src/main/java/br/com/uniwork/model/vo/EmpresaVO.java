package br.com.uniwork.model.vo;

import br.com.uniwork.model.Conta;


public class EmpresaVO extends Conta{
	
	/**
	 * Nome da empresa
	 */
	private String nome;
	
	/**
	 * Segmento de atuação da empresa
	 */
	private String segmento;
	
	/**
	 * Cnpj vinculado à empresa
	 */
	private Long cnpj;
	
	/**
	 * Valor de confiabilidade da empresa
	 */
	private float trust;
	
	private String redeSocial;
	
	
	/**
	 * Construtor vazio
	 */
	public EmpresaVO() {

	}

	/**
	 * Construtor parâmetrizado
	 * @param nome
	 * @param id
	 * @param login
	 * @param pwd
	 * @param email
	 * @param cel
	 * @param cnpj
	 */
	public EmpresaVO(String nome, int id, String login, String pwd, String email, long cel, String endereco, long cnpj) {
		super(nome, id, login, pwd, email, (long) cel, endereco);
		this.setCnpj(cnpj);
	}

	//Getters e Setters
	@Override
	public String toString() {
		return ("Nome: " + this.getNome() + "    " + 
							"Celular: " + this.getCelular() + 
							"\nLogin: " + this.getLogin() + "    " + 
							"Senha: " + this.getPwd() + "\n" + 
							"ID: " + this.getId() + "    " + 
							"Email: " + this.getEmail() + "\n" + 
							"CNPJ: " + this.getCnpj() + "\n" + 
							"Status: " + (this.isStatus() ? "Ativa" : "Desativada") + 
							"Status Email: " + (this.isStatusEmail() ? "Autenticado" :  "Não autenticado"));
		
	}

	
	@Override
	public boolean login(String login, String pwd) {
		return false;
	}

	@Override
	public boolean logout() {
		return false;
	}

	//Getters e Setters
	
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
	 * @return the segmento
	 */
	public String getSegmento() {
		return segmento;
	}

	/**
	 * @param segmento the segmento to set
	 */
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	/**
	 * @return the cnpj
	 */
	public Long getCnpj() {
		return cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @return the trust
	 */
	public float getTrust() {
		return trust;
	}

	/**
	 * @param trust the trust to set
	 */
	public void setTrust(float trust) {
		this.trust = trust;
	}

	/**
	 * @return the redeSocial
	 */
	public String getRedeSocial() {
		return redeSocial;
	}

	/**
	 * @param redeSocial the redeSocial to set
	 */
	public void setRedeSocial(String redeSocial) {
		this.redeSocial = redeSocial;
	}


	
	
}
