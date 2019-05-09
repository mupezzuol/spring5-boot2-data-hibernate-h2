package com.springboot.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Perfil perfil;
	
	
	//Constructor's
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String email, Perfil perfil) {
		super();
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
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

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}


}
