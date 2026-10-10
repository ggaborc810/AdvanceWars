package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 * Class representing a panel to manage players in the game. This panel allows
 * input of names and selection of options through buttons.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class PanelJugadores extends JPanel {
	/**
	 * Button to confirm the player's selection.
	 */
	private JButton btnOk;

	/**
	 * Button to return to the previous screen.
	 */
	private JButton btnBack;

	/**
	 * Button to select two players.
	 */
	private JButton btn2;

	/**
	 * Button to select three players.
	 */
	private JButton btn3;

	/**
	 * Button to select four players.
	 */
	private JButton btn4;

	/**
	 * Background image for the panel.
	 */
	private ImageIcon fondo;

	/**
	 * Text field for entering the player's name.
	 */
	private JTextField txtNombre;

	/**
	 * Constructor that initializes the players panel. Configures size, layout, and
	 * adds the necessary components.
	 */
	public PanelJugadores() {
		setSize(1391, 839);
		setLayout(null);
		setVisible(true);
		setBackground(Color.white);

		fondo = new ImageIcon("resources/images/opciones/2.png");

		txtNombre = new CenteredRoundedTextField(20);
		txtNombre.setBounds(500, 220, 400, 60);
		txtNombre.setFont(new Font("ARIAL", Font.BOLD, 30));
		add(txtNombre);

		btnBack = generarBoton("VOLVER", 70, 710, 170, 90, "");

		add(btnBack);

		btn2 = generarBoton("2 JUGADORES", 120, 482, 210, 205, "");
		btn3 = generarBoton("3 JUGADORES", 570, 480, 210, 205, "");
		btn4 = generarBoton("4 JUGADORES", 1015, 480, 210, 205, "");

		add(btn2);
		add(btn3);
		add(btn4);

		limitarCaracter(txtNombre, 20);
		letras(txtNombre);

		repaint();
	}

	/**
	 * Draws the panel background. This method is called whenever the panel needs to
	 * be repainted.
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
	 * Clears the text content of the input field `txtNombre`. This method resets
	 * the text field to an empty string, ensuring no residual data remains.
	 */
	public void limpiarPanelTexto() {
		txtNombre.setText("");
	}

	/**
	 * Generates a button with the specified properties.
	 *
	 * @param texto The text displayed on the button.
	 * @param x     The x-axis position of the button.
	 * @param y     The y-axis position of the button.
	 * @param ancho The width of the button.
	 * @param alto  The height of the button.
	 * @param url   The URL of the image (not used in this method).
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
	 * Adds a listener to the JTextField to restrict input to letters and spaces.
	 *
	 * @param a The JTextField to add the listener to.
	 */
	public static void letras(JTextField a) {
		a.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!Character.isLetter(c) && c != ' ') {
					e.consume();
				}
			}
		});
	}

	/**
	 * Limits the number of characters that can be entered in the JTextField.
	 *
	 * @param textField The JTextField to apply the limit to.
	 * @param limit     The maximum number of characters allowed.
	 */
	public static void limitarCaracter(JTextField textField, int limit) {
		AbstractDocument doc = (AbstractDocument) textField.getDocument();
		doc.setDocumentFilter(new DocumentFilter() {
			public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
					throws BadLocationException {
				if (fb.getDocument().getLength() + text.length() - length > limit) {
					Toolkit.getDefaultToolkit().beep();
					return;
				}
				super.replace(fb, offset, length, text, attrs);
			}
		});
	}

	/**
	 * Gets the "Ok" button.
	 * 
	 * @return The "Ok" button.
	 */
	public JButton getBtnOk() {
		return btnOk;
	}

	/**
	 * Sets the "Ok" button.
	 * 
	 * @param btnOk The "Ok" button to set.
	 */
	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
	}

	/**
	 * Gets the back button.
	 * 
	 * @return The back button.
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * Sets the back button.
	 * 
	 * @param btnBack The back button to set.
	 */
	public void setBtnBack(JButton btnBack) {
		this.btnBack = btnBack;
	}

	/**
	 * Gets the second button.
	 * 
	 * @return The second button.
	 */
	public JButton getBtn2() {
		return btn2;
	}

	/**
	 * Sets the second button.
	 * 
	 * @param btn2 The second button to set.
	 */
	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}

	/**
	 * Gets the third button.
	 * 
	 * @return The third button.
	 */
	public JButton getBtn3() {
		return btn3;
	}

	/**
	 * Sets the third button.
	 * 
	 * @param btn3 The third button to set.
	 */
	public void setBtn3(JButton btn3) {
		this.btn3 = btn3;
	}

	/**
	 * Gets the fourth button.
	 * 
	 * @return The fourth button.
	 */
	public JButton getBtn4() {
		return btn4;
	}

	/**
	 * Sets the fourth button.
	 * 
	 * @param btn4 The fourth button to set.
	 */
	public void setBtn4(JButton btn4) {
		this.btn4 = btn4;
	}

	/**
	 * Gets the background image.
	 * 
	 * @return The background image.
	 */
	public ImageIcon getFondo() {
		return fondo;
	}

	/**
	 * Sets the background image.
	 * 
	 * @param fondo The background image to set.
	 */
	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	/**
	 * Gets the text field for the player's name.
	 * 
	 * @return The text field for the player's name.
	 */
	public JTextField getTxtNombre() {
		return txtNombre;
	}

	/**
	 * Sets the text field for the player's name.
	 * 
	 * @param txtNombre The text field for the player's name to set.
	 */
	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

}
