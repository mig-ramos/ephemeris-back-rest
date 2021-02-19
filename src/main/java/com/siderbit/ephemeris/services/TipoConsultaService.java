package com.siderbit.ephemeris.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.TipoConsulta;
import com.siderbit.ephemeris.repositories.TipoConsultaRepository;

@Service
public class TipoConsultaService {
	
	@Autowired
	private TipoConsultaRepository repo;
	
	public TipoConsulta find(Integer id) {
		Optional<TipoConsulta> obj = repo.findById(id);
		return obj.orElse(null);
	}	
}
