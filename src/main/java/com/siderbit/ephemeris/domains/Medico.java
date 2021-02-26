package com.siderbit.ephemeris.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Medico implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String crm;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInscricao;
	
	@ManyToMany
	@JoinTable(name = "especialidade_medico", joinColumns = @JoinColumn(name = "medico_id"))
	private Set<Especialidade> especialidades = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Medico() {
	}
	
	public Medico(String crm, Date dataInscricao) {
		super();
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}
