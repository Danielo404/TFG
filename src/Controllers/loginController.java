package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.profesorAppService;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	HttpSession session;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         * Codificación UTF-8.
         * */
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(true);
		
		 /* Control de sesión.
         * */
        if (session.getAttribute("Iniciado") == null) {
            session.setAttribute("Iniciado", false);
        }
		
		request.getRequestDispatcher("WEB-INF/views/loginView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(true);
		
		profesorAppService _profesorAppService = new profesorAppService();
		
		try {
			if(_profesorAppService.iniciarSesion(request.getParameter("pEmail"),request.getParameter("pPassword")))
			{
				session.setAttribute("Iniciado", true);
				session.setAttribute("nombreProfesor", _profesorAppService.getNombre());
				session.setAttribute("codigoProfesor", _profesorAppService.getCodigo());
				session.setAttribute("grupoTutorizaProfesor", _profesorAppService.getGrupoTutoriza());
				response.sendRedirect("Index");
			}
			else
			{
				doGet(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
