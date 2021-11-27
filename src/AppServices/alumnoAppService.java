package AppServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class alumnoAppService {
	Connection conexion;
	PreparedStatement ps;
	ResultSet cargaAlumno;
	
	boolean estadoCarga;
	
	String dni;
	String nombre;
	String apellidos;
	boolean repetidor;
	String curso;
	String fechaNacimiento;
	String localidad;
	String grupo;
	String cicloEstudiar;
	String fechaIncorporacion;
	String medioTransporte;
	String procedencia;
	String estudiosPrevios;
	boolean portatil;
	String macPortatil;
	String nivelIngles;
	boolean erasmus;
	String expLaboral;
	String observaciones;
	String auxNombreModulo;
	
	final String URL = "jdbc:postgresql://localhost/tfg";
	final String USER = "postgres";
	final String PASSW = "ROOT";
	
	public alumnoAppService() {

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
			estadoCarga = cargaAlumno.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoCarga;
	}
	
	public void consultarAlumnos() {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.alumno");
			cargaAlumno = ps.executeQuery();
			cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarGrupos() {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.allgrupos");
			cargaAlumno = ps.executeQuery();
			cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarAlumnosPorCurso(String curso) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.alumno WHERE curso = ?");
			ps.setString(1, curso);
			cargaAlumno = ps.executeQuery();
			cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarAlumnosPorGrupo(String grupo) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.alumno WHERE grupo = ?");
			ps.setString(1, grupo);
			cargaAlumno = ps.executeQuery();
			cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarAlumno(String dni) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.alumno WHERE dni = ?");
			ps.setString(1, dni);
			cargaAlumno = ps.executeQuery();
			cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void consultarGrupoPorModulo(int idModulo) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.allgrupomodulo WHERE allgrupomodulo.\"idModulo\" = ?");
			ps.setInt(1, idModulo);
			cargaAlumno = ps.executeQuery();
			cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void anadirAlumno(String dni, String nombre, String apellidos, boolean repetidor, String curso, String fechaNacimiento, String localidad, String grupo, String cicloEstudiar, String fechaIncorporacion, String medioTransporte, String procedencia, String estudiosPrevios, boolean portatil, String macPortatil, String nivelIngles, boolean erasmus, String expLaboral, String observaciones)
	{
		try {
			establecerConexion();
			ps = conexion.prepareStatement("INSERT INTO tutorias.alumno (dni, nombre, apellidos, repetidor, curso, \"fechaNacimiento\", localidad, grupo, \"cicloEstudiar\", \"fechaIncorporacion\", \"medioTransporte\", procedencia, \"estudiosPrevios\", portatil, \"macPortatil\", \"nivelIngles\", erasmus, \"expLaboral\", observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, dni);
			ps.setString(2, nombre);
			ps.setString(3, apellidos);
			ps.setBoolean(4, repetidor);
			ps.setString(5, curso);
			ps.setString(6, fechaNacimiento);
			ps.setString(7, localidad);
			ps.setString(8, grupo);
			ps.setString(9, cicloEstudiar);
			ps.setString(10, fechaIncorporacion);
			ps.setString(11, medioTransporte);
			ps.setString(12, procedencia);
			ps.setString(13, estudiosPrevios);
			ps.setBoolean(14, portatil);
			ps.setString(15, macPortatil);
			ps.setString(16, nivelIngles);
			ps.setBoolean(17, erasmus);
			ps.setString(18, expLaboral);
			ps.setString(19, observaciones);
			
			ps.execute();
			
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean comprobarDni(String dni){
		boolean estadoDni = false;
		try {
			establecerConexion();
			ps = conexion.prepareStatement("select * from tutorias.alumno WHERE dni = ?");
			ps.setString(1, dni);
			cargaAlumno = ps.executeQuery();
			estadoDni = cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estadoDni;
	}
	
	public void consultarAlumnosPorGrupoYModulo(String grupo, int idModulo) {
		try {
			establecerConexion();
			ps = conexion.prepareStatement("SELECT * FROM tutorias.alumnadomodulo WHERE grupo = ? and \"idModulo\" = ? order by apellidos asc ");
			ps.setString(1, grupo);
			ps.setInt(2, idModulo);
			cargaAlumno = ps.executeQuery();
			cargaAlumno.next();
			cerrarConexion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getDni() {
		dni = "";
		try {
			dni = cargaAlumno.getString("dni");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dni;
	}

	public String getNombre() {
		nombre = "";
		try {
			nombre = cargaAlumno.getString("nombre");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombre;
	}

	public String getApellidos() {
		apellidos = "";
		try {
			apellidos = cargaAlumno.getString("apellidos"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return apellidos;
	}

	public boolean isRepetidor() {
		repetidor = false;
		try {
			repetidor = cargaAlumno.getBoolean("repetidor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return repetidor;
	}

	public String getCurso() {
		curso = "";
		try {
			curso = cargaAlumno.getString("curso"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curso;
	}

	public String getFechaNacimiento() {
		fechaNacimiento = "";
		try {
			fechaNacimiento = cargaAlumno.getString("fechaNacimiento"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fechaNacimiento;
	}

	public String getLocalidad() {
		localidad = "";
		try {
			localidad = cargaAlumno.getString("localidad"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return localidad;
	}

	public String getGrupo() {
		grupo = "";
		try {
			grupo = cargaAlumno.getString("grupo"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return grupo;
	}

	public String getCicloEstudiar() {
		cicloEstudiar = "";
		try {
			cicloEstudiar = cargaAlumno.getString("cicloEstudiar"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cicloEstudiar;
	}

	public String getFechaIncorporacion() {
		fechaIncorporacion = "";
		try {
			fechaIncorporacion = cargaAlumno.getString("fechaIncorporacion"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fechaIncorporacion;
	}

	public String getMedioTransporte() {
		medioTransporte = "";
		try {
			medioTransporte = cargaAlumno.getString("medioTransporte"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medioTransporte;
	}

	public String getProcedencia() {
		procedencia = "";
		try {
			procedencia = cargaAlumno.getString("procedencia"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return procedencia;
	}

	public String getEstudiosPrevios() {
		estudiosPrevios = "";
		try {
			estudiosPrevios = cargaAlumno.getString("estudiosPrevios"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return estudiosPrevios;
	}

	public boolean isPortatil() {
		portatil = false;
		try {
			portatil = cargaAlumno.getBoolean("portatil");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return portatil;
	}

	public String getMacPortatil() {
		macPortatil = "";
		try {
			macPortatil = cargaAlumno.getString("macPortatil"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return macPortatil;
	}

	public String getNivelIngles() {
		nivelIngles = "";
		try {
			nivelIngles = cargaAlumno.getString("nivelIngles"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nivelIngles;
	}

	public boolean isErasmus() {
		erasmus = false;
		try {
			erasmus = cargaAlumno.getBoolean("erasmus");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return erasmus;
	}

	public String getExpLaboral() {
		expLaboral = "";
		try {
			expLaboral = cargaAlumno.getString("expLaboral"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return expLaboral;
	}

	public String getObservaciones() {
		observaciones = "";
		try {
			observaciones = cargaAlumno.getString("observaciones"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return observaciones;
	}
	
	public String getAuxNombreModulo() {
		auxNombreModulo = "";
		try {
			auxNombreModulo = cargaAlumno.getString("nombreModulo"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return auxNombreModulo;
	}
	
	
}
