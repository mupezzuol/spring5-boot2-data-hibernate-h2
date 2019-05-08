package com.springboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
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
		
		
	}


}
