package br.com.etecmam.urnaeletronica.dmp;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class CandidatoDAO {
	
	EntityManagerFactory emf; 
	
	public CandidatoDAO() {		
		emf = Persistence.createEntityManagerFactory("CANDIDATO_UNIT");
	}
	
	public void adicionar(Candidato candidato) {
			
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(candidato);		
		em.getTransaction().commit();		
		
		em.close();
		
	}
	
	public void atualizar(Candidato candidato) {
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(candidato);		
		em.getTransaction().commit();
		
		em.close();
		
	}
	
	public Candidato pesquisar(Integer numero) {
		
		EntityManager em = emf.createEntityManager();
		Candidato candidato = em.find(Candidato.class, numero);		
		em.close();
		
		return candidato;
		
	}
	
	public List<Candidato> listarCandidatos() {
		
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Candidato> q =  em.createQuery("SELECT C FROM Candidato C", Candidato.class);
		List<Candidato> lista = q.getResultList();
		 		
		em.close();
		
		return lista;
		
	}	
		
	public void remover(Integer numero) {
				
		EntityManager em = emf.createEntityManager();
		
		Candidato candidato = em.find(Candidato.class, numero);
		
		if(candidato != null) {
			em.getTransaction().begin();
			em.remove(candidato);		
			em.getTransaction().commit();	
		}
	
		em.close();
		
	}	
		
}
