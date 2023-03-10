package co.edu.unbosque.model;


import java.util.ArrayList;
/**
 * Clase PokemonDAO donde se encuentra el CRUD
 * 
 * @author NICOLAS
 * @author JOSE
 * @author KEVIN
 */
public class PokemonDAO {
	/**
	 * Atributo de tipo ArrayList que guarda los pokemones de la pc
	 */
	private ArrayList<PokemonDTO> lista;

	/**
     * Metodo constructor
     * <b>pre</b> La existencia de los atributos <br>
     * <b>post</b> Atributos inicilizados y/o creados<br>
     */
	public PokemonDAO() {
		lista = new ArrayList<PokemonDTO>();
	}
	/**
	 * Metodo para guardar un nuevo pokemon <b> pre </b> <b> post </b> El nuevo
	 * pokemon es agregado a la lista del ususario<br>
	 * 
	 * @param id               El id a agregar
	 * @param nombre           El nombre a agregar
	 * @param id_general       la id_general a agregar
	 * @param tipo             El tipo a agregar
	 * @param ps               La ps a agregar
	 * @param ataque           La ataque a agregar
	 * @param defensa          La defensa a agregar
	 * @param ataque_especial  La ataque_especial a agregar
	 * @param defensa_especial La defensa_especial a agregar
	 * @param velocidad        La velocidad a agregar
	 * @param mote             La mote a agregar
	 * @param movimientos      La movimientos a agregar
	 * @param nivel            La nivel a agregar
	 *
	 */
	public void guardar(int id, String nombre, int id_general, String tipo, String ps, String ataque, String defensa,
			String ataque_especial, String defensa_especial, String velocidad, String mote, String movimientos,
			int nivel) {

		PokemonDTO a = new PokemonDTO( id,  nombre,  id_general,  tipo,  ps,  ataque,  defensa,
				 ataque_especial,  defensa_especial,  velocidad,  mote,  movimientos,
				 nivel);
		lista.add(a);

	}
	/**
	 * Metodo para eliminar por la posicion <b> pre </b> La existencia del pokemon
	 * <br>
	 * <b> post </b> El pokemon es eliminado <br>
	 * 
	 * @param pos La posicion por el que se va a buscar el pokemon
	 * @return Un valor de verdad que indica si la posicion fue eliminado
	 */
	public boolean eliminar(int pos) {
		try {
			lista.remove(pos);
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * Metodo para modificar por la posicion <b> pre </b> La existencia del pokemon
	 * <br>
	 * <b> post </b> El nombre del pokemon es actuzalizado <br>
	 * 
	 * @param pos La posicion del pokemon en la lista
	 * @param nom_nuevo El nuevo nombre del pokemon
	 * @return Un valor de verdad que indica si la posicion fue eliminado
	 */
	public boolean actualizarNombre(int pos, String nom_nuevo) {
		try {
			lista.get(pos).setNombre(nom_nuevo);
			;
			return true;

		} catch (Exception e) {
			return false;
		}
	}
	/**
	 * Metodo para mostrar los pokemones del usuario <b> pre </b> La existencia del
	 * archivo <br>
	 * <b> post </b> Muestra los pokemones del usuario <br>
	 * 
	 */
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
	/**
	 * @return the lista
	 */
	public ArrayList<PokemonDTO> getLista() {
		return lista;
	}
	/**
	 * @param lista the lista to set
	 */
	public void setLista(ArrayList<PokemonDTO> lista) {
		this.lista = lista;
	}

	

}
