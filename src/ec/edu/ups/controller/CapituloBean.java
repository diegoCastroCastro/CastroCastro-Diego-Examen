package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.model.Capitulo;


@Named
@SessionScoped
public class CapituloBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private CapituloFacade ejCapituloFacade;
	@EJB
	private LibroFacade ejLibroFacade;
	
	private List<Capitulo> list;
	private int numero;
	private String titulo;
	
	public CapituloBean() {
		
	}
	
	public void init() {
		list = ejCapituloFacade.findAll();
	}

	public Capitulo[] getList() {
		return list.toArray(new Capitulo[0]);
	}

	public void setList(List<Capitulo> list) {
		this.list = list;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String add() {
		ejCapituloFacade.create(new Capitulo(this.numero, this.titulo));
		list = ejCapituloFacade.findAll();
		return null;
	}
	
	public String delete(Capitulo c) {
		ejCapituloFacade.remove(c);
		list = ejCapituloFacade.findAll();
		return null;
	}
	
	public String edit(Capitulo c) {
		c.setEditable(true);
		return null;
	}
	
	public String save(Capitulo c) {
		ejCapituloFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
}
