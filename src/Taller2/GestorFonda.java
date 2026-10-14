package Taller2;

import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GestorFonda {
	private Consumo[] registro = new Consumo[200];
	private int totalRegistros = 0;
	
	private String[] participantes = new String[200];
	private int totalParticipantes = 0;
	
	private Scanner scanner = new Scanner(System.in);
	
	public void inicio() {
		cargarParticipantes();
		cargarConsumos();
		int opcion = 0;
		do {
		System.out.println("============================================\r\n"
				+ "           LA FONDA DEL PAPU\r\n"
				+ "============================================\r\n"
				+ "  Registros cargados:"  + totalRegistros);
		System.out.println("--------------------------------------------\r\n"
				+ "  [1] Ver registros\r\n"
				+ "  [2] Actualizar registros\r\n"
				+ "  [3] Calcular metricas\r\n"
				+ "  [4] Salir\r\n"
				+ "============================================\r\n"
				+ "Seleccione una opcion: ");
		String entrada = scanner.nextLine();
		if (entrada.isEmpty()) {
			System.out.println("No se ingreso nada, intentelo de nuevo");
		} else {
			try {
				opcion = Integer.parseInt(entrada);
				switch (opcion) {
				case 1:
					menuVerRegistros();
					break;
				case 2:
					menuActualizarRegistros();
					break;
				case 3:
					menuCalcularMetricas();
					break;
				case 4:
					System.out.println("Saliendo del sistema...");
					break;
				default:
					System.out.println("Ingrese un número valido por favor");
				}
			} catch (Exception e) {
				System.out.println("No se ingresó un número. Intentelo nuevamente.");
			}
		}
		
		} while (opcion != 4);
	}
	
	private void menuCalcularMetricas() {
		// TODO Auto-generated method stub
		
	}

	private void menuActualizarRegistros() {
		// TODO Auto-generated method stub
		
	}

	private void menuVerRegistros() {
		// TODO Auto-generated method stub
		
	}

	public void cargarParticipantes() {
		File archivo = new File("Participantes.txt");
		if (!archivo.exists()) {
			System.out.println("No se encontró ningún archivo");
			return;
		}
		
		try (Scanner lector = new Scanner(archivo)) {
			while(lector.hasNextLine() && totalParticipantes < 200) {
				String linea = lector.nextLine();
				if (!linea.isEmpty()) {
					participantes[totalParticipantes++] = linea;
				}
			}
		} catch (IOException e) {
			System.out.println("Error al leer el archivo correspondiente");
		}
	}
	
	public void cargarConsumos() {
		File archivo = new File("Consumido.txt");
		if (!archivo.exists()) {
			System.out.println("No se encontró ningún archivo");
			return;
		}
		try (Scanner lector = new Scanner(archivo)) {
			while (lector.hasNextLine() && totalRegistros < 200) {
				String linea = lector.nextLine();
				
				if (!linea.isEmpty()) {
					String[] partes = linea.split(";");
					if (partes.length >= 4) {
						String tipo = partes[0];
						String consumidor = partes[1];
						String fecha = partes[partes.length-1];
						
						if (tipo.equalsIgnoreCase("Choripan") && partes.length >= 5) {
							try {
								double largo = Double.parseDouble(partes[2]);
								double ancho = Double.parseDouble(partes[3]);
								registro[totalRegistros++] = new Choripan(consumidor, fecha, largo, ancho);
							} catch (Exception e) {
								System.out.println("Error al intentar leer datos");
							}
						} 
						else if (tipo.equalsIgnoreCase("Terremoto") && partes.length >= 4) {
							try {
								double litros = Double.parseDouble(partes[2]);
								registro[totalRegistros++] = new Terremoto(consumidor, fecha, litros);
							} catch (Exception e) {
								System.out.println("Error al intentar leer datos");
							}
						}
					}
				}
			}
		}
		catch (IOException e) {
			System.out.println("Error al leer el archivo correspondiente");
		}
	}
}
