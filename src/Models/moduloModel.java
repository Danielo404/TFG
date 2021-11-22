package Models;

public class moduloModel {
	int id;
	String nombre;
	int nHoras;
	String siglas;
	
	
	public moduloModel(int pid, String pnombre, int pnHoras, String psiglas) {
		super();
		id = pid;
		nombre = pnombre;
		nHoras = pnHoras;
		siglas = psiglas;
	}
	
	


	public moduloModel(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}




	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public int getnHoras() {
		return nHoras;
	}


	public String getSiglas() {
		return siglas;
	}
	
	
}
