package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class representing a panel that displays a river image. It can include a
 * graphical pointer that can be toggled on or off.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelRio extends JPanel {
	/**
	 * The image icon representing the river background.
	 */
	private final ImageIcon rio;

	/**
	 * The image icon representing the pointer or cursor icon.
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently active.
	 */
	private boolean apuntadorActual = false;

	/**
	 * Constructor that initializes the panel with a river image.
	 * 
	 * @param rutaImagen The path to the river image to be displayed.
	 */

	public PanelRio(String rutaImagen) {
		rio = new ImageIcon(rutaImagen);
		apuntador = new ImageIcon("resources/images/campo/apuntador.png");
		setSize(32, 32);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Sets whether the pointer should be visible.
	 * 
	 * @param act {@code true} to show the pointer, {@code false} to hide it.
	 */
	public void setApuntador(boolean act) {
		this.apuntadorActual = act;
	}

	/**
	 * Renders the panel, drawing the river image and the pointer if active.
	 * 
	 * @param g The Graphics object used for drawing.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(rio.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
		// C
	}
}
