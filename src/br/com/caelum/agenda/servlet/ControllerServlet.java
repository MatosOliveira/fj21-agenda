/**
 * 
 */
package br.com.caelum.agenda.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.logica.Logica;

/**
 * Servlet que controla o fluxo da aplicação
 * 
 * @author Matos
 *
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		String parametro = request.getParameter("logica");
		String nomeClasse = "br.com.caelum.agenda.logica." + parametro;
		
		try {
			
			Class<?> classe = Class.forName(nomeClasse);
			
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			request.getRequestDispatcher(pagina).forward(request, response); 
			
		} catch(Exception e){
			throw new ServletException("A logica de negócios causou uma exceção.", e);
		}
		
	}
}
