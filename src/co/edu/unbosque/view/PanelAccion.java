package co.edu.unbosque.view;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Class representing an action panel that contains buttons for game actions.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
public class PanelAccion extends JPanel {
	/**
	 * The background image of the panel.
	 */
	private ImageIcon fondo;

	/**
	 * The button used to move in the game.
	 */
	private JButton btnMove;

	/**
	 * The button used to shoot in the game.
	 */
	private JButton btnShoot;

	/**
	 * The button used to activate skills in the game.
	 */
	private JButton btnSkills;
	/**
	 * JButton used to display information to the user. This button can be
	 * configured with an action listener to handle specific events when clicked.
	 */
	private JButton btnInfo;

	/**
	 * Constructor for the PanelAccion class. Initializes the panel, sets its size,
	 * layout, and creates the action buttons.
	 */
	public PanelAccion() {
		setSize(300, 500);
		setLayout(null);
		fondo = new ImageIcon("resources/images/opciones/6.png");
		btnMove = new JButton();
		btnMove.setBounds(90, 60, 140, 60);
		btnMove.setOpaque(false);
		btnMove.setContentAreaFilled(false);
		btnMove.setBorderPainted(false);

		btnShoot = new JButton();
		btnShoot.setBounds(75, 180, 185, 60);
		btnShoot.setOpaque(false);
		btnShoot.setContentAreaFilled(false);
		btnShoot.setBorderPainted(false);

		btnSkills = new JButton();
		btnSkills.setBounds(70, 302, 195, 60);
		btnSkills.setOpaque(false);
		btnSkills.setContentAreaFilled(false);
		btnSkills.setBorderPainted(false);

		btnInfo = new JButton();
		btnInfo.setBounds(45, 415, 250, 55);
		btnInfo.setOpaque(false);
		btnInfo.setContentAreaFilled(false);
		btnInfo.setBorderPainted(false);

		add(btnMove);
		add(btnShoot);
		add(btnSkills);
		add(btnInfo);
	}

	/**
	 * Paints the background of the panel.
	 *
	 * @param g The Graphics object used to draw on the panel.
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
	}

	/**
	 * Gets the move button.
	 *
	 * @return The move button.
	 */
	public JButton getBtnMove() {
		return btnMove;
	}

	/**
	 * Sets the move button.
	 *
	 * @param btnMove The move button.
	 */
	public void setBtnMove(JButton btnMove) {
		this.btnMove = btnMove;
	}

	/**
	 * Gets the shoot button.
	 *
	 * @return The shoot button.
	 */
	public JButton getBtnShoot() {
		return btnShoot;
	}

	/**
	 * Sets the shoot button.
	 *
	 * @param btnShoot The shoot button.
	 */
	public void setBtnShoot(JButton btnShoot) {
		this.btnShoot = btnShoot;
	}

	/**
	 * Gets the skills button.
	 *
	 * @return The skills button.
	 */
	public JButton getBtnSkills() {
		return btnSkills;
	}

	/**
	 * Sets the skills button.
	 *
	 * @param btnSkills The skills button.
	 */
	public void setBtnSkills(JButton btnSkills) {
		this.btnSkills = btnSkills;
	}

//Getters y Setters
	public ImageIcon getFondo() {
		return fondo;
	}

	public void setFondo(ImageIcon fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnInfo() {
		return btnInfo;
	}

	public void setBtnInfo(JButton btnInfo) {
		this.btnInfo = btnInfo;
	}

}
