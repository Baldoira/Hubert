package uy.edu.hubert.Grafos;

public class Punto {

	private double coordX;
	private double coordY;

	public Punto(double coordX, double coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
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
		return "<" + coordX + ">;<" + coordY + ">";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((nombreSACARPARAELOBLI == null) ? 0 : nombreSACARPARAELOBLI.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Punto other = (Punto) obj;
//		if (nombreSACARPARAELOBLI == null) {
//			if (other.nombreSACARPARAELOBLI != null)
//				return false;
//		} else if (!nombreSACARPARAELOBLI.equals(other.nombreSACARPARAELOBLI))
//			return false;
//		return true;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(coordX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(coordY);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (Double.doubleToLongBits(coordX) != Double.doubleToLongBits(other.coordX))
			return false;
		if (Double.doubleToLongBits(coordY) != Double.doubleToLongBits(other.coordY))
			return false;
		return true;
	}
	
	
}
