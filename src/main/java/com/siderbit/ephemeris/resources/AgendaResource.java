package com.siderbit.ephemeris.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siderbit.ephemeris.domains.Agenda;
import com.siderbit.ephemeris.services.AgendaService;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendaResource {

	@Autowired
	private AgendaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agenda> find(@PathVariable Integer id) {
		Agenda obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
