package com.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	
	//MUITOS User -> UM Role
	//Eu posso ter vários usuários com o mesmo perfil
	//ManyToOne -> Ele trás toda a hierarquia do objeto, faz o inner join, pois por default ele usa FetchType.EAGER (TRÁS TUDO DO BANCO)
	//CascadeType.PERSIST -> Caso eu insira um User que o Role ainda não existe, ele habilita pra salvar o Role, e dps o User.
	@ManyToOne//(cascade = CascadeType.PERSIST)
	private Role role;
	
	
	//Constructor's
	public User() {
		super();
	}
	
	public User(String nome, String email, Role role) {
		super();
		this.nome = nome;
		this.email = email;
		this.role = role;
	}
	
	
	//Getter's and Setter's
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
