package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.Arrays;

import javax.swing.JPanel;

import co.edu.unbosque.util.structure.MyLinkedList;

/**
 * The class PartidaDTO represents a game item in the game.
 * 
 * This class contains information about the name of the game, the number of
 * players, the panel matrix, the unit matrix, and the team list.
 * 
 * Represents the array of panels, the array of units, and the list of teams
 * participating in the game.
 * 
 * @author
 */
public class PartidaDTO implements Serializable {
	/**
	 * Serial Version UID for the serialization of the class.
	 */
	private static final long serialVersionUID = 2982997416225244224L;

	/**
	 * Name of the game session.
	 */
	private String nombre;

	/**
	 * Number of players in the game session.
	 */
	private int numJugadores;

	/**
	 * 2D array of JPanel objects representing the game board.
	 */
	private JPanel[][] matrizPaneles;

	/**
	 * 2D array of UnidadDTO objects representing the units in the game session.
	 */
	private UnidadDTO[][] matrizUnidades;

	/**
	 * List of teams participating in the game session.
	 */
	private MyLinkedList<EquipoDTO> listaEquipos;

	/**
	 * The current team that has the turn.
	 */
	private String equipoActual;

	/**
	 * The number of remaining moves for the current turn.
	 */
	private int movimientosRestantes;

	/**
	 * Index of the current turn in the turn order list.
	 */
	private int indiceTurnoActual;

	/**
	 * Default constructor of the class PartidaDTO.
	 */
	public PartidaDTO() {
		// Constructor vacío
	}

	/**
	 * Constructor that initializes the game with the given parameters.
	 * 
	 * @param nombre               The name of the game.
	 * @param numJugadores         The number of players in the game.
	 * @param matrizPaneles        The array of panels representing the state of the
	 *                             game.
	 * @param matrizUnidades       The array of units that are in play.
	 * @param listaEquipos         The list of teams participating in the game.
	 * @param equipoActual         The team that currently has the turn.
	 * @param movimientosRestantes The number of moves remaining for the current
	 *                             turn.
	 * @param indiceTurnoActual    The index of the current turn in the list of turn
	 *                             order.
	 */
	public PartidaDTO(String nombre, int numJugadores, JPanel[][] matrizPaneles, UnidadDTO[][] matrizUnidades,
			MyLinkedList<EquipoDTO> listaEquipos, String equipoActual, int movimientosRestantes,
			int indiceTurnoActual) {
		this.nombre = nombre;
		this.numJugadores = numJugadores;
		this.matrizPaneles = matrizPaneles;
		this.matrizUnidades = matrizUnidades;
		this.listaEquipos = listaEquipos;
		this.equipoActual = equipoActual;
		this.movimientosRestantes = movimientosRestantes;
		this.indiceTurnoActual = indiceTurnoActual;
	}

	/**
	 * Gets the name of the game session.
	 * 
	 * @return The name of the game session.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the name of the game session.
	 * 
	 * @param nombre The new name of the game session.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the number of players in the game.
	 * 
	 * @return The number of players in the game.
	 */
	public int getNumJugadores() {
		return numJugadores;
	}

	/**
	 * Sets the number of players in the game.
	 * 
	 * @param numJugadores The new number of players in the game.
	 */
	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	/**
	 * Gets the array of panels for the game.
	 * 
	 * @return The array of panels.
	 */
	public JPanel[][] getMatrizPaneles() {
		return matrizPaneles;
	}

	/**
	 * Sets the starting array of panels.
	 * 
	 * @param matrizPaneles The new panel array.
	 */
	public void setMatrizPaneles(JPanel[][] matrizPaneles) {
		this.matrizPaneles = matrizPaneles;
	}

	/**
	 * Gets the unit matrix of the game session.
	 * 
	 * @return The unit array.
	 */
	public UnidadDTO[][] getMatrizUnidades() {
		return matrizUnidades;
	}

	/**
	 * Sets the units array of the game session.
	 * 
	 * @param matrizUnidades The new units array.
	 */
	public void setMatrizUnidades(UnidadDTO[][] matrizUnidades) {
		this.matrizUnidades = matrizUnidades;
	}

	/**
	 * Gets the list of teams in the game session.
	 * 
	 * @return The list of teams.
	 */
	public MyLinkedList<EquipoDTO> getListaEquipos() {
		return listaEquipos;
	}

	/**
	 * Sets the list of teams in the game session.
	 * 
	 * @param listaEquipos The new list of teams.
	 */
	public void setListaEquipos(MyLinkedList<EquipoDTO> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

	/**
	 * Gets the current team that has the turn.
	 * 
	 * @return The current team in turn.
	 */
	public String getEquipoActual() {
		return equipoActual;
	}

	/**
	 * Sets the current team that has the turn.
	 * 
	 * @param equipoActual The new current team in turn.
	 */
	public void setEquipoActual(String equipoActual) {
		this.equipoActual = equipoActual;
	}

	/**
	 * Gets the number of remaining moves for the current team.
	 * 
	 * @return The number of remaining moves.
	 */
	public int getMovimientosRestantes() {
		return movimientosRestantes;
	}

	/**
	 * Sets the number of remaining moves for the current team.
	 * 
	 * @param movimientosRestantes The new number of remaining moves.
	 */
	public void setMovimientosRestantes(int movimientosRestantes) {
		this.movimientosRestantes = movimientosRestantes;
	}

	/**
	 * Gets the index of the current turn in the turn order list.
	 * 
	 * @return The index of the current turn.
	 */
	public int getIndiceTurnoActual() {
		return indiceTurnoActual;
	}

	/**
	 * Sets the index of the current turn in the turn order list.
	 * 
	 * @param indiceTurnoActual The new index of the current turn.
	 */
	public void setIndiceTurnoActual(int indiceTurnoActual) {
		this.indiceTurnoActual = indiceTurnoActual;
	}

	/**
	 * Returns a string representation of the match.
	 * 
	 * @return A string representing the match.
	 */
	@Override
	public String toString() {
		return "PartidaDTO [nombre=" + nombre + ", numJugadores=" + numJugadores + ", matrizPaneles="
				+ Arrays.toString(matrizPaneles) + ", matrizUnidades=" + Arrays.toString(matrizUnidades)
				+ ", listaEquipos=" + listaEquipos + ", equipoActual=" + equipoActual + ", movimientosRestantes="
				+ movimientosRestantes + ", indiceTurnoActual=" + indiceTurnoActual + "]";
	}
}
