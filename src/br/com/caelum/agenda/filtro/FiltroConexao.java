/**
 * 
 */
package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.caelum.agenda.factory.ConnectionFactory;

/**
 * Classe que controla a abertura e fechamento de conexão com o banco de dados.
 * 
 * @author Matos
 *
 */
@WebFilter("/*")
public class FiltroConexao implements Filter {

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
		
			//Abre a conexão
			Connection connection = new ConnectionFactory().getConnection();
			
			//Pendura um objeto no Request
			request.setAttribute("conexao", connection);
			
			//Indica que o processamento deve prosseguir
			chain.doFilter(request, response);
			
			//Fecha a conexão
			connection.close();
			
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
}
