package Models;

public class anotacionModel {
	int idAnotacion;
	String tipo;
	String texto;
	String alumno;
	String fecha;
	String hora;
	String codigoProfesor;
	alumnoModel _alumno;
	
	
	
	public anotacionModel(int pidAnotacion, String ptipo, String ptexto, String palumno, String pfecha,
			String phora, String pcodigoProfesor) {
		
		idAnotacion = pidAnotacion;
		tipo = ptipo;
		texto = ptexto;
		alumno = palumno;
		fecha = pfecha;
		hora = phora;
		codigoProfesor = pcodigoProfesor;
	}
	
	public anotacionModel(int pidAnotacion, String ptipo, String ptexto, String palumno, String pfecha,
			String phora, String pcodigoProfesor, alumnoModel p_alumno) {
		
		idAnotacion = pidAnotacion;
		tipo = ptipo;
		texto = ptexto;
		alumno = palumno;
		fecha = pfecha;
		hora = phora;
		codigoProfesor = pcodigoProfesor;
		_alumno = p_alumno;
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


	public String getAlumno() {
		return alumno;
	}

	public String getFecha() {
		return fecha;
	}

	public String getHora() {
		return hora;
	}
	
	public String getcodigoProfesor() {
		return codigoProfesor;
	}

	public alumnoModel get_alumno() {
		return _alumno;
	}
	
	
}
