package Taller2;

public class Terremoto extends Consumo {
	private double litros;
	
	public Terremoto(String consumidor, String fecha, double litros) {
		super(consumidor, fecha);
		this.litros = litros;
	}

	public double getLitros() {
		return litros;
	}

	public void setLitros(double litros) {
		this.litros = litros;
	}

	@Override
	public double calcularKCal() {
		return (litros*10)/3;
	}

	@Override
	public String getTipo() {
		return "Terremoto";
	}

	@Override
	public String toFileString() {
		return "Terremoto;" +  consumidor + ";" + litros + ";" + fecha;
	}

	@Override
	public void mostrarDetalle(int index) {
		System.out.println(" " + index +  " | " + consumidor + " | " + litros + " L | " + fecha + " | " + calcularKCal() + "kCal");
		
	}
}
