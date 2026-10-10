package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class representing an options panel in the game.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelOpciones extends JPanel {
	/**
	 * Button to perform the move action.
	 */
	private JButton btnMove;

	/**
	 * Button to perform the shoot action.
	 */
	private JButton btnShoot;

	/**
	 * Button to perform the enhancements action.
	 */
	private JButton btnEnhancements;

	/**
	 * Background image of the panel.
	 */
	private ImageIcon fondo;

	/**
	 * Constructor that initializes the options panel.
	 */
	public PanelOpciones() {
		setSize(470, 605);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		fondo = new ImageIcon("resources/images/opciones/6.png");
		btnMove = generarBoton("MOVE", 117, 73, 374, 70, "");
		btnShoot = generarBoton("SHOOT", 95, 266, 374, 70, "");
		btnEnhancements = generarBoton("ENHANCEMENTS", 30, 452, 374, 70, "");

		add(btnMove);
		add(btnShoot);
		add(btnEnhancements);
		repaint();

	}

	/**
	 * Method that draws the component.
	 * 
	 * @param g The Graphics object used for drawing.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 470;
		int alto = 605;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Generates a button with the specified properties.
	 * 
	 * @param texto The button text.
	 * @param x     The x position of the button.
	 * @param y     The y position of the button.
	 * @param ancho The button width.
	 * @param alto  The button height.
	 * @param url   The URL of the button's icon image.
	 * @return The created button.
	 */
	public JButton generarBoton(String texto, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton();
		btn.setBackground(Color.decode("#17fffb"));
		btn.setBorderPainted(true);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setToolTipText("BOTON " + texto + ".");
		ImageIcon icono = new ImageIcon(url);
		btn.setIcon(icono);
		btn.setBounds(x, y, ancho, alto);
		return btn;
	}

	/**
	 * Gets the move button.
	 * 
	 * @return The move button (JButton).
	 */
	public JButton getBtnMove() {
		return btnMove;
	}

	/**
	 * Sets the move button.
	 * 
	 * @param btnMove The new move button (JButton).
	 */
	public void setBtnMove(JButton btnMove) {
		this.btnMove = btnMove;
	}

	/**
	 * Gets the shoot button.
	 * 
	 * @return The shoot button (JButton).
	 */
	public JButton getBtnShoot() {
		return btnShoot;
	}

	/**
	 * Sets the shoot button.
	 * 
	 * @param btnShoot The new shoot button (JButton).
	 */
	public void setBtnShoot(JButton btnShoot) {
		this.btnShoot = btnShoot;
	}

	/**
	 * Gets the enhancements button.
	 * 
	 * @return The enhancements button (JButton).
	 */
	public JButton getBtnEnhancements() {
		return btnEnhancements;
	}

	/**
	 * Sets the enhancements button.
	 * 
	 * @param btnEnhancements The new enhancements button (JButton).
	 */
	public void setBtnEnhancements(JButton btnEnhancements) {
		this.btnEnhancements = btnEnhancements;
	}

	/**
	 * Gets the background image of the panel.
	 * 
	 * @return The background image (ImageIcon).
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background image of the panel.
	 * 
	 * @param fondo The new background image (ImageIcon).
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

}