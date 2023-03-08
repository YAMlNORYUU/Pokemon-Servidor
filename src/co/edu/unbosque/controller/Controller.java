package co.edu.unbosque.controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import co.edu.unbosque.model.PokemonDAO;

public class Controller {

 private PokemonDAO dao;
 String[] arr = {"Ala de acero", "Cola férrea", "Garra metal", "Danza lluvia", "Pulpocañón", "Torbellino", "Cortefuria", "Megacuerno", "Telaraña", "Ciclón", "Dragoaliento", "Enfado", "Chispa", "Electrocañón", "Bola sombra", "Mismo destino", "Pesadilla", "Rencor", "Día soleado", "Fuego sagrado", "Rueda fuego", "Nieve polvo", "Viento hielo", "Detección", "Golpe kárate (2ª gen.)", "Golpe roca", "Inversión", "Puño dinámico", "Tajo cruzado", "Tiro vital"};

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
	public String movimientos() {
		String aux = "";
		for (int i = 0; i < 4; i++) {
			
			  Random rand = new Random();

		        // gera um número aleatório entre 1 e 19
		        int randomNumber = rand.nextInt(19) + 1;
		       aux += arr[randomNumber]+"  ";
		}
		
		return aux;
	}

	public void iniciar() throws IOException {
		leer_json();
	
		

		
		   System.out.println("Puerto 12345");

	   
	 

	        while (true) {
	            Socket cliente = (Socket) servidor.accept();
	       
	            

	        	 Server  tratamento = new Server((java.net.Socket) cliente,dao.getLista());
	             Thread t = new Thread(tratamento);
	            // Inicia a thread para o cliente conectado
//	            tratamento.code();
	        
	
	
	          
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
				
				 Random rand = new Random();

			        // gera um número aleatório entre 1 e 100
			        int randomNumber = rand.nextInt(100) + 1;
			        
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
							String a12 = movimientos() ;
							int a13 = randomNumber;
							
							dao.guardar(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
							
			
			}

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ParseException e) {
		}
	}
}
