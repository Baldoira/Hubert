package uy.edu.hubert.Sistema;

public interface ISistema {

	/**
	 * : Inicializa las estructuras necesarias para representar el sistema especificado,
	 * capaz de albergar como m�ximo maxPuntos puntos diferentes en el mapa. Como punto se
	 * entiende que puede ser tanto una esquina, un m�vil o un delivery (cualquier entidad
	 * georeferenciada).

	 * @param maxPuntos
	 * @return
	 */
	Retorno inicializarSistema(int maxPuntos);

	/**
	 * : Destruye el sistema de todos sus elementos y estructuras, liberando la
	 * memoria utilizada.

	 * @return
	 */
	Retorno destruirSistema();

	/**
	 * Registra el usuario con sus datos. El email identifica al usuario.
	 * <br>
	 * Restricci�n de eficiencia: log(n) promedio
	 * @param email
	 * @param nombre
	 * @param password
	 * @return
	 */
	Retorno registrarUsuario(String email, String nombre, String password);

	/**
	 * Retorna en valorString los datos del usuario con el formato �Email; Nombre�.
	 * Adem�s, en el campo valorEntero de la clase Retorno, deber� devolver la cantidad de
	 * elementos que recorri� durante la b�squeda en la estructura de los usuarios.
	 * <br>
	 * Restricci�n de eficiencia: log(n) promedio

	 * @param email
	 * @return
	 */
	Retorno buscarUsuario(String email);

	/**
	 * Retorna en valorString los datos de todos los usuarios registrados, ordenados
	 * en forma alfab�tica por email
	 * <br>
	 * Restricci�n de eficiencia: log(n) promedio
	 * @return
	 */
	Retorno listarUsuarios();

	/**
	 * Retorna en valorString todas las direcciones registradas para el usuario de
	 * email email. Las direcciones deber�n ser devueltas en orden decreciente de mayor cantidad
	 * de usos
	 * @param email
	 * @return
	 */
	Retorno direccionesDeUsuario(String email);

	/**
	 * Registra la esquina de coordenadas coordX, coordY en el sistema.
	 * @param coordX
	 * @param coordY
	 * @return
	 */
	Retorno registrarEsquina(double coordX, double coordY);

	/**
	 * Registra el delivery en las coordenadas coordX, coordY en el sistema y lo deja
	 * en estado Activo.

	 * @param cedula
	 * @param coordX
	 * @param coordY
	 * @return
	 */
	Retorno registrarDelivery(String cedula, double coordX, double coordY);

	/**
	 * Registra el m�vil en las coordenadas coordX, coordY en el sistema y lo deja en
	 * estado Activo.

	 * @param matricula
	 * @param coordX
	 * @param coordY
	 * @return
	 */
	Retorno registrarMovil(String matricula, double coordX, double coordY);

	/**
	 * 
	 * Registra un tramo en el sistema desde la coordenada inicio (coordXi, coordYi)
	 * hasta la coordenada destino (coordXf, coordYf), con un un peso en metros y otro peso en
	 * minutos.
	 
	 *
	 * Para los delivery se considerar� que los tramos son navegables en ambos sentidos,
	 * ya que circular�n por la vereda. O sea, que si agregamos el tramo para ir del punto A al
	 * punto B, tambi�n se podr� navegar del punto B al punto A.
	 *

	 * 
	 * @param coordXi
	 * @param coordYi
	 * @param coordXf
	 * @param coordYf
	 * @param metros
	 * @param minutos
	 * @return
	 */
	Retorno registrarTramo(double coordXi, double coordYi, double coordXf, double coordYf, int metros, int minutos);

	/**
	 * 
	 * Retorna el m�vil disponible m�s cercano a las coordenadas en donde se
	 * encuentra el usuario.

	 * 
	 * @param coordXi
	 * @param coordYi
	 * @return
	 */
	Retorno movilMasCercano(double coordXi, double coordYi);

	/**
	 * 
	 * Retorna el delivery disponible que se encuentre a menos cuadras (�tramos�) de
	 * distancia de las coordenadas dadas. Aqu� no se quiere usar la distancia de los tramos del
	 * mapa si no la cantidad de tramos a recorrer.

	 * 
	 * @param coordXi
	 * @param coordYi
	 * @return
	 */
	Retorno deliveryMasCercano(double coordXi, double coordYi);

	/**
	 * 
	 * Retorna el camino m�s corto que podr�a realizar el m�vil entre las coordenadas
	 * iniciales y las coordenadas finales.

	 * 
	 * @param coordXi
	 * @param coordYi
	 * @param coordXf
	 * @param coordYf
	 * @return
	 */
	Retorno caminoMinimoMovil(double coordXi, double coordYi, double coordXf, double coordYf, String email);

	/**
	 * 
	 * Retorna el camino m�s r�pido (tomando el tiempo) que podr�a realizar el
	 * delivery entre las coordenadas iniciales y las coordenadas finales.
	 * 
	 * @param coordXi
	 * @param coordYi
	 * @param coordXf
	 * @param coordYf
	 * @return
	 */
	Retorno caminoMinimoDelivery(double coordXi, double coordYi, double coordXf, double coordYf);

	/**
	 * 
	 * Esta operaci�n deber� mostrar en un mapa de Google Maps todos los m�viles
	 * y deliverys presentes en el mapa. Se desea distinguir con colores seg�n los m�viles y
	 * deliverys est�n disponibles (verdes) o ocupados (rojos).

	 * 
	 * @return
	 */
	Retorno dibujarMapa();

}
