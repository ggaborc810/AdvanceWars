package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class representing a panel that displays a field. The panel can show a
 * pointer and a character on the field.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelCampo extends JPanel {
	/**
	 * The image of the field (grass).
	 */
	private ImageIcon pasto;

	/**
	 * The image of the pointer.
	 */
	private final ImageIcon apuntador;

	/**
	 * Indicates whether the pointer is currently visible.
	 */
	private boolean apuntadorActual = false;

	/**
	 * The JLabel representing the character on the field.
	 */
	private JLabel personaje;

	/**
	 * Constructor for the PanelCampo class. Initializes the panel and loads the
	 * images of the field and the pointer.
	 */

	public PanelCampo() {
		pasto = new ImageIcon("resources/images/campo/campo.png");
		apuntador = new ImageIcon("resources/images/campo/apuntador.png");
		setSize(32, 32);
		setLayout(null);
		setVisible(true);
	}

	/**
	 * Sets the background image of the component. This method updates the `pasto`
	 * attribute with a new ImageIcon based on the provided URL and triggers a
	 * repaint of the component to reflect the change.
	 *
	 * @param url the URL or file path of the new background image.
	 */
	public void setImagenFondo(String url) {
		this.pasto = new ImageIcon(url);
		repaint();
	}

	/**
	 * Adds a character to the panel with the specified image.
	 *
	 * @param url The path to the character's image.
	 */
	public void addPersonaje(String url) {
		ImageIcon icn = new ImageIcon(url);
		this.personaje = new JLabel(icn);
		this.personaje.setSize(40, 40);
		this.personaje.setVisible(true);
		add(personaje);
		repaint();
	};

	/**
	 * Gets the character's image if it is visible.
	 *
	 * @return The character image's description, or null if there is no character.
	 */
	public String getPersonajeImage() {
		if (personaje != null && personaje.isVisible()) {
			return ((ImageIcon) personaje.getIcon()).getDescription();
		}
		return null;
	}

	/**
	 * Removes the character from the panel.
	 */
	public void removePersonaje() {
		removeAll(); // Elimina todos los componentes dentro del panel
		this.personaje = null; // Libera la referencia
		repaint();
	}

	/**
	 * Checks if there is a character in the panel.
	 *
	 * @return true if a character is visible, false otherwise.
	 */
	public boolean tienePersonaje() {
		return personaje != null && personaje.isVisible();
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
	 * Draws the field and, if active, the pointer on the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawImage(pasto.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
		// Cargamos la imagen

	}

	/**
	 * Gets the JLabel of the character.
	 *
	 * @return The JLabel representing the character.
	 */
	public JLabel getPersonaje() {
		return personaje;
	}

	/**
	 * Sets the JLabel of the character.
	 *
	 * @param personaje The JLabel representing the character.
	 */
	public void setPersonaje(JLabel personaje) {
		this.personaje = personaje;
	}

	/**
	 * Gets the image of the field.
	 *
	 * @return The ImageIcon representing the field.
	 */
	public ImageIcon getPasto() {
		return pasto;
	}

	/**
	 * Gets the image of the pointer.
	 *
	 * @return The ImageIcon representing the pointer.
	 */
	public ImageIcon getApuntador() {
		return apuntador;
	}

}
