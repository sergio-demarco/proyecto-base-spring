package ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Objeto {

	// La anotacion id indica que este atributo es el utilizado
	// como clave primaria de la entity, se indica que el valor es autogenerado.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	int integer;
	private String string;

	public Objeto() {
		this.integer = 1;
		this.string = "a";
	}

	public Objeto(int integer, String string) {
		this.integer = integer;
		this.string = string;
	}

	public Long getId() {
		return this.id;
	}

	public void setInteger(int integer) {
		this.integer = integer;
	}

	public void setString(String string) {
		this.string = string;
	}

	public String getString() {
		return this.string;
	}

	public int getInteger() {
		return this.integer;
	}

}
