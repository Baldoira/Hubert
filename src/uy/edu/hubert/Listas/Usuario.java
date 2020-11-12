package uy.edu.hubert.Listas;

public class Usuario implements Comparable<Usuario> {

	private String email;
	private String nombre;
	private String password;
	private ILista<Direccion> direcciones;

	public Usuario(String email, String nombre, String password) {
		this.email = email;
		this.nombre = nombre;
		this.password = password;
		direcciones = new ListaSEOrd<Direccion>();
	}

	public String getMail() {
		return email;
	}

	public void setMail(String mail) {
		this.email = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public boolean Validar() {
		return esValidoMail(email);
	}
	
//	[DataType(DataType.EmailAddress)]
	public static boolean esValidoMail(String email) {
		return email.contains("@") && email.contains(".com") &&
				email.indexOf("@") == email.lastIndexOf("@");
	}


	@Override
	public String toString() {
		return  email + ";" + nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (email.toLowerCase() != other.email.toLowerCase())
			return false;
		return true;
	}

	@Override
	public int compareTo(Usuario o) {
		return this.email.compareTo(o.email);
	}
	
}
