package com.siderbit.ephemeris.dto;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.siderbit.ephemeris.domains.Hora;

public class HoraDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "hora_minuto", unique = true, nullable = false)
	private LocalTime horaMinuto;

	public HoraDTO() {
	}

	public HoraDTO(Hora obj) {
		id = obj.getId();
		horaMinuto = obj.getHoraMinuto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHoraMinuto() {
		return horaMinuto;
	}

	public void setHoraMinuto(LocalTime horaMinuto) {
		this.horaMinuto = horaMinuto;
	}
}
