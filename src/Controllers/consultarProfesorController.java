package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.profesorAppService;
import Models.profesorModel;

/**
 * Servlet implementation class consultarProfesorController
 */
@WebServlet("/consultarProfesor")
public class consultarProfesorController extends HttpServlet {
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
		
		profesorAppService _profesorAppService = new profesorAppService();
		profesorModel profesorResult;
		
		 if (session.getAttribute("Iniciado") == null) 
		 {
	            session.setAttribute("Iniciado", false);
	     }
		 
		 if((boolean)session.getAttribute("Iniciado") == true)
		 {
			 try {
				_profesorAppService.consultarProfesor(request.getParameter("codigo"));
				profesorResult = new profesorModel(_profesorAppService.getNombre(),
						_profesorAppService.getApellidos(),
						_profesorAppService.getEmail(),
						_profesorAppService.getPassword(),
						_profesorAppService.getCodigo(),
						_profesorAppService.getDni());
				
				session.setAttribute("profesorResult", profesorResult);
				
				request.getRequestDispatcher("WEB-INF/views/consultarProfesorView.jsp").forward(request, response);
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
