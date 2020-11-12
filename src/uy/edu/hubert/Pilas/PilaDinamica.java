package uy.edu.hubert.Pilas;

public class PilaDinamica<T> implements IPila<T> {

	private NodoPila<T> inicio;
	private int cantidad;
	private int tope;
	
	public PilaDinamica() {
//		this.inicio = null;
//		this.cantidad = 0;
		this.tope = -1;
	}
	
	public PilaDinamica(int tope) {
//		this.inicio = null;
//		this.cantidad = 0;
		this.tope = tope;
	}

	@Override
	public void push(T dato) {
		inicio = new NodoPila<T>(dato,inicio);
		cantidad++;
	}

	@Override
	public void pop() {
		inicio = inicio.getSig();
		cantidad--;
	}

	@Override
	public T top() {
		return inicio.getDato();
	}

	@Override
	public T topAndPop() {
		T primero = top();
		pop();
		return primero;
	}

	@Override
	public boolean esVacia() {
		//return inicio == null;
		return cantidad == 0;
	}

	@Override
	public boolean esLlena() {
		return cantidad == tope;
	}

	@Override
	public int largo() {
		return cantidad;
	}
	
}
