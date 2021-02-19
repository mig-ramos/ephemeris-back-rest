package com.siderbit.ephemeris.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siderbit.ephemeris.domains.Hora;
import com.siderbit.ephemeris.services.HoraService;

@RestController
@RequestMapping(value="/horas")
public class HoraResource {
	
	@Autowired
	private HoraService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Hora obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
