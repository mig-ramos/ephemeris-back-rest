package com.siderbit.ephemeris.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.siderbit.ephemeris.domains.Paciente;

public class PacienteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@Column(name = "data_nascimento", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataNascimento;

	public PacienteDTO() {
	}

	public PacienteDTO(Paciente obj) {
		id = obj.getId();
		dataNascimento = obj.getDataNascimento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
