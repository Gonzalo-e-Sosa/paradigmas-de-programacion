package ejercicio6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CerraduraTest {

	@Test
	void CreacionCerradura() {
		Cerradura cerradura = new Cerradura(123, 3);
		
		assertNotNull(cerradura);
	}
	
	@Test
	void ClaveCorrecta() {
		int clave = 123;
		Cerradura cerradura = new Cerradura(clave, 3);
		
		assertTrue(cerradura.abrir(clave));
		assertTrue(cerradura.estaAbierta());
		assertFalse(cerradura.estaCerrada());
	}
	
	@Test
	void ClaveIncorrecta() {
		int clave1 = 123;
		int clave2 = 321;
		Cerradura cerradura = new Cerradura(clave1, 3);
		
		assertFalse(cerradura.abrir(clave2));
		assertTrue(cerradura.estaCerrada());
		assertFalse(cerradura.estaAbierta());
	}
	
	@Test
	void ExistenFallosConsecutivos() {
		int clave1 = 123;
		int clave2 = 321;
		int cantidadDeFallos = 2;
		Cerradura cerradura = new Cerradura(clave1, cantidadDeFallos);
		
		assertFalse(cerradura.abrir(clave2));
		assertFalse(cerradura.abrir(clave2));
		
		assertEquals(2, cerradura.contarAperturasFallidas());
		assertEquals(0, cerradura.contarAperturasExitosas());
		
		assertTrue(cerradura.fueBloqueada());
	}
}
