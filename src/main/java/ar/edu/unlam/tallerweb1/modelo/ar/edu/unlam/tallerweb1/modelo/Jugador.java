package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jugador {
	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	Equipo equipo;

	String nombre;

	/* CONSTRUCTORS */
	public Jugador() {
		this.nombre = "";
	}

	public Jugador(String nombre) {
		this.nombre = nombre;
	}

	public Jugador(String nombre, Equipo equipo) {
		this.nombre = nombre;
		this.equipo = equipo;
	}

	/* AUX METHODS */
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

	public Equipo getEquipo() {
		return this.equipo;
	}
}