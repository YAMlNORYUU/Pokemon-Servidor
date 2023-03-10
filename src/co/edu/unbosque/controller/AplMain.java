package co.edu.unbosque.controller;

import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Clase main del proyecto.
 * 
 * @author Jose
 * @author Kevin
 * @author Nicolás
 */
public class AplMain {
	/**
	 * Metodo main del proyecto.
	 * 
	 * @param args para el metodo main
	 * @throws IOException Excepcion que hace que no pare el programa
	 */
	public static void main(String[] args) throws IOException {
		Controller c = new Controller();
		c.iniciar();
	}
}
