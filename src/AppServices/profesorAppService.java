package AppServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class profesorAppService {
	Connection conexion;
	PreparedStatement ps;
	ResultSet cargaProfesor;
	
	boolean estadoCarga;
	
	String nombre;
	String apellidos;
	String email;
	String password;
	String codigo;
	String dni;
	boolean tutoriza;
	String grupoTutoriza;
	
	final String URL = "jdbc:postgresql://localhost/tfg";
	final String USER = "postgres";
	final String PASSW = "ROOT";
	
	public profesorAppService() {

	}
	
	public void establecerConexion() {
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSW);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion() {
		try {
			conexion.close();
		} catch (Exception e) {

		}
	}
	
	public boolean iniciarSesion(String email, String password) {
		boolean estadoSesion = false;
		try {
			establecerConexion();
			ps = conexion.prepareStatement("select * from tutorias.profesor WHERE email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			cargaProfesor = ps.executeQuery();
			estadoSesion = cargaProfesor.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoSesion;
	}
	
	public boolean comprobarCodigo(String codigo) {
		boolean estadoCodigo = false;
		try {
			establecerConexion();
			ps = conexion.prepareStatement("select * from tutorias.profesor WHERE codigo = ?");
			ps.setString(1, codigo);
			cargaProfesor = ps.executeQuery();
			estadoCodigo = cargaProfesor.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoCodigo;
	}
	
	public void consultarProfesor(String codigo) {
		
		try {
			establecerConexion();
			ps = conexion.prepareStatement("select * from tutorias.profesor WHERE codigo = ?");
			ps.setString(1, codigo);
			cargaProfesor = ps.executeQuery();
			cargaProfesor.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
public void cambiarContrasena(String codigo, String password) {
		
		try {
			establecerConexion();
			ps = conexion.prepareStatement("UPDATE tutorias.profesor SET password = ? WHERE codigo = ?");
			ps.setString(1, password);
			ps.setString(2, codigo);
			ps.execute();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void darDeAlta(String nombre, String apellidos, String codigo, String dni, String email, String password) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("INSERT INTO tutorias.profesor (nombre, apellidos, email, password, codigo, dni) VALUES (?, ?, ?, ?, ?, ?)");
			ps.setString(1, nombre);
			ps.setString(2, apellidos);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, codigo);
			ps.setString(6, dni);
			
			ps.execute();
			
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean consultarSiguiente() {
		estadoCarga = false;
		try {
			estadoCarga = cargaProfesor.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoCarga;
	}

	public String getNombre() {
		nombre = "";
		try {
			nombre = cargaProfesor.getString("nombre");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getApellidos() {
		apellidos = "";
		try {
			apellidos = cargaProfesor.getString("apellidos");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apellidos;
	}

	public String getEmail() {
		email = "";
		try {
			email = cargaProfesor.getString("email");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}

	public String getPassword() {
		password = "";
		try {
			password = cargaProfesor.getString("password");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	public String getCodigo() {
		codigo = "";
		try {
			codigo = cargaProfesor.getString("codigo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codigo;
	}

	public String getDni() {
		dni = "";
		try {
			dni = cargaProfesor.getString("dni");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dni;
	}
	public boolean isTutoriza() {
		tutoriza = false;
		try {
			tutoriza = cargaProfesor.getBoolean("tutoriza");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tutoriza;
	}
	
	public String getGrupoTutoriza() {
		grupoTutoriza = "";
		try {
			grupoTutoriza = cargaProfesor.getString("grupoTutoriza");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grupoTutoriza;
	}
	
	
}
