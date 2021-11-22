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
			<h1 class="h3 mb-4 text-gray-800">Módulos de <%=(String)session.getAttribute("grupoTutorizaProfesor") %></h1>

			<div class="row">
			<% for(int i = 0; i<moduloResult.size();i++){ %>
			<div class="col-lg-4">
				<div class="card p-3" style="width: 100%!important;">
					<img class="card-img-top w-100" src="/TFG/img/modulo1.jpg" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title"><%= moduloResult.get(i).getNombre() %></h5>
						<a href="consultarAlumnado?idModulo=<%= moduloResult.get(i).getId() %>&grupo=<%=(String)session.getAttribute("grupoTutorizaProfesor") %>" class="btn btn-primary w-100">Ver alumnos...</a>
					</div>
				</div>
				</div>
				<%} %>
			</div>
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>