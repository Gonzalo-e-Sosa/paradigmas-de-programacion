package ejercicio1;

import java.security.InvalidParameterException;

public class CuentaCorriente extends Cuenta {
	private double extra;
	
	public CuentaCorriente(double saldo) {
		super(saldo);
		this.extra = 0;
	}
	
	public CuentaCorriente(double saldo, double extra) {
		super(saldo);
		this.extra = extra;
	}

	@Override
	public double retirar(double monto) {
		if(monto <= 0)
			throw new InvalidParameterException("Monto debe ser positivo.");
		
		double saldo = obtenerSaldo();
		
		if(saldo < monto) {
			if(saldo + extra < monto)
				throw new RuntimeException("Saldo insuficiente.");
			
			retirar(saldo);
			this.extra = monto - saldo;
			
			return saldo;
		}
		
		retirar(monto);
		
		return saldo;
	}

	
	public double consultarExtra() {
		return extra;
	}
}
