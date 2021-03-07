package com.siderbit.ephemeris;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.siderbit.ephemeris.services.EmailService;
import com.siderbit.ephemeris.services.SmtpEmailService;

@SpringBootApplication
public class EphemerisApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(EphemerisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {			
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}

}
