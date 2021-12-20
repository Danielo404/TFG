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

/**
 * Servlet implementation class eliminarCursoController
 */
@WebServlet("/eliminarCurso")
public class eliminarCursoController extends HttpServlet {
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
			 alumnoAppService _alumnoAppService = new alumnoAppService();
			 ArrayList<String> cursoResult = new ArrayList<String>();
			 _alumnoAppService.consultarCursos();
			 
			 do {
				 cursoResult.add(_alumnoAppService.getCurso());
			 }while(_alumnoAppService.consultarSiguiente());
			 
			 session.setAttribute("cursoResult", cursoResult);
			 
			request.getRequestDispatcher("WEB-INF/views/eliminarCursoView.jsp").forward(request, response);

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
			alumnoAppService _alumnoAppService = new alumnoAppService();
			_alumnoAppService.consultarAlumnosPorCurso(request.getParameter("pCurso"));
			
			do {
				_alumnoAppService.eliminarClavesForaneas(_alumnoAppService.getDni());
				_alumnoAppService.eliminarAlumno(_alumnoAppService.getDni());
			}while(_alumnoAppService.consultarSiguiente());
			
			response.sendRedirect("consultarAlumnadoAdmin");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
