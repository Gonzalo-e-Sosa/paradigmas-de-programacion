package lenguaje;

public class Rango implements Comparable<Rango>{
	private double inicio;
	private double fin;
	private boolean inicioIncluido;
	private boolean finIncluido;
	private static final double MIN = Double.MIN_VALUE;
	private static final double MAX = Double.MAX_VALUE;
	
	public Rango() {
		this.inicio = 0.0;
		this.fin = 0.0;
		this.inicioIncluido = false;
		this.finIncluido = false;
	}
	
	public Rango(double inicio, boolean inicioIncluido, double fin, boolean finIncluido) {
		if(inicio >= fin) 
			throw new RuntimeException("Inicio debe ser menor a fin.");
		
		this.inicio = inicio ;
		this.fin = fin;
		this.inicioIncluido = inicioIncluido;
		this.finIncluido = finIncluido;
	}
	
	public double obtenerInicio() {
		return inicio;
	}
	
	public double obtenerFin() {
		return fin;
	}

	public boolean obtenerInicioIncluido() {
		return inicioIncluido;
	}
	
	public boolean obtenerFinIncluido() {
		return finIncluido;
	}
	
	public boolean estaDentroDelRango(double valor) {
		boolean siInicio = inicioIncluido ? inicio <= valor : inicio < valor; 
		boolean siFinal = finIncluido ? fin >= valor : fin > valor;
		
		return siInicio && siFinal;
	}
	
	public boolean estaDentroDelRango(Rango rango) {
		boolean siInicio = estaDentroDelRango(rango.obtenerInicio());
		boolean siFin = estaDentroDelRango(rango.obtenerFin());
		
		return siInicio && siFin;
	}
	
	public boolean hayInterseccion(Rango rango) {
		boolean siInicio = estaDentroDelRango(rango.obtenerInicio());
		boolean siFin = estaDentroDelRango(rango.obtenerFin());
		
		return siInicio || siFin;
	}
	
	public Rango rangoInterseccion(Rango rango) {
		if(!hayInterseccion(rango))
			return new Rango();
		
		return new Rango(rango.obtenerInicio(), rango.obtenerInicioIncluido(), fin, finIncluido);
	}
	
	public Rango sumar(Rango rango) {
		return new Rango(inicio, inicioIncluido, rango.obtenerFin(), rango.obtenerFinIncluido());
	}

	public Rango desplazar(double escalar) {
		return new Rango(inicio + escalar, inicioIncluido, fin + escalar, finIncluido);
	}
	
	// []
	public static Rango rangoCerrado(double inicio, double fin) {
        return new Rango(inicio, true, fin, true);
    }

    // ()
	public static Rango rangoAbierto(double inicio, double fin) {
        return new Rango(inicio, false, fin, false);
    }
	
	// (-inf, +inf)
	public static Rango rangoInfinito() {
		return rangoAbierto(MIN, MAX);
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
		Rango other = (Rango) obj;
		return Double.doubleToLongBits(fin) == Double.doubleToLongBits(other.obtenerFin()) && finIncluido == other.obtenerFinIncluido()
				&& Double.doubleToLongBits(inicio) == Double.doubleToLongBits(other.obtenerInicio())
				&& inicioIncluido == other.obtenerInicioIncluido();
	}

	@Override
	public int compareTo(Rango o) {
		int cmpInicio = (int) (this.inicio - o.obtenerInicio());
		
		if (cmpInicio == 0) {
			int cmpFin = (int) (this.fin - o.obtenerFin());

			if(cmpFin == 0) {
				int primeroIncluido = this.inicioIncluido 
						? this.inicioIncluido == this.finIncluido 
							? 1 
							: 0 
						: 0;
				int segundoIncluido = o.obtenerInicioIncluido() 
						? o.obtenerInicioIncluido() == o.obtenerFinIncluido() 
							? 1 
							: 0
						: 0;
				
				return primeroIncluido - segundoIncluido;
			}
			
			return cmpFin;
		}
		
		return cmpInicio;
	}
	
	@Override
	public String toString() {
		char izquierda = inicioIncluido ? '[' : '(';
		char derecha = finIncluido ? ']' : ')';
		
		return "Rango: " + izquierda + inicio + ", " + fin + derecha;
	}
}
