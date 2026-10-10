package co.edu.unbosque.controller;

/**
 * The AplMain class is the entry point of the application. It contains the
 * method main method that initializes the {@link Controller} controller.
 * 
 * This class starts the application by creating an instance of
 * {@link Controller}.
 * 
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class AplMain {
	/**
	 * Método principal de la aplicación.
	 * 
	 * Este método sirve como el punto de entrada para la ejecución del programa. Se
	 * encarga de inicializar un controlador principal y de llamar a su método
	 * `correrGUI`, que lanza la interfaz gráfica de usuario (GUI) y maneja la
	 * lógica inicial de la aplicación.
	 *
	 * Proceso: 1. Se crea una instancia de la clase `Controller`. 2. Se invoca el
	 * método `correrGUI` para iniciar la GUI y las operaciones correspondientes,
	 * como la reproducción de música de fondo.
	 *
	 * Uso: - Este método se ejecuta automáticamente al iniciar la aplicación y es
	 * el punto de partida de toda la lógica del programa.
	 * 
	 * Dependencias: - La clase `Controller` debe estar correctamente implementada
	 * para gestionar la lógica del programa. - El método `correrGUI` de la clase
	 * `Controller` inicializa y ejecuta la GUI de la aplicación.
	 */
	public static void main(String[] args) {
		Controller ctrl = new Controller();
		ctrl.correrGUI();
	}
}