function validarFormularioRegistroAnuncioCliente(){

	
	alert("se ejecuta la funcion");
	var enviarForm = true;
	//obtener los datos del formulario (usuario)
	var campoTitulo = document.getElementsByName("campoTitulo")[0];
	var titulo = campoTitulo.value;
	
	var campoPrecio = document.getElementsByName("campoPrecio")[0];
	var precio = campoPrecio.value;
	
	var campoDescripcion = document.getElementsByName("campoDescripcion")[0];
	var descripcion = campoDescripcion.value;
	
	var campoEmail = document.getElementsByName("campoEmail")[0];
	var email = campoEmail.value;
	
	var campoTelefono = document.getElementsByName("campoTelefono")[0];
	var telefono = campoTelefono.value;
	
	//comprobar que sea correcto
	//las expresiones regulares son vitales para realizar validaciones
	//^ desde el principio
	//$ hasta el fin
	//[a-z] indica todas las letras de la a a la z
	//{3,10} de 3 a 10 elementos
	//i (insensitive) identifica tanto mayusculas como minusculas
	// \s   permite espacios en blanco
	//
	
	var expresionCampoNombre = /^[a-záéíóúñ\s]{3,10}$/i;
	var expresionCampoPrecio = /^[0-9]{1,8}[.,]?[0-9]{0,2}$/;
	var expresionCampoTextArea = /^[a-záéíóúñ\s]{40,400}$/i;
	
	if(expresionCampoNombre.test(titulo)){
		alert("nombre ok");
	}else{
		alert("nombre incorrecto");
		enviarForm = false;
	}
	
	if(expresionCampoPrecio.test(precio)){
		alert("precio ok");
	}else{
		alert("precio incorrecto");
		enviarForm = false;
	}
	
	if(expresionCampoTextArea.test(descripcion)){
		alert("descripcion ok");
	}else{
		alert("descripcion incorrecto");
		enviarForm = false;
	}
	
	
	//devolver true si todo esta bien
	
	
	//devolver false si algo esta mal
	return enviarForm;
	

}//end function