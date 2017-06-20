/**
 * 
 */
package br.com.caelum.agenda.dao;

/**
 * Classe para tratamento das Exceptions
 * 
 * @author matao01
 *
 */
public class DAOException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da classe
	 * 
	 * @param mensagem
	 * 			Mensagem de texto
	 * @param e
	 * 		  Objeto do tipo Exception
	 */
	public DAOException(String mensagem, Exception e){
		super(mensagem, e);
	}
	
	/**
	 * Construtor da classe
	 * 
	 * @param mensagem
	 * 			Mensagem de texto
	 */
	public DAOException(String mensagem){
		super(mensagem);
	}
	
	/**
	 * Construtor da classe
	 * 
	 * @param e
	 * 		  Objeto do tipo Exception
	 */
	public DAOException(Exception e){
		super(e);
	}
}
