package Models;

public class anotacionModel {
	int idAnotacion;
	String tipo;
	String texto;
	Byte[] archivo;
	String alumno;
	String fecha;
	String hora;
	
	public anotacionModel(int pidAnotacion, String ptipo, String ptexto, Byte[] parchivo, String palumno, String pfecha,
			String phora) {
		super();
		idAnotacion = pidAnotacion;
		tipo = ptipo;
		texto = ptexto;
		archivo = parchivo;
		alumno = palumno;
		fecha = pfecha;
		hora = phora;
	}
	
	public anotacionModel(int pidAnotacion, String ptipo, String ptexto, String palumno, String pfecha,
			String phora) {
		super();
		idAnotacion = pidAnotacion;
		tipo = ptipo;
		texto = ptexto;
		alumno = palumno;
		fecha = pfecha;
		hora = phora;
	}

	public int getIdAnotacion() {
		return idAnotacion;
	}

	public String getTipo() {
		return tipo;
	}

	public String getTexto() {
		return texto;
	}

	public Byte[] getArchivo() {
		return archivo;
	}

	public String getAlumno() {
		return alumno;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}
	
	
}
