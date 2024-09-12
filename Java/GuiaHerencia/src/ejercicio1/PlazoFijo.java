package ejercicio1;

import java.security.InvalidParameterException;

public class PlazoFijo {
	private Cuenta cuenta;
	private double monto;
	private int cantMeses;
	public static int INTERES_ANUAL = 36;
	
	public PlazoFijo(Cuenta cuenta, double monto) {
		this(cuenta, monto, 1);
	}
	
	public PlazoFijo(Cuenta cuenta, double monto, int cantMeses) {
		if(monto <= 0)
			throw new InvalidParameterException("Monto debe ser positivo.");
		
		if(cantMeses <= 0 || cantMeses > 12)
			throw new InvalidParameterException("Cant. de meses debe estar comprendido de 1 a 12.");
		
		this.cuenta = cuenta;
		this.monto = monto;
		this.cantMeses = cantMeses;
	}

	public double acreditar() {
		return cuenta.acreditar(monto * INTERES_ANUAL / (12 - cantMeses));
	}
}
