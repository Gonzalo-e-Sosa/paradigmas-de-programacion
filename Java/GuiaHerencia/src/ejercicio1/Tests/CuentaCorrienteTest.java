package ejercicio1.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

import ejercicio1.CuentaCorriente;

class CuentaCorrienteTest {

	@Test
	void porcentajeExtraNegativo() {
		assertThrows(
				InvalidParameterException.class, 
				() -> new CuentaCorriente(100, -100d)
		);
	}

	@Test 
	void porcentajeExtraIgualAuno() {
		CuentaCorriente c = new CuentaCorriente(100, 1);
		double esperado = 1;
		
	    assertEquals(esperado, c.consultarPorcentajeExtra());
	}
	
	@Test
	void porcentajeExtraValido() {
		double esperado, porcentajeExtra = 1;
		CuentaCorriente c = new CuentaCorriente(100, porcentajeExtra);
		esperado = porcentajeExtra;
		
	    assertEquals(esperado, c.consultarPorcentajeExtra());
	}
	
	@Test
	void transferirMontoIgualAcero() {
		CuentaCorriente c1 = new CuentaCorriente(10, 1);
		CuentaCorriente c2 = new CuentaCorriente(10);
		
		assertFalse(c1.transferir(0, c2));
		assertEquals(10, c1.obtenerSaldo());
		assertEquals(10, c2.obtenerSaldo());
	}

	@Test
	void transferirMontoMayorAporcentajeExtra() {
		CuentaCorriente c1 = new CuentaCorriente(0, 1.50);
		CuentaCorriente c2 = new CuentaCorriente(0);
		
		assertFalse(c1.transferir(100, c2));
		assertEquals(0, c1.obtenerSaldo());
		assertEquals(0, c2.obtenerSaldo());
	}
	
	@Test
	void transferirMontoMenorAporcentajeExtra() {
		double saldo1, saldo2, porcentajeExtra, monto;
		saldo1 = 20;
		saldo2 = 20;
		porcentajeExtra = 1.50;
		monto = 30;
		CuentaCorriente c1 = new CuentaCorriente(saldo1, porcentajeExtra);
		CuentaCorriente c2 = new CuentaCorriente(saldo2);
		
		double saldoEsperado1 = 0;
		double deudaEsperada = monto - saldo1;
		double saldoEsperado2 = saldo2 + monto;
		
		assertTrue(c1.transferir(monto, c2));
		assertEquals(saldoEsperado1, c1.obtenerSaldo());
		assertEquals(deudaEsperada, c1.consultarDeuda());
		assertEquals(saldoEsperado2, c2.obtenerSaldo());
	}
}
