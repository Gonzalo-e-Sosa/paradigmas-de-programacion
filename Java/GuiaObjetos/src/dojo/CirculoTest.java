package dojo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ejercicio2.Punto;

class CirculoTest {
	
	@Test 
	void distanciaAsiMismo() {
		Punto p = new Punto(1, 1);
		Circulo c = new Circulo(p, 1);
		
		double esperado = p.distanciaAotroPunto(p);
		
		assertEquals(esperado, c.distanciaCon(c));
	}
	
	@Test
	void distanciaAotroCirculo() {
		Punto p1, p2;
		Circulo c1, c2;
		p1 = new Punto(10, 1);
		p2 = new Punto(20, 1);
		c1 = new Circulo(p1, 5.00);
		c2 = new Circulo(p2, 5.00);
		
		double esperado = p1.distanciaAotroPunto(p2);
		
		assertEquals(esperado, c1.distanciaCon(c2));
		assertEquals(esperado, c2.distanciaCon(c1));
	}
	
	@Test 
	void intersectaConsigoMismo() {
		Circulo c = new Circulo(new Punto(1, 1), 1);
		
		assertTrue(c.intersectaCon(c));
	}
	
	@Test 
	void intersectaConOtroCirculo() {
		Punto p1, p2;
		Circulo c1, c2;
		p1 = new Punto(10, 1);
		p2 = new Punto(20, 1);
		c1 = new Circulo(p1, 5.00);
		c2 = new Circulo(p2, 5.00);
		
		assertTrue(c1.intersectaCon(c2));
		assertTrue(c2.intersectaCon(c1));
	}
	
	@Test
	void noIntersectaConOtroCirculo() {
		Punto p1, p2;
		Circulo c1, c2;
		p1 = new Punto(10, 1);
		p2 = new Punto(30, 1);
		c1 = new Circulo(p1, 5.00);
		c2 = new Circulo(p2, 5.00);
		
		assertFalse(c1.intersectaCon(c2));
		assertFalse(c2.intersectaCon(c1));
	}
}
