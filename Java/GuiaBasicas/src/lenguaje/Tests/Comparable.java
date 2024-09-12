package lenguaje.Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lenguaje.Rango;

class Comparable {

	@Test
	void rules() {
		Rango uno = Rango.rangoAbierto(0, 1);
		Rango dos = Rango.rangoAbierto(0, 1);
		Rango tres = Rango.rangoAbierto(1, 2);

		assertTrue(uno.compareTo(dos) == 0);
		assertTrue(uno.compareTo(tres) < 0);
		assertTrue(tres.compareTo(uno) > 0);
	}

}
