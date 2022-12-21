package ec.edu.ups.appweb.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appweb.dao.PersonaDAO;
import ec.edu.ups.appweb.model.Persona;

@Stateless
public class PersonaON implements PersonaONLocal{
	
	@Inject
	private PersonaDAO personaDAO;
	
	@Override
	public void insert(Persona p) throws Exception {
		// TODO Auto-generated method stub
		personaDAO.insert(p);
	}

	@Override
	public List<Persona> getUsers() {
		// TODO Auto-generated method stub
		return personaDAO.getUsers();
	}

}
