package uy.edu.hubert.Grafos;

import java.util.Arrays;

import uy.edu.hubert.Colas.ColaDinamica;
import uy.edu.hubert.Colas.ICola;

public class Grafo {

	private int tope;
	private int cant;
	private Punto[] vertices;
	private Tramo[][] matAdy;

	public Grafo() {

	}

	public Grafo(int tope, boolean esDirigido) {
		this.tope = tope;
//		this.cant = 0;
		this.vertices = new Punto[tope];
		this.matAdy = new Tramo[tope][tope];

		if (esDirigido) {
			for (int i = 0; i < matAdy.length; i++) {
				for (int j = 0; j < matAdy.length; j++) {
					matAdy[i][j] = new Tramo();
				}
			}
		} else {
			for (int i = 0; i < matAdy.length; i++) {
				for (int j = i; j < matAdy.length; j++) {
					matAdy[i][j] = matAdy[j][i] = new Tramo();
				}
			}
		}

	}

	public boolean esLleno() {
		return cant == tope;
	}

	public boolean esVacio() {
		return cant == 0;
	}

	// Pre: !esLleno()
	public void agregarVertice(Punto dato) {
		int pos = posHueco();
		vertices[pos] = dato;
		cant++;
	}

	private int posHueco() {
		int pos = 0;
		while (vertices[pos] != null) {
			pos++;
		}
		return pos;
	}

	private int posConVertice() {
		int pos = 0;
		while (vertices[pos] == null) {
			pos++;
		}
		return pos;
	}

	public boolean existeVertice(Punto origen) {
		return buscarPos(origen) != -1;
	}

	// Pre: existeVertice(origen) && existeVertice(destino)
	public boolean existeTramo(Punto origen, Punto destino) {
		int posOrigen = buscarPos(origen);
		int posDestino = buscarPos(destino);

		return matAdy[posOrigen][posDestino].isExiste();
	}

	// Pre: existeVertice(origen) && existeVertice(destino)
	public void borrarTramo(Punto origen, Punto destino) {
		int posOrigen = buscarPos(origen);
		int posDestino = buscarPos(destino);

		matAdy[posOrigen][posDestino].setExiste(false);
	}

	// Pre: existeVertice(origen)
	public void borrarVertice(Punto origen) {
		int posOrigen = buscarPos(origen);
		cant--;
		vertices[posOrigen] = null;
		for (int i = 0; i < tope; i++) {
			matAdy[i][posOrigen].setExiste(false);
			matAdy[posOrigen][i].setExiste(false);
		}
	}

	// Pre: existeVertice(origen) && existeVertice(destino) && !existeTramo(origen,
	// destino)
	public void agregarTramo(Punto origen, Punto destino, int costoMetros, int costoMinutos) {
		int posOrigen = buscarPos(origen);
		int posDestino = buscarPos(destino);

		matAdy[posOrigen][posDestino].setExiste(true);
		matAdy[posOrigen][posDestino].setCostoMetros(costoMetros);
		matAdy[posOrigen][posDestino].setCostoMinutos(costoMinutos);
	}

	private int buscarPos(Punto destino) {
		for (int i = 0; i < tope; i++) {
			if (destino.equals(vertices[i])) {
				return i;
			}
		}
		return -1;
	}

	// Pre: existeVertice(origen)
	// dfs = depth first search
	public void dfs(Punto origen) {
		int posOrigen = buscarPos(origen);
		boolean[] vis = new boolean[tope]; // para no loopear y no alterar la matriz
		dfsRec(posOrigen, vis);
	}

	private void dfsRec(int pos, boolean[] vis) {
		System.out.println(vertices[pos]);
		vis[pos] = true; // para no loopear
		for (int j = 0; j < tope; j++) {
			if (!vis[j] && matAdy[pos][j].isExiste()) {
				dfsRec(j, vis);
			}
		}
	}
	
	// Pre: existeVertice(origen)
	// bfs = breadth first search
	public void bfs(Punto origen) {
		int posOrigen = buscarPos(origen);
		boolean[] vis = new boolean[tope];
		bfsInterno(posOrigen, vis);
	}

	private void bfsInterno(int posOrigen, boolean[] vis) {
		ICola<Integer> cola = new ColaDinamica<Integer>();
		cola.enqueue(posOrigen);
		vis[posOrigen] = true;
		while (!cola.esVacia()) {
			int pos = cola.frontAndDequeue();
			System.out.println(vertices[pos]);
			for (int j = 0; j < tope; j++) {
				if (!vis[j] && matAdy[pos][j].isExiste()) {
					cola.enqueue(j);
					vis[j] = true;
				}
			}
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------
	
	//Busco el tramo menos costoso entre 2 puntos
	
	public void prim() {
		int pos = posConVertice();
		boolean[] vis = new boolean[tope];
		vis[pos] = true;
		// Realizo el procedimiento reiterativo |V|-1 veces
		for (int k = 0; k < cant - 1; k++) {
			int posO = -1, posD = -1, costo = Integer.MAX_VALUE;

			// Hago un todos contra todos para quedarme con la arista más corta
			// entre un visitado y un no visitado

			// Busco los visitados
			for (int i = 0; i < tope; i++) {
				if (vis[i]) {
					// Busco los no visitados
					for (int j = 0; j < tope; j++) {
						if (!vis[j] && matAdy[i][j].isExiste() && matAdy[i][j].getCostoMetros() < costo && matAdy[i][j].getCostoMinutos() < costo) {
							posO = i;
							posD = j;
							costo = matAdy[i][j].getCostoMetros();
						}
					}
				}
			}
			vis[posD] = true;
			System.out.println(String.format("%s -> %s (costo: %s)", vertices[posO], vertices[posD], costo));
			// System.out.println(vertices[posO] + " -> " + vertices[posD] + " (costo: " +
			// costo + ")");
		}
	}

	//-----------------------------------------------------------------------------------------------------------------------
	
	//Camino mas corto
	public void dijkstra(Punto origen) {

		int posO = buscarPos(origen);

		// Armo los tres arreglos necesarios para realizar el algoritmo
		int[] dist = new int[tope];
		int[] ant = new int[tope];
		boolean[] vis = new boolean[tope];

		// inicializo los vectores
		for (int i = 0; i < tope; dist[i] = Integer.MAX_VALUE, ant[i] = -1, i++)
			;

		// asigno al destino como el primer nodo a ser recorrido
		dist[posO] = 0;

		// comienzo proceso reiterativo (V veces) para ir procesando a los vértices de a
		// uno
		for (int k = 0; k < cant; k++) {
			int posMin = -1, min = Integer.MAX_VALUE;

			// hallo al vértice no visitado de menor distancia al origen
			for (int i = 0; i < tope; i++) {
				if (!vis[i] && dist[i] < min) {
					posMin = i;
					min = dist[i];
				}
			}

			// visito al elemento a ser procesado
			vis[posMin] = true;

			// analizo a los adyacentes, actualizando su distancia en caso de ser menor a la
			// hasta ahora descubierta
			for (int j = 0; j < tope; j++) {
				if (!vis[j] && matAdy[posMin][j].isExiste()) {
					int sumaAcumulada = dist[posMin] + matAdy[posMin][j].getCostoMetros();
					if (sumaAcumulada < dist[j]) {
						dist[j] = sumaAcumulada;
						ant[j] = posMin;
					}
				}
			}
		}

		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(vertices));
		System.out.println(Arrays.toString(ant));
	}

}
