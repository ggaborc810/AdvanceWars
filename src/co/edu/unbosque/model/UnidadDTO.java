package co.edu.unbosque.model;

import java.io.Serializable;

/**
 * The class UnidadDTO represents a unit in the game.
 * 
 * This class contains attributes that define the characteristics of a unit,
 * such as life, attack, defense, experience and type.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class UnidadDTO implements Serializable {
	/**
	 * Serial Version UID for the serialization of the class.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The team of the unit.
	 */
	private String equipo;

	/**
	 * The health points of the unit.
	 */
	private int vida;

	/**
	 * The attack power of the unit.
	 */
	private int ataque;

	/**
	 * The experience points of the unit.
	 */
	private int experiencia;

	/**
	 * The type of the unit (e.g., Soldier, Tank, etc.).
	 */
	private String tipo;

	/**
	 * Default constructor of the class UnidadDTO.
	 */
	public UnidadDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor that initializes the unit with the given parameters.
	 * 
	 * @param vida        The amount of life of the unit.
	 * @param ataque      The amount of attack of the unit.
	 * @param defensa     The amount of defense of the unit.
	 * @param experiencia The amount of experience accumulated by the unit.
	 * @param tipo        The type of the unit (e.g. “soldier”, “tank”).
	 */
	public UnidadDTO(String equipo, int vida, int ataque, int experiencia, String tipo) {
		super();
		this.equipo = equipo;
		this.vida = vida;
		this.ataque = ataque;
		this.experiencia = experiencia;
		this.tipo = tipo;
	}
//Getters y Setters
	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	/**
	 * Gets the amount of life of the unit.
	 * 
	 * @return The amount of life of the unit.
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Sets the amount of life of the unit.
	 * 
	 * @param life The new life amount of the unit.
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * Gets the attack amount of the unit.
	 * 
	 * @return The attack amount of the unit.
	 */
	public int getAtaque() {
		return ataque;
	}

	/**
	 * Sets the attack amount of the unit.
	 * 
	 * @param attack The new attack amount of the unit.
	 */
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	/**
	 * Gets the experience accumulated by the unit.
	 * 
	 * @return The experience accumulated by the unit.
	 */
	public int getExperiencia() {
		return experiencia;
	}

	/**
	 * Sets the experience accumulated by the unit.
	 * 
	 * @param experience The new amount of experience accumulated by the unit.
	 */
	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * Gets the type of the unit.
	 * 
	 * @return The type of the unit.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Sets the type of the unit.
	 * 
	 * @param type The new type of the unit.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Returns a string representation of the unit.
	 * 
	 * @return A string representing the unit.
	 */
	@Override
	public String toString() {
		return " Personaje: " + tipo + ", Equipo:" + equipo + ", Vida:" + vida + ", Ataque:" + ataque + ", XP:"
				+ experiencia;
	}

}