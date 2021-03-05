package com.siderbit.ephemeris.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.siderbit.ephemeris.domains.Medico;

public class MedicoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

private Integer id;

@NotEmpty(message="Preenchimento obrigatório")
private String crm;

@DateTimeFormat(iso = ISO.DATE)
@Column(name = "data_inscricao", nullable = false)
private LocalDate dataInscricao;

public MedicoDTO() {
}

public MedicoDTO(Medico obj) {
	id = obj.getId();
	crm = obj.getCrm();
	dataInscricao = obj.getDataInscricao();
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
}
