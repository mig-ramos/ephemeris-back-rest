package com.siderbit.ephemeris.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siderbit.ephemeris.domains.Medico;
import com.siderbit.ephemeris.services.MedicoService;

@RestController
@RequestMapping(value = "/medicos")
public class MedicoResource {

	@Autowired
	private MedicoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Medico> find(@PathVariable Integer id) {
		Medico obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
