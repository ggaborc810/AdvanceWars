package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class representing a panel to manage the interface of a game with three
 * players.
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
public class PanelJugadores3 extends JPanel {

	/**
	 * Button to confirm actions.
	 */
	private JButton btnOk;

	/**
	 * Button to go back to the previous screen.
	 */
	private JButton btnBack;

	/**
	 * Background image for the panel.
	 */
	private ImageIcon fondo;

	/**
	 * Label to display GIFs.
	 */
	private JLabel gif;

	/**
	 * Label representing the red airplane.
	 */
	private JLabel avionRojo;

	/**
	 * Label representing the blue airplane.
	 */
	private JLabel avionAzul;

	/**
	 * Label representing the green airplane.
	 */
	private JLabel avionVerde;

	/**
	 * Label representing the red soldier.
	 */
	private JLabel soldadoRojo;

	/**
	 * Label representing the blue soldier.
	 */
	private JLabel soldadoAzul;

	/**
	 * Label representing the green soldier.
	 */
	private JLabel soldadoVerde;

	/**
	 * Label representing the red tank.
	 */
	private JLabel tanqueRojo;

	/**
	 * Label representing the blue tank.
	 */
	private JLabel tanqueAzul;

	/**
	 * Label representing the green tank.
	 */
	private JLabel tanqueVerde;

	/**
	 * Button to add a red airplane.
	 */
	private JButton btnAgregarAvionRojoMas;

	/**
	 * Button to add a red soldier.
	 */
	private JButton btnAgregarSoldadoRojoMas;

	/**
	 * Button to add a red tank.
	 */
	private JButton btnAgregarTanqueRojoMas;

	/**
	 * Button to subtract a red airplane.
	 */
	private JButton btnAgregarAvionRojoMenos;

	/**
	 * Button to subtract a red soldier.
	 */
	private JButton btnAgregarSoldadoRojoMenos;

	/**
	 * Button to subtract a red tank.
	 */
	private JButton btnAgregarTanqueRojoMenos;

	/**
	 * Button to add a blue airplane.
	 */
	private JButton btnAgregarAvionAzulMas;

	/**
	 * Button to add a blue soldier.
	 */
	private JButton btnAgregarSoldadoAzulMas;

	/**
	 * Button to add a blue tank.
	 */
	private JButton btnAgregarTanqueAzulMas;

	/**
	 * Button to subtract a blue airplane.
	 */
	private JButton btnAgregarAvionAzulMenos;

	/**
	 * Button to subtract a blue soldier.
	 */
	private JButton btnAgregarSoldadoAzulMenos;

	/**
	 * Button to subtract a blue tank.
	 */
	private JButton btnAgregarTanqueAzulMenos;

	/**
	 * Button to add a green airplane.
	 */
	private JButton btnAgregarAvionVerdeMas;

	/**
	 * Button to add a green soldier.
	 */
	private JButton btnAgregarSoldadoVerdeMas;

	/**
	 * Button to add a green tank.
	 */
	private JButton btnAgregarTanqueVerdeMas;

	/**
	 * Button to subtract a green airplane.
	 */
	private JButton btnAgregarAvionVerdeMenos;

	/**
	 * Button to subtract a green soldier.
	 */
	private JButton btnAgregarSoldadoVerdeMenos;

	/**
	 * Button to subtract a green tank.
	 */
	private JButton btnAgregarTanqueVerdeMenos;

	/**
	 * Label showing the amount of money.
	 */
	private JLabel lblDinero;

	/**
	 * Second label showing the amount of money.
	 */
	private JLabel lblDinero2;

	/**
	 * Third label showing the amount of money.
	 */
	private JLabel lblDinero3;

	/**
	 * Label representing the red airplane.
	 */
	private JLabel lblAvionRojo;

	/**
	 * Label representing the red soldier.
	 */
	private JLabel lblSoldadoRojo;

	/**
	 * Label representing the red tank.
	 */
	private JLabel lblTanqueRojo;

	/**
	 * Label representing the green airplane.
	 */
	private JLabel lblAvionVerde;

	/**
	 * Label representing the green soldier.
	 */
	private JLabel lblSoldadoVerde;

	/**
	 * Label representing the green tank.
	 */
	private JLabel lblTanqueVerde;

	/**
	 * Label representing the blue airplane.
	 */
	private JLabel lblAvionAzul;

	/**
	 * Label representing the blue soldier.
	 */
	private JLabel lblSoldadoAzul;

	/**
	 * Label representing the blue tank.
	 */
	private JLabel lblTanqueAzul;

	/**
	 * Label to display the amount of money.
	 */
	private JLabel moneda;

	/**
	 * Second label to display the amount of money.
	 */
	private JLabel moneda1;

	/**
	 * Third label to display the amount of money.
	 */
	private JLabel moneda2;

	/**
	 * Constructor for the PanelJugadores3 class. Initializes the panel, sets the
	 * size, background, and adds all graphical components.
	 */
	public PanelJugadores3() {
		setSize(1391, 839);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		fondo = new ImageIcon("resources/images/opciones/tresJugadores.png");

		moneda = generarGif(160, 100, 70, 70, "resources/images/Moneda.gif");
		moneda1 = generarGif(870, 105, 70, 70, "resources/images/Moneda.gif");
		moneda2 = generarGif(550, 528, 70, 70, "resources/images/Moneda.gif");

		lblDinero = generarMensaje("50", 385, 85, 100, 100);
		lblDinero2 = generarMensaje("50", 1090, 90, 100, 100);
		lblDinero3 = generarMensaje("50", 765, 515, 100, 100);

		lblAvionRojo = generarMensaje("0", 600, 177, 100, 100);
		lblSoldadoRojo = generarMensaje("0", 600, 230, 100, 100);
		lblTanqueRojo = generarMensaje("0", 600, 290, 100, 100);

		lblAvionAzul = generarMensaje("0", 1350, 172, 100, 100);
		lblSoldadoAzul = generarMensaje("0", 1350, 225, 100, 100);
		lblTanqueAzul = generarMensaje("0", 1350, 285, 100, 100);

		lblAvionVerde = generarMensaje("0", 900, 592, 100, 100);
		lblSoldadoVerde = generarMensaje("0", 900, 645, 100, 100);
		lblTanqueVerde = generarMensaje("0", 900, 700, 100, 100);

		avionRojo = generarGif(600, 177, 100, 100, "resources/images/aviones/avionRojo.gif");
		soldadoRojo = generarGif(600, 230, 100, 100, "resources/images/soldados/soldadoRojo.gif");
		tanqueRojo = generarGif(600, 290, 100, 100, "resources/images/tanques/tanqueRojo.gif");

		avionAzul = generarGif(1270, 172, 100, 100, "resources/images/aviones/avionAzul.gif");
		soldadoAzul = generarGif(1270, 225, 100, 100, "resources/images/soldados/soldadoAzul.gif");
		tanqueAzul = generarGif(1270, 285, 100, 100, "resources/images/tanques/tanqueAzul.gif");

		avionVerde = generarGif(900, 592, 100, 100, "resources/images/aviones/avionVerde.gif");
		soldadoVerde = generarGif(900, 645, 100, 100, "resources/images/soldados/soldadoVerde.gif");
		tanqueVerde = generarGif(900, 700, 100, 100, "resources/images/tanques/tanqueVerde.gif");

		btnAgregarAvionRojoMas = generarBoton("", 50, 215, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoRojoMas = generarBoton("", 50, 270, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueRojoMas = generarBoton("", 50, 325, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionRojoMenos = generarBoton("", 90, 215, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoRojoMenos = generarBoton("", 90, 270, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueRojoMenos = generarBoton("", 90, 325, 30, 30, "resources/images/opciones/quitar.png");

		btnAgregarAvionAzulMas = generarBoton("", 740, 205, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoAzulMas = generarBoton("", 740, 260, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueAzulMas = generarBoton("", 740, 320, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionAzulMenos = generarBoton("", 785, 205, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoAzulMenos = generarBoton("", 785, 260, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueAzulMenos = generarBoton("", 785, 320, 30, 30, "resources/images/opciones/quitar.png");

		btnAgregarAvionVerdeMas = generarBoton("", 340, 625, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoVerdeMas = generarBoton("", 340, 680, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueVerdeMas = generarBoton("", 340, 735, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionVerdeMenos = generarBoton("", 380, 625, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoVerdeMenos = generarBoton("", 380, 680, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueVerdeMenos = generarBoton("", 380, 735, 30, 30, "resources/images/opciones/quitar.png");

		btnBack = generarBoton("VOLVER", 52, 725, 150, 80, "");
		btnOk = generarBoton("SIGUIENTE", 1218, 750, 120, 50, "");

		add(avionRojo);
		add(avionAzul);
		add(avionVerde);
		add(soldadoRojo);
		add(soldadoAzul);
		add(soldadoVerde);
		add(tanqueRojo);
		add(tanqueAzul);
		add(tanqueVerde);

		add(btnAgregarAvionRojoMas);
		add(btnAgregarAvionRojoMenos);
		add(btnAgregarSoldadoRojoMas);
		add(btnAgregarSoldadoRojoMenos);
		add(btnAgregarTanqueRojoMas);
		add(btnAgregarTanqueRojoMenos);

		add(btnAgregarAvionAzulMas);
		add(btnAgregarSoldadoAzulMas);
		add(btnAgregarTanqueAzulMas);
		add(btnAgregarAvionAzulMenos);
		add(btnAgregarSoldadoAzulMenos);
		add(btnAgregarTanqueAzulMenos);

		add(btnAgregarAvionVerdeMas);
		add(btnAgregarSoldadoVerdeMas);
		add(btnAgregarTanqueVerdeMas);

		add(btnAgregarAvionVerdeMenos);
		add(btnAgregarSoldadoVerdeMenos);
		add(btnAgregarTanqueVerdeMenos);

		add(lblDinero);// rojo
		add(lblDinero2);// Azul
		add(lblDinero3);// verde

		add(btnBack);
		add(btnOk);

		add(lblAvionRojo);
		add(lblSoldadoRojo);
		add(lblTanqueRojo);

		add(lblAvionVerde);
		add(lblSoldadoVerde);
		add(lblTanqueVerde);

		add(lblAvionAzul);
		add(lblSoldadoAzul);
		add(lblTanqueAzul);

		add(moneda);
		add(moneda1);
		add(moneda2);
		repaint();
	}

	/**
	 * Draws the background of the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1391;
		int alto = 820;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Generates a JLabel that contains a GIF at the specified position and size.
	 *
	 * @param x     The x position of the JLabel.
	 * @param y     The y position of the JLabel.
	 * @param ancho The width of the JLabel.
	 * @param alto  The height of the JLabel.
	 * @param url   The URL of the GIF image to display.
	 * @return A JLabel that contains the GIF.
	 */
	public JLabel generarGif(int x, int y, int ancho, int alto, String url) {
		ImageIcon gifIcon = new ImageIcon(url);
		gif = new JLabel(gifIcon);
		gif.setBounds(x, y, ancho, alto);
		return gif;
	}

	/**
	 * Generates a JLabel with the specified text at the given position and size.
	 *
	 * @param texto The text to display on the JLabel.
	 * @param x     The x position of the JLabel.
	 * @param y     The y position of the JLabel.
	 * @param ancho The width of the JLabel.
	 * @param alto  The height of the JLabel.
	 * @return A JLabel with the specified text.
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("IMPACT", Font.BOLD, 32));
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * Generates a JButton with an icon at the specified position and size.
	 *
	 * @param x     The x position of the JButton.
	 * @param y     The y position of the JButton.
	 * @param ancho The width of the JButton.
	 * @param alto  The height of the JButton.
	 * @param url   The URL of the icon image to display.
	 * @return A JButton with the specified icon.
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
	 * Gets the confirmation button.
	 *
	 * @return The button btnOk.
	 */
	public JButton getBtnOk() {
		return btnOk;
	}

	/**
	 * Sets the confirmation button.
	 *
	 * @param btnOk The button to set.
	 */
	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	/**
	 * Gets the back button.
	 *
	 * @return The button btnBack.
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * Sets the back button.
	 *
	 * @param btnBack The button to set.
	 */
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	/**
	 * Gets the background of the panel.
	 *
	 * @return The background image.
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background of the panel.
	 *
	 * @param fondo The background image to set.
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * Gets the JLabel that contains the GIF.
	 *
	 * @return The JLabel gif.
	 */
	public JLabel getGif() {
		return gif;
	}

	/**
	 * Sets the JLabel that contains the GIF.
	 *
	 * @param gif The JLabel to set.
	 */
	public void setGif(JLabel gif) {
		this.gif = gif;
	}

	/**
	 * Gets the JLabel of the red airplane.
	 *
	 * @return The JLabel avionRojo.
	 */
	public JLabel getAvionRojo() {
		return avionRojo;
	}

	/**
	 * Sets the JLabel of the red airplane.
	 *
	 * @param avionRojo The JLabel to set.
	 */
	public void setAvionRojo(JLabel avionRojo) {
		this.avionRojo = avionRojo;
	}

	/**
	 * Gets the JLabel of the blue airplane.
	 *
	 * @return The JLabel avionAzul.
	 */
	public JLabel getAvionAzul() {
		return avionAzul;
	}

	/**
	 * Sets the JLabel of the blue airplane.
	 *
	 * @param avionAzul The JLabel to set.
	 */
	public void setAvionAzul(JLabel avionAzul) {
		this.avionAzul = avionAzul;
	}

	/**
	 * Gets the JLabel of the green airplane.
	 *
	 * @return The JLabel avionVerde.
	 */
	public JLabel getAvionVerde() {
		return avionVerde;
	}

	/**
	 * Sets the JLabel of the green airplane.
	 *
	 * @param avionVerde The JLabel to set.
	 */
	public void setAvionVerde(JLabel avionVerde) {
		this.avionVerde = avionVerde;
	}

	/**
	 * Gets the JLabel of the red soldier.
	 *
	 * @return The JLabel soldadoRojo.
	 */
	public JLabel getSoldadoRojo() {
		return soldadoRojo;
	}

	/**
	 * Sets the JLabel of the red soldier.
	 *
	 * @param soldadoRojo The JLabel to set.
	 */
	public void setSoldadoRojo(JLabel soldadoRojo) {
		this.soldadoRojo = soldadoRojo;
	}

	/**
	 * Gets the JLabel of the blue soldier.
	 *
	 * @return The JLabel soldadoAzul.
	 */
	public JLabel getSoldadoAzul() {
		return soldadoAzul;
	}

	/**
	 * Sets the JLabel of the blue soldier.
	 *
	 * @param soldadoAzul The JLabel to set.
	 */
	public void setSoldadoAzul(JLabel soldadoAzul) {
		this.soldadoAzul = soldadoAzul;
	}

	/**
	 * Gets the JLabel of the green soldier.
	 *
	 * @return The JLabel soldadoVerde.
	 */
	public JLabel getSoldadoVerde() {
		return soldadoVerde;
	}

	/**
	 * Sets the JLabel of the green soldier.
	 *
	 * @param soldadoVerde The JLabel to set.
	 */
	public void setSoldadoVerde(JLabel soldadoVerde) {
		this.soldadoVerde = soldadoVerde;
	}

	/**
	 * Gets the JLabel of the red tank.
	 *
	 * @return The JLabel tanqueRojo.
	 */
	public JLabel getTanqueRojo() {
		return tanqueRojo;
	}

	/**
	 * Sets the JLabel of the red tank.
	 *
	 * @param tanqueRojo The JLabel to set.
	 */
	public void setTanqueRojo(JLabel tanqueRojo) {
		this.tanqueRojo = tanqueRojo;
	}

	/**
	 * Gets the JLabel of the blue tank.
	 *
	 * @return The JLabel tanqueAzul.
	 */
	public JLabel getTanqueAzul() {
		return tanqueAzul;
	}

	/**
	 * Sets the JLabel of the blue tank.
	 *
	 * @param tanqueAzul The JLabel to set.
	 */
	public void setTanqueAzul(JLabel tanqueAzul) {
		this.tanqueAzul = tanqueAzul;
	}

	/**
	 * Gets the JLabel of the green tank.
	 *
	 * @return The JLabel tanqueVerde.
	 */
	public JLabel getTanqueVerde() {
		return tanqueVerde;
	}

	/**
	 * Sets the JLabel of the green tank.
	 *
	 * @param tanqueVerde The JLabel to set.
	 */
	public void setTanqueVerde(JLabel tanqueVerde) {
		this.tanqueVerde = tanqueVerde;
	}

	/**
	 * Gets the button to add a red airplane.
	 *
	 * @return The button btnAgregarAvionRojoMas.
	 */
	public JButton getBtnAgregarAvionRojoMas() {
		return btnAgregarAvionRojoMas;
	}

	/**
	 * Sets the button to add a red airplane.
	 *
	 * @param btnAgregarAvionRojoMas The button to set.
	 */
	public void setBtnAgregarAvionRojoMas(JButton btnAgregarAvionRojoMas) {
		this.btnAgregarAvionRojoMas = btnAgregarAvionRojoMas;
	}

	/**
	 * Gets the button to add a red soldier.
	 *
	 * @return The button btnAgregarSoldadoRojoMas.
	 */
	public JButton getBtnAgregarSoldadoRojoMas() {
		return btnAgregarSoldadoRojoMas;
	}

	/**
	 * Sets the button to add a red soldier.
	 *
	 * @param btnAgregarSoldadoRojoMas The button to set.
	 */
	public void setBtnAgregarSoldadoRojoMas(JButton btnAgregarSoldadoRojoMas) {
		this.btnAgregarSoldadoRojoMas = btnAgregarSoldadoRojoMas;
	}

	/**
	 * Gets the button to add a red tank.
	 *
	 * @return The button btnAgregarTanqueRojoMas.
	 */
	public JButton getBtnAgregarTanqueRojoMas() {
		return btnAgregarTanqueRojoMas;
	}

	/**
	 * Sets the button to add a red tank.
	 *
	 * @param btnAgregarTanqueRojoMas The button to set.
	 */
	public void setBtnAgregarTanqueRojoMas(JButton btnAgregarTanqueRojoMas) {
		this.btnAgregarTanqueRojoMas = btnAgregarTanqueRojoMas;
	}

	/**
	 * Gets the button to remove a red airplane.
	 *
	 * @return The button btnAgregarAvionRojoMenos.
	 */
	public JButton getBtnAgregarAvionRojoMenos() {
		return btnAgregarAvionRojoMenos;
	}

	/**
	 * Sets the button to remove a red airplane.
	 *
	 * @param btnAgregarAvionRojoMenos The button to set.
	 */
	public void setBtnAgregarAvionRojoMenos(JButton btnAgregarAvionRojoMenos) {
		this.btnAgregarAvionRojoMenos = btnAgregarAvionRojoMenos;
	}

	/**
	 * Gets the button to remove a red soldier.
	 *
	 * @return The button btnAgregarSoldadoRojoMenos.
	 */
	public JButton getBtnAgregarSoldadoRojoMenos() {
		return btnAgregarSoldadoRojoMenos;
	}

	/**
	 * Sets the button to remove a red soldier.
	 *
	 * @param btnAgregarSoldadoRojoMenos The button to set.
	 */
	public void setBtnAgregarSoldadoRojoMenos(JButton btnAgregarSoldadoRojoMenos) {
		this.btnAgregarSoldadoRojoMenos = btnAgregarSoldadoRojoMenos;
	}

	/**
	 * Gets the button to remove a red tank.
	 *
	 * @return The button btnAgregarTanqueRojoMenos.
	 */
	public JButton getBtnAgregarTanqueRojoMenos() {
		return btnAgregarTanqueRojoMenos;
	}

	/**
	 * Sets the button to remove a red tank.
	 *
	 * @param btnAgregarTanqueRojoMenos The button to set.
	 */
	public void setBtnAgregarTanqueRojoMenos(JButton btnAgregarTanqueRojoMenos) {
		this.btnAgregarTanqueRojoMenos = btnAgregarTanqueRojoMenos;
	}

	/**
	 * Gets the button to add a blue airplane.
	 *
	 * @return The button btnAgregarAvionAzulMas.
	 */
	public JButton getBtnAgregarAvionAzulMas() {
		return btnAgregarAvionAzulMas;
	}

	/**
	 * Sets the button to add a blue airplane.
	 *
	 * @param btnAgregarAvionAzulMas The button to set.
	 */
	public void setBtnAgregarAvionAzulMas(JButton btnAgregarAvionAzulMas) {
		this.btnAgregarAvionAzulMas = btnAgregarAvionAzulMas;
	}

	/**
	 * Gets the button to add a blue soldier.
	 *
	 * @return The button btnAgregarSoldadoAzulMas.
	 */
	public JButton getBtnAgregarSoldadoAzulMas() {
		return btnAgregarSoldadoAzulMas;
	}

	/**
	 * Sets the button to add a blue soldier.
	 *
	 * @param btnAgregarSoldadoAzulMas The button to set.
	 */
	public void setBtnAgregarSoldadoAzulMas(JButton btnAgregarSoldadoAzulMas) {
		this.btnAgregarSoldadoAzulMas = btnAgregarSoldadoAzulMas;
	}

	/**
	 * Gets the button to add a blue tank.
	 *
	 * @return The button btnAgregarTanqueAzulMas.
	 */
	public JButton getBtnAgregarTanqueAzulMas() {
		return btnAgregarTanqueAzulMas;
	}

	/**
	 * Sets the button to add a blue tank.
	 *
	 * @param btnAgregarTanqueAzulMas The button to set.
	 */
	public void setBtnAgregarTanqueAzulMas(JButton btnAgregarTanqueAzulMas) {
		this.btnAgregarTanqueAzulMas = btnAgregarTanqueAzulMas;
	}

	/**
	 * Gets the button to remove a blue airplane.
	 *
	 * @return The button btnAgregarAvionAzulMenos.
	 */
	public JButton getBtnAgregarAvionAzulMenos() {
		return btnAgregarAvionAzulMenos;
	}

	/**
	 * Sets the button to remove a blue airplane.
	 *
	 * @param btnAgregarAvionAzulMenos The button to set.
	 */
	public void setBtnAgregarAvionAzulMenos(JButton btnAgregarAvionAzulMenos) {
		this.btnAgregarAvionAzulMenos = btnAgregarAvionAzulMenos;
	}

	/**
	 * Gets the button to remove a blue soldier.
	 *
	 * @return The button btnAgregarSoldadoAzulMenos.
	 */
	public JButton getBtnAgregarSoldadoAzulMenos() {
		return btnAgregarSoldadoAzulMenos;
	}

	/**
	 * Sets the button to remove a blue soldier.
	 *
	 * @param btnAgregarSoldadoAzulMenos The button to set.
	 */
	public void setBtnAgregarSoldadoAzulMenos(JButton btnAgregarSoldadoAzulMenos) {
		this.btnAgregarSoldadoAzulMenos = btnAgregarSoldadoAzulMenos;
	}

	/**
	 * Gets the button to remove a blue tank.
	 *
	 * @return The button btnAgregarTanqueAzulMenos.
	 */
	public JButton getBtnAgregarTanqueAzulMenos() {
		return btnAgregarTanqueAzulMenos;
	}

	/**
	 * Sets the button to remove a blue tank.
	 *
	 * @param btnAgregarTanqueAzulMenos The button to set.
	 */
	public void setBtnAgregarTanqueAzulMenos(JButton btnAgregarTanqueAzulMenos) {
		this.btnAgregarTanqueAzulMenos = btnAgregarTanqueAzulMenos;
	}

	/**
	 * Gets the button to add a green airplane.
	 *
	 * @return The button btnAgregarAvionVerdeMas.
	 */
	public JButton getBtnAgregarAvionVerdeMas() {
		return btnAgregarAvionVerdeMas;
	}

	/**
	 * Sets the button to add a green airplane.
	 *
	 * @param btnAgregarAvionVerdeMas The button to set.
	 */
	public void setBtnAgregarAvionVerdeMas(JButton btnAgregarAvionVerdeMas) {
		this.btnAgregarAvionVerdeMas = btnAgregarAvionVerdeMas;
	}

	/**
	 * Gets the button to add a green soldier.
	 *
	 * @return The button btnAgregarSoldadoVerdeMas.
	 */
	public JButton getBtnAgregarSoldadoVerdeMas() {
		return btnAgregarSoldadoVerdeMas;
	}

	/**
	 * Sets the button to add a green soldier.
	 *
	 * @param btnAgregarSoldadoVerdeMas The button to set.
	 */
	public void setBtnAgregarSoldadoVerdeMas(JButton btnAgregarSoldadoVerdeMas) {
		this.btnAgregarSoldadoVerdeMas = btnAgregarSoldadoVerdeMas;
	}

	/**
	 * Gets the button to add a green tank.
	 *
	 * @return The button btnAgregarTanqueVerdeMas.
	 */
	public JButton getBtnAgregarTanqueVerdeMas() {
		return btnAgregarTanqueVerdeMas;
	}

	/**
	 * Sets the button to add a green tank.
	 *
	 * @param btnAgregarTanqueVerdeMas The button to set.
	 */
	public void setBtnAgregarTanqueVerdeMas(JButton btnAgregarTanqueVerdeMas) {
		this.btnAgregarTanqueVerdeMas = btnAgregarTanqueVerdeMas;
	}

	/**
	 * Gets the button to remove a green airplane.
	 *
	 * @return The button btnAgregarAvionVerdeMenos.
	 */
	public JButton getBtnAgregarAvionVerdeMenos() {
		return btnAgregarAvionVerdeMenos;
	}

	/**
	 * Sets the button to remove a green airplane.
	 *
	 * @param btnAgregarAvionVerdeMenos The button to set.
	 */
	public void setBtnAgregarAvionVerdeMenos(JButton btnAgregarAvionVerdeMenos) {
		this.btnAgregarAvionVerdeMenos = btnAgregarAvionVerdeMenos;
	}

	/**
	 * Gets the button to remove a green soldier.
	 *
	 * @return The button btnAgregarSoldadoVerdeMenos.
	 */
	public JButton getBtnAgregarSoldadoVerdeMenos() {
		return btnAgregarSoldadoVerdeMenos;
	}

	/**
	 * Sets the button to remove a green soldier.
	 *
	 * @param btnAgregarSoldadoVerdeMenos The button to set.
	 */
	public void setBtnAgregarSoldadoVerdeMenos(JButton btnAgregarSoldadoVerdeMenos) {
		this.btnAgregarSoldadoVerdeMenos = btnAgregarSoldadoVerdeMenos;
	}

	/**
	 * Gets the button to remove a green tank.
	 *
	 * @return The button btnAgregarTanqueVerdeMenos.
	 */
	public JButton getBtnAgregarTanqueVerdeMenos() {
		return btnAgregarTanqueVerdeMenos;
	}

	/**
	 * Sets the button to remove a green tank.
	 *
	 * @param btnAgregarTanqueVerdeMenos The button to set.
	 */
	public void setBtnAgregarTanqueVerdeMenos(JButton btnAgregarTanqueVerdeMenos) {
		this.btnAgregarTanqueVerdeMenos = btnAgregarTanqueVerdeMenos;
	}

	/**
	 * Gets the JLabel that shows the amount of money.
	 *
	 * @return The JLabel lblDinero.
	 */
	public JLabel getLblDinero() {
		return lblDinero;
	}

	/**
	 * Sets the JLabel that shows the amount of money.
	 *
	 * @param lblDinero The JLabel to set.
	 */
	public void setLblDinero(JLabel lblDinero) {
		this.lblDinero = lblDinero;
	}

	/**
	 * Gets the second JLabel that shows the amount of money.
	 *
	 * @return The JLabel lblDinero2.
	 */
	public JLabel getLblDinero2() {
		return lblDinero2;
	}

	/**
	 * Sets the second JLabel that shows the amount of money.
	 *
	 * @param lblDinero2 The JLabel to set.
	 */
	public void setLblDinero2(JLabel lblDinero2) {
		this.lblDinero2 = lblDinero2;
	}

	/**
	 * Gets the third JLabel that shows the amount of money.
	 *
	 * @return The JLabel lblDinero3.
	 */
	public JLabel getLblDinero3() {
		return lblDinero3;
	}

	/**
	 * Sets the third JLabel that shows the amount of money.
	 *
	 * @param lblDinero3 The JLabel to set.
	 */
	public void setLblDinero3(JLabel lblDinero3) {
		this.lblDinero3 = lblDinero3;
	}

	/**
	 * Gets the JLabel for the red airplane.
	 *
	 * @return The JLabel lblAvionRojo.
	 */
	public JLabel getLblAvionRojo() {
		return lblAvionRojo;
	}

	/**
	 * Sets the JLabel for the red airplane.
	 *
	 * @param lblAvionRojo The JLabel to set.
	 */
	public void setLblAvionRojo(JLabel lblAvionRojo) {
		this.lblAvionRojo = lblAvionRojo;
	}

	/**
	 * Gets the JLabel for the red soldier.
	 *
	 * @return The JLabel lblSoldadoRojo.
	 */
	public JLabel getLblSoldadoRojo() {
		return lblSoldadoRojo;
	}

	/**
	 * Sets the JLabel for the red soldier.
	 *
	 * @param lblSoldadoRojo The JLabel to set.
	 */
	public void setLblSoldadoRojo(JLabel lblSoldadoRojo) {
		this.lblSoldadoRojo = lblSoldadoRojo;
	}

	/**
	 * Gets the JLabel for the red tank.
	 *
	 * @return The JLabel lblTanqueRojo.
	 */
	public JLabel getLblTanqueRojo() {
		return lblTanqueRojo;
	}

	/**
	 * Sets the JLabel for the red tank.
	 *
	 * @param lblTanqueRojo The JLabel to set.
	 */
	public void setLblTanqueRojo(JLabel lblTanqueRojo) {
		this.lblTanqueRojo = lblTanqueRojo;
	}

	/**
	 * Gets the JLabel for the green airplane.
	 *
	 * @return The JLabel lblAvionVerde.
	 */
	public JLabel getLblAvionVerde() {
		return lblAvionVerde;
	}

	/**
	 * Sets the JLabel for the green airplane.
	 *
	 * @param lblAvionVerde The JLabel to set.
	 */
	public void setLblAvionVerde(JLabel lblAvionVerde) {
		this.lblAvionVerde = lblAvionVerde;
	}

	/**
	 * Gets the JLabel for the green soldier.
	 *
	 * @return The JLabel lblSoldadoVerde.
	 */
	public JLabel getLblSoldadoVerde() {
		return lblSoldadoVerde;
	}

	/**
	 * Sets the JLabel for the green soldier.
	 *
	 * @param lblSoldadoVerde The JLabel to set.
	 */
	public void setLblSoldadoVerde(JLabel lblSoldadoVerde) {
		this.lblSoldadoVerde = lblSoldadoVerde;
	}

	/**
	 * Gets the JLabel for the green tank.
	 *
	 * @return The JLabel lblTanqueVerde.
	 */
	public JLabel getLblTanqueVerde() {
		return lblTanqueVerde;
	}

	/**
	 * Sets the JLabel for the green tank.
	 *
	 * @param lblTanqueVerde The JLabel to set.
	 */
	public void setLblTanqueVerde(JLabel lblTanqueVerde) {
		this.lblTanqueVerde = lblTanqueVerde;
	}

	/**
	 * Gets the JLabel for the blue airplane.
	 *
	 * @return The JLabel lblAvionAzul.
	 */
	public JLabel getLblAvionAzul() {
		return lblAvionAzul;
	}

	/**
	 * Sets the JLabel for the blue airplane.
	 *
	 * @param lblAvionAzul The JLabel to set.
	 */
	public void setLblAvionAzul(JLabel lblAvionAzul) {
		this.lblAvionAzul = lblAvionAzul;
	}

	/**
	 * Gets the JLabel for the blue soldier.
	 *
	 * @return The JLabel lblSoldadoAzul.
	 */
	public JLabel getLblSoldadoAzul() {
		return lblSoldadoAzul;
	}

	/**
	 * Sets the JLabel for the blue soldier.
	 *
	 * @param lblSoldadoAzul The JLabel to set.
	 */
	public void setLblSoldadoAzul(JLabel lblSoldadoAzul) {
		this.lblSoldadoAzul = lblSoldadoAzul;
	}

	/**
	 * Gets the JLabel for the blue tank.
	 *
	 * @return The JLabel lblTanqueAzul.
	 */
	public JLabel getLblTanqueAzul() {
		return lblTanqueAzul;
	}

	/**
	 * Sets the JLabel for the blue tank.
	 *
	 * @param lblTanqueAzul The JLabel to set.
	 */
	public void setLblTanqueAzul(JLabel lblTanqueAzul) {
		this.lblTanqueAzul = lblTanqueAzul;
	}
}