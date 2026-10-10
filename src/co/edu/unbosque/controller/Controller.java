package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.model.PartidaDTO;
import co.edu.unbosque.model.TurnosDTO;
import co.edu.unbosque.model.UnidadDTO;
import co.edu.unbosque.model.persistence.FileHandler;
import co.edu.unbosque.util.structure.MyLinkedList;
import co.edu.unbosque.view.MensajeEmergente;
import co.edu.unbosque.view.PanelCampo;
import co.edu.unbosque.view.ViewFacade;

/**
 * The Controller class handles user interactions with the graphical interface
 * and game logic. graphical interface and game logic. It implements keyboard
 * events and actions on the user interface buttons.
 * 
 * This class coordinates the interactions between the view {@link ViewFacade}
 * and the model {@link ModelFacade}. model {@link ModelFacade}, allowing the
 * manipulation of units and game features through various features of the game
 * through various events such as the keyboard and actions on the buttons.
 * 
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class Controller implements KeyListener, ActionListener {

	/**
	 * View facade that manages the graphical interface.
	 */
	private ViewFacade vf;

	/**
	 * Model facade that manages the business logic.
	 */
	private ModelFacade mf;

	/**
	 * Indicates if a unit is currently moving.
	 */
	private boolean moviendo = false;

	/**
	 * Indicates if a unit is currently shooting.
	 */
	private boolean disparando = false;

	/**
	 * X-coordinate of the selected unit.
	 */
	private int x;

	/**
	 * Y-coordinate of the selected unit.
	 */
	private int y;
	/**
	 * X coordinate of the upper boundary.
	 */
	private int superiorX;

	/**
	 * Y coordinate of the upper boundary.
	 */
	private int superiorY;

	/**
	 * X coordinate of the lower boundary.
	 */
	private int inferiorX;

	/**
	 * Y coordinate of the lower boundary.
	 */
	private int inferiorY;

	/**
	 * Flag that represents the state of the players.
	 */
	private int banderaJugadores;

	/**
	 * Cost of creating a Soldier unit.
	 */
	private static final int PRECIO_SOLDADO = 9;

	/**
	 * Cost of creating a Tank unit.
	 */
	private static final int PRECIO_TANQUE = 11;

	/**
	 * Cost of creating a Plane unit.
	 */
	private static final int PRECIO_AVION = 15;

	/**
	 * Matrix that contains the units in the game.
	 */
	private UnidadDTO[][] matrizUnidades;
	/**
	 * Indicates if the tutorial flag is active.
	 */
	private boolean banderaTutorial = false;

	/**
	 * DTO for managing turns in the game.
	 */
	private TurnosDTO turnos;

	/**
	 * Maximum allowed distance for movements.
	 */
	private int maxDistancia;

	/**
	 * Order of turns for a 2-player game.
	 */
	private List<String> ordenTurnos2Jugadores = new ArrayList<>(Arrays.asList("rojo", "verde"));

	/**
	 * Order of turns for a 3-player game.
	 */
	private List<String> ordenTurnos3Jugadores = new ArrayList<>(Arrays.asList("rojo", "azul", "verde"));

	/**
	 * Order of turns for a 4-player game.
	 */
	private List<String> ordenTurnos4Jugadores = new ArrayList<>(Arrays.asList("rojo", "azul", "verde", "amarillo"));

	/**
	 * Current order of turns, adjusted to the number of players.
	 */
	private List<String> ordenTurnosActual = new ArrayList<>();

	/**
	 * Index of the current turn in the turn order list.
	 */
	private int indiceTurnoActual = 0;

	/**
	 * Maximum number of moves allowed per turn.
	 */
	private int movimientosPorTurno = 3;

	/**
	 * Remaining moves in the current turn.
	 */
	private int movimientosRestantes = movimientosPorTurno;

	/**
	 * Name of the current team playing.
	 */
	private String equipoActual;

	/**
	 * Counter for the tutorial stage.
	 */
	private int contadorTutorial;

	/**
	 * Current round number.
	 */
	private int ronda;
	/**
	 * Represents the currently selected unit in the game.
	 */
	private UnidadDTO unidadSeleccionada;
	/**
	 * Indicates whether the game has ended.
	 */
	private boolean juegoTerminado = false;

	/**
	 * Controller class constructor. It initializes the view and the model, assigns
	 * listeners to the GUI components and displays the main window. main window.
	 */
	public Controller() {
		vf = ViewFacade.getInstance();
		vf = new ViewFacade();
		mf = ModelFacade.getInstance();
		asignarOyentes();
		ronda = 0;
		turnos = new TurnosDTO();
		vf.getVen().addKeyListener(this);
		vf.getVen().setVisible(true);

	}

	/**
	 * Assigns listeners to buttons and other GUI components. GUI components.
	 * Defines the actions to execute when the buttons are * pressed. pressed.
	 */
	private void asignarOyentes() {
		vf.getVen().getJpnBienvenida().getBtnStart().addActionListener(this);
		vf.getVen().getJpnBienvenida().getBtnExit().addActionListener(this);
		vf.getVen().getJpnBienvenida().getBtntuto().addActionListener(this);

		vf.getVen().getJpnPartidas().getBtnBack().addActionListener(this);

		vf.getVen().getJpnCaracteristicas().getBtnBack().addActionListener(this);
		vf.getVen().getJpnCaracteristicas().getBtn2().addActionListener(this);
		vf.getVen().getJpnCaracteristicas().getBtn3().addActionListener(this);
		vf.getVen().getJpnCaracteristicas().getBtn4().addActionListener(this);
		vf.getVen().getJpnJugadores2().getBtnBack().addActionListener(this);
		vf.getVen().getJpnJugadores3().getBtnBack().addActionListener(this);
		vf.getVen().getJpnJugadores4().getBtnBack().addActionListener(this);
		vf.getVen().getJpnJugadores4().getBtnOk().addActionListener(this);
		vf.getVen().getJpnJugadores3().getBtnOk().addActionListener(this);
		vf.getVen().getJpnJugadores2().getBtnOk().addActionListener(this);
		vf.getVen().getJpnBienvenida().getBtnPartidas().addActionListener(this);
		vf.getVen().getJpnGameOver().getBtnCerrar().addActionListener(this);

		// ***************************************************************************************//

		vf.getVen().getJpnBienvenida().getBtnStart().setActionCommand("iniciar");
		vf.getVen().getJpnBienvenida().getBtnExit().setActionCommand("Salir");
		vf.getVen().getJpnBienvenida().getBtntuto().setActionCommand("tutorial");
		vf.getVen().getJpnPartidas().getBtnBack().setActionCommand("volverBienvenida");
		vf.getVen().getJpnCaracteristicas().getBtnBack().setActionCommand("volver");

		vf.getVen().getJpnCaracteristicas().getBtn2().setActionCommand("jugadores2");
		vf.getVen().getJpnCaracteristicas().getBtn3().setActionCommand("jugadores3");
		vf.getVen().getJpnCaracteristicas().getBtn4().setActionCommand("jugadores4");
		vf.getVen().getJpnJugadores2().getBtnBack().setActionCommand("volverJugadores");
		vf.getVen().getJpnJugadores4().getBtnBack().setActionCommand("volver4Jugadores");
		vf.getVen().getJpnJugadores2().getBtnOk().setActionCommand("correr2jugadores");
		vf.getVen().getJpnJugadores3().getBtnOk().setActionCommand("correr3jugadores");
		vf.getVen().getJpnJugadores3().getBtnBack().setActionCommand("volver3Jugadores");
		vf.getVen().getJpnJugadores4().getBtnOk().setActionCommand("correr4jugadores");
		vf.getVen().getJpnBienvenida().getBtnPartidas().setActionCommand("cargar partida");
		vf.getVen().getJpnGameOver().getBtnCerrar().setActionCommand("volver Game Over");
		// --2 jugadores Rojos y verde-----------
		// rojo
		vf.getVen().getJpnJugadores2().getBtnAgregarSoldadoRojoMas()
				.addActionListener(e -> agregarUnidad2Jugadores(PRECIO_SOLDADO, 1, "soldadoRojo"));
		vf.getVen().getJpnJugadores2().getBtnAgregarSoldadoRojoMenos()
				.addActionListener(e -> quitarUnidad2Jugadores(PRECIO_SOLDADO, 1, "soldadoRojo"));
		vf.getVen().getJpnJugadores2().getBtnAgregarTanqueRojoMas()
				.addActionListener(e -> agregarUnidad2Jugadores(PRECIO_TANQUE, 1, "tanqueRojo"));
		vf.getVen().getJpnJugadores2().getBtnAgregarTanqueRojoMenos()
				.addActionListener(e -> quitarUnidad2Jugadores(PRECIO_TANQUE, 1, "tanqueRojo"));
		vf.getVen().getJpnJugadores2().getBtnAgregarAvionRojoMas()
				.addActionListener(e -> agregarUnidad2Jugadores(PRECIO_AVION, 1, "avionRojo"));
		vf.getVen().getJpnJugadores2().getBtnAgregarAvionRojoMenos()
				.addActionListener(e -> quitarUnidad2Jugadores(PRECIO_AVION, 1, "avionRojo"));
		// verde
		vf.getVen().getJpnJugadores2().getBtnAgregarSoldadoVerdeMas()
				.addActionListener(e -> agregarUnidad2Jugadores(PRECIO_SOLDADO, 2, "soldadoVerde"));
		vf.getVen().getJpnJugadores2().getBtnAgregarSoldadoVerdeMenos()
				.addActionListener(e -> quitarUnidad2Jugadores(PRECIO_SOLDADO, 2, "soldadoVerde"));
		vf.getVen().getJpnJugadores2().getBtnAgregarTanqueVerdeMas()
				.addActionListener(e -> agregarUnidad2Jugadores(PRECIO_TANQUE, 2, "tanqueVerde"));
		vf.getVen().getJpnJugadores2().getBtnAgregarTanqueVerdeMenos()
				.addActionListener(e -> quitarUnidad2Jugadores(PRECIO_TANQUE, 2, "tanqueVerde"));
		vf.getVen().getJpnJugadores2().getBtnAgregarAvionVerdeMas()
				.addActionListener(e -> agregarUnidad2Jugadores(PRECIO_AVION, 2, "avionVerde"));
		vf.getVen().getJpnJugadores2().getBtnAgregarAvionVerdeMenos()
				.addActionListener(e -> quitarUnidad2Jugadores(PRECIO_AVION, 2, "avionVerde"));

		// -----3 jugadores Rojos, verde y azul----
		// rojo
		vf.getVen().getJpnJugadores3().getBtnAgregarSoldadoRojoMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_SOLDADO, 1, "soldadoRojo"));
		vf.getVen().getJpnJugadores3().getBtnAgregarSoldadoRojoMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_SOLDADO, 1, "soldadoRojo"));
		vf.getVen().getJpnJugadores3().getBtnAgregarTanqueRojoMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_TANQUE, 1, "tanqueRojo"));
		vf.getVen().getJpnJugadores3().getBtnAgregarTanqueRojoMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_TANQUE, 1, "tanqueRojo"));
		vf.getVen().getJpnJugadores3().getBtnAgregarAvionRojoMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_AVION, 1, "avionRojo"));
		vf.getVen().getJpnJugadores3().getBtnAgregarAvionRojoMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_AVION, 1, "avionRojo"));
		// verde
		vf.getVen().getJpnJugadores3().getBtnAgregarSoldadoVerdeMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_SOLDADO, 2, "soldadoVerde"));
		vf.getVen().getJpnJugadores3().getBtnAgregarSoldadoVerdeMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_SOLDADO, 2, "soldadoVerde"));
		vf.getVen().getJpnJugadores3().getBtnAgregarTanqueVerdeMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_TANQUE, 2, "tanqueVerde"));
		vf.getVen().getJpnJugadores3().getBtnAgregarTanqueVerdeMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_TANQUE, 2, "tanqueVerde"));
		vf.getVen().getJpnJugadores3().getBtnAgregarAvionVerdeMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_AVION, 2, "avionVerde"));
		vf.getVen().getJpnJugadores3().getBtnAgregarAvionVerdeMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_AVION, 2, "avionVerde"));
		// azul
		vf.getVen().getJpnJugadores3().getBtnAgregarSoldadoAzulMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_SOLDADO, 3, "soldadoAzul"));
		vf.getVen().getJpnJugadores3().getBtnAgregarSoldadoAzulMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_SOLDADO, 3, "soldadoAzul"));
		vf.getVen().getJpnJugadores3().getBtnAgregarTanqueAzulMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_TANQUE, 3, "tanqueAzul"));
		vf.getVen().getJpnJugadores3().getBtnAgregarTanqueAzulMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_TANQUE, 3, "tanqueAzul"));
		vf.getVen().getJpnJugadores3().getBtnAgregarAvionAzulMas()
				.addActionListener(e -> agregarUnidad3Jugadores(PRECIO_AVION, 3, "avionAzul"));
		vf.getVen().getJpnJugadores3().getBtnAgregarAvionAzulMenos()
				.addActionListener(e -> quitarUnidad3Jugadores(PRECIO_AVION, 3, "avionAzul"));

		// -----4 jugadores Rojos, verde, azul y amarillo----

		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoRojoMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_SOLDADO, 1, "soldadoRojo"));

		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoRojoMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_SOLDADO, 1, "soldadoRojo"));

		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueRojoMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_TANQUE, 1, "tanqueRojo"));
		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueRojoMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_TANQUE, 1, "tanqueRojo"));

		vf.getVen().getJpnJugadores4().getBtnAgregarAvionRojoMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_AVION, 1, "avionRojo"));
		vf.getVen().getJpnJugadores4().getBtnAgregarAvionRojoMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_AVION, 1, "avionRojo"));

		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoVerdeMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_SOLDADO, 2, "soldadoVerde"));
		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoVerdeMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_SOLDADO, 2, "soldadoVerde"));

		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueVerdeMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_TANQUE, 2, "tanqueVerde"));
		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueVerdeMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_TANQUE, 2, "tanqueVerde"));

		vf.getVen().getJpnJugadores4().getBtnAgregarAvionVerdeMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_AVION, 2, "avionVerde"));
		vf.getVen().getJpnJugadores4().getBtnAgregarAvionVerdeMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_AVION, 2, "avionVerde"));

//-------------------------------------Azules--------------------------------------------------------------------------------------

		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoAzulMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_SOLDADO, 3, "soldadoAzul"));
		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoAzulMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_SOLDADO, 3, "soldadoAzul"));

		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueAzulMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_TANQUE, 3, "tanqueAzul"));
		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueAzulMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_TANQUE, 3, "tanqueAzul"));

		vf.getVen().getJpnJugadores4().getBtnAgregarAvionAzulMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_AVION, 3, "avionAzul"));
		vf.getVen().getJpnJugadores4().getBtnAgregarAvionAzulMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_AVION, 3, "avionAzul"));

//----------------------------------------------Amarillo--------------------------------------------------
		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoAmarilloMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_SOLDADO, 4, "soldadoAmarillo"));
		vf.getVen().getJpnJugadores4().getBtnAgregarSoldadoAmarilloMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_SOLDADO, 4, "soldadoAmarillo"));
		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueAmarilloMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_TANQUE, 4, "tanqueAmarillo"));
		vf.getVen().getJpnJugadores4().getBtnAgregarTanqueAmarilloMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_TANQUE, 4, "tanqueAmarillo"));
		vf.getVen().getJpnJugadores4().getBtnAgregarAvionAmarilloMas()
				.addActionListener(e -> agregarUnidad4Jugadores(PRECIO_AVION, 4, "avionAmarillo"));
		vf.getVen().getJpnJugadores4().getBtnAgregarAvionAmarilloMenos()
				.addActionListener(e -> quitarUnidad4Jugadores(PRECIO_AVION, 4, "avionAmarillo"));

	}

	/**
	 * Adds a unit to the selected player if he has enough money. Updates the number
	 * of units and the player's remaining money.
	 * 
	 * @param price    The price of the unit you want to add.
	 * @param player   The number of the player (1, 2 or 3) to which the unit is to
	 *                 be added.
	 * @param unit.
	 * @param unittype The type of unit to be added (e.g., “soldierRed”, “tankRed”,
	 *                 “planeRed”, “soldierGreen”, “tankGreen”, “planeGreen”,
	 *                 “soldierBlue”, “tankBlue”, “planeBlue”).
	 */
	public void agregarUnidad2Jugadores(int precio, int jugador, String tipoUnidad) {
		try {
			int precioActual;

			if (jugador == 1) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblDinero().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores2().getLblDinero().setText(String.valueOf(precioActual));

					switch (tipoUnidad) {
					case "soldadoRojo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblSoldadoRojo().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores2().getLblSoldadoRojo().setText(String.valueOf(soldadosActuales));
						break;
					case "tanqueRojo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblTanqueRojo().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores2().getLblTanqueRojo().setText(String.valueOf(tanquesActuales));
						break;
					case "avionRojo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblAvionRojo().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores2().getLblAvionRojo().setText(String.valueOf(avionesActuales));
						break;
					}
					vf.getVen().getJpnJugadores2().revalidate();
					vf.getVen().getJpnJugadores2().repaint();
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 1 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			} else if (jugador == 2) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblDinero2().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores2().getLblDinero2().setText(String.valueOf(precioActual));

					switch (tipoUnidad) {
					case "soldadoVerde":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblSoldadoVerde().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores2().getLblSoldadoVerde().setText(String.valueOf(soldadosActuales));

						break;
					case "tanqueVerde":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblTanqueVerde().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores2().getLblTanqueVerde().setText(String.valueOf(tanquesActuales));

						break;
					case "avionVerde":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblAvionVerde().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores2().getLblAvionVerde().setText(String.valueOf(avionesActuales));
						break;
					}
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 2 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			}

			vf.getVen().getJpnJugadores2().repaint();

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Error al obtener el valor del dinero. Asegúrate de que el valor sea un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Removes one unit from the selected player and returns the corresponding money
	 * to the player corresponding money, as long as the resulting money does not
	 * exceed the maximum allowed (50 coins). allowed (50 coins).
	 * 
	 * @param price    The price of the unit to be removed.
	 * @param player   The number of the player (1, 2 or 3) from whom the unit is to
	 *                 be * removed.
	 * @param unit.
	 * @param unittype The type of unit to be removed (e.g., “soldierRed”,
	 *                 “tankRed”, “planeRed”, “soldierGreen”, “tankGreen”,
	 *                 “planeGreen”, “soldierBlue”, “tankBlue”, “planeBlue”).
	 */
	public void quitarUnidad2Jugadores(int precio, int jugador, String tipoUnidad) {
		try {
			int precioActual;

			if (jugador == 1) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblDinero().getText());
				if (precioActual + precio <= 50) {
					switch (tipoUnidad) {
					case "soldadoRojo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblSoldadoRojo().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores2().getLblSoldadoRojo()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueRojo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblTanqueRojo().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores2().getLblTanqueRojo().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionRojo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblAvionRojo().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores2().getLblAvionRojo().setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores2().getLblDinero().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores2().revalidate();
					vf.getVen().getJpnJugadores2().repaint();
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 1 no puede tener más de 50 monedas.", 180, 42, 500, 50);

				}
			} else if (jugador == 2) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblDinero2().getText());
				if (precioActual + precio <= 50) {
					switch (tipoUnidad) {
					case "soldadoVerde":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblSoldadoVerde().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores2().getLblSoldadoVerde()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueVerde":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblTanqueVerde().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores2().getLblTanqueVerde().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionVerde":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores2().getLblAvionVerde().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores2().getLblAvionVerde().setText(String.valueOf(avionesActuales));
						} else {

							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores2().getLblDinero2().setText(String.valueOf(precioActual));
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 2 no puede tener más de 50 monedas.", 180, 42, 500, 50);
					return;
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Error al obtener el valor del dinero. Asegúrate de que el valor sea un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Adds a unit to the selected player (in a 3-player game) if he/she has enough
	 * money. Updates the number of units and the player's remaining player's
	 * remaining money.
	 * 
	 * @param price    The price of the unit you want to add.
	 * @param player   The number of the player (1, 2 or 3) to which the unit is to
	 *                 be added.
	 * @param unit.
	 * @param unittype The type of unit to be added (e.g., “soldierRed”, “tankRed”,
	 *                 “planeRed”, “soldierGreen”, “tankGreen”, “planeGreen”,
	 *                 “soldierBlue”, “tankBlue”, “planeBlue”).
	 */
	public void agregarUnidad3Jugadores(int precio, int jugador, String tipoUnidad) {
		try {
			int precioActual;
			if (jugador == 1) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores3().getLblDinero().setText(String.valueOf(precioActual));
					switch (tipoUnidad) {
					case "soldadoRojo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoRojo().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores3().getLblSoldadoRojo().setText(String.valueOf(soldadosActuales));
						break;
					case "tanqueRojo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueRojo().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores3().getLblTanqueRojo().setText(String.valueOf(tanquesActuales));
						break;
					case "avionRojo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblAvionRojo().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores3().getLblAvionRojo().setText(String.valueOf(avionesActuales));
						break;
					}
					vf.getVen().getJpnJugadores3().revalidate();
					vf.getVen().getJpnJugadores3().repaint();
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 1 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			} else if (jugador == 2) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero3().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores3().getLblDinero3().setText(String.valueOf(precioActual));
					switch (tipoUnidad) {
					case "soldadoVerde":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoVerde().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores3().getLblSoldadoVerde().setText(String.valueOf(soldadosActuales));

						break;
					case "tanqueVerde":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueVerde().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores3().getLblTanqueVerde().setText(String.valueOf(tanquesActuales));

						break;
					case "avionVerde":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblAvionVerde().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores3().getLblAvionVerde().setText(String.valueOf(avionesActuales));
						break;
					}
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 2 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			} else if (jugador == 3) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero2().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores3().getLblDinero2().setText(String.valueOf(precioActual));
					switch (tipoUnidad) {
					case "soldadoAzul":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoAzul().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores3().getLblSoldadoAzul().setText(String.valueOf(soldadosActuales));

						break;
					case "tanqueAzul":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueAzul().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores3().getLblTanqueAzul().setText(String.valueOf(tanquesActuales));

						break;
					case "avionAzul":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblAvionAzul().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores3().getLblAvionAzul().setText(String.valueOf(avionesActuales));
						break;
					}
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 3 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			}
			vf.getVen().getJpnJugadores3().repaint();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Error al obtener el valor del dinero. Asegúrate de que el valor sea un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Remove one unit from players in a three-player game and update the money.
	 * 
	 * @param price  The price of the unit to remove.
	 * @param player The player's number (1, 2 or 3). Unit type The type of unit to
	 *               remove (“soldierRed”, “tankRed”, “airplaneRed”, “soldierGreen”,
	 *               “tankGreen”, “airplaneGreen”, “soldierBlue”, “tankBlue”,
	 *               “planeBlue”).
	 */
	public void quitarUnidad3Jugadores(int precio, int jugador, String tipoUnidad) {
		try {
			int precioActual;

			if (jugador == 1) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero().getText());
				if (precioActual + precio <= 50) {

					switch (tipoUnidad) {
					case "soldadoRojo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoRojo().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblSoldadoRojo()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueRojo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueRojo().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblTanqueRojo().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionRojo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblAvionRojo().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblAvionRojo().setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores3().getLblDinero().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores3().revalidate();
					vf.getVen().getJpnJugadores3().repaint();

				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 1 no puede tener más de 50 monedas.", 180, 42, 500, 50);
				}

			} else if (jugador == 2) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero3().getText());
				if (precioActual + precio <= 50) {

					switch (tipoUnidad) {
					case "soldadoVerde":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoVerde().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblSoldadoVerde()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueVerde":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueVerde().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblTanqueVerde().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionVerde":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblAvionVerde().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblAvionVerde().setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores3().getLblDinero3().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores3().revalidate();
					vf.getVen().getJpnJugadores3().repaint();

				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 2 no puede tener más de 50 monedas.", 180, 42, 500, 50);
				}

			} else if (jugador == 3) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero2().getText());
				if (precioActual + precio <= 50) {

					switch (tipoUnidad) {
					case "soldadoAzul":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoAzul().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblSoldadoAzul()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueAzul":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueAzul().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblTanqueAzul().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionAzul":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores3().getLblAvionAzul().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores3().getLblAvionAzul().setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores3().getLblDinero2().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores3().revalidate();
					vf.getVen().getJpnJugadores3().repaint();

				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 3 no puede tener más de 50 monedas.", 180, 42, 500, 50);
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Error al obtener el valor del dinero. Asegúrate de que el valor sea un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Custom exception class to handle cases where text is empty or contains only
	 * whitespace. This exception is thrown to signal that a required text field has
	 * been left blank.
	 */
	private static class TextoVacioException extends RuntimeException {
		/**
		 * Constructs a new TextoVacioException with a specified error message.
		 *
		 * @param message the detail message explaining the cause of the exception
		 */
		public TextoVacioException(String mensaje) {
			super(mensaje);
		}
	}

	/**
	 * Checks if the provided text is null, empty, or contains only whitespace. If
	 * any of these conditions are met, a TextoVacioException is thrown with an
	 * error message.
	 *
	 * @param text the text to be validated
	 * @throws TextoVacioException if the text is null, empty, or contains only
	 *                             whitespace
	 */
	public static void revisarEspacioBlanco(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			throw new TextoVacioException("El nombre de la partida no puede estar vacío.");
		}
	}

	/**
	 * Add one unit to the players in a four-player game and Upgrade the money.
	 * 
	 * @param price    The price of the unit to add.
	 * @param player   The number of the player (1, 2, 3 or 4).
	 * @param unittype The type of unit to add (“soldierRed”, “tankRed”,
	 *                 “airplaneRed”, “soldierGreen”, “tankGreen”, “airplaneGreen”,
	 *                 “soldierBlue”, “tankBlue”, “planeBlue”, “soldierYellow”,
	 *                 “tankYellow”, “planeYellow”).
	 */
	public void agregarUnidad4Jugadores(int precio, int jugador, String tipoUnidad) {
		try {
			int precioActual;

			if (jugador == 1) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores4().getLblDinero().setText(String.valueOf(precioActual));
					switch (tipoUnidad) {
					case "soldadoRojo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoRojo().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores4().getLblSoldadoRojo().setText(String.valueOf(soldadosActuales));
						break;
					case "tanqueRojo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueRojo().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores4().getLblTanqueRojo().setText(String.valueOf(tanquesActuales));
						break;
					case "avionRojo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionRojo().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores4().getLblAvionRojo().setText(String.valueOf(avionesActuales));
						break;
					}

					vf.getVen().getJpnJugadores4().revalidate();
					vf.getVen().getJpnJugadores4().repaint();
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 1 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			} else if (jugador == 2) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero3().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores4().getLblDinero3().setText(String.valueOf(precioActual));
					switch (tipoUnidad) {
					case "soldadoVerde":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoVerde().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores4().getLblSoldadoVerde().setText(String.valueOf(soldadosActuales));

						break;
					case "tanqueVerde":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueVerde().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores4().getLblTanqueVerde().setText(String.valueOf(tanquesActuales));

						break;
					case "avionVerde":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionVerde().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores4().getLblAvionVerde().setText(String.valueOf(avionesActuales));
						break;
					}
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 2 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			} else if (jugador == 3) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero2().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores4().getLblDinero2().setText(String.valueOf(precioActual));
					switch (tipoUnidad) {
					case "soldadoAzul":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoAzul().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores4().getLblSoldadoAzul().setText(String.valueOf(soldadosActuales));

						break;
					case "tanqueAzul":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueAzul().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores4().getLblTanqueAzul().setText(String.valueOf(tanquesActuales));

						break;
					case "avionAzul":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionAzul().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores4().getLblAvionAzul().setText(String.valueOf(avionesActuales));
						break;
					}
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 3 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			} else if (jugador == 4) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero4().getText());
				if (precioActual >= precio) {
					precioActual -= precio;
					vf.getVen().getJpnJugadores4().getLblDinero4().setText(String.valueOf(precioActual));
					switch (tipoUnidad) {
					case "soldadoAmarillo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoAmarillo().getText());
						soldadosActuales++;
						vf.getVen().getJpnJugadores4().getLblSoldadoAmarillo()
								.setText(String.valueOf(soldadosActuales));
						break;
					case "tanqueAmarillo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueAmarillo().getText());
						tanquesActuales++;
						vf.getVen().getJpnJugadores4().getLblTanqueAmarillo().setText(String.valueOf(tanquesActuales));

						break;
					case "avionAmarillo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionAmarillo().getText());
						avionesActuales++;
						vf.getVen().getJpnJugadores4().getLblAvionAmarillo().setText(String.valueOf(avionesActuales));
						break;
					}
				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 4 no tiene suficiente dinero para esta operación.", 180, 42, 500, 50);
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Error al obtener el valor del dinero. Asegúrate de que el valor sea un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Remove one unit from the players in a four-player game and Upgrade the money.
	 * 
	 * @param price    The price of the unit to remove.
	 * @param player   The player's number (1, 2, 3 or 4).
	 * @param unittype The type of unit to remove (“soldierRed”, “tankRed”,
	 *                 “airplaneRed”, “soldierGreen”, “tankGreen”, “airplaneGreen”,
	 *                 “soldierBlue”, “tankBlue”, “planeBlue”, “soldierYellow”,
	 *                 “tankYellow”, “planeYellow”).
	 */
	public void quitarUnidad4Jugadores(int precio, int jugador, String tipoUnidad) {
		try {
			int precioActual;

			if (jugador == 1) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero().getText());
				if (precioActual + precio <= 50) {
					switch (tipoUnidad) {
					case "soldadoRojo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoRojo().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblSoldadoRojo()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueRojo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueRojo().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblTanqueRojo().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionRojo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionRojo().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblAvionRojo().setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores4().getLblDinero().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores4().revalidate();
					vf.getVen().getJpnJugadores4().repaint();

				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 1 no puede tener más de 50 monedas.", 180, 42, 500, 50);
				}

			} else if (jugador == 2) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero3().getText());
				if (precioActual + precio <= 50) {
					switch (tipoUnidad) {
					case "soldadoVerde":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoVerde().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblSoldadoVerde()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueVerde":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueVerde().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblTanqueVerde().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionVerde":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionVerde().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblAvionVerde().setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores4().getLblDinero3().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores4().revalidate();
					vf.getVen().getJpnJugadores4().repaint();

				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 2 no puede tener más de 50 monedas.", 180, 42, 500, 50);
				}

			} else if (jugador == 3) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero2().getText());
				if (precioActual + precio <= 50) {
					switch (tipoUnidad) {
					case "soldadoAzul":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoAzul().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblSoldadoAzul()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueAzul":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueAzul().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblTanqueAzul().setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionAzul":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionAzul().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblAvionAzul().setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores4().getLblDinero2().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores4().revalidate();
					vf.getVen().getJpnJugadores4().repaint();

				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 3 no puede tener más de 50 monedas.", 180, 42, 500, 50);
				}

			} else if (jugador == 4) {
				precioActual = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero4().getText());
				if (precioActual + precio <= 50) {
					switch (tipoUnidad) {
					case "soldadoAmarillo":
						int soldadosActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoAmarillo().getText());
						if (soldadosActuales > 0) {
							soldadosActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblSoldadoAmarillo()
									.setText(String.valueOf(soldadosActuales));
						} else {
							return;
						}
						break;
					case "tanqueAmarillo":
						int tanquesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueAmarillo().getText());
						if (tanquesActuales > 0) {
							tanquesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblTanqueAmarillo()
									.setText(String.valueOf(tanquesActuales));
						} else {
							return;
						}
						break;
					case "avionAmarillo":
						int avionesActuales = Integer
								.parseInt(vf.getVen().getJpnJugadores4().getLblAvionAmarillo().getText());
						if (avionesActuales > 0) {
							avionesActuales--;
							precioActual += precio;
							vf.getVen().getJpnJugadores4().getLblAvionAmarillo()
									.setText(String.valueOf(avionesActuales));
						} else {
							return;
						}
						break;
					}
					vf.getVen().getJpnJugadores4().getLblDinero4().setText(String.valueOf(precioActual));
					vf.getVen().getJpnJugadores4().revalidate();
					vf.getVen().getJpnJugadores4().repaint();

				} else {
					MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
							"Jugador 4 no puede tener más de 50 monedas.", 180, 42, 500, 50);
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null,
					"Error al obtener el valor del dinero. Asegúrate de que el valor sea un número válido.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Determines the maximum health for a unit based on its type. This method uses
	 * a switch statement to return predefined maximum health values depending on
	 * whether the unit is a soldier, tank, or plane.
	 *
	 * @param unit the {@link UnidadDTO} object representing the unit whose maximum
	 *             health is to be obtained
	 * @return the maximum health for the unit based on its type; returns 0 if the
	 *         type is unrecognized
	 */
	private int obtenerVidaMaximaPorTipo(UnidadDTO unidad) {
		switch (unidad.getTipo()) {
		case "soldado":
			return 5;
		case "tanque":
			return 10;
		case "avion":
			return 15;
		default:
			return 0;
		}
	}

	/**
	 * Executes an attack between an attacking and defending unit, applying damage
	 * based on their types. If the units belong to the same team, the attack is
	 * canceled. The method calculates and applies attack and counterattack damage,
	 * removing units from the board if their health reaches zero.
	 * 
	 * Includes debug messages with details about unit types, teams, and remaining
	 * health.
	 */
	public void disparar() {
		if (disparando) {
			if (verificarFinDeJuego()) {
				return;
			}
			int origenX = x;
			int origenY = y;
			int x = vf.getVen().getApuntadorX();
			int y = vf.getVen().getApuntadorY();

			UnidadDTO atacante = matrizUnidades[origenY][origenX];
			UnidadDTO defensor = matrizUnidades[y][x];

			if (atacante == null) {
				disparando = false;
				return;
			}

			int distancia = Math.abs(origenX - x) + Math.abs(origenY - y);
			int rangoDisparo;
			switch (atacante.getTipo()) {
			case "soldado":
				rangoDisparo = 2;
				break;
			case "tanque":
				rangoDisparo = 3;
				break;
			case "avion":
				rangoDisparo = 5;
				break;
			default:
				disparando = false;
				return;
			}

			if (distancia > rangoDisparo) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/7.png");
				disparando = false;
				return;
			}

			if (defensor == null) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/9.png");
				disparando = false;
				return;
			}

			if (atacante.getEquipo().equals(defensor.getEquipo())) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/10.png");
				disparando = false;
				return;
			}

			vf.getVen().getJpnPeleas().cambiarFondoConTipoYEquipo(atacante.getTipo(), atacante.getEquipo(),
					defensor.getTipo(), defensor.getEquipo());

			int danioAtacante = calcularDanio(atacante.getTipo(), defensor.getTipo(), true);
			int danioDefensor = calcularDanio(atacante.getTipo(), defensor.getTipo(), false);

			defensor.setVida(defensor.getVida() - danioAtacante);
			atacante.setVida(atacante.getVida() - danioDefensor);

			vf.getVen().getJpnPeleas().setCurrentHealthLeft(atacante.getVida(), obtenerVidaMaximaPorTipo(atacante));
			vf.getVen().getJpnPeleas().setCurrentHealthRight(defensor.getVida(), obtenerVidaMaximaPorTipo(defensor));

			if (defensor.getVida() <= 0) {
				matrizUnidades[y][x] = null;
				if (vf.getVen().getMatrizPanel()[y][x] instanceof PanelCampo) {
					PanelCampo panelDestino = (PanelCampo) vf.getVen().getMatrizPanel()[y][x];
					panelDestino.removePersonaje();
				}
				if (atacante.getVida() > 0) {
					atacante.setExperiencia(atacante.getExperiencia() + 1);
				}
			}

			if (atacante.getVida() <= 0) {
				matrizUnidades[origenY][origenX] = null;
				if (vf.getVen().getMatrizPanel()[origenY][origenX] instanceof PanelCampo) {
					PanelCampo panelOrigen = (PanelCampo) vf.getVen().getMatrizPanel()[origenY][origenX];
					panelOrigen.removePersonaje();
				}
				if (defensor.getVida() > 0) {
					defensor.setExperiencia(defensor.getExperiencia() + 1);
				}
			}

			String equipoEnTurno = obtenerEquipoActual();
			if (!equipoTieneUnidades(equipoEnTurno)) {
				cambiarTurno();
			} else {
				realizarAccionEquipo();
			}

			disparando = false;
		}
	}

	/**
	 * Calculates the damage dealt based on the type of attacker, type of defender,
	 * and whether the action is offensive or defensive.
	 *
	 * @param tipoAtacante The type of the attacking unit (e.g., "soldado",
	 *                     "tanque", "avion").
	 * @param tipoDefensor The type of the defending unit (e.g., "soldado",
	 *                     "tanque", "avion").
	 * @param esAtaque     A boolean indicating whether the action is offensive
	 *                     (true) or defensive (false).
	 * @return The damage value based on the interaction between tipoAtacante and
	 *         tipoDefensor.
	 */
	private int calcularDanio(String tipoAtacante, String tipoDefensor, boolean esAtaque) {
		if (esAtaque) {
			switch (tipoAtacante) {
			case "soldado":
				if (tipoDefensor.equals("soldado"))
					return 2;
				if (tipoDefensor.equals("tanque"))
					return 2;
				if (tipoDefensor.equals("avion"))
					return 6;
				break;
			case "tanque":
				if (tipoDefensor.equals("soldado"))
					return 3;
				if (tipoDefensor.equals("tanque"))
					return 3;
				if (tipoDefensor.equals("avion"))
					return 4;
				break;
			case "avion":
				if (tipoDefensor.equals("soldado"))
					return 1;
				if (tipoDefensor.equals("tanque"))
					return 4;
				if (tipoDefensor.equals("avion"))
					return 4;
				break;
			}
		} else {
			switch (tipoDefensor) {
			case "soldado":
				if (tipoAtacante.equals("soldado"))
					return 1;
				if (tipoAtacante.equals("tanque"))
					return 2;
				if (tipoAtacante.equals("avion"))
					return 5;
				break;
			case "tanque":
				if (tipoAtacante.equals("soldado"))
					return 2;
				if (tipoAtacante.equals("tanque"))
					return 2;
				if (tipoAtacante.equals("avion"))
					return 2;
				break;
			case "avion":
				if (tipoAtacante.equals("soldado"))
					return 1;
				if (tipoAtacante.equals("tanque"))
					return 4;
				if (tipoAtacante.equals("avion"))
					return 2;
				break;
			}
		}
		return 0;
	}

	/**
	 * Launches the graphical user interface (GUI) for the application and plays
	 * background audio. The GUI is made visible, and an audio file located in the
	 * resources directory is played. The method also pauses the current thread for
	 * the duration of the audio playback.
	 */
	public void correrGUI() {
		vf.getVen().setVisible(true);
		FileHandler reproductor = new FileHandler();
		String ruta = "resources/audio/advanceWarce.wav";
		reproductor.reproducir(ruta);
		try {
			Thread.sleep(360000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if the space in the matrix is free.
	 *
	 * @param y the y-coordinate.
	 * @param x the X coordinate.
	 * @return true if the coordinates are within the bounds of the array, false
	 *         otherwise.
	 */
	private boolean espacioLibre(int y, int x) {
		return y >= 0 && y < vf.getVen().getFila() && x >= 0 && x < vf.getVen().getColumna();
	}

	/**
	 * Verifies if the troop labels indicate that all players' funds are below a
	 * specific threshold. Depending on the number of players, it checks the money
	 * labels for each player to determine if they all have less than 50 units of
	 * currency.
	 *
	 * @param numJugadores the number of players in the game, ranging from 2 to 4
	 * @return true if all players' money values are below 50, false otherwise
	 */
	private boolean verificarLabelsDeTropas(int numJugadores) {
		switch (numJugadores) {
		case 2:
			int dineroRojo = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblDinero().getText());

			int dineroVerde = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblDinero2().getText());

			return dineroRojo < 50 && dineroVerde < 50;

		case 3:
			int dineroAzul = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero2().getText());
			dineroRojo = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero().getText());
			dineroVerde = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblDinero3().getText());

			return dineroRojo < 50 && dineroVerde < 50 && dineroAzul < 50;

		case 4:
			dineroAzul = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero2().getText());
			int dineroAmarillo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero4().getText());
			dineroRojo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero().getText());
			dineroVerde = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblDinero3().getText());

			return dineroRojo < 50 && dineroVerde < 50 && dineroAzul < 50 && dineroAmarillo < 50;

		default:
			return false;
		}
	}

	/**
	 * Starts the game based on the number of players. Configure the panels of
	 * interface and add the necessary ActionListeners.
	 */
	public void iniciarPartida() {
		switch (banderaJugadores) {
		case 2:
			vf.getVen().getJpnJugadores2().setVisible(false);
			vf.getVen().setVisible(true);
			vf.getVen().getPanelAccion().getBtnMove().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnShoot().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnSkills().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnInfo().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnMove().setActionCommand("mover");
			vf.getVen().getPanelAccion().getBtnShoot().setActionCommand("shoot");
			vf.getVen().getPanelAccion().getBtnSkills().setActionCommand("enhancements");
			vf.getVen().getPanelAccion().getBtnInfo().setActionCommand("info");

			vf.getVen().getJpnPausa().getBtnContinuar().addActionListener(this);
			vf.getVen().getJpnPausa().getBtnGuardar().addActionListener(this);
			vf.getVen().getJpnPausa().getBtnContinuar().setActionCommand("continuar");
			vf.getVen().getJpnPausa().getBtnGuardar().setActionCommand("Guardar Partida");

			vf.getVen().getJpnMejoras().getBtnVidaMas().addActionListener(this);
			vf.getVen().getJpnMejoras().getBtnDanioMas().addActionListener(this);
			vf.getVen().getJpnMejoras().getBtnVidaMas().setActionCommand("aumentar vida");
			vf.getVen().getJpnMejoras().getBtnDanioMas().setActionCommand("aumentar ataque");
			break;
		case 3:
			vf.getVen().getJpnJugadores3().setVisible(false);
			vf.getVen().setVisible(true);
			vf.getVen().getPanelAccion().getBtnMove().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnShoot().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnSkills().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnInfo().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnInfo().setActionCommand("info");
			vf.getVen().getPanelAccion().getBtnMove().setActionCommand("mover");
			vf.getVen().getPanelAccion().getBtnShoot().setActionCommand("shoot");
			vf.getVen().getPanelAccion().getBtnSkills().setActionCommand("enhancements");

			vf.getVen().getJpnPausa().getBtnContinuar().addActionListener(this);
			vf.getVen().getJpnPausa().getBtnGuardar().addActionListener(this);
			vf.getVen().getJpnPausa().getBtnContinuar().setActionCommand("continuar");
			vf.getVen().getJpnPausa().getBtnGuardar().setActionCommand("Guardar Partida");

			vf.getVen().getJpnMejoras().getBtnVidaMas().addActionListener(this);
			vf.getVen().getJpnMejoras().getBtnDanioMas().addActionListener(this);
			vf.getVen().getJpnMejoras().getBtnVidaMas().setActionCommand("aumentar vida");
			vf.getVen().getJpnMejoras().getBtnDanioMas().setActionCommand("aumentar ataque");
			break;
		case 4:
			vf.getVen().getJpnJugadores4().setVisible(false);
			vf.getVen().setVisible(true);
			vf.getVen().getPanelAccion().getBtnMove().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnShoot().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnSkills().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnInfo().addActionListener(this);
			vf.getVen().getPanelAccion().getBtnInfo().setActionCommand("info");
			vf.getVen().getPanelAccion().getBtnMove().setActionCommand("mover");
			vf.getVen().getPanelAccion().getBtnShoot().setActionCommand("shoot");
			vf.getVen().getPanelAccion().getBtnSkills().setActionCommand("enhancements");

			vf.getVen().getJpnPausa().getBtnContinuar().addActionListener(this);
			vf.getVen().getJpnPausa().getBtnGuardar().addActionListener(this);
			vf.getVen().getJpnPausa().getBtnContinuar().setActionCommand("continuar");
			vf.getVen().getJpnPausa().getBtnGuardar().setActionCommand("Guardar Partida");

			vf.getVen().getJpnMejoras().getBtnVidaMas().addActionListener(this);
			vf.getVen().getJpnMejoras().getBtnDanioMas().addActionListener(this);
			vf.getVen().getJpnMejoras().getBtnVidaMas().setActionCommand("aumentar vida");
			vf.getVen().getJpnMejoras().getBtnDanioMas().setActionCommand("aumentar ataque");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Número de jugadores no válido.", "Error", JOptionPane.ERROR_MESSAGE);
			break;
		}
	}

	/**
	 * Saves the status of the current game in a binary file.
	 *
	 * @param line item the LineDTO object containing the line item status.
	 */
	public void guardarPartida(PartidaDTO partida) {
		if (partida.getMatrizUnidades() == null || partida.getMatrizUnidades().length == 0) {
			MensajeEmergente.mostrarInfo("resources/images/tutorial/13.png", "No se puede guardar la partida", 220, 90,
					500, 200);
			return;
		}
		String nombreArchivo = partida.getNombre();
		if (nombreArchivo != null && !nombreArchivo.trim().isEmpty()) {
			File directorio = new File("partidas/");
			if (!directorio.exists()) {
				directorio.mkdirs();
			}
			try (ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("partidas/" + nombreArchivo + ".bin"))) {
				oos.writeObject(partida);
				MensajeEmergente.mostrarInfo("resources/images/tutorial/13.png", "Partida guardada con éxito.", 220, 90,
						500, 200);
			} catch (IOException e) {
				e.printStackTrace();
				MensajeEmergente.mostrarInfo("resources/images/tutorial/13.png", "Error al guardar la partida.", 220,
						90, 500, 200);
			}
		}
	}

	/**
	 * Loads a saved game from a binary file.
	 *
	 * @return the PartidaDTO object containing the status of the loaded game, or
	 *         null if it cannot be loaded.
	 */
	public PartidaDTO cargarPartida() {
		String[] partidasGuardadas = obtenerPartidasGuardadas();
		if (partidasGuardadas.length == 0) {
			JOptionPane.showMessageDialog(null, "No hay partidas guardadas disponibles.");
			return null;
		}

		String partidaSeleccionada = (String) JOptionPane.showInputDialog(null, "Selecciona una partida para cargar:",
				"Cargar partida", JOptionPane.QUESTION_MESSAGE, null, partidasGuardadas, partidasGuardadas[0]);

		if (partidaSeleccionada != null) {
			try (ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("partidas/" + partidaSeleccionada))) {
				PartidaDTO partidaCargada = (PartidaDTO) ois.readObject();
				MensajeEmergente.mostrarInfo("resources/images/tutorial/13.png", "Partida cargada con éxito.", 220, 90,
						500, 200);

				this.matrizUnidades = partidaCargada.getMatrizUnidades();
				vf.getVen().setMatrizPanel(partidaCargada.getMatrizPaneles());

				reconstruirEstadoDeTurnos(partidaCargada);

				return partidaCargada;
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error al cargar la partida.");
			}
		}
		return null;
	}

	/**
	 * Reconstructs the turn state for a loaded game by resetting the turn counter
	 * and round number. Initializes the number of players and sets the turn to the
	 * first move. It also resets the pointer position on the game board to the
	 * top-left corner.
	 *
	 * @param partidaCargada the loaded game data containing the number of players
	 *                       in the game
	 */
	private void reconstruirEstadoDeTurnos(PartidaDTO partidaCargada) {
		this.turnos = new TurnosDTO();
		this.turnos.setCantidadJugadores(partidaCargada.getNumJugadores());
		this.turnos.setJugada(0);

		this.ronda = 0;

		vf.getVen().setApuntadorX(0);
		vf.getVen().setApuntadorY(0);

	}

	/**
	 * Gets a list of file names of saved games in the 'games' directory. directory
	 * 'games'.
	 *
	 * @return an array of Strings with the names of saved game files. saved.
	 */
	public String[] obtenerPartidasGuardadas() {
		File directorio = new File("partidas/");
		if (directorio.exists() && directorio.isDirectory()) {
			return directorio.list((dir, name) -> name.endsWith(".bin"));
		}
		return new String[0];
	}

	/**
	 * Adds the ActionListeners needed for the controls of the actions panel and the
	 * pause panel. action panel and pause panel controls.
	 */
	public void addListenersPartida() {
		vf.getVen().getPanelAccion().getBtnMove().addActionListener(this);
		vf.getVen().getPanelAccion().getBtnShoot().addActionListener(this);
		vf.getVen().getPanelAccion().getBtnSkills().addActionListener(this);
		vf.getVen().getPanelAccion().getBtnInfo().addActionListener(this);
		vf.getVen().getPanelAccion().getBtnInfo().setActionCommand("info");
		vf.getVen().getPanelAccion().getBtnMove().setActionCommand("mover");
		vf.getVen().getPanelAccion().getBtnShoot().setActionCommand("shoot");
		vf.getVen().getPanelAccion().getBtnSkills().setActionCommand("enhancements");

		vf.getVen().getJpnPausa().getBtnContinuar().addActionListener(this);
		vf.getVen().getJpnPausa().getBtnGuardar().addActionListener(this);
		vf.getVen().getJpnPausa().getBtnContinuar().setActionCommand("continuar");
		vf.getVen().getJpnPausa().getBtnGuardar().setActionCommand("Guardar Partida");

		vf.getVen().getJpnMejoras().getBtnVidaMas().addActionListener(this);
		vf.getVen().getJpnMejoras().getBtnDanioMas().addActionListener(this);
		vf.getVen().getJpnMejoras().getBtnVidaMas().setActionCommand("aumentar vida");
		vf.getVen().getJpnMejoras().getBtnDanioMas().setActionCommand("aumentar ataque");
	}

	/**
	 * Removes the ActionListeners from the action panel controls and the pause
	 * panel. pause panel.
	 */
	public void removeListenersPartida() {
		vf.getVen().getJpnPausa().getBtnContinuar().removeActionListener(this);
		vf.getVen().getJpnPausa().getBtnGuardar().removeActionListener(this);
		vf.getVen().getPanelAccion().getBtnMove().removeActionListener(this);
	}

	/**
	 * Generates the teams of players and distributes the units in the game matrix,
	 * depending on the number of players. game, depending on the number of players.
	 *
	 * @param numPlayers the number of players participating in the game.
	 */
	public void generarEquipos(int numJugadores) {
		if (matrizUnidades == null) {
			int filas = vf.getVen().getFila();
			int columnas = vf.getVen().getColumna();
			matrizUnidades = new UnidadDTO[filas][columnas];
		}
		int rio = 0;
		int soldadosRojo = 0;
		int soldadosAmarillo = 0;
		int soldadosAzul = 0;
		int soldadosVerde = 0;

		int tankRojo = 0;
		int tankAmarillo = 0;
		int tankAzul = 0;
		int tankVerde = 0;

		int avionRojo = 0;
		int avionAmarillo = 0;
		int avionAzul = 0;
		int avionVerde = 0;
		if (numJugadores == 2) {
			soldadosRojo = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblSoldadoRojo().getText());
			soldadosVerde = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblSoldadoVerde().getText());

			tankRojo = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblTanqueRojo().getText());
			tankVerde = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblTanqueVerde().getText());

			avionRojo = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblAvionRojo().getText());
			avionVerde = Integer.parseInt(vf.getVen().getJpnJugadores2().getLblAvionVerde().getText());
		}
		if (numJugadores == 3) {
			avionRojo = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblAvionRojo().getText());
			avionAzul = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblAvionAzul().getText());
			avionVerde = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblAvionVerde().getText());

			soldadosRojo = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoRojo().getText());
			soldadosAzul = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoAzul().getText());
			soldadosVerde = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblSoldadoVerde().getText());

			tankRojo = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueRojo().getText());
			tankAzul = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueAzul().getText());
			tankVerde = Integer.parseInt(vf.getVen().getJpnJugadores3().getLblTanqueVerde().getText());
		}
		if (numJugadores == 4) {
			avionRojo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblAvionRojo().getText());
			avionAmarillo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblAvionAmarillo().getText());
			avionAzul = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblAvionAzul().getText());
			avionVerde = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblAvionVerde().getText());

			soldadosRojo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoRojo().getText());
			soldadosAmarillo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoAmarillo().getText());
			soldadosAzul = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoAzul().getText());
			soldadosVerde = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblSoldadoVerde().getText());

			tankRojo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueRojo().getText());
			tankAmarillo = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueAmarillo().getText());
			tankAzul = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueAzul().getText());
			tankVerde = Integer.parseInt(vf.getVen().getJpnJugadores4().getLblTanqueVerde().getText());
		}

		MyLinkedList<UnidadDTO> listaTropasRojo = new MyLinkedList<>();
		MyLinkedList<UnidadDTO> listaTropasAmarillo = new MyLinkedList<>();
		MyLinkedList<UnidadDTO> listaTropasAzul = new MyLinkedList<>();
		MyLinkedList<UnidadDTO> listaTropasVerde = new MyLinkedList<>();

		int filas = vf.getVen().getFila();
		int columnas = vf.getVen().getColumna();
		matrizUnidades = new UnidadDTO[filas][columnas];
		switch (numJugadores) {
		case 2:
			rio = 3;
			for (int i = 0; i < soldadosRojo; i++) {
				UnidadDTO soldado = new UnidadDTO("rojo", 5, 2, 0, "soldado");
				listaTropasRojo.add(soldado);
				matrizUnidades[0][i + 1] = soldado;
			}
			for (int i = 0; i < tankRojo; i++) {
				UnidadDTO tanque = new UnidadDTO("rojo", 10, 3, 0, "tanque");
				listaTropasRojo.add(tanque);
				matrizUnidades[2][i + 1] = tanque;
			}
			for (int i = 0; i < avionRojo; i++) {
				UnidadDTO avion = new UnidadDTO("rojo", 15, 4, 0, "avion");
				listaTropasRojo.add(avion);
				matrizUnidades[3][i + 1] = avion;
			}
			for (int i = columnas - 2; i >= columnas - soldadosVerde - 1; i--) {
				UnidadDTO soldado = new UnidadDTO("verde", 5, 2, 0, "soldado");
				listaTropasVerde.add(soldado);
				matrizUnidades[filas - 1][i] = soldado;
			}
			for (int i = columnas - 2; i >= columnas - tankVerde - 1; i--) {
				UnidadDTO tanque = new UnidadDTO("verde", 10, 3, 0, "tanque");
				listaTropasVerde.add(tanque);
				matrizUnidades[filas - 3][i] = tanque;
			}
			for (int i = columnas - 2; i >= columnas - avionVerde - 1; i--) {
				UnidadDTO avion = new UnidadDTO("verde", 15, 4, 0, "avion");
				listaTropasVerde.add(avion);
				matrizUnidades[filas - 4][i] = avion;
			}
			mf.getEquipoDAO().create(new EquipoDTO("rojo", listaTropasRojo));
			mf.getEquipoDAO().create(new EquipoDTO("verde", listaTropasVerde));
			vf.getVen().generarPartida2Players(soldadosRojo, tankRojo, avionRojo, soldadosVerde, tankVerde, avionVerde);
			vf.getVen().generarRios(rio);
			break;
		case 3:
			rio = 3;
			for (int i = 0; i < soldadosRojo; i++) {
				UnidadDTO soldado = new UnidadDTO("rojo", 5, 2, 0, "soldado");
				listaTropasRojo.add(soldado);
				matrizUnidades[0][i + 1] = soldado;
			}
			for (int i = 0; i < tankRojo; i++) {
				UnidadDTO tanque = new UnidadDTO("rojo", 10, 3, 0, "tanque");
				listaTropasRojo.add(tanque);
				matrizUnidades[2][i + 1] = tanque;
			}
			for (int i = 0; i < avionRojo; i++) {
				UnidadDTO avion = new UnidadDTO("rojo", 15, 4, 0, "avion");
				listaTropasRojo.add(avion);
				matrizUnidades[3][i + 1] = avion;
			}
			for (int i = 0; i < soldadosAzul; i++) {
				UnidadDTO soldado = new UnidadDTO("azul", 5, 2, 0, "soldado");
				listaTropasAzul.add(soldado);
				matrizUnidades[filas - 1][i + 1] = soldado;
			}
			for (int i = 0; i < tankAzul; i++) {
				UnidadDTO tanque = new UnidadDTO("azul", 10, 3, 0, "tanque");
				listaTropasAzul.add(tanque);
				matrizUnidades[filas - 3][i + 1] = tanque;
			}
			for (int i = 0; i < avionAzul; i++) {
				UnidadDTO avion = new UnidadDTO("azul", 15, 4, 0, "avion");
				listaTropasAzul.add(avion);
				matrizUnidades[filas - 4][i + 1] = avion;
			}
			for (int i = columnas - 2; i >= columnas - soldadosVerde - 1; i--) {
				UnidadDTO soldado = new UnidadDTO("verde", 5, 2, 0, "soldado");
				listaTropasVerde.add(soldado);
				matrizUnidades[filas - 1][i] = soldado;
			}
			for (int i = columnas - 2; i >= columnas - tankVerde - 1; i--) {
				UnidadDTO tanque = new UnidadDTO("verde", 10, 3, 0, "tanque");
				listaTropasVerde.add(tanque);
				matrizUnidades[filas - 3][i] = tanque;
			}
			for (int i = columnas - 2; i >= columnas - avionVerde - 1; i--) {
				UnidadDTO avion = new UnidadDTO("verde", 15, 4, 0, "avion");
				listaTropasVerde.add(avion);
				matrizUnidades[filas - 4][i] = avion;
			}
			mf.getEquipoDAO().create(new EquipoDTO("rojo", listaTropasRojo));
			mf.getEquipoDAO().create(new EquipoDTO("azul", listaTropasAzul));
			mf.getEquipoDAO().create(new EquipoDTO("verde", listaTropasVerde));
			vf.getVen().generarPartida3Players(soldadosRojo, tankRojo, avionRojo, soldadosVerde, tankVerde, avionVerde,
					soldadosAzul, tankAzul, avionAzul);
			vf.getVen().generarRios(rio);
			break;
		case 4:
			rio = 3;
			for (int i = 0; i < soldadosRojo; i++) {
				UnidadDTO soldado = new UnidadDTO("rojo", 5, 2, 0, "soldado");
				listaTropasRojo.add(soldado);
				matrizUnidades[0][i + 1] = soldado;
			}
			for (int i = 0; i < tankRojo; i++) {
				UnidadDTO tanque = new UnidadDTO("rojo", 10, 3, 0, "tanque");
				listaTropasRojo.add(tanque);
				matrizUnidades[2][i + 1] = tanque;
			}
			for (int i = 0; i < avionRojo; i++) {
				UnidadDTO avion = new UnidadDTO("rojo", 15, 4, 0, "avion");
				listaTropasRojo.add(avion);
				matrizUnidades[3][i + 1] = avion;
			}
			for (int i = columnas - 2; i >= columnas - soldadosAmarillo - 1; i--) {
				UnidadDTO soldado = new UnidadDTO("amarillo", 5, 2, 0, "soldado");
				listaTropasAmarillo.add(soldado);
				matrizUnidades[0][i] = soldado;
			}
			for (int i = columnas - 2; i >= columnas - tankAmarillo - 1; i--) {
				UnidadDTO tanque = new UnidadDTO("amarillo", 10, 3, 0, "tanque");
				listaTropasAmarillo.add(tanque);
				matrizUnidades[2][i] = tanque;
			}
			for (int i = columnas - 2; i >= columnas - avionAmarillo - 1; i--) {
				UnidadDTO avion = new UnidadDTO("amarillo", 15, 4, 0, "avion");
				listaTropasAmarillo.add(avion);
				matrizUnidades[3][i] = avion;
			}
			for (int i = 0; i < soldadosAzul; i++) {
				UnidadDTO soldado = new UnidadDTO("azul", 5, 2, 0, "soldado");
				listaTropasAzul.add(soldado);
				matrizUnidades[filas - 1][i + 1] = soldado;
			}
			for (int i = 0; i < tankAzul; i++) {
				UnidadDTO tanque = new UnidadDTO("azul", 10, 3, 0, "tanque");
				listaTropasAzul.add(tanque);
				matrizUnidades[filas - 3][i + 1] = tanque;
			}
			for (int i = 0; i < avionAzul; i++) {
				UnidadDTO avion = new UnidadDTO("azul", 15, 4, 0, "avion");
				listaTropasAzul.add(avion);
				matrizUnidades[filas - 4][i + 1] = avion;
			}
			for (int i = columnas - 2; i >= columnas - soldadosVerde - 1; i--) {
				UnidadDTO soldado = new UnidadDTO("verde", 5, 2, 0, "soldado");
				listaTropasVerde.add(soldado);
				matrizUnidades[filas - 1][i] = soldado;
			}
			for (int i = columnas - 2; i >= columnas - tankVerde - 1; i--) {
				UnidadDTO tanque = new UnidadDTO("verde", 10, 3, 0, "tanque");
				listaTropasVerde.add(tanque);
				matrizUnidades[filas - 3][i] = tanque;
			}
			for (int i = columnas - 2; i >= columnas - avionVerde - 1; i--) {
				UnidadDTO avion = new UnidadDTO("verde", 15, 4, 0, "avion");
				listaTropasVerde.add(avion);
				matrizUnidades[filas - 4][i] = avion;
			}

			mf.getEquipoDAO().create(new EquipoDTO("rojo", listaTropasRojo));
			mf.getEquipoDAO().create(new EquipoDTO("amarillo", listaTropasAmarillo));
			mf.getEquipoDAO().create(new EquipoDTO("azul", listaTropasAzul));
			mf.getEquipoDAO().create(new EquipoDTO("verde", listaTropasVerde));
			vf.getVen().generarPartida4Players(soldadosRojo, tankRojo, avionRojo, soldadosVerde, tankVerde, avionVerde,
					soldadosAzul, tankAzul, avionAzul, soldadosAmarillo, tankAmarillo, avionAmarillo);
			vf.getVen().generarRios(rio);

			break;
		}
		for (int i = 0; i < matrizUnidades.length; i++) {
			for (int j = 0; j < matrizUnidades[i].length; j++) {
				if (matrizUnidades[i][j] != null) {
					System.out.print("[" + matrizUnidades[i][j].getEquipo().charAt(0) + "] ");
				} else {
					System.out.print("[ ] ");
				}
			}

		}

		configurarTurnos(numJugadores);
	}

	/**
	 * Configures the turn order based on the number of players. Sets the turn order
	 * list, resets the current turn index to the first team, and initializes the
	 * current team and remaining moves.
	 *
	 * @param numeroDeJugadores The number of players in the game
	 */
	public void configurarTurnos(int numeroDeJugadores) {
		switch (numeroDeJugadores) {
		case 2:
			ordenTurnosActual = ordenTurnos2Jugadores;
			break;
		case 3:
			ordenTurnosActual = ordenTurnos3Jugadores;
			break;
		case 4:
			ordenTurnosActual = ordenTurnos4Jugadores;
			break;
		}
		indiceTurnoActual = 0;
		movimientosRestantes = movimientosPorTurno;
		equipoActual = ordenTurnosActual.get(indiceTurnoActual);

	}

	/**
	 * Performs an action for the current team. Reduces the remaining moves and
	 * automatically switches the turn if no moves are left.
	 */
	public void realizarAccionEquipo() {
		if (verificarFinDeJuego()) {
			return;
		}

		if (movimientosRestantes > 0) {
			movimientosRestantes--;
		}

		if (movimientosRestantes == 0) {
			cambiarTurno();
		}
	}

	/**
	 * Switches to the next team's turn in the turn order list, resets remaining
	 * moves, and displays a message indicating the current team.
	 */
	private void cambiarTurno() {
		if (verificarFinDeJuego()) {
			return;
		}

		if (ordenTurnosActual == null || ordenTurnosActual.isEmpty()) {
			return;
		}

		do {
			indiceTurnoActual = (indiceTurnoActual + 1) % ordenTurnosActual.size();
			equipoActual = ordenTurnosActual.get(indiceTurnoActual);
		} while (!equipoTieneUnidades(equipoActual));

		movimientosRestantes = movimientosPorTurno;
		MensajeEmergente.mostrarInfo("resources/images/tutorial/13.png", "Es turno del equipo: " + equipoActual, 220,
				90, 500, 200);
	}

	/**
	 * Checks if a given team has any units on the battlefield.
	 *
	 * @param equipo The name of the team to check for units.
	 * @return true if the team has at least one unit in matrizUnidades, false
	 *         otherwise.
	 */
	private boolean equipoTieneUnidades(String equipo) {
		for (int i = 0; i < matrizUnidades.length; i++) {
			for (int j = 0; j < matrizUnidades[i].length; j++) {
				UnidadDTO unidad = matrizUnidades[i][j];
				if (unidad != null && unidad.getEquipo().equals(equipo)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if the game has ended by verifying if only one team remains active on
	 * the board.
	 *
	 * @return true if only one team is left; false otherwise
	 */
	public boolean verificarFinDeJuego() {
		Set<String> equiposRestantes = new HashSet<>();
		String equipoGanador = null;

		for (int i = 0; i < matrizUnidades.length; i++) {
			for (int j = 0; j < matrizUnidades[i].length; j++) {
				UnidadDTO unidad = matrizUnidades[i][j];
				if (unidad != null) {
					equiposRestantes.add(unidad.getEquipo());
					equipoGanador = unidad.getEquipo();
				}
			}
		}

		if (equiposRestantes.size() == 1) {
			juegoTerminado = true;

			String equipoFinal = equipoGanador;
			javax.swing.Timer timer = new javax.swing.Timer(5000, e -> {
				vf.getVen().limpiarPaneles();
				vf.getVen().limpiarJuego();
				vf.getVen().getJpnGameOver().mostrarEquipoGanador(equipoFinal);
				vf.getVen().getJpnGameOver().setVisible(true);
				vf.getVen().revalidate();
				vf.getVen().repaint();
			});
			timer.setRepeats(false);
			timer.start();

			return true;
		}
		return false;
	}

	/**
	 * Checks if it is currently the specified team's turn.
	 *
	 * @param equipo The name of the team to check
	 * @return true if it is the specified team's turn; false otherwise
	 */
	public boolean esTurnoDelEquipo(String equipo) {
		return equipoActual.equals(equipo);
	}

	/**
	 * Restricts movement range based on the type of unit and updates the boundaries
	 * (superiorX, inferiorX, superiorY, inferiorY) to reflect this range.
	 *
	 * @param x    The X coordinate of the unit
	 * @param y    The Y coordinate of the unit
	 * @param tipo The type of unit (e.g., "soldado", "tanque", "avion")
	 */
	private void restringirMovimiento(int x, int y, String tipo) {
		switch (tipo) {
		case "soldado":
			maxDistancia = 3;
			break;
		case "tanque":
			maxDistancia = 4;
			break;
		case "avion":
			maxDistancia = 6;
			break;
		default:
			maxDistancia = 0;
			break;
		}

		inferiorX = Math.max(x - maxDistancia, 0);
		superiorX = Math.min(x + maxDistancia, vf.getVen().getColumna() - 1);
		inferiorY = Math.max(y - maxDistancia, 0);
		superiorY = Math.min(y + maxDistancia, vf.getVen().getFila() - 1);
	}

	/**
	 * Repaints panels within the movement range, marking the reachable positions
	 * for the selected unit with an indicator.
	 */
	private void repintarPanelesMovimiento() {
		for (int i = inferiorY; i <= superiorY; i++) {
			for (int j = inferiorX; j <= superiorX; j++) {
				int distancia = Math.abs(i - y) + Math.abs(j - x);
				if (distancia <= maxDistancia && esCasillaValida(j, i)) {
					if (vf.getVen().getMatrizPanel()[i][j] instanceof PanelCampo) {
						((PanelCampo) vf.getVen().getMatrizPanel()[i][j])
								.setImagenFondo("resources/images/campo/Apuntadormm.png");
					}
				}
			}
		}
	}

	/**
	 * Restores panels to their default background image after movement, removing
	 * any indicators.
	 */
	private void restaurarPanelesMovimiento() {
		for (int i = inferiorY; i <= superiorY; i++) {
			for (int j = inferiorX; j <= superiorX; j++) {
				if (vf.getVen().getMatrizPanel()[i][j] instanceof PanelCampo) {
					((PanelCampo) vf.getVen().getMatrizPanel()[i][j])
							.setImagenFondo("resources/images/campo/campo.png");
				}
			}
		}
	}

	/**
	 * Checks if the specified position is within the valid movement range of the
	 * unit based on current boundaries and maximum allowed distance.
	 *
	 * @param destinoX The destination X coordinate
	 * @param destinoY The destination Y coordinate
	 * @return true if the position is within the valid movement range; false
	 *         otherwise
	 */
	private boolean esCasillaValida(int destinoX, int destinoY) {
		int distancia = Math.abs(destinoX - x) + Math.abs(destinoY - y);
		return (distancia <= maxDistancia) && (destinoX >= inferiorX && destinoX <= superiorX)
				&& (destinoY >= inferiorY && destinoY <= superiorY);
	}

	/**
	 * Manages turn progression based on player positions and the number of moves in
	 * the current round. Adjusts the pointer based on recent moves and the number
	 * of players in the game, setting it for the next round as needed.
	 *
	 * @param llegadaX The X coordinate of the destination
	 * @param llegadaY The Y coordinate of the destination
	 */
	public void controlarTurnos(int llegadaX, int llegadaY) {
		String turnoActual = llegadaX + "," + llegadaY;

		turnos.setJugada(turnos.getJugada() + 1);

		if (turnos.getJugada() == 3) {
			turnos.getUltimasPosicioneStrings().add(turnoActual);
			turnos.setJugada(0);

			switch (turnos.getCantidadJugadores()) {
			case 2:
				if (ronda == 0) {
					vf.getVen().setApuntadorX(42);
					vf.getVen().setApuntadorY(24);
					ronda = 1;
				} else {
					String[] posiciones = turnos.getUltimasPosicioneStrings()
							.get(turnos.getUltimasPosicioneStrings().size() - 2).split(",");
					vf.getVen().setApuntadorX(Integer.parseInt(posiciones[0]));
					vf.getVen().setApuntadorY(Integer.parseInt(posiciones[1]));
				}
				break;

			case 3:
				if (ronda == 0) {
					if (turnos.getUltimasPosicioneStrings().size() == 1) {
						vf.getVen().setApuntadorX(0);
						vf.getVen().setApuntadorY(24);
					} else {
						vf.getVen().setApuntadorX(42);
						vf.getVen().setApuntadorY(24);
						ronda = 1;
					}
				} else {
					String[] posiciones = turnos.getUltimasPosicioneStrings()
							.get(turnos.getUltimasPosicioneStrings().size() - 3).split(",");
					vf.getVen().setApuntadorX(Integer.parseInt(posiciones[0]));
					vf.getVen().setApuntadorY(Integer.parseInt(posiciones[1]));
				}
				break;

			case 4:
				if (ronda == 0) {
					if (turnos.getUltimasPosicioneStrings().size() == 1) {
						vf.getVen().setApuntadorX(0);
						vf.getVen().setApuntadorY(24);
					} else if (turnos.getUltimasPosicioneStrings().size() == 2) {
						vf.getVen().setApuntadorX(42);
						vf.getVen().setApuntadorY(24);
					} else {
						vf.getVen().setApuntadorX(42);
						vf.getVen().setApuntadorY(0);
						ronda = 1;
					}
				} else {
					String[] posiciones = turnos.getUltimasPosicioneStrings()
							.get(turnos.getUltimasPosicioneStrings().size() - 4).split(",");
					vf.getVen().setApuntadorX(Integer.parseInt(posiciones[0]));
					vf.getVen().setApuntadorY(Integer.parseInt(posiciones[1]));
				}
				break;
			}

		}
	}

	/**
	 * Gets the current team that is active in the game.
	 *
	 * @return the name of the current team
	 */
	public String obtenerEquipoActual() {
		return equipoActual;
	}

	/**
	 * Ends the current team's turn and shifts the game to the next team's turn.
	 */
	public void terminarTurno() {
		cambiarTurno();
	}

	/**
	 * Updates the pointer position on the game board for the specified team at the
	 * start of their turn. Searches the matrix for an active unit belonging to the
	 * team and sets the pointer to its position. If no active unit is found for the
	 * team, logs a message indicating this.
	 *
	 * @param equipo the name of the team whose turn is starting
	 */
	private void actualizarApuntadorParaNuevoTurno(String equipo) {
		for (int i = 0; i < matrizUnidades.length; i++) {
			for (int j = 0; j < matrizUnidades[i].length; j++) {
				UnidadDTO unidad = matrizUnidades[i][j];
				if (unidad != null && unidad.getEquipo().equals(equipo)) {
					vf.getVen().setApuntadorX(j);
					vf.getVen().setApuntadorY(i);
					return;
				}
			}
		}
	}

	/**
	 * Handles the action events generated by the components of the graphical
	 * interface. graphical.
	 *
	 * @param e the action event that has occurred.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "terminarTurno": {
			cambiarTurno();
			break;
		}
		case "info": {
			if (unidadSeleccionada != null) {
				MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png", unidadSeleccionada.toString(), 180, 42,
						500, 50);
				vf.getVen().getPanelAccion().setVisible(false);
				vf.getVen().requestFocusInWindow();

				unidadSeleccionada = null;
			}
			break;
		}

		case "mover": {
			if (banderaTutorial == true) {
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif8.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif9.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif10.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif13.gif");
				banderaTutorial = false;
			}
			moviendo = true;
			x = vf.getVen().getApuntadorX();
			y = vf.getVen().getApuntadorY();
			restringirMovimiento(x, y, matrizUnidades[y][x].getTipo());
			repintarPanelesMovimiento();
			vf.getVen().getPanelAccion().setVisible(false);
			vf.getVen().requestFocusInWindow();
			break;
		}

		case "aumentar vida":
			if (unidadSeleccionada != null) {
				if (unidadSeleccionada.getExperiencia() > 0) {
					unidadSeleccionada.setVida(unidadSeleccionada.getVida() + 1);
					unidadSeleccionada.setExperiencia(unidadSeleccionada.getExperiencia() - 1);
					MensajeEmergente.mostrarTexto("resources/images/tutorial/17.png");

				}
			}
			unidadSeleccionada = null;
			vf.getVen().getJpnMejoras().setVisible(false);
			vf.getVen().requestFocusInWindow();
			break;

		case "aumentar ataque":
			if (unidadSeleccionada != null) {
				if (unidadSeleccionada.getExperiencia() > 0) {
					unidadSeleccionada.setAtaque(unidadSeleccionada.getAtaque() + 1);
					unidadSeleccionada.setExperiencia(unidadSeleccionada.getExperiencia() - 1);
					MensajeEmergente.mostrarTexto("resources/images/tutorial/16.png");

				}
			}
			unidadSeleccionada = null;
			vf.getVen().getJpnMejoras().setVisible(false);
			vf.getVen().requestFocusInWindow();
			break;

		case "tutorial": {
			banderaTutorial = !(banderaTutorial);
			contadorTutorial++;

			if (contadorTutorial > 3) {
				contadorTutorial = 1;
			}
			switch (contadorTutorial) {
			case 1:
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif1.gif");
				break;
			case 2:
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif3.gif");
				break;
			case 3:
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif2.gif");
				break;
			}
			break;
		}
		case "shoot": {
			if (banderaTutorial == true) {
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif14.gif");
			}
			try {
				disparando = true;
				x = vf.getVen().getApuntadorX();
				y = vf.getVen().getApuntadorY();
				vf.getVen().getPanelAccion().setVisible(false);
				vf.getVen().requestFocusInWindow();
			} catch (TextoVacioException e2) {
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif14.gif");
			}
			break;
		}
		case "Salir": {
			System.exit(0);
			break;
		}
		case "iniciar": {
			vf.getVen().limpiarPaneles();
			vf.getVen().getJpnCaracteristicas().setVisible(true);
			vf.getVen().repaint();
			if (banderaTutorial == true) {
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif4.gif");
			}
			break;
		}

		case "partidas": {
			vf.getVen().limpiarPaneles();
			vf.getVen().getJpnPartidas().setVisible(true);
			vf.getVen().repaint();
			break;
		}

		case "volver": {
			vf.getVen().limpiarPaneles();
			vf.getVen().getJpnBienvenida().setVisible(true);
			vf.getVen().repaint();
			break;
		}

		case "volverBienvenida": {
			vf.getVen().limpiarPaneles();
			vf.getVen().getJpnBienvenida().setVisible(true);
			vf.getVen().repaint();
			break;
		}

		case "volverJugadores": {
			vf.getVen().limpiarPaneles();
			vf.getVen().getJpnCaracteristicas().setVisible(true);
			vf.getVen().repaint();
			break;
		}
		case "volver3Jugadores": {
			vf.getVen().limpiarPaneles();
			vf.getVen().getJpnCaracteristicas().setVisible(true);
			vf.getVen().repaint();
			break;
		}
		case "volver4Jugadores": {
			vf.getVen().limpiarPaneles();
			vf.getVen().getJpnCaracteristicas().setVisible(true);
			vf.getVen().repaint();
			break;
		}

		case "jugadores2": {
			try {
				turnos.setCantidadJugadores(2);
				turnos.getConteoTurnos().add(0);
				turnos.getConteoTurnos().add(1);

				String nombrePartida = vf.getVen().getJpnCaracteristicas().getTxtNombre().getText();
				revisarEspacioBlanco(nombrePartida);

				if (nombrePartida != null && !nombrePartida.trim().isEmpty()) {
					File archivoPartida = new File("partidas/" + nombrePartida + ".bin");
					if (archivoPartida.exists()) {
						MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
								"El nombre de la partida ya existe. Por favor elige uno diferente.", 180, 42, 500, 50);
						return;
					}
				}

				PartidaDTO partida = new PartidaDTO();
				partida.setNombre(nombrePartida);
				mf.setPartidaActual(partida);

				vf.getVen().limpiarPaneles();
				vf.getVen().getJpnJugadores2().setVisible(true);
				vf.getVen().getJpnCaracteristicas().limpiarPanelTexto();
				vf.getVen().repaint();
				if (banderaTutorial == true) {
					MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif5.gif");
				}
			} catch (TextoVacioException e1) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/2.png");
			}
			break;
		}

		case "correr2jugadores": {
			if (!verificarLabelsDeTropas(2)) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/6.png");
				return;
			}
			if (banderaTutorial == true) {
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif6.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif7.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif11.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif12.gif");
			}
			generarEquipos(banderaJugadores = 2);
			iniciarPartida();

			MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png", "El primero en jugar es el equipo Rojo",
					180, 42, 500, 50);
			break;
		}
		case "jugadores3": {
			try {
				turnos.setCantidadJugadores(3);
				turnos.getConteoTurnos().add(0);
				turnos.getConteoTurnos().add(1);

				String nombrePartida = vf.getVen().getJpnCaracteristicas().getTxtNombre().getText();
				revisarEspacioBlanco(nombrePartida);

				if (nombrePartida != null && !nombrePartida.trim().isEmpty()) {
					File archivoPartida = new File("partidas/" + nombrePartida + ".bin");
					if (archivoPartida.exists()) {
						MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
								"El nombre de la partida ya existe. Por favor elige uno diferente.", 180, 42, 500, 50);
						return;
					}
				}

				PartidaDTO partida = new PartidaDTO();
				partida.setNombre(nombrePartida);
				mf.setPartidaActual(partida);

				vf.getVen().limpiarPaneles();
				vf.getVen().getJpnJugadores3().setVisible(true);
				vf.getVen().getJpnCaracteristicas().limpiarPanelTexto();
				vf.getVen().repaint();
				if (banderaTutorial == true) {
					MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif5.gif");
				}
			} catch (TextoVacioException e1) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/2.png");
			}
			break;
		}

		case "correr3jugadores": {
			if (!verificarLabelsDeTropas(3)) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/6.png");
				return;
			}
			if (banderaTutorial == true) {
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif6.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif7.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif11.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif12.gif");
			}
			generarEquipos(banderaJugadores = 3);
			iniciarPartida();

			MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png", "El primero en jugar es el equipo Rojo",
					180, 42, 500, 50);
			break;
		}

		case "jugadores4": {
			try {
				turnos.setCantidadJugadores(4);
				turnos.getConteoTurnos().add(0);
				turnos.getConteoTurnos().add(1);

				String nombrePartida = vf.getVen().getJpnCaracteristicas().getTxtNombre().getText();
				revisarEspacioBlanco(nombrePartida);

				if (nombrePartida != null && !nombrePartida.trim().isEmpty()) {
					File archivoPartida = new File("partidas/" + nombrePartida + ".bin");
					if (archivoPartida.exists()) {
						MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png",
								"El nombre de la partida ya existe. Por favor elige uno diferente.", 180, 42, 500, 50);
						return;
					}
				}

				PartidaDTO partida = new PartidaDTO();
				partida.setNombre(nombrePartida);
				mf.setPartidaActual(partida);

				vf.getVen().limpiarPaneles();
				vf.getVen().getJpnJugadores4().setVisible(true);
				vf.getVen().getJpnCaracteristicas().limpiarPanelTexto();
				vf.getVen().repaint();
				if (banderaTutorial == true) {
					MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif5.gif");
				}
			} catch (TextoVacioException e1) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/2.png");
			}
			break;
		}

		case "correr4jugadores": {
			if (!verificarLabelsDeTropas(4)) {
				MensajeEmergente.mostrarTexto("resources/images/tutorial/6.png");
				return;
			}
			if (banderaTutorial == true) {
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif6.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif7.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif11.gif");
				MensajeEmergente.mostrarTutorial("resources/images/tutorial/Gif12.gif");
			}
			generarEquipos(banderaJugadores = 4);
			iniciarPartida();

			MensajeEmergente.mostrarInfo("resources/images/tutorial/12.png", "El primero en jugar es el equipo Rojo",
					180, 42, 500, 50);
			break;
		}
		case "continuar": {
			vf.getVen().getJpnPausa().setVisible(false);
			vf.getVen().requestFocusInWindow();
			break;
		}
		case "volver Game Over": {
			System.exit(0);
			break;
		}

		case "Guardar Partida": {
			PartidaDTO partidaActual = mf.getPartidaActual();
			partidaActual.setListaEquipos(mf.getEquipoDAO().getListaEquipos());
			partidaActual.setMatrizUnidades(matrizUnidades);
			partidaActual.setMatrizPaneles(vf.getVen().getMatrizPanel());
			partidaActual.setNumJugadores(banderaJugadores);

			partidaActual.setEquipoActual(equipoActual);
			partidaActual.setMovimientosRestantes(movimientosRestantes);
			partidaActual.setIndiceTurnoActual(indiceTurnoActual);

			if (partidaActual != null) {
				guardarPartida(partidaActual);
			}
			System.exit(0);
			break;
		}

		case "cargar partida": {
			PartidaDTO partidaCargada = cargarPartida();
			if (partidaCargada != null) {
				banderaJugadores = partidaCargada.getNumJugadores();
				matrizUnidades = partidaCargada.getMatrizUnidades();
				vf.getVen().limpiarVentana();
				mf.setPartidaActual(partidaCargada);
				vf.getVen().cargarPartida(partidaCargada.getMatrizPaneles());

				configurarTurnos(banderaJugadores);

				equipoActual = partidaCargada.getEquipoActual();
				movimientosRestantes = partidaCargada.getMovimientosRestantes();
				indiceTurnoActual = partidaCargada.getIndiceTurnoActual();

				MensajeEmergente
						.mostrarInfo(
								"resources/images/tutorial/12.png", "Empieza la partida con el equipo: " + equipoActual
										+ " Y le quedan " + movimientosRestantes + " movimientos restantes",
								180, 42, 500, 50);
			}
			addListenersPartida();
			break;
		}

		case "Salir Partida": {
			removeListenersPartida();
			break;
		}

		case "enhancements": {
			if (unidadSeleccionada != null && unidadSeleccionada.getExperiencia() >= 1) {
				vf.getVen().getPanelAccion().setVisible(false);
				vf.getVen().getJpnMejoras().setVisible(true);
				vf.getVen().requestFocusInWindow();
				vf.getVen().repaint();
			} else {
				vf.getVen().getPanelAccion().setVisible(false);
				MensajeEmergente.mostrarTexto("resources/images/tutorial/1.png");
				unidadSeleccionada = null;
			}
			break;
		}
		}

	}

	/**
	 * Handles the keystroke event.
	 *
	 * @param e the key event that has occurred.
	 */
	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Handles the key release event.
	 *
	 * @param e the key event that has occurred.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
	}

	/**
	 * Handles the keystroke event, including the movement of the pointer and the
	 * actions associated with the keys.
	 *
	 * @param e the key event that has occurred.
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		int tecla = e.getKeyCode();
		int llegadaX;
		int llegadaY;

		switch (tecla) {
		case KeyEvent.VK_UP:
			if (vf.getVen().getPanelAccion().isVisible() || vf.getVen().getJpnPausa().isVisible()
					|| vf.getVen().getJpnPeleas().isVisible()) {
				return;
			}
			if (espacioLibre(vf.getVen().getApuntadorY() - 1, vf.getVen().getApuntadorX())) {
				vf.getVen().setApuntadorY(vf.getVen().getApuntadorY() - 1);
			}
			break;
		case KeyEvent.VK_DOWN:
			if (vf.getVen().getPanelAccion().isVisible() || vf.getVen().getJpnPausa().isVisible()
					|| vf.getVen().getJpnPeleas().isVisible()) {
				return;
			}

			if (espacioLibre(vf.getVen().getApuntadorY() + 1, vf.getVen().getApuntadorX())) {
				vf.getVen().setApuntadorY(vf.getVen().getApuntadorY() + 1);
			}
			break;
		case KeyEvent.VK_LEFT:
			if (vf.getVen().getPanelAccion().isVisible() || vf.getVen().getJpnPausa().isVisible()
					|| vf.getVen().getJpnPeleas().isVisible()) {
				return;
			}
			if (espacioLibre(vf.getVen().getApuntadorY(), vf.getVen().getApuntadorX() - 1)) {
				vf.getVen().setApuntadorX(vf.getVen().getApuntadorX() - 1);
			}
			break;

		case KeyEvent.VK_RIGHT:
			if (vf.getVen().getPanelAccion().isVisible() || vf.getVen().getJpnPausa().isVisible()
					|| vf.getVen().getJpnPeleas().isVisible()) {
				return;
			}
			if (espacioLibre(vf.getVen().getApuntadorY(), vf.getVen().getApuntadorX() + 1)) {
				vf.getVen().setApuntadorX(vf.getVen().getApuntadorX() + 1);
			}
			break;

		case KeyEvent.VK_SPACE:
			int apuntadorX = vf.getVen().getApuntadorX();
			int apuntadorY = vf.getVen().getApuntadorY();

			if (unidadSeleccionada != null || vf.getVen().getPanelAccion().isVisible()
					|| vf.getVen().getJpnPausa().isVisible() || vf.getVen().getJpnPeleas().isVisible()) {
				return;
			}

			if (vf.getVen().getMatrizPanel()[apuntadorY][apuntadorX] instanceof PanelCampo) {
				PanelCampo panel = (PanelCampo) vf.getVen().getMatrizPanel()[apuntadorY][apuntadorX];

				if (panel.tienePersonaje()) {
					unidadSeleccionada = matrizUnidades[apuntadorY][apuntadorX];
					String equipoPersonaje = unidadSeleccionada.getEquipo();

					if (esTurnoDelEquipo(equipoPersonaje)) {
						vf.getVen().getPanelAccion().setVisible(!vf.getVen().getPanelAccion().isVisible());
						x = apuntadorX;
						y = apuntadorY;
					} else {
						MensajeEmergente.mostrarTexto("resources/images/tutorial/3.png");
						unidadSeleccionada = null;
					}
				} else {
					vf.getVen().getPanelAccion().setVisible(false);
					unidadSeleccionada = null;
				}
			}
			break;

		case KeyEvent.VK_P:

			vf.getVen().getJpnPausa().setVisible(!vf.getVen().getJpnPausa().isVisible());
			break;

		case KeyEvent.VK_T:
			if (vf.getVen().getPanelAccion().isVisible() || vf.getVen().getJpnPausa().isVisible()
					|| vf.getVen().getJpnPeleas().isVisible()) {
				return;
			}
			if (unidadSeleccionada != null) {

				unidadSeleccionada = null;
				moviendo = false;
				disparando = false;
				restaurarPanelesMovimiento();
			}

			cambiarTurno();
			actualizarApuntadorParaNuevoTurno(equipoActual);
			break;

		case KeyEvent.VK_ENTER:
			if (juegoTerminado) {
				return;
			}

			llegadaX = vf.getVen().getApuntadorX();
			llegadaY = vf.getVen().getApuntadorY();

			if (moviendo) {
				if (esTurnoDelEquipo(matrizUnidades[y][x].getEquipo())) {
					if (esCasillaValida(llegadaX, llegadaY)) {
						if (vf.getVen().getMatrizPanel()[llegadaY][llegadaX] instanceof PanelCampo) {
							PanelCampo panelDestino = (PanelCampo) vf.getVen().getMatrizPanel()[llegadaY][llegadaX];
							if (!panelDestino.tienePersonaje()) {
								PanelCampo panelOrigen = (PanelCampo) vf.getVen().getMatrizPanel()[y][x];
								panelDestino.addPersonaje(panelOrigen.getPersonajeImage());
								panelOrigen.removePersonaje();
								vf.getVen().actualizarApuntador();

								matrizUnidades[llegadaY][llegadaX] = matrizUnidades[y][x];
								matrizUnidades[y][x] = null;

								moviendo = false;

								restaurarPanelesMovimiento();

								boolean edificioCapturado = vf.getVen().verificarCapturaEdificio(llegadaX, llegadaY,
										matrizUnidades[llegadaY][llegadaX].getEquipo());

								if (edificioCapturado) {
									matrizUnidades[llegadaY][llegadaX]
											.setExperiencia(matrizUnidades[llegadaY][llegadaX].getExperiencia() + 1);

								}

								controlarTurnos(llegadaX, llegadaY);
								realizarAccionEquipo();

								unidadSeleccionada = null;
							}
						}
					} else {
						MensajeEmergente.mostrarTexto("resources/images/tutorial/5.png");
						return;
					}
				} else {
					MensajeEmergente.mostrarTexto("resources/images/tutorial/3.png");
					return;
				}
			}

			if (disparando) {
				if (esTurnoDelEquipo(matrizUnidades[y][x].getEquipo())) {
					disparar();
					controlarTurnos(llegadaX, llegadaY);

					unidadSeleccionada = null;
				}
			}
			break;

		case KeyEvent.VK_ESCAPE:
			if (unidadSeleccionada != null) {
				unidadSeleccionada = null;
				moviendo = false;
				disparando = false;

				vf.getVen().getPanelAccion().setVisible(false);
				restaurarPanelesMovimiento();
			}
			break;
		}
		vf.getVen().actualizarApuntador();
	}

	/**
	 * Gets the team name of the unit located at the specified position. If there is
	 * no unit at the position, returns null.
	 *
	 * @param y The Y coordinate of the position
	 * @param x The X coordinate of the position
	 * @return The team name of the unit at the specified position, or null if no
	 *         unit is present
	 */
	private String obtenerEquipoEnPosicion(int y, int x) {
		if (matrizUnidades[y][x] != null) {
			return matrizUnidades[y][x].getEquipo();
		}
		return null;
	}
}
