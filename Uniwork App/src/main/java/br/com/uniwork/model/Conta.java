package br.com.uniwork.model;

import br.com.uniwork.model.interfaces.SistemaLogin;

/**
 * Classe que abstrai Conta de usuários.
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
	private Long celular;
	
	/**
	 * Se o email está verificado no sistema
	 */
	private boolean statusEmail;
	
	/**
	 * Se a conta está ativa
	 */
	private boolean status;
	
	/**
	 * Endereco do usuário
	 */
	private String endereco;
	
	/**
	 * Construtor vazio
	 */
	public Conta() {
		
	}
	
	/**
	 * Construtor parâmetrizado
	 * @param nome
	 * @param id
	 * @param login
	 * @param pwd
	 * @param email
	 * @param cel
	 */
	public Conta(String nome, int id, String login, String pwd, String email, Long cel, String endereco) {
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
	
	public Conta(String nome, int id, String login, String pwd, String email, Long cel) {
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
	 * Verificação de email - só será autenticado caso a conta esteja ativa
	 */
	public void autenticarEmail() {
		if(this.isStatus()) {
			if(this.isStatusEmail()) {
				System.out.println("Erro: Conta já autenticada");
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
			System.out.println("Credenciais inválidas");
		}
	}
	
	
	/**
	 * Alteração e reset de senha
	 */
	public void resetSenha() {
		if(this.isStatus()) {
			this.setPwd("Padrao");
		}   else  {
			System.out.println("Erro: Conta Desativada");
		}
		
	};
	
	/**
	 * Alteração de senha
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
	 * Método para enviar dados pelo DAO
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


	public Long getCelular() {
		return celular;
	}


	public void setCelular(Long celular) {
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
