package ec.edu.ups.appweb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appweb.model.Persona;

@Stateless
public class PersonaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona p) {
		em.persist(p);
	}
	
	@SuppressWarnings("unchecked")
	public List<Persona> getUsers(){
		List<Persona> personas = new ArrayList<Persona>();
		String jpql = "SELECT op FROM Persona op";
		
		Query query = em.createQuery(jpql, Persona.class);
		personas=query.getResultList();
		return personas;
	}
	
}
