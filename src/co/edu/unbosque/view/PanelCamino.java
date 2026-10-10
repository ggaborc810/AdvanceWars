package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class representing a panel that displays a path. The panel can show a pointer
 * on the path.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelCamino extends JPanel {
	/**
	 * The image of the path.
	 */
	private final ImageIcon camino;

	/**
	 * The image of the pointer.
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently visible.
	 */
	private boolean apuntadorActual = false;

	/**
	 * Constructor for the PanelCamino class. Initializes the panel and loads the
	 * images of the path and the pointer.
	 */
	public PanelCamino() {
		camino = new ImageIcon("resources/images/camino.gif");
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
	 * Draws the path and, if active, the pointer on the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(camino.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
	}
}