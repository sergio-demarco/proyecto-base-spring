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
	private Double latitud;
	private Double longitud;
	
	/* CONSTRUCTORS */
	public Ubicacion(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}

	/* SETTERS */
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	/* GETTERS */
	public Long getId() {
		return this.id;
	}

	public Double getLatitud() {
		return this.latitud;
	}

	public Double getLongitud() {
		return this.longitud;
	}
}
