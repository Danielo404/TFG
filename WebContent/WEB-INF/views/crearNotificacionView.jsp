<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="Models.profesorModel" %>
	<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<profesorModel> profesorResult = (ArrayList<profesorModel>) session.getAttribute("profesorResult");
%>

<jsp:include page="shared/_header.jsp">
	<jsp:param name="tituloPagina" value="Acerca de" />
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
			<h1 class="h3 mb-4 text-gray-800">Crear Notificación</h1>

			<form method="POST">
				<div class="container">
					<div class="row">
						<div class="col-lg-6">
							<div class="form-group">
								<label for="pProfesores">Profesores</label>
								<div>
									<select id="pProfesores" name="pProfesores" style="height:280px;"
										class="custom-select" required="required" multiple="multiple">
										<% for(int i = 0; i<profesorResult.size();i++)
											{%>
										<option value="<%= profesorResult.get(i).getCodigo() %>"><%= profesorResult.get(i).getNombre() %> <%= profesorResult.get(i).getApellidos() %></option>
										<% } %>
									</select>
								</div>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="form-group">
								<label for="pTitulo">Titulo</label> <input id="pTitulo"
									name="pTitulo" placeholder="Titulo" type="text"
									class="form-control" required="required">
							</div>
							<div class="form-group">
								<label for="pTexto">Texto</label>
								<textarea id="pTexto" name="pTexto" cols="40" rows="5"
									class="form-control" required="required"></textarea>
							</div>
							<button type="submit" class="btn btn-primary w-100">Crear notificación...</button>
						</div>
					</div>
				</div>
			</form>

		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>