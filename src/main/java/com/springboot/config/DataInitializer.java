package com.springboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.enums.RoleStatus;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		//Criando e Salvando as Roles
		Role role1 = new Role("admin",RoleStatus.ATIVO);
		Role role2 = new Role("aluno",RoleStatus.INATIVO);
		Role role3 = new Role("aux",RoleStatus.ATIVO);
		this.roleRepository.save(role1);
		this.roleRepository.save(role2);
		this.roleRepository.save(role3);
		
		//Criando e Salvando Users com as Roles setadas
		User user1 = new User("Murillo Pezzuol","murillopezzuol@hotmail.com",role1);//Role1 -> admin
		User user2 = new User("Gabriella Monteiro","gabriella_monteiroaz@hotmail.com",role2);//Role2 -> aluno
		User user3 = new User("User 3","user3@hotmail.com",role2);//Role2 -> aluno
		this.userRepository.save(user1);
		this.userRepository.save(user2);
		this.userRepository.save(user3);
		
		
		//Buscando ROLES que estão ATIVAS
		List<Role> roles = this.roleRepository.findByStatus(RoleStatus.ATIVO);
		for (Role role : roles) {
			System.out.println(role.getName());
		}
		
		
		
		
		//PAGINAÇÃO
		//Cadastro 1000 Role, para eu testar a criação da paginação
		for (int i = 0; i < 1000; i++) {
			Role role = new Role("paginacaoTeste",RoleStatus.ATIVO);
			this.roleRepository.save(role);
		}
		
		//Crio paginação, de 10 página com 10 itens cada uma
		PageRequest page = PageRequest.of(10, 10);
		
		//Crio minha lista com a busca de todos porém com a paginação na query
		Page<Role> rolesPage = this.roleRepository.findAll(page);
		
		//Listo 10 itens, de acordo com a regra da paginação criada
		System.out.println();
		System.out.println("LISTA DE ROLE COM PAGINAÇÃO:");
		for (Role role : rolesPage) {
			System.out.println(role.getName());
		}
		
		
		
	}


}
