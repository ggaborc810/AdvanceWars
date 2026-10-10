package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Class representing a panel to manage the interface of a two-player game. This
 * panel includes buttons to add and remove units (planes, soldiers, and tanks)
 * for each player and displays relevant information such as money and unit
 * counts.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelJugadores2 extends JPanel {

	public JLabel getMoneda() {
		return moneda;
	}

	public void setMoneda(JLabel moneda) {
		this.moneda = moneda;
	}

	public JLabel getMoneda1() {
		return moneda1;
	}

	public void setMoneda1(JLabel moneda1) {
		this.moneda1 = moneda1;
	}

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
	 * Label to display the amount of money.
	 */
	private JLabel moneda;

	/**
	 * Second label to display the amount of money.
	 */
	private JLabel moneda1;

	/**
	 * Label representing the red airplane.
	 */
	private JLabel avionRojo;

	/**
	 * Label representing the red soldier.
	 */
	private JLabel soldadoRojo;

	/**
	 * Label representing the red tank.
	 */
	private JLabel tanqueRojo;

	/**
	 * Label representing the green airplane.
	 */
	private JLabel avionVerde;

	/**
	 * Label representing the green soldier.
	 */
	private JLabel soldadoVerde;

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
	 * Label showing the amount of money.
	 */
	private JLabel lblDinero;

	/**
	 * Second label showing the amount of money.
	 */
	private JLabel lblDinero2;

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
	 * Constructor for the PanelJugadores2 class. Initializes the panel, sets its
	 * size, layout, and adds the necessary components for the two-player game
	 * interface.
	 */
	public PanelJugadores2() {
		setSize(1391, 839);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		lblDinero = generarMensaje("50", 355, 145, 100, 100);
		lblDinero2 = generarMensaje("50", 1065, 145, 100, 100);

		lblAvionRojo = generarMensaje("0", 615, 365, 100, 100);
		lblSoldadoRojo = generarMensaje("0", 615, 462, 100, 100);
		lblTanqueRojo = generarMensaje("0", 615, 570, 100, 100);

		lblAvionVerde = generarMensaje("0", 1340, 365, 100, 100);
		lblSoldadoVerde = generarMensaje("0", 1340, 462, 100, 100);
		lblTanqueVerde = generarMensaje("0", 1340, 570, 100, 100);

		fondo = new ImageIcon("resources/images/opciones/dosJugadores.png");

		btnBack = generarBoton("VOLVER", 50, 700, 190, 60, "");
		btnOk = generarBoton("SIGUIENTE", 1160, 710, 160, 60, "");

		moneda = generarGif(135, 160, 70, 70, "resources/images/Moneda.gif");
		moneda1 = generarGif(850, 160, 70, 70, "resources/images/Moneda.gif");

		avionRojo = generarGif(550, 365, 100, 100, "resources/images/aviones/avionRojo.gif");
		soldadoRojo = generarGif(550, 462, 100, 100, "resources/images/soldados/soldadoRojo.gif");
		tanqueRojo = generarGif(550, 570, 100, 100, "resources/images/tanques/tanqueRojo.gif");

		avionVerde = generarGif(1250, 365, 100, 100, "resources/images/aviones/avionVerde.gif");
		soldadoVerde = generarGif(1250, 462, 100, 100, "resources/images/soldados/soldadoVerde.gif");
		tanqueVerde = generarGif(1250, 570, 100, 100, "resources/images/tanques/tanqueVerde.gif");

		btnAgregarAvionRojoMas = generarBoton("agregar", 50, 400, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoRojoMas = generarBoton("agregar", 50, 500, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueRojoMas = generarBoton("agregar", 50, 605, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionRojoMenos = generarBoton("quitar", 90, 400, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoRojoMenos = generarBoton("quitar", 90, 500, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueRojoMenos = generarBoton("quitar", 90, 605, 30, 30, "resources/images/opciones/quitar.png");

		btnAgregarAvionVerdeMas = generarBoton("agregar", 740, 400, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarSoldadoVerdeMas = generarBoton("agregar", 740, 500, 30, 30, "resources/images/opciones/agregar.png");
		btnAgregarTanqueVerdeMas = generarBoton("agregar", 740, 605, 30, 30, "resources/images/opciones/agregar.png");

		btnAgregarAvionVerdeMenos = generarBoton("quitar", 780, 400, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarSoldadoVerdeMenos = generarBoton("quitar", 780, 500, 30, 30, "resources/images/opciones/quitar.png");
		btnAgregarTanqueVerdeMenos = generarBoton("quitar", 780, 605, 30, 30, "resources/images/opciones/quitar.png");

		add(lblDinero2);
		add(btnBack);
		add(btnOk);
		add(lblDinero);
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

		add(avionRojo);
		add(soldadoRojo);
		add(tanqueRojo);
		add(avionVerde);
		add(soldadoVerde);
		add(tanqueVerde);

		add(lblAvionRojo);
		add(lblSoldadoRojo);
		add(lblTanqueRojo);
		add(lblAvionVerde);
		add(lblSoldadoVerde);
		add(lblTanqueVerde);
		add(moneda);
		add(moneda1);

		repaint();
	}

	/**
	 * Method responsible for drawing the background of the panel.
	 *
	 * @param g The Graphics object used to draw the background.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1380;
		int alto = 805;
		g.drawImage(fondo.getImage(), 0, 0, ancho, alto, this);
	}

	/**
	 * Method that generates a JLabel displaying a GIF.
	 *
	 * @param x     The x coordinate of the JLabel.
	 * @param y     The y coordinate of the JLabel.
	 * @param ancho The width of the JLabel.
	 * @param alto  The height of the JLabel.
	 * @param url   The URL of the GIF image.
	 * @return The created JLabel.
	 */

	public JLabel generarGif(int x, int y, int ancho, int alto, String url) {
		ImageIcon gifIcon = new ImageIcon(url);
		gif = new JLabel(gifIcon);
		gif.setBounds(x, y, ancho, alto);
		return gif;
	}

	/**
	 * Generates a JButton with the specified properties.
	 *
	 * @param texto the text of the button
	 * @param x     the x position of the button
	 * @param y     the y position of the button
	 * @param ancho the width of the button
	 * @param alto  the height of the button
	 * @param url   the path of the button's icon image
	 * @return the generated JButton
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
	 * Generates a JLabel with the specified text.
	 *
	 * @param texto the text of the JLabel
	 * @param x     the x position of the JLabel
	 * @param y     the y position of the JLabel
	 * @param ancho the width of the JLabel
	 * @param alto  the height of the JLabel
	 * @return the generated JLabel
	 */
	public JLabel generarMensaje(String texto, int x, int y, int ancho, int alto) {
		JLabel lbl = new JLabel(texto);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("IMPACT", Font.BOLD, 32));
		lbl.setBounds(x, y, ancho, alto);
		return lbl;
	}

	/**
	 * Gets the "OK" button.
	 *
	 * @return the "OK" button
	 */

	public JButton getBtnOk() {
		return btnOk;
	}

	/**
	 * Establece el botón "OK".
	 * 
	 * @param btnOk el botón "OK" a establecer
	 */
	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	/**
	 * Gets the "Back" button.
	 *
	 * @return the "Back" button
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * Sets the "Back" button.
	 *
	 * @param btnBack the "Back" button to set
	 */
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	/**
	 * Gets the background of the panel.
	 *
	 * @return the ImageIcon of the background
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background of the panel.
	 *
	 * @param fondo the ImageIcon of the background to set
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * Gets the JLabel containing the GIF.
	 *
	 * @return the JLabel of the GIF
	 */
	public JLabel getGif() {
		return gif;
	}

	/**
	 * Sets the JLabel containing the GIF.
	 *
	 * @param gif the JLabel of the GIF to set
	 */
	public void setGif(JLabel gif) {
		this.gif = gif;
	}

	/**
	 * Gets the JLabel of the red airplane.
	 *
	 * @return the JLabel of the red airplane
	 */
	public JLabel getAvionRojo() {
		return avionRojo;
	}

	/**
	 * Sets the JLabel of the red airplane.
	 *
	 * @param avionRojo the JLabel of the red airplane to set
	 */
	public void setAvionRojo(JLabel avionRojo) {
		this.avionRojo = avionRojo;
	}

	/**
	 * Gets the JLabel of the red soldier.
	 *
	 * @return the JLabel of the red soldier
	 */
	public JLabel getSoldadoRojo() {
		return soldadoRojo;
	}

	/**
	 * Sets the JLabel of the red soldier.
	 *
	 * @param soldadoRojo the JLabel of the red soldier to set
	 */
	public void setSoldadoRojo(JLabel soldadoRojo) {
		this.soldadoRojo = soldadoRojo;
	}

	/**
	 * Gets the JLabel of the red tank.
	 *
	 * @return the JLabel of the red tank
	 */
	public JLabel getTanqueRojo() {
		return tanqueRojo;
	}

	/**
	 * Sets the JLabel of the red tank.
	 *
	 * @param tanqueRojo the JLabel of the red tank to set
	 */
	public void setTanqueRojo(JLabel tanqueRojo) {
		this.tanqueRojo = tanqueRojo;
	}

	/**
	 * Gets the JLabel of the green airplane.
	 *
	 * @return the JLabel of the green airplane
	 */
	public JLabel getAvionVerde() {
		return avionVerde;
	}

	/**
	 * Sets the JLabel of the green airplane.
	 *
	 * @param avionVerde the JLabel of the green airplane to set
	 */
	public void setAvionVerde(JLabel avionVerde) {
		this.avionVerde = avionVerde;
	}

	/**
	 * Gets the JLabel of the green soldier.
	 *
	 * @return the JLabel of the green soldier
	 */
	public JLabel getSoldadoVerde() {
		return soldadoVerde;
	}

	/**
	 * Sets the JLabel of the green soldier.
	 *
	 * @param soldadoVerde the JLabel of the green soldier to set
	 */
	public void setSoldadoVerde(JLabel soldadoVerde) {
		this.soldadoVerde = soldadoVerde;
	}

	/**
	 * Gets the JLabel of the green tank.
	 *
	 * @return the JLabel of the green tank
	 */
	public JLabel getTanqueVerde() {
		return tanqueVerde;
	}

	/**
	 * Sets the JLabel of the green tank.
	 *
	 * @param tanqueVerde the JLabel of the green tank to set
	 */
	public void setTanqueVerde(JLabel tanqueVerde) {
		this.tanqueVerde = tanqueVerde;
	}

	/**
	 * Gets the button to add a red airplane.
	 *
	 * @return the button to add a red airplane
	 */
	public JButton getBtnAgregarAvionRojoMas() {
		return btnAgregarAvionRojoMas;
	}

	/**
	 * Sets the button to add a red airplane.
	 *
	 * @param btnAgregarAvionRojoMas the button to add a red airplane to set
	 */
	public void setBtnAgregarAvionRojoMas(JButton btnAgregarAvionRojoMas) {
		this.btnAgregarAvionRojoMas = btnAgregarAvionRojoMas;
	}

	/**
	 * Gets the button to add a red soldier.
	 *
	 * @return the button to add a red soldier
	 */
	public JButton getBtnAgregarSoldadoRojoMas() {
		return btnAgregarSoldadoRojoMas;
	}

	/**
	 * Sets the button to add a red soldier.
	 *
	 * @param btnAgregarSoldadoRojoMas the button to add a red soldier to set
	 */
	public void setBtnAgregarSoldadoRojoMas(JButton btnAgregarSoldadoRojoMas) {
		this.btnAgregarSoldadoRojoMas = btnAgregarSoldadoRojoMas;
	}

	/**
	 * Gets the button to add a red tank.
	 *
	 * @return the button to add a red tank
	 */
	public JButton getBtnAgregarTanqueRojoMas() {
		return btnAgregarTanqueRojoMas;
	}

	/**
	 * Sets the button to add a red tank.
	 *
	 * @param btnAgregarTanqueRojoMas the button to add a red tank to set
	 */
	public void setBtnAgregarTanqueRojoMas(JButton btnAgregarTanqueRojoMas) {
		this.btnAgregarTanqueRojoMas = btnAgregarTanqueRojoMas;
	}

	/**
	 * Gets the button to subtract a red airplane.
	 *
	 * @return the button to subtract a red airplane
	 */
	public JButton getBtnAgregarAvionRojoMenos() {
		return btnAgregarAvionRojoMenos;
	}

	/**
	 * Sets the button to subtract a red airplane.
	 *
	 * @param btnAgregarAvionRojoMenos the button to subtract a red airplane to set
	 */
	public void setBtnAgregarAvionRojoMenos(JButton btnAgregarAvionRojoMenos) {
		this.btnAgregarAvionRojoMenos = btnAgregarAvionRojoMenos;
	}

	/**
	 * Gets the button to subtract a red soldier.
	 *
	 * @return the button to subtract a red soldier
	 */
	public JButton getBtnAgregarSoldadoRojoMenos() {
		return btnAgregarSoldadoRojoMenos;
	}

	/**
	 * Sets the button to subtract a red soldier.
	 *
	 * @param btnAgregarSoldadoRojoMenos the button to subtract a red soldier to set
	 */

	public void setBtnAgregarSoldadoRojoMenos(JButton btnAgregarSoldadoRojoMenos) {
		this.btnAgregarSoldadoRojoMenos = btnAgregarSoldadoRojoMenos;
	}

	/**
	 * Gets the button to subtract a red tank.
	 *
	 * @return the button to subtract a red tank
	 */
	public JButton getBtnAgregarTanqueRojoMenos() {
		return btnAgregarTanqueRojoMenos;
	}

	/**
	 * Sets the button to subtract a red tank.
	 *
	 * @param btnAgregarTanqueRojoMenos the button to subtract a red tank to set
	 */
	public void setBtnAgregarTanqueRojoMenos(JButton btnAgregarTanqueRojoMenos) {
		this.btnAgregarTanqueRojoMenos = btnAgregarTanqueRojoMenos;
	}

	/**
	 * Gets the button to subtract a green airplane.
	 *
	 * @return the button to subtract a green airplane
	 */
	public JButton getBtnAgregarAvionVerdeMenos() {
		return btnAgregarAvionVerdeMenos;
	}

	/**
	 * Sets the button to subtract a green airplane.
	 *
	 * @param btnAgregarAvionVerdeMenos the button to subtract a green airplane to
	 *                                  set
	 */
	public void setBtnAgregarAvionVerdeMenos(JButton btnAgregarAvionVerdeMenos) {
		this.btnAgregarAvionVerdeMenos = btnAgregarAvionVerdeMenos;
	}

	/**
	 * Gets the button to subtract a green soldier.
	 *
	 * @return the button to subtract a green soldier
	 */
	public JButton getBtnAgregarSoldadoVerdeMenos() {
		return btnAgregarSoldadoVerdeMenos;
	}

	/**
	 * Sets the button to subtract a green soldier.
	 *
	 * @param btnAgregarSoldadoVerdeMenos the button to subtract a green soldier to
	 *                                    set
	 */
	public void setBtnAgregarSoldadoVerdeMenos(JButton btnAgregarSoldadoVerdeMenos) {
		this.btnAgregarSoldadoVerdeMenos = btnAgregarSoldadoVerdeMenos;
	}

	/**
	 * Gets the button to subtract a green tank.
	 *
	 * @return the button to subtract a green tank
	 */
	public JButton getBtnAgregarTanqueVerdeMenos() {
		return btnAgregarTanqueVerdeMenos;
	}

	/**
	 * Sets the button to subtract a green tank.
	 *
	 * @param btnAgregarTanqueVerdeMenos the button to subtract a green tank to set
	 */
	public void setBtnAgregarTanqueVerdeMenos(JButton btnAgregarTanqueVerdeMenos) {
		this.btnAgregarTanqueVerdeMenos = btnAgregarTanqueVerdeMenos;
	}

	/**
	 * Gets the button to add a green airplane.
	 *
	 * @return the button to add a green airplane
	 */
	public JButton getBtnAgregarAvionVerdeMas() {
		return btnAgregarAvionVerdeMas;
	}

	/**
	 * Sets the button to add a green airplane.
	 *
	 * @param btnAgregarAvionVerdeMas the button to add a green airplane to set
	 */
	public void setBtnAgregarAvionVerdeMas(JButton btnAgregarAvionVerdeMas) {
		this.btnAgregarAvionVerdeMas = btnAgregarAvionVerdeMas;
	}

	/**
	 * Gets the button to add a green soldier.
	 *
	 * @return the button to add a green soldier
	 */
	public JButton getBtnAgregarSoldadoVerdeMas() {
		return btnAgregarSoldadoVerdeMas;
	}

	/**
	 * Sets the button to add a green soldier.
	 *
	 * @param btnAgregarSoldadoVerdeMas the button to add a green soldier to set
	 */
	public void setBtnAgregarSoldadoVerdeMas(JButton btnAgregarSoldadoVerdeMas) {
		this.btnAgregarSoldadoVerdeMas = btnAgregarSoldadoVerdeMas;
	}

	/**
	 * Gets the button to add a green tank.
	 *
	 * @return the button to add a green tank
	 */
	public JButton getBtnAgregarTanqueVerdeMas() {
		return btnAgregarTanqueVerdeMas;
	}

	/**
	 * Sets the button to add a green tank.
	 *
	 * @param btnAgregarTanqueVerdeMas the button to add a green tank to set
	 */
	public void setBtnAgregarTanqueVerdeMas(JButton btnAgregarTanqueVerdeMas) {
		this.btnAgregarTanqueVerdeMas = btnAgregarTanqueVerdeMas;
	}

	/**
	 * Gets the JLabel displaying the amount of money.
	 *
	 * @return the JLabel displaying the amount of money
	 */
	public JLabel getLblDinero() {
		return lblDinero;
	}

	/**
	 * Sets the JLabel displaying the amount of money.
	 *
	 * @param lblDinero the JLabel displaying the amount of money to set
	 */
	public void setLblDinero(JLabel lblDinero) {
		this.lblDinero = lblDinero;
	}

	/**
	 * Gets the JLabel displaying the second amount of money.
	 *
	 * @return the JLabel displaying the second amount of money
	 */
	public JLabel getLblDinero2() {
		return lblDinero2;
	}

	/**
	 * Sets the JLabel displaying the second amount of money.
	 *
	 * @param lblDinero2 the JLabel displaying the second amount of money to set
	 */
	public void setLblDinero2(JLabel lblDinero2) {
		this.lblDinero2 = lblDinero2;
	}

	/**
	 * Gets the JLabel representing the red airplane.
	 *
	 * @return the JLabel representing the red airplane
	 */
	public JLabel getLblAvionRojo() {
		return lblAvionRojo;
	}

	/**
	 * Sets the JLabel representing the red airplane.
	 *
	 * @param lblAvionRojo the JLabel representing the red airplane to set
	 */
	public void setLblAvionRojo(JLabel lblAvionRojo) {
		this.lblAvionRojo = lblAvionRojo;
	}

	/**
	 * Gets the JLabel representing the red soldier.
	 *
	 * @return the JLabel representing the red soldier
	 */
	public JLabel getLblSoldadoRojo() {
		return lblSoldadoRojo;
	}

	/**
	 * Sets the JLabel representing the red soldier.
	 *
	 * @param lblSoldadoRojo the JLabel representing the red soldier to set
	 */
	public void setLblSoldadoRojo(JLabel lblSoldadoRojo) {
		this.lblSoldadoRojo = lblSoldadoRojo;
	}

	/**
	 * Gets the JLabel representing the red tank.
	 *
	 * @return the JLabel representing the red tank
	 */
	public JLabel getLblTanqueRojo() {
		return lblTanqueRojo;
	}

	/**
	 * Sets the JLabel representing the red tank.
	 *
	 * @param lblTanqueRojo the JLabel representing the red tank to set
	 */
	public void setLblTanqueRojo(JLabel lblTanqueRojo) {
		this.lblTanqueRojo = lblTanqueRojo;
	}

	/**
	 * Gets the JLabel representing the green airplane.
	 *
	 * @return the JLabel representing the green airplane
	 */
	public JLabel getLblAvionVerde() {
		return lblAvionVerde;
	}

	/**
	 * Sets the JLabel representing the green airplane.
	 *
	 * @param lblAvionVerde the JLabel representing the green airplane to set
	 */
	public void setLblAvionVerde(JLabel lblAvionVerde) {
		this.lblAvionVerde = lblAvionVerde;
	}

	/**
	 * Gets the JLabel representing the green soldier.
	 *
	 * @return the JLabel representing the green soldier
	 */
	public JLabel getLblSoldadoVerde() {
		return lblSoldadoVerde;
	}

	/**
	 * Sets the JLabel representing the green soldier.
	 *
	 * @param lblSoldadoVerde the JLabel representing the green soldier to set
	 */
	public void setLblSoldadoVerde(JLabel lblSoldadoVerde) {
		this.lblSoldadoVerde = lblSoldadoVerde;
	}

	/**
	 * Gets the JLabel representing the green tank.
	 *
	 * @return the JLabel representing the green tank
	 */
	public JLabel getLblTanqueVerde() {
		return lblTanqueVerde;
	}

	/**
	 * Sets the JLabel representing the green tank.
	 *
	 * @param lblTanqueVerde the JLabel representing the green tank to set
	 */
	public void setLblTanqueVerde(JLabel lblTanqueVerde) {
		this.lblTanqueVerde = lblTanqueVerde;
	}

}