package com.siderbit.ephemeris.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Especialidade;
import com.siderbit.ephemeris.repositories.EspecialidadeRepository;
import com.siderbit.ephemeris.services.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {
	
	@Autowired
	private EspecialidadeRepository repo;
	
	public Especialidade find(Integer id) {
		Optional<Especialidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + ", Tipo: "
		+ Especialidade.class.getName()));
	}

	public Especialidade insert(Especialidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}	
}
