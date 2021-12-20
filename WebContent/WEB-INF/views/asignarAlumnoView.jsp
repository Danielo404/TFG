<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Models.alumnoModel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Models.moduloModel"%>

<%
	alumnoModel alumnoResult = (alumnoModel) session.getAttribute("alumnoResult");
%>

<%
	ArrayList<moduloModel> moduloResult = (ArrayList<moduloModel>)session.getAttribute("moduloResult");
%>

    <jsp:include page="shared/_header.jsp">
    <jsp:param name="tituloPagina" value="Crear tutoría"/>
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
                <h1 class="h3 mb-4 text-gray-800">Asignar módulos</h1>
			
			<form method="POST">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<h1 class="h4 mb-4 text-gray-800">Datos del alumno</h1>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
						<div class="form-group">
									<label for="">Nombre:</label> <input id="" name="" type="text"
										class="form-control" value="<%=alumnoResult.getNombre()%>"
										readonly>
								</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
									<label for="">Apellidos:</label> <input id="" name=""
										type="text" class="form-control"
										value="<%=alumnoResult.getApellidos()%>" readonly>
								</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
									<label for="">DNI:</label> <input id="" name="pDni" type="text"
										class="form-control" value="<%=alumnoResult.getDni()%>"
										readonly>
								</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
						<div class="form-group">
									<label for="">Grupo:</label> <input id="" name="" type="text"
										class="form-control" value="<%=alumnoResult.getGrupo()%>"
										readonly>
								</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
									<label for="">Curso:</label> <input id="" name="" type="text"
										class="form-control" value="<%=alumnoResult.getCurso()%>"
										readonly>
								</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
						<% String resulRepetidor = ""; if(alumnoResult.isRepetidor()== true){ resulRepetidor ="Sí";}else{resulRepetidor = "No";} %>
							<label for="">Repetidor:</label> <input id="" name="" type="text"
								class="form-control" value="<%=resulRepetidor%>"
								readonly>
						</div>
						</div>
					</div>
					<hr>
					<div class="row">
						<div class="col-lg-12">
							<h1 class="h4 mb-4 text-gray-800">Seleccionar módulos</h1>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
						<div class="form-group">
								<label for="pProfesores">Modulos</label>
								<div>
									<select id="pProfesores" name="pModulos" style="height:280px;"
										class="custom-select" required="required" multiple="multiple">
										<% for(int i = 0; i<moduloResult.size();i++)
											{%>
										<option value="<%= moduloResult.get(i).getId() %>"><%= moduloResult.get(i).getNombre() %> </option>
										<% } %>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
						<button type="submit" class="btn btn-primary w-100">Asignar modulos</button>
						</div>
					</div>
				</div>
			</form>
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
            <jsp:include page="shared/_footer.jsp"></jsp:include>