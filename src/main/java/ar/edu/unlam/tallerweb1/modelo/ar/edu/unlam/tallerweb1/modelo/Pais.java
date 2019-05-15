package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pais {

	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	int habitantes;
	
	String nombre;
	String idioma;
	
	@OneToOne
	Ciudad capital;
	
	@ManyToOne
	Continente continente;

	/* CONSTRUCTORS */
	public Pais(String nombre, int habitantes, String idioma, Ciudad capital, Continente continente) {
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.idioma = idioma;
		this.capital = capital;
		this.continente = continente;
	}
	
	/* SETTERS */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public void setCapital(Ciudad capital) {
		this.capital = capital;
	}
	
	public void setContinente(Continente continente) {
		this.continente = continente;
	}
	
	/* GETTERS */
	
	public Long getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public String getIdioma() {
		return this.idioma;
	}
	
	public Ciudad getCapital() {
		return this.capital;
	}
	
	public Continente getContinente() {
		return this.continente;
	}
	
}
