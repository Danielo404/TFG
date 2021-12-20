package AppServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class notificacionAppService {
	Connection conexion;
	PreparedStatement ps;
	ResultSet cargaNotificacion;

	boolean estadoCarga;
	
	int idNotificacion;
	String fecha;
	String titulo;
	String texto;
	String emisor;
	
	final String URL = "jdbc:postgresql://localhost/tfg";
	final String USER = "postgres";
	final String PASSW = "ROOT";
	
	public notificacionAppService() {

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
			estadoCarga = cargaNotificacion.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoCarga;
	}
	
	public int consultarUltimoId() {
		int ultimoId = 0;
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT \"idNotificacion\" FROM tutorias.notificacion order by \"idNotificacion\" desc limit 1");
			ResultSet e = ps.executeQuery();
			e.next();
			ultimoId = e.getInt("idNotificacion") + 1;
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ultimoId;
	}
	
public void crearNotificacion(int idNotificacion, String fecha, String titulo, String texto, String emisor) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("INSERT INTO tutorias.notificacion( \"idNotificacion\", fecha, titulo, texto, emisor) VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, idNotificacion);
			ps.setString(2, fecha);
			ps.setString(3, titulo);
			ps.setString(4, texto);
			ps.setString(5, emisor);
			ps.execute();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

public void relacionarNotificacion(int idNotificacion, String codigoProfesor) {
	try {
		establecerConexion();
		ps = conexion.prepareStatement("INSERT INTO tutorias.profesornotificacion( \"idNotificacion\", \"codigoProfesor\") VALUES (?, ?)");
		ps.setInt(1, idNotificacion);
		ps.setString(2, codigoProfesor);
		ps.execute();
		cerrarConexion();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

public void consultarNotificaciones(String codigoProfesor) {
	try {
		establecerConexion();
		ps = conexion.prepareStatement("SELECT * FROM tutorias.allnotificacionprofesor where \"codigoProfesor\" = ?");
		ps.setString(1, codigoProfesor);
		cargaNotificacion = ps.executeQuery();
		cerrarConexion();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

	public int getIdNotificacion() {
		idNotificacion = 0;
		try {
			idNotificacion = cargaNotificacion.getInt("idNotificacion");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idNotificacion;
	}
	
	

	public String getFecha() {
		fecha = "";
		try {
			fecha = cargaNotificacion.getString("fecha");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fecha;
	}

	public String getTitulo() {
		titulo = "";
		try {
			titulo = cargaNotificacion.getString("titulo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return titulo;
	}

	public String getTexto() {
		texto = "";
		try {
			texto = cargaNotificacion.getString("texto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return texto;
	}

	public String getEmisor() {
		emisor = "";
		try {
			emisor = cargaNotificacion.getString("emisor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emisor;
	}

	

	
	
	
}
