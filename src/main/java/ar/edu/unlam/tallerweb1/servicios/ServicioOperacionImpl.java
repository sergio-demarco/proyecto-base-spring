package ar.edu.unlam.tallerweb1.servicios;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Operacion;

@Service("servicioLogin")
@Transactional
public class ServicioOperacionImpl implements ServicioOperacion {

	@Override
	public Operacion consultarOperacion (Operacion operacion) {
		
		String nombreOperacion = operacion.getNombre();
		String cadena=operacion.getCadena();
		String resultadoCadena= aplicarOperacion(nombreOperacion,cadena);
		operacion.setCadenaResultado(resultadoCadena);
		return operacion;	
	}
	
	private String aplicarOperacion(String nombreOperacion,String cadena) {
		String resultadoCadena = null;
		if(nombreOperacion=="pasarAMayuscula"){resultadoCadena=pasarAMayuscula(cadena);}
		if(nombreOperacion=="pasarAMiniscula"){resultadoCadena=pasarAMiniscula(cadena);}
		if(nombreOperacion=="invertirOrden"){resultadoCadena=invertirOrden(cadena);}
		if(nombreOperacion=="cantidadDeCaracteres"){resultadoCadena=String.valueOf(cantidadDeCaracteres(cadena));}
		return resultadoCadena;
	}
	private String pasarAMayuscula (String cadena) {
		return cadena.toUpperCase();
	}
	private String pasarAMiniscula (String cadena) {
		return cadena.toLowerCase();
	}
	private String invertirOrden (String cadena) {
		String cadenaInvertida="";
		for (int i = cadena.length()-1; i>=0; i--){
			cadenaInvertida += cadena.charAt(i);
        }
		return cadenaInvertida;
	}
	private int cantidadDeCaracteres (String cadena) {
		return cadena.length();
	}

}
