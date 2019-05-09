package com.springboot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.enums.RoleStatus;
import com.springboot.repository.UserRepository;

@Component
public class DataInitializerComCascade{ //implements ApplicationListener<ContextRefreshedEvent> {

//	@Autowired
//	private UserRepository userRepository; 
//	
//	
//	@Override
//	public void onApplicationEvent(ContextRefreshedEvent arg0) {
//		//USANDO CASCADE
//		//Ao utilizar o cascade, é preciso configurar sua classe Role com -> (cascade = CascadeType.PERSIST) no atributo
//		Role roleCascade = new Role("roleCascade",RoleStatus.ATIVO);
//		User userCascade = new User("Role Cascade","cascade@hotmail.com",roleCascade);
//		this.userRepository.save(userCascade);//Fará o save normalmente do User, pois o Role está habilitado o Cascade PERSIST
//		
//	}


}
