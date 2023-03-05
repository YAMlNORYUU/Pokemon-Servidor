import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Controller {

 private PokemonDAO dao;
	public Controller() {
	dao = new PokemonDAO();
	}

	public void iniciar() {
		leer_json();
		System.out.println(dao.getLista().get(0).getNombre());
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
