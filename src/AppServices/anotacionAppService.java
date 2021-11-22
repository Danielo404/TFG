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

	public int getIdAnotacion() {
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
		try {
			texto = cargaAnotacion.getString("texto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}

	public String getAlumno() {
		try {
			alumno = cargaAnotacion.getString("alumno");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alumno;
	}

	public String getFecha() {
		try {
			fecha = cargaAnotacion.getString("fecha");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fecha;
	}

	public String getHora() {
		try {
			hora = cargaAnotacion.getString("hora");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hora;
	}
	
	
}
