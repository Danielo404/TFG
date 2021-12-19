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
			<form method="POST">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-3">
						<img src="/TFG/img/profesor.png" class="w-75 rounded img-center-custom">
					</div>
					<div class="col-lg-9">
						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Nombre:</label> <input id="" name="pNombre" type="text"
										class="form-control" value="<%=profesorResult.getNombre()%>"
										>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Apellidos:</label> <input id="" name="pApellidos"
										type="text" class="form-control"
										value="<%=profesorResult.getApellidos()%>" >
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">DNI:</label> <input id="" name="pDni" type="text"
										class="form-control" value="<%=profesorResult.getDni()%>"
										>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Código:</label> <input id="" name="pCodigo"
										type="text" class="form-control"
										value="<%=profesorResult.getCodigo()%>" readonly>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Email:</label> <input id="" name="pEmail" type="text"
										class="form-control" value="<%=profesorResult.getEmail()%>"
										>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Contraseña:</label> <input id="" name="pPassword" type="password"
										class="form-control" value="<%=profesorResult.getPassword()%>"
										>
								</div>
							</div>
							
						</div>
						<div class="row justify-content-end">
							<div class="col-lg-6">
							<button type="submit" class="btn btn-primary w-100 p-2">Guardar</button>	
							</div>
						</div>
					</div>
				</div>
				
			</div>

		</div>
		</form>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>