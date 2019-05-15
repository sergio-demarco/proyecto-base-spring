package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Equipo {

	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Club club;

	private String nombre;
	private Integer cantidadDeCampeonatos;

	/* CONSTRUCTORS */
	public Equipo() {
		this.nombre = "";
	}

	public Equipo(String nombre, Integer cantidadDeCampeonatos) {
		this.nombre = nombre;
		this.cantidadDeCampeonatos = cantidadDeCampeonatos;
	}

	public Equipo(String nombre, Club club) {
		this.nombre = nombre;
		this.club = club;
	}

	/* AUX METHODS */
	/* SETTERS */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setCantidadDeCampeonatos(Integer cantidadDeCampeonatos) {
		this.cantidadDeCampeonatos = cantidadDeCampeonatos;
	}

	/* GETTERS */
	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Club getClub() {
		return this.club;
	}
}
