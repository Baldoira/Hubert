package uy.edu.hubert.Listas;

public class Main {

	public static void main(String[] args) {
		
//		ILista<Integer> lis = new ListaSE<Integer>();
//		lis.insertarPpio(3);
//		lis.insertarPpio(2);
//		lis.insertarFin(4);
//		lis.insertarFin(5);
//		lis.insertarPpio(1);
//		lis.listar();
		
		ILista<String> lis = new ListaSE<String>();
		lis.insertarPpio("C");
		lis.insertarPpio("B");
		lis.insertarFin("D");
		lis.insertarFin("E");
		lis.insertarPpio("A");
//		lis.listar();
		
		for(String str : lis) {
			System.out.println(str);
		}
	
		System.out.println("------------------------------------------------");

		ILista<Usuario> lisPer = new ListaSEOrd<Usuario>();
		Usuario p2 = new Usuario("sofia@gmail.com", "Sofia Bedelia", "s123");
		Usuario p3 = new Usuario("augusto@gmail.com", "Augusto Bedelía", "a123");
		Usuario p1 = new Usuario("viviana@gmail.com", "Viviana Baldoira", "vb123");
		lisPer.insertarOrd(p1);
		lisPer.insertarOrd(p2);
		lisPer.insertarOrd(p3);
//		lisPer.listar();

		for(Usuario str : lisPer) {
			System.out.println(str);
		}
		
	}

}
