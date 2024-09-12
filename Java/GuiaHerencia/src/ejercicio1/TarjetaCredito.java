package ejercicio1;

import java.security.InvalidParameterException;

public class TarjetaCredito {
	private Cuenta cuenta;
	private double totalComprado;
	final double limite;
	public static final int COMISION = 3;
	
	public TarjetaCredito(Cuenta cuenta, double limite) {
		if(limite <= 0)
			throw new InvalidParameterException("Límite debe ser positivo.");
		
		this.cuenta = cuenta;
		this.limite = limite;
		this.totalComprado = 0;
	}
	
	public double comprar(double monto) {
		if(totalComprado + monto > limite)
			throw new RuntimeException("Límite insuficiente.");
		
		this.totalComprado += monto;
		
		return this.totalComprado;
	}

	public double debitar() {
		return cuenta.retirar(totalComprado * COMISION / 100);
	}
	
	public double consultarTotalComprado() {
		return totalComprado;
	}
	
	public double consultarTotalCompradoConComision() {
		return totalComprado * 3 / 100;
	}
}
