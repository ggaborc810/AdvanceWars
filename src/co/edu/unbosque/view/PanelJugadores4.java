package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class that represents the graphical interface panel for the four-player game.
 * This panel allows adding different types of units (airplanes, soldiers,
 * tanks) and displays the amount of money available for each player.
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
public class PanelJugadores4 extends JPanel {
	/**
	 * Button to add more red airplanes
	 */
	private JButton btnAgregarAvionRojoMas;
	/**
	 * Button to reduce red airplanes.
	 */
	private JButton btnAgregarAvionRojoMenos;
	/**
	 * Button to add more green airplanes.
	 */
	private JButton btnAgregarAvionVerdeMas;
	/**
	 * Button to reduce green airplanes.
	 */
	private JButton btnAgregarAvionVerdeMenos;
	/**
	 * Button to add more yellow airplanes.
	 */
	private JButton btnAgregarAvionAmarilloMas;
	/**
	 * Button to reduce yellow airplanes.
	 */
	private JButton btnAgregarAvionAmarilloMenos;
	/**
	 * Button to add more blue airplanes.
	 */
	private JButton btnAgregarAvionAzulMas;
	/**
	 * Button to reduce blue airplanes.
	 */
	private JButton btnAgregarAvionAzulMenos;

	/**
	 * Button to add more red soldiers.
	 */
	private JButton btnAgregarSoldadoRojoMas;
	/**
	 * Button to reduce red soldiers.
	 */
	private JButton btnAgregarSoldadoRojoMenos;
	/**
	 * Button to add more green soldiers.
	 */
	private JButton btnAgregarSoldadoVerdeMas;
	/**
	 * Button to reduce green soldiers.
	 */
	private JButton btnAgregarSoldadoVerdeMenos;
	/**
	 * Button to add more yellow soldiers.
	 */
	private JButton btnAgregarSoldadoAmarilloMas;
	/**
	 * Button to reduce yellow soldiers.
	 */
	private JButton btnAgregarSoldadoAmarilloMenos;
	/**
	 * Button to add more blue soldiers.
	 */
	private JButton btnAgregarSoldadoAzulMas;
	/**
	 * Button to reduce blue soldiers.
	 */
	private JButton btnAgregarSoldadoAzulMenos;

	/**
	 * Button to add more red tanks.
	 */
	private JButton btnAgregarTanqueRojoMas;
	/**
	 * Button to reduce red tanks.
	 */
	private JButton btnAgregarTanqueRojoMenos;
	/**
	 * Button to add more green tanks.
	 */
	private JButton btnAgregarTanqueVerdeMas;
	/**
	 * Button to reduce green tanks.
	 */
	private JButton btnAgregarTanqueVerdeMenos;
	/**
	 * Button to add more yellow tanks.
	 */
	private JButton btnAgregarTanqueAmarilloMas;
	/**
	 * Button to reduce yellow tanks.
	 */
	private JButton btnAgregarTanqueAmarilloMenos;
	/**
	 * Button to add more blue tanks.
	 */
	private JButton btnAgregarTanqueAzulMas;
	/**
	 * Button to reduce blue tanks.
	 */
	private JButton btnAgregarTanqueAzulMenos;

	/**
	 * Label to display GIFs.
	 */
	private JLabel gif;
	/**
	 * Label for red airplanes.
	 */
	private JLabel avionRojo;
	/**
	 * Label for red soldiers.
	 */
	private JLabel soldadoRojo;
	/**
	 * Label for red tanks.
	 */
	private JLabel tanqueRojo;

	/**
	 * Label for blue airplanes.
	 */
	private JLabel avionAzul;
	/**
	 * Label for blue soldiers.
	 */
	private JLabel soldadoAzul;
	/**
	 * Label for blue tanks.
	 */
	private JLabel tanqueAzul;

	/**
	 * Label for yellow airplanes.
	 */
	private JLabel avionAmarillo;
	/**
	 * Label for yellow soldiers.
	 */
	private JLabel soldadoAmarillo;
	/**
	 * Label for yellow tanks.
	 */
	private JLabel tanqueAmarillo;

	/**
	 * Label for green airplanes.
	 */
	private JLabel avionVerde;
	/**
	 * Label for green soldiers.
	 */
	private JLabel soldadoVerde;
	/**
	 * Label for green tanks.
	 */
	private JLabel tanqueVerde;

	/**
	 * Buttons for confirmation and navigation.
	 */
	private JButton btnOk, btnBack;
	/**
	 * Background image icon.
	 */
	private ImageIcon fondo;

	/**
	 * Labels to display money for each player.
	 */
	private JLabel lblDinero, lblDinero2, lblDinero3, lblDinero4;

	/**
	 * Labels for red units.
	 */
	private JLabel lblAvionRojo, lblSoldadoRojo, lblTanqueRojo;

	/**
	 * Labels for green units.
	 */
	private JLabel lblAvionVerde, lblSoldadoVerde, lblTanqueVerde;

	/**
	 * Labels for blue units.
	 */
	private JLabel lblAvionAzul, lblSoldadoAzul, lblTanqueAzul;

	/**
	 * Labels for yellow units.
	 */
	private JLabel lblAvionAmarillo, lblSoldadoAmarillo, lblTanqueAmarillo;
	/**
	 * Label for money display.
	 */
	private JLabel moneda;
	/**
	 * Label for money display.
	 */
	private JLabel moneda1;
	/**
	 * Label for money display.
	 */
	private JLabel moneda2;
	/**
	 * Label for money display.
	 */
	private JLabel moneda3;

	/**
	 * Constructor that initializes the panel and its components.
	 */
	public PanelJugadores4() {
		setSize(1391, 839);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		fondo = new ImageIcon("resources/images/opciones/cuatroJugadores.png");

		moneda = generarGif(190, 100, 70, 70, "resources/images/Moneda.gif");
		moneda1 = generarGif(900, 100, 70, 70, "resources/images/Moneda.gif");
		moneda2 = generarGif(200, 480, 70, 70, "resources/images/Moneda.gif");
		moneda3 = generarGif(880, 480, 70, 70, "resources/images/Moneda.gif");

		lblDinero = generarMensaje("50", 430, 88, 100, 100);
		lblDinero2 = generarMensaje("50", 1120, 85, 100, 100);
		lblDinero3 = generarMensaje("50", 430, 465, 100, 100);
		lblDinero4 = generarMensaje("50", 1110, 465, 100, 100);

		lblAvionRojo = generarMensaje("0", 650, 170, 100, 100);
		lblSoldadoRojo = generarMensaje("0", 650, 220, 100, 100);
		lblTanqueRojo = generarMensaje("0", 650, 275, 100, 100);

		lblAvionAzul = generarMensaje("0", 1340, 170, 100, 100);
		lblSoldadoAzul = generarMensaje("0", 1340, 220, 100, 100);
		lblTanqueAzul = generarMensaje("0", 1340, 275, 100, 100);

		lblAvionVerde = generarMensaje("0", 650, 530, 100, 100);
		lblSoldadoVerde = generarMensaje("0", 650, 580, 100, 100);
		lblTanqueVerde = generarMensaje("0", 650, 640, 100, 100);

		lblAvionAmarillo = generarMensaje("0", 1335, 530, 100, 100);
		lblSoldadoAmarillo = generarMensaje("0", 1335, 580, 100, 100);
		lblTanqueAmarillo = generarMensaje("0", 1335, 640, 100, 100);

		avionRojo = generarGif(560, 170, 100, 100, "resources/images/aviones/avionRojo.gif");
		soldadoRojo = generarGif(560, 220, 100, 100, "resources/images/soldados/soldadoRojo.gif");
		tanqueRojo = generarGif(560, 275, 100, 100, "resources/images/tanques/tanqueRojo.gif");

		avionAmarillo = generarGif(1260, 170, 100, 100, "resources/images/aviones/avionAmarillo.gif");
		soldadoAmarillo = generarGif(1260, 220, 100, 100, "resources/images/soldados/soldadoAmarillo.gif");
		tanqueAmarillo = generarGif(1260, 275, 100, 100, "resources/images/tanques/tanqueAmarillo.gif");

		avionAzul = generarGif(565, 530, 100, 100, "resources/images/aviones/avionAzul.gif");
		soldadoAzul = generarGif(565, 580, 100, 100, "resources/images/soldados/soldadoAzul.gif");
		tanqueAzul = generarGif(565, 640, 100, 100, "resources/images/tanques/tanqueAzul.gif");

		avionVerde = generarGif(1255, 530, 100, 100, "resources/images/aviones/avionVerde.gif");
		soldadoVerde = generarGif(1255, 580, 100, 100, "resources/images/soldados/soldadoVerde.gif");
		tanqueVerde = generarGif(1255, 640, 100, 100, "resources/images/tanques/tanqueVerde.gif");

		btnAgregarAvionRojoMas = generarBoton("", 50, 200, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoRojoMas = generarBoton("", 50, 250, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueRojoMas = generarBoton("", 50, 305, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionRojoMenos = generarBoton("", 90, 200, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoRojoMenos = generarBoton("", 90, 250, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueRojoMenos = generarBoton("", 90, 305, 30, 30, "resources/images/opciones/quitar.png");

		btnAgregarAvionVerdeMas = generarBoton("", 65, 570, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoVerdeMas = generarBoton("", 65, 620, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueVerdeMas = generarBoton("", 65, 670, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionVerdeMenos = generarBoton("", 105, 570, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoVerdeMenos = generarBoton("", 105, 620, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueVerdeMenos = generarBoton("", 105, 670, 30, 30, "resources/images/opciones/quitar.png");

		btnAgregarAvionAzulMas = generarBoton("", 750, 200, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoAzulMas = generarBoton("", 750, 250, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueAzulMas = generarBoton("", 750, 305, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionAzulMenos = generarBoton("", 790, 200, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoAzulMenos = generarBoton("", 790, 250, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueAzulMenos = generarBoton("", 790, 305, 30, 30, "resources/images/opciones/quitar.png");

		btnAgregarAvionAmarilloMas = generarBoton("", 750, 570, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoAmarilloMas = generarBoton("", 750, 620, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueAmarilloMas = generarBoton("", 750, 670, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionAmarilloMenos = generarBoton("", 790, 570, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoAmarilloMenos = generarBoton("", 790, 620, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueAmarilloMenos = generarBoton("", 790, 670, 30, 30, "resources/images/opciones/quitar.png");

		btnBack = generarBoton("VOLVER", 20, 735, 120, 60, "");
		btnOk = generarBoton("SIGUIENTE", 1250, 730, 120, 50, "");

		add(btnAgregarAvionRojoMas);
		add(btnAgregarSoldadoRojoMas);
		add(btnAgregarTanqueRojoMas);
		add(btnAgregarAvionRojoMenos);
		add(btnAgregarSoldadoRojoMenos);
		add(btnAgregarTanqueRojoMenos);

		add(btnAgregarAvionVerdeMas);
		add(btnAgregarSoldadoVerdeMas);
		add(btnAgregarTanqueVerdeMas);
		add(btnAgregarAvionVerdeMenos);
		add(btnAgregarSoldadoVerdeMenos);
		add(btnAgregarTanqueVerdeMenos);

		add(btnAgregarAvionAzulMas);
		add(btnAgregarSoldadoAzulMas);
		add(btnAgregarTanqueAzulMas);
		add(btnAgregarAvionAzulMenos);
		add(btnAgregarSoldadoAzulMenos);
		add(btnAgregarTanqueAzulMenos);

		add(btnAgregarAvionAmarilloMas);
		add(btnAgregarSoldadoAmarilloMas);
		add(btnAgregarTanqueAmarilloMas);
		add(btnAgregarAvionAmarilloMenos);
		add(btnAgregarSoldadoAmarilloMenos);
		add(btnAgregarTanqueAmarilloMenos);

		add(avionRojo);
		add(soldadoRojo);
		add(tanqueRojo);

		add(avionAzul);
		add(soldadoAzul);
		add(tanqueAzul);

		add(avionAmarillo);
		add(soldadoAmarillo);
		add(tanqueAmarillo);

		add(avionVerde);
		add(soldadoVerde);
		add(tanqueVerde);

		add(lblDinero);// rojo
		add(lblDinero2);// azul
		add(lblDinero3);// verde
		add(lblDinero4);// amarillo

		add(lblAvionRojo);
		add(lblSoldadoRojo);
		add(lblTanqueRojo);

		add(lblAvionVerde);
		add(lblSoldadoVerde);
		add(lblTanqueVerde);

		add(lblAvionAzul);
		add(lblSoldadoAzul);
		add(lblTanqueAzul);

		add(lblAvionAmarillo);
		add(lblSoldadoAmarillo);
		add(lblTanqueAmarillo);

		add(btnBack);
		add(btnOk);
		add(moneda);
		add(moneda1);
		add(moneda2);
		add(moneda3);

		repaint();
	}

	/**
	 * Method responsible for drawing the background of the panel.
	 *
	 * @param g The Graphics object used for drawing on the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1391;
		int alto = 820;
		g.drawImage(fondo.getImage(), 0, 0, ancho, 800, this);
	}

	/**
	 * Method that generates a JLabel with a GIF.
	 *
	 * @param x     The x position of the JLabel.
	 * @param y     The y position of the JLabel.
	 * @param ancho The width of the JLabel.
	 * @param alto  The height of the JLabel.
	 * @param url   The URL of the GIF to display.
	 * @return The created JLabel.
	 */
	public JLabel generarGif(int x, int y, int ancho, int alto, String url) {
		ImageIcon gifIcon = new ImageIcon(url);
		gif = new JLabel(gifIcon);
		gif.setBounds(x, y, ancho, alto);
		return gif;
	}

	/**
	 * Method that generates a JLabel with text.
	 *
	 * @param texto The text to display on the JLabel.
	 * @param x     The x position of the JLabel.
	 * @param y     The y position of the JLabel.
	 * @param ancho The width of the JLabel.
	 * @param alto  The height of the JLabel.
	 * @return The created JLabel with the text.
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("IMPACT", Font.BOLD, 32));
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * Method that generates a JButton with an icon.
	 *
	 * @param x     The x position of the JButton.
	 * @param y     The y position of the JButton.
	 * @param ancho The width of the JButton.
	 * @param alto  The height of the JButton.
	 * @param url   The URL of the icon to display on the button.
	 * @return The created JButton with the icon.
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
	 * Obtains the button that allows adding a red plane (increment).
	 *
	 * @return The button to add a red plane.
	 */
	public JButton getBtnAgregarAvionRojoMas() {
		return btnAgregarAvionRojoMas;
	}

	/**
	 * Sets the button that allows adding a red plane (increment).
	 *
	 * @param btnAgregarAvionRojoMas The button to add a red plane.
	 */
	public void setBtnAgregarAvionRojoMas(JButton btnAgregarAvionRojoMas) {
		this.btnAgregarAvionRojoMas = btnAgregarAvionRojoMas;
	}

	/**
	 * Obtains the button that allows adding a red plane (decrement).
	 *
	 * @return The button to add a red plane.
	 */
	public JButton getBtnAgregarAvionRojoMenos() {
		return btnAgregarAvionRojoMenos;
	}

	/**
	 * Sets the button that allows adding a red plane (decrement).
	 *
	 * @param btnAgregarAvionRojoMenos The button to add a red plane.
	 */
	public void setBtnAgregarAvionRojoMenos(JButton btnAgregarAvionRojoMenos) {
		this.btnAgregarAvionRojoMenos = btnAgregarAvionRojoMenos;
	}

	/**
	 * Obtains the button that allows adding a green plane (increment).
	 *
	 * @return The button to add a green plane.
	 */
	public JButton getBtnAgregarAvionVerdeMas() {
		return btnAgregarAvionVerdeMas;
	}

	/**
	 * Sets the button that allows adding a green plane (increment).
	 *
	 * @param btnAgregarAvionVerdeMas The button to add a green plane.
	 */
	public void setBtnAgregarAvionVerdeMas(JButton btnAgregarAvionVerdeMas) {
		this.btnAgregarAvionVerdeMas = btnAgregarAvionVerdeMas;
	}

	/**
	 * Obtains the button that allows adding a green plane (decrement).
	 *
	 * @return The button to add a green plane.
	 */
	public JButton getBtnAgregarAvionVerdeMenos() {
		return btnAgregarAvionVerdeMenos;
	}

	/**
	 * Sets the button that allows adding a green plane (decrement).
	 *
	 * @param btnAgregarAvionVerdeMenos The button to add a green plane.
	 */
	public void setBtnAgregarAvionVerdeMenos(JButton btnAgregarAvionVerdeMenos) {
		this.btnAgregarAvionVerdeMenos = btnAgregarAvionVerdeMenos;
	}

	/**
	 * Obtains the button that allows adding a yellow plane (increment).
	 *
	 * @return The button to add a yellow plane.
	 */
	public JButton getBtnAgregarAvionAmarilloMas() {
		return btnAgregarAvionAmarilloMas;
	}

	/**
	 * Sets the button that allows adding a yellow plane (increment).
	 *
	 * @param btnAgregarAvionAmarilloMas The button to add a yellow plane.
	 */
	public void setBtnAgregarAvionAmarilloMas(JButton btnAgregarAvionAmarilloMas) {
		this.btnAgregarAvionAmarilloMas = btnAgregarAvionAmarilloMas;
	}

	/**
	 * Obtains the button that allows adding a yellow plane (decrement).
	 *
	 * @return The button to add a yellow plane.
	 */
	public JButton getBtnAgregarAvionAmarilloMenos() {
		return btnAgregarAvionAmarilloMenos;
	}

	/**
	 * Sets the button that allows adding a yellow plane (decrement).
	 *
	 * @param btnAgregarAvionAmarilloMenos The button to add a yellow plane.
	 */
	public void setBtnAgregarAvionAmarilloMenos(JButton btnAgregarAvionAmarilloMenos) {
		this.btnAgregarAvionAmarilloMenos = btnAgregarAvionAmarilloMenos;
	}

	/**
	 * Obtains the button that allows adding a blue plane (increment).
	 *
	 * @return The button to add a blue plane.
	 */
	public JButton getBtnAgregarAvionAzulMas() {
		return btnAgregarAvionAzulMas;
	}

	/**
	 * Sets the button that allows adding a blue plane (increment).
	 *
	 * @param btnAgregarAvionAzulMas The button to add a blue plane.
	 */
	public void setBtnAgregarAvionAzulMas(JButton btnAgregarAvionAzulMas) {
		this.btnAgregarAvionAzulMas = btnAgregarAvionAzulMas;
	}

	/**
	 * Obtains the button that allows adding a blue plane (decrement).
	 *
	 * @return The button to add a blue plane.
	 */
	public JButton getBtnAgregarAvionAzulMenos() {
		return btnAgregarAvionAzulMenos;
	}

	/**
	 * Sets the button that allows adding a blue plane (decrement).
	 *
	 * @param btnAgregarAvionAzulMenos The button to add a blue plane.
	 */
	public void setBtnAgregarAvionAzulMenos(JButton btnAgregarAvionAzulMenos) {
		this.btnAgregarAvionAzulMenos = btnAgregarAvionAzulMenos;
	}

	/**
	 * Obtains the button that allows adding a red soldier (increment).
	 *
	 * @return The button to add a red soldier.
	 */
	public JButton getBtnAgregarSoldadoRojoMas() {
		return btnAgregarSoldadoRojoMas;
	}

	/**
	 * Sets the button that allows adding a red soldier (increment).
	 *
	 * @param btnAgregarSoldadoRojoMas The button to add a red soldier.
	 */
	public void setBtnAgregarSoldadoRojoMas(JButton btnAgregarSoldadoRojoMas) {
		this.btnAgregarSoldadoRojoMas = btnAgregarSoldadoRojoMas;
	}

	/**
	 * Obtains the button that allows adding a red soldier (decrement).
	 *
	 * @return The button to add a red soldier.
	 */
	public JButton getBtnAgregarSoldadoRojoMenos() {
		return btnAgregarSoldadoRojoMenos;
	}

	/**
	 * Sets the button that allows adding a red soldier (decrement).
	 *
	 * @param btnAgregarSoldadoRojoMenos The button to add a red soldier.
	 */
	public void setBtnAgregarSoldadoRojoMenos(JButton btnAgregarSoldadoRojoMenos) {
		this.btnAgregarSoldadoRojoMenos = btnAgregarSoldadoRojoMenos;
	}

	/**
	 * Obtains the button that allows adding a green soldier (increment).
	 *
	 * @return The button to add a green soldier.
	 */
	public JButton getBtnAgregarSoldadoVerdeMas() {
		return btnAgregarSoldadoVerdeMas;
	}

	/**
	 * Sets the button that allows adding a green soldier (increment).
	 *
	 * @param btnAgregarSoldadoVerdeMas The button to add a green soldier.
	 */
	public void setBtnAgregarSoldadoVerdeMas(JButton btnAgregarSoldadoVerdeMas) {
		this.btnAgregarSoldadoVerdeMas = btnAgregarSoldadoVerdeMas;
	}

	/**
	 * Obtains the button that allows adding a green soldier (decrement).
	 *
	 * @return The button to add a green soldier.
	 */
	public JButton getBtnAgregarSoldadoVerdeMenos() {
		return btnAgregarSoldadoVerdeMenos;
	}

	/**
	 * Sets the button that allows adding a green soldier (decrement).
	 *
	 * @param btnAgregarSoldadoVerdeMenos The button to add a green soldier.
	 */
	public void setBtnAgregarSoldadoVerdeMenos(JButton btnAgregarSoldadoVerdeMenos) {
		this.btnAgregarSoldadoVerdeMenos = btnAgregarSoldadoVerdeMenos;
	}

	/**
	 * Obtains the button that allows adding a yellow soldier (increment).
	 *
	 * @return The button to add a yellow soldier.
	 */
	public JButton getBtnAgregarSoldadoAmarilloMas() {
		return btnAgregarSoldadoAmarilloMas;
	}

	/**
	 * Sets the button that allows adding a yellow soldier (increment).
	 *
	 * @param btnAgregarSoldadoAmarilloMas The button to add a yellow soldier.
	 */
	public void setBtnAgregarSoldadoAmarilloMas(JButton btnAgregarSoldadoAmarilloMas) {
		this.btnAgregarSoldadoAmarilloMas = btnAgregarSoldadoAmarilloMas;
	}

	/**
	 * Obtains the button that allows adding a yellow soldier (decrement).
	 *
	 * @return The button to add a yellow soldier.
	 */
	public JButton getBtnAgregarSoldadoAmarilloMenos() {
		return btnAgregarSoldadoAmarilloMenos;
	}

	/**
	 * Sets the button that allows adding a yellow soldier (decrement).
	 *
	 * @param btnAgregarSoldadoAmarilloMenos The button to add a yellow soldier.
	 */
	public void setBtnAgregarSoldadoAmarilloMenos(JButton btnAgregarSoldadoAmarilloMenos) {
		this.btnAgregarSoldadoAmarilloMenos = btnAgregarSoldadoAmarilloMenos;
	}

	/**
	 * Obtains the button that allows adding a blue soldier (increment).
	 *
	 * @return The button to add a blue soldier.
	 */
	public JButton getBtnAgregarSoldadoAzulMas() {
		return btnAgregarSoldadoAzulMas;
	}

	/**
	 * Sets the button that allows adding a blue soldier (increment).
	 *
	 * @param btnAgregarSoldadoAzulMas The button to add a blue soldier.
	 */
	public void setBtnAgregarSoldadoAzulMas(JButton btnAgregarSoldadoAzulMas) {
		this.btnAgregarSoldadoAzulMas = btnAgregarSoldadoAzulMas;
	}

	/**
	 * Obtains the button that allows adding a blue soldier (decrement).
	 *
	 * @return The button to add a blue soldier.
	 */
	public JButton getBtnAgregarSoldadoAzulMenos() {
		return btnAgregarSoldadoAzulMenos;
	}

	/**
	 * Sets the button that allows adding a blue soldier (decrement).
	 *
	 * @param btnAgregarSoldadoAzulMenos The button to add a blue soldier.
	 */
	public void setBtnAgregarSoldadoAzulMenos(JButton btnAgregarSoldadoAzulMenos) {
		this.btnAgregarSoldadoAzulMenos = btnAgregarSoldadoAzulMenos;
	}

	/**
	 * Gets the button that allows adding a red tank (increment).
	 *
	 * @return The button to add a red tank.
	 */
	public JButton getBtnAgregarTanqueRojoMas() {
		return btnAgregarTanqueRojoMas;
	}

	/**
	 * Sets the button that allows adding a red tank (increment).
	 *
	 * @param btnAgregarTanqueRojoMas The button to add a red tank.
	 */
	public void setBtnAgregarTanqueRojoMas(JButton btnAgregarTanqueRojoMas) {
		this.btnAgregarTanqueRojoMas = btnAgregarTanqueRojoMas;
	}

	/**
	 * Gets the button that allows adding a red tank (decrement).
	 *
	 * @return The button to add a red tank.
	 */
	public JButton getBtnAgregarTanqueRojoMenos() {
		return btnAgregarTanqueRojoMenos;
	}

	/**
	 * Sets the button that allows adding a red tank (decrement).
	 *
	 * @param btnAgregarTanqueRojoMenos The button to add a red tank.
	 */
	public void setBtnAgregarTanqueRojoMenos(JButton btnAgregarTanqueRojoMenos) {
		this.btnAgregarTanqueRojoMenos = btnAgregarTanqueRojoMenos;
	}

	/**
	 * Gets the button that allows adding a green tank (increment).
	 *
	 * @return The button to add a green tank.
	 */
	public JButton getBtnAgregarTanqueVerdeMas() {
		return btnAgregarTanqueVerdeMas;
	}

	/**
	 * Sets the button that allows adding a green tank (increment).
	 *
	 * @param btnAgregarTanqueVerdeMas The button to add a green tank.
	 */
	public void setBtnAgregarTanqueVerdeMas(JButton btnAgregarTanqueVerdeMas) {
		this.btnAgregarTanqueVerdeMas = btnAgregarTanqueVerdeMas;
	}

	/**
	 * Gets the button that allows adding a green tank (decrement).
	 *
	 * @return The button to add a green tank.
	 */
	public JButton getBtnAgregarTanqueVerdeMenos() {
		return btnAgregarTanqueVerdeMenos;
	}

	/**
	 * Sets the button that allows adding a green tank (decrement).
	 *
	 * @param btnAgregarTanqueVerdeMenos The button to add a green tank.
	 */
	public void setBtnAgregarTanqueVerdeMenos(JButton btnAgregarTanqueVerdeMenos) {
		this.btnAgregarTanqueVerdeMenos = btnAgregarTanqueVerdeMenos;
	}

	/**
	 * Gets the button that allows adding a yellow tank (increment).
	 *
	 * @return The button to add a yellow tank.
	 */
	public JButton getBtnAgregarTanqueAmarilloMas() {
		return btnAgregarTanqueAmarilloMas;
	}

	/**
	 * Sets the button that allows adding a yellow tank (increment).
	 *
	 * @param btnAgregarTanqueAmarilloMas The button to add a yellow tank.
	 */
	public void setBtnAgregarTanqueAmarilloMas(JButton btnAgregarTanqueAmarilloMas) {
		this.btnAgregarTanqueAmarilloMas = btnAgregarTanqueAmarilloMas;
	}

	/**
	 * Gets the button that allows adding a yellow tank (decrement).
	 *
	 * @return The button to add a yellow tank.
	 */
	public JButton getBtnAgregarTanqueAmarilloMenos() {
		return btnAgregarTanqueAmarilloMenos;
	}

	/**
	 * Sets the button that allows adding a yellow tank (decrement).
	 *
	 * @param btnAgregarTanqueAmarilloMenos The button to add a yellow tank.
	 */
	public void setBtnAgregarTanqueAmarilloMenos(JButton btnAgregarTanqueAmarilloMenos) {
		this.btnAgregarTanqueAmarilloMenos = btnAgregarTanqueAmarilloMenos;
	}

	/**
	 * Gets the button that allows adding a blue tank (increment).
	 *
	 * @return The button to add a blue tank.
	 */
	public JButton getBtnAgregarTanqueAzulMas() {
		return btnAgregarTanqueAzulMas;
	}

	/**
	 * Sets the button that allows adding a blue tank (increment).
	 *
	 * @param btnAgregarTanqueAzulMas The button to add a blue tank.
	 */
	public void setBtnAgregarTanqueAzulMas(JButton btnAgregarTanqueAzulMas) {
		this.btnAgregarTanqueAzulMas = btnAgregarTanqueAzulMas;
	}

	/**
	 * Gets the button that allows adding a blue tank (decrement).
	 *
	 * @return The button to add a blue tank.
	 */
	public JButton getBtnAgregarTanqueAzulMenos() {
		return btnAgregarTanqueAzulMenos;
	}

	/**
	 * Sets the button that allows adding a blue tank (decrement).
	 *
	 * @param btnAgregarTanqueAzulMenos The button to add a blue tank.
	 */
	public void setBtnAgregarTanqueAzulMenos(JButton btnAgregarTanqueAzulMenos) {
		this.btnAgregarTanqueAzulMenos = btnAgregarTanqueAzulMenos;
	}

	/**
	 * Gets the JLabel component that shows the GIF.
	 *
	 * @return The JLabel component that shows the GIF.
	 */
	public JLabel getGif() {
		return gif;
	}

	/**
	 * Sets the JLabel component that shows the GIF.
	 *
	 * @param gif The JLabel component that shows the GIF.
	 */
	public void setGif(JLabel gif) {
		this.gif = gif;
	}

	/**
	 * Gets the JLabel component that represents the red plane.
	 *
	 * @return The JLabel component that represents the red plane.
	 */
	public JLabel getAvionRojo() {
		return avionRojo;
	}

	/**
	 * Sets the JLabel component that represents the red plane.
	 *
	 * @param avionRojo The JLabel component that represents the red plane.
	 */
	public void setAvionRojo(JLabel avionRojo) {
		this.avionRojo = avionRojo;
	}

	/**
	 * Gets the JLabel component that represents the red soldier.
	 *
	 * @return The JLabel component that represents the red soldier.
	 */
	public JLabel getSoldadoRojo() {
		return soldadoRojo;
	}

	/**
	 * Sets the JLabel component that represents the red soldier.
	 *
	 * @param soldadoRojo The JLabel component that represents the red soldier.
	 */
	public void setSoldadoRojo(JLabel soldadoRojo) {
		this.soldadoRojo = soldadoRojo;
	}

	/**
	 * Gets the JLabel component that represents the red tank.
	 *
	 * @return The JLabel component that represents the red tank.
	 */
	public JLabel getTanqueRojo() {
		return tanqueRojo;
	}

	/**
	 * Sets the JLabel component that represents the red tank.
	 *
	 * @param tanqueRojo The JLabel component that represents the red tank.
	 */
	public void setTanqueRojo(JLabel tanqueRojo) {
		this.tanqueRojo = tanqueRojo;
	}

	/**
	 * Gets the JLabel component that represents the blue plane.
	 *
	 * @return The JLabel component that represents the blue plane.
	 */
	public JLabel getAvionAzul() {
		return avionAzul;
	}

	/**
	 * Sets the JLabel component that represents the blue plane.
	 *
	 * @param avionAzul The JLabel component that represents the blue plane.
	 */
	public void setAvionAzul(JLabel avionAzul) {
		this.avionAzul = avionAzul;
	}

	/**
	 * Gets the JLabel component that represents the blue soldier.
	 *
	 * @return The JLabel component that represents the blue soldier.
	 */
	public JLabel getSoldadoAzul() {
		return soldadoAzul;
	}

	/**
	 * Sets the JLabel component that represents the blue soldier.
	 *
	 * @param soldadoAzul The JLabel component that represents the blue soldier.
	 */
	public void setSoldadoAzul(JLabel soldadoAzul) {
		this.soldadoAzul = soldadoAzul;
	}

	/**
	 * Gets the JLabel component that represents the blue tank.
	 *
	 * @return The JLabel component that represents the blue tank.
	 */
	public JLabel getTanqueAzul() {
		return tanqueAzul;
	}

	/**
	 * Sets the JLabel component that represents the blue tank.
	 *
	 * @param tanqueAzul The JLabel component that represents the blue tank.
	 */
	public void setTanqueAzul(JLabel tanqueAzul) {
		this.tanqueAzul = tanqueAzul;
	}

	/**
	 * Gets the JLabel component that represents the yellow plane.
	 *
	 * @return The JLabel component that represents the yellow plane.
	 */
	public JLabel getAvionAmarillo() {
		return avionAmarillo;
	}

	/**
	 * Sets the JLabel component that represents the yellow plane.
	 *
	 * @param avionAmarillo The JLabel component that represents the yellow plane.
	 */
	public void setAvionAmarillo(JLabel avionAmarillo) {
		this.avionAmarillo = avionAmarillo;
	}

	/**
	 * Gets the JLabel component that represents the yellow soldier.
	 *
	 * @return The JLabel component that represents the yellow soldier.
	 */
	public JLabel getSoldadoAmarillo() {
		return soldadoAmarillo;
	}

	/**
	 * Sets the JLabel component that represents the yellow soldier.
	 *
	 * @param soldadoAmarillo The JLabel component that represents the yellow
	 *                        soldier.
	 */
	public void setSoldadoAmarillo(JLabel soldadoAmarillo) {
		this.soldadoAmarillo = soldadoAmarillo;
	}

	/**
	 * Obtains the JLabel component representing the yellow tank.
	 *
	 * @return The JLabel component representing the yellow tank.
	 */
	public JLabel getTanqueAmarillo() {
		return tanqueAmarillo;
	}

	/**
	 * Sets the JLabel component representing the yellow tank.
	 *
	 * @param tanqueAmarillo The JLabel component representing the yellow tank.
	 */
	public void setTanqueAmarillo(JLabel tanqueAmarillo) {
		this.tanqueAmarillo = tanqueAmarillo;
	}

	/**
	 * Obtains the JLabel component representing the green plane.
	 *
	 * @return The JLabel component representing the green plane.
	 */
	public JLabel getAvionVerde() {
		return avionVerde;
	}

	/**
	 * Sets the JLabel component representing the green plane.
	 *
	 * @param avionVerde The JLabel component representing the green plane.
	 */
	public void setAvionVerde(JLabel avionVerde) {
		this.avionVerde = avionVerde;
	}

	/**
	 * Obtains the JLabel component representing the green soldier.
	 *
	 * @return The JLabel component representing the green soldier.
	 */
	public JLabel getSoldadoVerde() {
		return soldadoVerde;
	}

	/**
	 * Sets the JLabel component representing the green soldier.
	 *
	 * @param soldadoVerde The JLabel component representing the green soldier.
	 */
	public void setSoldadoVerde(JLabel soldadoVerde) {
		this.soldadoVerde = soldadoVerde;
	}

	/**
	 * Obtains the JLabel component representing the green tank.
	 *
	 * @return The JLabel component representing the green tank.
	 */
	public JLabel getTanqueVerde() {
		return tanqueVerde;
	}

	/**
	 * Sets the JLabel component representing the green tank.
	 *
	 * @param tanqueVerde The JLabel component representing the green tank.
	 */
	public void setTanqueVerde(JLabel tanqueVerde) {
		this.tanqueVerde = tanqueVerde;
	}

	/**
	 * Obtains the button that confirms the action.
	 *
	 * @return The confirmation button.
	 */
	public JButton getBtnOk() {
		return btnOk;
	}

	/**
	 * Sets the button that confirms the action.
	 *
	 * @param btnOk The confirmation button.
	 */
	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	/**
	 * Obtains the button that allows returning to the previous screen.
	 *
	 * @return The back button.
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * Sets the button that allows returning to the previous screen.
	 *
	 * @param btnBack The back button.
	 */
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	/**
	 * Obtains the background of the screen.
	 *
	 * @return The background image.
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background image of the screen.
	 *
	 * @param fondo The background image.
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * Obtains the JLabel component that shows the amount of money.
	 *
	 * @return The JLabel component that shows the amount of money.
	 */
	public JLabel getLblDinero() {
		return lblDinero;
	}

	/**
	 * Sets the JLabel component that shows the amount of money.
	 *
	 * @param lblDinero The JLabel component that shows the amount of money.
	 */
	public void setLblDinero(JLabel lblDinero) {
		this.lblDinero = lblDinero;
	}

	/**
	 * Obtains the JLabel component that shows the second amount of money.
	 *
	 * @return The JLabel component that shows the second amount of money.
	 */
	public JLabel getLblDinero2() {
		return lblDinero2;
	}

	/**
	 * Sets the JLabel component that shows the second amount of money.
	 *
	 * @param lblDinero2 The JLabel component that shows the second amount of money.
	 */
	public void setLblDinero2(JLabel lblDinero2) {
		this.lblDinero2 = lblDinero2;
	}

	/**
	 * Obtains the JLabel component that shows the third amount of money.
	 *
	 * @return The JLabel component that shows the third amount of money.
	 */
	public JLabel getLblDinero3() {
		return lblDinero3;
	}

	/**
	 * Sets the JLabel component that shows the third amount of money.
	 *
	 * @param lblDinero3 The JLabel component that shows the third amount of money.
	 */
	public void setLblDinero3(JLabel lblDinero3) {
		this.lblDinero3 = lblDinero3;
	}

	/**
	 * Obtains the JLabel component that shows the fourth amount of money.
	 *
	 * @return The JLabel component that shows the fourth amount of money.
	 */
	public JLabel getLblDinero4() {
		return lblDinero4;
	}

	/**
	 * Sets the JLabel component that shows the fourth amount of money.
	 *
	 * @param lblDinero4 The JLabel component that shows the fourth amount of money.
	 */
	public void setLblDinero4(JLabel lblDinero4) {
		this.lblDinero4 = lblDinero4;
	}

	/**
	 * Obtains the JLabel component that shows the red plane.
	 *
	 * @return The JLabel component that shows the red plane.
	 */
	public JLabel getLblAvionRojo() {
		return lblAvionRojo;
	}

	/**
	 * Sets the JLabel component that shows the red plane.
	 *
	 * @param lblAvionRojo The JLabel component that shows the red plane.
	 */
	public void setLblAvionRojo(JLabel lblAvionRojo) {
		this.lblAvionRojo = lblAvionRojo;
	}

	/**
	 * Obtains the JLabel component that shows the red soldier.
	 *
	 * @return The JLabel component that shows the red soldier.
	 */
	public JLabel getLblSoldadoRojo() {
		return lblSoldadoRojo;
	}

	/**
	 * Sets the JLabel component that shows the red soldier.
	 *
	 * @param lblSoldadoRojo The JLabel component that shows the red soldier.
	 */
	public void setLblSoldadoRojo(JLabel lblSoldadoRojo) {
		this.lblSoldadoRojo = lblSoldadoRojo;
	}

	/**
	 * Obtains the JLabel component that shows the red tank.
	 *
	 * @return The JLabel component that shows the red tank.
	 */
	public JLabel getLblTanqueRojo() {
		return lblTanqueRojo;
	}

	/**
	 * Sets the JLabel component that shows the red tank.
	 *
	 * @param lblTanqueRojo The JLabel component that shows the red tank.
	 */
	public void setLblTanqueRojo(JLabel lblTanqueRojo) {
		this.lblTanqueRojo = lblTanqueRojo;
	}

	/**
	 * Obtains the JLabel component that shows the green plane.
	 *
	 * @return The JLabel component that shows the green plane.
	 */
	public JLabel getLblAvionVerde() {
		return lblAvionVerde;
	}

	/**
	 * Sets the JLabel component that shows the green plane.
	 *
	 * @param lblAvionVerde The JLabel component that shows the green plane.
	 */
	public void setLblAvionVerde(JLabel lblAvionVerde) {
		this.lblAvionVerde = lblAvionVerde;
	}

	/**
	 * Obtains the JLabel component that shows the green soldier.
	 *
	 * @return The JLabel component that shows the green soldier.
	 */
	public JLabel getLblSoldadoVerde() {
		return lblSoldadoVerde;
	}

	/**
	 * Sets the JLabel component that shows the green soldier.
	 *
	 * @param lblSoldadoVerde The JLabel component that shows the green soldier.
	 */
	public void setLblSoldadoVerde(JLabel lblSoldadoVerde) {
		this.lblSoldadoVerde = lblSoldadoVerde;
	}

	/**
	 * Obtains the JLabel component that shows the green tank.
	 *
	 * @return The JLabel component that shows the green tank.
	 */
	public JLabel getLblTanqueVerde() {
		return lblTanqueVerde;
	}

	/**
	 * Sets the JLabel component that shows the green tank.
	 *
	 * @param lblTanqueVerde The JLabel component that shows the green tank.
	 */
	public void setLblTanqueVerde(JLabel lblTanqueVerde) {
		this.lblTanqueVerde = lblTanqueVerde;
	}

	/**
	 * Obtains the JLabel component that shows the blue plane.
	 *
	 * @return The JLabel component that shows the blue plane.
	 */
	public JLabel getLblAvionAzul() {
		return lblAvionAzul;
	}

	/**
	 * Sets the JLabel component that shows the blue plane.
	 *
	 * @param lblAvionAzul The JLabel component that shows the blue plane.
	 */
	public void setLblAvionAzul(JLabel lblAvionAzul) {
		this.lblAvionAzul = lblAvionAzul;
	}

	/**
	 * Obtains the JLabel component that shows the blue soldier.
	 *
	 * @return The JLabel component that shows the blue soldier.
	 */
	public JLabel getLblSoldadoAzul() {
		return lblSoldadoAzul;
	}

	/**
	 * Sets the JLabel component that shows the blue soldier.
	 *
	 * @param lblSoldadoAzul The JLabel component that shows the blue soldier.
	 */
	public void setLblSoldadoAzul(JLabel lblSoldadoAzul) {
		this.lblSoldadoAzul = lblSoldadoAzul;
	}

	/**
	 * Obtains the JLabel component that shows the blue tank.
	 *
	 * @return The JLabel component that shows the blue tank.
	 */
	public JLabel getLblTanqueAzul() {
		return lblTanqueAzul;
	}

	/**
	 * Sets the JLabel component that shows the blue tank.
	 *
	 * @param lblTanqueAzul The JLabel component that shows the blue tank.
	 */
	public void setLblTanqueAzul(JLabel lblTanqueAzul) {
		this.lblTanqueAzul = lblTanqueAzul;
	}

	/**
	 * Obtains the JLabel component that displays the yellow airplane.
	 *
	 * @return The JLabel component that displays the yellow airplane.
	 */
	public JLabel getLblAvionAmarillo() {
		return lblAvionAmarillo;
	}

	/**
	 * Sets the JLabel component that displays the yellow airplane.
	 *
	 * @param lblAvionAmarillo The JLabel component that displays the yellow
	 *                         airplane.
	 */
	public void setLblAvionAmarillo(JLabel lblAvionAmarillo) {
		this.lblAvionAmarillo = lblAvionAmarillo;
	}

	/**
	 * Obtains the JLabel component that displays the yellow soldier.
	 *
	 * @return The JLabel component that displays the yellow soldier.
	 */
	public JLabel getLblSoldadoAmarillo() {
		return lblSoldadoAmarillo;
	}

	/**
	 * Sets the JLabel component that displays the yellow soldier.
	 *
	 * @param lblSoldadoAmarillo The JLabel component that displays the yellow
	 *                           soldier.
	 */
	public void setLblSoldadoAmarillo(JLabel lblSoldadoAmarillo) {
		this.lblSoldadoAmarillo = lblSoldadoAmarillo;
	}

	/**
	 * Obtains the JLabel component that displays the yellow tank.
	 *
	 * @return The JLabel component that displays the yellow tank.
	 */
	public JLabel getLblTanqueAmarillo() {
		return lblTanqueAmarillo;
	}

	/**
	 * Sets the JLabel component that displays the yellow tank.
	 *
	 * @param lblTanqueAmarillo The JLabel component that displays the yellow tank.
	 */
	public void setLblTanqueAmarillo(JLabel lblTanqueAmarillo) {
		this.lblTanqueAmarillo = lblTanqueAmarillo;
	}
}