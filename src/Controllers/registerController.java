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
import AppServices.profesorAppService;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/register")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
        
        try {
        	alumnoAppService _alumnoAppService = new alumnoAppService();
        	_alumnoAppService.consultarGrupos();
        	ArrayList<String> gruposResult = new ArrayList<String>();
        	
        	do {
        		gruposResult.add(_alumnoAppService.getGrupo());
        	} while(_alumnoAppService.consultarSiguiente());
        	
        	session.setAttribute("gruposResult", gruposResult);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("WEB-INF/views/registerView.jsp").forward(request, response);
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
			if(_profesorAppService.comprobarCodigo(request.getParameter("pCodigo")))
			{
				doGet(request, response);	
			}
			else
			{
				boolean tutoriza = (request.getParameter("pTutoriza").equals("Sí")) ?true:false;
				String grupoTutoriza = (tutoriza == true) ?request.getParameter("pGrupo"):null;
				
				_profesorAppService.darDeAltaCompleto(request.getParameter("pNombre"),
						request.getParameter("pApellidos"),
						request.getParameter("pCodigo"),
						request.getParameter("pDni"),
						request.getParameter("pEmail"),
						request.getParameter("pPassword"),
						tutoriza,
						grupoTutoriza);
				session.setAttribute("codigoProfesor", request.getParameter("pCodigo"));
				response.sendRedirect("asignarProfesor?codigo=" + request.getParameter("pCodigo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
