package lenguaje.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lenguaje.Rango;

class Metodos {

	@Test
	void creacionRango() {
		double inicio = 3.0;
		double fin = 3.1;
		boolean incluido = false;
		
		Rango rango = new Rango(inicio, incluido, fin, incluido);
		
		assertNotNull(rango);
	}
	
	@Test 
	void dosRangosIguales(){
		double inicio = 3.0;
		double fin = 4.0;
		
		Rango rango1 = Rango.rangoAbierto(inicio, fin);
		Rango rango2 = Rango.rangoAbierto(inicio, fin);
 		
		assertTrue(rango1.equals(rango2));
		assertTrue(rango2.equals(rango1));
	}
	
	@Test 
	void creacionRangoAbierto(){
		double inicio = 3.0;
		double fin = 4.0;
		boolean incluido = false;
		
		Rango rango = Rango.rangoAbierto(inicio, fin);
		
		Rango esperado = new Rango(inicio, incluido, fin, incluido);
		
		assertEquals(esperado, rango);
	}
	
	@Test
	void creacionRangoCerrado() {
		double inicio = 3.0;
		double fin = 4.0;
		boolean incluido = true;
		
		Rango rango = Rango.rangoCerrado(inicio, fin);
		
		Rango esperado = new Rango(inicio, incluido, fin, incluido);
		
		assertEquals(esperado, rango);
	}
	
	@Test 
	void valorDentroDelRango() {
		double inicio = 1.0;
		double fin = 5.0;
		double valor = 3.0;
		
		Rango rango1 = Rango.rangoAbierto(inicio, fin);
		Rango rango2 = Rango.rangoCerrado(inicio, fin);
				
		assertTrue(rango1.estaDentroDelRango(valor));
		assertTrue(rango2.estaDentroDelRango(valor));
	}

	@Test 
	void valorFueraDelRango() {
		double inicio = 1.0;
		double fin = 2.0;
		double valor = 3.0;
		
		Rango rango1 = Rango.rangoAbierto(inicio, fin);
		Rango rango2 = Rango.rangoCerrado(inicio, fin);
				
		assertFalse(rango1.estaDentroDelRango(valor));
		assertFalse(rango2.estaDentroDelRango(valor));
	}
	
	@Test 
	void valoresEnBordesDeRangoCerrado() {
		double inicio = 1.0;
		double fin = 2.0;
		double valor1 = 1.0;
		double valor2 = 2.0;
		
		Rango rango = Rango.rangoCerrado(inicio, fin);
				
		assertTrue(rango.estaDentroDelRango(valor1));
		assertTrue(rango.estaDentroDelRango(valor2));
	}
	
	@Test 
	void valoresEnBordesDeRangoAbierto() {
		double inicio = 1.0;
		double fin = 2.0;
		double valor1 = 1.0;
		double valor2 = 2.0;
		
		Rango rango = Rango.rangoAbierto(inicio, fin);
		
		assertFalse(rango.estaDentroDelRango(valor1));
		assertFalse(rango.estaDentroDelRango(valor2));
	}
	
	@Test
	void rangoNoIncluidoDentroDeOtroRangoIncluido() {
		double inicio1 = 1.0;
		double fin1 = 4.0;
		double inicio2 = 1.0;
		double fin2 = 4.0;
		
		Rango rango1 = Rango.rangoCerrado(inicio1, fin1);
		Rango rango2 = Rango.rangoAbierto(inicio2, fin2);
	
		assertTrue(rango1.estaDentroDelRango(rango2));
	}
	
	@Test
	void rangoIncluidoDentroDeOtroRangoNoIncluido() {
		double inicio1 = 1.0;
		double fin1 = 4.0;
		double inicio2 = 1.0;
		double fin2 = 3.0;
		
		Rango rango1 = Rango.rangoAbierto(inicio1, fin1);
		Rango rango2 = Rango.rangoCerrado(inicio2, fin2);
	
		assertFalse(rango1.estaDentroDelRango(rango2));
	}
	
	@Test
	void interseccionEntreRangos() {
		double inicio1 = 1.0;
		double fin1 = 4.0;
		double inicio2 = 1.0;
		double fin2 = 3.0;

		Rango rango1 = Rango.rangoAbierto(inicio1, fin1);
		Rango rango2 = Rango.rangoAbierto(inicio2, fin2);
		
		assertTrue(rango1.hayInterseccion(rango2));
		assertTrue(rango2.hayInterseccion(rango1));
	}
	
	@Test
	void interseccionEntreRangosCerradosEnLosBordes() {
		double inicio1 = 1.0;
		double fin1 = 4.0;
		double inicio2 = 4.0;
		double fin2 = 5.0;

		Rango rango1 = Rango.rangoCerrado(inicio1, fin1);
		Rango rango2 = Rango.rangoCerrado(inicio2, fin2);
		
		assertTrue(rango1.hayInterseccion(rango2));
	}
	
	@Test
	void interseccionEntreRangosAbiertosEnLosBordes() {
		double inicio1 = 1.0;
		double fin1 = 4.0;
		double inicio2 = 4.0;
		double fin2 = 5.0;

		Rango rango1 = Rango.rangoAbierto(inicio1, fin1);
		Rango rango2 = Rango.rangoAbierto(inicio2, fin2);
		
		assertFalse(rango1.hayInterseccion(rango2));
	}
	
	@Test 
	void rangoInfinito(){
		Rango rango = Rango.rangoInfinito();
		Rango esperado = Rango.rangoAbierto(Double.MIN_VALUE, Double.MAX_VALUE);
		
		assertEquals(esperado, rango);
	}
	
	@Test
	void sumarDosRangos() {
		double inicio1 = 1.0;
		double fin1 = 2.0;
		double inicio2 = 3.0;
		double fin2 = 4.0;
		boolean incluido = true;

		Rango rango1 = new Rango(inicio1, incluido, fin1, incluido);
		Rango rango2 = new Rango(inicio2, incluido, fin2, incluido);
		
		Rango esperado = new Rango(inicio1, incluido, fin2, incluido);
		
		assertEquals(esperado, rango1.sumar(rango2));
	}
	
	@Test
	void rangoInterseccion() {
		double inicio1 = 1.0;
		double fin1 = 3.0;
		double inicio2 = 2.0;
		double fin2 = 4.0;

		Rango rango1 = new Rango(inicio1, true, fin1, true);
		Rango rango2 = new Rango(inicio2, true, fin2, true);
		
		Rango esperado = new Rango(inicio2, true, fin1, true);
		
		assertEquals(esperado, rango1.rangoInterseccion(rango2));
	}
	
	@Test
	void desplazarRangoConEscalar() {
		double inicio = 1.0;
		double fin = 2.0;
		Rango rango = Rango.rangoAbierto(inicio, fin);
		
		double escalar = 3.0;

		double inicioEsperado = inicio + escalar;
		double finEsperado = fin + escalar;
		Rango esperado = Rango.rangoAbierto(inicioEsperado, finEsperado);
		
		assertEquals(esperado, rango.desplazar(escalar));
	}
}
