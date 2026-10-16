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
	
	public void menuCalcularMetricas() {
		int opcionMetrica = 0;
		do {
			System.out.println("============ CALCULAR METRICAS =============\r\n"
					+ "  [1] Choripanes comidos en total\r\n"
					+ "  [2] Terremotos tomados en total\r\n"
					+ "  [3] Choripanes comidos por usuario\r\n"
					+ "  [4] Terremotos tomados por usuario\r\n"
					+ "  [5] KCal consumidas por usuario\r\n"
					+ "  [6] Dias ebrio por usuario\r\n"
					+ "  [7] Volver al menu principal\r\n"
					+ "============================================\r\n"
					+ "Seleccione una opcion: ");
			String preguntaCalculo = scanner.nextLine();
			
			if (preguntaCalculo.isEmpty()) {
				System.out.println("No se ingresó nada, intentelo de nuevo");
			}
			else {
				try {
					opcionMetrica = Integer.parseInt(preguntaCalculo);
					switch (opcionMetrica) {
					case 1:
						choripanesTotales();
						break;
					case 2:
						terremotosTotales();
						break;
					case 3: 
						choripanesIndividual();
						break;
					case 4:
						terremotosIndividual();
						break;
					case 5:
						kCalUsuario();
						break;
					case 6:
						diasEbrio();
						break;
					case 7:
						System.out.println("Saliendo de Calcular Metricas...");
						break;
					default:
						System.out.println("Ingrese un número válido por favor");
						}
					} catch (Exception e) {
						System.out.println("No se ingresó ningún número. Intentelo nuevamente");
					}
				} 
			} while (opcionMetrica != 7);
		} 
	private void choripanesTotales() {
		int total = 0;
		for (int i = 0; i < totalRegistros; i++) {
			if (registro[i].getTipo().equalsIgnoreCase("Choripan")) {
				total++;
			}
		}
		System.out.println("========== TOTAL DE CHORIPANES =============");
		System.out.println("  Total de choripanes comidos: " + total);
		System.out.println("============================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}

	private void terremotosTotales() {
		int total = 0;
		double litrosTotal = 0;
		for (int i = 0; i < totalRegistros; i++) {
			if (registro[i].getTipo().equalsIgnoreCase("Terremoto")) {
				total++;
				Terremoto t = (Terremoto) registro[i];
				litrosTotal += t.getLitros();
			}
		}
		System.out.println("\n========== TOTAL DE TERREMOTOS =============");
		System.out.println("  Total de terremotos tomados: " + total);
		System.out.println("  Litros totales consumidos: " + litrosTotal + " L");
		System.out.println("============================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}

	private void choripanesIndividual() {
		System.out.println("====== CHORIPANES COMIDOS POR USUARIO ======\r\n"
				+ "  Usuario          Cantidad");
		for (int i = 0; i < totalParticipantes; i++) {
			String u = participantes[i];
			int cantidad = 0;
			for (int j = 0; j < totalRegistros; j++) {
				if (registro[j].getTipo().equalsIgnoreCase("Choripan") && registro[j].getConsumidor().equals(u)) {
					cantidad++;
				}
			}
			System.out.println("  " + u + " -> " + cantidad);
		}
		System.out.println("============================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}

	private void terremotosIndividual() {
		System.out.println("\n====== TERREMOTOS TOMADOS POR USUARIO ======");
		System.out.println("  Usuario          Cantidad    Litros");
		for (int i = 0; i < totalParticipantes; i++) {
			String u = participantes[i];
			int cantidad = 0;
			double litrosUser = 0;
			for (int j = 0; j < totalRegistros; j++) {
				if (registro[j].getTipo().equalsIgnoreCase("Terremoto") && registro[j].getConsumidor().equals(u)) {
					cantidad++;
					Terremoto t = (Terremoto) registro[j];
					litrosUser += t.getLitros();
				}
			}
			System.out.println("  " + u + " -> " + cantidad + " terremotos (" + litrosUser + " L)");
		}
		System.out.println("============================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}

	private void kCalUsuario() {
		System.out.println("\n=========== KCAL CONSUMIDAS POR USUARIO ===========");
		double kcalFondaTotal = 0;
		for (int i = 0; i < totalParticipantes; i++) {
			String u = participantes[i];
			double kcalUser = 0;
			for (int j = 0; j < totalRegistros; j++) {
				if (registro[j].getConsumidor().equals(u)) {
					kcalUser += registro[j].calcularKCal(); // Polimorfismo puro
				}
			}
			kcalFondaTotal += kcalUser;
			System.out.println("  " + u + " -> " + kcalUser + " kCal");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("  Consumo total de la fonda: " + kcalFondaTotal + " kCal");
		System.out.println("===================================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}

	private void diasEbrio() {
		System.out.println("\n============= DIAS EBRIO POR USUARIO ==============");
		for (int i = 0; i < totalParticipantes; i++) {
			String u = participantes[i];
			int diasEbrioContador = 0;
			for (int j = 0; j < totalRegistros; j++) {
				if (registro[j].getTipo().equalsIgnoreCase("Terremoto") && registro[j].getConsumidor().equals(u)) {
					String fechaActual = registro[j].getFecha();
					boolean yaEvaluado = false;
					for (int k = 0; k < j; k++) {
						if (registro[k].getTipo().equalsIgnoreCase("Terremoto") && registro[k].getConsumidor().equals(u) && registro[k].getFecha().equals(fechaActual)) {
							yaEvaluado = true;
							break;
						}
					}
					if (!yaEvaluado) {
						double litrosDia = 0;
						for (int l = 0; l < totalRegistros; l++) {
							if (registro[l].getTipo().equalsIgnoreCase("Terremoto") && registro[l].getConsumidor().equals(u) && registro[l].getFecha().equals(fechaActual)) {
								Terremoto t = (Terremoto) registro[l];
								litrosDia += t.getLitros();
							}
						}
						if (litrosDia >= 2.0) {
							diasEbrioContador++;
						}
					}
				}
			}
			System.out.println("  " + u + " -> Días ebrio (>= 2.0 L): " + diasEbrioContador);
		}
		System.out.println("==================================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}


	public void menuActualizarRegistros() {
		int opcionActualizar = 0;
		do {
			System.out.println("========== ACTUALIZAR REGISTROS ============\r\n"
					+ "  [1] Agregar\r\n"
					+ "  [2] Editar\r\n"
					+ "  [3] Eliminar\r\n"
					+ "  [4] Volver al menu principal\r\n"
					+ "============================================\r\n"
					+ "Seleccione una opcion: ");
			String preguntaActualizar = scanner.nextLine();
			if (preguntaActualizar.isEmpty()) {
				System.out.println("No se ingresó nada, intentelo nuevamente");
			} 
			else {
				try {
					opcionActualizar = Integer.parseInt(preguntaActualizar);
					switch (opcionActualizar) {
					case 1:
						agregarRegistro();
						break;
					case 2:
						editarRegistro();
						break;
					case 3:
						eliminarRegistro();
						break;
					default:
						System.out.println("Ingrese un número valido por favor");
						break;
					}
				} catch (Exception e) {
					System.out.println("No se ingresó un número");
				}
			}
		} while (opcionActualizar != 4);
	}

	private void agregarRegistro() {
		if (totalRegistros >= 200) {
			System.out.println("Limite de registros alcanzado (200 máximo)");
			return;
		}
		System.out.println("========== AGREGAR NUEVO REGISTRO ==========\r\n"
				+ "  [1] Choripan\r\n"
				+ "  [2] Terremoto\r\n"
				+ "Seleccione el tipo de consumo: ");
		String pregunta = scanner.nextLine();
		
		try {
			int opcion = Integer.parseInt(pregunta);
			System.out.println("Ingrese el nombre del consumidor: ");
			String consumidor = scanner.nextLine();
			System.out.println("Ingrese la fecha (ej. 2026-10-16)");
			String fecha = scanner.nextLine();
			
			switch (opcion) {
			case 1: 
				System.out.println("Ingrese el largo (cm): ");
				double largo = Double.parseDouble(scanner.nextLine());
				System.out.println("Ingrese el ancho (cm): ");
				double ancho = Double.parseDouble(scanner.nextLine());
				
				registro[totalRegistros++] = new Choripan(consumidor, fecha, largo, ancho);
				guardarConsumos();
				System.out.println("Choripan agregado exitosamente!");
				break;
			case 2:
				System.out.println("Ingrese los litros: ");
				double litros = Double.parseDouble(scanner.nextLine());
				
				registro[totalRegistros++] = new Terremoto(consumidor, fecha, litros);
				guardarConsumos();
				System.out.println("Terremoto agregado exitosamente!");
				break;
			default: 
				System.out.println("Ingrese un valor valido");
			}
		} catch (Exception e) {
			System.out.println("Error en los datos ingresados, intentelo nuevamente");
		}
	}
	
	private void guardarConsumos() {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("Consumido.txt"))) {
			for (int i = 0; i < totalRegistros; i++) {
				writer.write(registro[i].toFileString());
				writer.newLine();
			}
		} catch (IOException e) {
			System.out.println("Error al intentar actualizar el archivo");
		}
	}

	private void editarRegistro() {
		if (totalRegistros == 0) {
			System.out.println("No hay registros para editar");
			return;
		}
		System.out.println("========== EDITAR REGISTRO =================");
		for (int i = 0; i < totalRegistros; i++) {
			System.out.println(" [" + (i+1) + "] ");
			registro[i].mostrarDetalle(i+1);
		}
		System.out.println("Ingrese el número del registro a editar: ");
		String pregunta = scanner.nextLine();
		
		try {
			int index = Integer.parseInt(pregunta) -1;
			if (index >= 0 && index < totalRegistros) {
				Consumo actual = registro[index];
				System.out.println("Editando registro de tipo: " + actual.getTipo());
				System.out.println("Nuevo consumidor (" + actual.getConsumidor() + "): ");
				String consumidor = scanner.nextLine();
				if (consumidor.isEmpty()) {
					consumidor= actual.getConsumidor();
				}
				System.out.println("Nueva fecha (" + actual.getFecha() + "): ");
				String fecha = scanner.nextLine();
				if (fecha.isEmpty()) {
					fecha = actual.getFecha();
				}
				
				if (actual.getTipo().equalsIgnoreCase("Choripan")) {
					Choripan c = (Choripan) actual;
					System.out.println("Nuevo largo (" + c.getLargo() + "): ");
					String stringLargo = scanner.nextLine();
					double nuevoLargo = 0;
					if (stringLargo.isEmpty()) {
						nuevoLargo = c.getLargo();
					}
					else {
						nuevoLargo = Double.parseDouble(stringLargo);
					}
					System.out.println("Nuevo ancho (" + c.getAncho() + "): ");
					String stringAncho = scanner.nextLine();
					double nuevoAncho = 0;
					if (stringAncho.isEmpty()) {
						nuevoAncho = c.getAncho();
					}
					else {
						nuevoAncho = Double.parseDouble(stringAncho);
					}
					registro[index] = new Choripan(consumidor, fecha, nuevoLargo, nuevoAncho);
				}
				else {
					Terremoto t = (Terremoto) actual;
					System.out.println("Nuevos litros (" + t.getLitros() + "): ");
					String stringLitros = scanner.nextLine();
					double nuevoLitros = 0;
					if (stringLitros.isEmpty()) {
						nuevoLitros = t.getLitros();
					}
					else {
						nuevoLitros = Double.parseDouble(stringLitros);
					}
					registro[index] = new Terremoto(consumidor, fecha, nuevoLitros);
				}
				guardarConsumos();
				System.out.println("Registro actualizado exitosamente.");
			}
			else {
				System.out.println("Número de registros fuera de rango");
			}
		} catch (Exception e) {
			System.out.println("Error al intentar editar, intentelo nuevamente");
		}
	}

	private void eliminarRegistro() {
		if (totalRegistros == 0) {
			System.out.println("No hay registros para eliminar");
			return;
		}
		System.out.println("========== ELIMINAR REGISTRO ================");
		for (int i = 0; i < totalRegistros; i++) {
			System.out.println(" [" + (i+1) + "] ");
			registro[i].mostrarDetalle(i+1);
		}
		System.out.println("Ingrese el número del registro a eliminar: ");
		String pregunta = scanner.nextLine();
		
		try {
			int index = Integer.parseInt(pregunta) - 1;
			if (index >= 0 && index < totalRegistros) {
				for (int i = index; i < totalRegistros-1; i++) {
					registro[i] = registro[i+1];
				}
				registro[totalRegistros-1] = null;
				totalRegistros--;
				guardarConsumos();
				System.out.println("Registro eliminado exitosamente!");
			}
			else {
				System.out.println("Numero de registro fuera de rango");
			}
		} catch (Exception e) {
			System.out.println("Error al intentar eliminar, intentelo nuevamente");
		}
	}

	public void menuVerRegistros() {
		int opcionVer = 0;
		do {
			System.out.println("============= VER REGISTROS =================\r\n"
					+ "  [1] Choripanes\r\n"
					+ "  [2] Terremotos\r\n"
					+ "  [3] Volver al menu principal\r\n"
					+ "============================================\r\n"
					+ "Seleccione una opcion: ");
			String preguntaVer = scanner.nextLine();
			if (preguntaVer.isEmpty()) {
				System.out.println("No ha ingresado nada, intentelo de nuevo");
			} else {
				try {
					opcionVer = Integer.parseInt(preguntaVer);
					switch (opcionVer) {
						case 1:
							mostrarChoripanes();
							break;
						case 2:
							mostrarTerremotos();
							break;
						case 3:
							System.out.println("Volviendo al menú principal");
							break;
						default:
							System.out.println("Ingrese un número valido por favor");
							break;
					}
				} catch (Exception e) {
					System.out.println("No se ingresó ningún numero. Intentelo nuevamente.");
				}
			}
		} while (opcionVer != 3);
		
	}

	private void mostrarChoripanes() {
		System.out.println("=============== CHORIPANES =================\r\n"
				+ "  #   Consumidor    Largo      Ancho      Fecha         KCal");
		int contadorChoripanes = 1;
		for (int i = 0; i < totalRegistros; i++) {
			if (registro[i].getTipo().equalsIgnoreCase("Choripan")) {
				Choripan c = (Choripan) registro[i];
				System.out.println("  " + contadorChoripanes + "  " + c.getConsumidor() + "  " + c.getLargo() + " cm  " + c.getAncho() + " cm  " + c.getFecha() + "  " + c.calcularKCal());
				contadorChoripanes++;
			}
		}
		System.out.println("--------------------------------------------------");
		System.out.println("  Total: " + (contadorChoripanes - 1) + " choripanes registrados");
		System.out.println("==================================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
	}

	private void mostrarTerremotos() {
		System.out.println("=============== TERREMOTOS =================\r\n"
				+ "  #   Consumidor    Litros     Fecha         KCal");
		int contadorTerremotos = 1;
		double contadorLitros = 0;
		for (int i = 0; i < totalRegistros; i++) {
			if (registro[i].getTipo().equalsIgnoreCase("Terremoto")) {
				Terremoto t = (Terremoto) registro[i];
				System.out.println("  " + contadorTerremotos + "  " + t.getConsumidor() + "  " + t.getLitros() + " L  " + t.getFecha() + "  " + t.calcularKCal());
				contadorLitros += t.getLitros();
				contadorTerremotos++;
			}
		}
		System.out.println("--------------------------------------------------");
		System.out.println("  Total: " + (contadorTerremotos - 1) + " terremotos registrados (" + contadorLitros + " L)");
		System.out.println("==================================================");
		System.out.print("\nPresione ENTER para continuar...");
		scanner.nextLine();
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
