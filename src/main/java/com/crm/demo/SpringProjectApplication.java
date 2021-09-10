package com.crm.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.crm.dao.clientDao;
import com.crm.dao.clientDaoImpl;
import com.crm.dao.clientMrlDao;
import com.crm.dao.clientMrlDaoImpl;
import com.crm.dao.clientPhyDao;
import com.crm.models.client;
import com.crm.models.clientMorale;

@SpringBootApplication
@EntityScan( basePackages = {"com.crm.models"} )
@ComponentScan( basePackages = {"com.crm.dao"} )
@ComponentScan( basePackages = {"com.crm.web"} )

public class SpringProjectApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(SpringProjectApplication.class, args);
		clientDao dao = ctx.getBean(clientDaoImpl.class);
		
		/*dao.addclien(new client("yassine","dkfkf", "lsdcjds", "012457"));
		dao.addclien(new client("mouna","lola", "123", "014457"));
		
		List<client> liste  =  dao.consultAllClient();
		for (client client : liste) {
			System.out.println(client.getNom());
		}
		
		dao.deletClient(1);
		
		
		client c = dao.consultclientWithId(2);
		System.out.println(c.getNom());
		*/
		clientPhyDao dd = ctx.getBean(clientPhyDao.class);
		System.out.println(dd.consultclienNom("cheggar"));
	}
}
