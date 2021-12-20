package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.profesorAppService;
import AppServices.moduloAppService;
import Models.profesorModel;
import Models.moduloModel;

/**
 * Servlet implementation class asignarProfesorController
 */
@WebServlet("/asignarProfesor")
public class asignarProfesorController extends HttpServlet {
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
		 
		
	
			 try {
				 profesorModel profesorResult;
				 profesorAppService _profesorAppService = new profesorAppService();
				 _profesorAppService.consultarProfesor(request.getParameter("codigo"));
				 moduloAppService _moduloAppService = new moduloAppService();
				 ArrayList<moduloModel> moduloResult = new ArrayList<moduloModel>();
				 
				 _moduloAppService.consultarModulos();
				 
				 do {
					 moduloResult.add(new moduloModel(_moduloAppService.getId(), _moduloAppService.getNombre()));
				 }while(_moduloAppService.consultarSiguiente());
				 
				 
				 profesorResult = new profesorModel(_profesorAppService.getNombre(),
						 _profesorAppService.getApellidos(),
						 _profesorAppService.getCodigo());
				 
				 session.setAttribute("profesorResult", profesorResult);
				 session.setAttribute("moduloResult", moduloResult);
				 
				 request.getRequestDispatcher("WEB-INF/views/asignarProfesorView.jsp").forward(request, response);
				 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			profesorAppService _profesorAppService = new profesorAppService();
			String[] pIdModulo = request.getParameterValues("pModulos");
			
			for(String modulo: pIdModulo) {
				_profesorAppService.asignarModulo(request.getParameter("pCodigo"), Integer.parseInt(modulo));
			}
			
			response.sendRedirect("login");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
