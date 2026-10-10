package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.EquipoDTO;
import co.edu.unbosque.model.PartidaDTO;
import co.edu.unbosque.util.structure.MyLinkedList;

/**
 * The {@link PartidaDAO} class is responsible for managing CRUD operations for
 * the {@link PartidaDTO} class. It uses a custom data structure,
 * {@link MyLinkedList}, to store and manipulate the list of games.
 * 
 * Main methods:
 * 
 * - {@link #create(PartidaDTO)}: Creates a new game and adds it to the list of
 * games. - {@link #update(String, PartidaDTO)}: Updates the data of an existing
 * game identified by its name. - {@link #delete(String)}: Removes a game from
 * the list based on its name. - {@link #findOne(String)}: Searches for and
 * retrieves a specific game by its name. -
 * {@link #crerEquipoEnPartida(String, EquipoDTO)}: Adds a team to a specific
 * game. - {@link #borrarEquipoEnPartida(String, String)}: Removes a team from a
 * game based on its name and team color. -
 * {@link #updateEquipoEnPartida(String, String, EquipoDTO)}: Updates a team
 * within a game based on its color. - {@link #findOneEquipo(String, String)}:
 * Searches for and retrieves a specific team within a game by its team color.
 *
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PartidaDAO {
	/**
	 * The {@code MyLinkedList} that stores the game sessions ({@link PartidaDTO}).
	 * 
	 * This linked list allows for efficient addition, removal, and retrieval of
	 * game session objects.
	 */
	private MyLinkedList<PartidaDTO> listaPartidas;

	/**
	 * Constructor that initializes the list of games as a new {@link MyLinkedList}.
	 */
	public PartidaDAO() {
		listaPartidas = new MyLinkedList<>();
	}

	/**
	 * Creates a new game and adds it to the end of the list.
	 * 
	 * @param data The {@link PartidaDTO} object representing the game to be
	 *             created.
	 */
	public void create(PartidaDTO data) {
		listaPartidas.agregarFinal(data);
	}

	/**
	 * Updates an existing game identified by its name.
	 * 
	 * @param nombre  The name of the game to be updated.
	 * @param newData The new {@link PartidaDTO} object with updated data.
	 */
	public void update(String nombre, PartidaDTO newData) {
		listaPartidas.get(findOne(nombre)).setInfo(newData);
	}

	/**
	 * Deletes a game from the list based on its name.
	 * 
	 * @param nombre The name of the game to be deleted.
	 */
	public void delete(String nombre) {
		if (findOne(nombre) != null) {
			listaPartidas.extract(findOne(nombre));
		}
	}

	/**
	 * Searches for and returns a specific game by its name.
	 * 
	 * @param nombre The name of the game to be found.
	 * @return The corresponding {@link PartidaDTO} object or null if not found.
	 */
	public PartidaDTO findOne(String nombre) {
		for (int i = 0; i < listaPartidas.size(); i++) {
			if (listaPartidas.get(i).getInfo().getNombre().equals(nombre)) {
				return listaPartidas.get(i).getInfo();
			}
		}
		return null;
	}

	/**
	 * Adds a team to a specific game.
	 * 
	 * @param nombre The name of the game to which the team will be added.
	 * @param data   The {@link EquipoDTO} object representing the team to be added.
	 */
	public void crerEquipoEnPartida(String nombre, EquipoDTO data) {
		listaPartidas.get(findOne(nombre)).getInfo().getListaEquipos().add(data);
	}

	/**
	 * Deletes a team from a game based on its name and team color.
	 * 
	 * @param nombre The name of the game.
	 * @param color  The color of the team to be deleted.
	 */
	public void borrarEquipoEnPartida(String nombre, String color) {
		listaPartidas.get(findOne(nombre)).getInfo().getListaEquipos().extract(findOneEquipo(nombre, color));
	}

	/**
	 * Updates a team within a game based on its color.
	 * 
	 * @param nombre The name of the game.
	 * @param color  The color of the team to be updated.
	 * @param data   The {@link EquipoDTO} object with updated team data.
	 */
	public void updateEquipoEnPartida(String nombre, String color, EquipoDTO data) {
		listaPartidas.get(findOne(nombre)).getInfo().getListaEquipos().get(findOneEquipo(nombre, color)).setInfo(data);
	}

	/**
	 * Searches for and returns a specific team within a game by its team color.
	 * 
	 * @param nombre The name of the game.
	 * @param color  The color of the team to be found.
	 * @return The corresponding {@link EquipoDTO} object or null if not found.
	 */
	public EquipoDTO findOneEquipo(String nombre, String color) {
		for (int i = 0; i < listaPartidas.get(findOne(nombre)).getInfo().getListaEquipos().size(); i++) {
			if (listaPartidas.get(findOne(nombre)).getInfo().getListaEquipos().get(i).getInfo().getColor()
					.equals(color)) {
				return listaPartidas.get(findOne(nombre)).getInfo().getListaEquipos().get(i).getInfo();
			}
		}
		return null;
	}
}
