package com.springboot.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.springboot.enums.RoleStatus;

@Entity
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	
	@Enumerated(EnumType.STRING)//Para ele cadastrar no banco o conteúdo do ENUM, ou seja a STRING, sem ser o número do index
	private RoleStatus status;
	
	//OneToMany -> Padrão é o FetchType.LAZY
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Funcionalidades> funcionalidades;
	
	//Constructor's
	public Perfil() {
		super();
	}
	
	public Perfil(String nome, RoleStatus status) {
		this.nome = nome;
		this.status = status;
	}
	
	public Perfil(String nome, RoleStatus status, List<Funcionalidades> funcionalidades) {
		this.nome = nome;
		this.status = status;
		this.funcionalidades = funcionalidades;
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

	public RoleStatus getStatus() {
		return status;
	}

	public void setStatus(RoleStatus status) {
		this.status = status;
	}

	public List<Funcionalidades> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidades> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	
}
