package co.edu.unbosque.view;

/**
 * Class that represents the view facade in the application. Provides access to
 * the main window and ensures that there is only one instance of the view
 * through the Singleton pattern.
 *
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class ViewFacade {
	/**
	 * A static instance of the ViewFacade class used to implement the Singleton
	 * design pattern. Ensures that only one instance of the class is created and
	 * accessible globally.
	 */
	private static ViewFacade instance;

	/**
	 * A reference to the main application window (`VentanaPrincipal`), which serves
	 * as the central graphical interface for the user.
	 */
	private VentanaPrincipal ven;

	/**
	 * Creates a new instance of ViewFacade and initializes the main window.
	 */
	public ViewFacade() {

		ven = new VentanaPrincipal();
	}

	/**
	 * Obtains the unique instance of ViewFacade.
	 * 
	 * @return The instance of ViewFacade.
	 */
	public static synchronized ViewFacade getInstance() {
		if (instance == null) {
			instance = new ViewFacade();
		}
		return instance;
	}

	/**
	 * Sets the instance of ViewFacade. This method can be used to replace the
	 * current instance.
	 * 
	 * @param instance The new instance of ViewFacade to set.
	 */
	public static void setInstance(ViewFacade instance) {
		ViewFacade.instance = instance;
	}

	/**
	 * Obtains the main window associated with this view facade.
	 * 
	 * @return The main window.
	 */
	public VentanaPrincipal getVen() {
		return ven;
	}

	/**
	 * Sets the main window associated with this view facade.
	 * 
	 * @param ven The new main window to set.
	 */
	public void setVen(VentanaPrincipal ven) {
		this.ven = ven;
	}

}
