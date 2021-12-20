package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Models.moduloModel;

import AppServices.moduloAppService;

/**
 * Servlet implementation class consultarGrupoModuloController
 */
@WebServlet("/consultarGrupoModulo")
public class consultarGrupoModuloController extends HttpServlet {
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
			 moduloAppService _moduloAppService = new moduloAppService();
			 ArrayList<moduloModel> moduloResult = new ArrayList<moduloModel>();
			 try {
				_moduloAppService.consultarModuloGrupo((String)session.getAttribute("grupoTutorizaProfesor"));
				
				do {
					moduloResult.add(new moduloModel(_moduloAppService.getIdModulo(),_moduloAppService.getNombre()));
				}while(_moduloAppService.consultarSiguiente());
				
				session.setAttribute("moduloResult", moduloResult);
				
				request.getRequestDispatcher("WEB-INF/views/consultarGrupoModuloView.jsp").forward(request, response);
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
