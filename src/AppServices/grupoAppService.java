package AppServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class grupoAppService {

	Connection conexion;
	PreparedStatement ps;
	ResultSet cargaGrupo;
	
	boolean estadoCarga;
	
	String codigo;
	String nombre;
	
	final String URL = "jdbc:postgresql://localhost/tfg";
	final String USER = "postgres";
	final String PASSW = "ROOT";
	
	public grupoAppService() {

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
			estadoCarga = cargaGrupo.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoCarga;
	}
	
	public void consultarGrupos() {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.grupo");
			cargaGrupo = ps.executeQuery();
			cargaGrupo.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarGrupoEspecifico(int idModulo) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.allmodulogrupo where \"idModulo\" = ?");
			ps.setInt(1, idModulo);
			cargaGrupo = ps.executeQuery();
			cargaGrupo.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getCodigo() {
		codigo = "";
		try {
			codigo = cargaGrupo.getString("codigo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codigo;
	}
	
	public String getCodigoGrupo() {
		codigo = "";
		try {
			codigo = cargaGrupo.getString("codigoGrupo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codigo;
	}
	
	public String getNombre() {
		nombre = "";
		try {
			nombre = cargaGrupo.getString("nombre");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombre;
	}
}
