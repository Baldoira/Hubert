package uy.edu.hubert.Grafos;

public class Tramo {

	private boolean existe;
	private int costoMetros;
	private int costoMinutos;

	

	public Tramo(int costoMetros, int costoMinutos) {
		this.existe = true;
		this.costoMetros = costoMetros;
		this.costoMinutos = costoMinutos;
	}

	public Tramo() {
//		this.existe = false;
//		this.costoMetros = 0;
//		this.costoMinutos = 0;
	}

	

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public int getCostoMetros() {
		return costoMetros;
	}

	public void setCostoMetros(int costoMetros) {
		this.costoMetros = costoMetros;
	}

	public int getCostoMinutos() {
		return costoMinutos;
	}

	public void setCostoMinutos(int costoMinutos) {
		this.costoMinutos = costoMinutos;
	}

	@Override
	public String toString() {
		return costoMetros + " metros y " + costoMinutos + " minutos";
	}
	
}
