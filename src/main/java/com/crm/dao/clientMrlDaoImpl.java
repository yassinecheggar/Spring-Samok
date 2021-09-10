package com.crm.dao;

import java.util.List;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.models.client;
import com.crm.models.clientMorale;
import com.crm.models.clientPhysique;
@Repository
public class clientMrlDaoImpl  implements clientMrlDao{
	@Autowired
	private EntityManager em ; 
	
	
	@Transactional
	public clientMorale addclienMorale(clientMorale m) {
		em.persist(m);
		return m;
	}

	@Transactional
	public List<clientMorale> consultAllClientMO() {
		
		 return em.createQuery("from clientMorale").getResultList();
	}

	@Transactional
	public clientMorale consultclienMoralRaisons(String raisonSocial) {
		clientMorale c = em.find(clientMorale.class, raisonSocial);
		return c;
	}

	@Transactional
	public clientMorale consultclientMoralId(int id) {
		clientMorale c = em.find(clientMorale.class,id);
		return c;
	}

	@Transactional
	public clientMorale deletClientMoral(int id) {
		clientMorale c = em.find(clientMorale.class,id);
		em.remove(c);
		return null;
	}
	
	@Transactional
	public clientMorale update(int id, clientMorale c) {
		clientMorale cl = em.find(clientMorale.class, id);

		 
		  cl.setNumeroPatente(c.getNumeroPatente());
		  cl.setNumeroRegistreCommerce(c.getNumeroRegistreCommerce());
		  cl.setRaisonSocial(c.getRaisonSocial());
		return c;
	}

	@Transactional
	public clientMorale consultclientMoralRaison(String raison) {
		List<clientMorale> e =  em.createQuery(
			    " FROM clientMorale WHERE raisonSocial LIKE :raison")
			    .setParameter("raison", raison)
			    
			    .getResultList();
		return e.get(0);
	}

}
