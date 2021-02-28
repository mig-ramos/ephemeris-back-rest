package com.siderbit.ephemeris.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Agenda;
import com.siderbit.ephemeris.repositories.AgendaRepository;
import com.siderbit.ephemeris.services.exceptions.ObjectNotFoundException;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository repo;

	public Agenda find(Integer id) {
		Optional<Agenda> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Agenda.class.getName()));
	}

}
