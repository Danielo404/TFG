package Controllers;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import AppServices.alumnoAppService;

/**
 * Servlet implementation class subirCursoController
 */
@WebServlet("/subirCurso")
public class subirCursoController extends HttpServlet {
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
			 request.getRequestDispatcher("WEB-INF/views/subirCursoView.jsp").forward(request, response);
		 }
		 else 
		 {
			 response.sendRedirect("login");
		 }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
try {
    

        File file = null;
        int maxFileSize = 5000 * 1024;
        int maxMemSize = 5000 * 1024;
        ServletContext servletContext;
        String filePath;
        String contentType;
        PrintWriter out;
        FileItem fi;
        List<FileItem> fileItems;
        DiskFileItemFactory factory;
        String fileName = null;

        servletContext = getServletContext();
        filePath = servletContext.getInitParameter("file-upload");

        contentType = request.getContentType();
        if ((contentType.indexOf("multipart/form-data") >= 0)) {

            factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new File("."));

            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            try {
                fileItems = upload.parseRequest(request);
                Iterator<FileItem> i = fileItems.iterator();
                while (i.hasNext()) {
                    fi = (FileItem) i.next();
                    if (!fi.isFormField()) {
                        // Get the uploaded file parameters
                        String fieldName = fi.getFieldName();
                        fileName = fi.getName();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInBytes = fi.getSize();
                        // Write the file
                        if (fileName.lastIndexOf("/") >= 0) {
                            file = new File(filePath + fileName.substring(fileName.lastIndexOf("/")));
                        } else {
                            file = new File(filePath + "/" + fileName.substring(fileName.lastIndexOf("/") + 1));
                        }
                        fi.write(file);
                        System.out.println(filePath + "/" + fileName.substring(fileName.lastIndexOf("/") + 1));
                        try {
							JSONParser parser = new JSONParser();
							//Charset UTF8 = Charset.forName("UFT-8");
							JSONArray alumnos = (JSONArray) parser.parse(new FileReader(filePath + "/" + fileName.substring(fileName.lastIndexOf("/") + 1), StandardCharsets.UTF_8));
							alumnoAppService _alumnoAppService = new alumnoAppService();
							
							for(Object alumnoSinConvertir: alumnos) {
								JSONObject alumno = (JSONObject) alumnoSinConvertir;
								String modulo = (String)alumno.get("modulo");
								String [] arrayModulos = modulo.split(",");
								_alumnoAppService.anadirAlumno((String)alumno.get("dni"),
										(String)alumno.get("nombre"),
										(String)alumno.get("apellidos"),
										(boolean)alumno.get("repetidor"),
										(String)alumno.get("curso"),
										(String)alumno.get("fechaNacimiento"),
										(String)alumno.get("localidad"),
										(String)alumno.get("grupo"),
										(String)alumno.get("cicloEstudiar"),
										(String)alumno.get("fechaIncorporacion"),
										(String)alumno.get("medioTransporte"),
										(String)alumno.get("procedencia"),
										(String)alumno.get("estudiosPrevios"),
										(boolean)alumno.get("portatil"),
										(String)alumno.get("macPortatil"),
										(String)alumno.get("nivelIngles"),
										(boolean)alumno.get("erasmus"),
										(String)alumno.get("expLaboral"),
										(String)alumno.get("observaciones"),
										(String)alumno.get("email"));
										
								System.out.println((String)alumno.get("dni") + "  "  + 
							            (String)alumno.get("nombre") + "  "  + 
							            (String)alumno.get("apellidos") + "  "  + 
							            (boolean)alumno.get("repetidor") + "  "  + 
							            (String)alumno.get("curso") + "  "  + 
							            (String)alumno.get("fechaNacimiento") + "  "  + 
							            (String)alumno.get("localidad") + "  "  + 
							            (String)alumno.get("grupo") + "  "  + 
							            (String)alumno.get("cicloEstudiar") + "  "  + 
							            (String)alumno.get("fechaIncorporacion") + "  "  + 
							            (String)alumno.get("medioTransporte") + "  "  + 
							            (String)alumno.get("procedencia") + "  "  + 
							            (String)alumno.get("estudiosPrevios") + "  "  + 
							            (boolean)alumno.get("portatil") + "  "  + 
							            (String)alumno.get("macPortatil") + "  "  + 
							            (String)alumno.get("nivelIngles") + "  "  + 
							            (boolean)alumno.get("erasmus") + "  "  + 
							            (String)alumno.get("expLaboral") + "  "  + 
							            (String)alumno.get("observaciones") + "  "  + 
							            (String)alumno.get("email") + "\n"  );
								
								Thread.sleep(100);
							            
								for(String moduloAsignar: arrayModulos) {
									_alumnoAppService.asignarModulo((String)alumno.get("dni"), Integer.parseInt(moduloAsignar));
								}
							}
							response.sendRedirect("consultarAlumnadoAdmin");
						} catch (Exception e) {
							e.printStackTrace();
						}
                    }
                }

            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            doGet(request, response);
        }

    } catch (Exception e) {
    	e.printStackTrace();
    }
            }

}
