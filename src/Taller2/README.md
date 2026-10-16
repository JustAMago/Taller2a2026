La Fonda del Papu - Gestor de Consumos (Taller 2)

Descripción del Proyecto
La Fonda del Papu es una aplicación desarrollada en Java orientada a la Programación Orientada a Objetos (POO). Su propósito es gestionar, registrar, actualizar y calcular métricas detalladas del consumo de asistentes en una fonda tradicional chilena, controlando alimentos y bebestibles típicos como Choripanes y Terremotos. El sistema implementa persistencia manual mediante archivos de texto plano (Consumido.txt y Participantes.txt), utilizando estructuras de datos estáticas, polimorfismo robusto y menús interactivos protegidos contra errores de entrada en consola.

Integrantes

Nombre: ENZO SALVATORE CORNIELES MEDINA

RUT: 26.814.980-5

Usuario GitHub: JustAMago (https://github.com/JustAMago)

Estructura del Proyecto
El proyecto está organizado bajo el paquete Taller2 e incluye las siguientes clases principales:

Main.java (Clase de Inicio): Punto de entrada del programa (main). Inicializa el sistema instanciando GestorFonda y ejecutando su ciclo principal.

GestorFonda.java (Clase Gestora Principal): Administra el flujo del sistema mediante un menú interactivo en consola basado en estructuras switch y do-while. Gestiona arreglos estáticos de hasta 200 elementos, controla la carga y guardado manual en archivos y ejecuta la lógica de visualización, actualizaciones (agregar, editar, eliminar) y cálculo de métricas totales e individuales.

Consumo.java (Clase Abstracta Base): Define los atributos comunes de cualquier consumo (consumidor, fecha) y declara los métodos abstractos de polimorfismo (calcularKCal(), getTipo(), toFileString(), mostrarDetalle()), evitando el uso de operadores instanceof.

Choripan.java (Subclase): Hereda de Consumo incorporando los atributos específicos largo y ancho (en centímetros) y su respectiva fórmula de calorías (KCal = (largo * ancho) / 3).

Terremoto.java (Subclase): Hereda de Consumo incorporando el atributo de volumen en litros y su cálculo calórico correspondiente.

Instrucciones de Ejecución (Desde Eclipse IDE)

Sigue estos pasos para configurar, compilar y ejecutar el proyecto correctamente en Eclipse:

Importar el Proyecto:

Abre Eclipse IDE.

Importa o crea un proyecto Java estándar asegurándote de que los archivos fuente estén contenidos dentro del paquete Taller2.

Verificar los Archivos de Datos:

Comprueba que los archivos de texto plano Participantes.txt y Consumido.txt estén ubicados en la raíz del proyecto (en el mismo nivel que las carpetas src y bin), para que el sistema pueda cargarlos correctamente al iniciar.

Ejecutar la Aplicación:

Localiza la clase Main.java en el explorador de paquetes (src/Taller2/Main.java).

Haz clic derecho sobre Main.java -> Run As -> Java Application.

Listo. Sigue las instrucciones en la consola de Eclipse para interactuar con los menús de la fonda.

Add README.md
