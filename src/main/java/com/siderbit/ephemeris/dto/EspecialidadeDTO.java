package com.siderbit.ephemeris.dto;

import java.io.Serializable;

import com.siderbit.ephemeris.domains.Especialidade;

public class EspecialidadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

private Integer id;
private String nome;

public EspecialidadeDTO() {
}

public EspecialidadeDTO(Especialidade obj) {
	id = obj.getId();
	nome = obj.getNome();
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}


}
