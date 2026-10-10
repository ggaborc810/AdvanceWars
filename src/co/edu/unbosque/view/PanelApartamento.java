package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class representing a panel that displays an apartment with a pointer.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelApartamento extends JPanel {
	/**
	 * Image of the apartment to be displayed on the panel.
	 */
	private final ImageIcon apartamento;

	/**
	 * Image of the pointer that can be shown over the apartment.
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently active.
	 */
	private boolean apuntadorActual = false;

	/**
	 * Constructor. Initializes the apartment and pointer images.
	 *
	 * @param rutaImagen Path to the image of the apartment.
	 */
	public PanelApartamento(String rutaImagen) {
		apartamento = new ImageIcon(rutaImagen);
		apuntador = new ImageIcon("resources/images/campo/apuntador.png");
		setSize(32, 32);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Sets whether the pointer should be displayed.
	 *
	 * @param act true to show the pointer, false to hide it.
	 */
	public void setApuntador(boolean act) {
		this.apuntadorActual = act;
	}

	/**
	 * Paints the apartment and, if active, the pointer on the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(apartamento.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}

	}
}
