package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.model.Autor;

@Named
@SessionScoped
public class AutorBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private AutorFacade ejbAutorFacade;
	
	private List<Autor> list;
	private String  nombre;
	private String nacionalidad;
	
	public AutorBean() {
		
	}
	
	@PostConstruct
	public void init() {
		list = ejbAutorFacade.findAll();
	}

	public Autor[] getList() {
		return list.toArray(new Autor[0]);
	}

	public void setList(List<Autor> list) {
		this.list = list;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public String add() {
		ejbAutorFacade.create(new Autor(this.nombre, this.nacionalidad));
		list = ejbAutorFacade.findAll();
		return null;
	}
	
	public String delete(Autor c) {
		ejbAutorFacade.remove(c);
		list = ejbAutorFacade.findAll();
		return null;
	}
	
	public String edit(Autor c) {
		c.setEditable(true);
		return null;
	}
	
	public String save(Autor c) {
		ejbAutorFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
	
	
	

}
