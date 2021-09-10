package com.crm.dao;

import java.util.List;

import com.crm.models.client;
import com.crm.models.clientPhysique;

public interface clientPhyDao {

	public clientPhysique addclienPhysique( clientPhysique P);
	public List<clientPhysique>consultAllClientPhy();
	public clientPhysique consultclienPhyCin(String CIN);
	public List<clientPhysique> consultclienNom(String nom);
	public List<clientPhysique> consultclienPrenom(String prenom);
	
	public clientPhysique consultclientPhyId(int id);
	public clientPhysique deletClientPhy(int id);
	public clientPhysique update(int id , clientPhysique c);
	 
}
