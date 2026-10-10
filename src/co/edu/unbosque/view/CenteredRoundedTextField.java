package co.edu.unbosque.view;

import java.awt.Graphics;
import javax.swing.SwingConstants;

/**
 * Class that represents a rounded text field with centered text. Extends the
 * {@link RoundedTextField} class to provide centered text alignment.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class CenteredRoundedTextField extends RoundedTextField {
	/**
	 * Constructor of the CenteredRoundedTextField class.
	 *
	 * @param columns The number of columns for the text field.
	 */
	public CenteredRoundedTextField(int columns) {
		super(columns);
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	/**
	 * Draws the component. This method is overridden to maintain the functionality
	 * of {@link RoundedTextField}, although the behavior is not modified in this
	 * implementation.
	 *
	 * @param g The Graphics object used to draw the component.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
}
