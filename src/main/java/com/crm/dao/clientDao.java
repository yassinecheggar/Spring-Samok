package com.crm.dao;

import java.util.List;

import com.crm.models.client;



public interface clientDao {

	
	public client addclien(client c);
	public List<client>consultAllClient();
	public client consultclientWithName(String name);
	public client consultclientWithId(int id);
	public client deletClient(int id);
	public client update(int id , client c);
	public List<client> consultclientWithNom(String nom);
	
	
	
	
	
	
	
}
