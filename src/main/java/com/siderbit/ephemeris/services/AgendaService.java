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

import com.siderbit.ephemeris.domains.Agenda;
import com.siderbit.ephemeris.domains.Especialidade;
import com.siderbit.ephemeris.domains.Hora;
import com.siderbit.ephemeris.domains.Medico;
import com.siderbit.ephemeris.domains.Paciente;
import com.siderbit.ephemeris.domains.TipoConsulta;
import com.siderbit.ephemeris.dto.AgendaDTO;
import com.siderbit.ephemeris.dto.AgendaNewDTO;
import com.siderbit.ephemeris.repositories.AgendaRepository;
import com.siderbit.ephemeris.services.exceptions.DataIntegrityException;
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

	public Agenda insert(Agenda obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Agenda fromDTO(@Valid AgendaDTO objDto) {
		return new Agenda(objDto.getId(), objDto.getEspecialidade(), objDto.getMedico(), objDto.getPaciente(),
				objDto.getDataAgendamento(), objDto.getHora(), objDto.getTipoConsulta(), objDto.getInstante());
	}

	public Agenda fromDTO(@Valid AgendaNewDTO objDto) {

		Especialidade esp = new Especialidade(objDto.getEspecialidade_Id(), null);
		Medico med = new Medico(objDto.getMedico_Id(), null, null);
		Paciente pac = new Paciente(objDto.getPaciente_Id(), null);
		Hora hr = new Hora(objDto.getHora_Id(), null);
		TipoConsulta tipo = new TipoConsulta(objDto.getTipoConsulta_Id(), null);
		Agenda age = new Agenda(null, esp, med, pac, objDto.getDataAgendamento(), hr, tipo, objDto.getInstante());
		return age;
	}

	public Agenda update(Agenda obj) {
		Agenda newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(Agenda newObj, Agenda obj) {
		newObj.setDataAgendamento(obj.getDataAgendamento());
		newObj.setHora(obj.getHora());		
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há XXXXXXX relacionadas");
		}		
	}

	public List<Agenda> findAll() {
		return repo.findAll();
	}

	public Page<Agenda> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}
