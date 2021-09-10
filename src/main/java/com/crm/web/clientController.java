package com.crm.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.crm.dao.clientDao;

@RestController
@CrossOrigin
public class clientController {

	@Autowired
	private clientDao client;
	
	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<com.crm.models.client> index() {
		
		return client.consultAllClient();
	}
	
	@RequestMapping(value="/clients/{id}", method=RequestMethod.GET)
	public com.crm.models.client getClientId(@PathVariable  int id) {
		
		return client.consultclientWithId(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/clients", method=RequestMethod.POST)
	public com.crm.models.client addclient(@RequestBody com.crm.models.client c){
		
		return client.addclien(c);
	}
	@CrossOrigin
	@RequestMapping(value="/clients/{id}", method=RequestMethod.PUT)
	public com.crm.models.client updateClient(@PathVariable  int id ,@RequestBody com.crm.models.client c ) {
		
		return client.update(id, c);
	}
	
	@RequestMapping(value="/clientsN/{nom}", method=RequestMethod.GET)
	public List<com.crm.models.client> getClientNom(@PathVariable  String nom) {
		
		return client.consultclientWithNom(nom);
	}
}
