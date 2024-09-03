package ejercicio3;

public class Circulo {
	private double radio;
	private double area;
	private double diametro;
	private double perimetro;
	
	public Circulo() {
		this.radio = 1;
		this.area = Math.PI;
		this.diametro = 2;
		this.perimetro = 2 * Math.PI;
	}
	
	public Circulo(double radio) {
		this.radio = radio;
		this.area = Math.PI * Math.pow(radio, 2);
		this.diametro = 2 * radio;
		this.perimetro = 2 * Math.PI * radio;
	}
	
	public double obtenerRadio() {
		return radio;
	}
	
	public double obtenerArea() {
		return area;
	}
	
	public double obtenerDiametro() {
		return diametro;
	}
	
	public double obtenerPerimetro() {
		return perimetro;
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
		return Double.doubleToLongBits(radio) == Double.doubleToLongBits(other.radio);
	}
}
