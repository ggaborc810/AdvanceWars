package co.edu.unbosque.view;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class represents a custom JPanel used for displaying and interacting
 * with the "Mejoras" (Improvements) section in the user interface. It includes
 * buttons for increasing the player's life points and damage points.
 * 
 * The panel has a background image and two buttons: one to increase life points
 * and another to increase damage points. The layout is null to allow absolute
 * positioning of the components within the panel.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelMejoras extends JPanel {
	/**
	 * The background image icon for the UI component.
	 */
	private ImageIcon fondo;

	/**
	 * The button used to increase the life points in the game or system.
	 */
	private JButton btnVidaMas;

	/**
	 * The button used to increase the damage points in the game or system.
	 */
	private JButton btnDanioMas;

	/**
	 * Constructs a new PanelMejoras object, setting up the layout and buttons for
	 * the panel. Initializes the background image and buttons for upgrading life
	 * and damage.
	 * 
	 * The size of the panel is set to 300x500 pixels. The layout is set to null to
	 * allow absolute positioning of components. Two buttons are added: one for
	 * increasing life (btnVidaMas) and another for increasing damage (btnDanioMas).
	 * Both buttons are set with transparent backgrounds, and their borders are not
	 * painted.
	 */
	public PanelMejoras() {
		setSize(300, 500);
		setLayout(null);
		fondo = new ImageIcon("resources/images/opciones/panelMejoras.png");

		btnVidaMas = new JButton();
		btnVidaMas.setBounds(50, 120, 220, 65);
		btnVidaMas.setOpaque(false);
		btnVidaMas.setContentAreaFilled(false);
//		btnVidaMas.setBorderPainted(false);

		btnDanioMas = new JButton();
		btnDanioMas.setBounds(50, 295, 230, 65);
		btnDanioMas.setOpaque(false);
		btnDanioMas.setContentAreaFilled(false);
//		btnDañoMas.setBorderPainted(false);

		add(btnVidaMas);
		add(btnDanioMas);
	}

	/**
	 * Paints the background of the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	// Getters y Setters
	public ImageIcon getFondo() {
		return fondo;
	}

	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVidaMas() {
		return btnVidaMas;
	}

	public void setBtnVidaMas(JButton btnVidaMas) {
		this.btnVidaMas = btnVidaMas;
	}

	public JButton getBtnDanioMas() {
		return btnDanioMas;
	}

	public void setBtnDanioMas(JButton btnDanioMas) {
		this.btnDanioMas = btnDanioMas;
	}

}
