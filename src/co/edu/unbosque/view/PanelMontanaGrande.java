package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class representing a panel that displays an image of a large mountain.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelMontanaGrande extends JPanel {
	/**
	 * Image representing a large mountain.
	 */
	private final ImageIcon montanaGrande;

	/**
	 * Image representing the pointer.
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently visible.
	 */
	private boolean apuntadorActual = false;

	/**
	 * Constructor that initializes the large mountain panel.
	 */
	public PanelMontanaGrande() {
		montanaGrande = new ImageIcon("resources/images/obstaculos/montanaGrande.png");
		apuntador = new ImageIcon("resources/images/campo/apuntador.png");
		setSize(1400, 800);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Sets the state of the pointer.
	 * 
	 * @param act Indicates whether the pointer should be visible or not.
	 */
	public void setApuntador(boolean act) {
		this.apuntadorActual = act;
	}

	/**
	 * Draws the component.
	 * 
	 * @param g The Graphics object used for drawing.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(montanaGrande.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}

	}
}
