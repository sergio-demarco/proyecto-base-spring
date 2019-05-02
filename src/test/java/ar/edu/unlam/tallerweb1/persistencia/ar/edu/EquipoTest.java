package ar.edu.unlam.tallerweb1.persistencia.ar.edu;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Equipo;
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

import javax.management.Query;

//REQUERIDO PARA HACER DML
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class EquipoTest extends SpringTest{
	
	@Test
	@Transactional
	@Rollback
	public void todosLosEquiposQueGanaronMasDe3Campeonatos() {

		Session session = getSession();
		
		Equipo boca = new Equipo("Boca",6);
		session.save(boca);
		
		Equipo riber = new Equipo("Riber",4);
		session.save(riber);
		
		Equipo sanLorenzo = new Equipo("San Lorenzo", 1);
		session.save(sanLorenzo);
		
		List<Equipo> result = 
				(List<Equipo>) session.createCriteria(Equipo.class)
				.add(Restrictions.gt("cantidadDeCampeonatos", 3)).list();
		
		assertThat(result.size()).isEqualByComparingTo(2);
	}
	
	@Test
	@Transactional
	@Rollback
	public void todosLosJugadoresDeBoca() {

		Session session = getSession();
		
		Equipo boca = new Equipo("Boca",6);
		session.save(boca);
		
		Jugador pavon = new Jugador("Pavon", boca);
		session.save(pavon);
		
		Jugador zarate = new Jugador("Zarate", boca);
		session.save(zarate);
		
		Jugador tevez = new Jugador("Teve$", boca);
		session.save(tevez);
		
		List<Jugador> result = 
				(List<Jugador>) session.createCriteria(Jugador.class)
				.add(Restrictions.eq("equipo", boca)).list();
		
		assertThat(result.size()).isEqualByComparingTo(3);
	}
	
	@Test
	@Transactional
	@Rollback
	public void todosLosJugadoresDeEquiposQueGanaronMasDe3Campeonatos() {

		Session session = getSession();
		
		Equipo sanLorenzo = new Equipo("San Lorenzo",1);
		session.save(sanLorenzo);
		
		Jugador blandi = new Jugador("Blandi", sanLorenzo);
		session.save(blandi);
		
		Equipo boca = new Equipo("Boca",6);
		session.save(boca);
		
		Jugador pavon = new Jugador("Pavon", boca);
		session.save(pavon);
		
		Jugador zarate = new Jugador("Zarate", boca);
		session.save(zarate);
		
		Jugador tevez = new Jugador("Teve$", boca);
		session.save(tevez);
		
		List<Jugador> result = 
				(List<Jugador>) session.createCriteria(Jugador.class)
				.createAlias("equipo","e")
				.add(Restrictions.gt("e.cantidadDeCampeonatos", 3)).list();
		
		assertThat(result.size()).isEqualByComparingTo(3);
	}
}
