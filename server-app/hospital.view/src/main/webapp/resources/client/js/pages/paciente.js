define([
		"../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"
], function($) {
	generic.initialize();
	paciente.recuperar();
});

var paciente = {
	'buscarListado' : function() {
		generic.loading();
		var searchParameters = {
			param : $("#txtBusqueda").val()
		};
		server.get('pacientemovil', searchParameters, paciente.buscarListadoCallback);
	},
	'buscarListadoCallback' : function(listaItems) {
		$("#listaPacientes li").remove();
		for(var i = 0; i < listaItems.length; i++) {
			var li = $("<li><a rel='external' alt='Acceder al paciente' href='paciente.html?id=" + listaItems[i].id + "' data-transition='fade'>" + listaItems[i].nombre + "&nbsp;" + listaItems[i].apellidos + " [N&deg; ident:" + listaItems[i].numeroIdentificacion + "]<br/><span class='videoFeatures'>Fecha Nacimiento: " + listaItems[i].fechaNacimiento
					+ "&nbsp;|&nbsp;Fecha &uacute;ltima evaluaci&oacute;n: " + listaItems[i].fechaUltimaEvaluacion + "</span></a></li>");
			$("#listaPacientes").append(li);
		}
		$("#listaPacientes").listview('refresh');
		generic.noLoading();
	},

	'recuperar' : function() {
		var idPaciente = generic.getURLParameter("id");
		if (idPaciente != null) {
			// Entramos en modo edicion
			generic.loading();
			$("#subtitle").html("Consulta de Paciente");
			server.get('pacientemovil/' + idPaciente, null , paciente.recuperarCallback);
			server.get('pacientemovil/' + idPaciente + "/exploracion", null, paciente.recuperarExploracionesCallback);
			$("#exploraciones").show();
		}
		else {
			// Entramos en modo alta
			$("#subtitle").html("Alta de Paciente");
			$("#exploraciones").hide();
			generic.noLoading();
		}
	},

	'recuperarCallback' : function(paciente) {
		if (paciente != null) {
			$("#idPaciente").val(paciente.id != null ? paciente.id : "");
			$("#txtNumIdentificacion").val(paciente.numeroIdentificacion != null ? paciente.numeroIdentificacion : "");
			$("#txtNombre").val(paciente.nombre != null ? paciente.nombre : "");
			$("#txtApellidos").val(paciente.apellidos != null ? paciente.apellidos : "");
			$("#txtTelefono").val(paciente.telefono != null ? paciente.telefono : "");
			$("#txtFechaNacimiento").val(paciente.fechaNacimiento != null ? paciente.fechaNacimiento : "");
			if (paciente.sexo != null) {
				$("#cmbSexo option[value=" + paciente.sexo + "]").attr("selected", true).change();
			}
			if (paciente.escolarizacion != null) {
				$("#cmbEscolarizacion option[value=" + paciente.escolarizacion + "]").attr("selected", true).change();
			}

			$("#txtCurso").val(paciente.curso != null ? paciente.curso : "");
		}
		generic.noLoading();
	},
	
	'recuperarExploracionesCallback' : function(exploraciones) {
		console.log("recuperadas exploraciones de paciente");
		if (exploraciones != null && exploraciones.length > 0) {
			for(var i = 0; i < exploraciones.length; i++) {
				var exploracion = exploraciones[i];
				var cont = i + 1;
				$("#listaExploraciones").append("<li><a rel='external' href='#' onclick='javascript:paciente.irAExploracion(" + exploracion.id + ", " + cont + ");' data-transition='fade'>Exploraci&oacute;n " + cont + "<br><span class='videoFeatures'>" + exploracion.fecha + "&nbsp;|&nbsp;" + exploracion.nombreUsuario + "</span></a></li>");
			}
			$("#listaExploraciones").listview('refresh');
			$("#listaExploraciones").show();
		}
	},

	'insertar' : function() {
		var pacienteMovilDTO = paciente.recogerCamposDePantalla();
		if (pacienteMovilDTO != null) {
			generic.loading();
			if (pacienteMovilDTO.id == null) {
				// insert
				server.post("pacientemovil", pacienteMovilDTO, paciente.insertarCallback);
			}
			else {
				// update
				server.post("pacientemovil/" + pacienteMovilDTO.id, pacienteMovilDTO, paciente.actualizarCallback);
			}
		}
	},

	'insertarCallback' : function(params) {
		$("#exploraciones").show();
		$("#listaExploraciones").hide();
		$("#subtitle").html("Consulta de Paciente");
		$("#idPaciente").val(params.parameter.id);
		generic.noLoading();
	},

	'actualizarCallback' : function(params) {
		generic.noLoading();
	},

	'recogerCamposDePantalla' : function() {
		var idPaciente = $("#idPaciente").val() != "" ? $("#idPaciente").val() : null;
		var pacienteMovilDTO = {
			id : idPaciente,
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
		if (pacienteMovilDTO.numeroIdentificacion == "") {
			errores += " - Debe introducir el n&uacute;mero de identificaci&oacute;n<br/>";
		}
		if (pacienteMovilDTO.nombre == "") {
			errores += " - Debe introducir el nombre<br/>";
		}
		if (pacienteMovilDTO.apellidos == "") {
			errores += " - Debe introducir los apellidos<br/>";
		}
		if (errores != "") {
			errores = "Se han producido los siguientes errores:<br/>" + errores;
			generic.alert("Error gestión de pacientes", errores, null);
			return null;
		}
		return pacienteMovilDTO;
	},

	'irAExploracion' : function(idExploracion, num) {
		var params = {};
		if (idExploracion) {
			params = {
				'idPaciente' : $("#idPaciente").val(),
				'idExploracion' : idExploracion,
				'num' : num
			};
		}
		else {
			params = {
				'idPaciente' : $("#idPaciente").val()
			};
		}
		generic.changePage("exploracion_fisica.html", params);
	}
};