package br.com.uniwork.model;

import br.com.uniwork.model.interfaces.SistemaLogin;

/**
 * Classe que abstrai Conta de usu�rios.
 * @author mateus-cabral
 * @version 1.0
 */
public abstract class Conta implements SistemaLogin{
	
	/**
	 * Nome da conta
	 */
	private String nome;
	
	/**
	 * Id da conta no banco de dados
	 */
	private int id;
	
	/**
	 * Login da conta no sistema
	 */
	private String login;
	
	/**
	 * Senha da conta no sistema
	 */
	private String pwd;
	
	/**
	 * Email cadastrado no sistema
	 */
	private String email;
	
	/**
	 * Celular de contato
	 */
	private String celular;
	
	/**
	 * Se o email est� verificado no sistema
	 */
	private boolean statusEmail;
	
	/**
	 * Se a conta est� ativa
	 */
	private boolean status;
	
	/**
	 * Endereco do usu�rio
	 */
	private String endereco;
	
	/**
	 * Construtor vazio
	 */
	public Conta() {
		
	}
	
	/**
	 * Construtor par�metrizado
	 * @param nome
	 * @param id
	 * @param login
	 * @param pwd
	 * @param email
	 * @param cel
	 */
	public Conta(String nome, int id, String login, String pwd, String email, String cel, String endereco) {
		this.setNome(nome);
		this.setId(id);
		this.setLogin(login);
		this.setPwd(pwd);
		this.setEmail(email);
		this.setCelular(cel);
		this.setStatus(true);
		this.setStatusEmail(false);
		this.setEndereco(endereco);
	}
	
	public Conta(String nome, int id, String login, String pwd, String email, String cel) {
		this.setNome(nome);
		this.setId(id);
		this.setLogin(login);
		this.setPwd(pwd);
		this.setEmail(email);
		this.setCelular(cel);
		this.setStatus(true);
		this.setStatusEmail(false);
	}
	
	
	/**
	 * Verifica��o de email - s� ser� autenticado caso a conta esteja ativa
	 */
	public void autenticarEmail() {
		if(this.isStatus()) {
			if(this.isStatusEmail()) {
				System.out.println("Erro: Conta j� autenticada");
			}	else   {
				this.setStatusEmail(true);
			}
		}	else  {
			System.out.println("Erro: Conta Desativada");
		}
		
	}
	
	
	/**
	 * Fechamento de Conta
	 * @param login
	 * @param pwd
	 */
	public void fecharConta(String login, String pwd) {
		if(this.getLogin() == login && this.getPwd() == pwd){
			this.setStatus(false);
		}	else {
			System.out.println("Credenciais inv�lidas");
		}
	}
	
	
	/**
	 * Altera��o e reset de senha
	 */
	public void resetSenha() {
		if(this.isStatus()) {
			this.setPwd("Padrao");
		}   else  {
			System.out.println("Erro: Conta Desativada");
		}
		
	};
	
	/**
	 * Altera��o de senha
	 * @param novaPwd
	 */
	public void alterarSenha(String novaPwd) {
		if(this.isStatus()) {
			this.setPwd(novaPwd);
		}	else {
			System.out.println("Erro: Conta Desativada");
		}
		
	};
	
	/**
	 * M�todo para enviar dados pelo DAO
	 * @param c conta
	 */
	public void cadastrarConta(Conta c) {
		
	}
	
	
	//Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isStatusEmail() {
		return statusEmail;
	}

	public void setStatusEmail(boolean statusEmail) {
		this.statusEmail = statusEmail;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}
