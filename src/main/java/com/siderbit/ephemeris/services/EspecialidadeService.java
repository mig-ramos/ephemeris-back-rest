package com.siderbit.ephemeris.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Especialidade;
import com.siderbit.ephemeris.repositories.EspecialidadeRepository;
import com.siderbit.ephemeris.services.exceptions.DataIntegrityException;
import com.siderbit.ephemeris.services.exceptions.ObjectNotFoundException;

@Service
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository repo;

	public Especialidade find(Integer id) {
		Optional<Especialidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + ", Tipo: " + Especialidade.class.getName()));
	}

	public Especialidade insert(Especialidade obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Especialidade update(Especialidade obj) {
		find(obj.getId());
		return repo.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma especialidade que existe");
		}
	}

	public List<Especialidade> findAll() {
		return repo.findAll();
	}
}
