package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.model.Libro;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class LibroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private LibroFacade ejbLibroFacade;

	private List<Libro> list;
	private String nombre;
	private String isbn;
	private int numPag;

	public LibroBean() {

	}


	@PostConstruct
	public void init() {
		list = ejbLibroFacade.findAll();

	}

	
	public Libro[] getList(){
		return list.toArray(new Libro[0]);
	}


	public void setList(List<Libro> listLibros) {
		this.list = listLibros;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}

	public String add() {
		ejbLibroFacade.create(new Libro(this.nombre, this.isbn, this.numPag));
		list = ejbLibroFacade.findAll();
		return null;
	}

	public String delete(Libro c) {
		ejbLibroFacade.remove(c);
		list = ejbLibroFacade.findAll();
		return null;
	}

	public String edit(Libro c) {
		c.setEditable(true);
		return null;
	}

	public String save(Libro c) {
		ejbLibroFacade.edit(c);
		c.setEditable(false);
		return null;
	}

}
