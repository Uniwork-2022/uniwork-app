package br.com.uniwork.model.vo;

/**
 * Classe que abstrai os testes (provas) que serão feitas pelo candidato
 * @author mateus-cabral
 * @version 1.0
 */


import java.util.ArrayList;

public class TesteVO {
	/**
	 * ID do teste no banco de dados
	 */
	private int idTeste;
	
	
	/**
	 * Nome do teste
	 */
	private String nome;
	
	
	/**
	 * Tipo/Categoria do teste
	 */
	private String tipoTestes;
	
	
	/**
	 * Lista de perguntas do teste
	 */
	private ArrayList<PerguntaVO> perguntas = new ArrayList<PerguntaVO>();
	
	
	/**
	 * Lista de Usuários que fizeram o teste
	 */
	private CandidatoVO candidato = new CandidatoVO();
	
	
	/**
	 * Lista de respostas de um candidato, será armazenado acerto ou erro
	 */
	private ArrayList<Boolean> userResposta = new ArrayList<Boolean>();
	
	
	/**
	 * Construtor vazio
	 */
	public TesteVO() {
		
	}
	
	/**
	 * Construtor parametrizado
	 * @param id
	 * @param nome
	 */
	public TesteVO(int id, String nome) {
		this.setIdTeste(id);
		this.setNome(nome);
	}
	
	
	//Adiciona o acerto ou erro do usuário à uma lista
	public void responder(int respostaUser, int resposta) {
		if (respostaUser == resposta) {
			this.getUserResposta().add(true);
			System.out.println("Correto");
			
		} else {
			this.getUserResposta().add(false);
			System.out.println("Incorreto");
		}
	}
	
	
	// Cadastro de usuario
	public void cadastrarUser(CandidatoVO user) {
		this.setCandidato(user);;
	}
	
	
	// Cadastro de perguntas
	public void cadastrarPergunta(PerguntaVO pergunta) {
		this.getPerguntas().add(pergunta);
	}
	

	
	/**
	 * Método para enviar dados pelo DAO
	 * @param teste
	 */
	public void cadastrarTeste(TesteVO teste) {
		
	}

	
	//Getters e Setters
	
	/**
	 * @return the idTeste
	 */
	public int getIdTeste() {
		return idTeste;
	}

	/**
	 * @param idTeste the idTeste to set
	 */
	public void setIdTeste(int idTeste) {
		this.idTeste = idTeste;
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
	 * @return the candidato
	 */
	public CandidatoVO getCandidato() {
		return candidato;
	}

	/**
	 * @param candidato the candidato to set
	 */
	public void setCandidato(CandidatoVO candidato) {
		this.candidato = candidato;
	}

	/**
	 * @return the tipoTestes
	 */
	public String getTipoTestes() {
		return tipoTestes;
	}

	/**
	 * @param tipoTestes the tipoTestes to set
	 */
	public void setTipoTestes(String tipoTestes) {
		this.tipoTestes = tipoTestes;
	}

	/**
	 * @return the perguntas
	 */
	public ArrayList<PerguntaVO> getPerguntas() {
		return perguntas;
	}

	/**
	 * @param perguntas the perguntas to set
	 */
	public void setPerguntas(ArrayList<PerguntaVO> perguntas) {
		this.perguntas = perguntas;
	}


	/**
	 * @return the userResposta
	 */
	public ArrayList<Boolean> getUserResposta() {
		return userResposta;
	}

	/**
	 * @param userResposta the userResposta to set
	 */
	public void setUserResposta(ArrayList<Boolean> userResposta) {
		this.userResposta = userResposta;
	}
	

}

