package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ubicacion {
	/* ATTRIBUTES */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	String latitud;
	String longitud;

	/* CONSTRUCTORS */
	public Ubicacion(String latitud, String longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	/* SETTERS */
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}

	/* GETTERS */
	public Long getId() {
		return this.id;
	}

	public String getLatitud() {
		return this.latitud;
	}

	public String getLongitud() {
		return this.longitud;
	}
}
