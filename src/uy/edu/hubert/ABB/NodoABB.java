package uy.edu.hubert.ABB;

public class NodoABB<T> {

	private T dato;
	private int posicion;

	private NodoABB<T> izq;
	private NodoABB<T> der;

	public NodoABB(T dato) {
		this.dato = dato;
	}

	public NodoABB(T dato, NodoABB<T> izq, NodoABB<T> der) {
		this.dato = dato;
		this.izq = izq;
		this.der = der;
	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	
	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	public NodoABB<T> getIzq() {
		return izq;
	}

	public void setIzq(NodoABB<T> izq) {
		this.izq = izq;
	}

	public NodoABB<T> getDer() {
		return der;
	}

	public void setDer(NodoABB<T> der) {
		this.der = der;
	}

	@Override
	public String toString() {
		return dato + "";
	}
	
}
