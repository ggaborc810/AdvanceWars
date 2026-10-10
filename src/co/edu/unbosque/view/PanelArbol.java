package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa un panel que muestra un árbol y un apuntador.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelArbol extends JPanel {
	/**
	 * The tree image to be displayed on the panel.
	 */
	private final ImageIcon arbol;

	/**
	 * The pointer image to be displayed on the panel.
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently active.
	 */
	private boolean apuntadorActual = false;

	/**
	 * Constructor for the PanelArbol class. Initializes the images for the tree and
	 * the pointer.
	 */
	public PanelArbol() {
		arbol = new ImageIcon("resources/images/obstaculos/arbol.png");
		apuntador = new ImageIcon("resources/images/campo/apuntador.png");
		setSize(32, 32);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Sets whether the pointer is active or not.
	 *
	 * @param act true to activate the pointer, false to deactivate it.
	 */
	public void setApuntador(boolean act) {
		this.apuntadorActual = act;
	}

	/**
	 * Draws the tree and the pointer on the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(arbol.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}

	}
}
