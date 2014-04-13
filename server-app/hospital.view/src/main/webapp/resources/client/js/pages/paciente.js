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
			generic.loading();
			server.get('paciente', idPaciente, paciente.recuperarCallback);
		}
		else{
			generic.noLoading();
		}
	},
	
	'recuperarCallback' : function(paciente){
		generic.noLoading();
		if (paciente != null){
			$("#txtNumIdentificacion").val(paciente.numeroIdentificacion);
			$("#txtNombre").val(paciente.nombre != null ? paciente.nombre : "");
			$("#txtApellidos").val(paciente.apellidos != null ? paciente.apellidos : "");
			$("#txtTelefono").val(paciente.telefono != null ? paciente.telefono : "");
			$("#txtFechaNacimiento").val(paciente.fechaNacimiento != null ? paciente.fechaNacimiento : "");
			$("#txtNumIdentificacion").val(paciente.numeroIdentificacion != null ? paciente.numeroIdentificacion : "");
			if (paciente.sexo != null){
				$("#cmbSexo option[value=" + paciente.sexo + "]").attr("selected", true).change();
			}
			if (paciente.escolarizacion != null){
				$("#cmbEscolarizacion option[value=" + paciente.escolarizacion + "]").attr("selected", true).change();
			}
			
			$("#txtCurso").val(paciente.curso != null ? paciente.curso : "");
			
		}
		/*
		apellidos: "Pérez Llamazares"
			curso: "1"
			escolarizacion: "Educacion especial"
			examinador: "Pablo Montagud"
			fechaEvaluacion: "08/03/2010"
			fechaNacimiento: "21/01/2008"
			fichero: null
			id: 2
			nombre: "Alfonso"
			numeroIdentificacion: "000002"
			sexo: "Hombre"
			telefono: null
			*/
	}
};