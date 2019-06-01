package br.com.opet.mensageiro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.opet.mensageiro.model.Body;
import br.com.opet.mensageiro.model.Email;
import br.com.opet.mensageiro.util.JPAUtil;

public class EmailDAO {

	private EntityManager em = new JPAUtil().getEntityManager();

	public void persist(Email email) {
		try {
			em.getTransaction().begin();
			em.persist(email);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	public Email getByIdEmail(int id) {
		return em.find(Email.class, id);
	}

	public List<Email> findByIdMensagem(int idBody) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Email> cq = cb.createQuery(Email.class);
		Root<Email> fromEmail = cq.from(Email.class);

		TypedQuery<Email> tp = em
				.createQuery(cq
						.select(fromEmail)
						.where(cb.equal(fromEmail.get("mensagem").get("id"), idBody)));

		return tp.getResultList();
	}
	
	public List<Body> findByIdEmail(int idMensagem) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Body> cq = cb.createQuery(Body.class);
		Root<Body> fromBody = cq.from(Body.class);

		TypedQuery<Body> tp = em
				.createQuery(cq
						.select(fromBody)
						.where(cb.equal(fromBody.get("email").get("id"), idMensagem)));

		return tp.getResultList();
	}

	public void merge(Email email) {
		try {
			em.getTransaction().begin();
			em.merge(email);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void update(int id) {
		try {
			em.getTransaction().begin();
			Email email = em.find(Email.class, id);
			em.persist(email);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
	
	public void remove(int id) {
		try {
			em.getTransaction().begin();
			Email email = em.find(Email.class, id);
			email.setSituacao('0');
			em.persist(email);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
