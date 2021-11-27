package AppServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class anotacionAppService {
	Connection conexion;
	PreparedStatement ps;
	ResultSet cargaAnotacion;

	boolean estadoCarga;
	
	int idAnotacion;
	String tipo;
	String texto;
	String alumno;
	String fecha;
	String hora;
	String codigoProfesor;
	
	final String URL = "jdbc:postgresql://localhost/tfg";
	final String USER = "postgres";
	final String PASSW = "ROOT";
	
	public anotacionAppService() {

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
	
	public boolean consultarSiguiente() {
		estadoCarga = false;
		try {
			estadoCarga = cargaAnotacion.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoCarga;
	}
	
	public int consultarUltimoId() {
		int ultimoId = 0;
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT \"idAnotacion\" FROM tutorias.anotacion order by \"idAnotacion\" desc limit 1");
			ResultSet e = ps.executeQuery();
			e.next();
			ultimoId = e.getInt("idAnotacion") + 1;
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ultimoId;
	}
	
	public void crearTutoria(int idAnotacion, String tipo, String texto, String alumno, String fecha, String hora, String codigoProfesor) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("INSERT INTO tutorias.anotacion (\"idAnotacion\", tipo, texto, alumno, fecha, hora, \"codigoProfesor\") VALUES (?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, idAnotacion);
			ps.setString(2, tipo);
			ps.setString(3, texto);
			ps.setString(4, alumno);
			ps.setString(5, fecha);
			ps.setString(6, hora);
			ps.setString(7, codigoProfesor);
			ps.execute();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getIdAnotacion() {
		idAnotacion = 0;
		try {
			idAnotacion = cargaAnotacion.getInt("idAnotacion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idAnotacion;
	}

	public String getTipo() {
		tipo = "";
		try {
			tipo = cargaAnotacion.getString("tipo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tipo;
	}

	public String getTexto() {
		texto = "";
		try {
			texto = cargaAnotacion.getString("texto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}

	public String getAlumno() {
		alumno = "";
		try {
			alumno = cargaAnotacion.getString("alumno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumno;
	}

	public String getFecha() {
		fecha = "";
		try {
			fecha = cargaAnotacion.getString("fecha");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fecha;
	}

	public String getHora() {
		hora = "";
		try {
			hora = cargaAnotacion.getString("hora");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hora;
	}
	
	public String getcodigoProfesor() {
		codigoProfesor = "";
		try {
			codigoProfesor = cargaAnotacion.getString("codigoProfesor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codigoProfesor;
	}
	
	
}
