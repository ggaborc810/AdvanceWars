package co.edu.unbosque.model.persistence;

/**
 * The CRUDOperation interface defines the basic operations of a CRUD (Create,
 * Read, Update, Delete) for an entity of generic type.
 * 
 * @param <E> The type of the entity on which the operations are executed.
 * 
 *            Main methods:
 * 
 *            - {@link #create(Object)}: Creates a new instance of the entity.
 *            -{@link #update(int, Object)}: Updates an existing instance. of
 *            the entity at a specific index. - {@link #delete(int)}: Deletes an
 *            instance of the entity at a specified index.
 *            -{@link #findOne(int)}: Finds and returns an instance of the.
 *            entity according to an index.
 * 
 *            This interface is used by DAO classes that handle the *
 *            persistence of different entities. persistence of different
 *            entities.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public interface CRUDOperation<E> {
	/**
	 * Creates a new instance of the entity.
	 * 
	 * @param data The entity to be created.
	 */
	public void create(E data);

	/**
	 * Updates an existing entity at a specific index.
	 * 
	 * @param index   The index of the entity to update.
	 * @param newData The new data that will replace the existing entity.
	 */
	public void update(int index, E newData);

	/**
	 * Deletes an entity at a specific index.
	 * 
	 * @param index The index of the entity to delete.
	 */
	public void delete(int index);

	/**
	 * Finds an entity at a specific index.
	 * 
	 * @param index The index of the entity to find.
	 * @return The entity found, or null if not found.
	 */
	public E findOne(int index);

}
