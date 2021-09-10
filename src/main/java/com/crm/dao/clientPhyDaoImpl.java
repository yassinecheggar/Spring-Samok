package com.crm.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.models.client;
import com.crm.models.clientPhysique;
@Repository
public class clientPhyDaoImpl implements clientPhyDao {
	@Autowired
	private EntityManager em ; 
	
	
	@Transactional
	public clientPhysique addclienPhysique(clientPhysique P) {
		em.persist(P);
		return P;
	}

	@Transactional
	public List<clientPhysique> consultAllClientPhy() {
		return em.createQuery("from clientPhysique").getResultList();
	}


	@Transactional
	public clientPhysique consultclientPhyId(int id) {
		clientPhysique c = em.find(clientPhysique.class, id);
		return c;
	}

	@Transactional
	public clientPhysique deletClientPhy(int id) {
		clientPhysique c = em.find(clientPhysique.class, id);
		em.remove(c);
		return null;
	}
	
	@Transactional
	public clientPhysique update(int id, clientPhysique c) {
		clientPhysique cl = em.find(clientPhysique.class, id);

		 
		  cl.setCIN(c.getCIN());
		  cl.setDateNaissance(c.getDateNaissance());
		  cl.setLieuNaissance(c.getLieuNaissance());
		  cl.setNationalite(c.getNationalite());
		  cl.setNom(c.getNom());
		  cl.setNumeroCarteCredit(c.getNumeroCarteCredit());
		  cl.setPrenom(c.getPrenom());
		  cl.setSituationFamiliale(c.getSituationFamiliale());
		return cl;
	}

	@Transactional
	public clientPhysique consultclienPhyCin(String CIN) {
		List<clientPhysique> e =  em.createQuery(
			    " FROM clientPhysique WHERE CIN LIKE :cin")
			    .setParameter("cin", CIN)
			    
			    .getResultList();
		return e.get(0);
	}

	@Transactional
	public List<clientPhysique> consultclienNom(String nom) {
		// TODO Auto-generated method stub
		return em.createQuery(
			    " FROM clientPhysique WHERE nom LIKE :Nom")
			    .setParameter("Nom", nom)
			    
			    .getResultList();
	}

	@Transactional
	public List<clientPhysique> consultclienPrenom(String prenom) {
		// TODO Auto-generated method stub
		return em.createQuery(
			    " FROM clientPhysique WHERE prenom LIKE :Prenom")
			    .setParameter("Prenom", prenom)
			    
			    .getResultList();
	}
}
