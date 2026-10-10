package co.edu.unbosque.view;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * Class that represents a panel to display a map in the graphical interface.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelMapa extends JPanel {
	/**
	 * Constructor that initializes the map panel. Sets a preferred size based on
	 * the number of cells in the map.
	 */
	public PanelMapa() {
		setLayout(null);
		setPreferredSize(new Dimension(43 * 32, 25 * 32));
	}
}