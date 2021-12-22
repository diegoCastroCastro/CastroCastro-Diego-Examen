package ec.edu.ups.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.AutorFacade;
import ec.edu.ups.ejb.CapituloFacade;
import ec.edu.ups.ejb.LibroFacade;
import ec.edu.ups.model.Autor;
import ec.edu.ups.model.Capitulo;
import ec.edu.ups.model.Libro;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class LibroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private LibroFacade ejbLibroFacade;
	@EJB
	private AutorFacade ejbAutorFacade;
	@EJB
	private CapituloFacade ejbCapituloFacade;

	private List<Libro> list;
	private List<Capitulo> listCapitulos;
	private String nombre;
	private String isbn;
	private int numPag;
	
	private int num;
	private String titulo;
	private Integer autor;
	
	private Libro libro;
	private Capitulo capitulo;


	public LibroBean() {

	}

	@PostConstruct
	public void init() {
		list = ejbLibroFacade.findAll();
		listCapitulos = new ArrayList<>();
		libro = new Libro();
		capitulo = new Capitulo();

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
	
	

	public List<Capitulo> getListCapitulos() {
		return listCapitulos;
	}

	public void setListCapitulos(List<Capitulo> listCapitulos) {
		this.listCapitulos = listCapitulos;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Capitulo getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}

	public String save(Libro c) {
		ejbLibroFacade.edit(c);
		c.setEditable(false);
		return null;
	}
	
	public void agregaCapitulo() {
		capitulo.setNumero(num);
		capitulo.setTitulo(this.titulo);
		capitulo.setAutor(ejbAutorFacade.find(this.autor));
		listCapitulos.add(capitulo);
		capitulo = new Capitulo();
	}
	
	public void agregarLibro() {
		
		libro.setIsbn(this.isbn);
		libro.setNombre(this.nombre);
		libro.setNumPag(this.numPag);
		libro.setListaCapitulos(this.listCapitulos);
		ejbLibroFacade.create(libro);
		listCapitulos = new ArrayList<>();
		libro = new Libro();
		
	}

}
