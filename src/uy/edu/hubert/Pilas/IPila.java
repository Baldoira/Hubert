package uy.edu.hubert.Pilas;

public interface IPila<T> {

	/**
	 * Pre: !esLlena()
	 * @param dato
	 */
	public void push(T dato);

	/**
	 * Pre: !esVacia()
	 * @param dato
	 */
	public void pop();
	
	/**
	 * Pre: !esVacia()
	 * @param dato
	 */
	public T top();
	
	/**
	 * Pre: !esVacia()
	 * @param dato
	 */
	public T topAndPop();
	
	public boolean esVacia();
	
	public boolean esLlena();
	
	public int largo();
	
}
