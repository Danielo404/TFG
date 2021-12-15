<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.profesorModel"%>
<%@ page import="java.util.ArrayList"%>

<%
	profesorModel profesorResult = (profesorModel) session.getAttribute("profesorResult");
%>

<jsp:include page="shared/_header.jsp">
	<jsp:param name="tituloPagina" value="Consultar alumno" />
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
			<h1 class="h3 mb-4 text-gray-800">Perfil de <%= profesorResult.getNombre() + " " + profesorResult.getApellidos() %></h1>
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-3">
						<img src="/TFG/img/prof_<%= profesorResult.getCodigo() %>.png" class="w-75 rounded img-center-custom">
					</div>
					<div class="col-lg-9">
						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Nombre:</label> <input id="" name="" type="text"
										class="form-control" value="<%=profesorResult.getNombre()%>"
										readonly>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Apellidos:</label> <input id="" name=""
										type="text" class="form-control"
										value="<%=profesorResult.getApellidos()%>" readonly>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">DNI:</label> <input id="" name="" type="text"
										class="form-control" value="<%=profesorResult.getDni()%>"
										readonly>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Código:</label> <input id="" name=""
										type="text" class="form-control"
										value="<%=profesorResult.getCodigo()%>" readonly>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Email:</label> <input id="" name="" type="text"
										class="form-control" value="<%=profesorResult.getEmail()%>"
										readonly>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Contraseña:</label> <input id="" name="" type="password"
										class="form-control" value="<%=profesorResult.getPassword()%>"
										readonly>
								</div>
							</div>
							
						</div>
						<div class="row justify-content-end">
							<div class="col-lg-12">
							<a href="modificarProfesor?codigo=<%= profesorResult.getCodigo()%>" class="btn btn-primary w-100 p-2">Modificar datos</a>	
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