<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Models.profesorModel"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="Models.moduloModel"%>

<%
	profesorModel profesorResult = (profesorModel) session.getAttribute("profesorResult");
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
							<h1 class="h4 mb-4 text-gray-800">Datos del profesor</h1>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4">
						<div class="form-group">
									<label for="">Nombre:</label> <input id="" name="" type="text"
										class="form-control" value="<%=profesorResult.getNombre()%>"
										readonly>
								</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
									<label for="">Apellidos:</label> <input id="" name=""
										type="text" class="form-control"
										value="<%=profesorResult.getApellidos()%>" readonly>
								</div>
						</div>
						<div class="col-lg-4">
							<div class="form-group">
									<label for="">Codigo:</label> <input id="" name="pCodigo" type="text"
										class="form-control" value="<%=profesorResult.getCodigo()%>"
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