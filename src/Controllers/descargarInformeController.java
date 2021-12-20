package Controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.w3c.dom.Text;

import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import AppServices.alumnoAppService;
import AppServices.moduloAppService;
import AppServices.profesorAppService;
import Models.alumnoModel;

/**
 * Servlet implementation class descargarInformeController
 */
@WebServlet("/descargarInforme")
public class descargarInformeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   HttpSession session;
	
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
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss_mm_hh_dd_MM_yyyy");
				   LocalDateTime now = LocalDateTime.now();
				   String datetime = dtf.format(now);
				 
				// Creating a PdfWriter object
			     String file = "WebContent/pdf/" + datetime + ".pdf";       
			                      
			     
			     // Creating a Document object       
			     Document doc = new Document();               
			     FileOutputStream ficheroPdf = new FileOutputStream(file);
			     PdfWriter.getInstance(doc, ficheroPdf).setInitialLeading(20);
			     doc.open();
			     
			     alumnoAppService _alumnoAppService = new alumnoAppService();
			     moduloAppService _moduloAppService = new moduloAppService();
			     profesorAppService _profesorAppService = new profesorAppService();
			    
			     // Creating a table       
			     
			     float[] relativeWidth = new float[2];
			     relativeWidth[0] = 30;
			     relativeWidth[1] = 70;
			     PdfPTable table = new PdfPTable(relativeWidth);
			  
			     table.setWidthPercentage(100);
			     
			     
			     
			     /**
			      *  DATOS DEL TUTOR
			     */
			     PdfPCell cLabelDatosTutor = new PdfPCell();       
			     cLabelDatosTutor.addElement(new Paragraph("Datos del Tutor"));
			     //cLabelDatosTutor.setHorizontalAlignment(Element.ALIGN_CENTER);
			         
			     table.addCell(cLabelDatosTutor);
			     
			     _profesorAppService.consultarProfesor((String) session.getAttribute("codigoProfesor"));
			     List ListDatosTutor = new List();       
			    
			     ListDatosTutor.add(new ListItem("Nombre: " + _profesorAppService.getNombre() + " " + _profesorAppService.getApellidos()));            
			    
			      PdfPCell cDatosTutor = new PdfPCell();       
			      cDatosTutor.addElement(ListDatosTutor);       
			         
			     table.addCell(cDatosTutor);  
			    
			     /**
			      * DATOS DEL ALUMNO
			      */
			     PdfPCell cLabelDatosAlumno = new PdfPCell();
			     cLabelDatosAlumno.addElement(new Paragraph("Datos del Alumno") );
			     cLabelDatosAlumno.setHorizontalAlignment(Element.ALIGN_LEFT);    
			     table.addCell(cLabelDatosAlumno);                      
			     
			    
			     
			     _alumnoAppService.consultarAlumno(request.getParameter("dni"));
			    
			     List ListDatosAlumno = new List();       
			           
			     ListDatosAlumno.add(new ListItem("Nombre: " + _alumnoAppService.getNombre() + " " +  _alumnoAppService.getApellidos()));       
			          
			     
			     String repetidorAux = _alumnoAppService.isRepetidor() == true ? "Si" : "No";
			     ListDatosAlumno.add(new ListItem("Repetidor: " + repetidorAux));
			     ListDatosAlumno.add(new ListItem("Correo electrónico: " + _alumnoAppService.getEmail())); 
			     
			     ListDatosAlumno.add(new ListItem("Fecha de nacimiento: " + _alumnoAppService.getFechaNacimiento()));       
			     ListDatosAlumno.add(new ListItem("Viene de: " + _alumnoAppService.getLocalidad()));       
			           
			     ListDatosAlumno.add(new ListItem("¿Era éste el ciclo que quería estudiar?: " + _alumnoAppService.getCicloEstudiar()));       
			     ListDatosAlumno.add(new ListItem("Se incorporó en: " + _alumnoAppService.getFechaIncorporacion()));       
			     ListDatosAlumno.add(new ListItem("Medio de transporte: " + _alumnoAppService.getMedioTransporte()));       
			     ListDatosAlumno.add(new ListItem("Viene de: " + _alumnoAppService.getProcedencia()));       
			     ListDatosAlumno.add(new ListItem("Ha estudiado anteriormente: " + _alumnoAppService.getEstudiosPrevios()));
			     
			     
			     _moduloAppService.consultarModuloAlumno(request.getParameter("dni"));
			     String siglasAux = "";
			     do{
				      siglasAux = siglasAux + _moduloAppService.getSiglas() + ", ";
				     }while(_moduloAppService.consultarSiguiente());
			     siglasAux = siglasAux.substring(0, siglasAux.length() - 2);
			     ListDatosAlumno.add(new ListItem("Módulos que cursa: " + siglasAux));

			     String portatilAux = _alumnoAppService.isPortatil() == true ? "Si" : "No";
			     ListDatosAlumno.add(new ListItem("Portatil: " + portatilAux));
			         
			    
			     ListDatosAlumno.add(new ListItem("Nivel de inglés: " + _alumnoAppService.getNivelIngles()));       
			     String erasmusAux = _alumnoAppService.isErasmus() == true ? "Si" : "No";
			     ListDatosAlumno.add(new ListItem("Erasmus: " + erasmusAux));       
			    
			     ListDatosAlumno.add(new ListItem("Experiencia laboral: " + _alumnoAppService.getExpLaboral()));             
			           
			    
			     PdfPCell cDatosAlumno = new PdfPCell();       
			     cDatosAlumno.addElement(ListDatosAlumno);              
			     table.addCell(cDatosAlumno);                 
			     
			    
			    /**
			     * OBSERVACIONES
			     */
			    PdfPCell cLabelObservaciones = new PdfPCell();       
			    cLabelObservaciones.addElement(new Paragraph("Observaciones del tutor"));       
			       
			    table.addCell(cLabelObservaciones);
			    
			    
			    PdfPCell cObservaciones = new PdfPCell();       
			    cObservaciones.addElement(new Paragraph(_alumnoAppService.getObservaciones()));       
			          
			    table.addCell(cObservaciones);                 
			    
			    
			    
			                   
			     
			     
			     // Adding Table to document        
			     doc.add(table);                  
			     
			     // Closing the document       
			     doc.close();  
			     System.out.println("Lists added to table successfully..");
			     
			     session.setAttribute("fichero", datetime);
			        
				 
				 request.getRequestDispatcher("WEB-INF/views/descargarInformeView.jsp").forward(request, response);
				 
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
