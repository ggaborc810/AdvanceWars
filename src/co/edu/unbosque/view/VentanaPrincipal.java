package co.edu.unbosque.view;

import javax.swing.*;

import co.edu.unbosque.model.UnidadDTO;

import java.awt.*;
import java.util.Random;

/**
 * Class that represents the main window of the game "ADVANCE-WARS". This class
 * is responsible for creating and managing the panels and graphical elements of
 * the game's user interface.
 *
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class VentanaPrincipal extends JFrame {
	// FILA Y COLUMNA X
	/**
	 * A matrix of panels representing the game layout.
	 */
	private JPanel[][] matrizPanel;

	/**
	 * The number of rows in the panel matrix.
	 */
	private int fila = 25;

	/**
	 * The number of columns in the panel matrix.
	 */
	private int columna = 43;

	/**
	 * The size of each panel in the matrix.
	 */
	private final int TAMANIO_PANEL = 32;

	/**
	 * The current X coordinate pointer for positioning elements.
	 */
	private int apuntadorX = 0;

	/**
	 * The current Y coordinate pointer for positioning elements.
	 */
	private int apuntadorY = 0;

	/**
	 * The panel representing the game field.
	 */
	private PanelCampo panelCampo;

	/**
	 * The panel for action-related elements in the game.
	 */
	private PanelAccion panelAccion;

	/**
	 * The panel displaying the game map.
	 */
	private PanelMapa panelMapa;

	/**
	 * The welcome panel displayed at the start of the game.
	 */
	private PanelBienvenida jpnBienvenida;

	/**
	 * The panel showing player characteristics.
	 */
	private PanelJugadores jpnCaracteristicas;

	/**
	 * The panel for managing two players.
	 */
	private PanelJugadores2 jpnJugadores2;

	/**
	 * The panel for managing three players.
	 */
	private PanelJugadores3 jpnJugadores3;

	/**
	 * The panel for managing four players.
	 */
	private PanelJugadores4 jpnJugadores4;

	/**
	 * The panel displayed when the game is over.
	 */
	private PanelGameOver jpnGameOver;

	/**
	 * The panel for managing saved game sessions.
	 */
	private PanelPartidas jpnPartidas;

	/**
	 * The panel for handling fights in the game.
	 */
	private PanelPeleas jpnPeleas;

	/**
	 * The panel displayed when the game is paused.
	 */
	private PanelPausa jpnPausa;

	/**
	 * A layered pane for managing overlapping components in the window.
	 */
	private JLayeredPane layeredPane;
	/**
	 * Represents the panel used for displaying the improvement options in the game.
	 */
	private PanelMejoras jpnMejoras;

	/**
	 * Creates a new instance of VentanaPrincipal. Initializes the window with the
	 * title "ADVANCE-WARS", size, and necessary graphical elements.
	 */
	public VentanaPrincipal() {
		setTitle("ADVANCE-WARS");
		setSize(1391, 839);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		jpnBienvenida = new PanelBienvenida();
		jpnBienvenida.setVisible(true);
		jpnCaracteristicas = new PanelJugadores();
		jpnCaracteristicas.setVisible(false);
		jpnJugadores2 = new PanelJugadores2();
		jpnJugadores2.setVisible(false);
		jpnJugadores3 = new PanelJugadores3();
		jpnJugadores3.setVisible(false);
		jpnJugadores4 = new PanelJugadores4();
		jpnJugadores4.setVisible(false);
		jpnGameOver = new PanelGameOver();
		jpnGameOver.setVisible(false);
		jpnPartidas = new PanelPartidas();
		jpnPartidas.setVisible(false);
		jpnMejoras = new PanelMejoras();
		jpnMejoras.setVisible(false);

		add(jpnBienvenida);
		add(jpnPartidas);
		add(jpnCaracteristicas);
		add(jpnJugadores2);
		add(jpnJugadores3);
		add(jpnJugadores4);
		add(jpnGameOver);
	}

	/**
	 * Clears the visibility of all panels in the window.
	 */
	public void limpiarPaneles() {
		if (matrizPanel != null) { // Verifica si matrizPanel no es null
			for (int i = 0; i < matrizPanel.length; i++) {
				for (int j = 0; j < matrizPanel[i].length; j++) {
					if (matrizPanel[i][j] instanceof PanelCampo) {
						PanelCampo panel = (PanelCampo) matrizPanel[i][j];
						panel.removePersonaje(); // Método para remover el JLabel con el GIF
					}
				}
			}
		} else {

		}

		jpnBienvenida.setVisible(false);
		jpnCaracteristicas.setVisible(false);
		jpnJugadores2.setVisible(false);
		jpnJugadores3.setVisible(false);
		jpnJugadores4.setVisible(false);
		jpnGameOver.setVisible(false);
		jpnPartidas.setVisible(false);
		revalidate();
		repaint();
	}

	/**
	 * Initializes a matrix of JPanel objects, each representing a cell in a grid.
	 * The matrix is populated with instances of `PanelCampo`, which are used to
	 * represent individual grid cells.
	 * 
	 * @param filas    The number of rows in the grid.
	 * @param columnas The number of columns in the grid.
	 */
	public void inicializarMatrizPanel(int filas, int columnas) {
		matrizPanel = new JPanel[filas][columnas];
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				matrizPanel[i][j] = new PanelCampo();
			}
		}
	}

	/**
	 * Loads the game into the main window using the provided panel matrix.
	 *
	 * @param matriz The panel matrix representing the game state.
	 */
	public void cargarPartida(JPanel[][] matriz) {
		limpiarJuego();
		matrizPanel = matriz;
		fila = matrizPanel.length;
		columna = matrizPanel[0].length;

		layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1391, 839));

		panelMapa = new PanelMapa();
		panelMapa.setLayout(null);
		panelMapa.setPreferredSize(new Dimension(columna * TAMANIO_PANEL, fila * TAMANIO_PANEL));

		for (int i = 0; i < fila; i++) {
			for (int j = 0; j < columna; j++) {
				panelMapa.add(matrizPanel[i][j]);
			}
		}
		JScrollPane scrollPane = new JScrollPane(panelMapa);
		scrollPane.setBounds(0, 0, 1391, 839);

		jpnPeleas = new PanelPeleas();
		jpnPeleas.setVisible(false);
		jpnPeleas.setBounds(120, 80, 1112, 671);

		panelAccion = new PanelAccion();
		panelAccion.setBounds(510, 130, 320, 500);
		panelAccion.setVisible(false);

		jpnPausa = new PanelPausa();
		jpnPausa.setBounds(510, 130, 320, 500);
		jpnPausa.setVisible(false);

		jpnMejoras = new PanelMejoras();
		jpnMejoras.setBounds(510, 130, 320, 500);
		jpnMejoras.setVisible(false);

		layeredPane.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(jpnPausa, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(panelAccion, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnPeleas, JLayeredPane.PALETTE_LAYER);
		add(layeredPane);

		setFocusable(true);
		actualizarApuntador();
		requestFocusInWindow();
	}

	/**
	 * Clears the game state by hiding all components in the layered panel.
	 */
	public void limpiarJuego() {
		if (layeredPane != null) {
			// Detener la animación de los GIFs
			for (Component comp : layeredPane.getComponents()) {
				if (comp instanceof JLabel) {
					JLabel label = (JLabel) comp;
					if (label.getIcon() instanceof ImageIcon) {
						label.setIcon(null); // Detener la animación del GIF
					}
				}
			}

			for (Component comp : layeredPane.getComponents()) {
				comp.setVisible(false);
			}
			layeredPane.removeAll();
			layeredPane.revalidate();
			layeredPane.repaint();
		}
	}

	/**
	 * Clears the visibility of the welcome and player characteristics panels.
	 */
	public void limpiarVentana() {
		jpnBienvenida.setVisible(false);
		jpnCaracteristicas.setVisible(false);
		jpnJugadores2.setVisible(false);
		jpnJugadores3.setVisible(false);
		jpnJugadores4.setVisible(false);

	}

	/**
	 * Checks if a building at a given location can be captured by a unit from a
	 * specified team. The method checks adjacent panels (up, down, left, right)
	 * from the provided coordinates to determine if any building can be captured by
	 * the unit.
	 * 
	 * If the building is neutral, it is captured and the team color is updated. The
	 * capturing unit gains experience upon successfully capturing the building.
	 * 
	 * @param x                 The x-coordinate of the starting position to check.
	 * @param y                 The y-coordinate of the starting position to check.
	 * @param equipo            The team attempting to capture the building (e.g.,
	 *                          "rojo", "azul").
	 * @param unidadCapturadora The unit attempting to capture the building. This
	 *                          unit gains experience if the capture is successful.
	 */
	public boolean verificarCapturaEdificio(int x, int y, String equipo) {
		System.out.println("Verificando captura de edificio desde (" + x + ", " + y + ")");
		int[][] direcciones = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int[] direccion : direcciones) {
			int nuevoX = x + direccion[0];
			int nuevoY = y + direccion[1];
			System.out.println("entra al for de la funcion");

			if (nuevoY >= 0 && nuevoY < matrizPanel.length && nuevoX >= 0 && nuevoX < matrizPanel[0].length) {
				JPanel panelAdyacente = matrizPanel[nuevoY][nuevoX];
				System.out.println("Revisando panel en (" + nuevoX + ", " + nuevoY + ")");
				if (panelAdyacente instanceof PanelEdificio) {
					PanelEdificio edificio = (PanelEdificio) panelAdyacente;
					System.out.println("Panel en (" + nuevoX + ", " + nuevoY + ") es un edificio de color: "
							+ edificio.getColorActual());

					if (edificio.getColorActual().equals("gris")) {
						System.out.println("El edificio es neutral. Cambiando el color al equipo " + equipo);
						edificio.cambiarColor(equipo);
						System.out.println(
								"Edificio en (" + nuevoX + ", " + nuevoY + ") capturado por el equipo " + equipo);

						return true; // Indicar que el edificio fue capturado
					} else {
						System.out
								.println("El edificio ya fue capturado por otro equipo: " + edificio.getColorActual());
					}
				} else {
					System.out.println("Panel en (" + nuevoX + ", " + nuevoY + ") no es un edificio.");
				}
			}
		}
		return false; // No se capturó un edificio
	}

	/**
	 * Generates a game for two players with the specified characteristics (number
	 * of soldiers, tanks, and planes).
	 *
	 * @param soldados1 Number of soldiers for player 1.
	 * @param tanques1  Number of tanks for player 1.
	 * @param aviones1  Number of planes for player 1.
	 * @param soldados2 Number of soldiers for player 2.
	 * @param tanques2  Number of tanks for player 2.
	 * @param aviones2  Number of planes for player 2.
	 */
	public void generarPartida2Players(int soldados1, int tanques1, int aviones1, int soldados2, int tanques2,
			int aviones2) {
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1600, 900));

		panelMapa = new PanelMapa();
		panelMapa.setLayout(null);
		panelMapa.setPreferredSize(new Dimension(columna * TAMANIO_PANEL, fila * TAMANIO_PANEL));

		matrizPanel = new JPanel[fila][columna];

		Random random = new Random();
		int longitudCamino = 10;
		int contadorCamino = 0;
		boolean puedeAgregarCamino = false;
		int espacioEntreCaminos = 2;

		String[] rutasEdificios = { "resources/images/obstaculos/torreRoja.png",
				"resources/images/obstaculos/torreVerde.png" };

		String[] rutasCasas = { "resources/images/obstaculos/casaRoja.png",
				"resources/images/obstaculos/casaVerde.png" };

		String[] rutasApartamentos = { "resources/images/obstaculos/apartamentoRojo.png",
				"resources/images/obstaculos/apartamentoVerde.png" };

		String[] rutasSoldados = { "resources/images/soldados/soldadoRojo.gif",
				"resources/images/soldados/soldadoVerde.gif" };

		String[] rutasTanques = { "resources/images/tanques/tanqueRojo.gif",
				"resources/images/tanques/tanqueVerde.gif" };

		String[] rutasAviones = { "resources/images/aviones/avionRojo.gif", "resources/images/aviones/avionVerde.gif" };

		// Inicializa la matriz de paneles
		for (int f = 0; f < fila; f++) {
			for (int c = 0; c < columna; c++) {
				matrizPanel[f][c] = new PanelCampo();
				if (random.nextDouble() < 0.03 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5 && f != 4
						&& c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3 && c != 41) {
					matrizPanel[f][c] = new PanelMontana();
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (random.nextDouble() < 0.05 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5
						&& f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3
						&& c != 41) {
					matrizPanel[f][c] = new PanelArbol();
					contadorCamino = 0;
					puedeAgregarCamino = false;
					// CASAS
				} else if (f == 5 && c == 1) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 4 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 20 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 19 && c == 40) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (random.nextDouble() < 0.02 && !esEsquina(f, c) && f != 1 && c != 2 && f != 23 && c != 40
						&& f != 1 && f != 5 && f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4
						&& c != 1 && c != 3 && c != 41) {
					matrizPanel[f][c] = new PanelEdificio("resources/images/obstaculos/torre.png"); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 2) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[0]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 40) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[1]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 1 && c == 3) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[0]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 41) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[1]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (random.nextDouble() < 0.01 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5
						&& f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3
						&& c != 41) {
					matrizPanel[f][c] = new PanelMontanaGrande();
					contadorCamino = 0;
					puedeAgregarCamino = false;
				}

				matrizPanel[f][c].setBounds(c * TAMANIO_PANEL, f * TAMANIO_PANEL, TAMANIO_PANEL, TAMANIO_PANEL);
				panelMapa.add(matrizPanel[f][c]);
			}
		}

		imprimirAvionesRojos(aviones1, rutasAviones[0]);
		imprimirSoldadosRojos(soldados1, rutasSoldados[0]);
		imprimirTanquesRojos(tanques1, rutasTanques[0]);

		imprimirSoldadosVerdes(soldados2, rutasSoldados[1]);
		imprimirTanquesVerdes(tanques2, rutasTanques[1]);
		imprimirAvionesVerdes(aviones2, rutasAviones[1]);

		JScrollPane scrollPane = new JScrollPane(panelMapa);
		scrollPane.setBounds(0, 0, 1391, 839);

		jpnPeleas = new PanelPeleas();
		jpnPeleas.setVisible(false);
		jpnPeleas.setBounds(120, 80, 1112, 671);

		panelAccion = new PanelAccion();
		panelAccion.setBounds(510, 130, 320, 500);
		panelAccion.setVisible(false); // Cambiar a true para verificar la visibilidad

		jpnPausa = new PanelPausa();
		jpnPausa.setBounds(510, 130, 320, 500);
		jpnPausa.setVisible(false);

		jpnMejoras = new PanelMejoras();
		jpnMejoras.setBounds(510, 130, 320, 500);
		jpnMejoras.setVisible(false);
//		layeredPane.add(panelStop, JLayeredPane.PALETTE_LAYER);

		layeredPane.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(panelAccion, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnPeleas, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnPausa, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnMejoras, JLayeredPane.PALETTE_LAYER);
		add(layeredPane);

		// Inicializa el apuntador
		setFocusable(true);
		actualizarApuntador();
		requestFocusInWindow();

	}

	/**
	 * Generates a game map for a three-player match.
	 *
	 * This method initializes the map, creates panels that represent the terrain,
	 * and places each player's units in the specified positions. Mountains, trees,
	 * and buildings are randomly generated on the map. The images of the map
	 * elements are selected according to the specified paths.
	 *
	 * @param soldados1 Number of soldiers for the red player.
	 * @param tanques1  Number of tanks for the red player.
	 * @param aviones1  Number of planes for the red player.
	 * @param soldados2 Number of soldiers for the green player.
	 * @param tanques2  Number of tanks for the green player.
	 * @param aviones2  Number of planes for the green player.
	 * @param soldados3 Number of soldiers for the blue player.
	 * @param tanques3  Number of tanks for the blue player.
	 * @param aviones3  Number of planes for the blue player.
	 */
	public void generarPartida3Players(int soldados1, int tanques1, int aviones1, int soldados2, int tanques2,
			int aviones2, int soldados3, int tanques3, int aviones3) {
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1600, 900));

		panelMapa = new PanelMapa();
		panelMapa.setLayout(null);
		panelMapa.setPreferredSize(new Dimension(columna * TAMANIO_PANEL, fila * TAMANIO_PANEL));

		matrizPanel = new JPanel[fila][columna];
		Random random = new Random();
		int longitudCamino = 10;
		int contadorCamino = 0;
		boolean puedeAgregarCamino = false;
		int espacioEntreCaminos = 2;

		String[] rutasEdificios = { "resources/images/obstaculos/torreRoja.png",
				"resources/images/obstaculos/torreAzul.png", "resources/images/obstaculos/torreVerde.png" };

		String[] rutasCasas = { "resources/images/obstaculos/casaRoja.png", "resources/images/obstaculos/casaAzul.png",
				"resources/images/obstaculos/casaVerde.png" };

		String[] rutasApartamentos = { "resources/images/obstaculos/apartamentoRojo.png",
				"resources/images/obstaculos/apartamentoAzul.png", "resources/images/obstaculos/apartamentoVerde.png" };

		String[] rutasSoldados = { "resources/images/soldados/soldadoRojo.gif",
				"resources/images/soldados/soldadoAzul.gif", "resources/images/soldados/soldadoVerde.gif" };

		String[] rutasTanques = { "resources/images/tanques/tanqueRojo.gif", "resources/images/tanques/tanqueAzul.gif",
				"resources/images/tanques/tanqueVerde.gif" };

		String[] rutasAviones = { "resources/images/aviones/avionRojo.gif", "resources/images/aviones/avionAzul.gif",
				"resources/images/aviones/avionVerde.gif" };

		// Inicializa la matriz de paneles
		for (int f = 0; f < fila; f++) {
			for (int c = 0; c < columna; c++) {
				matrizPanel[f][c] = new PanelCampo();
				if (random.nextDouble() < 0.03 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5 && f != 4
						&& c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3 && c != 41) {
					matrizPanel[f][c] = new PanelMontana();
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (random.nextDouble() < 0.05 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5
						&& f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3
						&& c != 41) {
					matrizPanel[f][c] = new PanelArbol();
					contadorCamino = 0;
					puedeAgregarCamino = false;
					// CASAS
				} else if (f == 5 && c == 1) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 4 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 20 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[2]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[2]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 19 && c == 40) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[2]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 20 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 19 && c == 2) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (random.nextDouble() < 0.02 && !esEsquina(f, c) && f != 1 && c != 2 && f != 23 && c != 40
						&& f != 1 && f != 5 && f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4
						&& c != 1 && c != 3 && c != 41) {
					matrizPanel[f][c] = new PanelEdificio("resources/images/obstaculos/torre.png"); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 2) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[0]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 40) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[2]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 2) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[1]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 1 && c == 3) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[0]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 41) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[2]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 3) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[1]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (random.nextDouble() < 0.01 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5
						&& f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3
						&& c != 41) {
					matrizPanel[f][c] = new PanelMontanaGrande();
					contadorCamino = 0;
					puedeAgregarCamino = false;
				}
				matrizPanel[f][c].setBounds(c * TAMANIO_PANEL, f * TAMANIO_PANEL, TAMANIO_PANEL, TAMANIO_PANEL);
				panelMapa.add(matrizPanel[f][c]);
			}
		}
		imprimirSoldadosRojos(soldados1, rutasSoldados[0]);
		imprimirTanquesRojos(tanques1, rutasTanques[0]);
		imprimirAvionesRojos(aviones1, rutasAviones[0]);

		imprimirSoldadosAzules(soldados3, rutasSoldados[1]);
		imprimirTanquesAzules(tanques3, rutasTanques[1]);
		imprimirAvionesAzules(aviones3, rutasAviones[1]);

		imprimirSoldadosVerdes(soldados2, rutasSoldados[2]);
		imprimirTanquesVerdes(tanques2, rutasTanques[2]);
		imprimirAvionesVerdes(aviones2, rutasAviones[2]);

		JScrollPane scrollPane = new JScrollPane(panelMapa);
		scrollPane.setBounds(0, 0, 1391, 839);

		jpnPeleas = new PanelPeleas();
		jpnPeleas.setVisible(false);
		jpnPeleas.setBounds(120, 80, 1112, 671);

		panelAccion = new PanelAccion();
		panelAccion.setBounds(510, 130, 320, 500);
		panelAccion.setVisible(false);

		jpnPausa = new PanelPausa();
		jpnPausa.setBounds(510, 130, 320, 500);
		jpnPausa.setVisible(false);

		jpnMejoras = new PanelMejoras();
		jpnMejoras.setBounds(510, 130, 320, 500);
		jpnMejoras.setVisible(false);

		layeredPane.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(panelAccion, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnPausa, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnPeleas, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnMejoras, JLayeredPane.PALETTE_LAYER);
		add(layeredPane);

		// Inicializa el apunta dor
		setFocusable(true);
		actualizarApuntador();
		requestFocusInWindow();
	}

	/**
	 * Generates a game map for a four-player match.
	 *
	 * This method initializes the map, creates panels that represent the terrain,
	 * and places each player's units in the specified positions. Mountains, trees,
	 * and buildings are randomly generated on the map. The images of the map
	 * elements are selected according to the specified paths.
	 *
	 * @param soldadosRojo     Number of soldiers for the red player.
	 * @param tanquesRojo      Number of tanks for the red player.
	 * @param avionesRojo      Number of planes for the red player.
	 * @param soldadosVerde    Number of soldiers for the green player.
	 * @param tanquesVerde     Number of tanks for the green player.
	 * @param avionesVerde     Number of planes for the green player.
	 * @param soldadosAzul     Number of soldiers for the blue player.
	 * @param tanquesAzul      Number of tanks for the blue player.
	 * @param avionesAzul      Number of planes for the blue player.
	 * @param soldadosAmarillo Number of soldiers for the yellow player.
	 * @param tanquesAmarillo  Number of tanks for the yellow player.
	 * @param avionesAmarillo  Number of planes for the yellow player.
	 */
	public void generarPartida4Players(int soldadosRojo, int tanquesRojo, int avionesRojo, int soldadosVerde,
			int tanquesVerde, int avionesVerde, int soldadosAzul, int tanquesAzul, int avionesAzul,
			int soldadosAmarillo, int tanquesAmarillo, int avionesAmarillo) {
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setPreferredSize(new Dimension(1600, 900));

		panelMapa = new PanelMapa();
		panelMapa.setLayout(null);
		panelMapa.setPreferredSize(new Dimension(columna * TAMANIO_PANEL, fila * TAMANIO_PANEL));

		matrizPanel = new JPanel[fila][columna];

		Random random = new Random();
		int longitudCamino = 10;
		int contadorCamino = 0;
		boolean puedeAgregarCamino = false;
		int espacioEntreCaminos = 2;

		String[] rutasEdificios = { "resources/images/obstaculos/torreRoja.png", // Esquina superior izquierda
				"resources/images/obstaculos/torreVerde.png", // Esquina superior derecha
				"resources/images/obstaculos/torreAmarilla.png", // Esquina inferior izquierda
				"resources/images/obstaculos/torreAzul.png" // Esquina inferior derecha
		};

		String[] rutasCasas = { "resources/images/obstaculos/casaRoja.png", "resources/images/obstaculos/casaVerde.png",
				"resources/images/obstaculos/casaAmarilla.png", "resources/images/obstaculos/casaAzul.png" };

		String[] rutasApartamentos = { "resources/images/obstaculos/apartamentoRojo.png",
				"resources/images/obstaculos/apartamentoVerde.png",
				"resources/images/obstaculos/apartamentoAmarillo.png",
				"resources/images/obstaculos/apartamentoAzul.png" };

		String[] rutasSoldados = { "resources/images/soldados/soldadoRojo.gif",
				"resources/images/soldados/soldadoAzul.gif", "resources/images/soldados/soldadoVerde.gif",
				"resources/images/soldados/soldadoAmarillo.gif" };

		String[] rutasTanques = { "resources/images/tanques/tanqueRojo.gif", "resources/images/tanques/tanqueAzul.gif",
				"resources/images/tanques/tanqueVerde.gif", "resources/images/tanques/tanqueAmarillo.gif" };

		String[] rutasAviones = { "resources/images/aviones/avionRojo.gif", "resources/images/aviones/avionAzul.gif",
				"resources/images/aviones/avionVerde.gif", "resources/images/aviones/avionAmarillo.gif" };

		// Inicializa la matriz de paneles
		for (int f = 0; f < fila; f++) {
			for (int c = 0; c < columna; c++) {
				matrizPanel[f][c] = new PanelCampo();

				if (random.nextDouble() < 0.03 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5 && f != 4
						&& c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3 && c != 41) {
					matrizPanel[f][c] = new PanelMontana();
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (random.nextDouble() < 0.05 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5
						&& f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3
						&& c != 41) {
					matrizPanel[f][c] = new PanelArbol();
					contadorCamino = 0;
					puedeAgregarCamino = false;
					// CASAS
				} else if (f == 5 && c == 1) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 4 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[0]);
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 20 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 19 && c == 40) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[1]);
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 4 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[2]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 37) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[2]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 5 && c == 40) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[2]);
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 23 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[3]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 20 && c == 5) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[3]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 19 && c == 2) {
					matrizPanel[f][c] = new PanelCasa(rutasCasas[3]);
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (random.nextDouble() < 0.02 && !esEsquina(f, c) && f != 1 && c != 2 && f != 23 && c != 40
						&& f != 1 && f != 5 && f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4
						&& c != 1 && c != 3 && c != 41) {
					matrizPanel[f][c] = new PanelEdificio("resources/images/obstaculos/torre.png"); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 2) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[0]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 40) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[1]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 40) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[2]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 2) {
					matrizPanel[f][c] = new PanelEdificio(rutasEdificios[3]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (f == 1 && c == 3) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[0]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 41) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[1]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 1 && c == 41) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[2]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;
				} else if (f == 23 && c == 3) {
					matrizPanel[f][c] = new PanelApartamento(rutasApartamentos[3]); // Edificio genérico
					contadorCamino = 0;
					puedeAgregarCamino = false;

				} else if (random.nextDouble() < 0.01 && f != 1 && c != 2 && f != 23 && c != 40 && f != 1 && f != 5
						&& f != 4 && c != 4 && c != 5 && f != 19 && c != 37 && f != 20 && f != 4 && c != 1 && c != 3
						&& c != 41) {
					matrizPanel[f][c] = new PanelMontanaGrande();
					contadorCamino = 0;
					puedeAgregarCamino = false;
				}
				matrizPanel[f][c].setBounds(c * TAMANIO_PANEL, f * TAMANIO_PANEL, TAMANIO_PANEL, TAMANIO_PANEL);
				panelMapa.add(matrizPanel[f][c]);
			}
		}

		imprimirSoldadosRojos(soldadosRojo, rutasSoldados[0]);
		imprimirTanquesRojos(tanquesRojo, rutasTanques[0]);
		imprimirAvionesRojos(avionesRojo, rutasAviones[0]);

		imprimirSoldadosAzules(soldadosAzul, rutasSoldados[1]);
		imprimirTanquesAzules(tanquesAzul, rutasTanques[1]);
		imprimirAvionesAzules(avionesAzul, rutasAviones[1]);

		imprimirSoldadosVerdes(soldadosVerde, rutasSoldados[2]);
		imprimirTanquesVerdes(tanquesVerde, rutasTanques[2]);
		imprimirAvionesVerdes(avionesVerde, rutasAviones[2]);

		imprimirAvionesAmarillos(avionesAmarillo, rutasAviones[3]);
		imprimirSoldadosAmarillos(soldadosAmarillo, rutasSoldados[3]);
		imprimirTanquesAmarillos(tanquesAmarillo, rutasTanques[3]);

		JScrollPane scrollPane = new JScrollPane(panelMapa);
		scrollPane.setBounds(0, 0, 1391, 839);

		jpnPeleas = new PanelPeleas();
		jpnPeleas.setVisible(false);
		jpnPeleas.setBounds(120, 80, 1112, 671);

		panelAccion = new PanelAccion();
		panelAccion.setBounds(510, 130, 320, 500);
		panelAccion.setVisible(false);

		jpnPausa = new PanelPausa();
		jpnPausa.setBounds(510, 130, 320, 500);
		jpnPausa.setVisible(false);

		jpnMejoras = new PanelMejoras();
		jpnMejoras.setBounds(510, 130, 320, 500);
		jpnMejoras.setVisible(false);

		layeredPane.add(scrollPane, JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(panelAccion, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnPausa, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnPeleas, JLayeredPane.PALETTE_LAYER);
		layeredPane.add(jpnMejoras, JLayeredPane.PALETTE_LAYER);
		add(layeredPane);

		// Inicializa el apuntador
		setFocusable(true);
		actualizarApuntador();
		requestFocusInWindow();

	}

	/**
	 * Prints blue planes on the map.
	 *
	 * This method places a specific number of planes in the corresponding row of
	 * the map, using the provided URL for the visual representation of the planes.
	 * The planes are placed from left to right in the specified row, in panels that
	 * are instances of PanelCampo.
	 *
	 * @param cantidadAviones the number of planes to print
	 * @param url             the URL of the plane image
	 */
	public void imprimirAvionesAzules(int cantidadAviones, String url) {
		int cont = 0;
		int fila = matrizPanel.length - 4;
		int columnaInicio = 1;

		for (int j = columnaInicio; j < matrizPanel[fila].length; j++) {
			if (cont == cantidadAviones) {
				break;
			}
			if (matrizPanel[fila][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[fila][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints red planes on the map.
	 *
	 * This method places a specific number of planes in the corresponding row of
	 * the map, using the provided URL for the visual representation of the planes.
	 * The planes are placed from left to right in the specified row, in panels that
	 * are instances of PanelCampo.
	 *
	 * @param cantidadAviones the number of planes to print
	 * @param url             the URL of the plane image
	 */
	public void imprimirAvionesRojos(int cantidadAviones, String url) {
		int cont = 0;

		// Cambiar la fila a 2 para colocar los tanques dos filas más abajo
		for (int j = 1; j < columna; j++) {
			if (cont == cantidadAviones) {
				break;
			}
			// Cambiar la fila a 2
			if (matrizPanel[3][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[3][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints yellow planes on the map.
	 *
	 * This method places a specific number of planes in the corresponding row of
	 * the map, using the provided URL for the visual representation of the planes.
	 * The planes are placed from right to left in the specified row, in panels that
	 * are instances of PanelCampo.
	 *
	 * @param cantidadAviones the number of planes to print
	 * @param url             the URL of the plane image
	 */
	public void imprimirAvionesAmarillos(int cantidadAviones, String url) {
		int cont = 0;

		// Empieza desde la última columna (columna - 1) y ve hacia la izquierda
		for (int j = columna - 2; j >= 0; j--) {
			if (cont == cantidadAviones) {
				break;
			}
			// Cambiar la fila a 2
			if (matrizPanel[3][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[3][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints green planes on the map.
	 *
	 * This method places a specific number of planes in the corresponding row of
	 * the map, using the provided URL for the visual representation of the planes.
	 * The planes are placed from right to left in the specified row, in panels that
	 * are instances of PanelCampo.
	 *
	 * @param cantidadAviones the number of planes to print
	 * @param url             the URL of the plane image
	 */
	public void imprimirAvionesVerdes(int cantidadAviones, String url) {
		int cont = 0;
//		 Trabajar con la penúltima fila (fila - 2) y recorrer desde la última columna
//		 (columna - 1) hacia la izquierda
		for (int j = columna - 2; j >= 0; j--) {
			if (cont == cantidadAviones) {
				break;
			}
			if (matrizPanel[fila - 4][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[fila - 4][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints blue tanks on the map.
	 *
	 * This method places a specific number of tanks in the corresponding row of the
	 * map, using the provided URL for the visual representation of the tanks. The
	 * tanks are placed from left to right in the specified row, in panels that are
	 * instances of PanelCampo.
	 *
	 * @param cantidadTanques the number of tanks to print
	 * @param url             the URL of the tank image
	 */
	public void imprimirTanquesAzules(int cantidadTanques, String url) {
		int cont = 0;
		int fila = matrizPanel.length - 3;
		int columnaInicio = 1;

		for (int j = columnaInicio; j < matrizPanel[fila].length; j++) {
			if (cont == cantidadTanques) {
				break;
			}
			if (matrizPanel[fila][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[fila][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints red tanks on the map.
	 *
	 * This method places a specific number of tanks in the corresponding row of the
	 * map, using the provided URL for the visual representation of the tanks. The
	 * tanks are placed from left to right in the specified row, in panels that are
	 * instances of PanelCampo.
	 *
	 * @param cantidadTanques the number of tanks to print
	 * @param url             the URL of the tank image
	 */
	public void imprimirTanquesRojos(int cantidadTanques, String url) {
		int cont = 0;

		// Cambiar la fila a 2 para colocar los tanques dos filas más abajo
		for (int j = 1; j < columna; j++) {
			if (cont == cantidadTanques) {
				break;
			}
			// Cambiar la fila a 2
			if (matrizPanel[2][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[2][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints yellow tanks on the map.
	 *
	 * This method places a specific number of tanks in the corresponding row of the
	 * map, using the provided URL for the visual representation of the tanks. The
	 * tanks are placed from right to left in the specified row, in panels that are
	 * instances of PanelCampo.
	 *
	 * @param cantidadTanques the number of tanks to print
	 * @param url             the URL of the tank image
	 */
	public void imprimirTanquesAmarillos(int cantidadTanques, String url) {
		int cont = 0;

		// Empieza desde la última columna (columna - 1) y ve hacia la izquierda
		for (int j = columna - 2; j >= 0; j--) {
			if (cont == cantidadTanques) {
				break;
			}
			// Cambiar la fila a 2
			if (matrizPanel[2][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[2][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints green tanks on the map.
	 *
	 * This method places a specific number of tanks in the corresponding row of the
	 * map, using the provided URL for the visual representation of the tanks. The
	 * tanks are placed from right to left in the specified row, in panels that are
	 * instances of PanelCampo.
	 *
	 * @param cantidadTanques the number of tanks to print
	 * @param url             the URL of the tank image
	 */
	public void imprimirTanquesVerdes(int cantidadTanques, String url) {
		int cont = 0;

		// Trabajar con la penúltima fila (fila - 2) y recorrer desde la última columna
		// (columna - 1) hacia la izquierda
		for (int j = columna - 2; j >= 0; j--) {
			if (cont == cantidadTanques) {
				break;
			}
			if (matrizPanel[fila - 3][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[fila - 3][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints red soldiers on the map.
	 *
	 * This method places a specific number of soldiers in the corresponding row of
	 * the map, using the provided URL for the visual representation of the
	 * soldiers. The soldiers are placed from left to right in the specified row, in
	 * panels that are instances of PanelCampo.
	 *
	 * @param cantidadSoldados the number of soldiers to print
	 * @param url              the URL of the soldier image
	 */
	public void imprimirSoldadosRojos(int cantidadSoldados, String url) {
		int cont = 0;

		for (int j = 1; j < columna; j++) {
			if (cont == cantidadSoldados) {
				break;
			}
			if (matrizPanel[0][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[0][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints yellow soldiers on the map.
	 *
	 * This method places a specific number of soldiers in the corresponding row of
	 * the map, using the provided URL for the visual representation of the
	 * soldiers. The soldiers are placed from right to left in the specified row, in
	 * panels that are instances of PanelCampo.
	 *
	 * @param cantidadSoldados the number of soldiers to print
	 * @param url              the URL of the soldier image
	 */
	public void imprimirSoldadosAmarillos(int cantidadSoldados, String url) {
		int cont = 0;

		// Empieza desde la última columna (columna - 1) y ve hacia la izquierda
		for (int j = columna - 2; j >= 0; j--) {
			if (cont == cantidadSoldados) {
				break;
			}
			if (matrizPanel[0][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[0][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints green soldiers on the map.
	 *
	 * This method places a specific number of soldiers in the corresponding row of
	 * the map, using the provided URL for the visual representation of the
	 * soldiers. The soldiers are placed from right to left in the specified row, in
	 * panels that are instances of PanelCampo.
	 *
	 * @param cantidadSoldados the number of soldiers to print
	 * @param url              the URL of the soldier image
	 */
	public void imprimirSoldadosVerdes(int cantidadSoldados, String url) {
		int cont = 0;

		// Trabajar con la última fila (fila - 1) y recorrer desde la última columna
		// (columna - 1) hacia la izquierda
		for (int j = columna - 2; j >= 0; j--) {
			if (cont == cantidadSoldados) {
				break;
			}
			if (matrizPanel[fila - 1][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[fila - 1][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Prints blue soldiers on the map.
	 *
	 * This method places a specific number of soldiers in the last row of the map,
	 * using the provided URL for the visual representation of the soldiers. The
	 * soldiers are placed from left to right in the specified row, in panels that
	 * are instances of PanelCampo.
	 *
	 * @param cantidadSoldados the number of soldiers to print
	 * @param url              the URL of the soldier image
	 */
	public void imprimirSoldadosAzules(int cantidadSoldados, String url) {
		int cont = 0;

		// Trabajar con la última fila (fila - 1) y recorrer desde la primera columna
		// hacia la derecha
		for (int j = 1; j < columna; j++) {
			if (cont == cantidadSoldados) {
				break;
			}
			if (matrizPanel[fila - 1][j] instanceof PanelCampo) {
				((PanelCampo) matrizPanel[fila - 1][j]).addPersonaje(url);
				++cont;
			}
		}
	}

	/**
	 * Moves a soldier from one position to another on the map.
	 *
	 * This method moves a soldier from the specified position (posicionSoldadoX,
	 * posicionSoldadoY) to the new position (x, y) on the map. The provided URL is
	 * used for the visual representation of the soldier at the new position.
	 *
	 * @param x                the new X coordinate of the soldier
	 * @param y                the new Y coordinate of the soldier
	 * @param url              the URL of the soldier image
	 * @param posicionSoldadoX the current X coordinate of the soldier
	 * @param posicionSoldadoY the current Y coordinate of the soldier
	 */
	public void moverSoldados(int x, int y, String url, int posicionSoldadoX, int posicionSoldadoY) {
		PanelCampo soldado1 = ((PanelCampo) matrizPanel[posicionSoldadoX][posicionSoldadoY]);
		((PanelCampo) matrizPanel[x][y]).addPersonaje(url);
		soldado1.removePersonaje();
	}

	/**
	 * Updates the pointer on the map.
	 *
	 * This method sets the state of the pointer across all panels on the map,
	 * ensuring that only the panel at the pointer's position is activated.
	 * repaint() is called at the end to reflect the changes visually.
	 */
	public void actualizarApuntador() {
		for (int f = 0; f < fila; f++) {
			for (int c = 0; c < columna; c++) {
				if (matrizPanel[f][c] instanceof PanelCampo) {
					((PanelCampo) matrizPanel[f][c]).setApuntador(false);
				} else if (matrizPanel[f][c] instanceof PanelMontana) {
					((PanelMontana) matrizPanel[f][c]).setApuntador(false);
				} else if (matrizPanel[f][c] instanceof PanelEdificio) {
					((PanelEdificio) matrizPanel[f][c]).setApuntador(false);
				} else if (matrizPanel[f][c] instanceof PanelCamino) {
					((PanelCamino) matrizPanel[f][c]).setApuntador(false);
				} else if (matrizPanel[f][c] instanceof PanelArbol) {
					((PanelArbol) matrizPanel[f][c]).setApuntador(false);
				} else if (matrizPanel[f][c] instanceof PanelCasa) {
					((PanelCasa) matrizPanel[f][c]).setApuntador(false);
				}
			}
		}
		if (matrizPanel[apuntadorY][apuntadorX] instanceof PanelCampo) {
			((PanelCampo) matrizPanel[apuntadorY][apuntadorX]).setApuntador(true);
		} else if (matrizPanel[apuntadorY][apuntadorX] instanceof PanelMontana) {
			((PanelMontana) matrizPanel[apuntadorY][apuntadorX]).setApuntador(true);

		} else if (matrizPanel[apuntadorY][apuntadorX] instanceof PanelEdificio) {
			((PanelEdificio) matrizPanel[apuntadorY][apuntadorX]).setApuntador(true);
		} else if (matrizPanel[apuntadorY][apuntadorX] instanceof PanelCamino) {
			((PanelCamino) matrizPanel[apuntadorY][apuntadorX]).setApuntador(true);
		} else if (matrizPanel[apuntadorY][apuntadorX] instanceof PanelArbol) {
			((PanelArbol) matrizPanel[apuntadorY][apuntadorX]).setApuntador(true);
		} else if (matrizPanel[apuntadorY][apuntadorX] instanceof PanelCasa) {
			((PanelCasa) matrizPanel[apuntadorY][apuntadorX]).setApuntador(true);
		}
		repaint();
	}

	/**
	 * Checks if a specific position is a corner of the map.
	 *
	 * This method determines if the coordinates (f, c) correspond to a corner of
	 * the map. The corners are defined as the positions (0, 0), (0, last column),
	 * (last row, 0), and (last row, last column).
	 *
	 * @param f the row to check
	 * @param c the column to check
	 * @return true if the position is a corner, false otherwise
	 */
	public boolean esEsquina(int f, int c) {
		int filas = matrizPanel.length;
		int columnas = matrizPanel[0].length;
		return (f == 0 && c == 0) || (f == 0 && c == columnas - 1) || (f == filas - 1 && c == 0)
				|| (f == filas - 1 && c == columnas - 1);
	}

	/**
	 * Generates a specific number of rivers on the map.
	 *
	 * This method places rivers in random positions on the map, ensuring that they
	 * do not overlap with other rivers or buildings. A random number generator is
	 * used to determine the location of the rivers.
	 *
	 * @param cantidadRios the number of rivers to generate
	 */
	public void generarRios(int cantidadRios) {
		Random generadorAleatorio = new Random();

		for (int contador = 0; contador < cantidadRios; contador++) {
			int posX = generadorAleatorio.nextInt(columna - 3);
			int posY = generadorAleatorio.nextInt(fila - 3);
			boolean esEspacioValido = true;

			if ((posX < 10 && posY < 10) || (posX > columna - 14 && posY < 10) || (posX < 10 && posY > fila - 14)
					|| (posX > columna - 14 && posY > fila - 14)) {
				esEspacioValido = false;
			}

			for (int filaActual = posY; filaActual < posY + 4 && esEspacioValido; filaActual++) {
				for (int columnaActual = posX; columnaActual < posX + 4 && esEspacioValido; columnaActual++) {
					if (matrizPanel[filaActual][columnaActual] instanceof PanelRio
							|| matrizPanel[filaActual][columnaActual] instanceof PanelEdificio) {
						esEspacioValido = false;
					}
				}
			}

			if (esEspacioValido) {
				for (int filaActual = posY; filaActual < posY + 4; filaActual++) {
					for (int columnaActual = posX; columnaActual < posX + 4; columnaActual++) {
						String imagenRio = fotosRios(filaActual - posY, columnaActual - posX);
						matrizPanel[filaActual][columnaActual] = new PanelRio(imagenRio);
						matrizPanel[filaActual][columnaActual].setBounds(columnaActual * TAMANIO_PANEL,
								filaActual * TAMANIO_PANEL, TAMANIO_PANEL, TAMANIO_PANEL);
						panelMapa.add(matrizPanel[filaActual][columnaActual], 1);
					}
				}
			} else {
				contador--;
			}
		}
	}

	/**
	 * Returns the URL of the river image based on its position in a 4x4 section.
	 *
	 * This method returns the URL corresponding to the river image according to the
	 * provided row and column.
	 *
	 * @param fila    the row of the river image
	 * @param columna the column of the river image
	 * @return the URL of the corresponding river image
	 */
	private String fotosRios(int fila, int columna) {
		if (fila == 0 && columna == 0) {
			return "resources/images/rio/rio1.png";
		} else if (fila == 0 && columna == 3) {
			return "resources/images/rio/rio3.png";
		} else if (fila == 3 && columna == 0) {
			return "resources/images/rio/rio7.png";
		} else if (fila == 3 && columna == 3) {
			return "resources/images/rio/rio9.png";
		} else if (fila == 0) {
			return "resources/images/rio/rio2.png";
		} else if (fila == 3) {
			return "resources/images/rio/rio8.png";
		} else if (columna == 0) {
			return "resources/images/rio/rio4.png";
		} else if (columna == 3) {
			return "resources/images/rio/rio6.png";
		} else {
			return "resources/images/rio/rio5.png";
		}
	}

	/**
	 * Obtains the game field panel.
	 * 
	 * @return the PanelCampo instance.
	 */
	public PanelCampo getPanelCampo() {
		return panelCampo;
	}

	/**
	 * Sets the game field panel.
	 * 
	 * @param panelCampo the PanelCampo instance to set.
	 */
	public void setPanelCampo(PanelCampo panelCampo) {
		this.panelCampo = panelCampo;
	}

	/**
	 * Obtains the matrix of JPanel elements.
	 * 
	 * @return a 2D array of JPanel.
	 */
	public JPanel[][] getMatrizPanel() {
		return matrizPanel;
	}

	/**
	 * Sets the matrix of JPanel elements.
	 * 
	 * @param matrizPanel the 2D array of JPanel to set.
	 */
	public void setMatrizPanel(JPanel[][] matrizPanel) {
		this.matrizPanel = matrizPanel;
	}

	/**
	 * Obtains the X-coordinate of the pointer.
	 * 
	 * @return the X-coordinate of the pointer.
	 */
	public int getApuntadorX() {
		return apuntadorX;
	}

	/**
	 * Sets the X-coordinate of the pointer.
	 * 
	 * @param apuntadorX the X-coordinate to set.
	 */
	public void setApuntadorX(int apuntadorX) {
		this.apuntadorX = apuntadorX;
	}

	/**
	 * Obtains the Y-coordinate of the pointer.
	 * 
	 * @return the Y-coordinate of the pointer.
	 */
	public int getApuntadorY() {
		return apuntadorY;
	}

	/**
	 * Sets the Y-coordinate of the pointer.
	 * 
	 * @param apuntadorY the Y-coordinate to set.
	 */
	public void setApuntadorY(int apuntadorY) {
		this.apuntadorY = apuntadorY;
	}

	/**
	 * Obtains the row of the panel.
	 * 
	 * @return the row value.
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * Obtains the column of the panel.
	 * 
	 * @return the column value.
	 */
	public int getColumna() {
		return columna;
	}

	/**
	 * Obtains the constant panel size.
	 * 
	 * @return the size of the panel.
	 */
	public int getTAMANIO_PANEL() {
		return TAMANIO_PANEL;
	}

	/**
	 * Obtains the map panel.
	 * 
	 * @return the PanelMapa instance.
	 */
	public PanelMapa getPanelMapa() {
		return panelMapa;
	}

	/**
	 * Sets the map panel.
	 * 
	 * @param panelMapa the PanelMapa instance to set.
	 */
	public void setPanelMapa(PanelMapa panelMapa) {
		this.panelMapa = panelMapa;
	}

	/**
	 * Obtains the welcome panel.
	 * 
	 * @return the PanelBienvenida instance.
	 */
	public PanelBienvenida getJpnBienvenida() {
		return jpnBienvenida;
	}

	/**
	 * Sets the welcome panel.
	 * 
	 * @param jpnBienvenida the PanelBienvenida instance to set.
	 */
	public void setJpnBienvenida(PanelBienvenida jpnBienvenida) {
		this.jpnBienvenida = jpnBienvenida;
	}

	/**
	 * Obtains the player characteristics panel.
	 * 
	 * @return the PanelJugadores instance.
	 */
	public PanelJugadores getJpnCaracteristicas() {
		return jpnCaracteristicas;
	}

	/**
	 * Sets the player characteristics panel.
	 * 
	 * @param jpnCaracteristicas the PanelJugadores instance to set.
	 */
	public void setJpnCaracteristicas(PanelJugadores jpnCaracteristicas) {
		this.jpnCaracteristicas = jpnCaracteristicas;
	}

	/**
	 * Obtains the two-player panel.
	 * 
	 * @return the PanelJugadores2 instance.
	 */
	public PanelJugadores2 getJpnJugadores2() {
		return jpnJugadores2;
	}

	/**
	 * Sets the two-player panel.
	 * 
	 * @param jpnJugadores2 the PanelJugadores2 instance to set.
	 */
	public void setJpnJugadores2(PanelJugadores2 jpnJugadores2) {
		this.jpnJugadores2 = jpnJugadores2;
	}

	/**
	 * Obtains the three-player panel.
	 * 
	 * @return the PanelJugadores3 instance.
	 */
	public PanelJugadores3 getJpnJugadores3() {
		return jpnJugadores3;
	}

	/**
	 * Sets the three-player panel.
	 * 
	 * @param jpnJugadores3 the PanelJugadores3 instance to set.
	 */
	public void setJpnJugadores3(PanelJugadores3 jpnJugadores3) {
		this.jpnJugadores3 = jpnJugadores3;
	}

	/**
	 * Obtains the four-player panel.
	 * 
	 * @return the PanelJugadores4 instance.
	 */
	public PanelJugadores4 getJpnJugadores4() {
		return jpnJugadores4;
	}

	/**
	 * Sets the four-player panel.
	 * 
	 * @param jpnJugadores4 the PanelJugadores4 instance to set.
	 */
	public void setJpnJugadores4(PanelJugadores4 jpnJugadores4) {
		this.jpnJugadores4 = jpnJugadores4;
	}

	/**
	 * Obtains the game over panel.
	 * 
	 * @return the PanelGameOver instance.
	 */
	public PanelGameOver getJpnGameOver() {
		return jpnGameOver;
	}

	/**
	 * Sets the game over panel.
	 * 
	 * @param jpnGameOver the PanelGameOver instance to set.
	 */
	public void setJpnGameOver(PanelGameOver jpnGameOver) {
		this.jpnGameOver = jpnGameOver;
	}

	/**
	 * Obtains the matches panel.
	 * 
	 * @return the PanelPartidas instance.
	 */
	public PanelPartidas getJpnPartidas() {
		return jpnPartidas;
	}

	/**
	 * Sets the matches panel.
	 * 
	 * @param jpnPartidas the PanelPartidas instance to set.
	 */
	public void setJpnPartidas(PanelPartidas jpnPartidas) {
		this.jpnPartidas = jpnPartidas;
	}

	/**
	 * Obtains the battles panel.
	 * 
	 * @return the PanelPeleas instance.
	 */
	public PanelPeleas getJpnPeleas() {
		return jpnPeleas;
	}

	/**
	 * Sets the battles panel.
	 * 
	 * @param jpnPeleas the PanelPeleas instance to set.
	 */
	public void setJpnPeleas(PanelPeleas jpnPeleas) {
		this.jpnPeleas = jpnPeleas;
	}

	/**
	 * Obtains the action panel.
	 * 
	 * @return the PanelAccion instance.
	 */
	public PanelAccion getPanelAccion() {
		return panelAccion;
	}

	/**
	 * Sets the action panel.
	 * 
	 * @param panelAccion the PanelAccion instance to set.
	 */
	public void setPanelAccion(PanelAccion panelAccion) {
		this.panelAccion = panelAccion;
	}

	/**
	 * Obtains the pause panel.
	 * 
	 * @return the PanelPausa instance.
	 */
	public PanelPausa getJpnPausa() {
		return jpnPausa;
	}

	/**
	 * Sets the pause panel.
	 * 
	 * @param jpnPausa the PanelPausa instance to set.
	 */
	public void setJpnPausa(PanelPausa jpnPausa) {
		this.jpnPausa = jpnPausa;
	}

	public PanelMejoras getJpnMejoras() {
		return jpnMejoras;
	}

	public void setJpnMejoras(PanelMejoras jpnMejoras) {
		this.jpnMejoras = jpnMejoras;
	}

}