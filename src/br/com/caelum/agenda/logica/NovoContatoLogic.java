/**
 * 
 */
package br.com.caelum.agenda.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe que direciona para a página de inclusão de contato.
 * 
 * @author matao01
 *
 */
public class NovoContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		System.out.println("Preparando para adicionar contato...");
		
		return "/WEB-INF/jsp/adiciona-contato.jsp";
	}
}
