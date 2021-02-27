package com.siderbit.ephemeris.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Medico;
import com.siderbit.ephemeris.repositories.MedicoRepository;
import com.siderbit.ephemeris.services.exceptions.ObjectNotFoundException;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repo;

	public Medico find(Integer id) {
		Optional<Medico> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Medico.class.getName()));
	}

}
