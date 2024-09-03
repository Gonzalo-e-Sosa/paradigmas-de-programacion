package ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class Cerradura {
    private int claveDeApertura;
    private int cantidadDeFallosConsecutivosQueLaBloquean;
	private boolean estado;
	private boolean bloqueada;
	// es una lista con valores "true" o "false"
	private List<String> aperturas;
	
    public Cerradura(int claveDeApertura, int cantidadDeFallosConsecutivosQueLaBloquean) {
		this.claveDeApertura = claveDeApertura;
    	this.cantidadDeFallosConsecutivosQueLaBloquean = cantidadDeFallosConsecutivosQueLaBloquean;
    	this.estado = false;
    	this.bloqueada = false;
    	this.aperturas = new ArrayList<>();
    }
    
    private boolean existenFallosConsecutivos() {
    	int total = 0;
    	
    	for (String apertura : aperturas) {
			if(cantidadDeFallosConsecutivosQueLaBloquean == total) return true;
    		
			if(!Boolean.parseBoolean(apertura)) {
				total += 1;
			}
			else {
				total *= 0;
			}
		}
    	
    	return cantidadDeFallosConsecutivosQueLaBloquean == total;
    }
    
    public boolean abrir(int clave) {
    	estado = claveDeApertura == clave;
    	// se crea un nuevo string para que su direccion de memoria sea distinta
    	aperturas.add(estado ? new String("true") : new String("false"));
    	
    	if(existenFallosConsecutivos()) {
    		System.out.println("La cerradura está bloqueada.");
    		
    		estado = false;
    		bloqueada = true;
    		
    		return false;
		}
    	
    	if(estado) {
    		System.out.println("Clave correcta.");
    	}
    	else {
    		System.out.println("Clave incorrecta.");
    	}
    	
    	return estado;
    }
    
    public void cerrar() {
    	estado = false;
    }
    
    public boolean estaAbierta() {
    	return estado == true;
    }
    
    public boolean estaCerrada() {
    	return estado == false;
    }
    
    public boolean fueBloqueada() {
    	return bloqueada == true;
    }
    
    public int contarAperturasExitosas() {
    	int total = 0;
    	
    	for (String apertura : aperturas) {
			total += Boolean.parseBoolean(apertura) ? 1 : 0;
		}
    	
    	return total;
    }
    
    public int contarAperturasFallidas() {
    	int total = 0;
    	
    	for (String apertura : aperturas) {
			total += Boolean.parseBoolean(apertura) ? 0 : 1;
		}
    	
    	return total;
    }
}
