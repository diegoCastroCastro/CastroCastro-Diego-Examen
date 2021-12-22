package ec.edu.ups.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.model.Autor;

public class AutorFacade extends AbstractFacade<Autor>{


	@PersistenceContext(unitName = "CastroCastro-Diego-Examen")
    private EntityManager em;
	
	
	public AutorFacade() {
		super(Autor.class);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return em;
	}

	
}
