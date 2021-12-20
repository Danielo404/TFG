package Models;

public class notificacionModel {
	int idNotificacion;
	String fecha;
	String titulo;
	String texto;
	String emisor;
	
	public notificacionModel(int pidNotificacion, String pfecha, String ptitulo, String ptexto, String pemisor) {
		
		idNotificacion = pidNotificacion;
		fecha = pfecha;
		titulo = ptitulo;
		texto = ptexto;
		emisor = pemisor;
	}

	public int getIdNotificacion() {
		return idNotificacion;
	}

	public String getFecha() {
		return fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		return texto;
	}

	public String getEmisor() {
		return emisor;
	}
	
	
	
}
