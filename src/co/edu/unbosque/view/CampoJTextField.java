package co.edu.unbosque.view;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JTextField;

/**
 * A customized JTextField with rounded corners.
 */
public class CampoJTextField extends JTextField {
	/**
	 * Defines the shape of the text field, used to determine if a point is within
	 * the field.
	 */
	private Shape shape;

	/**
	 * Creates an instance of CampoJTextField with rounded corners.
	 */
	public CampoJTextField() {

	}

	/**
	 * Paints the background of the text field with rounded corners.
	 *
	 * @param g the Graphics object used to render the component
	 */
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		super.paintComponent(g);
	}

	/**
	 * Paints the border of the text field with rounded corners.
	 *
	 * @param g the Graphics object used to render the border
	 */
	protected void paintBorder(Graphics g) {
		g.setColor(getForeground());
		g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
	}

	/**
	 * Checks if a specified point is contained within the rounded shape of the text
	 * field.
	 *
	 * @param x the x-coordinate of the point to check
	 * @param y the y-coordinate of the point to check
	 * @return true if the point is within the shape, false otherwise
	 */
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
			shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
		}
		return shape.contains(x, y);
	}
}