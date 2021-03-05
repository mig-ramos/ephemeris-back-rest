package com.siderbit.ephemeris.services;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.siderbit.ephemeris.domains.enums.Perfil;
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
	private BCryptPasswordEncoder pe;
	
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
	
	Cidade c1 = new Cidade(null, "Apucarana",est16);
	Cidade c2 = new Cidade(null, "Santos",est25);
	Cidade c3 = new Cidade(null, "São Vicente",est25);
	
	est1.getCidades().addAll(Arrays.asList(c2,c3));
	est2.getCidades().addAll(Arrays.asList(c3));
	
	estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5, est6, est7, est8, 
			est9, est10, est11, est12, est13, est14, est15, est16, est17, est18, est19, est20,
			est21, est22, est23, est24, est25, est26, est27));
	cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
	
	Usuario usu1 = new Usuario(null, "Administrador Ephemeris", "adm.ephemeris@gmail.com", LocalDateTime.parse("2021-02-20T00:00"), pe.encode("123"));
	usu1.getTelefones().addAll(Arrays.asList("118986664"));
	usu1.addPerfil(Perfil.ADMIN);
	
	Especialidade esp1 = new Especialidade(null, "Dentista");
	Especialidade esp2 = new Especialidade(null, "Clínico Geral");
	Especialidade esp3 = new Especialidade(null, "Geriatra");
	Especialidade esp4 = new Especialidade(null, "Otorrino");	
	Especialidade esp5 = new Especialidade(null, "Pediatra");
	Especialidade esp6 = new Especialidade(null, "Dermatologista");
	Especialidade esp7 = new Especialidade(null, "Cirurgial Geral");		
	
	
	Usuario usu2 = new Usuario(null, "Paciente Ephemeris", "p.ephemeris@gmail.com", LocalDateTime.parse("2021-02-20T00:00"), pe.encode("123"));
	usu2.getTelefones().addAll(Arrays.asList("858576745", "19991356880"));
	
	Usuario usu3 = new Usuario(null, "Médico Ephemeris", "m.ephemeris@gmail.com", LocalDateTime.parse("2021-02-21T00:00"), pe.encode("123"));
	usu3.getTelefones().addAll(Arrays.asList("858986745", "19991356754"));
	usu3.addPerfil(Perfil.MEDICO);
	
	Endereco e1 = new Endereco(null,"Rua Valentin","389","casa","Vl Cascatinha","34567001",usu1,c3);
	Endereco e2 = new Endereco(null,"Rua Catarina","34","Ap 33","Vl Andorinha","11100010",usu2,c2);
	Endereco e3 = new Endereco(null,"Rua Caiamoré","456","casa","Vl Mirim","11200010",usu3,c1);
	
	especialidadeRepository.saveAll(Arrays.asList(esp1, esp2, esp3, esp4, esp5, esp6, esp7));
	
	usu1.getEnderecos().addAll(Arrays.asList(e1));
	usu2.getEnderecos().addAll(Arrays.asList(e2));
	usu3.getEnderecos().addAll(Arrays.asList(e3));
	
	Medico med1 = new Medico(null, "345629", LocalDate.parse("2001-02-12"));

	
	med1.getEspecialidades().addAll(Arrays.asList(esp2,esp3));
	med1.setUsuario(usu3);
	

	Paciente paci1 = new Paciente(null, LocalDate.parse("1970-02-23"));
	
	
	paci1.setUsuario(usu2);
	
	usuarioRepository.saveAll(Arrays.asList(usu1, usu2, usu3));
	enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));
	medicoRepository.saveAll(Arrays.asList(med1));
	pacienteRepository.saveAll(Arrays.asList(paci1));	
	
	
	Hora hr1 = new Hora(null, LocalTime.parse("07:00"));
	Hora hr2 = new Hora(null, LocalTime.parse("07:30"));
	Hora hr3 = new Hora(null, LocalTime.parse("08:00"));
	Hora hr4 = new Hora(null, LocalTime.parse("08:30"));
	Hora hr5 = new Hora(null, LocalTime.parse("09:00"));
	Hora hr6 = new Hora(null, LocalTime.parse("09:30"));
	Hora hr7 = new Hora(null, LocalTime.parse("10:00"));
	Hora hr8 = new Hora(null, LocalTime.parse("10:30"));
	Hora hr9 = new Hora(null, LocalTime.parse("11:00"));
	Hora hr10 = new Hora(null, LocalTime.parse("11:30"));
	Hora hr11 = new Hora(null, LocalTime.parse("12:00"));
	Hora hr12 = new Hora(null, LocalTime.parse("13:00"));
	Hora hr13 = new Hora(null, LocalTime.parse("13:30"));
	Hora hr14 = new Hora(null, LocalTime.parse("14:00"));
	Hora hr15 = new Hora(null, LocalTime.parse("14:30"));
	Hora hr16 = new Hora(null, LocalTime.parse("15:00"));
	Hora hr17 = new Hora(null, LocalTime.parse("15:30"));
	Hora hr18 = new Hora(null, LocalTime.parse("16:00"));
	Hora hr19 = new Hora(null, LocalTime.parse("16:30"));
	
	TipoConsulta tipoCon1 = new TipoConsulta(null, "Consulta");
	TipoConsulta tipoCon2 = new TipoConsulta(null, "Retorno");		
			
	horaRepository.saveAll(Arrays.asList(hr1, hr2, hr3, hr4, hr5, hr6, hr7, hr8, 
			hr9, hr10, hr11, hr12, hr13, hr14, hr15, hr16, hr17, hr18, hr19));
	
	tipoConsultaRepository.saveAll(Arrays.asList(tipoCon1, tipoCon2));
	
	Agenda age1 = new Agenda(null, esp3, med1, paci1, LocalDate.parse("2021-02-26"), hr1, tipoCon1, LocalDateTime.parse("2021-02-20T00:00"));
	
	agendaRepository.saveAll(Arrays.asList(age1));
	
	}	
}
