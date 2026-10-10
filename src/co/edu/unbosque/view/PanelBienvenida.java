package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class representing the game's welcome panel. This panel contains buttons to
 * start the game, exit, and view saved games.
 * 
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelBienvenida extends JPanel {
	/**
	 * Button to start the game.
	 */
	private JButton btnStart;

	/**
	 * Button to exit the game.
	 */
	private JButton btnExit;

	/**
	 * Button to view saved games.
	 */
	private JButton btnPartidas;

	/**
	 * The background image of the panel.
	 */
	private ImageIcon fondo;

	/**
	 * Panel for two players.
	 */
	private PanelJugadores2 jpnJugadores2;

	/**
	 * Panel for three players.
	 */
	private PanelJugadores3 jpnJugadores3;

	/**
	 * Panel for four players.
	 */
	private PanelJugadores4 jpnJugadores4;

	/**
	 * Constructor for the PanelBienvenida class. Initializes the panel, loads the
	 * background, and creates the interactive buttons.
	 */
	private JButton btntuto;

	public PanelBienvenida() {
		setSize(1391, 839);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		fondo = new ImageIcon("resources/images/opciones/1.png");
		btnStart = generarBoton("INICIAR", 763, 637, 276, 90, "");
		btnExit = generarBoton("SALIR", 329, 637, 276, 90, "");
		btnPartidas = generarBoton("HISTORIAL", 532, 506, 320, 110, "");
		btntuto = generarBoton("TUTORIAL", 573, 735, 240, 56, "");

		jpnJugadores2 = new PanelJugadores2();
		jpnJugadores2.setVisible(false);
		jpnJugadores3 = new PanelJugadores3();
		jpnJugadores3.setVisible(false);
		jpnJugadores4 = new PanelJugadores4();
		jpnJugadores4.setVisible(false);

		add(btntuto);
		add(btnStart);
		add(btnExit);
		add(btnPartidas);

		repaint();

	}

	/**
	 * Draws the background of the welcome panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1391;
		int alto = 810;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Generates a button with the specified properties.
	 *
	 * @param texto The text to display on the button.
	 * @param x     The X position of the button.
	 * @param y     The Y position of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the image to use as the button's icon.
	 * @return The generated button.
	 */
	public JButton generarBoton(String texto, int x, int y, int ancho, int alto, String url) {
		JButton btn = new JButton();
		btn.setBackground(Color.black); // Color.decode("#17fffb")
		btn.setBorderPainted(false);
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
	 * Gets the start game button.
	 *
	 * @return The button that starts the game.
	 */
	public JButton getBtnStart() {
		return btnStart;
	}

	/**
	 * Sets the start game button.
	 *
	 * @param btnStart The button to set as the start button.
	 */
	public void setBtnStart(JButton btnStart) {
		this.btnStart = btnStart;
	}

	/**
	 * Gets the exit game button.
	 *
	 * @return The button that exits the game.
	 */
	public JButton getBtnExit() {
		return btnExit;
	}

	/**
	 * Sets the exit game button.
	 *
	 * @param btnExit The button to set as the exit button.
	 */
	public void setBtnExit(JButton btnExit) {
		this.btnExit = btnExit;
	}

	/**
	 * Gets the background image of the panel.
	 *
	 * @return The background image as an ImageIcon object.
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background image of the panel.
	 *
	 * @param fondo The background image to set.
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * Gets the button to access saved games.
	 *
	 * @return The button that shows saved games.
	 */
	public JButton getBtnPartidas() {
		return btnPartidas;
	}

	/**
	 * Sets the button to access saved games.
	 *
	 * @param btnPartidas The button to set for showing saved games.
	 */
	public void setBtnPartidas(JButton btnPartidas) {
		this.btnPartidas = btnPartidas;

	}

	/**
	 * Obtains the two-player panel.
	 * 
	 * @return the PanelJugadores2 instance.
	 */
	public PanelJugadores2 getJpnJugadores2() {
		return jpnJugadores2;
	}

	/**
	 * Sets the two-player panel.
	 * 
	 * @param jpnJugadores2 the PanelJugadores2 instance to set.
	 */
	public void setJpnJugadores2(PanelJugadores2 jpnJugadores2) {
		this.jpnJugadores2 = jpnJugadores2;
	}

	/**
	 * Obtains the three-player panel.
	 * 
	 * @return the PanelJugadores3 instance.
	 */
	public PanelJugadores3 getJpnJugadores3() {
		return jpnJugadores3;
	}

	/**
	 * Sets the three-player panel.
	 * 
	 * @param jpnJugadores3 the PanelJugadores3 instance to set.
	 */
	public void setJpnJugadores3(PanelJugadores3 jpnJugadores3) {
		this.jpnJugadores3 = jpnJugadores3;
	}

	/**
	 * Obtains the four-player panel.
	 * 
	 * @return the PanelJugadores4 instance.
	 */
	public PanelJugadores4 getJpnJugadores4() {
		return jpnJugadores4;
	}

	/**
	 * Sets the four-player panel.
	 * 
	 * @param jpnJugadores4 the PanelJugadores4 instance to set.
	 */
	public void setJpnJugadores4(PanelJugadores4 jpnJugadores4) {
		this.jpnJugadores4 = jpnJugadores4;
	}

	/**
	 * Obtains the tutorial button.
	 * 
	 * @return the JButton instance for the tutorial.
	 */
	public JButton getBtntuto() {
		return btntuto;
	}

	/**
	 * Sets the tutorial button.
	 * 
	 * @param btntuto the JButton instance to set for the tutorial.
	 */
	public void setBtntuto(JButton btntuto) {
		this.btntuto = btntuto;
	}

}

//	public JButton getBtnGO() {
//		return btnGO;
//	}
//
//	public void setBtnGO(JButton btnGO) {
//		this.btnGO = btnGO;
//	}

//	public JButton getBtnOp() {
//		return btnOp;
//	}
//
//	public void setBtnOp(JButton btnOp) {
//		this.btnOp = btnOp;
//	}
