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
import Models.alumnoModel;

/**
 * Servlet implementation class consultarAlumnadoAdminController
 */
@WebServlet("/consultarAlumnadoAdmin")
public class consultarAlumnadoAdminController extends HttpServlet {
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
				alumnoAppService _alumnoAppService = new alumnoAppService();
				ArrayList<alumnoModel> alumnoResult = new ArrayList<alumnoModel>();
				
				_alumnoAppService.consultarAlumnos();
				
				do {
					alumnoResult.add(new alumnoModel(_alumnoAppService.getDni(), _alumnoAppService.getNombre(), _alumnoAppService.getApellidos(), _alumnoAppService.isRepetidor(), _alumnoAppService.getCurso(),_alumnoAppService.getGrupo()));
				}while(_alumnoAppService.consultarSiguiente());
				
				session.setAttribute("alumnoResult", alumnoResult);
				request.getRequestDispatcher("WEB-INF/views/consultarAlumnadoAdminView.jsp").forward(request, response);
				 
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
