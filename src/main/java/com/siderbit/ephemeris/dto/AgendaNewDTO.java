package com.siderbit.ephemeris.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class AgendaNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer especialidade_Id;

	private Integer medico_Id;

	private Integer paciente_Id;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataAgendamento;

	private Integer hora_Id;

	private Integer tipoConsulta_Id;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime instante;

	public AgendaNewDTO() {
	}

	public Integer getEspecialidade_Id() {
		return especialidade_Id;
	}

	public void setEspecialidade_Id(Integer especialidade_Id) {
		this.especialidade_Id = especialidade_Id;
	}

	public Integer getMedico_Id() {
		return medico_Id;
	}

	public void setMedico_Id(Integer medico_Id) {
		this.medico_Id = medico_Id;
	}

	public Integer getPaciente_Id() {
		return paciente_Id;
	}

	public void setPaciente_Id(Integer paciente_Id) {
		this.paciente_Id = paciente_Id;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Integer getHora_Id() {
		return hora_Id;
	}

	public void setHora_Id(Integer hora_Id) {
		this.hora_Id = hora_Id;
	}

	public Integer getTipoConsulta_Id() {
		return tipoConsulta_Id;
	}

	public void setTipoConsulta_Id(Integer tipoConsulta_Id) {
		this.tipoConsulta_Id = tipoConsulta_Id;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public void setInstante(LocalDateTime instante) {
		this.instante = instante;
	}
}
