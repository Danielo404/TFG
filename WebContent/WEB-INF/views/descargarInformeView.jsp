<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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
			<h1 class="h3 mb-4 text-gray-800"></h1>

			<div class="container">
				<div class="row justify-content-center">
					<h3>Su informe se ha generado con éxito</h3>
				</div>
				<div class="row justify-content-center">
					<div class="col-lg-4">
						<a href="/TFG/pdf/<%= (String)session.getAttribute("fichero") %>.pdf" class="btn btn-primary w-100" download="informe_<%= (String)session.getAttribute("fichero") %>"
							>Descargar
							Informe</a>
					</div>
				</div>
			</div>

		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>