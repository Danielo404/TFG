<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.alumnoModel"%>
<%@ page import="java.util.ArrayList"%>

<%
	alumnoModel alumnoResult = (alumnoModel) session.getAttribute("alumnoResult");
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
			<h1 class="h3 mb-4 text-gray-800">Datos del alumno</h1>
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-3">
						<img src="/TFG/img/default_profile.png" class="w-75 rounded img-center-custom">
					</div>
					<div class="col-lg-9">
						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Nombre:</label> <input id="" name="" type="text"
										class="form-control" value="<%=alumnoResult.getNombre()%>"
										readonly>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Apellidos:</label> <input id="" name=""
										type="text" class="form-control"
										value="<%=alumnoResult.getApellidos()%>" readonly>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">DNI:</label> <input id="" name="" type="text"
										class="form-control" value="<%=alumnoResult.getDni()%>"
										readonly>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Fecha de nacimiento:</label> <input id="" name=""
										type="text" class="form-control"
										value="<%=alumnoResult.getFechaNacimiento()%>" readonly>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Curso:</label> <input id="" name="" type="text"
										class="form-control" value="<%=alumnoResult.getCurso()%>"
										readonly>
								</div>
							</div>
							<div class="col-lg-6" name="">
								<div class="form-group">
									<label for="">Grupo:</label> <input id="" name="" type="text"
										class="form-control" value="<%=alumnoResult.getGrupo()%>"
										readonly>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row mt-4">
					<div class="col-lg-3" name="">
						<div class="form-group">
						<% String resulRepetidor = ""; if(alumnoResult.isRepetidor()== true){ resulRepetidor ="Sí";}else{resulRepetidor = "No";} %>
							<label for="">Repetidor:</label> <input id="" name="" type="text"
								class="form-control" value="<%=resulRepetidor%>"
								readonly>
						</div>
					</div>
					<div class="col-lg-3" name="">
						<div class="form-group">
							<label for="">Localidad:</label> <input id="" name="" type="text"
								class="form-control" value="<%=alumnoResult.getLocalidad()%>"
								readonly>
						</div>
					</div>
					<div class="col-lg-3" name="">
						<div class="form-group">
							<label for="">Fecha de incorporación:</label> <input id=""
								name="" type="text" class="form-control"
								value="<%=alumnoResult.getFechaIncorporacion()%>" readonly>
						</div>
					</div>
					<div class="col-lg-3" name="">
						<div class="form-group">
							<label for="">Nivel de inglés:</label> <input id="" name=""
								type="text" class="form-control"
								value="<%=alumnoResult.getNivelIngles()%>" readonly>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-3" name="">
						<div class="form-group">
						<% String resulPortatil = ""; if(alumnoResult.isPortatil()== true){ resulPortatil ="Sí";}else{resulPortatil = "No";} %>
							<label for="">Portátil:</label> <input id="" name="" type="text"
								class="form-control" value="<%= resulPortatil %>"
								readonly>
						</div>
					</div>
					<div class="col-lg-3" name="">
						<div class="form-group">
							<label for="">MAC del portátil:</label> <input id="" name=""
								type="text" class="form-control"
								value="<%=alumnoResult.getMacPortatil()%>" readonly>
						</div>
					</div>
					<div class="col-lg-3" name="">
						<div class="form-group">
						<% String resulErasmus = ""; if(alumnoResult.isErasmus()== true){ resulErasmus ="Sí";}else{resulErasmus = "No";} %>
							<label for="">Erasmus:</label> <input id="" name="" type="text"
								class="form-control" value="<%= resulErasmus%>"
								readonly>
						</div>
					</div>
					<div class="col-lg-3" name="">
						<div class="form-group">
							<label for="">Medio de Transporte:</label> <input id="" name=""
								type="text" class="form-control"
								value="<%=alumnoResult.getMedioTransporte()%>" readonly>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6" name="">
						<div class="form-group">
							<label for="">Estudios Previos:</label>
							<textarea id="" name="" type="text" class="form-control"
								value="" readonly><%=alumnoResult.getEstudiosPrevios()%>
										</textarea>
						</div>
					</div>
					<div class="col-lg-6" name="">
						<div class="form-group">
							<label for="">Procedencia:</label>
							<textarea id="" name="" type="text" class="form-control"
								value="" readonly><%=alumnoResult.getProcedencia()%>
										</textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6" name="">
						<div class="form-group">
							<label for="">Experiencia Laboral:</label>
							<textarea id="" name="" type="text" class="form-control"
								value="" readonly><%=alumnoResult.getExpLaboral()%>
										</textarea>
						</div>
					</div>
					<div class="col-lg-6" name="">
						<div class="form-group">
							<label for="">Observaciones:</label>
							<textarea id="" name="" type="text" class="form-control"
								value="" readonly><%=alumnoResult.getObservaciones()%>
										</textarea>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6" name="">
						<% String grupoTutorizProfesor = (String)session.getAttribute("grupoTutorizaProfesor");
						if(grupoTutorizProfesor.equals(alumnoResult.getGrupo())) { %>
						<a href="crearTutoria?dni=<%= alumnoResult.getDni() %>" class="btn btn-primary w-100 p-3">Concertar tutoría</a>
						<%} %>
					</div>
					<div class="col-lg-6" name="">
						<a href="modificarAlumno?dni=<%= alumnoResult.getDni() %>" class="btn btn-primary w-100 p-3">Modificar datos del alumno</a>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>