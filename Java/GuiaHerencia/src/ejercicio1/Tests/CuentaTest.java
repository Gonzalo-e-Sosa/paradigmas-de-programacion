package ejercicio1.Tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import ejercicio1.Cuenta;

class CuentaTest {

	@Test
	void cuentaConSaldoNegativo() {
	
		assertThrows(
				InvalidParameterException.class, 
				() -> new Cuenta(-100d)
		);
	}
	
	@Test 
	void cuentaConSaldoCero() {
		Cuenta c = new Cuenta();
		double esperado = 0;
		
		assertEquals(esperado, c.obtenerSaldo());
	}
	
	@Test
	void cuentaConSaldo() {
		double esperado, monto;
		esperado = monto = 10;
		Cuenta c = new Cuenta(monto);
		
		assertEquals(esperado, c.obtenerSaldo());
	}
	
	@Test 
	void depositarMontoNegativo() {
		Cuenta c = new Cuenta(10);
		double monto = -100d;
		
		assertFalse(c.depositar(monto));
		assertEquals(10, c.obtenerSaldo());
	}
	
	@Test 
	void depositarMontoIgualAcero() {
		Cuenta c = new Cuenta(100);
		double monto = 0;
		
		assertFalse(c.depositar(monto));
		assertEquals(100, c.obtenerSaldo());
	}
	
	@Test 
	void depositarMonto() {
		double esperado, monto;
		Cuenta c = new Cuenta();
		esperado = monto = 10;
		
		assertTrue(c.depositar(monto));
		assertEquals(esperado, c.obtenerSaldo());
	}
	
	@Test
	void transferirMontoNegativo() {
		Cuenta c1 = new Cuenta(100);
		Cuenta c2 = new Cuenta();
		double monto = -100d;
		
		assertFalse(c1.transferir(monto, c2));
		assertEquals(100, c1.obtenerSaldo());
		assertEquals(0, c2.obtenerSaldo());
	}
	
	@Test
	void transferirMontoIgualAcero() {
		Cuenta c1 = new Cuenta(100);
		Cuenta c2 = new Cuenta();
		double monto = 0;
		
		assertFalse(c1.transferir(monto, c2));
		assertEquals(100, c1.obtenerSaldo());
		assertEquals(0, c2.obtenerSaldo());
	}
	
	@Test 
	void transferirMontoConSaldoInsuficiente() {
		Cuenta c1 = new Cuenta(10);
		Cuenta c2 = new Cuenta();
		double monto = 100;
		
		assertFalse(c1.transferir(monto, c2));
		assertEquals(10, c1.obtenerSaldo());
		assertEquals(0, c2.obtenerSaldo());
	}
	
	@Test
	void transferirMonto() {
		Cuenta c1 = new Cuenta(100);
		Cuenta c2 = new Cuenta();
		double monto = 100;
		
		assertTrue(c1.transferir(monto, c2));
		assertEquals(0, c1.obtenerSaldo());
		assertEquals(100, c2.obtenerSaldo());
	}
}
