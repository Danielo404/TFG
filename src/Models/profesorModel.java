package Models;

public class profesorModel {
	String nombre;
	String apellidos;
	String email;
	String password;
	String codigo;
	String dni;
	boolean tutoriza;
	String grupoTutoriza;
	
	public profesorModel(String pnombre, String papellidos, String pemail, String ppassword, String pcodigo, String pdni) {
		super();
		nombre = pnombre;
		apellidos = papellidos;
		email = pemail;
		password = ppassword;
		codigo = pcodigo;
		dni = pdni;
	}
	
	public profesorModel(String pnombre, String papellidos, String pemail, String ppassword, String pcodigo, String pdni, boolean pTutoriza, String pGrupoTutoriza) {
		super();
		nombre = pnombre;
		apellidos = papellidos;
		email = pemail;
		password = ppassword;
		codigo = pcodigo;
		dni = pdni;
		tutoriza = pTutoriza;
		grupoTutoriza = pGrupoTutoriza;
	}
	
	
	public profesorModel(String nombre, String apellidos, String codigo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getDni() {
		return dni;
	}
	public boolean isTutoriza() {
		return tutoriza;
	}
	public String getGrupoTutoriza() {
		return grupoTutoriza;
	}
	
	
}
