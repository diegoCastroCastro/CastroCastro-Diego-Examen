package ec.edu.ups.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "capitulo")
public class Capitulo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private int numero;
	private int titulo;
	
	@ManyToOne
	@JoinColumn
	private Libro libro;
	
	@ManyToOne
	@JoinColumn
	private Capitulo capitulo;
	
	@Transient
	private boolean editable;

	public Capitulo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTitulo() {
		return titulo;
	}

	public void setTitulo(int titulo) {
		this.titulo = titulo;
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

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "Capitulo [codigo=" + codigo + ", numero=" + numero + ", titulo=" + titulo + ", libro=" + libro
				+ ", capitulo=" + capitulo + ", editable=" + editable + "]";
	}
	
	
	
}
