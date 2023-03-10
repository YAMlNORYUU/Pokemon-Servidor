package co.edu.unbosque.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import co.edu.unbosque.model.PokemonDTO;

/**
 * Clase que se encarga de controlar la logica del programa
 * 
 * @author Jose
 * @author Kevin
 * @author Nicolás
 */

public class Server implements Runnable {
	/**
	 * Atributo tipo Socket cliente
	 */
	public Socket cliente;
	/**
	 * Atributo de tipo ArrayList que guarda los pokemones del usuario
	 */
	private ArrayList<PokemonDTO> lista;

	/**
	 * Metodo constructor <b>pre</b> cliente,lista <br>
	 * <b>post</b> se instancian los atributos <br>
	 * 
	 * @param cliente El socket que se va a usar
	 * @param lista   La lista de donde se va a usar
	 * 
	 */
	public Server(Socket cliente, ArrayList<PokemonDTO> lista) {
		super();
		this.cliente = cliente;
		this.lista = lista;
	}

	/**
	 * Metodo Correr la informacion del servidor al cliente para asi generar la conexion
	 */
	@Override
	public void run() {
		System.out.println("Nueva conexion ip " + this.cliente.getInetAddress().getHostAddress());
//      System.out.println(con.getCiudades().get(0));

		Random rnd = new Random();

		int aleatorio = rnd.nextInt(100);

		int operacao;

		try {

			ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
			ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

			operacao = dados.readInt();

			if (operacao == 1) {
				System.out.println("Opcion de los 6");
				resultado.writeInt(lista.get(aleatorio).getId());
				resultado.writeUTF(lista.get(aleatorio).getNombre());
				resultado.writeInt(lista.get(aleatorio).getId_general());
				resultado.writeUTF(lista.get(aleatorio).getTipo());
				resultado.writeUTF(lista.get(aleatorio).getPs());
				resultado.writeUTF(lista.get(aleatorio).getAtaque());
				resultado.writeUTF(lista.get(aleatorio).getDefensa());
				resultado.writeUTF(lista.get(aleatorio).getAtaque_especial());
				resultado.writeUTF(lista.get(aleatorio).getDefensa_especial());
				resultado.writeUTF(lista.get(aleatorio).getVelocidad());
				resultado.writeUTF(lista.get(aleatorio).getMote());
				resultado.writeUTF(lista.get(aleatorio).getMovimientos());
				resultado.writeInt(lista.get(aleatorio).getNivel());

				resultado.flush();

			}
			if (operacao == 2) {

				int aux = dados.readInt();
				int id = aux - 1;
				resultado.writeInt(lista.get(id).getId());
				resultado.writeUTF(lista.get(id).getNombre());
				resultado.writeInt(lista.get(id).getId_general());
				resultado.writeUTF(lista.get(id).getTipo());
				resultado.writeUTF(lista.get(id).getPs());
				resultado.writeUTF(lista.get(id).getAtaque());
				resultado.writeUTF(lista.get(id).getDefensa());
				resultado.writeUTF(lista.get(id).getAtaque_especial());
				resultado.writeUTF(lista.get(id).getDefensa_especial());
				resultado.writeUTF(lista.get(id).getVelocidad());
				resultado.writeUTF(lista.get(id).getMote());
				resultado.writeUTF(lista.get(id).getMovimientos());
				resultado.writeInt(lista.get(id).getNivel());

			} else {

			}

			resultado.close();
			dados.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}

	}

}