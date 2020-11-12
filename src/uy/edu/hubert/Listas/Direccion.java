package uy.edu.hubert.Listas;

public class Direccion implements Comparable<Direccion> {
	
	private int cantUsos;
	private double coordX;
	private double coordY;
	
	//Constructor
	
	
	
	//Getters && Setters
	
	public int getCantUsos() {
		return cantUsos;
	}
	public Direccion(double coordX, double coordY) {
		this.cantUsos = 0;
		this.coordX = coordX;
		this.coordY = coordY;
	}
	public void setCantUsos(int cantUsos) {
		this.cantUsos = cantUsos;
	}

	public double getCoordX() {
		return coordX;
	}

	public void setCoordX(double coordX) {
		this.coordX = coordX;
	}

	public double getCoordY() {
		return coordY;
	}

	public void setCoordY(double coordY) {
		this.coordY = coordY;
	}
	
	@Override
	public String toString() {
		return  "<" + coordX + ">;<" + coordY + ">";
	}
	
	@Override
	public int compareTo(Direccion o) {
		return this.cantUsos - o.cantUsos;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccion other = (Direccion) obj;
		if (coordX != other.coordX && coordY != other.coordY)
			return false;
		return true;
	}
}
