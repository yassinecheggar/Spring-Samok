package com.crm.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Morale")
public class clientMorale  implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id @GeneratedValue 
	private int Id;
	private int numeroPatente;
	private int numeroRegistreCommerce;
	private String raisonSocial;
	
	public clientMorale() {
		
	}

	public int getNumeroPatente() {
		return numeroPatente;
	}

	public void setNumeroPatente(int numeroPatente) {
		this.numeroPatente = numeroPatente;
	}

	public int getNumeroRegistreCommerce() {
		return numeroRegistreCommerce;
	}

	public void setNumeroRegistreCommerce(int numeroRegistreCommerce) {
		this.numeroRegistreCommerce = numeroRegistreCommerce;
	}

	public String getRaisonSocial() {
		return raisonSocial;
	}

	public void setRaisonSocial(String raisonSocial) {
		this.raisonSocial = raisonSocial; 
	}

	public int getId() {
		return Id;
	}
	
	
	
}
