package com.oberdan.listavip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity(name = "convidados")
public class Convidado extends AbstractEntity{
	
	@Column(nullable=false, length=50)
	@NotEmpty
	private String nome;
	
	@Column(nullable=false, length=100)
	@NotEmpty
	@Email
	private String email;
	
	@Column(nullable=false, length=14)
	@NotEmpty
	private String telefone;

	public Convidado() {
	}

	public Convidado(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	@Override
	public String toString() {
		return "Convidado [id=" + super.getId() + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
	}
}
