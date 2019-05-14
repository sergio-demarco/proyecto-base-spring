//Paquete donde esta la clase
package ar.edu.unlam.tallerweb1.persistencia.ar.edu;

//REQUERIDO SPRING TEST
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Equipo;
//REQUERIDO CLASE QUE VA A TESTEAR
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Jugador;

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
public class JugadorTest extends SpringTest {

	@Test
	@Transactional
	@Rollback
	public void jugadorCanBeInserted() {
		// SE INICIA LA SESSION DE SPRING PARA HACER DML Y QUERY
		Session session = getSession();

		// INSERT DATA ZONE
		Jugador jugador = new Jugador();
		jugador.setNombre("pepito");

		session.save(jugador);

		// SE QUEREA CON EL METODO .GET(NOMBRECLASE.CLASS, REGISTRO.GETID())
		Jugador jugadorRetrieved = session.get(Jugador.class, jugador.getId());

		assertThat(jugadorRetrieved).isNotNull();
	}

	@Test
	@Transactional
	@Rollback
	public void jugadorCanBeUpdated() {
		Session session = getSession();
		Jugador jugador = new Jugador();
		jugador.setNombre("pepito");

		session.save(jugador);
		Jugador jugadorRetrieved = session.get(Jugador.class, jugador.getId());

		assertThat(jugadorRetrieved).isNotNull();

		jugador.setNombre("Carlos");
		session.update(jugador);
		jugadorRetrieved = session.get(Jugador.class, jugador.getId());

		assertThat(jugadorRetrieved.getNombre()).isEqualTo("Carlos");
	}

	@Test
	@Transactional
	@Rollback
	public void jugadorCanBeDeleted() {
		Session session = getSession();
		Jugador jugador = new Jugador();
		jugador.setNombre("pepito");

		session.save(jugador);
		Jugador jugadorRetrieved = session.get(Jugador.class, jugador.getId());

		assertThat(jugadorRetrieved).isNotNull();

		session.delete(jugador);

		jugadorRetrieved = session.get(Jugador.class, jugador.getId());

		assertThat(jugadorRetrieved).isNull();

	}

	@Test
	@Transactional
	@Rollback
	public void jugadoresCanBeInserted() {
		Session session = getSession();

		List<Jugador> jugadores = new LinkedList<Jugador>();

		jugadores.add(new Jugador("Riquelme"));
		jugadores.add(new Jugador("Palermo"));
		jugadores.add(new Jugador("ELPIPA"));

		for (Jugador jugador : jugadores) {
			session.save(jugador);
		}

		List<Jugador> jugadoresRetrieved = new LinkedList<Jugador>();
		assertThat(jugadoresRetrieved).isEmpty();

		for (Jugador jugador : jugadores) {
			jugadoresRetrieved.add(session.get(Jugador.class, jugador.getId()));
		}

		assertThat(jugadoresRetrieved).isNotEmpty();

	}
	
	@Test
	@Transactional
	@Rollback
	public void elClubDelJugadorPuedeSerRecuperado() {
		Session session = getSession();
		
		Equipo boca = new Equipo("BOCA",5);
		session.save(boca);
		
		Equipo jorge = new Equipo("JORGE",1);
		session.save(jorge);
		
		List<Jugador> jugadores = new LinkedList<Jugador>();

		jugadores.add(new Jugador("Riquelme", boca));
		jugadores.add(new Jugador("Palermo", boca));
		jugadores.add(new Jugador("ELPIPA", boca));
		
		jugadores.add(new Jugador("ELPOCHI", jorge));

		for (Jugador jugador : jugadores) {
			session.save(jugador);
		}

		List<Jugador> jugadoresRetrieved = new LinkedList<Jugador>();
		assertThat(jugadoresRetrieved).isEmpty();

		for (Jugador jugador : jugadores) {
			jugadoresRetrieved.add(session.get(Jugador.class, jugador.getId()));
		}
		
		assertThat(jugadoresRetrieved.size()).isEqualByComparingTo(4);
		
		List<Jugador> jugadoresDeBoca = new LinkedList<Jugador>();
		for(Jugador jugadorRetrieved : jugadoresRetrieved) {
			
			if(jugadorRetrieved.getEquipo().getNombre() == "BOCA") {
				jugadoresDeBoca.add(jugadorRetrieved);
			}
		}
		
		assertThat(jugadoresDeBoca.size()).isEqualByComparingTo(3);

	}

}
