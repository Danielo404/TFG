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

	String id;
	String nombre;
	String siglas;
	int nHoras;

	final String URL = "jdbc:postgresql://localhost/tfg";
	final String USER = "root";
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

	public String getId() {
		id = "";
		try {
			id = cargaModulo.getString("id");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	public String getNombre() {
		nombre = "";
		try {
			nombre = cargaModulo.getString("nombre");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombre;
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
