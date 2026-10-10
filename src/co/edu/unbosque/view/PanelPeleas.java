package co.edu.unbosque.view;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Panel that displays animations of battles between different units. It uses a
 * set of background images to show various fights and hides after a set time.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelPeleas extends JPanel {
	/**
	 * Array to store background images for battles.
	 */
	private ImageIcon[] fondos; // Variable de instancia para almacenar los fondos
	/**
	 * Timer used to hide the panel after a set duration.
	 */
	private Timer timer;
	/**
	 * Index of the current background image.
	 */
	private int indiceFondo;
	/**
	 * A map that stores the fights between units, where the key is the name or
	 * identifier of the fight, and the value is the score or result of the fight.
	 */
	private Map<String, Integer> mapaPeleas;

	/**
	 * The current health points (HP) of the left unit/player in the game.
	 */
	private int currentHpLeft;

	/**
	 * The current health points (HP) of the right unit/player in the game.
	 */
	private int currentHpRight;

	/**
	 * The maximum health points (HP) of the left unit/player in the game.
	 */
	private int maxHpLeft;

	/**
	 * The maximum health points (HP) of the right unit/player in the game.
	 */
	private int maxHpRight;
	private ImageIcon marcoHpIzquierda;
	private ImageIcon marcoHpDerecha;

	/**
	 * Initializes the fight panel, loads fight images, and sets up a timer to hide
	 * the panel after a set time.
	 */

	public PanelPeleas() {
		setLayout(null); // Set the parent container's layout to null

		// ARREGLO DE MINI PANELES DE PELEAS

		// 0-5 PELEAS DE TANQUE VS TANQUE
		// 6-11 PELEAS DE SOLDADO VS SOLDADO
		// 12-17 PELEAS DE AVION VS AVION

		// 18-23 PELEAS AVION AMARILLO VS SOLDADOS Y TANQUES (AZUL,ROJO,VERDE)
		// 24-29 PELEAS AVION AZUL VS SOLDADOS Y TANQUES (AMARILLO,ROJO,VERDE)
		// 30-35 PELEAS AVION ROJO VS SOLDADOS Y TANQUES (AZUL,AMARILLO,VERDE)
		// 36-41 PELEAS AVION VERDE VS SOLDADOS Y TANQUES (AZUL,AMARILLO,ROJO)

		// 42-44 PELEAS SOLDADOS AMARILLO VS TANQUES
		// 45-47 PELEAS SOLDADOS AZUL VS TANQUES
		// 48-50 PELEAS SOLDADOS ROJO VS TANQUES
		// 51-53 PELEAS SOLDADOS VERDE VS TANQUES

		fondos = new ImageIcon[] {
				// TANQUES VS TANQUES 0 - 5
				new ImageIcon("resources/images/tanqueVStanque/tanqueAmarilloVSTanqueVerde.gif"),
				new ImageIcon("resources/images/tanqueVStanque/tanqueAzulVSTanqueAmarillo.gif"),
				new ImageIcon("resources/images/tanqueVStanque/tanqueAzulVSTanqueRojo.gif"),
				new ImageIcon("resources/images/tanqueVStanque/tanqueAzulVSTanqueVerde.gif"),
				new ImageIcon("resources/images/tanqueVStanque/tanqueRojoVSTanqueAmarillo.gif"),
				new ImageIcon("resources/images/tanqueVStanque/tanqueRojoVSTanqueVerde.gif"),

				// SOLDADO VS SOLDADO 6 - 11
				new ImageIcon("resources/images/soldadoVSsoldado/soldadoAzulVSAmarillo.gif"),
				new ImageIcon("resources/images/soldadoVSsoldado/soldadoAzulVSRojo.gif"),
				new ImageIcon("resources/images/soldadoVSsoldado/soldadoAzulVSVerde.gif"),
				new ImageIcon("resources/images/soldadoVSsoldado/soldadoRojoVSAmarillo.gif"),
				new ImageIcon("resources/images/soldadoVSsoldado/soldadoRojoVSVerde.gif"),
				new ImageIcon("resources/images/soldadoVSsoldado/soldadoVerdeVSAmarillo.gif"),

				// AVION VS AVION 12 - 17
				new ImageIcon("resources/images/avionVSavion/avionAzulVSAvionAmarillo.gif"),
				new ImageIcon("resources/images/avionVSavion/avionAzulVSAvionRojo.gif"),
				new ImageIcon("resources/images/avionVSavion/avionAzulVSAvionVerde.gif"),
				new ImageIcon("resources/images/avionVSavion/avionRojoVSAvionAmarillo.gif"), //
				new ImageIcon("resources/images/avionVSavion/avionRojoVSAvionVerde.gif"),
				new ImageIcon("resources/images/avionVSavion/avionVerdeVSAvionAmarillo.gif"),

				// PELEAS AVION AMARILLO VS SOLDADOS Y TANQUES, 18 - 23
				new ImageIcon("resources/images/GIfEstructura/avionAmarilloVSsoldadoAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAmarilloVSsoldadoRojo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAmarilloVSsoldadoVerde.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAmarilloVStanqueAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAmarilloVStanqueRojo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAmarilloVStanqueVerde.gif"),

				// PELEAS AVION AZUL VS SOLDADOS Y TANQUES, 24 - 29
				new ImageIcon("resources/images/GIfEstructura/avionAzulVSsoldadoAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAzulVSsoldadoRojo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAzulVSsoldadoVerde.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAzulVStanqueAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAzulVStanqueRojo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionAzulVStanqueVerde.gif"),

				// PELEAS AVION ROJO VS SOLDADOS Y TANQUES, 30 - 35
				new ImageIcon("resources/images/GIfEstructura/avionRojoVSsoldadoAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionRojoVSsoldadoAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionRojoVSsoldadoVerde.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionRojoVStanqueAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionRojoVStanqueAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionRojoVStanqueVerde.gif"),

				// PELEAS AVION VERDE VS SOLDADOS Y TANQUES, 36 - 41
				new ImageIcon("resources/images/GIfEstructura/avionVerdeVSsoldadoAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionVerdeVSsoldadoAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionVerdeVSsoldadoRojo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionVerdeVStanqueAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionVerdeVStanqueAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/avionVerdeVStanqueRojo.gif"),

				// PELEAS SOLDADO AMARILLO VS TANQUES, 42 - 44
				new ImageIcon("resources/images/GIfEstructura/soldadoAmarilloVStanqueAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoAmarilloVStanqueRojo.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoAmarilloVStanqueVerde.gif"),

				// PELEAS SOLDADO AZUL VS TANQUES 45 - 47
				new ImageIcon("resources/images/GIfEstructura/soldadoAzulVStanqueAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoAzulVStanqueRojo.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoAzulVStanqueVerde.gif"),

				// PELEAS SOLDADO ROJO VS TANQUES 48 - 50
				new ImageIcon("resources/images/GIfEstructura/soldadoRojoVStanqueAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoRojoVStanqueAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoRojoVStanqueVerde.gif"),

				// PELEAS SOLDADO VERDE VS TANQUES 51 - 53
				new ImageIcon("resources/images/GIfEstructura/soldadoVerdeVStanqueAmarillo.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoVerdeVStanqueAzul.gif"),
				new ImageIcon("resources/images/GIfEstructura/soldadoVerdeVStanqueRojo.gif"), };

		mapaPeleas = new HashMap<>();
		inicializarMapaPeleas();

		// Inicializa el temporizador
		timer = new Timer(8000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminarPanel();
			}
		});

		marcoHpIzquierda = new ImageIcon("resources/images/tutorial/atacante.png");
		marcoHpDerecha = new ImageIcon("resources/images/tutorial/defensor.png");

		timer.setRepeats(true); // Solo se ejecuta una vez
		timer.start(); // Inicia el temporizador
	}

	/**
	 * Draws a health bar on the screen to visually represent the current health of
	 * a unit or player. The bar is filled with green color for the current health
	 * and red color for the remaining health. The bar can be drawn either from left
	 * to right or right to left based on the specified direction.
	 *
	 * @param g           The Graphics2D object used to render the health bar.
	 * @param x           The x-coordinate of the top-left corner of the health bar.
	 * @param y           The y-coordinate of the top-left corner of the health bar.
	 * @param barWidth    The width of the health bar.
	 * @param barHeight   The height of the health bar.
	 * @param currentHp   The current health value.
	 * @param maxHp       The maximum health value.
	 * @param leftToRight A boolean indicating the direction in which the health bar
	 *                    should be filled: if true, the bar is filled from left to
	 *                    right; if false, the bar is filled from right to left.
	 */
	private void drawHealthBar(Graphics2D g, int x, int y, int barWidth, int barHeight, int currentHp, int maxHp,
			boolean leftToRight) {
		int currentBarWidth = (int) ((double) currentHp / maxHp * barWidth);

		g.setColor(Color.RED);
		g.fillRect(x, y, barWidth, barHeight);

		g.setColor(Color.GREEN);
		if (leftToRight) {
			g.fillRect(x, y, currentBarWidth, barHeight);
		} else {
			g.fillRect(x + (barWidth - currentBarWidth), y, currentBarWidth, barHeight);
		}

		g.setColor(Color.BLACK);
		g.drawRect(x, y, barWidth, barHeight);
	}

	/**
	 * Initializes the fight map with specific keys representing different combat
	 * scenarios and their corresponding image indices.
	 */
	public void inicializarMapaPeleas() {

		mapaPeleas.put("tanque_amarillo_vs_tanque_verde", 0);
		mapaPeleas.put("tanque_azul_vs_tanque_amarillo", 1);
		mapaPeleas.put("tanque_azul_vs_tanque_rojo", 2);
		mapaPeleas.put("tanque_azul_vs_tanque_verde", 3);
		mapaPeleas.put("tanque_rojo_vs_tanque_amarillo", 4);
		mapaPeleas.put("tanque_rojo_vs_tanque_verde", 5);

		// SOLDADO VS SOLDADO 6 - 11
		mapaPeleas.put("soldado_azul_vs_soldado_amarillo", 6);
		mapaPeleas.put("soldado_azul_vs_soldado_rojo", 7);
		mapaPeleas.put("soldado_azul_vs_soldado_verde", 8);
		mapaPeleas.put("soldado_rojo_vs_soldado_amarillo", 9);
		mapaPeleas.put("soldado_rojo_vs_soldado_verde", 10);
		mapaPeleas.put("soldado_verde_vs_soldado_amarillo", 11);

		// AVION VS AVION 12 - 17
		mapaPeleas.put("avion_azul_vs_avion_amarillo", 12);
		mapaPeleas.put("avion_azul_vs_avion_rojo", 13);
		mapaPeleas.put("avion_azul_vs_avion_verde", 14);
		mapaPeleas.put("avion_rojo_vs_avion_amarillo", 15);
		mapaPeleas.put("avion_rojo_vs_avion_verde", 16);
		mapaPeleas.put("avion_verde_vs_avion_amarillo", 17);

		// AVION AMARILLO VS SOLDADOS Y TANQUES, 18 - 23
		mapaPeleas.put("avion_amarillo_vs_soldado_azul", 18);
		mapaPeleas.put("avion_amarillo_vs_soldado_rojo", 19);
		mapaPeleas.put("avion_amarillo_vs_soldado_verde", 20);
		mapaPeleas.put("avion_amarillo_vs_tanque_azul", 21);
		mapaPeleas.put("avion_amarillo_vs_tanque_rojo", 22);
		mapaPeleas.put("avion_amarillo_vs_tanque_verde", 23);

		// AVION AZUL VS SOLDADOS Y TANQUES, 24 - 29
		mapaPeleas.put("avion_azul_vs_soldado_amarillo", 24);
		mapaPeleas.put("avion_azul_vs_soldado_rojo", 25);
		mapaPeleas.put("avion_azul_vs_soldado_verde", 26);
		mapaPeleas.put("avion_azul_vs_tanque_amarillo", 27);
		mapaPeleas.put("avion_azul_vs_tanque_rojo", 28);
		mapaPeleas.put("avion_azul_vs_tanque_verde", 29);

		// AVION ROJO VS SOLDADOS Y TANQUES, 30 - 35
		mapaPeleas.put("avion_rojo_vs_soldado_amarillo", 30);
		mapaPeleas.put("avion_rojo_vs_soldado_azul", 31);
		mapaPeleas.put("avion_rojo_vs_soldado_verde", 32);
		mapaPeleas.put("avion_rojo_vs_tanque_amarillo", 33);
		mapaPeleas.put("avion_rojo_vs_tanque_azul", 34);
		mapaPeleas.put("avion_rojo_vs_tanque_verde", 35);

		// AVION VERDE VS SOLDADOS Y TANQUES, 36 - 41
		mapaPeleas.put("avion_verde_vs_soldado_amarillo", 36);
		mapaPeleas.put("avion_verde_vs_soldado_azul", 37);
		mapaPeleas.put("avion_verde_vs_soldado_rojo", 38);
		mapaPeleas.put("avion_verde_vs_tanque_amarillo", 39);
		mapaPeleas.put("avion_verde_vs_tanque_azul", 40);
		mapaPeleas.put("avion_verde_vs_tanque_rojo", 41);

		// SOLDADO AMARILLO VS TANQUES, 42 - 44
		mapaPeleas.put("soldado_amarillo_vs_tanque_azul", 42);
		mapaPeleas.put("soldado_amarillo_vs_tanque_rojo", 43);
		mapaPeleas.put("soldado_amarillo_vs_tanque_verde", 44);

		// SOLDADO AZUL VS TANQUES, 45 - 47
		mapaPeleas.put("soldado_azul_vs_tanque_amarillo", 45);
		mapaPeleas.put("soldado_azul_vs_tanque_rojo", 46);
		mapaPeleas.put("soldado_azul_vs_tanque_verde", 47);

		// SOLDADO ROJO VS TANQUES, 48 - 50
		mapaPeleas.put("soldado_rojo_vs_tanque_amarillo", 48);
		mapaPeleas.put("soldado_rojo_vs_tanque_azul", 49);
		mapaPeleas.put("soldado_rojo_vs_tanque_verde", 50);

		// SOLDADO VERDE VS TANQUES, 51 - 53
		mapaPeleas.put("soldado_verde_vs_tanque_amarillo", 51);
		mapaPeleas.put("soldado_verde_vs_tanque_azul", 52);
		mapaPeleas.put("soldado_verde_vs_tanque_rojo", 53);

	}

	/**
	 * Retrieves the index of the image associated with a fight between the
	 * specified attacker and defender.
	 *
	 * @param tipoAtacante   the type of the attacking unit (e.g., "soldado" or
	 *                       "avion")
	 * @param equipoAtacante the team of the attacking unit (e.g., "azul" or "rojo")
	 * @param tipoDefensor   the type of the defending unit (e.g., "soldado" or
	 *                       "tanque")
	 * @param equipoDefensor the team of the defending unit (e.g., "amarillo" or
	 *                       "verde")
	 * @return the index of the image if a match is found, or -1 if no match is
	 *         available
	 */
	public int obtenerIndiceImagenPelea(String tipoAtacante, String equipoAtacante, String tipoDefensor,
			String equipoDefensor) {
		String clave = tipoAtacante + "_" + equipoAtacante + "_vs_" + tipoDefensor + "_" + equipoDefensor;

		// Intentar con la clave original
		if (mapaPeleas.containsKey(clave)) {
			return mapaPeleas.get(clave);
		} else {
			// Intentar con la clave invertida (defensor como atacante y viceversa)
			String claveInvertida = tipoDefensor + "_" + equipoDefensor + "_vs_" + tipoAtacante + "_" + equipoAtacante;
			System.out.println("Clave no encontrada: " + clave + ". Intentando clave invertida: " + claveInvertida);

			if (mapaPeleas.containsKey(claveInvertida)) {
				return mapaPeleas.get(claveInvertida);
			} else {
				System.out.println("Clave invertida tampoco encontrada: " + claveInvertida);
				return -1; // Retorna -1 si ninguna clave está disponible
			}
		}
	}

	/**
	 * Changes the background image based on the type and team of both the attacker
	 * and defender.
	 *
	 * @param tipoAtacante   the type of the attacking unit (e.g., "tanque" or
	 *                       "avion")
	 * @param equipoAtacante the team of the attacking unit (e.g., "amarillo" or
	 *                       "verde")
	 * @param tipoDefensor   the type of the defending unit (e.g., "soldado" or
	 *                       "tanque")
	 * @param equipoDefensor the team of the defending unit (e.g., "azul" or "rojo")
	 */
	public void cambiarFondoConTipoYEquipo(String tipoAtacante, String equipoAtacante, String tipoDefensor,
			String equipoDefensor) {

		int indiceImagen = obtenerIndiceImagenPelea(tipoAtacante, equipoAtacante, tipoDefensor, equipoDefensor);

		if (indiceImagen != -1) {
			cambiarFondo(indiceImagen); // Llama a cambiarFondo para actualizar la imagen

			this.setVisible(true); // Asegura que el panel de pelea se muestre
		} else {
		}
	}

	/**
	 * Gets the preferred size of the panel.
	 * 
	 * @return The preferred Dimension of the panel.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(1112, 671); // Set the preferred size for the panel
	}

	/**
	 * Obtains the fight map containing combat scenarios and their corresponding
	 * image indices.
	 *
	 * @return the map of fight scenarios with keys as combat descriptions and
	 *         values as image indices
	 */
	public Map<String, Integer> getMapaPeleas() {
		return mapaPeleas;
	}

	/**
	 * Sets the fight map with a new set of combat scenarios and their image
	 * indices.
	 *
	 * @param mapaPeleas the map of fight scenarios to set, where keys are combat
	 *                   descriptions and values are image indices
	 */
	public void setMapaPeleas(Map<String, Integer> mapaPeleas) {
		this.mapaPeleas = mapaPeleas;
	}

	/**
	 * Changes the current background to the image at the specified index.
	 * 
	 * @param posicion The index of the background image to display.
	 */
	public void cambiarFondo(int posicion) {
		if (posicion >= 0 && posicion < fondos.length) {
			this.indiceFondo = posicion;
			repaint();
		} else {
		}
	}

	/**
	 * Draws the component, including the current fight background.
	 * 
	 * @param g The Graphics object used to draw the component.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int ancho = 1112;
		int alto = 671;

		// Dibuja el fondo actual de pelea
		if (fondos[indiceFondo] != null) {
			g.drawImage(fondos[indiceFondo].getImage(), 0, 0, ancho, alto, this);

			// Dibuja las barras de vida en sus posiciones originales
			drawHealthBar((Graphics2D) g, 20, 12, 170, 25, currentHpLeft, maxHpLeft, true);
			drawHealthBar((Graphics2D) g, ancho - 190, 12, 170, 25, currentHpRight, maxHpRight, false);
		}

		// Dibuja los marcos de las barras de vida pegados a los bordes
		if (marcoHpIzquierda != null) {
			g.drawImage(marcoHpIzquierda.getImage(), 0, 7, 230, 53, this); // Posición X ajustada a 0
		}
		if (marcoHpDerecha != null) {
			g.drawImage(marcoHpDerecha.getImage(), ancho - 228, 8, 228, 53, this); // Posición X ajustada para que esté
																					// pegado al borde derecho
		}
	}

	/**
	 * Sets the current health for the left entity (e.g., left player or unit).
	 * Ensures that the current health is not less than 0 and updates the max health
	 * value. Calls repaint to refresh the display after the health is updated.
	 *
	 * @param health    The current health value to be set.
	 * @param maxHealth The maximum health value to be set.
	 */
	public void setCurrentHealthLeft(int health, int maxHealth) {
		this.currentHpLeft = Math.max(0, health);
		this.maxHpLeft = maxHealth; // Asegúrate de agregar una variable `maxHpLeft`
		repaint();
	}

	/**
	 * Sets the current health for the right entity (e.g., right player or unit).
	 * Ensures that the current health is not less than 0 and updates the max health
	 * value. Calls repaint to refresh the display after the health is updated.
	 *
	 * @param health    The current health value to be set.
	 * @param maxHealth The maximum health value to be set.
	 */
	public void setCurrentHealthRight(int health, int maxHealth) {
		this.currentHpRight = Math.max(0, health);
		this.maxHpRight = maxHealth; // Asegúrate de agregar una variable `maxHpRight`
		repaint();
	}

	/**
	 * Hides the fight panel by setting its visibility to false. Called when the
	 * timer expires.
	 */
	private void eliminarPanel() {
		this.setVisible(false);
	}

	/**
	 * Obtains the array of background images.
	 *
	 * @return the array of background images
	 */
	public ImageIcon[] getFondos() {
		return fondos;
	}

	/**
	 * Sets the array of background images.
	 *
	 * @param fondos the array of background images to set
	 */
	public void setFondos(ImageIcon[] fondos) {
		this.fondos = fondos;
	}

	/**
	 * Obtains the timer used for background transitions or other timed actions.
	 *
	 * @return the timer
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * Sets the timer for managing timed actions or background transitions.
	 *
	 * @param timer the timer to set
	 */
	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	/**
	 * Obtains the current index of the background image in use.
	 *
	 * @return the index of the current background image
	 */
	public int getIndiceFondo() {
		return indiceFondo;
	}

	/**
	 * Sets the index of the background image to be used.
	 *
	 * @param indiceFondo the index of the background image to set
	 */
	public void setIndiceFondo(int indiceFondo) {
		this.indiceFondo = indiceFondo;
	}

	public int getCurrentHpLeft() {
		return currentHpLeft;
	}

	public void setCurrentHpLeft(int currentHpLeft) {
		this.currentHpLeft = currentHpLeft;
	}

	public int getCurrentHpRight() {
		return currentHpRight;
	}

	public void setCurrentHpRight(int currentHpRight) {
		this.currentHpRight = currentHpRight;
	}

	public int getMaxHpLeft() {
		return maxHpLeft;
	}

	public void setMaxHpLeft(int maxHpLeft) {
		this.maxHpLeft = maxHpLeft;
	}

	public int getMaxHpRight() {
		return maxHpRight;
	}

	public void setMaxHpRight(int maxHpRight) {
		this.maxHpRight = maxHpRight;
	}

}
