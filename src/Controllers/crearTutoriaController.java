package Controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.alumnoAppService;
import AppServices.anotacionAppService;
import Mailer.mailerUtils;
import Mailer.mailerUtils2;
import Models.alumnoModel;

/**
 * Servlet implementation class crearTutoriaController
 */
@WebServlet("/crearTutoria")
public class crearTutoriaController extends HttpServlet {
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
				 alumnoModel alumnoResult;
				 alumnoAppService _alumnoAppService = new alumnoAppService();
				 _alumnoAppService.consultarAlumno(request.getParameter("dni"));
				 
				 alumnoResult = new alumnoModel(_alumnoAppService.getDni(),
						 _alumnoAppService.getNombre(),
						 _alumnoAppService.getApellidos(),
						 _alumnoAppService.isRepetidor(),
						 _alumnoAppService.getCurso(),
						 _alumnoAppService.getGrupo());
				 
				 session.setAttribute("alumnoResult", alumnoResult);
				 
				 request.getRequestDispatcher("WEB-INF/views/crearTutoriaView.jsp").forward(request, response);
				 
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
		try {
			anotacionAppService _anotacionAppService = new anotacionAppService();
			int ultimoId = _anotacionAppService.consultarUltimoId();
			alumnoAppService _alumnoAppService = new alumnoAppService();
			_alumnoAppService.consultarAlumno(request.getParameter("pDni"));
			mailerUtils _mailerUtils = new mailerUtils();
			
			_anotacionAppService.crearTutoria(ultimoId,
					request.getParameter("pTipo"),
					request.getParameter("pTexto"),
					request.getParameter("pDni"),
					request.getParameter("pFecha"),
					request.getParameter("pHora"),
					(String)session.getAttribute("codigoProfesor"));
			
			//_mailerUtils.enviar(_alumnoAppService.getEmail(), "Tutoría " + request.getParameter("pFecha") + " " + request.getParameter("pHora"), request.getParameter("pTexto"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("consultarTutoria");
	}

}
