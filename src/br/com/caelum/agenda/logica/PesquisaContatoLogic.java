/**
 * 
 */
package br.com.caelum.agenda.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.modelo.Contato;

/**
 * Classe que pesquisa um contato no banco, guarda as informações na request e depois
 * direciona para a página de alteração.
 * 
 * @author matao01
 *
 */
public class PesquisaContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//Recuperando os dados 
		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		
		//Formatacao da data
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		try {
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		} catch (ParseException e) {
			System.out.println("Erro de conversao de data.");
		}
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//Guardando informacoes do contato a ser alterado
		request.setAttribute("contato", contato);
		
		System.out.println("Pesquisando contato...");
		
		return "/WEB-INF/jsp/altera-contato.jsp";
	}

	
}
