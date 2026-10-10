package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class that represents the Game Over panel. This panel is displayed when the
 * game has ended.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelGameOver extends JPanel {
	/**
	 * The background image for the Game Over panel.
	 */
	private ImageIcon fondo;
	/**
	 * The button used to close the application or window.
	 */
	private JButton btnCerrar;

	/**
	 * Constructor of the PanelGameOver class. Initializes the panel and sets its
	 * background.
	 */
	public PanelGameOver() {
		setSize(1391, 839);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		btnCerrar = new JButton();
		btnCerrar.setBounds(550, 600, 300, 150);
		btnCerrar.setOpaque(false);
		btnCerrar.setContentAreaFilled(false);
//		btnVidaMas.setBorderPainted(false);

		add(btnCerrar);
		repaint();
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}

	public void setBtnCerrar(JButton btnCerrar) {
		this.btnCerrar = btnCerrar;
	}

	/**
	 * Paints the background of the Game Over panel. This method is called each time
	 * the panel needs to be repainted.
	 * 
	 * @param g The Graphics object used for drawing on the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1391;
		int alto = 820;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Displays the winning team's screen by updating the background image. This
	 * method sets the `fondo` attribute to an image corresponding to the winning
	 * team's color and triggers a repaint of the component to reflect the update.
	 *
	 * @param equipo the name of the winning team, expected to be one of the
	 *               following: "rojo", "verde", "amarillo", or "azul". If the input
	 *               does not match any of these, no action is performed.
	 */
	public void mostrarEquipoGanador(String equipo) {
		switch (equipo) {
		case "rojo":
			fondo = new ImageIcon("resources/images/JuegoTerminado/Rojo.png");
			break;
		case "verde":
			fondo = new ImageIcon("resources/images/JuegoTerminado/Verde.png");
			break;
		case "amarillo":
			fondo = new ImageIcon("resources/images/JuegoTerminado/Amarillo.png");
			break;
		case "azul":
			fondo = new ImageIcon("resources/images/JuegoTerminado/Azul.png");
			break;
		default:
			break;
		}
		repaint();
	}

	/**
	 * Gets the background image.
	 * 
	 * @return The background image.
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background image.
	 * 
	 * @param fondo The background image to set.
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

}
