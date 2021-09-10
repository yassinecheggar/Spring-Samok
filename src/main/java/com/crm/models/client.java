package com.crm.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class client implements Serializable {

	private static final long serialVersionUID = 1L;
@javax.persistence.Id @GeneratedValue
	private int Id;
	private String nom ;
	private String adresse ;
	private String Email ;
	private String Telephone ;
	
	public client() {
		
	}

	public int getId() {
		return Id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public client(String nom, String adresse, String email, String telephone) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		Email = email;
		Telephone = telephone;
	}
	
	
}
