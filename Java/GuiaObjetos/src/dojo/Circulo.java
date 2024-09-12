package dojo;

import ejercicio2.Punto;

public class Circulo {
	private Punto centro;
	private double radio;
	
	public Circulo(Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	public double distanciaCon(Circulo c) {
		if(equals(c))
			return 0.0;
		
 		return centro.distanciaAotroPunto(c.obtenerCentro());
	}
	
	public boolean intersectaCon(Circulo c) {
		if(equals(c)) 
			return true;
		
		return distanciaCon(c) <= radio + c.obtenerRadio();
	}
	
	public Punto obtenerCentro() {
		return centro;
	}
	
	public double obtenerRadio() {
		return radio;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Circulo other = (Circulo) obj;
		if (centro == null) {
			if (other.centro != null) {
				return false;
			}
		} else if (!centro.equals(other.centro)) {
			return false;
		}
		if (Double.doubleToLongBits(radio) != Double.doubleToLongBits(other.radio)) {
			return false;
		}
		return true;
	}
}
