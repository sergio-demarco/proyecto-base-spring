package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Continente {
	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	/* CONSTRUCTORS */
	public Continente(String nombre) {
		this.nombre = nombre;
	}
	
	/* SETTERS */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/* GETTERS */
	public Long getId() {
		return this.id;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
