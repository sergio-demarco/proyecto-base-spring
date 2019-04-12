package ar.edu.unlam.tallerweb1;

public class Pais {
	private String nombre;
	private String habitantes;
	private String idioma;
	private String capital;
	private String continente;
	
	public Pais() {
		
	}

	public Pais(String nombre, String habitantes, String idioma, String capital, String continente) {
		this.nombre = nombre;
		this.habitantes = habitantes;
		this.idioma = idioma;
		this.capital = capital;
		this.continente = continente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHabitantes() {
		return habitantes;
	}

	public void setHabitantes(String habitantes) {
		this.habitantes = habitantes;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}
}
