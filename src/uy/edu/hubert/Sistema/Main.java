package uy.edu.hubert.Sistema;

public class Main {

	public static void main(String[] args) {
		
	Sistema s = new Sistema();
	Sistema s2 = new Sistema();
	Sistema s3 = new Sistema();
	
	System.out.println("Inicializar sistema OK: " + s.inicializarSistema(7).resultado);
	System.out.println("Inicializar sistema Mal por 0: " + s2.inicializarSistema(0).resultado);
	System.out.println("Inicializar sistema mal por negativo: " + s.inicializarSistema(-80).resultado);
	
	System.out.println("-------------------------------------------------------------------------------------------------------------");
	
	System.out.println("Registrar usuario bien: " + s.registrarUsuario("Viviana@gmail.com", "Viviana", "vb123").resultado);
	System.out.println("Registrar usuario bien: " + s.registrarUsuario("Bouza@gmail.com", "Bouza", "fb123").resultado);
	System.out.println("Registrar usuario bien: " + s.registrarUsuario("Washington@gmail.com", "Washington", "wb123").resultado);
	System.out.println("Registrar usuario bien: " + s.registrarUsuario("Zelia@gmail.com", "Zelia", "zb123").resultado);
	System.out.println("Registrar usuario mal mail: " + s.registrarUsuario("Viviana@gmail", "Viviana", "vb123").resultado);
	System.out.println("Registrar usuario mal repetido: " + s.registrarUsuario("Viviana@gmail.com", "Viviana", "vb123").resultado);

	System.out.println("-------------------------------------------------------------------------------------------------------------");

	Retorno ret = s.buscarUsuario("Viviana@gmail.com");
	System.out.println(ret.resultado);
	System.out.println(ret.valorEntero);
	System.out.println(ret.valorString);
	
	Retorno ret2 = s.buscarUsuario("Bouza@gmail.com");
	System.out.println(ret2.resultado);
	System.out.println(ret2.valorEntero);
	System.out.println(ret2.valorString);
	
	Retorno ret3 = s.buscarUsuario("Washington@gmail.com");
	System.out.println(ret3.resultado);
	System.out.println(ret3.valorEntero);
	System.out.println(ret3.valorString);

	Retorno ret4 = s.buscarUsuario("Zelia@gmail.com");
	System.out.println(ret4.resultado);
	System.out.println(ret4.valorEntero);
	System.out.println(ret4.valorString);
	
	}
}
