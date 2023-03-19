package br.com.dankicommerce.model;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import br.com.olimposistema.aipa.model.Model;

@Entity
public class Usuario extends Model {
	
	@NotBlank
	@Size(min = 3, max = 100)
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	private String senha;
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
