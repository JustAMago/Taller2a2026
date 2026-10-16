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
		return (largo*ancho)/3;
	}

	@Override
	public String getTipo() {
		return "Choripan";
	}

	@Override
	public String toFileString() {
		return "Choripan;" +  consumidor + ";" + largo + ";" + ancho + ";" + fecha;
	}

	@Override
	public void mostrarDetalle(int index) {
		System.out.println(" " + index + " | " + consumidor + " | " + largo + " cm | " + ancho +  " cm | " + fecha + " | " + calcularKCal() + " kCal");
		
	}
}
