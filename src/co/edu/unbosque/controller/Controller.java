package co.edu.unbosque.controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.model.PokemonDAO;

public class Controller {

 private PokemonDAO dao;


	 private  ServerSocket servidor;
	 
	public Controller() {
	dao = new PokemonDAO();

	   

	 try {
			servidor = new ServerSocket(12345);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void iniciar() throws IOException {
		leer_json();
	
		

		
		   System.out.println("Porta 12345 aberta!");

	        // Aguarda alguém se conectar. A execução do servidor
	        // fica bloqueada na chamada do método accept da classe
	        // ServerSocket. Quando alguém se conectar ao servidor, o
	        // método desbloqueia e retorna com um objeto da classe
	        // Socket, que é uma porta da comunicação.
	 

	        while (true) {
	            Socket cliente = (Socket) servidor.accept();
	            // Cria uma thread do servidor para tratar a conexão
	            

	        	 Server  tratamento = new Server((java.net.Socket) cliente,dao.getLista());
	             Thread t = new Thread(tratamento);
	            // Inicia a thread para o cliente conectado
//	            tratamento.code();
	        
	
	
	            // Inicia a thread para o cliente conectado
	            t.start();
	            
	            System.out.println("chao");
	        }
		
	}

	public void leer_json() {

		JSONParser parser = new JSONParser();
		try {

			Object obj = parser.parse(new FileReader("pokemones.json"));
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray array = (JSONArray) jsonObject.get("Pokemones");

			for (int i = 0; i < array.size(); i++) {
				JSONObject jsonObject1 = (JSONObject) array.get(i);
				int a1 = Integer.parseInt("" + jsonObject1.get("Id"));
				String a2 = "" + jsonObject1.get("Nombre");
				int a3 = Integer.parseInt("" + jsonObject1.get("Id General"));
				String a4 = "" + jsonObject1.get("Tipo");
				String a5 = "" + jsonObject1.get("PS");
				String a6 = "" + jsonObject1.get("Ataque");
				String a7 = "" + jsonObject1.get("Defensa");
				String a8 = "" + jsonObject1.get("Ataque Especial");
				String a9 = "" + jsonObject1.get("Defensa Especial");
				String a10 = "" + jsonObject1.get("Velocidad");
							String a11 = "" ;
							String a12 = "" ;
							int a13 = 0;
							
							dao.guardar(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
							
			
			}

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ParseException e) {
		}
	}
}
