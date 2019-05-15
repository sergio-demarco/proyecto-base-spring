package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {
	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;
	
	@OneToOne
	private Ubicacion ubicacionGeografica;
	
	@ManyToOne
	private Pais pais;

	/* CONSTRUCTORS */
	public Ciudad(String nombre, Ubicacion ubicacionGeografica, Pais pais) {
		this.nombre = nombre;
		this.ubicacionGeografica = ubicacionGeografica;
		this.pais = pais;
	}
	
	public Ciudad(String nombre, Ubicacion ubicacionGeografica) {
		this.nombre = nombre;
		this.ubicacionGeografica = ubicacionGeografica;
	}

	/* SETTERS */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setUbicacionGeografica(Ubicacion ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/* GETTERS */
	public Long getId() {
		return this.id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Ubicacion getUbicacionGeografica() {
		return this.ubicacionGeografica;
	}

	public Pais getPais() {
		return this.pais;
	}

}
