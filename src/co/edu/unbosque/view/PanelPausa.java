package co.edu.unbosque.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Represents the game's pause panel, containing buttons to resume, save, or
 * exit the game.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelPausa extends JPanel {
	/**
	 * Imagen de fondo del panel de pausa.
	 */
	private ImageIcon fondo;

	/**
	 * Botón para continuar el juego desde la pausa.
	 */
	private JButton btnContinuar;

	/**
	 * Botón para guardar el progreso del juego.
	 */
	private JButton btnGuardar;

	/**
	 * Botón para salir del juego desde el menú de pausa.
	 */
	private JButton btnSalir;

	/**
	 * Constructor of the PanelPausa class. Initializes the panel and its
	 * components.
	 */
	public PanelPausa() {
		setSize(300, 500);
		setLayout(null);
		fondo = new ImageIcon("resources/images/opciones/panelPausa.png");
		btnContinuar = new JButton();
		btnContinuar.setBounds(70, 140, 180, 60);
		btnContinuar.setOpaque(false);
		btnContinuar.setContentAreaFilled(false);
		btnContinuar.setBorderPainted(false);
		btnContinuar.setFocusPainted(false);

		btnGuardar = new JButton();
		btnGuardar.setBounds(70, 300, 180, 60);
		btnGuardar.setOpaque(false);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setBorderPainted(false);
		btnGuardar.setFocusPainted(false);

		add(btnContinuar);
		add(btnGuardar);
	}

	/**
	 * Draws the component on the panel, including the background of the pause
	 * panel.
	 * 
	 * @param g The Graphics object used to draw the component.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Gets the background image of the pause panel.
	 * 
	 * @return The background image (ImageIcon).
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background image of the pause panel.
	 * 
	 * @param fondo The new background image (ImageIcon).
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * Gets the button to continue the game.
	 * 
	 * @return The continue button (JButton).
	 */
	public JButton getBtnContinuar() {
		return btnContinuar;
	}

	/**
	 * Sets the button to continue the game.
	 * 
	 * @param btnContinuar The new continue button (JButton).
	 */
	public void setBtnContinuar(JButton btnContinuar) {
		this.btnContinuar = btnContinuar;
	}

	/**
	 * Gets the button to save the game.
	 * 
	 * @return The save button (JButton).
	 */
	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	/**
	 * Sets the button to save the game.
	 * 
	 * @param btnGuardar The new save button (JButton).
	 */
	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

}
