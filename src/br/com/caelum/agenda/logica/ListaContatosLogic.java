/**
 * 
 */
package br.com.caelum.agenda.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Classe que lista todos os contatos cadastrados no banco e guarda no request
 * 
 * @author Matos
 *
 */
public class ListaContatosLogic implements Logica {
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//Monta a lista de contatos
		List<Contato> contatos = new ContatoDAO().getLista();
		
		//Guarda a lista de contatos no request
		request.setAttribute("contatos", contatos);
		
		return "/WEB-INF/jsp/lista-contatos-jstl.jsp";
	}
}
