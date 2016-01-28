package br.com.leo.agenda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	@Column(name = "nome", length = 30, nullable = true)
	private String nome;
	@Column(name = "telefone", length = 15, nullable = true)
	private Integer telefone;
	@Column(name = "email", length = 60, nullable = true)
	private String email;
	@Column(name = "senha_wifi", length = 30, nullable = true)
	private String senhaWifi;
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public Integer getTelefone(){
		return telefone;
	}
	
	public void setTelefone(Integer telefone){
		this.telefone = telefone;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getSenhaWifi(){
		return senhaWifi;
	}
	
	public void setSenhaWifi(String senhaWifi){
		this.senhaWifi = senhaWifi;
	}
	
}