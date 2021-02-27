package com.siderbit.ephemeris.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Agenda;
import com.siderbit.ephemeris.domains.Cidade;
import com.siderbit.ephemeris.domains.Endereco;
import com.siderbit.ephemeris.domains.Especialidade;
import com.siderbit.ephemeris.domains.Estado;
import com.siderbit.ephemeris.domains.Hora;
import com.siderbit.ephemeris.domains.Medico;
import com.siderbit.ephemeris.domains.Paciente;
import com.siderbit.ephemeris.domains.TipoConsulta;
import com.siderbit.ephemeris.domains.Usuario;
import com.siderbit.ephemeris.repositories.AgendaRepository;
import com.siderbit.ephemeris.repositories.CidadeRepository;
import com.siderbit.ephemeris.repositories.EnderecoRepository;
import com.siderbit.ephemeris.repositories.EspecialidadeRepository;
import com.siderbit.ephemeris.repositories.EstadoRepository;
import com.siderbit.ephemeris.repositories.HoraRepository;
import com.siderbit.ephemeris.repositories.MedicoRepository;
import com.siderbit.ephemeris.repositories.PacienteRepository;
import com.siderbit.ephemeris.repositories.TipoConsultaRepository;
import com.siderbit.ephemeris.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private EstadoRepository estadoRepository;	
	@Autowired
	private HoraRepository horaRepository;
	@Autowired
	private TipoConsultaRepository tipoConsultaRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	@Autowired
	private MedicoRepository medicoRepository;
	@Autowired
	private PacienteRepository pacienteRepository;
	@Autowired
	private AgendaRepository agendaRepository;
	
	public void instantiateTestDatabase() throws ParseException {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

	Estado est1 = new Estado(null, "Acre");
	Estado est2 = new Estado(null, "Alagoas");
	Estado est3 = new Estado(null, "Amapá");
	Estado est4 = new Estado(null, "Amazonas");
	Estado est5 = new Estado(null, "Bahia");
	Estado est6 = new Estado(null, "Ceará");
	Estado est7 = new Estado(null, "Distrito Federal");
	Estado est8 = new Estado(null, "Espírito Santo");
	Estado est9 = new Estado(null, "Goiás");
	Estado est10 = new Estado(null, "Maranhão");
	Estado est11 = new Estado(null, "Mato Grosso");
	Estado est12 = new Estado(null, "Mato Grosso do Sul");
	Estado est13 = new Estado(null, "Minas Gerais");
	Estado est14 = new Estado(null, "Pará");
	Estado est15 = new Estado(null, "Paraíba");
	Estado est16 = new Estado(null, "Paraná");
	Estado est17 = new Estado(null, "Pernambuco");
	Estado est18 = new Estado(null, "Piauí");
	Estado est19 = new Estado(null, "Rio de Janeiro");
	Estado est20 = new Estado(null, "Rio Grande do Norte");
	Estado est21 = new Estado(null, "Rio Grande do Sul");
	Estado est22 = new Estado(null, "Rondônia");
	Estado est23 = new Estado(null, "Roraima");
	Estado est24 = new Estado(null, "Santa Catarina");
	Estado est25 = new Estado(null, "São Paulo");
	Estado est26 = new Estado(null, "Sergipe");
	Estado est27 = new Estado(null, "Tocantins");
	
	Cidade c1 = new Cidade(null, "Apucarana",est3);
	Cidade c2 = new Cidade(null, "Santos",est1);
	Cidade c3 = new Cidade(null, "São Vicente",est1);
	
	est1.getCidades().addAll(Arrays.asList(c2,c3));
	est2.getCidades().addAll(Arrays.asList(c3));
	
	estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, 
			est9, est10, est11, est12, est13, est14, est15, est16, est17, est18, est19, est20,
			est21, est22, est23, est24, est25, est26, est27));
	cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	
	Usuario usu1 = new Usuario(null, "Paciente Ephemeris", "p.ephemeris@gmail.com", sdf.parse("20/02/2021 00:00"),null);
	usu1.getTelefones().addAll(Arrays.asList("118986745"));
	
	Especialidade esp1 = new Especialidade(null, "Dentista");
	Especialidade esp2 = new Especialidade(null, "Clínico Geral");
	Especialidade esp3 = new Especialidade(null, "Geriatra");
	Especialidade esp4 = new Especialidade(null, "Otorrino");	
	Especialidade esp5 = new Especialidade(null, "Pediatra");
	Especialidade esp6 = new Especialidade(null, "Dermatologista");
	Especialidade esp7 = new Especialidade(null, "Cirurgial Geral");		
	
	
	Usuario usu2 = new Usuario(null, "Médico Ephemeris", "m.ephemeris@gmail.com", sdf.parse("21/02/2021 00:00"), "123");
	usu2.getTelefones().addAll(Arrays.asList("858986745", "19991356754"));
	
	Endereco e1 = new Endereco(null,"Rua Valentin","389","casa","Vl Cascatinha","34567001",usu1,c3);
	Endereco e2 = new Endereco(null,"Rua Catarina","34","Ap 33","Vl Andorinha","11100010",usu2,c2);
	
	especialidadeRepository.saveAll(Arrays.asList(esp1, esp2, esp3, esp4, esp5, esp6, esp7));
	
	usu1.getEnderecos().addAll(Arrays.asList(e1));
	usu2.getEnderecos().addAll(Arrays.asList(e2));
	
	
	Medico med1 = new Medico("345629", sdf.parse("12/06/2001 00:00"));

	
	med1.getEspecialidades().addAll(Arrays.asList(esp2,esp3));
	med1.setUsuario(usu2);

	Paciente paci1 = new Paciente(null, sdf.parse("12/06/2001 00:00"));
	
	
	paci1.setUsuario(usu1);
	
	usuarioRepository.saveAll(Arrays.asList(usu1, usu2));
	enderecoRepository.saveAll(Arrays.asList(e1,e2));
	medicoRepository.saveAll(Arrays.asList(med1));
	pacienteRepository.saveAll(Arrays.asList(paci1));	
	
	
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
	
	Agenda age1 = new Agenda(null, esp3, med1, paci1, sdf.parse("26/02/2021 00:00"), hr1, tipoCon1, sdf.parse("20/02/2021 00:00"));
	
	agendaRepository.saveAll(Arrays.asList(age1));
	}	
}
