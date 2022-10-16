package br.com.uniwork.model.vo;
/**
 * Classe que abstrai uma proposta de emprego dentro do sistema.
 * @author mateus-cabral
 * @version 1.0
 */
import java.util.ArrayList;



public class VagaEmpregoVO {
	
	/**
	 * Id da proposta no banco de dados
	 */
	private int idVaga;
	
	/**
	 * Id da empresa no banco de dados
	 */
	private int idEmpresa;
	
	/**
	 * Nome do cargo
	 */
	private String nomeCargo;
	
	/**
	 * Descrição do comportamento e responsabilidades esperados
	 */
	private String descritivo;
	
	/**
	 * Salário
	 */
	private double salario;
	
	private String beneficios;
	
	/**
	 * Localização do cargo
	 */
	private String local;
	
	/**
	 * Lista de habilidades requisitadas
	 */
	private ArrayList<HabilidadeVO> habilidades = new ArrayList<HabilidadeVO>();
	
	/**
	 * Lista de candidatos candidatados
	 * @deprecated
	 */
	private ArrayList<CandidatoVO> candidatos = new ArrayList<CandidatoVO>();
	
	/**
	 * Verifica se a proposta está ativa
	 * @deprecated
	 */
	private boolean status;
	
	/**
	 * Construtor vazio
	 */
	public VagaEmpregoVO() {
		
	}
	
	/**
	 * Construtor parametrizado
	 * @param idProposta int
	 * @param idEmpresa int
	 * @param nomeCargo String
	 * @param descritivo String
	 * @param salario float
	 * @param local String
	 * @param skills ArrayList<Integer>
	 */
	public VagaEmpregoVO(int idVaga, int idEmpresa, String nomeCargo, String descritivo, double salario, String local, ArrayList<HabilidadeVO> skills, String beneficios) {
		this.setIdVaga(idVaga);
		this.setEmpresa(idEmpresa);
		this.setNomeCargo(nomeCargo);
		this.setDescritivo(descritivo);
		this.setSalario(salario);
		this.setLocal(local);
		this.setHabilidades(skills);
		this.setStatus(true);
		this.setBeneficios(beneficios);
	}
	
	//Cadastro de usuários
	public void candidatar(CandidatoVO c) {
		this.getCandidatos().add(c);
	}
	
	/**
	 * Método para enviar dados pelo DAO
	 * @param vaga
	 */
	public void cadastrarVaga(VagaEmpregoVO vaga) {
		
	}
	
	
	//Fechamento da vaga
	public void fecharProposta() {
		this.setStatus(false);
	}

	
	//Getters e Setters
	
	/**
	 * @return the idVaga
	 */
	public int getIdVaga() {
		return idVaga;
	}

	/**
	 * @param idVaga the idVaga to set
	 */
	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}

	/**
	 * @return the empresa
	 */
	public int getEmpresa() {
		return idEmpresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(int empresa) {
		idEmpresa = empresa;
	}
	
	/**
	 * @return the nomeCargo
	 */
	public String getNomeCargo() {
		return nomeCargo;
	}

	/**
	 * @param nomeCargo the nomeCargo to set
	 */
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	/**
	 * @return the descritivo
	 */
	public String getDescritivo() {
		return descritivo;
	}

	/**
	 * @param descritivo the descritivo to set
	 */
	public void setDescritivo(String descritivo) {
		this.descritivo = descritivo;
	}

	/**
	 * @return the salario
	 */
	public double getSalario() {
		return salario;
	}

	/**
	 * @param salario the salario to set
	 */
	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * @return the local
	 */
	public String getLocal() {
		return local;
	}

	/**
	 * @param local the local to set
	 */
	public void setLocal(String local) {
		this.local = local;
	}

	/**
	 * @return the habilidades
	 */
	public ArrayList<HabilidadeVO> getHabilidades() {
		return habilidades;
	}

	/**
	 * @param habilidades the habilidades to set
	 */
	public void setHabilidades(ArrayList<HabilidadeVO> habilidades) {
		this.habilidades = habilidades;
	}

	/**
	 * @return the candidatos
	 */
	public ArrayList<CandidatoVO> getCandidatos() {
		return candidatos;
	}

	/**
	 * @param candidatos the candidatos to set
	 */
	public void setCandidatos(ArrayList<CandidatoVO> candidatos) {
		this.candidatos = candidatos;
	}

	
	/**
	 * @return the status
	 */
	public boolean isStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(boolean status) {
		this.status = status;
	}

	/**
	 * @return the beneficios
	 */
	public String getBeneficios() {
		return beneficios;
	}

	/**
	 * @param beneficios the beneficios to set
	 */
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

}
