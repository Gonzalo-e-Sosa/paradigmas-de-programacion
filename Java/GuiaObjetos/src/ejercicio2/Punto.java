package ejercicio2;

public class Punto {
	private double x;
	private double y;
	
	public Punto() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double obtenerX() {
		return this.x;
	}
	
	public double obtenerY() {
		return this.y;
	}
	
	public void cambiarX(double nuevoX) {
		this.x = nuevoX;
	}
	
	public void cambiarY(double nuevoY) {
		this.y = nuevoY;
	}
	
	public boolean estaSobreEjeX() {
		return y == 0;
	}
	
	public boolean esElOrigen() { 
		return x == 0 && y == 0;
	}
	
	public double distanciaAlOrigen() { 
		// formar un vector con el origen y el punto en cuestion
		// luego calcular su norma
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public double distanciaAotroPunto(Punto otro) { 
		// si es el mismo la distancia es cero
		if(this.equals(otro)) return 0;
		
		// formar un vector con el punto actual y el punto otro
		// calcular su norma
		Punto v = new Punto(this.x - otro.obtenerX(), this.y - otro.obtenerY());
		return Math.sqrt(Math.pow(v.x, 2) + Math.pow(v.y, 2));
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
		Punto other = (Punto) obj;
		return Double.doubleToLongBits(x) == Double.doubleToLongBits(other.x)
				&& Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
	}
}
