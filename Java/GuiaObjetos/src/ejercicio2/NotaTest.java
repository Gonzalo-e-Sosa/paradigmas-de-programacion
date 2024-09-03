package ejercicio1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NotaTest {
	@Test 
	void CrearNota() {
		Nota nota;
		try {
			nota = new Nota(4);
			
			assertNotNull(nota);
			assertEquals(4, nota.obtenerValor());
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void NotaAprobada() {
	    Nota nota;
		try {
			nota = new Nota(7);

			assertTrue(nota.aprobada());
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	public void NotaDesaprobada() {
		Nota nota;
		try {
			nota = new Nota(2);

			assertTrue(nota.desaprobada());
		} catch (Exception e) {
			fail(e.toString());
		}
	}
	
	@Test
	void NuevoValorMenorAValorActual() {
		int valorActual;
		int nuevoValor = 7;
		int valorEsperado;
		
		valorActual = valorEsperado = 10;
		
		Nota nota = null; 
		try {
			nota = new Nota(valorActual);			
			nota.recuperar(nuevoValor);
			
			assertEquals(valorEsperado, nota.obtenerValor());
		} catch (Exception e) {
			nota = new Nota();
			assertEquals(0, nota.obtenerValor());
		}
	}
	
	@Test
	void NuevoValorMayorAValorActual() {
		int valorActual = 7;
		int nuevoValor; 
		int valorEsperado;
		
		nuevoValor = valorEsperado = 10;
		
		Nota nota = null; 
		try {
			nota = new Nota(valorActual);			
			nota.recuperar(nuevoValor);
			
			assertEquals(valorEsperado, nota.obtenerValor());
		} catch (Exception e) {
			nota = new Nota();
			assertEquals(0, nota.obtenerValor());
		}
	}
	
	@Test 
	void NuevoValorMenorACero(){
		int valorActual; 
		int nuevoValor = -1;
		int valorEsperado;
		
		valorActual = valorEsperado = 0;
		
		Nota nota = null; 
		try {
			nota = new Nota(valorActual);
			nota.recuperar(nuevoValor);
			
			assertEquals(valorEsperado, nota.obtenerValor());
		} catch (Exception e) {
			nota = new Nota();
			assertEquals(0, nota.obtenerValor());
		}
		
	}
	
	@Test 
	void NuevoValorMayorADiez() {		
		int valorActual; 
		int nuevoValor = 11;
		int valorEsperado;
		
		valorActual = valorEsperado = 10;
		
		Nota nota = null; 
		try {
			nota = new Nota(valorActual);
			nota.recuperar(nuevoValor);
			
			assertEquals(valorEsperado, nota.obtenerValor());
		} catch (Exception e) {
			nota = new Nota();
			assertEquals(0, nota.obtenerValor());
		}
	}
}
