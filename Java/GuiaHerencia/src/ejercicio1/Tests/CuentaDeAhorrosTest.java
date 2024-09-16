package ejercicio1.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import ejercicio1.CuentaDeAhorros;

class CuentaDeAhorrosTest {

	@Test
	void ahorroMayorAsaldo() {
		double saldo, ahorro;
		saldo = 10;
		ahorro = 20;
		
		assertThrows(
				InvalidParameterException.class, 
				() -> new CuentaDeAhorros(saldo, ahorro)
		);
	}
	
	@Test
	void ahorroIgualAcero() {
		double saldo, ahorro;
		saldo = 10;
		ahorro = 0;
		
		CuentaDeAhorros c = new CuentaDeAhorros(saldo, ahorro);
		
		assertEquals(ahorro, c.consultarAhorro());
	}
	
	@Test
	void reservarMontoNegativo() {
		double saldo, ahorro;
		ahorro = saldo = 10;
		CuentaDeAhorros c = new CuentaDeAhorros(saldo, ahorro);
		
		assertThrows(
				InvalidParameterException.class, 
				() -> c.reservar(-100d)
		);
		
		assertEquals(ahorro, c.consultarAhorro());
		assertEquals(saldo, c.obtenerSaldo());
	}
	
	@Test
	void reservarMontoIgualAcero() {
		double saldo, ahorro;
		ahorro = saldo = 10;
		CuentaDeAhorros c = new CuentaDeAhorros(saldo, ahorro);
		
		assertThrows(
				InvalidParameterException.class, 
				() -> c.reservar(0d)
		);
		
		assertEquals(ahorro, c.consultarAhorro());
		assertEquals(saldo, c.obtenerSaldo());
	}
	
	@Test
	void reservarMontoValido() {
		double saldo, ahorro;
		ahorro = saldo = 10;
		CuentaDeAhorros c = new CuentaDeAhorros(saldo, ahorro);
		
		assertTrue(c.reservar(ahorro));
		assertEquals(ahorro * 2, c.consultarAhorro());
		assertEquals(saldo - ahorro, c.obtenerSaldo());
	}
	
	@Test
	void reintegrarMontoNegativo() {
		double saldo, ahorro;
		ahorro = saldo = 10;
		CuentaDeAhorros c = new CuentaDeAhorros(saldo, ahorro);
		
		assertThrows(
				InvalidParameterException.class, 
				() -> c.reintegrar(-100d)
		);
		
		assertEquals(ahorro, c.consultarAhorro());
		assertEquals(saldo, c.obtenerSaldo());
	}
	
	@Test
	void reintegrarMontoIgualAcero() {
		double saldo, ahorro;
		ahorro = saldo = 10;
		CuentaDeAhorros c = new CuentaDeAhorros(saldo, ahorro);
		
		assertThrows(
				InvalidParameterException.class, 
				() -> c.reintegrar(0)
		);
		
		assertEquals(ahorro, c.consultarAhorro());
		assertEquals(saldo, c.obtenerSaldo());
	}
	
	@Test
	void reintegrarMontoValido() {
		double saldo, ahorro, saldoEsperado, ahorroEsperado;
		ahorro = saldo = 10;
		saldoEsperado = ahorro + saldo;
		ahorroEsperado = 0;
		CuentaDeAhorros c = new CuentaDeAhorros(saldo, ahorro);
		
		assertTrue(c.reservar(ahorro));
		assertTrue(c.reintegrar());
		assertEquals(ahorroEsperado, c.consultarAhorro());
		assertEquals(saldoEsperado, c.obtenerSaldo());
	}
}
