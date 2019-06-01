package br.com.opet.mensageiro.dao;

import javax.persistence.EntityManager;

import br.com.opet.mensageiro.model.Body;
import br.com.opet.mensageiro.util.JPAUtil;

public class BodyDAO {
	
	
	private EntityManager em = new JPAUtil().getEntityManager();

	public void persist(Body message) {
		try {
			em.getTransaction().begin();
			em.persist(message);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			
		}
	}

}
