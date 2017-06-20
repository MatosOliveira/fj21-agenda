/**
 * 
 */
package br.com.caelum.agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe que implementa a interface criada para testar o controle da aplica��o
 * 
 * @author Matos
 *
 */
public class PrimeiraLogica implements Logica {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Executando a logica ... ");
		
		System.out.println("Retornando o nome da p�gina JSP ... ");
		
		return "primeira-logica.jsp";
	}
}
