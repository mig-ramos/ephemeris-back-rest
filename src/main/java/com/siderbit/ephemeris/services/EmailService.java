package com.siderbit.ephemeris.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.siderbit.ephemeris.domains.Usuario;

@Service
public interface EmailService {

	//Email com texto plano
	void sendUsuarioConfirmationEmail(Usuario obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	//Email com HTML
	void sendUsuarioConfirmationHtmlEmail(Usuario obj);
	
	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Usuario usuario, String newPass);
	
}
