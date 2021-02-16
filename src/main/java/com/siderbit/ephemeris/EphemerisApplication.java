package com.siderbit.ephemeris;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siderbit.ephemeris.domains.Estado;
import com.siderbit.ephemeris.repositories.EstadoRepository;

@SpringBootApplication
public class EphemerisApplication implements CommandLineRunner {
	
	@Autowired
	EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EphemerisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		Estado est3 = new Estado(null, "Paraná");
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		
	}

}
