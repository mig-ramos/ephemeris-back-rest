package com.siderbit.ephemeris.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.siderbit.ephemeris.domains.Agenda;
import com.siderbit.ephemeris.dto.AgendaDTO;
import com.siderbit.ephemeris.dto.AgendaNewDTO;
import com.siderbit.ephemeris.services.AgendaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendaResource {

	@Autowired
	private AgendaService service;
	
	@ApiOperation(value="Busca por id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Agenda> find(@PathVariable Integer id) {
		Agenda obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@ApiOperation(value="Insere agenda")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AgendaNewDTO objDto) {
		Agenda obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation(value="Altera agenda")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AgendaNewDTO objDto, @PathVariable Integer id) {
		Agenda obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Remove agendamento")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value="Retorna todos agendamentos")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAll() {
		List<Agenda> list = service.findAll();
		List<AgendaDTO> listDto = list.stream().map(obj -> new AgendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@ApiOperation(value="Retorna todos agendamentos com paginação")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AgendaDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Agenda> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AgendaDTO> listDto = list.map(obj -> new AgendaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
