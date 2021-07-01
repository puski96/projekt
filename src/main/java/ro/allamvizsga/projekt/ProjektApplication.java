package ro.allamvizsga.projekt;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProjektApplication{

	 
	public static void main(String[] args) {
		SpringApplication.run(ProjektApplication.class, args);
	}

	
	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}
	
	
	
	
	

}
