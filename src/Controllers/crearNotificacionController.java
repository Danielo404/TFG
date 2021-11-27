package Controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.notificacionAppService;
import AppServices.profesorAppService;
import Models.profesorModel;

/**
 * Servlet implementation class crearNotificacionController
 */
@WebServlet("/crearNotificacion")
public class crearNotificacionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(true);
		
		 if (session.getAttribute("Iniciado") == null) 
		 {
	            session.setAttribute("Iniciado", false);
	     }
		 
		 if((boolean)session.getAttribute("Iniciado") == true)
		 {
			 profesorAppService _profesorAppService = new profesorAppService();
			 ArrayList<profesorModel> profesorResult = new ArrayList<profesorModel>();
			 
			 _profesorAppService.consultarProfesores();
			 
			 do {
				 profesorResult.add(new profesorModel(_profesorAppService.getNombre(),
						 _profesorAppService.getApellidos(),
						 _profesorAppService.getCodigo()));
				 
			 }while(_profesorAppService.consultarSiguiente());
			 
			 session.setAttribute("profesorResult", profesorResult);
			 request.getRequestDispatcher("WEB-INF/views/crearNotificacionView.jsp").forward(request, response);
			 
		 }
		 else 
		 {
			 response.sendRedirect("login");
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			notificacionAppService _notificacionAppService = new notificacionAppService();
			String[] pCodigoProfesores = request.getParameterValues("pProfesores");
			int ultimoId = _notificacionAppService.consultarUltimoId();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			   LocalDateTime now = LocalDateTime.now();
			   
			   _notificacionAppService.crearNotificacion(ultimoId,
					   dtf.format(now),
					   request.getParameter("pTitulo"),
					   request.getParameter("pTexto"),
					   (String)session.getAttribute("nombreProfesor") + " " + (String)session.getAttribute("apellidosProfesor"));
			   
			   for(String codigoProfesor:pCodigoProfesores) {
				   _notificacionAppService.relacionarNotificacion(ultimoId, codigoProfesor);
			   }
			
			doGet(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
