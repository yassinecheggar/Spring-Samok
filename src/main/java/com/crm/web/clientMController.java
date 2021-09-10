package com.crm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dao.clientDao;
import com.crm.dao.clientMrlDao;
import com.crm.models.clientMorale;
@RestController
@CrossOrigin
public class clientMController {

	
	
		@Autowired
		private clientMrlDao client;
		
		@RequestMapping(value="/clientMorale", method=RequestMethod.GET)
		public List<clientMorale> index() {
			
			return client.consultAllClientMO();
		}
		
		@RequestMapping(value="/clientMorale/{id}", method=RequestMethod.GET)
		public clientMorale getClientId(@PathVariable  int id) {
			
			return client.consultclientMoralId(id);
		}
		
		@CrossOrigin
		@RequestMapping(value="/clientMorale", method=RequestMethod.POST)
		public clientMorale addclient(@RequestBody clientMorale c){
			
			return client.addclienMorale(c);
		}
		
		@CrossOrigin
		@RequestMapping(value="/clientMorale/{id}", method=RequestMethod.PUT)
		public clientMorale updateClientM(@PathVariable  int id ,@RequestBody clientMorale c ) {
			
			return client.update(id, c);
		}
		
		@RequestMapping(value="/clientMoraleR/{raison}", method=RequestMethod.GET)
		public clientMorale getClientRaison(@PathVariable  String raison) {
			
			return client.consultclientMoralRaison(raison);
		}
}
