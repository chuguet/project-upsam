define(["../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"], function($) {
	generic.initialize();
	paciente.recuperar();
});

var paciente = {
	'buscarListado' : function(){
		generic.loading();
		var searchParameters = {param : $("#txtBusqueda").val()};
		server.get('pacientemovil', searchParameters, paciente.buscarListadoCallback);
	},
	'buscarListadoCallback' : function(listaItems){
		$("#listaPacientes li").remove();
		for (var i = 0; i < listaItems.length; i++){
			var li = $("<li></li>");
			var a = $("<a rel='external' alt='Acceder al paciente' href='#' data-transition='fade'>" + listaItems[i].nombre + "&nbsp;" + listaItems[i].apellidos + " [N&deg; ident:" + listaItems[i].numeroIdentificacion + "]<br/><span class='videoFeatures'>Fecha Nacimiento: " + listaItems[i].fechaNacimiento + "&nbsp;|&nbsp;Fecha &uacute;ltima evaluaci&oacute;n: " + listaItems[i].fechaUltimaEvaluacion + "</span></a>");
			var params = { id : listaItems[i].id };
			a.click(function() {
				generic.changePage("paciente.html", params);
			});
			li.append(a);
			$("#listaPacientes").append(li);
		}
		$("#listaPacientes").listview('refresh');
		generic.noLoading();
	},
	
	'recuperar' : function(){
		var idPaciente = generic.getURLParameter("id");
		if (idPaciente != null){
			//Entramos en modo edicion
			generic.loading();
			$("#subtitle").html("Consulta de Paciente");
			server.get('paciente', idPaciente, paciente.recuperarCallback);
			$("#exploraciones").show();
		}
		else{
			//Entramos en modo alta
			$("#subtitle").html("Alta de Paciente");
			$("#exploraciones").hide();
			generic.noLoading();
		}
	},
	
	'recuperarCallback' : function(paciente){
		generic.noLoading();
		if (paciente != null){
			$("#txtNumIdentificacion").val(paciente.numeroIdentificacion != null ? paciente.numeroIdentificacion : "");
			$("#txtNombre").val(paciente.nombre != null ? paciente.nombre : "");
			$("#txtApellidos").val(paciente.apellidos != null ? paciente.apellidos : "");
			$("#txtTelefono").val(paciente.telefono != null ? paciente.telefono : "");
			$("#txtFechaNacimiento").val(paciente.fechaNacimiento != null ? paciente.fechaNacimiento : "");
			if (paciente.sexo != null){
				$("#cmbSexo option[value=" + paciente.sexo + "]").attr("selected", true).change();
			}
			if (paciente.escolarizacion != null){
				$("#cmbEscolarizacion option[value=" + paciente.escolarizacion + "]").attr("selected", true).change();
			}
			
			$("#txtCurso").val(paciente.curso != null ? paciente.curso : "");
			
		}
	},
	
	'insertar' : function(){
		var pacienteDTO = paciente.recogerCamposDePantalla();
		if (pacienteDTO != null){
			generic.loading();
			server.post("paciente", pacienteDTO, paciente.insertarCallback);
		}
	},
	
	'insertarCallback' : function(params){
		$("#exploraciones").show();
		$("#listaExploraciones").hide();
		generic.noLoading();
	},
	
	'recogerCamposDePantalla' : function(){
		var pacienteDTO = {
			numeroIdentificacion : $("#txtNumIdentificacion").val(),
			nombre : $("#txtNombre").val(),
			apellidos : $("#txtApellidos").val(),
			telefono : $("#txtTelefono").val(),
			fechaNacimiento : $("#txtFechaNacimiento").val(),
			sexo : $("#cmbSexo").val(),
			escolarizacion : $("#cmbEscolarizacion").val(),
			curso : $("#txtCurso").val()
		};
		var errores = "";
		if (pacienteDTO.numeroIdentificacion == ""){
			errores += " - Debe introducir el n&uacute;mero de identificaci&oacute;n<br/>";
		}
		if (pacienteDTO.nombre == ""){
			errores += " - Debe introducir el nombre<br/>";
		}
		if (pacienteDTO.apellidos == ""){
			errores += " - Debe introducir los apellidos<br/>";
		}
		if (errores != ""){
			errores = "Se han producido los siguientes errores:<br/>" + errores;
			generic.alert("Error gestión de pacientes", errores, null);
			return null;
		}
		return pacienteDTO;
	}
};