package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.UnidadDTO;
import co.edu.unbosque.util.structure.MyLinkedList;

/**
 * The EquipoDAO class implements the CRUD operations to handle the persistence
 * of objects {@linkTeamDAO}, which represent teams in the persistence of
 * {@link TeamDTO} objects, which represent teams in the system. system.
 * 
 * In addition, it provides additional methods to manage the units within each
 * team. each team.
 * 
 * Main methods:
 * 
 * - {@link #create(TeamDTO)}: Creates a new team. -
 * {@link #update(String, TeamDTO)}: Updates an existing team based on. its
 * color. - {@link #delete(String)}: Deletes a specific team based on its.
 * color. - {@link #findOne(String)}: Finds and returns a team by its color. -
 * {@link #createUnitInTeam(String, UnitDTO)}: Adds a new unit to. a team. -
 * {@link #deleteTeamUnit(String, int)}: Deletes a specific unit specific unit
 * from a team.
 * 
 * This class uses a custom linked list to store the teams and manage their
 * persistence .
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */

public class EquipoDAO implements EquipoCRUDOperation<EquipoDTO> {
	/**
	 * The list of teams represented as a {@link MyLinkedList}.
	 * 
	 * This list holds all the team objects managed by this DAO and allows for
	 * operations such as adding, removing, and retrieving teams.
	 */
	private MyLinkedList<EquipoDTO> listaEquipos;

	/**
	 * Constructor that initializes the equipment list.
	 */
	public EquipoDAO() {
		listaEquipos = new MyLinkedList<>();
	}

	/**
	 * Initializes or resets the equipment list.
	 */
	public void init() {
		listaEquipos = new MyLinkedList<>();
	}

	/**
	 * Creates a new team and adds it to the team list.
	 * 
	 * @param data The team to be added.
	 */
	@Override
	public void create(EquipoDTO data) {
		listaEquipos.add(data);
	}

	/**
	 * Updates an existing team based on its color.
	 * 
	 * @param color   The color of the team to update.
	 * @param newData The new data of the equipment.
	 */
	@Override
	public void update(String color, EquipoDTO newData) {
		listaEquipos.get(findOne(color)).setInfo(newData);
	}

	/**
	 * Removes a team from the list based on its color.
	 * 
	 * @param color The color of the team to remove.
	 */
	@Override
	public void delete(String color) {
		if (findOne(color) != null) {
			listaEquipos.extract(findOne(color));
		}
	}

	/**
	 * Finds and returns a team by its color.
	 * 
	 * @param color The color of the team to search for.
	 * @return The team found or null if it does not exist.
	 */
	@Override
	public EquipoDTO findOne(String color) {
		for (int i = 0; i < listaEquipos.size(); i++) {
			if (listaEquipos.get(i).getInfo().getColor().equals(color)) {
				return listaEquipos.get(i).getInfo();
			}
		}
		return null;
	}

	/**
	 * Adds a new unit to a specific team identified by its color.
	 * 
	 * @param color The color of the unit.
	 * @param data  The unit to add to the team.
	 */
	public void crearUnidadEnEquipo(String color, UnidadDTO data) {
		listaEquipos.get(findOne(color)).getInfo().getListaUnidades().add(data);
	}

	/**
	 * Removes a unit from a specific equipment identified by its color.
	 * 
	 * @param color    The color of the unit.
	 * @param idUnidad The ID of the unit to delete.
	 */
	public void borrarUnidadDeEquipo(String color, int idUnidad) {
		listaEquipos.get(findOne(color)).getInfo().getListaUnidades().extract(findOneUnidad(color, idUnidad));
	}

	/**
	 * Finds and returns a specific unit of a team.
	 * 
	 * @param color    The color of the unit.
	 * @param idUnidad The ID of the unit to search for.
	 * @return The unit found or null if it does not exist.
	 */
	public UnidadDTO findOneUnidad(String color, int idUnidad) {
		for (int i = 0; i < listaEquipos.get(findOne(color)).getInfo().getListaUnidades().size(); i++) {
			if (listaEquipos.get(findOne(color)).getInfo().getListaUnidades().get(i).getInfo()
					.equals(listaEquipos.get(findOne(color)).getInfo().getListaUnidades().get(idUnidad).getInfo())) {
				return listaEquipos.get(findOne(color)).getInfo().getListaUnidades().get(i).getInfo();
			}
		}
		return null;
	}

	/**
	 * Returns the list of teams.
	 * 
	 * @return The list of teams.
	 */
	public MyLinkedList<EquipoDTO> getListaEquipos() {
		return listaEquipos;
	}

	/**
	 * Sets the equipment list.
	 * 
	 * @param listaEquipos list The new equipment list.
	 */
	public void setListaEquipos(MyLinkedList<EquipoDTO> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

}
