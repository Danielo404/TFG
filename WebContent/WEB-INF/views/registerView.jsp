<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%
	ArrayList<String> gruposResult = (ArrayList<String>) session.getAttribute("gruposResult");
%>

<!DOCTYPE html>
<html lang="es">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Registro</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/sb-admin-2.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Dar de alta</h1>
							</div>
							<form class="user" method="POST">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" placeholder="Nombre" name="pNombre"
											required>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" placeholder="Apellidos"
											name="pApellidos" required>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											id="exampleFirstName" placeholder="C??digo" name="pCodigo"
											required>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											id="exampleLastName" placeholder="DNI" name="pDni" required>
									</div>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										id="exampleInputEmail" placeholder="Correo electr??nico"
										name="pEmail" required>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											id="exampleInputPassword" placeholder="Contrase??a"
											name="pPassword" required>
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											id="exampleRepeatPassword" placeholder="Repetir contrase??a"
											name="pRePaswword" required>
									</div>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<div class="form-group">
											<label for="pTutoriza">Tutoriza</label>
											<div>
												<select id="tutoriza" name="pTutoriza" required="required"
													class="custom-select">
													<option value="S??">S??</option>
													<option value="No">No</option>
												</select>
											</div>
										</div>
									</div>
									<div class="col-sm-6">
										<label for="pGrupo">Grupos</label> <select id="grupo"
											name="pGrupo" class="custom-select">
											<%
												for (int i = 0; i < gruposResult.size(); i++) {
											%>
											<option value="<%=gruposResult.get(i).toString()%>"><%=gruposResult.get(i).toString()%></option>
											<%
												}
											%>
										</select>

									</div>
								</div>
								<button type="submit" class="btn btn-primary btn-user btn-block">
									Dar de alta</button>
							</form>
							<hr>
							
							<div class="text-center">
								<a class="small" href="login">??Est??s dado de alta?
									??Inicia sesi??n!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/TFG/js/sb-admin-2.min.js"></script>
	

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.js"></script>

</body>

</html>