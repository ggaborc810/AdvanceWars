package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class representing a panel to display game sessions.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelPartidas extends JPanel {
	/**
	 * Button to go back to the previous menu or screen.
	 */
	private JButton btnBack;

	/**
	 * Background image of the panel.
	 */
	private ImageIcon fondo;

	/**
	 * Constructor that initializes the sessions panel.
	 */
	public PanelPartidas() {
		setSize(1391, 839);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		fondo = new ImageIcon("resources/images/opciones/8.png");
		btnBack = generarBoton("", 5, 700, 300, 120, "");
		add(btnBack);

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
		int ancho = 1391;
		int alto = 820;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Generates a button with the specified properties.
	 * 
	 * @param text   The button text.
	 * @param x      The x position of the button.
	 * @param y      The y position of the button.
	 * @param width  The width of the button.
	 * @param height The height of the button.
	 * @param url    The image URL (currently not used).
	 * @return The created button.
	 */
	public JButton generarBoton(String texto, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton(texto);
		btn.setBorderPainted(true);
		btn.setContentAreaFilled(false);
		btn.setFocusPainted(false);
		btn.setOpaque(false);
		btn.setFont(new Font("ARIAL", Font.BOLD, 30));
		btn.setForeground(Color.WHITE);
		btn.setBounds(x, y, ancho, alto);
		return btn;
	}

	/**
	 * Gets the back button.
	 * 
	 * @return The back button (JButton).
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * Sets the back button.
	 * 
	 * @param btnBack The new back button (JButton).
	 */
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
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