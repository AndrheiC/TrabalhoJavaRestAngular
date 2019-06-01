package br.com.opet.mensageiro.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.com.opet.mensageiro.dao.EmailDAO;
import br.com.opet.mensageiro.model.Body;
import br.com.opet.mensageiro.model.Email;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.opet.mensageiro.*"})
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		Email email = new Email();
		email.setId(1);
		
		String str = "2015-03-15";
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dateTime = LocalDate.parse(str, formatter);
		email.setData(dateTime);
		
		email.setOrigem("Meu");
		email.setSituacao('1');
		
		List<Body> message = new ArrayList <Body>();
		Body mensagem = new Body();
		mensagem.setId(1);
		mensagem.setEmail(email);
		mensagem.setMessage("Minha mensagem");
		
		message.add(mensagem);
		
		
		email.setMensagem(message);
		
		EmailDAO dao = new EmailDAO();
		dao.persist(email);
		
		System.out.println("PAssou");
		

	}

}
