package Taller2;

public class Choripan extends Consumo {
	private double largo;
	private double ancho;
	
	public Choripan(String consumidor, String fecha, double largo, double ancho) {
		super(consumidor, fecha);
		this.largo = largo;
		this.ancho = ancho;
	}

	public double getLargo() {
		return largo;
	}

	public void setLargo(double largo) {
		this.largo = largo;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	@Override
	public double calcularKCal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toFileString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mostrarDetalle(int index) {
		// TODO Auto-generated method stub
		
	}
}
