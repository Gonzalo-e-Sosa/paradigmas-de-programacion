package ejercicio1;

import java.security.InvalidParameterException;

public class CuentaDeAhorros extends Cuenta {
	private double ahorro;
	
	public CuentaDeAhorros(double saldo) {
		super(saldo);
		this.ahorro = 0;
	}
	
	public CuentaDeAhorros(double saldo, double ahorro) {
		super(saldo);

		if(saldo < ahorro)
			throw new InvalidParameterException("Saldo debe ser mayor o igual a ahorro.");
		
		this.ahorro = ahorro;
	}
	
	public boolean reservar(double monto) {
		if(monto <= 0)
			throw new InvalidParameterException("Monto debe ser positivo.");
		
		try {
			super.retirar(monto);
			this.ahorro += monto;
			
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			
			return false;
		}
		
	}
	
	public double consultarAhorro() {
		return ahorro;
	}
}
