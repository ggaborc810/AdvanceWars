package co.edu.unbosque.model;

import java.io.Serializable;

import co.edu.unbosque.util.structure.MyLinkedList;

/**
 * The EquipoDTO class represents a team in the game. It contains information.
 * about the color of the team and a list of units that compose it. This class
 * implements the {@link Serializable} interface to allow serialization of the
 * team object. of the team object.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class EquipoDTO implements Serializable {
	/**
	 * Serial Version UID for the serialization of the class.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The color of the team.
	 */
	private String color;

	/**
	 * List of units belonging to the team.
	 */
	private MyLinkedList<UnidadDTO> listaUnidades;

	/**
	 * Default constructor that initializes a new unit.
	 */
	public EquipoDTO() {
	}

	/**
	 * Constructor that initializes a team with the specified color and unit list.
	 * specified.
	 *
	 * @param color    The color of the unit.
	 * @param unitlist The list of units belonging to the rig.
	 */
	public EquipoDTO(String color, MyLinkedList<UnidadDTO> listaUnidades) {
		super();
		this.color = color;
		this.listaUnidades = listaUnidades;
	}

	/**
	 * Gets the color of the team.
	 *
	 * @return The color of the team.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color of the team.
	 *
	 * @param color The team color.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the list of units in the team.
	 *
	 * @return The list of units.
	 */
	public MyLinkedList<UnidadDTO> getListaUnidades() {
		return listaUnidades;
	}

	/**
	 * * Sets the list of units in the team.
	 *
	 * @param listUnits The new list of units.
	 */
	public void setListaUnidades(MyLinkedList<UnidadDTO> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}

}
