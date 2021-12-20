<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Models.alumnoModel" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<alumnoModel> alumnoResult = (ArrayList<alumnoModel>) session.getAttribute("alumnoResult");
%>

    <jsp:include page="shared/_header.jsp">
    <jsp:param name="tituloPagina" value="Alumnos"/>
</jsp:include>
    <jsp:include page="shared/_aside.jsp"></jsp:include>
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <jsp:include page="shared/_nav.jsp"></jsp:include>
            <!-- Begin Page Content -->
            <div class="container-fluid">
                
                <!-- Page Heading -->
                <h1 class="h3 mb-4 text-gray-800"><%= (String) session.getAttribute("auxNombreModulo") %> - Grupo <%= (String) session.getAttribute("auxGrupo") %></h1>
                
			<div class="row">
			<div class="col">
			 <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Alumnos</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Apellidos</th>
                                            <th>Nombre</th>
                                            <th>Curso</th>
                                            <th>Grupo</th>
                                            <th>Repetidor</th>
                                            <th>Datos</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Apellidos</th>
                                            <th>Nombre</th>
                                            <th>Curso</th>
                                            <th>Grupo</th>
                                            <th>Repetidor</th>
                                            <th>Datos</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <% for(int i = 0; i<alumnoResult.size();i++){ %>
                                        <tr>
                                            <td><%= alumnoResult.get(i).getApellidos() %></td>
                                            <td><%= alumnoResult.get(i).getNombre() %></td>
                                            <td><%= alumnoResult.get(i).getCurso()%></td>
                                            <td><%= alumnoResult.get(i).getGrupo()%></td>
                                            <% String resulRepetidor = ""; if(alumnoResult.get(i).isRepetidor()== true){ resulRepetidor ="Sí";}else{resulRepetidor = "No";} %>
                                            <td><%= resulRepetidor%></td>
                                            <td><a href="consultarAlumno?dni=<%= alumnoResult.get(i).getDni() %>" class="btn btn-primary w-100 text-center">Ver datos del alumno...</a></td>
                                        </tr>
                                        <%} %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    </div>
                    </div>
                    
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
            <jsp:include page="shared/_footer.jsp"></jsp:include>