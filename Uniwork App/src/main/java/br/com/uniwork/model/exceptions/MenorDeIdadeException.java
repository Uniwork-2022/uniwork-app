/**
 * 
 */
package br.com.uniwork.model.exceptions;

/**
 * @author Mateus Cabral
 * @version 1.0
 */
public class MenorDeIdadeException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6890558513601971507L;

	public MenorDeIdadeException(String errorMessage) {
		super(errorMessage);
	}
}
