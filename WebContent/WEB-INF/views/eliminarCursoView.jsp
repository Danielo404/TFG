<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<String> cursoResult = (ArrayList<String>) session.getAttribute("cursoResult");
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
			<h1 class="h3 mb-4 text-gray-800">Eliminar curso</h1>

			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-header text-center acordeonfondo text-white">Atención</div>
							<div class="card-body">
								<blockquote class="blockquote mb-0">
									<p>A continuación vas a proceder a eliminar un curso entero
										¿estas seguro?</p>
								</blockquote>
							</div>
						</div>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-lg-12">
						<form method="POST">
							<div class="form-group ">
								<label for="pCurso">Curso</label>
								 <select id="pCurso"
									name="pCurso" required="required" class="custom-select ">
									<% for( int i=0;i<cursoResult.size();i++){ %>
									<option value="<%= cursoResult.get(i).toString()%>"><%= cursoResult.get(i).toString()%></option>
									<% } %>
									
									
								</select>
							</div>
							<button type="submit" class="btn btn-danger w-100">Eliminar curso</button>
						</form>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>