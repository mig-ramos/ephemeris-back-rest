package com.siderbit.ephemeris.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.siderbit.ephemeris.domains.TipoConsulta;

public class TipoConsultaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 3 e 80 caracteres")
	private String tipoConsulta;

	public TipoConsultaDTO() {
	}

	public TipoConsultaDTO(TipoConsulta obj) {
		id = obj.getId();
		tipoConsulta = obj.getTipoConsulta();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoConsulta() {
		return tipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		this.tipoConsulta = tipoConsulta;
	}
}


