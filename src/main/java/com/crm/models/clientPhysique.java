package com.crm.models;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import com.mysql.fabric.xmlrpc.base.Data;

@Entity
@Table(name="Physique")
public class clientPhysique  implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@javax.persistence.Id   @GeneratedValue
	private int Id;
	private String CIN;
	private Date dateNaissance ;
	private String lieuNaissance;
	private String nationalite;
	private String nom;
	private String prenom;
	private Long NumeroCarteCredit;
	private String situationFamiliale;
	
	public clientPhysique() {
		
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
		
	}

	public Date getDateNaissance() { 
	
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getNumeroCarteCredit() {
		return NumeroCarteCredit;
	}

	public void setNumeroCarteCredit(Long numeroCarteCredit) {
		NumeroCarteCredit = numeroCarteCredit;
	}

	public String getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(String situationFamiliale) {
		this.situationFamiliale = situationFamiliale;
	}

	public int getId() {
		return Id;
	}

	public clientPhysique(String cIN, Date dateNaissance, String lieuNaissance, String nationalite, String nom,
			String prenom, Long numeroCarteCredit, String situationFamiliale) {
		super();
		CIN = cIN;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.nationalite = nationalite;
		this.nom = nom;
		this.prenom = prenom;
		NumeroCarteCredit = numeroCarteCredit;
		this.situationFamiliale = situationFamiliale;
	}
	
	
	
}
