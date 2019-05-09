package com.springboot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Role;
import com.springboot.enums.RoleStatus;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	//Parametro é o mesmo tipo que o seu atributo da classe é, sempre o mesmo tipo
	List<Role> findByStatus(RoleStatus status);
	
	
	//org.springframework.data.domain
	//Criando método personalizado de findAll com paginação customizada
	Page<Role> findAll(Pageable pageable);
	
}
