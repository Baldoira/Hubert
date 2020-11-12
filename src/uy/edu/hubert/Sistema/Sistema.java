package uy.edu.hubert.Sistema;

import uy.edu.hubert.ABB.ABB;
import uy.edu.hubert.ABB.NodoABB;
import uy.edu.hubert.Grafos.Grafo;
import uy.edu.hubert.Listas.Usuario;
import uy.edu.hubert.Sistema.Retorno.Resultado;;

public class Sistema implements ISistema {
	
	
	private ABB<Usuario> usuarios;
	private Grafo mapa;


	@Override
	public Retorno inicializarSistema(int maxPuntos) {
		Retorno ret = new Retorno(Resultado.OK);
		if(maxPuntos > 0) {
			this.usuarios = new ABB<Usuario>();
			this.mapa = new Grafo(maxPuntos, false);
		} else {
			ret.resultado = Resultado.ERROR_1;
//			ret.valorString = "Ingrese un maximo de puntos mayor a 0.";
		}
		return ret;
	}

	@Override
	public Retorno destruirSistema() {
		Retorno ret = new Retorno(Resultado.OK);
		this.usuarios = new ABB<Usuario>();
		this.mapa = new Grafo();
		return ret;
	}

	@Override
	public Retorno registrarUsuario(String email, String nombre, String password) {
		Retorno ret = new Retorno(Resultado.OK);
		
		Usuario nuevo = new Usuario(email, nombre, password);
		
		if(!usuarios.existe(nuevo)) {
			if(!nuevo.Validar()) { 
				ret.resultado = Retorno.Resultado.ERROR_1;
//				ret.valorString = "Ingrese un email valido. Ej: algo@algomas.com";
			} else {
				usuarios.insertar(nuevo);
			}
		} else {
			ret.resultado = Retorno.Resultado.ERROR_2;
//			ret.valorString = "Ya existe un usuario con ese email.";
		}
		
		return ret;
	}

	@Override
	public Retorno buscarUsuario(String email) {
		Retorno ret = new Retorno(Resultado.OK);
		
		if(Usuario.esValidoMail(email)) {
			Usuario aux = new Usuario(email, "aux", "aux");
			if(usuarios.existe(aux)) {
				NodoABB<Usuario> miUsuario = usuarios.buscar(aux);
				ret.valorString = miUsuario.getDato().toString();
				ret.valorEntero = miUsuario.getPosicion();
			} else {
				ret.resultado = Retorno.Resultado.ERROR_2;
			}
		} else {
			ret.resultado = Retorno.Resultado.ERROR_1;
		}
		return ret;
	}

	@Override
	public Retorno listarUsuarios() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno direccionesDeUsuario(String email) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarEsquina(double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros, int minutos) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarDelivery(String cedula, double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno registrarMovil(String matricula, double coordX, double coordY) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno movilMasCercano(double coordXi, double coordYi) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno deliveryMasCercano(double coordXi, double coordYi) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoMinimoMovil(double coordXi, double coordYi, double coordXf, double coordYf, String email) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno caminoMinimoDelivery(double coordXi, double coordYi, double coordXf, double coordYf) {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

	@Override
	public Retorno dibujarMapa() {
		return new Retorno(Resultado.NO_IMPLEMENTADA);
	}

}
