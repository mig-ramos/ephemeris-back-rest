package com.siderbit.ephemeris.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.siderbit.ephemeris.domains.Agenda;
import com.siderbit.ephemeris.domains.Especialidade;
import com.siderbit.ephemeris.domains.Hora;
import com.siderbit.ephemeris.domains.Medico;
import com.siderbit.ephemeris.domains.Paciente;
import com.siderbit.ephemeris.domains.TipoConsulta;

public class AgendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Especialidade especialidade;

	private Medico medico;

	private Paciente paciente;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataAgendamento;

	private Hora hora;

	private TipoConsulta tipoConsulta;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime instante;

	public AgendaDTO() {
	}

	public AgendaDTO(Agenda obj) {
		id = obj.getId();
		especialidade = obj.getEspecialidade();
		medico = obj.getMedico();
		paciente = obj.getPaciente();
		dataAgendamento = obj.getDataAgendamento();
		hora = obj.getHora();
		tipoConsulta = obj.getTipoConsulta();
		instante = obj.getInstante();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Hora getHora() {
		return hora;
	}

	public void setHora(Hora hora) {
		this.hora = hora;
	}

	public TipoConsulta getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(TipoConsulta tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public void setInstante(LocalDateTime instante) {
		this.instante = instante;
	}
}
