package co.edu.unbosque.view;

import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;

/**
 * Class that represents a text field with rounded borders.
 *
 * This class extends the standard text field to provide a visually appealing
 * design with rounded edges. It can be used in various user interfaces where a
 * softer appearance is desired. The text field maintains its standard
 * functionality while enhancing the aesthetic quality of the application.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */

public class RoundedTextField extends JTextField {
	/**
	 * Radius for the rounded corners.
	 */
	private int radius;

	/**
	 * Constructor that initializes the text field with a specific radius for
	 * rounded corners.
	 *
	 * @param radius the radius of the rounded corners
	 */
	public RoundedTextField(int radius) {
		super();
		this.radius = radius;
		setOpaque(false);
	}

	/**
	 * Renders the text field with a rounded background.
	 *
	 * @param g the graphics object used for drawing
	 */
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(getBackground());
		g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
		super.paintComponent(g);
	}

	/**
	 * Renders the border of the text field with rounded edges.
	 *
	 * @param g the graphics object used for drawing
	 */
	@Override
	protected void paintBorder(Graphics g) {
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
	}
}
