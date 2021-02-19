package com.siderbit.ephemeris;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siderbit.ephemeris.domains.Cidade;
import com.siderbit.ephemeris.domains.Estado;
import com.siderbit.ephemeris.domains.Hora;
import com.siderbit.ephemeris.domains.TipoConsulta;
import com.siderbit.ephemeris.repositories.CidadeRepository;
import com.siderbit.ephemeris.repositories.EstadoRepository;
import com.siderbit.ephemeris.repositories.HoraRepository;
import com.siderbit.ephemeris.repositories.TipoConsultaRepository;

@SpringBootApplication
public class EphemerisApplication implements CommandLineRunner {
	
	@Autowired
	EstadoRepository estadoRepository;	
	@Autowired
	HoraRepository horaRepository;
	@Autowired
	TipoConsultaRepository tipoConsultaRepository;
	@Autowired
	CidadeRepository cidadeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EphemerisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Estado est1 = new Estado(null, "São Paulo");
		Estado est2 = new Estado(null, "Minas Gerais");
		Estado est3 = new Estado(null, "Paraná");
		
		Cidade c1 = new Cidade(null, "Apucarana",est3);
		Cidade c2 = new Cidade(null, "Santos",est1);
		Cidade c3 = new Cidade(null, "São Vicente",est1);
		
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		est2.getCidades().addAll(Arrays.asList(c3));
		
		estadoRepository.saveAll(Arrays.asList(est1, est2, est3));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Hora hr1 = new Hora(null, "07:00");
		Hora hr2 = new Hora(null, "07:30");
		Hora hr3 = new Hora(null, "08:00");
		Hora hr4 = new Hora(null, "08:30");
		Hora hr5 = new Hora(null, "09:00");
		Hora hr6 = new Hora(null, "09:30");
		Hora hr7 = new Hora(null, "10:00");
		Hora hr8 = new Hora(null, "10:30");
		Hora hr9 = new Hora(null, "11:00");
		Hora hr10 = new Hora(null, "11:30");
		Hora hr11 = new Hora(null, "12:00");
		Hora hr12 = new Hora(null, "12:30");
		Hora hr13 = new Hora(null, "13:00");
		Hora hr14 = new Hora(null, "13:30");
		Hora hr15 = new Hora(null, "14:00");
		Hora hr16 = new Hora(null, "14:30");
		Hora hr17 = new Hora(null, "15:00");
		Hora hr18 = new Hora(null, "15:30");
		Hora hr19 = new Hora(null, "16:00");
		Hora hr20 = new Hora(null, "16:30");		
		Hora hr21 = new Hora(null, "17:00");
		
		TipoConsulta tipoCon1 = new TipoConsulta(null, "Consulta");
		TipoConsulta tipoCon2 = new TipoConsulta(null, "Retorno");
		
				
		horaRepository.saveAll(Arrays.asList(hr1, hr2, hr3, hr4, hr5, hr6, hr7, hr8, 
				hr9, hr10, hr11, hr12, hr13, hr14, hr15, hr16, hr17, hr18, hr19, hr20, hr21));
		
		tipoConsultaRepository.saveAll(Arrays.asList(tipoCon1, tipoCon2));
		
	}

}
