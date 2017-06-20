/**
 * 
 */
package br.com.caelum.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.agenda.factory.ConnectionFactory;
import br.com.caelum.agenda.modelo.Contato;

/**
 * Classe responsavel por gerenciar a conexao e inserir um novo contato 
 * no banco de dados
 * 
 * @author matao01
 *
 */
public class ContatoDAO {

	// a conexao com o banco de dados
	private Connection connection;
	
	/**
	 * Construtor da classe - responsavel pela conexao com o banco de dados
	 */
	public ContatoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	/**
	 * Construtor da classe
	 * 
	 * @param connection
	 * 			Objeto do tipo Connection para ser utilizado nos filtros 
	 */
	public ContatoDAO(Connection connection){
		this.connection = connection;
	}
	
	/**
	 * Metodo utilizado para adicionar um novo contato no banco de dados
	 * 
	 * @param contato
	 * 			Objeto do tipo Contato
	 */
	public void adiciona(Contato contato){
		
		// Query SQL
		String sql = "insert into Contatos" +
				"(nome, email, endereco, dataNascimento)" +
				"values(?, ?, ?, ?)" ;
		
		try {
			
			//Prepared statement para insercao
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			//Seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa
			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Metodo utilizado para retornar a lista de contatos cadastrado no banco de dados
	 * 
	 * @return
	 * 		Lista de objetos do tipo List<Contato>
	 * 
	 */
	public List<Contato> getLista(){
		try {
			
			List<Contato> listaContatos = new ArrayList<Contato>();
			
			PreparedStatement stmt = this.connection.
					prepareStatement("select * from Contatos");
			ResultSet rs = stmt.executeQuery();
			
			//Navega pelos registros no banco de dados
			//Retorna false quando terminar a pesquisa
			while(rs.next()){
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//Montando a data atraves de Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//Adicionando o objeto a lista
				listaContatos.add(contato);
			}
			rs.close();
			stmt.close();
			
			return listaContatos;
			
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	/**
	 * Metodo utilizado para retornar a lista de contatos mais refinada 
	 * 
	 * @param iniciaisNome
	 * 		Primeiras letras do nome
	 * @return
	 * 		Lista de objetos do tipo List<Contato>
	 * 
	 */
	public List<Contato> getListaRefinada(String iniciaisNome){
		try {
			
			List<Contato> listaContatos = new ArrayList<Contato>();
			
			PreparedStatement stmt = this.connection.prepareStatement(
					"select * from Contatos where nome like '" + iniciaisNome + "%'");
			ResultSet rs = stmt.executeQuery();
			
			//Navega pelos registros no banco de dados
			//Retorna false quando terminar a pesquisa
			while(rs.next()){
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//Montando a data atraves de Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//Adicionando o objeto a lista
				listaContatos.add(contato);
			}
			rs.close();
			stmt.close();
			
			return listaContatos;
			
		} catch (SQLException e) {
			throw new DAOException("Erro na busca do contato.", e);
		}
	}
	
	/**
	 * Metodo utilizado para retornar as informacoes de um contato 
	 * por meio de um id especifico
	 * 
	 * @param id
	 * 		Id do contato
	 * @return
	 * 		Objeto do tipo Contato
	 */
	public Contato pesquisa(int id){
		
		try {
			
			PreparedStatement stmt = this.connection.
				prepareStatement("select * from Contatos where id = " + id);
			ResultSet rs = stmt.executeQuery();
			
			Contato contato = new Contato();
			
			//Navega pelos registros no banco de dados
			//Retorna false quando terminar a pesquisa
			while(rs.next()){
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				

				//Montando a data atraves de Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
			
			return contato;
			
		} catch (SQLException e) {
			throw new DAOException("Contato nao encontrado." + e);
		}
		
	}
	
	/**
	 * Metodo utilizado para realizar alteracoes nas informacoes de um contato
	 * 
	 * @param contato
	 * 			Objeto do tipo Contato
	 */
	public void altera(Contato contato){
		String sql = "update Contatos set "
							+ " nome=?"
							+ ", email=?"
							+ ", endereco=?"
							+ ", dataNascimento=? "
					+ "where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new DAOException("Erro ao tentar alterar um contato.", e);
		}
		
	}
	
	/**
	 * Metodo utilizado para remover contatos do banco de dados
	 * 
	 * @param contato
	 * 			Objeto do Tipo Contato
	 */
	public void remove(Contato contato){
		String sql = "delete from Contatos where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException("Erro ao tentar remover um contato.", e);
		}
	}
}
