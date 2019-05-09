package com.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String email;
	
	//OneToMany -> Por padrão é utilizado FetchType.LAZY, portanto ele não trará os perfis, precisamos forçar o carregamento EAGER
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Perfil> perfis;
	
	
	//Constructor's
	public Usuario() {
		super();
	}
	
	public Usuario(String nome, String email, List<Perfil> perfiis) {
		super();
		this.nome = nome;
		this.email = email;
		this.perfis = perfiis;
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

	public List<Perfil> getPerfiis() {
		return perfis;
	}

	public void setPerfiis(List<Perfil> perfiis) {
		this.perfis = perfiis;
	}

}
