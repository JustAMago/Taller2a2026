package Taller2;

public abstract class Consumo {
	protected String consumidor;
	protected String fecha;
	
	public Consumo(String consumidor, String fecha) {
		this.consumidor = consumidor;
		this.fecha = fecha;
	}

	public String getConsumidor() {
		return consumidor;
	}

	public void setConsumidor(String consumidor) {
		this.consumidor = consumidor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public abstract double calcularKCal();
	public abstract String getTipo();
	public abstract String toFileString();
	public abstract void mostrarDetalle(int index);
	
}
