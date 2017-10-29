package br.com.nou.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RepositoryJpaFactory {

	private  EntityManagerFactory factory = Persistence.createEntityManagerFactory("nou");
	
	private EntityManager manager = factory.createEntityManager();
	
	
	public EntityManager getEntityManager() {
		return this.manager;
	}

}
