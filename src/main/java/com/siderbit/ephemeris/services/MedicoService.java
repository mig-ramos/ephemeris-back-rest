package com.siderbit.ephemeris.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Medico;
import com.siderbit.ephemeris.dto.MedicoDTO;
import com.siderbit.ephemeris.repositories.MedicoRepository;
import com.siderbit.ephemeris.services.exceptions.DataIntegrityException;
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

	public Medico fromDTO(@Valid MedicoDTO objDto) {
		return new Medico(objDto.getId(), objDto.getCrm(), null);
		}

	public Medico insert(Medico obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Medico update(Medico obj) {
		Medico newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Medico newObj, Medico obj) {
		newObj.setCrm(obj.getCrm());
		newObj.setDataInscricao(obj.getDataInscricao());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um médico que não existe");
		}		
	}

}
