<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<% HttpSession sesion = request.getSession(); %>

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
			<h1 class="h3 mb-4 text-gray-800">Añadir alumno</h1>
			<div class="container">
				<form method="POST">
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">DNI</div>
      </div> 
      <input id="pdni" name="pdni" placeholder="DNI" type="text" required="required" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Nombre</div>
      </div> 
      <input id="pNombre" name="pNombre" type="text" required="required" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Apellidos</div>
      </div> 
      <input id="pApellidos" name="pApellidos" type="text" required="required" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label>Repetidor</label> 
    <div>
      <div class="custom-controls-stacked">
        <div class="custom-control custom-radio">
          <input name="pRepetidor" id="pRepetidor_0" type="radio" required="required" class="custom-control-input" value="Si"> 
          <label for="pRepetidor_0" class="custom-control-label">Si</label>
        </div>
      </div>
      <div class="custom-controls-stacked">
        <div class="custom-control custom-radio">
          <input name="pRepetidor" id="pRepetidor_1" type="radio" required="required" class="custom-control-input" value="No"> 
          <label for="pRepetidor_1" class="custom-control-label">No</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label for="pCurso">Curso</label> 
    <select id="pCurso" name="pCurso" required="required" class="custom-select">
        <option value="2020/21">2020/21</option>
        <option value="2021/22">2021/22</option>
        </select>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Fecha de Nacimiento</div>
      </div> 
      <input id="pFechaNacimiento" name="pFechaNacimiento" placeholder="dd/mm/aaaa" type="text" required="required" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Localidad</div>
      </div> 
      <input id="pLocalidad" name="pLocalidad" type="text" required="required" class="form-control">
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
        <option value="1º DAW">1 DAW</option>
        <option value="2º DAW">2 DAW</option>
        <option value="1º DAM">1 DAM</option>
        <option value="2º DAM">2 DAM</option>
        <option value="1º ASIR">1 ASIR</option>
        <option value="2º ASIR">2 ASIR</option>
        <option value="1º GA">1 GA</option>
        <option value="2º GA">2 GA</option>
        <option value="1º IEA">1 IEA</option>
        <option value="2º IEA">2 IEA</option>
        <option value="1º IT">1 IT</option>
        <option value="2º IT">2 IT</option>
        <option value="1º AF">1 AF</option>
        <option value="2º AF">2 AF</option>
        <option value="1º STI">1 STI</option>
        <option value="2º STI">2 STI</option>
      </select>
    </div> 
    </div>
  </div>
  <div class="form-group">
    <label for="pCicloEstudiar">¿Es este el curso que querías estudiar? En el caso de que sea no, especifica cual quería estudiar.</label> 
    <textarea id="pCicloEstudiar" name="pCicloEstudiar" cols="40" rows="3" required="required" class="form-control"></textarea>
  </div>
  <div class="form-group">
    <label for="pFechaIncorporacion"></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Fecha de Incorporación</div>
      </div> 
      <input id="pFechaIncorporacion" name="pFechaIncorporacion" placeholder="dd/mm/aa" type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Método de Trasnporte</div>
      </div> 
      <input id="pMedioTransporte" name="pMedioTransporte" type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">Procedencia</div>
      </div> 
      <input id="pProcedencia" name="pProcedencia" type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label for="pEstudiosPrevios">Estudios Previos</label> 
    <textarea id="pEstudiosPrevios" name="pEstudiosPrevios" cols="40" rows="3" class="form-control"></textarea>
  </div>
  <div class="form-group">
    <label>Portátil</label> 
    <div>
      <div class="custom-controls-stacked">
        <div class="custom-control custom-radio">
          <input name="pPortatil" id="pPortatil_0" type="radio" class="custom-control-input" value="Si"> 
          <label for="pPortatil_0" class="custom-control-label">Si</label>
        </div>
      </div>
      <div class="custom-controls-stacked">
        <div class="custom-control custom-radio">
          <input name="pPortatil" id="pPortatil_1" type="radio" class="custom-control-input" value="No"> 
          <label for="pPortatil_1" class="custom-control-label">No</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label></label> 
    <div class="input-group">
      <div class="input-group-prepend">
        <div class="input-group-text">MAC Portatil</div>
      </div> 
      <input id="pMACPortatil" name="pMACPortatil" type="text" class="form-control">
    </div>
  </div>
  <div class="form-group">
    <label for="pIngles">Nivel de Inglés</label> 
    <div>
      <select id="pIngles" name="pIngles" class="custom-select">
        <option value="C2">C2</option>
        <option value="C1">C1</option>
        <option value="B2">B2</option>
        <option value="B1">B1</option>
        <option value="A2">A2</option>
        <option value="A1">A1</option>
        <option value="No tiene">No tiene</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <label>Erasmus</label> 
    <div>
      <div class="custom-controls-stacked">
        <div class="custom-control custom-radio">
          <input name="pErasmus" id="pErasmus_0" type="radio" class="custom-control-input" value="Si"> 
          <label for="pErasmus_0" class="custom-control-label">Si</label>
        </div>
      </div>
      <div class="custom-controls-stacked">
        <div class="custom-control custom-radio">
          <input name="pErasmus" id="pErasmus_1" type="radio" class="custom-control-input" value="No"> 
          <label for="pErasmus_1" class="custom-control-label">No</label>
        </div>
      </div>
    </div>
  </div>
  <div class="form-group">
    <label for="pExperienciaLaboral">Experiencia Laboral</label> 
    <textarea id="pExperienciaLaboral" name="pExperienciaLaboral" cols="40" rows="3" class="form-control"></textarea>
  </div>
  <div class="form-group">
    <label for="pObservaciones">Observaciones</label> 
    <textarea id="pObservaciones" name="pObservaciones" cols="40" rows="3" class="form-control"></textarea>
  </div> 
  <div class="form-group">
    <button name="submit" type="submit" class="btn btn-primary w-100">Añadir Alumno</button>
  </div>
</form>
			</div>


		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- End of Main Content -->
	<jsp:include page="shared/_footer.jsp"></jsp:include>