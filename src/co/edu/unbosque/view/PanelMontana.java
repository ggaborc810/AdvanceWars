package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class that represents a panel that displays an image of mountains.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelMontana extends JPanel {
	/**
	 * The image of the mountains (ImageIcon).
	 */
	private final ImageIcon montanas;

	/**
	 * The image of the pointer (ImageIcon).
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently visible or not.
	 */
	private boolean apuntadorActual = false;

	/**
	 * Constructor that initializes the mountains panel.
	 */
	public PanelMontana() {
		montanas = new ImageIcon("resources/images/obstaculos/montana.png");
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

		g.drawImage(montanas.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}

	}
}
