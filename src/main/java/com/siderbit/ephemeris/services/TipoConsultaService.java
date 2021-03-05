package com.siderbit.ephemeris.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.TipoConsulta;
import com.siderbit.ephemeris.dto.TipoConsultaDTO;
import com.siderbit.ephemeris.repositories.TipoConsultaRepository;
import com.siderbit.ephemeris.services.exceptions.DataIntegrityException;

@Service
public class TipoConsultaService {
	
	@Autowired
	private TipoConsultaRepository repo;
	
	public TipoConsulta find(Integer id) {
		Optional<TipoConsulta> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public TipoConsulta fromDTO(@Valid TipoConsultaDTO objDto) {
		return new TipoConsulta(objDto.getId(), objDto.getTipoConsulta());
	}

	public TipoConsulta insert(TipoConsulta obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public TipoConsulta update(TipoConsulta obj) {
		TipoConsulta newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(TipoConsulta newObj, TipoConsulta obj) {
		newObj.setTipoConsulta(obj.getTipoConsulta());			
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um tipo de consulta  que não existe");
		}		
	}

	public List<TipoConsulta> findAll() {
		return repo.findAll();
	}	
}
