/**
 * 
 */
package br.com.caelum.agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface que cont�m o m�todo executa a ser implementado pelas classes de controle.
 * 
 * @author Matos
 *
 */
public interface Logica {

	String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception;
}
