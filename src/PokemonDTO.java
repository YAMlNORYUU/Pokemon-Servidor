
/**
 * 
 * @author KEVIN
 * @author ANGEL
 * @author SANTIAGO
 * @author SHARICK
 * 
 * Aquí asignamos los atributos de un pokemon e inicializamos y damos getters y setters.
 *
 */
public class  PokemonDTO {
	private int id;
	private String nombre;
	private int id_general;
	private String tipo;
	private String ps;
	private String ataque;
	private String defensa;
	private String ataque_especial;
	private String defensa_especial;
	private String velocidad;
	private String mote;
	private String movimientos;
	private int nivel;

	public PokemonDTO() {
		// TODO Auto-generated constructor stub
	}
	



	public PokemonDTO(int id, String nombre, int id_general, String tipo, String ps, String ataque, String defensa,
			String ataque_especial, String defensa_especial, String velocidad, String mote, String movimientos,
			int nivel) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.id_general = id_general;
		this.tipo = tipo;
		this.ps = ps;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataque_especial = ataque_especial;
		this.defensa_especial = defensa_especial;
		this.velocidad = velocidad;
		this.mote = mote;
		this.movimientos = movimientos;
		this.nivel = nivel;
	}




	public String getMote() {
		return mote;
	}



	public void setMote(String mote) {
		this.mote = mote;
	}



	public String getMovimientos() {
		return movimientos;
	}



	public void setMovimientos(String movimientos) {
		this.movimientos = movimientos;
	}



	public int getNivel() {
		return nivel;
	}



	public void setNivel(int nivel) {
		this.nivel = nivel;
	}







	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId_general() {
		return id_general;
	}

	public void setId_general(int id_general) {
		this.id_general = id_general;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPs() {
		return ps;
	}

	public void setPs(String ps) {
		this.ps = ps;
	}

	public String getAtaque() {
		return ataque;
	}

	public void setAtaque(String ataque) {
		this.ataque = ataque;
	}

	public String getDefensa() {
		return defensa;
	}

	public void setDefensa(String defensa) {
		this.defensa = defensa;
	}

	public String getAtaque_especial() {
		return ataque_especial;
	}

	public void setAtaque_especial(String ataque_especial) {
		this.ataque_especial = ataque_especial;
	}

	public String getDefensa_especial() {
		return defensa_especial;
	}

	public void setDefensa_especial(String defensa_especial) {
		this.defensa_especial = defensa_especial;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

}
