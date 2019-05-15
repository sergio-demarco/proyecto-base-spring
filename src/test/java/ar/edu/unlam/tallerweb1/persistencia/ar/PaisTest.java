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
		//La latitud del ecuador es por definición 0° (cero grados).
		
		Session session = getSession();

		// UBICACIONES 
		Ubicacion ubicacion1 = new Ubicacion(40.41, -3.70);
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(40.71, -74.00);
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(-34.61, -58.37);
		session.save(ubicacion3);

		// CONTINENTES 
		Continente continente1 = new Continente("America del Sur");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);
		
		Continente continente3 = new Continente("Europa");
		session.save(continente3);

		// CIUDADES 
		Ciudad madrid = new Ciudad("Madrid", ubicacion1);//long -3.70 , lat 40.41
		session.save(madrid);

		Ciudad newYork = new Ciudad("Nueva York", ubicacion2);//long -74 lat 40.71
		session.save(newYork);

		Ciudad buenosAires = new Ciudad("Buenos Aires", ubicacion3);// long -58.37 lat -34.61
		session.save(buenosAires);
		
		// PAISES 
		Pais espania = new Pais("España", 1, "Español", madrid, continente3);
		session.save(espania);

		Pais eeuu = new Pais("Estados Unidos", 1, "Ingles", newYork, continente2);
		session.save(eeuu);

		Pais argentina = new Pais("Argentina", 1, "Español", buenosAires, continente2);
		session.save(argentina);
		
		//Assign each country to each city
		//todo ver la funcionalidad que permitia hacer la insercion si no estaba insertada
		madrid.setPais(espania);
		session.update(madrid);

		newYork.setPais(eeuu);
		session.update(newYork);

		buenosAires.setPais(argentina);
		session.update(buenosAires);
		
		List<Ciudad> result = 
				(List<Ciudad>) session.createCriteria(Ciudad.class)
				.createAlias("ubicacionGeografica","u")
				.add(Restrictions.lt("u.latitud",0.00))
				.list();
		
		//Solo buenos aires esta por debajo del ecuador
		assertThat(result.size()).isEqualByComparingTo(1);
	}
	
	@Test
	@Transactional
	@Rollback
	public void recuperarTodosLosPaisesCuyaCapitalEstanAlNorteDelTropicoDeCancer(){
		//Este paralelo está situado actualmente a una latitud de 23°26'16" al norte del Ecuador
		// osea latitud 23.4377777778
		
		Session session = getSession();

		// UBICACIONES 
		Ubicacion ubicacion1 = new Ubicacion(40.41, -3.70);
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(40.71, -74.00);
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(-34.61, -58.37);
		session.save(ubicacion3);

		// CONTINENTES 
		Continente continente1 = new Continente("America del Sur");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);
		
		Continente continente3 = new Continente("Europa");
		session.save(continente3);

		// CIUDADES 
		Ciudad madrid = new Ciudad("Madrid", ubicacion1);//long -3.70 , lat 40.41
		session.save(madrid);

		Ciudad newYork = new Ciudad("Nueva York", ubicacion2);//long -74 lat 40.71
		session.save(newYork);

		Ciudad buenosAires = new Ciudad("Buenos Aires", ubicacion3);// long -58.37 lat -34.61
		session.save(buenosAires);
		
		// PAISES 
		Pais espania = new Pais("España", 1, "Español", madrid, continente3);
		session.save(espania);

		Pais eeuu = new Pais("Estados Unidos", 1, "Ingles", newYork, continente2);
		session.save(eeuu);

		Pais argentina = new Pais("Argentina", 1, "Español", buenosAires, continente2);
		session.save(argentina);
		
		//Assign each country to each city
		//todo ver la funcionalidad que permitia hacer la insercion si no estaba insertada
		madrid.setPais(espania);
		session.update(madrid);

		newYork.setPais(eeuu);
		session.update(newYork);

		buenosAires.setPais(argentina);
		session.update(buenosAires);
		
		List<Ciudad> result = 
				(List<Ciudad>) session.createCriteria(Ciudad.class)
				.createAlias("ubicacionGeografica","u")
				.add(Restrictions.gt("u.latitud",23.43))
				.list();
		
		//Tanto Madrid como New York estan por derriba de la latitud del tropico de cancer
		assertThat(result.size()).isEqualByComparingTo(2);
	}
	
	@Test
	@Transactional
	@Rollback
	public void recuperarTodosLosPaisesDelContinenteEuropeo(){
		Session session = getSession();

		// UBICACIONES 
		Ubicacion ubicacion1 = new Ubicacion(40.41, -3.70);
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(40.71, -74.00);
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(-34.61, -58.37);
		session.save(ubicacion3);

		// CONTINENTES 
		Continente continente1 = new Continente("America del Sur");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);
		
		Continente continente3 = new Continente("Europa");
		session.save(continente3);

		// CIUDADES 
		Ciudad madrid = new Ciudad("Madrid", ubicacion1);//long -3.70 , lat 40.41
		session.save(madrid);

		Ciudad newYork = new Ciudad("Nueva York", ubicacion2);//long -74 lat 40.71
		session.save(newYork);

		Ciudad buenosAires = new Ciudad("Buenos Aires", ubicacion3);// long -58.37 lat -34.61
		session.save(buenosAires);
		
		// PAISES 
		Pais espania = new Pais("España", 1, "Español", madrid, continente3);
		session.save(espania);

		Pais eeuu = new Pais("Estados Unidos", 1, "Ingles", newYork, continente2);
		session.save(eeuu);

		Pais argentina = new Pais("Argentina", 1, "Español", buenosAires, continente2);
		session.save(argentina);
		
		//Assign each country to each city
		//todo ver la funcionalidad que permitia hacer la insercion si no estaba insertada
		madrid.setPais(espania);
		session.update(madrid);

		newYork.setPais(eeuu);
		session.update(newYork);

		buenosAires.setPais(argentina);
		session.update(buenosAires);
		
		List<Pais> result = 
				(List<Pais>) session.createCriteria(Pais.class)
				.createAlias("continente","c")
				.add(Restrictions.eq("c.nombre", "Europa")).list();
		
		//Solo Espania esta en Europa
		assertThat(result.size()).isEqualByComparingTo(1);
	}
	
	@Test
	@Transactional
	@Rollback
	public void recuperarPaisesHablaInglesa() {
		Session session = getSession();

		// UBICACIONES 
		Ubicacion ubicacion1 = new Ubicacion(40.41, -3.70);
		session.save(ubicacion1);

		Ubicacion ubicacion2 = new Ubicacion(40.71, -74.00);
		session.save(ubicacion2);

		Ubicacion ubicacion3 = new Ubicacion(-34.61, -58.37);
		session.save(ubicacion3);

		// CONTINENTES 
		Continente continente1 = new Continente("America del Sur");
		session.save(continente1);

		Continente continente2 = new Continente("America del Norte");
		session.save(continente2);
		
		Continente continente3 = new Continente("Europa");
		session.save(continente3);

		// CIUDADES 
		Ciudad madrid = new Ciudad("Madrid", ubicacion1);//long -3.70 , lat 40.41
		session.save(madrid);

		Ciudad newYork = new Ciudad("Nueva York", ubicacion2);//long -74 lat 40.71
		session.save(newYork);

		Ciudad buenosAires = new Ciudad("Buenos Aires", ubicacion3);// long -58.37 lat -34.61
		session.save(buenosAires);
		
		// PAISES 
		Pais espania = new Pais("España", 1, "Español", madrid, continente3);
		session.save(espania);

		Pais eeuu = new Pais("Estados Unidos", 1, "Ingles", newYork, continente2);
		session.save(eeuu);

		Pais argentina = new Pais("Argentina", 1, "Español", buenosAires, continente2);
		session.save(argentina);
		
		//Assign each country to each city
		//todo ver la funcionalidad que permitia hacer la insercion si no estaba insertada
		madrid.setPais(espania);
		session.update(madrid);

		newYork.setPais(eeuu);
		session.update(newYork);

		buenosAires.setPais(argentina);
		session.update(buenosAires);
		
		List<Pais> result = 
				(List<Pais>) session.createCriteria(Pais.class)
				.add(Restrictions.eq("idioma", "Ingles")).list();
		
		//Solo en eeuu se habla Ingles
		assertThat(result.size()).isEqualByComparingTo(1);
	}
	
}
