package ejercicio1;

public class Nota {	
	private int valor;
	
	public Nota() {
		valor = 0;
	}
	
	public Nota(int valor) throws Exception {
		if(valor < 0 || valor > 10) throw new Exception("valor debe estar comprendido entre 0 y 10.");
		this.valor = valor;
	}
	
	/**
	 * pre : nuevoValor está comprendido entre 0 y 10.
	 * post: modifica el valor numérico de la Nota, cambiándolo
	 *       por nuevoValor, siempre y cuando nuevoValor sea superior al
	 *       valor numérico actual de la Nota.
	 */
	public void recuperar(int nuevoValor) throws Exception {
		if(nuevoValor < 0 || nuevoValor > 10) throw new Exception("nuevoValor debe estar comprendido entre 0 y 10.");
		valor = nuevoValor > valor ? nuevoValor : valor;  
	}
	
	public boolean aprobada() {
		return valor >= 4;
	}

	public boolean desaprobada() {
		return valor < 4;
	}
	
	public int obtenerValor() {
		return valor;
	}
}
