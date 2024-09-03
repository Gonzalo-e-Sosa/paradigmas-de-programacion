package ejercicio4;

public class Cubo {
	private double lado;
	
	public Cubo(double lado) {
		this.lado = lado;
	}
	
	public double obtenerVolumen() {
		return Math.pow(lado, 3);
	}
	
	public double obtenerArea() {
		return 6 * (Math.pow(lado, 2));
	}
	
	public double obtenerDiagonal() {
		return lado * Math.sqrt(3);
	}
}
