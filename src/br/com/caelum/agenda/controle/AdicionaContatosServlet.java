package br.com.caelum.agenda.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDAO;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Classe que adiciona os contatos.
 * 
 * @author Matos
 * 
 * @deprecated - Substituída pela AdicionaAlteraContatoLogic
 *
 */
@WebServlet("/adicionaContato")
public class AdicionaContatosServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		//Busca o writter
		PrintWriter out = response.getWriter();
		
		//Parametros da request
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		//Formatacao da data
		try{
			Date data = new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(data);
		}catch(java.text.ParseException e ){
			out.println("Erro de conversao de data.");
			return;
		}
		
		//Monta o objeto
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//Adiciona contato 
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);

		//Imprime o nome do contato adicionado
		RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
		
		/*out.println("<html>");
		out.println("<body>");
		out.println("Contato " + contato.getNome() + " adicionado com sucesso!" );
		out.println("</body>");
		out.println("</html>");
		*/
	}
}
