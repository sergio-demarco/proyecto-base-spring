package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Club {

	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	Equipo equipo;

	String nombre;

	/* CONSTRUCTORS */
	public Club() {
		this.nombre = "";
	}

	public Club(String nombre) {
		this.nombre = nombre;
	}

	public Club(String nombre, Equipo equipo) {
		this.nombre = nombre;
		this.equipo = equipo;
	}

	/* AUX METHODS */
	/* SETTERS */
	public String getNombre() {
		return this.nombre;
	}
	
	public Equipo getEquipo() {
		return this.equipo;
	}
	
	/* GETTERS */
}
