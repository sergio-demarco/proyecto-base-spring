package ar.edu.unlam.tallerweb1.persistencia.ar;

//REQUERIDO SPRING TEST
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Continente;
//REQUERIDO CLASE QUE VA A TESTEAR
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Ubicacion;

//REQUERIDO PARA TESTEAR
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

//REQUERIDO PARA ASSERTEAR
import static org.assertj.core.api.Assertions.*;

//REQUERIDO PARA UTILIZAR LINKEDLIST
import java.util.LinkedList;
//REQUERIDO PARA USAR LIST
import java.util.List;

//REQUERIDO PARA HACER DML
import org.hibernate.Session;

//SIEMPRE TIENE QUE EXTENDER SPRING TEST
public class PaisTest extends SpringTest {
	/*
	 * // SE INICIA LA SESSION DE SPRING PARA HACER DML Y QUERY Session session =
	 * getSession();
	 * 
	 * // INSERT DATA ZONE Jugador jugador = new Jugador();
	 * jugador.setNombre("pepito");
	 * 
	 * session.save(jugador);
	 * 
	 * // SE QUEREA CON EL METODO .GET(NOMBRECLASE.CLASS, REGISTRO.GETID()) Jugador
	 * jugadorRetrieved = session.get(Jugador.class, jugador.getId());
	 * 
	 * assertThat(jugadorRetrieved).isNotNull();
	 * 
	 */

	@Test
	@Transactional
	@Rollback
	public void recuperarPaisesHablaInglesa() {

		Session session = getSession();

		/* UBICACIONES */
		Ubicacion ubicacion1 = new Ubicacion("10", "10");
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion("20", "20");
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion("30", "30");
		session.save(ubicacion3);

		/* CONTINENTES */
		Continente continente1 = new Continente("America del Sur");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);

		/* PAISES */
		Pais pais1 = new Pais("Argentina", 1, "Español", "La Plata", continente1);
		session.save(pais1);

		Pais pais2 = new Pais("Estados Unidos", 1, "Ingles", "Washington", continente2);
		session.save(pais2);

		Pais pais3 = new Pais("Canada", 1, "Ingles", "Nose", continente2);
		session.save(pais3);

		/* CIUDADES */
		Ciudad ciudad1 = new Ciudad("Buenos Aires", ubicacion1, pais1);
		session.save(ciudad1);

		Ciudad ciudad2 = new Ciudad("Nueva York", ubicacion2, pais2);
		session.save(ciudad2);

		Ciudad ciudad3 = new Ciudad("Nosejojo", ubicacion3, pais3);
		session.save(ciudad3);

		/* TESTING LOGIC */
		List<Pais> paises = new LinkedList<Pais>();
		paises.add(pais1);
		paises.add(pais2);
		paises.add(pais3);
		
		//TODO modificar esto utilizando metodos get del session!!
		
		List<Pais> paisesDeHablaInglesa = new LinkedList<Pais>();
		assertThat(paisesDeHablaInglesa).isEmpty();
		
		assertThat(paises.size()).isEqualByComparingTo(3);
		for (Pais pais : paises) {
			if ("Ingles" == pais.getIdioma()) {
				paisesDeHablaInglesa.add(pais);
			}
		}

		assertThat(paisesDeHablaInglesa.size()).isEqualByComparingTo(2);
	}
}
