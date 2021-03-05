package com.siderbit.ephemeris.domains;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Medico implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String crm;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_inscricao", nullable = false)
	private LocalDate dataInscricao;
	
	@ManyToMany
	@JoinTable(name = "especialidade_medico", joinColumns = @JoinColumn(name = "medico_id"))
	private Set<Especialidade> especialidades = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "medico")
	private List<Agenda> agendamentos;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Medico() {
	}
	
	public Medico(Integer id, String crm, LocalDate dataInscricao) {
		super();
		this.id = id;
		this.crm = crm;
		this.dataInscricao = dataInscricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public LocalDate getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(LocalDate dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Set<Especialidade> getEspecialidades() {
		return especialidades;
	}

	
	public void setAgendamentos(List<Agenda> agendamentos) {
		this.agendamentos = agendamentos;
	}

	public List<Agenda> getAgendamentos() {
		return agendamentos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
