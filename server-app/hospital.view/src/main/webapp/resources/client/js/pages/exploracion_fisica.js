define(["../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"], function($) {
	generic.initialize();
	exploracionFisica.recuperar();
});

var exploracionFisica = {
	'recuperar' : function(){
		var idPaciente = generic.getURLParameter("idPaciente");
		var idExploracion = generic.getURLParameter("idExploracion");
		$("#idPaciente").val(idPaciente);
		if (idExploracion != null){
			//Entramos en modo edicion
			generic.loading();
			$("#subtitle").html("Consulta de Exploraci&oacute;n");
			server.get('paciente/' + idPaciente + "/exploracion/", idExploracion, exploracionFisica.recuperarCallback);
			$("#videos").show();
		}
		else{
			//Entramos en modo alta
			$("#subtitle").html("Nueva Exploraci&oacute;n");
			$("#videos").hide();
			generic.noLoading();
		}
	},
	
	'recuperarCallback' : function(exploracion){
		if (exploracion != null){
			$("#idPaciente").val(paciente.id != null ? paciente.id : "");
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
			
			if (paciente.exploraciones != null && paciente.exploraciones.length > 0){
				for (var i = 0; i < paciente.exploraciones.length; i++){
					var exploracion = paciente.exploraciones[i];
					var cont = i + 1;
					$("#listaExploraciones").append("<li><a rel='external' href='#' onclick='javascript:paciente.irAExploracion(" + exploracion.id + ", " + cont + ");' data-transition='fade'>Exploraci&oacute;n " + cont + "<br><span class='videoFeatures'>" + exploracion.fecha + "&nbsp;|&nbsp;" + exploracion.nombreUsuario + "</span></a></li>");
				}
				$("#listaExploraciones").listview('refresh');
				$("#listaExploraciones").show();
			}
		}
		generic.noLoading();
	},
};
