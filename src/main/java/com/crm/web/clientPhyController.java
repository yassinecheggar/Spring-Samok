package com.crm.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crm.dao.clientMrlDao;
import com.crm.dao.clientPhyDao;
import com.crm.models.clientMorale;
import com.crm.models.clientPhysique;
@RestController
@CrossOrigin
public class clientPhyController {
	
	@Autowired
	private clientPhyDao client;
	
	@RequestMapping(value="/clientPhysique", method=RequestMethod.GET)
	public List<clientPhysique> index() {
		
		return client.consultAllClientPhy();
	}
	
	@RequestMapping(value="/clientPhysique/{id}", method=RequestMethod.GET)
	public clientPhysique getClientPhysId(@PathVariable  int id) {
		
		return client.consultclientPhyId(id);
	}
	
	@CrossOrigin
	@RequestMapping(value="/clientPhysique", method=RequestMethod.POST)
	public clientPhysique addclientPhys(@RequestBody clientPhysique c){
		
		return client.addclienPhysique(c);
	}
	
	@CrossOrigin
	@RequestMapping(value="/clientPhysique/{id}", method=RequestMethod.PUT)
	public clientPhysique updateClientPhys(@PathVariable  int id ,@RequestBody clientPhysique c ) {
		
		return client.update(id, c);
	}
	
	@RequestMapping(value="/clientPhysiqueC/{cin}", method=RequestMethod.GET)
	public clientPhysique  getClientPhysCIN(@PathVariable  String cin) {
		
		return client.consultclienPhyCin(cin);
	}
	
	@RequestMapping(value="/clientPhysiqueN/{nom}", method=RequestMethod.GET)
	public List<clientPhysique>  getClientPhysnom(@PathVariable  String nom) {
		
		return client.consultclienNom(nom);
	}
	

	@RequestMapping(value="/clientPhysiqueP/{prenom}", method=RequestMethod.GET)
	public List<clientPhysique>  getClientPhysprenom(@PathVariable  String prenom) {
		
		return client.consultclienPrenom(prenom);
	}
}
