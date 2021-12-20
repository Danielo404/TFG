<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ page import="Models.moduloModel" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<moduloModel> moduloResult = (ArrayList<moduloModel>) session.getAttribute("moduloResult");
%>

<jsp:include page="shared/_header.jsp">
	<jsp:param name="tituloPagina" value="" />
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
			<h1 class="h3 mb-4 text-gray-800">Inicio</h1>

			<div class="row">
			<% if(moduloResult.get(0).getId() != 0){ %>
			<% for(int i = 0; i<moduloResult.size();i++){ %>
			<div class="col-lg-4">
				<div class="card p-3" style="width: 100%!important;">
					<img class="card-img-top w-100" src="/TFG/img/mod_<%= moduloResult.get(i).getId()%>.jpg" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%= moduloResult.get(i).getSiglas() %></h5>
						<p class="card-text"><%= moduloResult.get(i).getNombre()%></p>
						<a href="consultarGrupo?idModulo=<%= moduloResult.get(i).getId() %>" class="btn btn-primary w-100">Ver grupo...</a>
					</div>
				</div>
				</div>
				<%} %>
				<%} %>
			</div>
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>