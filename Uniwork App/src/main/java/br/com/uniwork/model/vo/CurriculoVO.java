package br.com.uniwork.model.vo;

/**
 * Classe que abstrai o currículo do candidato, de acordo com as habilidades do sistema.
 * Deve começar sem habilidades
 * @author mateus-cabral
 * @version 1.0
 */

import java.util.ArrayList;

public class CurriculoVO{

	/**
	 * Id do currículo no banco de dados
	 */
	private int id;
	
	private int idCandidato;
	
	/**
	 * Lista de habilidades do candidatoa
	 */
	private ArrayList<HabilidadeVO> habilidades = new ArrayList<HabilidadeVO>();
	
	/**
	 * Objetivo profissional do candidato
	 */
	private String objetivoProfissional;
	
	/**
	 * Experiencia profissional do candidato
	 */
	private String experienciaProfissional;
	
	/**
	 * Formação acadêmica anterior do candidato
	 */
	private String formacaoAcademica;
	
	/**
	 * Valor da pretensão salarial do candidato
	 */
	private int pretensaoSalarial;
	
	/**
	 * Construtor vazio
	 */
	public CurriculoVO() {
		
	}
	
	/**
	 * Construtor parâmetrizado
	 */
	public CurriculoVO(int id, int candidato) {
		this.setId(id);
		this.setIdCandidato(candidato);
	}
	
	

	
	/**
	 * Método para enviar dados pelo DAO
	 * @param cv
	 */
	public void cadastrarCurriculo(CurriculoVO cv) {
		
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
	 * @return the candidato
	 */
	public int getIdCandidato() {
		return idCandidato;
	}

	/**
	 * @param candidato the candidato to set
	 */
	public void setIdCandidato(int candidato) {
		this.idCandidato = candidato;
	}

	/**
	 * @return the objetivoProfissional
	 */
	public String getObjetivoProfissional() {
		return objetivoProfissional;
	}

	/**
	 * @param objetivoProfissional the objetivoProfissional to set
	 */
	public void setObjetivoProfissional(String objetivoProfissional) {
		this.objetivoProfissional = objetivoProfissional;
	}

	/**
	 * @return the experienciaProfissional
	 */
	public String getExperienciaProfissional() {
		return experienciaProfissional;
	}

	/**
	 * @param experienciaProfissional the experienciaProfissional to set
	 */
	public void setExperienciaProfissional(String experienciaProfissional) {
		this.experienciaProfissional = experienciaProfissional;
	}

	/**
	 * @return the pretensaoSalarial
	 */
	public int getPretensaoSalarial() {
		return pretensaoSalarial;
	}

	/**
	 * @param pretensaoSalarial the pretensaoSalarial to set
	 */
	public void setPretensaoSalarial(int pretensaoSalarial) {
		this.pretensaoSalarial = pretensaoSalarial;
	}

	/**
	 * @return the formacaoAcademica
	 */
	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}

	/**
	 * @param formacaoAcademica the formacaoAcademica to set
	 */
	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}
	
}
