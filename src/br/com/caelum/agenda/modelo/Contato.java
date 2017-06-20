/**
 * 
 */
package br.com.caelum.agenda.modelo;

import java.util.Calendar;

/**
 * Classe que cont�m as informa��es de um contato
 * 
 * @author matao01
 *
 */
public class Contato {

	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Calendar getDataNascimento(){
		return this.dataNascimento; 
	}
	
	public void setDataNascimento(Calendar dataNascimento){
		this.dataNascimento = dataNascimento;
	}
}
