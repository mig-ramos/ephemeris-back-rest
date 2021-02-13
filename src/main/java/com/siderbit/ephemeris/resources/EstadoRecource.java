package com.siderbit.ephemeris.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siderbit.ephemeris.domains.Estado;

@RestController
@RequestMapping(value="/estados")
public class EstadoRecource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Estado> listar() {
		Estado e1 = new Estado(1, "São Paulo");
		Estado e2 = new Estado(2, "Paraná");
		
		List<Estado> lista = new ArrayList<>();
		lista.add(e1);
		lista.add(e2);
		
		return lista;
	}
}
