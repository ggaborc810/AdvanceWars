package co.edu.unbosque.model.persistence;

import co.edu.unbosque.model.UnidadDTO;
import co.edu.unbosque.util.structure.MyLinkedList;

/**
 * The {@link UnidadDAO} class manages CRUD operations for {@link UnidadDTO}
 * objects. It uses the custom data structure {@link MyLinkedList} to store and
 * manipulate units.
 * 
 * Main methods:
 * 
 * - {@link #create(UnidadDTO)}: Adds a new unit to the list of units. -
 * {@link #update(int, UnidadDTO)}: Updates an existing unit identified by its
 * index. - {@link #delete(int)}: Removes a unit from the list based on its
 * index. - {@link #findOne(int)}: Searches for and returns a specific unit by
 * its index.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class UnidadDAO implements CRUDOperation<UnidadDTO> {
	/**
	 * The {@code MyLinkedList} that stores the units ({@link UnidadDTO}).
	 * 
	 * This linked list allows for efficient manipulation of unit objects, including
	 * adding, removing, and accessing units.
	 */
	private MyLinkedList<UnidadDTO> listaUnidades;

	/**
	 * Constructor that initializes the list of units as a new {@link MyLinkedList}.
	 */
	public UnidadDAO() {
		listaUnidades = new MyLinkedList<>();
	}

	/**
	 * Adds a new unit to the end of the list of units.
	 * 
	 * @param data The {@link UnidadDTO} object representing the unit to be created.
	 */
	@Override
	public void create(UnidadDTO data) {
		listaUnidades.agregarFinal(data);
	}

	/**
	 * Updates an existing unit identified by its index.
	 * 
	 * @param index   The index of the unit to be updated.
	 * @param newData The new {@link UnidadDTO} object with updated data.
	 */
	@Override
	public void update(int index, UnidadDTO newData) {
		listaUnidades.get(findOne(index)).setInfo(newData);
	}

	/**
	 * Removes a unit from the list based on its index.
	 * 
	 * @param index The index of the unit to be deleted.
	 */
	@Override
	public void delete(int index) {
		if (findOne(index) != null) {
			listaUnidades.extract(findOne(index));
		}
	}

	/**
	 * Searches for and returns a specific unit by its index.
	 * 
	 * @param index The index of the unit to be found.
	 * @return The corresponding {@link UnidadDTO} object or null if not found.
	 */
	@Override
	public UnidadDTO findOne(int index) {
		for (int i = 0; i < listaUnidades.size(); i++) {
			if (listaUnidades.get(i).getInfo().equals(listaUnidades.get(index).getInfo())) {
				return listaUnidades.get(i).getInfo();
			}
		}
		return null;
	}

	/**
	 * Returns the list of units.
	 * 
	 * @return A {@link MyLinkedList} containing all the units.
	 */
	public MyLinkedList<UnidadDTO> getListaUnidades() {
		return listaUnidades;
	}

	/**
	 * Sets a new list of units.
	 * 
	 * @param listaUnidades The new {@link MyLinkedList} containing the units.
	 */

	public void setListaUnidades(MyLinkedList<UnidadDTO> listaUnidades) {
		this.listaUnidades = listaUnidades;
	}

}
