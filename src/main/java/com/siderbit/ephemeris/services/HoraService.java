package com.siderbit.ephemeris.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Hora;
import com.siderbit.ephemeris.dto.HoraDTO;
import com.siderbit.ephemeris.repositories.HoraRepository;
import com.siderbit.ephemeris.services.exceptions.DataIntegrityException;
import com.siderbit.ephemeris.services.exceptions.ObjectNotFoundException;

@Service
public class HoraService {
	
	@Autowired
	private HoraRepository repo;
	
	public Hora find(Integer id) {
		Optional<Hora> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + ", Tipo: "
		+ Hora.class.getName()));
	}

	public Hora fromDTO(@Valid HoraDTO objDto) {
		return new Hora(objDto.getId(), objDto.getHoraMinuto());
	}

	public Hora insert(Hora obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Hora update(Hora obj) {
		Hora newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Hora newObj, Hora obj) {
		newObj.setHoraMinuto(obj.getHoraMinuto());				
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir Hora que não existe");
		}		
	}

	public List<Hora> findAll() {
		return repo.findAll();
	}	
}
