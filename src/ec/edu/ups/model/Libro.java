package ec.edu.ups.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "libro")
public class Libro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	private String isbn;
	private int numPag;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "capitulo")
	private List<Capitulo> listaCapitulos;
	
	@Transient
	private boolean editable;

	public Libro() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public List<Capitulo> getListaCapitulos() {
		return listaCapitulos;
	}

	public void setListaCapitulos(List<Capitulo> listaCapitulos) {
		this.listaCapitulos = listaCapitulos;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", isbn=" + isbn + ", numPag=" + numPag
				+ ", listaCapitulos=" + listaCapitulos + ", editable=" + editable + "]";
	}
	
	
	

}
