package pancakes;

public class pancake {

	private String texto;
	private int id;
	private int idPadre;
	
	public pancake(String texto, int id, int idPadre) {
		this.texto = texto;
		this.id = id;
		this.idPadre = idPadre;
	}

	public String getTexto() {
		return texto;
	}

	public int getId() {
		return id;
	}

	public int getIdPadre() {
		return idPadre;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}
	
	
}
