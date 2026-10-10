package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class representing a panel that displays a house. The panel can show a
 * pointer over the house.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelCasa extends JPanel {
	/**
	 * The image of the house.
	 */
	private final ImageIcon casa;

	/**
	 * The image of the pointer.
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently visible.
	 */
	private boolean apuntadorActual = false;

	/**
	 * Constructor for the PanelCasa class. Initializes the panel and loads the
	 * images of the house and the pointer.
	 *
	 * @param rutaImagen The path to the image of the house.
	 */
	public PanelCasa(String rutaImagen) {
		casa = new ImageIcon(rutaImagen);
		apuntador = new ImageIcon("resources/images/campo/apuntador.png");
		setSize(32, 32);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Sets the state of the pointer.
	 *
	 * @param act true to show the pointer, false to hide it.
	 */
	public void setApuntador(boolean act) {
		this.apuntadorActual = act;
	}

	/**
	 * Draws the house and, if active, the pointer on the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(casa.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
		// C
	}
}
