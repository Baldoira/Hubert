package uy.edu.hubert.Listas;

public interface ILista<T> extends Iterable<T> {

	//CONSTRUCTORES
	
	/**
	 * Inserta a un elemento al principio de la lista 
	 * <br>
	 * Pre: !esLlena()
	 */
	public void insertarPpio(T dato);

	/**
	 * Inserta a un elemento al final de la lista 
	 * <br>
	 * Pre: !esLlena()
	 */
	public void insertarFin(T dato);

	/**
	 * Inserta a un elemento ordenado dentro de la lista 
	 * <br>
	 * Pre: !esLlena()
	 */
	public void insertarOrd(T dato);
	
	//DESTRUCTORES
	
	/**
	 * Elimina al primer elemento de la lista 
	 * <br>
	 * Pre: !esVacia()
	 */
	public void borrarInicio();

	/**
	 * Elimina al �ltimo elemento de la lista 
	 * <br>
	 * Pre: !esVacia()
	 */
	public void borrarFin();
	
	/**
	 * Elimina la primer ocurrencia del elemento recibido por par�metro
	 * <br>
	 * Pre: existe(dato)
	 */
	public void borrar(T dato);

	/**
	 * Elimina todas las ocurrencias del elemento recibido por par�metro
	 * <br>
	 * Pre:
	 */
	public void borrarTodos(T dato);
	
	/**
	 * Elimina a todos los elementos de la lista.
	 * <br>
	 * Pre:
	 */
	public void vaciar();
	
	//PREDICADOS

	/**
	 * Devuelve <code>true</code> sii el dato existe en la lista, o <code>false</code> en caso contrario.
	 * <br>
	 * Pre:
	 */
	public boolean existe(T dato);

	/**
	 * Devuelve <code>true</code> sii la lista est� vac�a, o <code>false</code> en caso contrario.
	 * <br>
	 * Pre:
	 */
	public boolean esVacia();

	/**
	 * Devuelve <code>true</code> sii la lista est� llena, o <code>false</code> en caso contrario.
	 * <br>
	 * Pre:
	 */
	public boolean esLlena();

	/**
	 * Devuelve la cantidad de elementos de la lista.
	 * <br>
	 * Pre:
	 */
	public int largo();
	
	//POSICIONAMIENTO
	
	/**
	 * Devuelve el primer elemento de la lista
	 * <br>
	 * Pre: !esVacia()
	 * @return T dato
	 */
	public T obtenerPpio();

	/**
	 * Devuelve el �ltimo elemento de la lista
	 * <br>
	 * Pre: !esVacia()
	 * @return T dato
	 */
	public T obtenerFin();

	/**
	 * Devuelve la posici�n del elemento recibido por par�metro, o -1 en caso de no existir.
	 * <br>
	 * Pre:
	 */
	public int obtenerPos(T dato);

	//SELECTORES

	/**
	 * Devuelve (en caso de existir) a un elemento igual al recibido por par�metro 
	 * <br>
	 * Pre:
	 */
	public T recuperar(T dato);
	
	public void listar();

}
