package uy.edu.hubert.ABB;

public class ABB<T extends Comparable<T>> {

	private NodoABB<T> raiz;

	public ABB() {

	}

	public ABB(NodoABB<T> raiz) {
		this.raiz = raiz;
	}

	public int cantNodos() {
		return cantNodosRec(raiz);
	}

	private int cantNodosRec(NodoABB<T> nodo) {
		if (nodo == null) {
			return 0;
		} else {
			int cantIzq = cantNodosRec(nodo.getIzq());
			int cantDer = cantNodosRec(nodo.getDer());
			return 1 + cantIzq + cantDer;
		}
	}

	public int cantHojas() {
		return cantHojasRec(raiz);
	}

	private int cantHojasRec(NodoABB<T> nodo) {
		if (nodo == null) {
			return 0;
		} else if (nodo.getIzq() == null && nodo.getDer() == null) {
			return 1;
		} else {
			int cantHojasIzq = cantHojasRec(nodo.getIzq());
			int cantHojasDer = cantHojasRec(nodo.getDer());
			return cantHojasIzq + cantHojasDer;
		}
	}

	public boolean existe(T dato) {
		return buscar(dato) != null;
	}

	public NodoABB<T> buscar(T dato) {
		return buscarRec(dato, raiz, 1);
	}

	private NodoABB<T> buscarRec(T dato, NodoABB<T> nodo, int cont) {
		if (nodo == null) {
			return null;
		} else if (dato.equals(nodo.getDato())) {
			nodo.setPosicion(cont);
			return nodo;
		} else if (dato.compareTo(nodo.getDato()) < 0) {
			cont++;
			return buscarRec(dato, nodo.getIzq(), cont);
		} else {
			cont++;
			return buscarRec(dato, nodo.getDer(), cont);
		}
	}

	public int peso() {
		return Math.max(cantNodos() - 1, 0);
	}

	public int altura() {
		return alturaRec(raiz);
	}

	private int alturaRec(NodoABB<T> nodo) {
		if (nodo == null) {
			return 0;
		} else {
			int alturaIzq = alturaRec(nodo.getIzq());
			int alturaDer = alturaRec(nodo.getDer());
			return 1 + Math.max(alturaIzq, alturaDer);
		}
	}

	public boolean igualesRec(NodoABB<T> a, NodoABB<T> b) {
		return a == null && b == null || a != null && b != null && a.getDato() == b.getDato()
				&& igualesRec(a.getIzq(), b.getIzq()) && igualesRec(a.getDer(), b.getDer());
	}

	public ABB<T> clon(ABB<T> a) {
		return new ABB<T>(clonRec(a.raiz));
	}

	private NodoABB<T> clonRec(NodoABB<T> nodo) {
		if (nodo == null) {
			return null;
		} else {
			NodoABB<T> clonIzq = clonRec(nodo.getIzq());
			NodoABB<T> clonDer = clonRec(nodo.getDer());
			return new NodoABB<T>(nodo.getDato(), clonIzq, clonDer);
		}
	}

	public ABB<T> espejo(ABB<T> a) {
		return new ABB<T>(espejoRec(a.raiz));
	}

	private NodoABB<T> espejoRec(NodoABB<T> nodo) {
		if (nodo == null) {
			return null;
		} else {
			NodoABB<T> espejoIzq = espejoRec(nodo.getIzq());
			NodoABB<T> espejoDer = espejoRec(nodo.getDer());
			return new NodoABB<T>(nodo.getDato(), espejoDer, espejoIzq);
		}
	}

	public String listarAscendiente() {
		return listarAscendienteRec(raiz);
	}

	private String listarAscendienteRec(NodoABB<T> nodo) {
		String ret = "";
		if (nodo != null) {
			ret += listarAscendienteRec(nodo.getIzq());
			ret += nodo.getDato() + "|";
			ret += listarAscendienteRec(nodo.getDer());
		}
		return ret;
	}

	public String listarDescendiente() {
		return listarDescendienteRec(raiz);
	}

	private String listarDescendienteRec(NodoABB<T> nodo) {
		String ret = "";
		if (nodo != null) {
			ret += listarDescendienteRec(nodo.getDer());
			ret += nodo.getDato() + "|";
			ret += listarDescendienteRec(nodo.getIzq());
		}
		return ret;
	}

	public void insertar(T dato) {
		this.raiz = insertarRec(dato, this.raiz);
	}

	// Pre: !existe(dato)
	public NodoABB<T> insertarRec(T dato, NodoABB<T> nodo) {
		if (nodo == null) {
			return new NodoABB<T>(dato);
		} else {
			if (dato.compareTo(nodo.getDato()) < 0) {
				nodo.setIzq(insertarRec(dato, nodo.getIzq()));
			} else if (dato.compareTo(nodo.getDato()) > 0) {
				nodo.setDer(insertarRec(dato, nodo.getDer()));
			}
			return nodo;
		}
	}

	public T borrarMin() {
		if (raiz.getIzq() == null) {
			T ret = raiz.getDato();
			raiz = raiz.getDer();
			return ret;
		} else {
			return borrarMinRec(raiz);
		}
	}

	private T borrarMinRec(NodoABB<T> nodo) {
		if (nodo.getIzq().getIzq() == null) {
			T ret = nodo.getIzq().getDato();
			nodo.setIzq(nodo.getIzq().getDer());
			return ret;
		} else
			return borrarMinRec(nodo.getIzq());
	}

	public void borrar(T dato) {
		raiz = borrarRec(dato, raiz);
	}

	private NodoABB<T> borrarRec(T dato, NodoABB<T> nodo) {
		// Si el dato a eliminar coincide con el nodo
		if (dato.equals(nodo.getDato())) {
			if (nodo.getIzq() == null && nodo.getDer() == null) { // Caso simple: nodo sin hijos --> Devuelvo null
				return null;
			} else if (nodo.getIzq() != null && nodo.getDer() == null) { // Caso intermedio : Raiz con 1 hijo -->
																			// Devuelvo al hijo
				return nodo.getIzq();
			} else if (nodo.getIzq() == null && nodo.getDer() != null) { // Caso intermedio : Raiz con 1 hijo -->
																			// Devuelvo al hijo
				return nodo.getDer();
			} else { // Caso complejo: Raiz con 2 hijos
				// Muevo a la raiz al menor elemento del sub-arbol derecho o al mayor elemento
				// del sub-arbol izq
				if (nodo.getDer().getIzq() == null) { // El hijo derecho es el menor elemento del sub-arbol derecho
					nodo.setDato(nodo.getDer().getDato());
					nodo.setDer(nodo.getDer().getDer());
				} else {
					nodo.setDato(borrarMinRec(nodo.getDer())); // asigno al nodo el valor del menor elemento del
																// sub-arbol derecho, y borro dicho elemento del arbol
				}
				return nodo;
			}
		} else { // si el dato a eliminar no coinicide con el nodo, llamo a la recursiva
			if (dato.compareTo(nodo.getDato()) < 0) {
				nodo.setIzq(borrarRec(dato, nodo.getIzq()));
			} else {
				nodo.setDer(borrarRec(dato, nodo.getDer()));
			}
			return nodo;
		}
	}

}
