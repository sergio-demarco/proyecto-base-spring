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
import org.hibernate.criterion.Restrictions;

//SIEMPRE TIENE QUE EXTENDER SPRING TEST
public class PaisTest extends SpringTest {
	
	@Test
	@Transactional
	@Rollback
	public void recuperarTodasLasCiudadesDelHemisferioSur(){
		//El ecuador esta a Latitud: -2.0000000 / Longitud: -77.5000000 / 
		
		Session session = getSession();

		// UBICACIONES 
		Ubicacion ubicacion1 = new Ubicacion(-10.0, -77.0); //este esta x debajo
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(-1.0, -77.0); //este esta x arriba
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(-1.0, -78.0); //este esta x arriba
		session.save(ubicacion3);

		// CONTINENTES 
		Continente continente1 = new Continente("Europa");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);

		// PAISES 
		Pais pais1 = new Pais("España", 1, "Español", "Madrid", continente1);
		session.save(pais1);

		Pais pais2 = new Pais("Estados Unidos", 1, "Ingles", "Washington", continente2);
		session.save(pais2);

		Pais pais3 = new Pais("Canada", 1, "Ingles", "Nose", continente2);
		session.save(pais3);

		// CIUDADES 
		Ciudad ciudad1 = new Ciudad("Madrid", ubicacion1, pais1);
		session.save(ciudad1);

		Ciudad ciudad2 = new Ciudad("Nueva York", ubicacion2, pais2);
		session.save(ciudad2);

		Ciudad ciudad3 = new Ciudad("Nosejojo", ubicacion3, pais3);
		session.save(ciudad3);
		
		List<Ciudad> result = 
				(List<Ciudad>) session.createCriteria(Ciudad.class)
				.createAlias("ubicacionGeografica","u")
				.add(Restrictions.lt("u.latitud",-2.0))
				.list();
		
		assertThat(result.size()).isEqualByComparingTo(1);
	}
	
	@Test
	@Transactional
	@Rollback
	public void recuperarTodosLosPaisesCuyaCapitalEstanAlNorteDelTropicoDeCancer(){
		//El tropico de cancer esta a : Latitud: 23,5 / Longitud: 0
		
		Session session = getSession();

		// UBICACIONES 
		Ubicacion ubicacion1 = new Ubicacion(24.0, 10.0);
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(20.0, 20.0);
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(30.0, 30.0);
		session.save(ubicacion3);

		// CONTINENTES 
		Continente continente1 = new Continente("Europa");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);

		// PAISES 
		Pais pais1 = new Pais("España", 1, "Español", "Madrid", continente1);
		session.save(pais1);

		Pais pais2 = new Pais("Estados Unidos", 1, "Ingles", "Washington", continente2);
		session.save(pais2);

		Pais pais3 = new Pais("Canada", 1, "Ingles", "Nose", continente2);
		session.save(pais3);

		// CIUDADES 
		Ciudad ciudad1 = new Ciudad("Madrid", ubicacion1, pais1);
		session.save(ciudad1);

		Ciudad ciudad2 = new Ciudad("Nueva York", ubicacion2, pais2);
		session.save(ciudad2);

		Ciudad ciudad3 = new Ciudad("Nosejojo", ubicacion3, pais3);
		session.save(ciudad3);
		
		List<Ciudad> result = 
				(List<Ciudad>) session.createCriteria(Ciudad.class)
				.createAlias("ubicacionGeografica","u")
				.add(Restrictions.gt("u.latitud", 23.5)).list();
		
		assertThat(result.size()).isEqualByComparingTo(2);
	}
	
	@Test
	@Transactional
	@Rollback
	public void recuperarTodosLosPaisesDelContinenteEuropeo(){
		Session session = getSession();

		/* UBICACIONES */
		Ubicacion ubicacion1 = new Ubicacion(10.0, 10.0);
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(20.0, 20.0);
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(30.0, 30.0);
		session.save(ubicacion3);

		/* CONTINENTES */
		Continente continente1 = new Continente("Europa");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);

		/* PAISES */
		Pais pais1 = new Pais("España", 1, "Español", "Madrid", continente1);
		session.save(pais1);

		Pais pais2 = new Pais("Estados Unidos", 1, "Ingles", "Washington", continente2);
		session.save(pais2);

		Pais pais3 = new Pais("Canada", 1, "Ingles", "Nose", continente2);
		session.save(pais3);

		/* CIUDADES */
		Ciudad ciudad1 = new Ciudad("Madrid", ubicacion1, pais1);
		session.save(ciudad1);

		Ciudad ciudad2 = new Ciudad("Nueva York", ubicacion2, pais2);
		session.save(ciudad2);

		Ciudad ciudad3 = new Ciudad("Nosejojo", ubicacion3, pais3);
		session.save(ciudad3);
		
		List<Pais> result = 
				(List<Pais>) session.createCriteria(Pais.class)
				.createAlias("continente","c")
				.add(Restrictions.eq("c.nombre", "Europa")).list();
		
		assertThat(result.size()).isEqualByComparingTo(1);
	}

	@Test
	@Transactional
	@Rollback
	public void recuperarPaisesHablaInglesa() {

		Session session = getSession();

		/* UBICACIONES */
		Ubicacion ubicacion1 = new Ubicacion(10.0, 10.0);
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(20.0, 20.0);
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(30.0, 30.0);
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
		
		List<Pais> result = 
				(List<Pais>) session.createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "Ingles")).list();
		
		assertThat(result.size()).isEqualByComparingTo(2);
	}
}
