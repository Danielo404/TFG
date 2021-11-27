package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.notificacionAppService;
import Models.notificacionModel;

/**
 * Servlet implementation class consultarNotificacionController
 */
@WebServlet("/consultarNotificacion")
public class consultarNotificacionController extends HttpServlet {
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
			 try {
				notificacionAppService _notificacionAppService = new notificacionAppService();
				ArrayList<notificacionModel> notificacionResult = new ArrayList<notificacionModel>();
				
				_notificacionAppService.consultarNotificaciones((String)session.getAttribute("codigoProfesor"));
				
				while(_notificacionAppService.consultarSiguiente() == true)
				{
					notificacionResult.add(new notificacionModel(_notificacionAppService.getIdNotificacion(),
							_notificacionAppService.getFecha(),
							_notificacionAppService.getTitulo(),
							_notificacionAppService.getTexto(),
							_notificacionAppService.getEmisor()));
				}
				
				session.setAttribute("notificacionResult", notificacionResult);
				request.getRequestDispatcher("WEB-INF/views/consultarNotificacionView.jsp").forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
