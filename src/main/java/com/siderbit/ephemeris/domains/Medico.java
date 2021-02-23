package com.siderbit.ephemeris.domains;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Medico extends Usuario {
	private static final long serialVersionUID = 1L;

	private String crm;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInscricao;
	
	@ManyToMany
	@JoinTable(name = "especialidade_medico", joinColumns = @JoinColumn(name = "medico_id"))
	private Set<Especialidade> especialidades = new HashSet<>();
	
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

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}	
}
