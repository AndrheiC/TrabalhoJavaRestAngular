package br.com.opet.mensageiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public EntityManager em;	

	public EntityManager getEntityManager() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mensageiro");
		if (em == null) {
			em = emf.createEntityManager();
		}
		return em;
	}

}
