package com.crm.dao;

import java.util.List;

import com.crm.models.client;
import com.crm.models.clientMorale;

public interface clientMrlDao {

	public clientMorale addclienMorale( clientMorale m);
	public List<clientMorale>consultAllClientMO();
	public clientMorale consultclienMoralRaisons(String raisonSocial);
	public clientMorale consultclientMoralId(int id);
	public clientMorale consultclientMoralRaison(String raison);
	public clientMorale deletClientMoral(int id);
	public clientMorale update(int id , clientMorale c);
}
