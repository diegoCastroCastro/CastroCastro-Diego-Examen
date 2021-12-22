package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.model.Libro;

@Stateless
public class LibroFacade extends AbstractFacade<Libro> {

	@PersistenceContext(unitName = "CastroCastro-Diego-Examen")
    private EntityManager em;
	
	public LibroFacade() {
		super(Libro.class);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}
}
