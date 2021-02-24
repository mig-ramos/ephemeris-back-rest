package com.siderbit.ephemeris.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Especialidade;
import com.siderbit.ephemeris.dto.EspecialidadeDTO;
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
		Especialidade newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Especialidade newObj, Especialidade obj) {
		newObj.setNome(obj.getNome());		
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma especialidade que não existe");
		}
	}

	public List<Especialidade> findAll() {
		return repo.findAll();
	}

	public Page<Especialidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Especialidade fromDTO(@Valid EspecialidadeDTO objDto) {
		return new Especialidade(objDto.getId(), objDto.getNome());
	}
}
