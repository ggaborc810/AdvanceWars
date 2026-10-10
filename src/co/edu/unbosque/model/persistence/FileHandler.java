package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import co.edu.unbosque.view.MensajeEmergente;

/**
 * The FileHandler class provides static methods to handle creating, read and
 * write files in the application, including serializable files. serializable.
 * 
 * Main methods:
 * 
 * - {@link #verificarFolderDeDatos()}: Verifies and creates the “data” folder
 * if it does not . exists. -
 * {@link #abrirYEscribirEnSerializable(String, Object)}: Writes a serializable
 * object in a file. - {@link #abrirYLeerArchivo(String)}: Reads the contents of
 * a text file. - {@link #abrirLeerSerializado(String)}: Reads a serializable
 * object from a file. - {@link #abrirYEscribirArchivo(String, String)}: Writes
 * content to a. text file.
 * 
 * This class also uses the {@link MensajeEmergente} class to display. error
 * messages or information in case a problem occurs during file operations.
 * 
 * @author Bustamante Castellanos Caren Sofia
 * @author Hospital Herrera Dylan Mathyus
 * @author Ramirez Chacon Alejandra Valenttina
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class FileHandler {

	/**
	 * The {@code FileInputStream} used to read bytes from a file.
	 * 
	 * This stream is used in conjunction with an {@link ObjectInputStream} to read
	 * serialized objects from a file.
	 */
	private static FileInputStream fis;

	/**
	 * The {@code ObjectInputStream} used to deserialize objects from a file.
	 * 
	 * This stream reads the serialized object data from the corresponding
	 * {@link FileInputStream}.
	 */
	private static ObjectInputStream ois;

	/**
	 * The {@code FileOutputStream} used to write bytes to a file.
	 * 
	 * This stream is used in conjunction with an {@link ObjectOutputStream} to
	 * write serialized objects to a file.
	 */
	private static FileOutputStream fos;

	/**
	 * The {@code ObjectOutputStream} used to serialize objects to a file.
	 * 
	 * This stream writes the object data to the corresponding
	 * {@link FileOutputStream}.
	 */
	private static ObjectOutputStream ous;

	/**
	 * The {@code File} object representing the file to be read or written.
	 * 
	 * This object is used to specify the file path and to create input and output
	 * streams.
	 */
	private static File archivo;

	/**
	 * The {@code Scanner} used for reading from the file.
	 * 
	 * This scanner can be used to read text from the file line by line or token by
	 * token.
	 */
	private static Scanner lectorDeArchivo;

	/**
	 * The {@code PrintWriter} used for writing formatted text to the file.
	 * 
	 * This writer can be used to write text data easily, including appending new
	 * lines and formatting.
	 */
	private static PrintWriter escritorDeArchivo;

	/**
	 * Represents the audio clip used for playback. This Clip object is utilized to
	 * handle audio file playback operations such as play, stop, and loop.
	 */
	private Clip clip;

	/**
	 * Check if the “data” folder exists in the file system. If it does not exist,
	 * create it.
	 */
	public static void verificarFolderDeDatos() {
		archivo = new File("data");

		if (archivo.mkdir()) {
			MensajeEmergente.mostrarMensaje("Carpeta creada por primera vez en " + archivo.toURI());
		}
	}

	/**
	 * Writes a serializable object to a file.
	 * 
	 * @param url       The location of the file where the object will be stored.
	 * @param contenido The object to be written to the file.
	 */
	public static void abrirYEscribirEnSerializable(String url, Object contenido) {

		archivo = new File(url);

		try {
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fos = new FileOutputStream(archivo);
			ous = new ObjectOutputStream(fos);
			ous.writeObject(contenido);
			fos.close();
			ous.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo. ");
		}
	}

	/**
	 * Reads the contents of a text file.
	 * 
	 * @param url The location of the file to read.
	 * @return The contents of the file in string format.
	 */
	public static String abrirYLeerArchivo(String url) {
		String contenido = "";
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			lectorDeArchivo = new Scanner(archivo);

			while (lectorDeArchivo.hasNext()) {
				contenido += lectorDeArchivo.nextLine() + "\n";

			}
		} catch (IOException e2) {
			e2.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo. ");
		}
		lectorDeArchivo.close();
		return contenido;
	}

	/**
	 * Reads a serializable object from a file.
	 * 
	 * @param url The location of the file to read.
	 * @return The object read from the file.
	 */
	public static Object abrirLeerSerializado(String url) {
		Object contenido = null;
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}
			fis = new FileInputStream(archivo);
			ois = new ObjectInputStream(fis);

			contenido = ois.readObject();
			fis.close();
			ois.close();
		} catch (IOException e3) {
			e3.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo. ");
		} catch (ClassNotFoundException e4) {
			e4.printStackTrace();
		}

		return contenido;
	}

	/**
	 * Writes text content to a file.
	 * 
	 * @param url     The location of the file where the content will be stored.
	 * @param content The string content to be written to the file.
	 */
	public static void abrirYEscribirArchivo(String url, String contenido) {
		try {
			archivo = new File(url);
			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			escritorDeArchivo = new PrintWriter(archivo);
			escritorDeArchivo.print(contenido);
		} catch (FileNotFoundException e5) {
			e5.printStackTrace();
			MensajeEmergente.mostrarMensaje("Archivo no ha sido encontrado. ");
		} catch (IOException e6) {
			e6.printStackTrace();
			MensajeEmergente.mostrarMensaje("No fue posible crear un archivo. ");
		}
		escritorDeArchivo.close();
	}

	/**
	 * Plays an audio file located at the specified file path. This method attempts
	 * to load and play the audio file in a continuous loop. If the file does not
	 * exist or an error occurs while loading the audio, the method logs the
	 * exceptions.
	 *
	 * @param rutaArchivo the file path of the audio file to be played
	 */
	public void reproducir(String rutaArchivo) {
		try {
			File archivoAudio = new File(rutaArchivo);
			if (!archivoAudio.exists()) {
				return;
			}
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoAudio);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}