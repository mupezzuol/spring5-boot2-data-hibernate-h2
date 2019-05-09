package com.springboot.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.FetchType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.springboot.entity.Funcionalidades;
import com.springboot.entity.Perfil;
import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.entity.Usuario;
import com.springboot.enums.RoleStatus;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;
import com.springboot.repository.UsuarioRepository;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository; 
	
	@Autowired
	private UsuarioRepository usuarioRepository; 
	
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
		System.out.println("---------------------------");
		for (Role role : rolesPage) {
			System.out.println(role.getName());
		}
		System.out.println("---------------------------");
		
		
		
		
		
		
		
		//UTILIZANDO CASCADE, CLASSES EM PT-BR PARA OS TESTES
		Funcionalidades func1 = new Funcionalidades("Add");
		Funcionalidades func2 = new Funcionalidades("Delete");
		Funcionalidades func3 = new Funcionalidades("Insert");
		
		Perfil roleCascade1 = new Perfil("perfilCascade",RoleStatus.ATIVO, Arrays.asList(func1));
		Perfil roleCascade2 = new Perfil("cascadePerfil",RoleStatus.INATIVO, Arrays.asList(func2));
		Perfil roleCascade3 = new Perfil("perfilA",RoleStatus.INATIVO, Arrays.asList(func3));
		
		//Não posso cadastrar objetos iguais que acabaram de ser cadastrados, vou gerar um erro de DETACHED
		Usuario userCascade1 = new Usuario("Babuxo","cascade@hotmail.com",Arrays.asList(roleCascade1,roleCascade3));
		Usuario userCascade2 = new Usuario("Morgana","lazy.eager@hibernate.com",Arrays.asList(roleCascade2));
		this.usuarioRepository.save(userCascade1);//Fará o save normalmente do User, pois o Role está habilitado o Cascade PERSIST
		this.usuarioRepository.save(userCascade2);
		
		
		//CASCADE TESTES
		System.out.println();
		System.out.println("CASCADE TESTES:");
		System.out.println("---------------------------");
		List<Usuario> usuarios = this.usuarioRepository.findAll();
		for (Usuario usuario : usuarios) {
			System.out.println("Usuário: "+usuario.getNome());
			for (Perfil perfil : usuario.getPerfis()) {
				System.out.println("Perfis: "+perfil.getNome());//Printa os perfis dos usuários da lista
				for (Funcionalidades func : perfil.getFuncionalidades()) {
					System.out.println("Funcionalidades: "+func.getNome());//Utilizo o -> FetchType.EAGER para o Hibernate fazer todos os join necessarios
				}
			}
			System.out.println("---------------------------");
		}
		
		
		
	}


}
