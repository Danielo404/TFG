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
import AppServices.grupoAppService;
import Models.grupoModel;

/**
 * Servlet implementation class consultarGrupoController
 */
@WebServlet("/consultarGrupo")
public class consultarGrupoController extends HttpServlet {
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
		grupoAppService _grupoAppService = new grupoAppService();
		
		 if (session.getAttribute("Iniciado") == null) 
		 {
	            session.setAttribute("Iniciado", false);
	     }
		 
		 if((boolean)session.getAttribute("Iniciado") == true)
		 {
			 try {
				 ArrayList<grupoModel> grupos = new ArrayList<grupoModel>();
				 
				 _grupoAppService.consultarGrupoEspecifico(Integer.parseInt(request.getParameter("idModulo")));
				 
				 do {
					 grupos.add(new grupoModel(_grupoAppService.getCodigoGrupo(), _grupoAppService.getNombre()));
				 }while(_grupoAppService.consultarSiguiente());
				 
				session.setAttribute("grupos", grupos);
				session.setAttribute("auxidModulo", request.getParameter("idModulo"));
				request.getRequestDispatcher("/WEB-INF/views/consultarGruposView.jsp").forward(request, response);
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
