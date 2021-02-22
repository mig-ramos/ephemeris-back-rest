package com.siderbit.ephemeris.domains;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Paciente extends Usuario {
	private static final long serialVersionUID = 1L;

	private Date dataNascimento;
	
	public Paciente() {
	}

	public Paciente(Integer id, String nome, String email, String cpfOuCnpj, Date instante, Date dataNascimento) {
		super(id, nome, email, cpfOuCnpj, instante);
		this.dataNascimento = dataNascimento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
}
