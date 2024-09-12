package ejercicio1;

import java.security.InvalidParameterException;

public class Cuenta {
	private double saldo = 0;
	
	public Cuenta(double saldo) {
		if(saldo <= 0)
			throw new InvalidParameterException("Saldo debe ser positivo.");
	
		this.saldo = saldo;
	}
	
	public double obtenerSaldo() {
		return saldo;
	}
	
	protected double acreditar(double monto) {
		if(monto <= 0)
			throw new InvalidParameterException("Monto debe ser positivo.");
		
		this.saldo += monto;
		
		return this.saldo;
	}
	
	protected double retirar(double monto) {
		if(monto <= 0)
			throw new InvalidParameterException("Monto debe ser positivo.");
		
		if(saldo < monto)
			throw new RuntimeException("Saldo insuficiente.");
		
		this.saldo -= monto;
		
		return this.saldo;
	}

	public boolean depositar(double monto) {
		try {
			acreditar(monto);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			
			return false;
		}
	}
	
	public boolean transferir(double monto, Cuenta destino) {
		try {
			retirar(monto);
			destino.depositar(monto);
			
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			
			return false;
		}
	}
}
