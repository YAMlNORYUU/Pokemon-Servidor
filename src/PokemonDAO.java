

import java.util.ArrayList;
/**
 * 
 * @author KEVIN
 * @author ANGEL
 * @author SANTIAGO
 * @author SHARICK
 * 
 * Empezamos declarando un array donde se guarda´ra los atributos de un objetos pokemon, ademas de crear metodos que nos ayudarán las CRUD
 *
 */
public class PokemonDAO {
	private ArrayList<PokemonDTO> lista;

	public PokemonDAO() {
		lista = new ArrayList<PokemonDTO>();
	}

	public void guardar(int id, String nombre, int id_general, String tipo, String ps, String ataque, String defensa,
			String ataque_especial, String defensa_especial, String velocidad, String mote, String movimientos,
			int nivel) {

		PokemonDTO a = new PokemonDTO( id,  nombre,  id_general,  tipo,  ps,  ataque,  defensa,
				 ataque_especial,  defensa_especial,  velocidad,  mote,  movimientos,
				 nivel);
		lista.add(a);

	}

	public boolean eliminar(int pos) {
		try {
			lista.remove(pos);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public boolean actualizarNombre(int pos, String nom_nuevo) {
		try {
			lista.get(pos).setNombre(nom_nuevo);
			;
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public void mostrarLista() {

		for (int i = 0; i < lista.size(); i++) {
			System.out.println("");
			System.out.println("ID = "+lista.get(i).getId());
			System.out.println("NOMBRE = "+lista.get(i).getNombre());
			System.out.println("ID GENERAL = "+lista.get(i).getId_general());
			System.out.println("TIPO = "+lista.get(i).getTipo());
			System.out.println("PS = "+lista.get(i).getPs());
			System.out.println("ATAQUE = "+lista.get(i).getAtaque());
			System.out.println("DEFENSA = "+lista.get(i).getDefensa());
			System.out.println("ATAQUE ESPECIAL = "+lista.get(i).getAtaque_especial());
			System.out.println("DEFENSA ESPECIAL = "+lista.get(i).getDefensa_especial());
			System.out.println("VELOCIDAD = "+lista.get(i).getVelocidad());
			System.out.println("");


		}

	}

	public ArrayList<PokemonDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<PokemonDTO> lista) {
		this.lista = lista;
	}

}
