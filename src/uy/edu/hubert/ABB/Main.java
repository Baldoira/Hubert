package uy.edu.hubert.ABB;

public class Main {

	public static void main(String[] args) {
		ABB<Integer> a = new ABB<Integer>();
		
		a.insertar(4);
		a.insertar(2);
		a.insertar(6);
		a.insertar(1);
		a.insertar(3);
		a.insertar(5);
		a.insertar(7);

		a.listarAscendiente();
		
		System.out.println("------------------------------------------------");
		
		a.listarDescendiente();
		
		a.borrar(4);
		
		System.out.println("------------------------------------------------");

		a.listarAscendiente();
		
		a.borrarMin();
		
		System.out.println("------------------------------------------------");
		
		a.listarDescendiente();
	}
	
}
