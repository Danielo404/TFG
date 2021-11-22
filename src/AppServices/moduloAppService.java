package AppServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class moduloAppService {
	Connection conexion;
	PreparedStatement ps;
	ResultSet cargaModulo;

	boolean estadoCarga;

	int id;
	String nombreModulo;
	String siglas;
	int nHoras;

	final String URL = "jdbc:postgresql://localhost/tfg";
	final String USER = "postgres";
	final String PASSW = "ROOT";

	public moduloAppService() {

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
			estadoCarga = cargaModulo.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoCarga;
	}

	public void consultarModulos() {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.modulo");
			cargaModulo = ps.executeQuery();
			cargaModulo.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void consultarModuloEspecifico(String id) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.modulo WHERE id = ?");
			ps.setString(1, id);
			cargaModulo = ps.executeQuery();
			cargaModulo.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarProfesorModuloEspecifico(String codigoProfesor) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.allprofesormodulo WHERE allprofesormodulo.\"codigoProfesor\" = ?");
			ps.setString(1, codigoProfesor);
			cargaModulo = ps.executeQuery();
			cargaModulo.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarModuloGrupo(String grupo) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.allmodulogrupo where \"codigoGrupo\" = ?");
			ps.setString(1, grupo);
			cargaModulo = ps.executeQuery();
			cargaModulo.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		id = 0;
		try {
			id = cargaModulo.getInt("id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	public int getIdModulo() {
		id = 0;
		try {
			id = cargaModulo.getInt("idModulo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public String getNombre() {
		nombreModulo = "";
		try {
			nombreModulo = cargaModulo.getString("nombreModulo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombreModulo;
	}
	

	public String getSiglas() {
		siglas = "";
		try {
			siglas = cargaModulo.getString("siglas");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return siglas;
	}

	public int getnHoras() {
		nHoras = 0;
		try {
			nHoras = cargaModulo.getInt("nHoras");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nHoras;
	}

}
