package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.alumnoAppService;
import AppServices.anotacionAppService;
import Models.alumnoModel;
import Models.anotacionModel;

/**
 * Servlet implementation class consultarTutoriaController
 */
@WebServlet("/consultarTutoria")
public class consultarTutoriaController extends HttpServlet {
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
				 ArrayList<anotacionModel> anotacionResult = new ArrayList<anotacionModel>();
				 
				 _anotacionAppService.consultarTutorias((String)session.getAttribute("codigoProfesor"));
				 while(_anotacionAppService.consultarSiguiente()) {
					 _alumnoAppService.consultarAlumno(_anotacionAppService.getAlumno());
					 anotacionResult.add(new anotacionModel(_anotacionAppService.getIdAnotacion(),
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
									 _alumnoAppService.getGrupo())));
				 }
				 
				 session.setAttribute("anotacionResult", anotacionResult);
				 
				 
				 request.getRequestDispatcher("WEB-INF/views/consultarTutoriaView.jsp").forward(request, response);
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
