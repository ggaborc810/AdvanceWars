/**
 * Este paquete contiene estructuras de datos utilizadas en el sistema,
 * incluyendo listas enlazadas y nodos. Estas estructuras permiten almacenar
 * y manipular colecciones de objetos de manera eficiente.
 *
 * 
 * Las clases en este paquete incluyen:
 * 
 * {@link MyLinkedList} - Una implementación de lista enlazada que permite
 *         almacenar elementos de manera dinámica.
 * {@link Node} - Representa un nodo en una lista enlazada que almacena
 *         información y una referencia al siguiente nodo.
 */
package co.edu.unbosque.util.structure;

import java.io.Serializable;

/**
 * The {@code MyLinkedList} class implements a simple linked list.
 * 
 * This list allows storing generic elements of type {@code E} and provides
 * methods for performing basic list manipulation operations such as adding,
 * removing, and searching for elements.
 *
 * @param <E> the type of elements the list will store
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class MyLinkedList<E> implements Serializable {
	/**
	 * The unique identifier for the serialized version of the class.
	 * 
	 * This field is used during the deserialization process to verify that the
	 * sender and receiver of a serialized object have loaded classes for that
	 * object that are compatible with respect to serialization.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The first node in the linked list.
	 * 
	 * This node serves as the entry point to the list. If the list is empty, this
	 * field will be {@code null}.
	 */
	protected Node<E> first;

	/**
	 * Creates an empty linked list.
	 */
	public MyLinkedList() {

		this.first = null;
	}

	/**
	 * Obtains the first node in the list.
	 * 
	 * @return the first node in the list
	 */
	public Node<E> getFirst() {
		return first;
	}

	/**
	 * Sets the first node in the list.
	 * 
	 * @param first the new first node
	 */
	public void setFirst(Node<E> first) {
		this.first = first;
	}

	/**
	 * Checks if the list is empty.
	 * 
	 * @return {@code true} if the list is empty, {@code false} otherwise
	 */
	public boolean isEmpty() {
		return (this.first == null);
	}

	/**
	 * Adds a new element to the beginning of the list.
	 * 
	 * @param info the element to be added
	 */
	public void add(E info) {
		Node<E> nuevoNode = new Node<E>(info);
		nuevoNode.setNext(this.first);
		first = nuevoNode;
	}

	/**
	 * Inserts a new element after a given node.
	 * 
	 * @param info     the element to be inserted
	 * @param previous the node after which the new node will be inserted
	 */
	public void insert(E info, Node<E> previous) {
		if (previous != null) {
			Node<E> nuevoNode = new Node<E>(info);
			nuevoNode.setNext(previous.getNext());
			previous.setNext(nuevoNode);
		}
	}

	/**
	 * Obtains the last node in the list.
	 * 
	 * @return the last node in the list
	 */
	public Node<E> getLastNode() {
		Node<E> current = this.first;
		while (current != null && current.getNext() != null) {
			current = current.getNext();
		}
		return current;
	}

	/**
	 * Adds a new element to the end of the list.
	 * 
	 * @param info the element to be added
	 */
	public void agregarFinal(E info) {
		Node<E> lastNode = getLastNode();
		if (lastNode != null) {
			insert(info, lastNode);

		} else {
			this.first = new Node<E>(info);
		}
	}

	/**
	 * Obtains the index of the first occurrence of the specified element.
	 * 
	 * @param info the element to search for
	 * @return the index of the element in the list, or -1 if not found
	 */
	public int indexOf(E info) {
		Node<E> current = this.first;
		int infoPosition = -1;

		if (!isEmpty()) {
			infoPosition = 0;
			while (current != null && !current.getInfo().equals(info)) {
				infoPosition++;
				current = current.getNext();
			}
		}
		return infoPosition;
	}

	/**
	 * Counts the number of occurrences of an element in the list.
	 * 
	 * @param info the element to count
	 * @return the number of occurrences of the element
	 */
	public int numberOfCurrences(E info) {
		int counter = 0;
		Node<E> current = this.first;
		while (current != null) {
			if (current.getInfo().equals(info)) {
				counter++;
			}
			current = current.getNext();
		}
		return counter;
	}

	/**
	 * Replaces the element at the specified index with the new element.
	 * 
	 * @param index the index of the element to replace
	 * @param info  the new element
	 */
	public void set(int index, E info) {
		int counter = 0;
		Node<E> current = this.first;
		while (counter < index) {
			current = current.getNext();
			counter++;
		}
		current.setInfo(info);
	}

	/**
	 * Extracts the first element from the list.
	 * 
	 * @return the extracted element, or {@code null} if the list is empty
	 */
	public E extract() {
		E data = null;
		if (this.first != null) {
			data = this.first.getInfo();
			this.first = this.first.getNext();
		}
		return data;
	}

	/**
	 * Deletes the element at the specified index.
	 * 
	 * @param index the index of the element to delete
	 * @return the deleted element, or {@code null} if not found
	 */
	public E delete(int index) {
		int counter = 1;
		Node<E> current = this.first;
		while (counter < index) {
			current = current.getNext();
			counter++;
		}
		if (index != 0) {
			E infoBorrada = current.getNext().getInfo();
			current.setNext(current.getNext().getNext());
			return infoBorrada;
		} else {
			E infoBorrada = this.first.getInfo();
			this.first = this.first.getNext();
			return infoBorrada;
		}
	}

	/**
	 * Deletes the first occurrence of the specified element.
	 * 
	 * @param info the element to delete
	 * @return the deleted element, or {@code null} if not found
	 */
	public E delete(E info) {
		int index = indexOf(info);
		return delete(index);
	}

	/**
	 * Extracts the specified element from the list.
	 * 
	 * @param info the element to extract
	 * @return the extracted element, or {@code null} if not found
	 */
	public E extract(E info) {
		Node<E> current = first;
		Node<E> previous = null;
		while (current != null) {
			if (current.getInfo().equals(info)) {
				if (previous == null) {
					first = current.getNext();
				} else {
					previous.setNext(current.getNext());
				}
				return current.getInfo();
			}
			previous = current;
			current = current.getNext();
		}
		return null;
	}

	/**
	 * Extracts the next node from a given previous node.
	 * 
	 * @param previous the previous node
	 * @return the extracted element, or {@code null} if not found
	 */
	public E extract(Node<E> previous) {// saca el contenido de la lista pero el previo apunta al siguiente que quitaron
										// del node y no se pierda el contenido siguiente
		E data = null;
		if (previous != null && previous.getNext() != null) {
			data = previous.getNext().getInfo();
			previous.setNext(previous.getNext().getNext());
		}
		return data;
	}

	/**
	 * Obtains the size of the list.
	 * 
	 * @return the number of elements in the list
	 */
	public int size() {
		int size = 0;
		Node<E> current = this.first;
		while (current != null) {
			size++;
			current = current.getNext();
		}
		return size;
	}

	/**
	 * Returns a string representation of the list.
	 * 
	 * @return the string representation of the list
	 */
	public String print() {
		return this.toString();
	}

	/**
	 * Obtains the node that contains the specified element.
	 * 
	 * @param info the element to search for
	 * @return the node containing the element, or {@code null} if not found
	 */
	public Node<E> get(E info) {// Va buscando el contenido en expesifico y lo copia y lo muestra
		Node<E> targetNode = null;
		Node<E> currentNode = this.first;

		while (currentNode != null && !currentNode.getInfo().equals(info)) {
			currentNode = currentNode.getNext();
		}
		if (currentNode != null) {
			targetNode = currentNode;
		}
		return targetNode;
	}

//------------------------------------------------------------------------------------------------
	/**
	 * Obtains the node at the specified position.
	 * 
	 * @param n the position of the node to return
	 * @return the node at the specified position, or {@code null} if not found
	 */
	public Node<E> get(int n) {
		Node<E> targetNode = null;
		Node<E> currentNode = this.first;
		int counter = 0;

		while (currentNode != null && counter < n) {
			currentNode = currentNode.getNext();
			counter++;
		}
		if (currentNode != null) {
			targetNode = currentNode;
		}
		return targetNode;
	}

	/**
	 * Counts the number of occurrences of an item in the list.
	 * 
	 * @param info the element to count
	 * @return the number of occurrences of the element.
	 */
	public int numberOfOccurrences(E info) {
		int counter = 0;
		Node<E> current = this.first;

		while (current != null) {
			if (current.getInfo().equals(info)) {
				counter++;
			}
			current = current.getNext();
		}
		return counter;
	}

	/**
	 * Extracts the last element from the linked list.
	 *
	 * @return the last element of the list, or null if the list is empty.
	 */
	public E extractLast() {
		E info = null;
		Node<E> current = this.first;
		int listSize = size();

		if (!isEmpty()) {
			if (listSize == 1) {
				info = current.getInfo();
				this.first = null;
			} else {
				Node<E> previousLastNode = get(listSize - 2);
				info = extract(previousLastNode);
			}
		}
		return info;
	}

	/**
	 * Prints the elements of the list starting from a specific position to the end.
	 *
	 * @param position the position from which to start printing.
	 * @return a string representing the elements of the list starting from the
	 *         specified position.
	 */
	public String print(int position) {
		StringBuilder sb = new StringBuilder();
		Node<E> current = this.first;
		int counter = 0;

		if (!isEmpty()) {
			while (current != null && counter < position) {
				current = current.getNext();
				counter++;
			}
			while (current != null) {
				sb.append(current.getInfo().toString());
				if (current.getNext() != null) {
					sb.append(" -> ");
				}
				current = current.getNext();
			}
		}
		return sb.toString();
	}

	/**
	 * Returns a string representation of all the elements in the list.
	 *
	 * @return a string that contains all the elements of the list separated by " ->
	 *         ".
	 */
	public String toString() {
		String listText = "";
		Node<E> current = this.first;

		while (current != null) {
			listText = listText + current.getInfo().toString();
			if (current.getNext() != null) {
				listText = listText + " -> ";
			}
			current = current.getNext();
		}
		return listText;
	}

	/**
	 * Returns the class's serial version UID for serialization.
	 *
	 * This UID is used during the deserialization process to verify that the sender
	 * and receiver of a serialized object have loaded classes that are compatible
	 * with respect to serialization.
	 *
	 * @return the serialVersionUID of the class.
	 */

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}