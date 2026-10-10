package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.EquipoDAO;
import co.edu.unbosque.model.persistence.PartidaDAO;
import co.edu.unbosque.model.persistence.UnidadDAO;

/**
 * The ModelFacade class acts as a facade for accessing the model data. model.
 * It provides methods for accessing and managing the main entities main
 * entities of the system, such as equipment, units and line items, using the
 * corresponding corresponding DAOs.
 * 
 * This class implements the Singleton pattern to ensure that there is only one
 * * instance of ModelFacade running. instance of ModelFacade running.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class ModelFacade {
	/**
	 * Data Access Object for managing team data.
	 */
	private EquipoDAO equipoDAO;

	/**
	 * Data Access Object for managing unit data.
	 */
	private UnidadDAO unidadDAO;

	/**
	 * Data Access Object for managing game session data.
	 */
	private PartidaDAO partidaDAO;

	/**
	 * The current game session being played.
	 */
	private PartidaDTO partidaActual;

	/**
	 * Singleton instance of the ModelFacade.
	 */
	private static ModelFacade instance;

	/**
	 * Default ModelFacade builder. It initializes the DAOs and creates a new empty
	 * empty line item.
	 */
	public ModelFacade() {
		equipoDAO = new EquipoDAO();
		unidadDAO = new UnidadDAO();
		partidaDAO = new PartidaDAO();
		partidaActual = new PartidaDTO();
	}

	/**
	 * Returns the single instance of ModelFacade, creating it if necessary.
	 * 
	 * @return The single instance of ModelFacade.
	 */
	public static synchronized ModelFacade getInstance() {
		if (instance == null) {
			instance = new ModelFacade();
		}
		return instance;
	}

	/**
	 * Obtains the DAO to manage the equipment.
	 * 
	 * @return The TeamDAO object.
	 */
	public EquipoDAO getEquipoDAO() {
		return equipoDAO;
	}

	/**
	 * Sets up a new DAO to manage the equipment.
	 * 
	 * @param equipoDAO The new EquipoDAO.
	 */
	public void setEquipoDAO(EquipoDAO equipoDAO) {
		this.equipoDAO = equipoDAO;
	}

	/**
	 * Obtains the DAO to manage the units.
	 * 
	 * @return The UnidadDAO object.
	 */
	public UnidadDAO getUnidadDAO() {
		return unidadDAO;
	}

	/**
	 * Sets up a new DAO to manage the units.
	 * 
	 * @param unidadDAO The new UnidadDAO.
	 */
	public void setUnidadDAO(UnidadDAO unidadDAO) {
		this.unidadDAO = unidadDAO;
	}

	/**
	 * Obtains the DAO to manage the items.
	 * 
	 * @return The object PartidaDAO.
	 */
	public PartidaDAO getPartidaDAO() {
		return partidaDAO;
	}

	/**
	 * Sets up a new DAO to manage the items.
	 * 
	 * @param partidaDAO The new PartidaDAO.
	 */
	public void setPartidaDAO(PartidaDAO partidaDAO) {
		this.partidaDAO = partidaDAO;
	}

	/**
	 * Sets the single instance of ModelFacade.
	 * 
	 * @param instance The new instance of ModelFacade.
	 */
	public static void setInstance(ModelFacade instance) {
		ModelFacade.instance = instance;
	}

	/**
	 * Gets the current line item in progress.
	 * 
	 * @return The PartidaDTO object representing the current line item.
	 */
	public PartidaDTO getPartidaActual() {
		return partidaActual;
	}

	/**
	 * Sets the current line item in progress.
	 * 
	 * @param lineItemCurrent The new LineItemDTO object for the current line item.
	 */
	public void setPartidaActual(PartidaDTO partidaActual) {
		this.partidaActual = partidaActual;
	}

}
