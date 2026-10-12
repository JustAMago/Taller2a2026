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
