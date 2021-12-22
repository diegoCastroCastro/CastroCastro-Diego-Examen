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
@Table(name = "autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	private String nacionalidad;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "libro")
	private List<Capitulo> listaCapitulos;
	
	@Transient
	private boolean editable;

	public Autor() {
		super();
	}
	
	

	public Autor(String nombre, String nacionalidad) {
		super();
		this.nombre = nombre;
		this.nacionalidad = nacionalidad;
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

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
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
		return "Autor [codigo=" + codigo + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", listaCapitulos="
				+ listaCapitulos + ", editable=" + editable + "]";
	}
	
	
	
	
	
}
