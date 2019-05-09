package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//Paramentro é usado -> ?1, ?2, ?3 etc... na ordem que está no método
	@Query("select u from Usuario u where u.nome like ?1%")
	Usuario findByNomeQualquerCoisa(String nome);
	
	Usuario findByEmail(String email);
	
	
	
	
/* EXPLICAÇÃO DO LIKE
 
texto    -> Nesse caso, serão retornados todos os registros que contêm no campo buscado exatamente o "texto" informado no filtro. 
O funcionamento aqui é equivalente a utilizar o operador de igualdade (=);

%texto%  -> Serão retornados os registros que contêm no campo buscado o "texto" informado. Por exemplo, podemos buscar os nomes que contêm 
"Santos", ou que contêm uma sílaba ou letra específica. O registro com nome "Luis da Silva", por exemplo, contém o termo "da", 
então atenderia ao filtro '%da%';

%texto   -> Serão retornados os registros cujo valor do campo filtrado termina com o "texto" informado. O %, nesse caso, indica 
que pode haver qualquer valor no começo do campo, desde que ele termine com o "texto". Por exemplo, o registro com nome "Luis da Silva" 
atenderia ao filtro '%Silva';

texto%   -> Serão retornados os registros cujo valor do campo filtrado começa com o "texto" informado. Dessa vez, o % indica que após 
o "texto" pode haver qualquer valor. Por exemplo, o registro com nome "Luis da Silva", atenderia ao filtro 'Luis%'.

*/

	
}
