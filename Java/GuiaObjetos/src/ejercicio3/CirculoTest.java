package ejercicio3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CirculoTest {
	@Test
	void AreaUnitaria() {
		Circulo c = new Circulo(1);
		double areaObtenida = c.obtenerArea();
		double areaEsperada = 3.14159;
		
		// Tolerancia de 5 decimales <--- ES ERROR
		//assertEquals(areaEsperada, areaObtenida, 0.000001);
		
		// Tolerancia de 4 decimales <--- ES OK
		assertEquals(areaEsperada, areaObtenida, 0.00001);
	}
	
	@Test 
	void ObtenerArea() {
		double radio = 3;
		Circulo c1 = new Circulo(radio);
		double areaEsperada = Math.PI * radio * radio;
		double areaObtenida = c1.obtenerArea();
		
		assertEquals(areaEsperada, areaObtenida);
	}
	
	@Test
	void ObtenerPerimetro() {
		double radio = 3;
		Circulo c1 = new Circulo(radio);
		double perimetroEsperado = 2 * Math.PI * radio;
		double perimetroObtenido = c1.obtenerPerimetro();
		
		assertEquals(perimetroEsperado, perimetroObtenido);
	}
	
	@Test
	void CompararDosCirculosIguales() {
		double radio1 = 3;
		Circulo c1 = new Circulo(radio1);
		Circulo c2 = new Circulo(radio1);
		
		Boolean esperado = true;
		Boolean obtenido  = c1.equals(c2);
		
		assertEquals(esperado,obtenido);
		assertTrue(obtenido);
		
	}
	
	@Test
	void CompararDosCirculosDistintos() {
		double radio1 = 3;
		double radio2 = 5;
		Circulo c1 = new Circulo(radio1);
		Circulo c2 = new Circulo(radio2);
		
		Boolean esperado = false;
		Boolean obtenido  = c1.equals(c2);
		
		assertEquals(esperado,obtenido);
		assertFalse(obtenido);
	}
}