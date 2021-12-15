<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.notificacionModel"%>
<%@ page import="java.util.ArrayList"%>

<%
	ArrayList<notificacionModel> notificacionResult = (ArrayList<notificacionModel>) session
			.getAttribute("notificacionResult");
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
			<h1 class="h3 mb-4 text-gray-800">Mis notificaciones</h1>

			<%
				if (notificacionResult.size() > 0) {
			%>
			<div class="accordion" id="accordionNotificacion">
			<%
				for (int i = 0; i < notificacionResult.size(); i++) {
			%>

			
				<div class="card mt-3">
					<div class="card-header acordeonfondo" id="heading_id_<%=notificacionResult.get(i).getIdNotificacion() %>">
						<h2 class="mb-0">
							<button class="btn btn-link btn-block text-center text-white" type="button"
								data-toggle="collapse" data-target="#id_<%=notificacionResult.get(i).getIdNotificacion() %>"
								aria-expanded="true" aria-controls="id_<%=notificacionResult.get(i).getIdNotificacion() %>">
								<%=notificacionResult.get(i).getFecha() %> - <%=notificacionResult.get(i).getTitulo() %> - <%=notificacionResult.get(i).getEmisor() %>
								</button>
						</h2>
					</div>

					<div id="id_<%=notificacionResult.get(i).getIdNotificacion() %>" class="collapse"
						aria-labelledby="heading_id_<%=notificacionResult.get(i).getIdNotificacion() %>" data-parent="#accordionNotificacion">
						<div class="card-body text-justify">
						<%=notificacionResult.get(i).getTexto() %></div>
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