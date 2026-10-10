package co.edu.unbosque.model.persistence;

/**
 * The EquipoCRUDOperation interface defines the CRUD operations (Create, Read,
 * Update, Delete) specific to the team entity, Update, Delete) specific to the
 * equipment entity, using the color as the unique identifier of each team.
 * 
 * @param <E> The type of the equipment entity.
 * 
 *            Main methods:
 * 
 *            - {@link #create(Object)}: Creates a new team. -
 *            {@link #update(String, Object)}: Updates an existing team. based
 *            on its color. - {@link #delete(String)}: Deletes a specific *
 *            equipmentby its color. based on its color. -
 *            {@link #findOne(String)}: Finds and returns a team by its color.
 * 
 *            This interface is used by the DAO classes that handle the
 *            persistence of teams in the game.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public interface EquipoCRUDOperation<E> {
	/**
	 * Create a new computer.
	 * 
	 * @param data The entity of the team to be created.
	 */
	public void create(E data);

	/**
	 * Updates an existing team based on its color.
	 * 
	 * @param color   The color of the team to update.
	 * @param newData The new data that will replace the existing team.
	 */
	public void update(String color, E newData);

	/**
	 * Deletes a team by its color.
	 * 
	 * @param color The color of the team to delete.
	 */
	public void delete(String color);

	/**
	 * Searches for a specific team by its color.
	 * 
	 * @param color The color of the team to search for.
	 * @return The entity of the team found, or null if it does not exist.
	 */
	public E findOne(String color);
}
