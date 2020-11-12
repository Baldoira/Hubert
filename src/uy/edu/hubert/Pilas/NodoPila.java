package uy.edu.hubert.Pilas;

public class NodoPila<T> {

	private T dato;
	private NodoPila<T> sig;
	
	// alt shift s + o + enter
	public NodoPila(T dato, NodoPila<T> sig) {
		this.dato = dato;
		this.sig = sig;
	}
	
	public NodoPila(T dato) {
		this.dato = dato;
		this.sig = null;
	}
	
	// alt shift s + r + alt a + o + enter
	public T getDato() {
		return dato;
	}
	public void setDato(T dato) {
		this.dato = dato;
	}
	public NodoPila<T> getSig() {
		return sig;
	}
	public void setSig(NodoPila<T> sig) {
		this.sig = sig;
	}
	
	//alt shift s + s + enter
	@Override
	public String toString() {
		return dato+"";
	}
	
}
