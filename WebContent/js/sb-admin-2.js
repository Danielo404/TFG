(function($) {
  "use strict"; // Start of use strict

  
  
  $(document).ready(function(){
	  console.log("inicio");
	  $("select#tutoriza option[value='No']").attr("selected", true);
	  if($("#tutoriza").val() == "No" )
	  {
	  console.log("Entra en no");
	  $("#grupo").prop("disabled", true);
	  }
	  $("select#tutoriza").change(function(){
		  console.log("prueba");
		  
		  if($("#tutoriza").val() == "No" )
			  {
			  console.log("Entra en no");
			  $("#grupo").prop("disabled", true);
			  }
		  else{
			  $("#grupo").prop("disabled", false);
		  }
	  })
});
 

})(jQuery); // End of use strict

function eliminarAlumnoAdmin(dni){
	  if(confirm("¿Estás seguro de que desea eliminarlo?")){
		  location.replace("borrarAlumno?dni=" + dni )
	  }
}

function eliminarProfesorAdmin(codigo){
	  if(confirm("¿Estás seguro de que desea eliminarlo?")){
		  location.replace("borrarProfesor?codigo=" + codigo )
	  }
}

function eliminarCursoAdmin(){
	var form= document.getElementById("formCurso");
	if(confirm("¿Desea eliminar el curso?")){
		if(confirm("¿Seguro?")){
			form.submit();
		}
	}
}


