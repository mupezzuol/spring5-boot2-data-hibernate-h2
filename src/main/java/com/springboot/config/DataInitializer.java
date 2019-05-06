package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springboot.entity.Role;
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
		Role role1 = new Role("admin");
		Role role2 = new Role("aluno");
		this.roleRepository.save(role1);
		this.roleRepository.save(role2);
		
		
		
		
		
	}


}
