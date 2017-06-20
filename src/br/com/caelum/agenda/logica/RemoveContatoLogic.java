/**
 * 
 */
package br.com.caelum.agenda.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Classe que realiza a remoção de um contato com base no ID informado.
 * 
 * Implementa a interface Logica para controle da aplicação.
 * 
 * @author Matos
 *
 */
public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		//Busca a conexao pendurada na request
		Connection connection = (Connection)request.getAttribute("conexao");
				
		//DAO alterado para pegar utilizar a conexao da request
		ContatoDAO dao = new ContatoDAO(connection);
				
		//ContatoDAO dao = new ContatoDAO();
		
		dao.remove(contato);
		
		System.out.println("Removendo contato...");
		
		return "mvc?logica=ListaContatosLogic";
	}
}
