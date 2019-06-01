package br.com.opet.mensageiro.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.opet.mensageiro.dao.EmailDAO;
import br.com.opet.mensageiro.model.Email;


@RestController
@RequestMapping("/api/")
public class Controller {	
	
	private EmailDAO emailDAO;
	
	@PostMapping(path="/emails/", consumes="application/json", produces ="application/json")
	public String addMensagem(@RequestBody(required = true) Email email) {
		
		emailDAO = new EmailDAO();		
		
		emailDAO.persist(email);
		
		return "0" ;
		
	}

}
