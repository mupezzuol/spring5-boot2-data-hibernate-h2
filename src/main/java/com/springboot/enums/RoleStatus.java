package com.springboot.enums;

public enum RoleStatus {
	//O retorno é um int, ele começa do index 0... ou seja 0 = ATIVO, 1 = INATIVO e assim por diante...
	//Para cadastrar no banco a string, sem ser o index deve ser usado -> @Enumerated(EnumType.STRING)
	ATIVO,
	INATIVO
}
