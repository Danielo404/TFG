package Models;

public class alumnoModel {
	String dni;
	String nombre;
	String apellidos;
	boolean repetidor;
	byte[] foto;
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
	
	public alumnoModel(String pdni, String pnombre, String papellidos, boolean prepetidor, byte[] pfoto, String pcurso,
			String pfechaNacimiento, String plocalidad, String pgrupo, String pcicloEstudiar, String pfechaIncorporacion,
			String pmedioTransporte, String pprocedencia, String pestudiosPrevios, boolean pportatil, String pmacPortatil,
			String pnivelIngles, boolean perasmus, String pexpLaboral, String pobservaciones) {
		
		dni = pdni;
		nombre = pnombre;
		apellidos = papellidos;
		repetidor = prepetidor;
		foto = pfoto;
		curso = pcurso;
		fechaNacimiento = pfechaNacimiento;
		localidad = plocalidad;
		grupo = pgrupo;
		cicloEstudiar = pcicloEstudiar;
		fechaIncorporacion = pfechaIncorporacion;
		medioTransporte = pmedioTransporte;
		procedencia = pprocedencia;
		estudiosPrevios = pestudiosPrevios;
		portatil = pportatil;
		macPortatil = pmacPortatil;
		nivelIngles = pnivelIngles;
		erasmus = perasmus;
		expLaboral = pexpLaboral;
		observaciones = pobservaciones;
	}
	
	public alumnoModel(String pdni, String pnombre, String papellidos, boolean prepetidor, String pcurso,
			String pfechaNacimiento, String plocalidad, String pgrupo, String pcicloEstudiar, String pfechaIncorporacion,
			String pmedioTransporte, String pprocedencia, String pestudiosPrevios, boolean pportatil, String pmacPortatil,
			String pnivelIngles, boolean perasmus, String pexpLaboral, String pobservaciones) {
		
		dni = pdni;
		nombre = pnombre;
		apellidos = papellidos;
		repetidor = prepetidor;
		curso = pcurso;
		fechaNacimiento = pfechaNacimiento;
		localidad = plocalidad;
		grupo = pgrupo;
		cicloEstudiar = pcicloEstudiar;
		fechaIncorporacion = pfechaIncorporacion;
		medioTransporte = pmedioTransporte;
		procedencia = pprocedencia;
		estudiosPrevios = pestudiosPrevios;
		portatil = pportatil;
		macPortatil = pmacPortatil;
		nivelIngles = pnivelIngles;
		erasmus = perasmus;
		expLaboral = pexpLaboral;
		observaciones = pobservaciones;
	}
	
	

	public alumnoModel(String pdni, String pnombre, String papellidos, boolean prepetidor, String pcurso, String pgrupo) {
		dni = pdni;
		nombre = pnombre;
		apellidos = papellidos;
		repetidor = prepetidor;
		curso = pcurso;
		grupo = pgrupo;
	}

	public alumnoModel() {
		// TODO Auto-generated constructor stub
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public boolean isRepetidor() {
		return repetidor;
	}

	public byte[] getFoto() {
		return foto;
	}

	public String getCurso() {
		return curso;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getGrupo() {
		return grupo;
	}

	public String getCicloEstudiar() {
		return cicloEstudiar;
	}

	public String getFechaIncorporacion() {
		return fechaIncorporacion;
	}

	public String getMedioTransporte() {
		return medioTransporte;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public String getEstudiosPrevios() {
		return estudiosPrevios;
	}

	public boolean isPortatil() {
		return portatil;
	}

	public String getMacPortatil() {
		return macPortatil;
	}

	public String getNivelIngles() {
		return nivelIngles;
	}

	public boolean isErasmus() {
		return erasmus;
	}

	public String getExpLaboral() {
		return expLaboral;
	}

	public String getObservaciones() {
		return observaciones;
	}
	
	
}
