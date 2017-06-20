/**
 * 
 */
package br.com.caelum.agenda.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Classe para Adicionar ou Alterar contatos.
 * 
 * Implementa a interface Logica para controle da aplicação.
 *  
 * @author matao01
 *
 */
public class AdicionaAlteraContatoLogic implements Logica {

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
		
		//Contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//Busca a conexao pendurada na request
		Connection connection = (Connection)request.getAttribute("conexao");
		
		//DAO alterado para pegar utilizar a conexao da request
		ContatoDAO dao = new ContatoDAO(connection);
		
		//DAO
		//ContatoDAO dao = new ContatoDAO();
		
		//Verifica qual operacao sera realizada
		if(id == 0){
			dao.adiciona(contato);
			System.out.println("Adicionando contato...");
		} else {
			contato.setId(id);
			dao.altera(contato);
			System.out.println("Alterando contato...");
		}
		
		return "mvc?logica=ListaContatosLogic";
	}
}
