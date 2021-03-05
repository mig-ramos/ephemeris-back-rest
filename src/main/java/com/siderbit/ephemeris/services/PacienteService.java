package com.siderbit.ephemeris.services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Paciente;
import com.siderbit.ephemeris.dto.PacienteDTO;
import com.siderbit.ephemeris.repositories.PacienteRepository;
import com.siderbit.ephemeris.services.exceptions.DataIntegrityException;
import com.siderbit.ephemeris.services.exceptions.ObjectNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	private PacienteRepository repo;

	public Paciente find(Integer id) {
		Optional<Paciente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Paciente.class.getName()));
	}

	public Paciente fromDTO(@Valid PacienteDTO objDto) {
		return new Paciente(objDto.getId(), objDto.getDataNascimento());
	}

	public Paciente insert(Paciente obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Paciente update(Paciente obj) {
		Paciente newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Paciente newObj, Paciente obj) {
		newObj.setDataNascimento(obj.getDataNascimento());				
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um paciente que não existe");
		}		
	}
}
