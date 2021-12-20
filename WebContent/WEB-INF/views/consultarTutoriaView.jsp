<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.anotacionModel"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<anotacionModel> anotacionResult = (ArrayList<anotacionModel>) session
			.getAttribute("anotacionResult");
%>

<jsp:include page="shared/_header.jsp">
	<jsp:param name="tituloPagina" value="Consultar tutoría" />
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
			<h1 class="h3 mb-4 text-gray-800">Mis tutorías</h1>

			<%
				if (anotacionResult.size() > 0) {
			%>
			<div class="accordion" id="accordionAnotacion">
				<%
					for (int i = 0; i < anotacionResult.size(); i++) {
				%>

				<div class="card mt-3">
					<div class="card-header acordeonfondo"
						id="heading_id_<%=anotacionResult.get(i).getIdAnotacion()%>">
						<h2 class="mb-0">
							<button class="btn btn-link btn-block text-center text-white"
								type="button" data-toggle="collapse"
								data-target="#id_<%=anotacionResult.get(i).getIdAnotacion()%>"
								aria-expanded="true"
								aria-controls="id_<%=anotacionResult.get(i).getIdAnotacion()%>">
								<%=anotacionResult.get(i).getFecha()%>
								 - 
								<%=anotacionResult.get(i).getHora() %>
								 - 
								<%=anotacionResult.get(i).getTipo()%>
								 - 
								<%=anotacionResult.get(i).get_alumno().getNombre()%>
								<%=anotacionResult.get(i).get_alumno().getApellidos()%>
							</button>
						</h2>
					</div>

					<div id="id_<%=anotacionResult.get(i).getIdAnotacion()%>"
						class="collapse"
						aria-labelledby="heading_id_<%=anotacionResult.get(i).getIdAnotacion()%>"
						data-parent="#accordionAnotacion">
						<div class="card-body text-justify">

							<div class="container-fluid">
								<div class="row">
									<div class="col-lg-6"><%=anotacionResult.get(i).getTexto()%></div>
									<div class="col-lg-6">
										<div class="form-group">
											<label for="">Nombre:</label> <input id="" name=""
												type="text" class="form-control"
												value="<%=anotacionResult.get(i).get_alumno().getNombre()%>"
												readonly>
										</div>
										<div class="form-group">
											<label for="">Apellidos:</label> <input id="" name=""
												type="text" class="form-control"
												value="<%=anotacionResult.get(i).get_alumno().getApellidos()%>"
												readonly>
										</div>
										<div class="form-group">
											<label for="">Grupo:</label> <input id="" name="" type="text"
												class="form-control"
												value="<%=anotacionResult.get(i).get_alumno().getGrupo()%>"
												readonly>
										</div>
										<div class="form-group">
											<%
												String resulRepetidor = "";
														if (anotacionResult.get(i).get_alumno().isRepetidor() == true) {
															resulRepetidor = "Sí";
														} else {
															resulRepetidor = "No";
														}
											%>
											<label for="">Repetidor:</label> <input id="" name=""
												type="text" class="form-control" value="<%=resulRepetidor%>"
												readonly>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6"> <a href="modificarTutoria?idAnotacion=<%= anotacionResult.get(i).getIdAnotacion() %>" class="btn btn-primary w-100">Modificar tutoría</a></div>
									<div class="col-lg-6"> <a href="eliminarTutoria?idAnotacion=<%= anotacionResult.get(i).getIdAnotacion() %>" class="btn btn-danger w-100">Eliminar tutoría</a></div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<%
					}
				%>
			</div>
			<%
				}
			%>
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>