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
import Mailer.mailerUtils2;
import Models.alumnoModel;
import Models.anotacionModel;

/**
 * Servlet implementation class modificarTutoriaController
 */
@WebServlet("/modificarTutoria")
public class modificarTutoriaController extends HttpServlet {
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
				 
				 anotacionAppService _anotacionAppService = new anotacionAppService();
				 alumnoAppService _alumnoAppService = new alumnoAppService();
				_anotacionAppService.consultarTutoria(Integer.parseInt(request.getParameter("idAnotacion")));
				 
				_alumnoAppService.consultarAlumno(_anotacionAppService.getAlumno());
				 anotacionModel anotacionResult = new anotacionModel(_anotacionAppService.getIdAnotacion(),
						 _anotacionAppService.getTipo(),
						 _anotacionAppService.getTexto(),
						 _anotacionAppService.getAlumno(),
						 _anotacionAppService.getFecha(),
						 _anotacionAppService.getHora(),
						 _anotacionAppService.getcodigoProfesor(),
						 new alumnoModel(_alumnoAppService.getDni(),
								 _alumnoAppService.getNombre(),
								 _alumnoAppService.getApellidos(),
								 _alumnoAppService.isRepetidor(),
								 _alumnoAppService.getCurso(),
								 _alumnoAppService.getGrupo()));
				 
				 session.setAttribute("anotacionResult", anotacionResult);
				 
				request.getRequestDispatcher("WEB-INF/views/modificarTutoriaView.jsp").forward(request, response);

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
			alumnoAppService _alumnoAppService = new alumnoAppService();
			_alumnoAppService.consultarAlumno(request.getParameter("dni"));
			mailerUtils2 _mailerUtils2 = new mailerUtils2();
			
			_anotacionAppService.modificarTutoria(Integer.parseInt(request.getParameter("pIdAnotacion")),
					request.getParameter("pTipo"),
					request.getParameter("pTexto"),
					request.getParameter("pDni"),
					request.getParameter("pFecha"),
					request.getParameter("pHora")
					);
			
			//_mailerUtils2.enviarConGMail(_alumnoAppService.getEmail(), "Tutoría " + request.getParameter("pFecha") + " " + request.getParameter("pHora"), request.getParameter("pTexto"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("consultarTutoria");
	}

}
