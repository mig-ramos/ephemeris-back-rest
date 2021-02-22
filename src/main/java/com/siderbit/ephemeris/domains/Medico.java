package com.siderbit.ephemeris.domains;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Medico extends Usuario {
	private static final long serialVersionUID = 1L;

	private String crm;
	private Date dataInscricao;
	
	public Medico() {
	}

	public Medico(Integer id, String nome, String email, String cpfOuCnpj, Date instante,String crm, Date dataInscricao) {
		super(id, nome, email, cpfOuCnpj, instante);
		this.crm = crm;
		this.dataInscricao = dataInscricao;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}	
}
