package com.siderbit.ephemeris.services;

import org.springframework.mail.SimpleMailMessage;

import com.siderbit.ephemeris.domains.Usuario;

public interface EmailService {

	void sendCadastroConfirmationEmail(Usuario obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
