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
			<h1 class="h3 mb-4 text-gray-800">Cambiar contraseña</h1>
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-6">
						<div class="row">
							<div class="col-lg-12">
								<form method="POST">
									<div class="row">
										<div class="col-lg-6" name="">
											<div class="form-group">
												<label for="">Nueva contraseña:</label> <input id="" name="password"
													type="password" class="form-control">
											</div>
										</div>
										<div class="col-lg-6" name="">
											<div class="form-group">
												<label for="">Confirmar contraseña:</label> <input id=""
													name="pPassword" type="password" class="form-control">
											</div>
										</div>
									</div>
									
									<div class="row">
										<button class="btn btn-primary w-100 p-2" type="submit">Cambiar contraseña</button>
									</div>
								</form>
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