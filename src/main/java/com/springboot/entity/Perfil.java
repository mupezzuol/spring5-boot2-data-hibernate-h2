package com.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.springboot.enums.RoleStatus;

@Entity
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	
	@Enumerated(EnumType.STRING)//Para ele cadastrar no banco o conteúdo do ENUM, ou seja a STRING, sem ser o número do index
	private RoleStatus status;
	
	//Constructor's
	public Perfil() {
		super();
	}
	
	public Perfil(String nome, RoleStatus status) {
		this.nome = nome;
		this.status = status;
	}

	
	//Getter's and Setter's
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return nome;
	}
	public void setName(String nome) {
		this.nome = nome;
	}
	public RoleStatus getStatus() {
		return status;
	}

	public void setStatus(RoleStatus status) {
		this.status = status;
	}
}
