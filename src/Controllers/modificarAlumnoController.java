package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.alumnoAppService;
import Models.alumnoModel;

/**
 * Servlet implementation class modificarAlumnoController
 */
@WebServlet("/modificarAlumno")
public class modificarAlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   HttpSession session;
        // TODO Auto-generated constructor stu

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
alumnoModel alumnoResult = new alumnoModel();
		
		alumnoAppService _alumnoAppService = new alumnoAppService();
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
		
        if(request.getParameter("dni") == null)
        {
        	response.sendRedirect("Index");
        	
        }
        else {
        	_alumnoAppService.consultarAlumno(request.getParameter("dni"));
        }
    
        
        	alumnoResult = new alumnoModel(_alumnoAppService.getDni(),
        			_alumnoAppService.getNombre(),
        			_alumnoAppService.getApellidos(),
        			_alumnoAppService.isRepetidor(),
        			_alumnoAppService.getCurso(),
        			_alumnoAppService.getFechaNacimiento(),
        			_alumnoAppService.getLocalidad(),
        			_alumnoAppService.getGrupo(),
        			_alumnoAppService.getCicloEstudiar(),
        			_alumnoAppService.getFechaIncorporacion(),
        			_alumnoAppService.getMedioTransporte(),
        			_alumnoAppService.getProcedencia(),
        			_alumnoAppService.getEstudiosPrevios(),
        			_alumnoAppService.isPortatil(),
        			_alumnoAppService.getMacPortatil(),
        			_alumnoAppService.getNivelIngles(),
        			_alumnoAppService.isErasmus(),
        			_alumnoAppService.getExpLaboral(),
        			_alumnoAppService.getObservaciones(),
        			_alumnoAppService.getEmail());
        
        session.setAttribute("alumnoResult", alumnoResult);
        
		request.getRequestDispatcher("WEB-INF/views/modificarAlumnoView.jsp").forward(request, response);
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
				_alumnoAppService.modificarAlumno(request.getParameter("pdni"),
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
				response.sendRedirect("consultarAlumno?dni=" + request.getParameter("pdni"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
