package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;

/**
 * Class that represents a panel displaying a building. The panel can show a
 * pointer over the building.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelEdificio extends JPanel {
	/**
	 * The image of the building displayed in the panel.
	 */
	private ImageIcon edificio;

	/**
	 * The pointer image that can be displayed over the building.
	 */
	private ImageIcon apuntador;

	/**
	 * A flag that indicates if the pointer is currently visible.
	 */
	private boolean apuntadorActual = false;
	/**
	 * The current color associated with the building icon.
	 */
	private String colorActual;

	/**
	 * URL for the default (gray) building image.
	 */
	private String urlGris = "resources/images/obstaculos/torre.png";
	/**
	 * URL for the red team building image.
	 */
	private String urlRojo = "resources/images/obstaculos/torreRoja.png";

	/**
	 * URL for the blue team building image.
	 */
	private String urlAzul = "resources/images/obstaculos/torreAzul.png";

	/**
	 * URL for the green team building image.
	 */
	private String urlVerde = "resources/images/obstaculos/torreVerde.png";

	/**
	 * URL for the yellow team building image.
	 */
	private String urlAmarillo = "resources/images/obstaculos/torreAmarilla.png";

	/**
	 * Constructor for the PanelEdificio class. Initializes the panel and loads the
	 * images for the building and the pointer.
	 *
	 * @param rutaImagen The path to the building image.
	 */
	public PanelEdificio(String rutaImagen) {
		edificio = new ImageIcon(rutaImagen);
		apuntador = new ImageIcon("resources/images/campo/apuntador.png");
		setSize(32, 32);
		setLayout(null);
		setVisible(true);
		colorActual = "gris";
	}

	/**
	 * Changes the building's color based on the specified team name. Selects the
	 * appropriate image URL based on the team color, updates the icon, and repaints
	 * the panel to reflect the change.
	 * 
	 * @param equipo the name of the team, which determines the color ("rojo",
	 *               "azul", "verde", "amarillo"). If the team name doesn't match
	 *               any specific color, the default gray icon is used.
	 */
	public void cambiarColor(String equipo) {
		String nuevaUrl = "";
		switch (equipo) {
		case "rojo":
			nuevaUrl = urlRojo;
			break;
		case "azul":
			nuevaUrl = urlAzul;
			break;
		case "verde":
			nuevaUrl = urlVerde;
			break;
		case "amarillo":
			nuevaUrl = urlAmarillo;
			break;
		default:
			nuevaUrl = urlGris;
			break;
		}

		edificio = new ImageIcon(nuevaUrl);

		colorActual = equipo;
		System.out.println("Cambiando imagen del edificio a: " + nuevaUrl);
		System.out.println("Cambiando imagen del edificio a: " + nuevaUrl + " para el equipo " + equipo);
		repaint(); // Asegúrate de repintar después de cambiar la imagen
		revalidate(); // Actualiza la estructura del panel si es necesario
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
	 * Draws the building and, if active, the pointer on the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(edificio.getImage(), 0, 0, getWidth(), getHeight(), this);
		if (apuntadorActual) {
			g.drawImage(apuntador.getImage(), 0, 0, getWidth(), getHeight(), this);
		}
		// C
	}

	/**
	 * Checks if the current pointer is active.
	 * 
	 * @return {@code true} if the current pointer is active; {@code false}
	 *         otherwise.
	 */
	public boolean isApuntadorActual() {
		return apuntadorActual;
	}

//Getters y Setters
	
	public void setApuntadorActual(boolean apuntadorActual) {
		this.apuntadorActual = apuntadorActual;
	}

	public String getColorActual() {
		return colorActual;
	}

	public void setColorActual(String colorActual) {
		this.colorActual = colorActual;
	}

	public ImageIcon getEdificio() {
		return edificio;
	}

	public ImageIcon getApuntador() {
		return apuntador;
	}

	public String getUrlGris() {
		return urlGris;
	}

	public String getUrlRojo() {
		return urlRojo;
	}

	public String getUrlAzul() {
		return urlAzul;
	}

	public String getUrlVerde() {
		return urlVerde;
	}

	public String getUrlAmarillo() {
		return urlAmarillo;
	}

}
