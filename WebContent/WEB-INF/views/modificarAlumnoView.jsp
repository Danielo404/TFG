<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="Models.alumnoModel" %>
<% alumnoModel alumnoResult = (alumnoModel)session.getAttribute("alumnoResult");%>
<% final String[] selectListGrupo = new String[]{"1º DAW", "2º DAW", "1º DAM", "2º DAM", "1º ASIR", "2º ASIR", "1º GA", "2º GA", "1º IEA", "2º IEA", "1º IT", "2º IT", "1º AF", "2º AF", "1º STI", "2º STI"}; %>
<% final String[] selectListRepetidor = new String[]{"Si", "No"}; %>
<% final String[] selectListCurso = new String[]{"2020/21", "2021/22"}; %>
<% final String[] selectListPortatil = new String[]{"Si", "No"}; %>
<% final String[] selectListNivelIngles = new String[]{"C2", "C1", "B2", "B1", "A2", "A1", "No tiene"}; %>
<% final String[] selectListErasmus = new String[]{"Si", "No"}; %>

<jsp:include page="shared/_header.jsp">
	<jsp:param name="tituloPagina" value="Acerca de" />
</jsp:include>
<jsp:include page="shared/_aside.jsp"></jsp:include>
<!-- Content Wrapper -->
<div id="content-wrapper" class="d-flex flex-column">

	<!-- Main Content -->
	<div id="content">
		<jsp:include page="shared/_nav.jsp">
			<jsp:param name="nombreProfesor" value="pepe" />
		</jsp:include>
		<!-- Begin Page Content -->
		<div class="container-fluid">

			<!-- Page Heading -->
			<h1 class="h3 mb-4 text-gray-800">Modificar alumno</h1>
			<div class="container">
				<form method="POST">
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">DNI</div>
      </div> 
      <input id="pdni" name="pdni" placeholder="DNI" type="text" required="required" class="form-control" value="<%= alumnoResult.getDni() %>">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Nombre</div>
      </div> 
      <input id="pNombre" name="pNombre" type="text" required="required" class="form-control" value="<%= alumnoResult.getNombre() %>" >
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Apellidos</div>
      </div> 
      <input id="pApellidos" name="pApellidos" type="text" required="required" class="form-control" value="<%= alumnoResult.getApellidos() %>">
    </div>
  </div>
  <div class="form-group">
    <label>Repetidor</label> 
    <div>
    <% 
	String auxRepetidor;
	if(alumnoResult.isRepetidor() == true){
	auxRepetidor = "Si";
	}else{
	auxRepetidor = "No";
	}
	%>
	<select id="pRepetidor" name="pRepetidor" class="custom-select">
    <% for(String repetidor: selectListRepetidor){ %>
      	<% if(repetidor.equals(auxRepetidor)) { %>
      	<option value="<%= repetidor %>" selected><%= repetidor %></option>
      	<% } else { %>
      		<option value="<%= repetidor %>" selected><%= repetidor %></option>
      		<% } %>
      <% } %>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="pCurso">Curso</label> 
    <select id="pCurso" name="pCurso" required="required" class="custom-select">
        <% for(String curso: selectListCurso){ %>
      	<% if(curso.equals(alumnoResult.getCurso())) { %>
      	<option value="<%= curso %>" selected><%= curso %></option>
      	<% } else { %>
      	<option value="<%= curso %>"><%= curso %></option>
      		<% } %>
      <% } %>
        </select>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Fecha de Nacimiento</div>
      </div> 
      <input id="pFechaNacimiento" name="pFechaNacimiento" placeholder="dd/mm/aaaa" type="text" required="required" class="form-control" value="<%= alumnoResult.getFechaNacimiento() %>">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Localidad</div>
      </div> 
      <input id="pLocalidad" name="pLocalidad" type="text" required="required" class="form-control" value="<%= alumnoResult.getLocalidad() %>">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Grupo</div>
      </div>
      <div>
      <select id="pGrupo" name="pGrupo" required="required" class="custom-select">
      <% for(String grupo: selectListGrupo){ %>
      	<% if(grupo.equals(alumnoResult.getGrupo())) { %>
      	<option value="<%= grupo %>" selected><%= grupo %></option>
      	<% } else { %>
      	<option value="<%= grupo %>"><%= grupo %></option>
      		<% } %>
      <% } %>
      </select>
    </div> 
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Email:</div>
      </div> 
      <input id="pNombre" name="pEmail" type="text" required="required" class="form-control" value="<%= alumnoResult.getEmail() %>" >
    </div>
  </div>
  <div class="form-group">
    <label for="pCicloEstudiar">¿Es este el curso que querías estudiar? En el caso de que sea no, especifica cual quería estudiar.</label> 
    <textarea id="pCicloEstudiar" name="pCicloEstudiar" cols="40" rows="3" required="required" class="form-control"><%= alumnoResult.getCicloEstudiar() %></textarea>
  </div>
  <div class="form-group">
    <label for="pFechaIncorporacion"></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Fecha de Incorporación</div>
      </div> 
      <input id="pFechaIncorporacion" name="pFechaIncorporacion" placeholder="dd/mm/aa" type="text" class="form-control" value="<%= alumnoResult.getFechaIncorporacion() %>">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Método de Trasnporte</div>
      </div> 
      <input id="pMedioTransporte" name="pMedioTransporte" type="text" class="form-control" value="<%= alumnoResult.getMedioTransporte() %>">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Procedencia</div>
      </div> 
      <input id="pProcedencia" name="pProcedencia" type="text" class="form-control" value="<%= alumnoResult.getProcedencia() %>">
    </div>
  </div>
  <div class="form-group">
    <label for="pEstudiosPrevios">Estudios Previos</label> 
    <textarea id="pEstudiosPrevios" name="pEstudiosPrevios" cols="40" rows="3" class="form-control"><%= alumnoResult.getEstudiosPrevios() %></textarea>
  </div>
  <div class="form-group">
    <label>Portátil</label>
    <div>
    <% 
	String auxPortatil;
	if(alumnoResult.isPortatil() == true){
	auxPortatil = "Si";
	}else{
	auxPortatil = "No";
	}
	%>
	<select id="pPortatil" name="pPortatil" class="custom-select">
    <% for(String portatil: selectListPortatil){ %>
      	<% if(portatil.equals(auxPortatil)) { %>
      	<option value="<%= portatil %>" selected><%= portatil %></option>
      	<% } else { %>
      		<option value="<%= portatil %>" ><%= portatil %></option>
      		<% } %>
      <% } %>
      </select>
      </div> 
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">MAC Portatil</div>
      </div> 
      <input id="pMACPortatil" name="pMACPortatil" type="text" class="form-control" value="<%= alumnoResult.getMacPortatil() %>">
    </div>
  </div>
  <div class="form-group">
    <label for="pIngles">Nivel de Inglés</label> 
    <div>
      <select id="pIngles" name="pIngles" class="custom-select">
        <% for(String nivelIngles: selectListNivelIngles){ %>
      	<% if(nivelIngles.equals(alumnoResult.getNivelIngles())) { %>
      	<option value="<%= nivelIngles %>" selected><%= nivelIngles %></option>
      	<% } else { %>
      	<option value="<%= nivelIngles %>"><%= nivelIngles %></option>
      		<% } %>
      <% } %>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label>Erasmus</label> 
    <div>
      <% 
	String auxErasmus;
	if(alumnoResult.isErasmus() == true){
	auxErasmus = "Si";
	}else{
	auxErasmus = "No";
	}
	%>
	<select id="pErasmus" name="pErasmus" class="custom-select">
    <% for(String erasmus: selectListErasmus){ %>
      	<% if(erasmus.equals(auxErasmus)) { %>
      	<option value="<%= erasmus %>" selected><%= erasmus %></option>
      	<% } else { %>
      		<option value="<%= erasmus %>"><%= erasmus %></option>
      		<% } %>
      <% } %>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label for="pExperienciaLaboral">Experiencia Laboral</label> 
    <textarea id="pExperienciaLaboral" name="pExperienciaLaboral" cols="40" rows="3" class="form-control" value=""><%= alumnoResult.getExpLaboral() %></textarea>
  </div>
  <div class="form-group">
    <label for="pObservaciones">Observaciones</label> 
    <textarea id="pObservaciones" name="pObservaciones" cols="40" rows="3" class="form-control" value=""><%= alumnoResult.getObservaciones() %></textarea>
  </div> 
  <div class="form-group">
    <button name="submit" type="submit" class="btn btn-primary w-100">Guardar</button>
  </div>
</form>
			</div>


		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>