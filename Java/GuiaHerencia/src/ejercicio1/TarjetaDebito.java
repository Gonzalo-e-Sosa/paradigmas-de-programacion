package ejercicio1;

public class TarjetaDebito {
	Cuenta cuenta;
	
	public TarjetaDebito(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public double comprar(double monto) {
		return cuenta.retirar(monto);
	}
	
	public double consultarSaldo() {
		return cuenta.obtenerSaldo();
	}
}
