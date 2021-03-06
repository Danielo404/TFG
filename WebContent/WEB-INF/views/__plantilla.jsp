<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Models.moduloModel" %>
<%@ page import="java.util.ArrayList" %>

<%
	ArrayList<moduloModel> moduloResult = (ArrayList<moduloModel>) session.getAttribute("moduloResult");
%>

    <jsp:include page="shared/_header.jsp">
    <jsp:param name="tituloPagina" value="Acerca de"/>
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
                <h1 class="h3 mb-4 text-gray-800">Mis módulos</h1>
                
                <ul>
                	<%
                		for(int i=0; i<moduloResult.size();i++)
                		{
                			
                	%>
                	<li><%= moduloResult.get(i).getNombre() %>
                	<ul>
                		<li><%= moduloResult.get(i).getSiglas() %></li>
                		<li><%= moduloResult.get(i).getnHoras() %></li>
                	</ul>
                	</li>
                	<%
                		}
                	%>
                </ul>

            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->
            <jsp:include page="shared/_footer.jsp"></jsp:include>