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
 * Servlet implementation class consultarAlumnoController
 */
@WebServlet("/consultarAlumno")
public class consultarAlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	HttpSession session;
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
        
		request.getRequestDispatcher("WEB-INF/views/consultarAlumnoView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
