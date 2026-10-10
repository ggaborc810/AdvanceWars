package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Class that provides a method to display pop-up messages using JOptionPane.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class MensajeEmergente extends JOptionPane {
	/**
	 * Constructor of the MensajeEmergente class. It is used to create instances of
	 * the class, although it is not needed in this case since only the static
	 * method is used.
	 */
	public MensajeEmergente() {
	}

	/**
	 * Displays a pop-up message with the provided text.
	 *
	 * @param mensaje The message to be displayed in the dialog box.
	 */
	public static void mostrarMensaje(String mensaje) {
		showMessageDialog(null, mensaje);
	}

	/**
	 * Displays a tutorial image in a dialog box.
	 *
	 * @param url the URL of the image to display in the tutorial dialog
	 */
	public static void mostrarTutorial(String url) {
		ImageIcon icono = new ImageIcon(new ImageIcon(url).getImage());
		JLabel label = new JLabel(icono);

		JOptionPane.showMessageDialog(null, label, "Tutorial", JOptionPane.PLAIN_MESSAGE);

		label.setIcon(null);
		icono.getImage().flush();

	}

	/**
	 * Displays an image located at the specified URL in a dialog box. Creates an
	 * ImageIcon from the URL, which is then set to a JLabel and displayed in a
	 * dialog. After the dialog is closed, the icon is cleared and the image
	 * resources are released.
	 *
	 * @param url the URL or file path to the image to be displayed
	 */
	public static void mostrarTexto(String url) {
		ImageIcon icono = new ImageIcon(new ImageIcon(url).getImage());
		JLabel label = new JLabel(icono);

		JOptionPane.showMessageDialog(null, label, "texto", JOptionPane.PLAIN_MESSAGE);

		label.setIcon(null);
		icono.getImage().flush();

	}

	/**
	 * Displays an image with a message below it in a dialog box.
	 *
	 * @param url     the URL or file path to the image to be displayed
	 * @param mensaje the message to be displayed below the image
	 */
	public static void mostrarInfo(String url, String mensaje, int x, int y, int anchoTexto, int altoTexto) {
		// Definir la fuente del texto
		Font retroFont = new Font("Monospaced", Font.BOLD | Font.ITALIC, 25); // Fuente retro en negrita y cursiva

		// Cargar la imagen desde la URL
		ImageIcon icono = new ImageIcon(new ImageIcon(url).getImage());

		// Crear una etiqueta para la imagen y configurar layout para superposición
		JLabel label = new JLabel(icono) {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				// Configurar la fuente y color del texto
				g.setFont(retroFont);
				g.setColor(Color.BLACK);

				// Configurar el área de texto con las medidas y posición dadas
				FontMetrics fm = g.getFontMetrics();
				int lineHeight = fm.getHeight();
				int espacioEntreLineas = 10; // Espacio adicional entre líneas

				// Dividir el texto en líneas según el ancho especificado
				String[] words = mensaje.split(" ");
				StringBuilder line = new StringBuilder();
				int currentY = y;

				for (String word : words) {
					if (fm.stringWidth(line + word) > anchoTexto) {
						g.drawString(line.toString(), x, currentY);
						line = new StringBuilder(word + " ");
						currentY += lineHeight + espacioEntreLineas; // Agregar espacio adicional entre líneas
					} else {
						line.append(word).append(" ");
					}
				}
				g.drawString(line.toString(), x, currentY); // Dibujar la última línea
			}
		};

		// Ajustar el tamaño del label según el tamaño de la imagen
		label.setPreferredSize(new Dimension(icono.getIconWidth(), icono.getIconHeight()));

		// Mostrar el label con imagen y texto en un JOptionPane
		JOptionPane.showMessageDialog(null, label, "Mensaje Emergente", JOptionPane.PLAIN_MESSAGE);

		// Liberar recursos
		label.setIcon(null);
		icono.getImage().flush();
	}

}