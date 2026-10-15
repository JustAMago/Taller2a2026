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
		// TODO Auto-generated method stub
		
	}

	private void terremotosTotales() {
		// TODO Auto-generated method stub
		
	}

	private void choripanesIndividual() {
		// TODO Auto-generated method stub
		
	}

	private void terremotosIndividual() {
		// TODO Auto-generated method stub
		
	}

	private void kCalUsuario() {
		// TODO Auto-generated method stub
		
	}

	private void diasEbrio() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	private void editarRegistro() {
		// TODO Auto-generated method stub
		
	}

	private void eliminarRegistro() {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	private void mostrarTerremotos() {
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
