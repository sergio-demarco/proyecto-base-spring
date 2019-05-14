package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Operacion;

@Service("servicioLogin")
@Transactional
public class ServicioOperacionImpl implements ServicioOperacion {

	@Override
	public Operacion consultarOperacion (Operacion operacion) {
		
		int valor1= operacion.getValor1();
		int valor2= operacion.getValor2();
		String operador=operacion.getOperador();
		int resultado=0;
		if(operador=="suma"){resultado=valor1+valor2;}
		if(operador=="resta"){resultado=valor1-valor2;}
		if(operador=="division"){resultado=valor1/valor2;}
		if(operador=="multiplicacion"){resultado=valor1*valor2;}
		operacion.setResultado(Integer.toString(resultado));
		return operacion;
	}

}
