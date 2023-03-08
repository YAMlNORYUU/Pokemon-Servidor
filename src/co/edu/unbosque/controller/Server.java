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

public class Server implements Runnable {
    public Socket cliente;
   private  ArrayList<PokemonDTO> lista;


    public Server(Socket cliente, ArrayList<PokemonDTO> lista) {
	super();
	this.cliente = cliente;
	this.lista = lista;
}

	@Override
	public void run() {
        System.out.println("Nova conexao com o cliente " + this.cliente.getInetAddress().getHostAddress());
//      System.out.println(con.getCiudades().get(0));
      
      
      Random rnd = new Random();


      int aleatorio =  rnd.nextInt(100);
      
      System.out.println(lista.get(aleatorio).getNombre()+" Soy la monda asdasdas");
      double num1, num2, total = 0.0;
      int operacao;
      char opr = '\n';

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




          }if (operacao == 2) { 
        	  
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
        	
        	  
          }else {

             

          }


    

      
          
   

      
          
          resultado.close();
          dados.close();
      } catch (IOException e) {
          e.printStackTrace();
      }catch (IndexOutOfBoundsException e) {
          e.printStackTrace();
      }
		
	}



}