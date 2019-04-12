package ar.edu.unlam.tallerweb1;
public class Ciudad {

	private String nombre;
	private String ubicacionGeografica;
	private String pais;
	
	public Ciudad() {
	}

	public Ciudad(String nombre, String ubicacionGeografica, String pais) {
		this.nombre = nombre;
		this.ubicacionGeografica = ubicacionGeografica;
		this.pais = pais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacionGeografica() {
		return ubicacionGeografica;
	}

	public void setUbicacionGeografica(String ubicacionGeografica) {
		this.ubicacionGeografica = ubicacionGeografica;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}	
}
