package com.siderbit.ephemeris.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Hora;
import com.siderbit.ephemeris.repositories.HoraRepository;

@Service
public class HoraService {
	
	@Autowired
	private HoraRepository repo;
	
	public Hora find(Integer id) {
		Optional<Hora> obj = repo.findById(id);
		return obj.orElse(null);
	}	
}
