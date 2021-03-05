package com.siderbit.ephemeris.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.siderbit.ephemeris.domains.Usuario;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	// Uma instancia do template engine
	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void sendUsuarioConfirmationEmail(Usuario obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromUsuario(obj);
		sendEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromUsuario(Usuario obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Usuário confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}

	// TRABALHANDO COM O TEMPLATE THYMELEAF
	protected String htmlFromTemplateUsuario(Usuario obj) {
		// Para acessar o template
		Context context = new Context();
		context.setVariable("usuario", obj);
		return templateEngine.process("email/confirmacaoCadastro", context);
	}

	@Override
	public void sendUsuarioConfirmationHtmlEmail(Usuario obj) {
		try {
			MimeMessage mm = prepareMimeMessageFromUsuario(obj);
			sendHtmlEmail(mm);
		} catch (MessagingException e) {
			sendUsuarioConfirmationEmail(obj);
		}
	}

	// Para poder ser implementado em alguma subclasse
	protected MimeMessage prepareMimeMessageFromUsuario(Usuario obj) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Cadastro confirmado! Código: " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateUsuario(obj), true);
		return mimeMessage;
	}
}
