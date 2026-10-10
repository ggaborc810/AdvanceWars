package co.edu.unbosque.model;

import java.util.ArrayList;

/**
 * This class is about game turns, including the history of positions, the count
 * of turns, the current turn, the number of moves in a turn, and the number of
 * players.
 */
public class TurnosDTO {
	/**
	 * Stores the history of recent positions for each team.
	 */
	private ArrayList<String> ultimasPosicioneStrings;

	/**
	 * Tracks the count of turns for each team.
	 */
	private ArrayList<Integer> conteoTurnos;

	/**
	 * Represents the current team's turn.
	 */
	private String turnoActual;

	/**
	 * Tracks the current move within a turn.
	 */
	private int jugada;

	/**
	 * Stores the total number of players in the game.
	 */
	private int cantidadJugadores;

	/**
	 * Default constructor initializing lists and setting default values.
	 */
	public TurnosDTO() {
		ultimasPosicioneStrings = new ArrayList<>();
		conteoTurnos = new ArrayList<>();
		turnoActual = new String();
		jugada = 0;
		cantidadJugadores = 0;
	}

	/**
	 * Constructor that initializes all attributes of TurnosDTO.
	 *
	 * @param ultimasPosicioneStrings The list of recent positions
	 * @param conteoTurnos            The list that tracks turn counts
	 * @param turnoActual             The current turn
	 * @param jugada                  The current move in a turn
	 * @param cantidadJugadores       The number of players in the game
	 */
	public TurnosDTO(ArrayList<String> ultimasPosicioneStrings, ArrayList<Integer> conteoTurnos, String turnoActual,
			int jugada, int cantidadJugadores) {
		super();
		this.ultimasPosicioneStrings = ultimasPosicioneStrings;
		this.conteoTurnos = conteoTurnos;
		this.turnoActual = turnoActual;
		this.jugada = jugada;
		this.cantidadJugadores = cantidadJugadores;
	}

	/**
	 * Gets the list of recent positions.
	 *
	 * @return The list of recent positions
	 */
	public ArrayList<String> getUltimasPosicioneStrings() {
		return ultimasPosicioneStrings;
	}

	/**
	 * Sets the list of recent positions.
	 *
	 * @param ultimasPosicioneStrings The list of recent positions to set
	 */
	public void setUltimasPosicioneStrings(ArrayList<String> ultimasPosicioneStrings) {
		this.ultimasPosicioneStrings = ultimasPosicioneStrings;
	}

	/**
	 * Gets the list of turn counts.
	 *
	 * @return The list of turn counts
	 */
	public ArrayList<Integer> getConteoTurnos() {
		return conteoTurnos;
	}

	/**
	 * Sets the list of turn counts.
	 *
	 * @param conteoTurnos The list of turn counts to set
	 */
	public void setConteoTurnos(ArrayList<Integer> conteoTurnos) {
		this.conteoTurnos = conteoTurnos;
	}

	/**
	 * Gets the current turn.
	 *
	 * @return The current turn
	 */
	public String getTurnoActual() {
		return turnoActual;
	}

	/**
	 * Sets the current turn.
	 *
	 * @param turnoActual The current turn to set
	 */
	public void setTurnoActual(String turnoActual) {
		this.turnoActual = turnoActual;
	}

	/**
	 * Gets the current move within a turn.
	 *
	 * @return The current move in a turn
	 */
	public int getJugada() {
		return jugada;
	}

	/**
	 * Sets the current move within a turn.
	 *
	 * @param jugada The current move in a turn to set
	 */
	public void setJugada(int jugada) {
		this.jugada = jugada;
	}

	/**
	 * Gets the number of players in the game.
	 *
	 * @return The number of players
	 */
	public int getCantidadJugadores() {
		return cantidadJugadores;
	}

	/**
	 * Sets the number of players in the game.
	 *
	 * @param cantidadJugadores The number of players to set
	 */
	public void setCantidadJugadores(int cantidadJugadores) {
		this.cantidadJugadores = cantidadJugadores;
	}
}