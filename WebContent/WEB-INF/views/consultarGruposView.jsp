<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Models.grupoModel" %>

<%
	ArrayList<grupoModel> grupos = (ArrayList<grupoModel>) session.getAttribute("grupos");
%>
    <jsp:include page="shared/_header.jsp">
    <jsp:param name="tituloPagina" value="Grupos"/>
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
                <h1 class="h3 mb-4 text-gray-800">Grupos</h1>
                
                <div class="row justify-content-around">
			<% for(int i = 0; i<grupos.size();i++){ %>
			<div class="col-lg-4">
				<div class="card p-3" style="width: 100%!important;">
					<img class="card-img-top w-100" src="/TFG/img/grupomodulo.jpg" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title text-center">Grupo <%= grupos.get(i).getCodigo() %></h5>
						<p class="card-text"><%= grupos.get(i).getNombre()%></p>
						<a href="consultarAlumnado?idModulo=<%= (String)session.getAttribute("auxidModulo") %>&grupo=<%= grupos.get(i).getCodigo() %>"class="btn btn-primary w-100">Ver grupo...</a>
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