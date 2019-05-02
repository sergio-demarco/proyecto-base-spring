package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.ar.edu.unlam.tallerweb1.modelo.Objeto;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

import org.hibernate.Session;

public class ObjetoTest extends SpringTest {

	@Test
	@Transactional
	@Rollback(true)
	public void objectCanBeInserted() {
		// obtenemos la session de hibernate para poder hacer el DML
		Session session = getSession();

		Objeto objeto = new Objeto();
		objeto.setInteger(2);
		objeto.setString("b");

		session.save(objeto);

		Objeto objectRetrieved = session.get(Objeto.class, objeto.getId());

		assertThat(objectRetrieved).isNotNull();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void objectCanBeDeleted() {
		// obtenemos la session de hibernate para poder hacer el DML
		Session session = getSession();

		Objeto objeto = new Objeto();
		objeto.setInteger(2);
		objeto.setString("b");

		session.save(objeto);

		Objeto objectRetrieved = session.get(Objeto.class, objeto.getId());

		assertThat(objectRetrieved).isNotNull();

		session.delete(objeto);

		objectRetrieved = session.get(Objeto.class, objeto.getId());

		assertThat(objectRetrieved).isNull();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void objectCanBeUpdated() {
		// obtenemos la session de hibernate para poder hacer el DML
		Session session = getSession();

		int initIntValue = 1;
		String initStringValue = "b";

		Objeto objeto = new Objeto();
		objeto.setInteger(initIntValue);
		objeto.setString(initStringValue);

		session.save(objeto);

		Objeto objectRetrieved = session.get(Objeto.class, objeto.getId());

		assertThat(objectRetrieved).isNotNull();
		assertThat(objectRetrieved.getInteger()).isEqualTo(initIntValue);
		assertThat(objectRetrieved.getString()).isEqualTo(initStringValue);

		objeto.setInteger(3);
		objeto.setString("c");
		session.update(objeto);

		objectRetrieved = session.get(Objeto.class, objeto.getId());

		assertThat(objectRetrieved.getInteger()).isNotEqualTo(initIntValue);
		assertThat(objectRetrieved.getString()).isNotEqualTo(initStringValue);
	}
}
