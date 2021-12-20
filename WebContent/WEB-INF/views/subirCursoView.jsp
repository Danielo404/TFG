<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.moduloModel"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<moduloModel> moduloResult = (ArrayList<moduloModel>) session.getAttribute("moduloResult");
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
			<h1 class="h3 mb-4 text-gray-800">Subir curso</h1>

			<form class="w-100 justify-content-center" action="subirCurso"
				method="post" enctype="multipart/form-data">
				<div class="container mt-5">
					<div class="row">
						<div class="col-8">
							<input class="w-100" type=file size=60 name="file"
								value="Examinar"><br>
							<br>
						</div>
						<div class="col-4">
							<input class="btn bg-Urban-1 text-center btn-primary  p-3 w-100"
								type=submit value="Subir"><br>
						</div>
					</div>
				</div>



			</form>

		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>