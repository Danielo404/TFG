package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.alumnoAppService;

/**
 * Servlet implementation class crearAlumnoController
 */
@WebServlet("/anadirAlumno")
public class crearAlumnoController extends HttpServlet {
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
			 request.getRequestDispatcher("WEB-INF/views/crearAlumnoView.jsp").forward(request, response);
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
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(true);
		
		alumnoAppService _alumnoAppService = new alumnoAppService();
		
		try {
			if(_alumnoAppService.comprobarDni(request.getParameter("pdni")))
			{
				doGet(request, response);
			}
			else 
			{
				boolean repetidor, portatil, erasmus;
				
				switch(request.getParameter("pRepetidor"))
				{
				case "Si": repetidor = true;
					
					break;
					
				case "No": repetidor = false;
				
					break;
					
				default: repetidor = false;
					
					break;
				}
				
				switch(request.getParameter("pPortatil"))
				{
				case "Si": portatil = true;
					
					break;
					
				case "No": portatil = false;
				
					break;
					
				default: portatil = false;
					
					break;
				}
				
				switch(request.getParameter("pErasmus"))
				{
				case "Si": erasmus = true;
					
					break;
					
				case "No": erasmus = false;
				
					break;
					
				default: erasmus = false;
					
					break;
				}
				_alumnoAppService.anadirAlumno(request.getParameter("pdni"),
						request.getParameter("pNombre"),
						request.getParameter("pApellidos"),
						repetidor,
						request.getParameter("pCurso"),
						request.getParameter("pFechaNacimiento"),
						request.getParameter("pLocalidad"),
						request.getParameter("pGrupo"),
						request.getParameter("pCicloEstudiar"),
						request.getParameter("pFechaIncorporacion"),
						request.getParameter("pMedioTransporte"),
						request.getParameter("pProcedencia"),
						request.getParameter("pEstudiosPrevios"),
						portatil,
						request.getParameter("pMACPortatil"),
						request.getParameter("pIngles"),
						erasmus,
						request.getParameter("pExperienciaLaboral"),
						request.getParameter("pObservaciones"),
						request.getParameter("pEmail"));
				response.sendRedirect("asignarAlumno?dni=" + request.getParameter("pdni"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
