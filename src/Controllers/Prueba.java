package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AppServices.moduloAppService;
import Models.moduloModel;

/**
 * Servlet implementation class Prueba
 */
@WebServlet("/Prueba")
public class Prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	HttpSession session;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<moduloModel> moduloResult = new ArrayList<moduloModel>();
		
		moduloAppService _moduloAppService = new moduloAppService();
		
		session = request.getSession(true);
		_moduloAppService.consultarModulos();
		do {
			moduloResult.add(new moduloModel(_moduloAppService.getId(), _moduloAppService.getNombre(), _moduloAppService.getnHoras(), _moduloAppService.getSiglas()));
		} while(_moduloAppService.consultarSiguiente());
		
		session.setAttribute("moduloResult", moduloResult);
		
		request.getRequestDispatcher("WEB-INF/views/__plantilla.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
