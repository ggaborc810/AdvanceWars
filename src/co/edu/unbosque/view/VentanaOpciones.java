package co.edu.unbosque.view;

import javax.swing.JFrame;

/**
 * Window representing the game options for "ADVANCE-WARS".
 *
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class VentanaOpciones extends JFrame {
	/*
	 * This panel contains various options that the player can configure, such as
	 * game settings, player preferences, and other customizable features.
	 */
	private PanelOpciones jpnOpc;

	/**
	 * Constructor that initializes the options window.
	 */
	public VentanaOpciones() {
		setTitle("ADVANCE-WARS");
		setSize(470, 605);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		jpnOpc = new PanelOpciones();
		jpnOpc.setVisible(true);

		add(jpnOpc);
	}

	/**
	 * Clears the visible panels in the options window.
	 *
	 * This method sets the visibility of the options panel to false, effectively
	 * hiding it from the user interface.
	 */
	public void limpiarPaneles() {
		jpnOpc.setVisible(false);
	}

	/**
	 * Retrieves the current options panel.
	 *
	 * @return the options panel
	 */
	public PanelOpciones getJpnOpc() {
		return jpnOpc;
	}

	/**
	 * Sets a new options panel.
	 *
	 * @param jpnOpc the new options panel to be set
	 */
	public void setJpnOpc(PanelOpciones jpnOpc) {
		this.jpnOpc = jpnOpc;
	}
}
