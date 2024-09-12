package ejercicio1;

import java.security.InvalidParameterException;
import java.util.Date;

public class Transaccion implements Comparable<Transaccion>{
	private Cuenta origen;
	private Cuenta destino;
	private double monto;
	private String motivo;
	private Date fecha;
	//LocalDateTime fecha;
	
	public Transaccion(Cuenta origen, Cuenta destino, double monto, String motivo) {
		if(monto <= 0)
			throw new InvalidParameterException("Monto debe ser positivo.");
		
		this.origen = origen;
		this.destino = destino;
		this.monto = monto;
		this.motivo = motivo;
		this.fecha = new Date();
	}

	public Transaccion(Cuenta origen, Cuenta destino, double monto, String motivo, Date fecha) {
		this(origen, destino, monto, motivo);
		
		this.fecha = fecha;
	}
	
	public Cuenta consultarCuentaOrigen() {
		return origen;
	}

	public Cuenta consultarCuentaDestino() {
		return destino;
	}
	
	public double consultarMonto() {
		return monto;
	}
	
	public String consultarMotivo() {
		return motivo;
	}
	
	public Date consultarFecha() {
		return fecha;
	}

	@Override
	public int compareTo(Transaccion o) {
		int cmpFecha = fecha.compareTo(o.consultarFecha());
		if(cmpFecha == 0) {
			return (int) (monto - o.consultarMonto()); 
		}
		return cmpFecha;
	}
}
