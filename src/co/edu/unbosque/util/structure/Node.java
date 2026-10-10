package co.edu.unbosque.util.structure;

import java.io.Serializable;

/**
 * Class representing a node in a linked list.
 *
 * @param <E> the type of information stored in the node.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class Node<E> implements Serializable {
	/**
	 * The unique identifier for the serialized version of the class.
	 * 
	 * This field is used during the deserialization process to verify that the
	 * sender and receiver of a serialized object have loaded classes for that
	 * object that are compatible with respect to serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The information stored in the node.
	 */
	private E info;
	/**
	 * The next node in the linked list.
	 */
	private Node<E> next;

	/**
	 * Creates a new node with null information and no next node.
	 */
	public Node() {
		this(null, null);
	}

	/**
	 * Creates a new node with the specified information and the next node.
	 *
	 * @param info the value to store in the node.
	 * @param next the next node in the linked list.
	 */
	public Node(E info, Node<E> next) {
		this.info = info;
		this.next = next;
	}

	/**
	 * Creates a new node with the specified information and no next node.
	 *
	 * @param info the value to store in the node.
	 */
	public Node(E info) {
		this.info = info;
	}

	/**
	 * Gets the information stored in the node.
	 *
	 * @return the information stored in the node.
	 */
	public E getInfo() {
		return info;
	}

	/**
	 * Sets the information stored in the node.
	 *
	 * @param info the new value to store in the node.
	 */
	public void setInfo(E info) {
		this.info = info;
	}

	/**
	 * Gets the next node in the linked list.
	 *
	 * @return the next node.
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Sets the next node in the linked list.
	 *
	 * @param next the next node.
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}

	/**
	 * Returns a string representation of the information stored in the node.
	 *
	 * @return the string representation of the information, or null if the
	 *         information is null.
	 */
	@Override
	public String toString() {
		if (info != null) {
			return info.toString();
		} else {
			return null;
		}
	}

	/**
	 * Returns the UID for serialization of the class.
	 *
	 * @return the serialVersionUID of the class.
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
