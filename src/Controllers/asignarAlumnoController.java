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
import AppServices.moduloAppService;
import Models.alumnoModel;
import Models.moduloModel;

/**
 * Servlet implementation class asignarAlumnoController
 */
@WebServlet("/asignarAlumno")
public class asignarAlumnoController extends HttpServlet {
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
				 alumnoModel alumnoResult;
				 alumnoAppService _alumnoAppService = new alumnoAppService();
				 _alumnoAppService.consultarAlumno(request.getParameter("dni"));
				 moduloAppService _moduloAppService = new moduloAppService();
				 ArrayList<moduloModel> moduloResult = new ArrayList<moduloModel>();
				 
				 _moduloAppService.cargarModulosAsignacion(_alumnoAppService.getGrupo().split(" ")[1]);
				 
				 do {
					 moduloResult.add(new moduloModel(_moduloAppService.getIdModulo(), _moduloAppService.getNombre()));
				 }while(_moduloAppService.consultarSiguiente());
				 
				 
				 alumnoResult = new alumnoModel(_alumnoAppService.getDni(),
						 _alumnoAppService.getNombre(),
						 _alumnoAppService.getApellidos(),
						 _alumnoAppService.isRepetidor(),
						 _alumnoAppService.getCurso(),
						 _alumnoAppService.getGrupo());
				 
				 session.setAttribute("alumnoResult", alumnoResult);
				 session.setAttribute("moduloResult", moduloResult);
				 
				 request.getRequestDispatcher("WEB-INF/views/asignarAlumnoView.jsp").forward(request, response);
				 
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
			alumnoAppService _alumnoAppService = new alumnoAppService();
			String[] pIdModulo = request.getParameterValues("pModulos");
			
			for(String modulo: pIdModulo) {
				_alumnoAppService.asignarModulo(request.getParameter("pDni"), Integer.parseInt(modulo));
			}
			
			response.sendRedirect("consultarAlumno?dni=" + request.getParameter("pDni"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
