package com.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.models.client;
import com.crm.models.clientMorale;

@Repository
public class clientDaoImpl implements clientDao {
	@Autowired
	
	private EntityManager em ;
	
	
	public clientDaoImpl() {
		
		
	}

	@Transactional
	public client addclien(client c) {
		em.persist(c);
		//System.out.println("lol");
		return c;
	}

	@Transactional
	public List<client> consultAllClient() {
		
		return em.createQuery("from client").getResultList();
	}

	@Transactional
	public client consultclientWithName(String name) {
		client c = em.find(client.class, name);
		return c;
	}

	@Transactional
	public client consultclientWithId(int id) {
		client c = em.find(client.class, id);
		return c;
	}

	@Transactional
	public client deletClient(int id) {
		client c = em.find(client.class, id);
		em.remove(c);
		return null;
	}

	@Transactional
	public client update(int id, client c) {
		client cl = em.find(client.class, id);

		 
		  cl.setNom(c.getNom());
		  cl.setAdresse(c.getAdresse());
		  cl.setTelephone(c.getTelephone());
		  cl.setEmail(c.getEmail());
		return c;
	}

	@Transactional
	public List<client> consultclientWithNom(String nom) {
		 
		
		return em.createQuery(
			    " FROM client WHERE nom LIKE :nom")
			    .setParameter("nom", nom)
			    
			    .getResultList();
	}

	
	

}
