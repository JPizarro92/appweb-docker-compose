package ec.edu.ups.appweb.business;

import java.util.List;

import javax.ejb.Local;

import ec.edu.ups.appweb.model.Persona;

@Local
public interface PersonaONLocal {
	
	public void insert(Persona p) throws Exception;
	
	public List<Persona> getUsers();
	
}
