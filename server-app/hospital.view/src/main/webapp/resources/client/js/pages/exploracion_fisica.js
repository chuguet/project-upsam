define([
		"../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"
], function($) {
	generic.initialize();
	exploracionFisica.recuperar();
});
var exploracionFisica = {
	'recuperar' : function(){
		var idPaciente = generic.getURLParameter("idPaciente");
		var idExploracion = generic.getURLParameter("idExploracion");
		$("#idPaciente").val(idPaciente);
		server.get('pacientemovil/' + idPaciente, null, exploracionFisica.recuperarPacienteCallback);
		if (idExploracion != null){
			$("#idExploracion").val(idExploracion);
			//Entramos en modo edicion
			generic.loading();
			$("#subtitle").html("Consulta de Exploraci&oacute;n");
			server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion, null, exploracionFisica.recuperarCallback);
			$("#listaVideos").show();
		}
		else{
			//Entramos en modo alta
			$("#subtitle").html("Nueva Exploraci&oacute;n");
			$("#lblFechaExploracion").html(generic.getActualDate());
			$("#listaVideos").hide();
			generic.noLoading();
		}
	},
	
	'recuperarPacienteCallback' : function(paciente){
		var nombreCompleto = paciente.nombre;
		if (paciente.apellidos != null){
			nombreCompleto += "&nbsp;" + paciente.apellidos;
		}
		$("#lblNombrePaciente").html(nombreCompleto);
		
		var usuario = generic.getObject("usuario");
		
		
		$("#lblNombreUsuario").html(usuario.nombre + " " + usuario.apellidos);
	},
	
	'recuperarCallback' : function(exploracion){
		if (exploracion != null){
			if (exploracion.fecha != null){
				$("#lblFechaExploracion").html(exploracion.fecha);
			}
			if (exploracion.fechaActualizacion != null){
				$("#lblFechaActualizacion").html(exploracion.fechaActualizacion);
			}
			
			if (exploracion.nombreUsuario != null){
				$("#lblNombreUsuario").html(exploracion.nombreUsuario);
			}
			
			if (exploracion.controlMotorSelectivo != null){
				$("#controlMotorSelectivo option[value=" + exploracion.controlMotorSelectivo + "]").attr("selected", true).change();
			}
			
			if (exploracion.evaluacionMuscular != null){
				$("#evaluacionMuscular option[value=" + exploracion.evaluacionMuscular + "]").attr("selected", true).change();
			}
			
			if (exploracion.longitudMiembroDerecho != null){
				$("#longitudMiembroDerecho").val(exploracion.longitudMiembroDerecho);
				$("#longitudMiembroDerecho").slider( "refresh" );
			}
			
			if (exploracion.longitudMiembroIzquierdo != null){
				$("#longitudMiembroIzquierdo").val(exploracion.longitudMiembroIzquierdo);
				$("#longitudMiembroIzquierdo").slider( "refresh" );
			}
			
			if (exploracion.puntuacion5Metros != null){
				$("#puntuacion5Metros option[value=" + exploracion.puntuacion5Metros + "]").attr("selected", true).change();
			}
			
			if (exploracion.puntuacion50Metros != null){
				$("#puntuacion50Metros option[value=" + exploracion.puntuacion50Metros + "]").attr("selected", true).change();
			}
			
			if (exploracion.puntuacion500Metros != null){
				$("#puntuacion500Metros option[value=" + exploracion.puntuacion500Metros + "]").attr("selected", true).change();
			}
			
			if (exploracion.caderaFlexionIzquierda != null){
				$("#caderaFlexionIzquierda option[value='" + exploracion.caderaFlexionIzquierda + "']").attr("selected", true).change();
			}
			
			if (exploracion.caderaFlexionDerecha != null){
				$("#caderaFlexionDerecha option[value='" + exploracion.caderaFlexionDerecha + "']").attr("selected", true).change();
			}
			
			if (exploracion.caderaInflexionIzquierda != null){
				$("#caderaInflexionIzquierda option[value='" + exploracion.caderaInflexionIzquierda + "']").attr("selected", true).change();
			}
			
			if (exploracion.caderaInflexionDerecha != null){
				$("#caderaInflexionDerecha option[value='" + exploracion.caderaInflexionDerecha + "']").attr("selected", true).change();
			}
			
			if (exploracion.rodillaFlexionIzquierda != null){
				$("#rodillaFlexionIzquierda option[value='" + exploracion.rodillaFlexionIzquierda + "']").attr("selected", true).change();
			}
			
			if (exploracion.rodillaFlexionDerecha != null){
				$("#rodillaFlexionDerecha option[value='" + exploracion.rodillaFlexionDerecha + "']").attr("selected", true).change();
			}
			
			if (exploracion.rodillaInflexionIzquierda != null){
				$("#rodillaInflexionIzquierda option[value='" + exploracion.rodillaInflexionIzquierda + "']").attr("selected", true).change();
			}
			
			if (exploracion.rodillaInflexionDerecha != null){
				$("#rodillaInflexionDerecha option[value='" + exploracion.rodillaInflexionDerecha + "']").attr("selected", true).change();
			}
			
			if (exploracion.tobilloFlexionIzquierda != null){
				$("#tobilloFlexionIzquierda option[value='" + exploracion.tobilloFlexionIzquierda + "']").attr("selected", true).change();
			}
			
			if (exploracion.tobilloFlexionDerecha != null){
				$("#tobilloFlexionDerecha option[value='" + exploracion.tobilloFlexionDerecha + "']").attr("selected", true).change();
			}
			
			if (exploracion.tobilloInflexionIzquierda != null){
				$("#tobilloInflexionIzquierda option[value='" + exploracion.tobilloInflexionIzquierda + "']").attr("selected", true).change();
			}
			
			if (exploracion.tobilloInflexionDerecha != null){
				$("#tobilloInflexionDerecha option[value='" + exploracion.tobilloInflexionDerecha + "']").attr("selected", true).change();
			}
			
			if (exploracion.analisisObservacionalMarcha != null){
				$("input[name=analisisObservacionalMarcha][value=" + exploracion.analisisObservacionalMarcha + "]").attr('checked', 'checked');
			}
			
			if (exploracion.videos != null && exploracion.videos.length > 0){
				for (var i = 0; i < exploracion.videos.length; i++){
					var video = exploracion.videos[i];
					var cont = i + 1;
					$("#listaVideos").append("<li><a rel='external' href='#' onclick='javascript:exploracion.irAVideo(" + video.id + ", " + cont + ");' data-transition='fade'>Video " + cont + "<br><span class='videoFeatures'>" + video.nombre + "&nbsp;|&nbsp;" + video.duracion + "</span></a></li>");
				}
				$("#listaVideos").listview('refresh');
				$("#listaVideos").show();
			}
		}
		generic.noLoading();
	},
	
	'insertar' : function() {
		var exploracionMovilDTO = exploracionFisica.recogerCamposDePantalla();
		var idPaciente = $("#idPaciente").val();
		
		if (exploracionMovilDTO != null) {
			generic.loading();
			if (exploracionMovilDTO.id == null) {
				// insert
				server.post("pacientemovil/" + idPaciente + "/exploracion", exploracionMovilDTO, exploracionFisica.insertarCallback);
			}
			else {
				// update
				server.post("pacientemovil/" + idPaciente + "/exploracion/" + exploracionMovilDTO.id, exploracionMovilDTO, exploracionFisica.actualizarCallback);
			}
		}
	},

	'insertarCallback' : function(params) {
		$("#subtitle").html("Consulta de Exploraci&oacute;n");
		$("#btnGuardar").text("Modificar");
		$("#idExploracion").val(params.parameter.id);
		$("#lblFechaActualizacion").html(params.parameter.fechaActualizacion);
		generic.noLoading();
	},
	
	'actualizarCallback' : function(params) {
		$("#lblFechaActualizacion").html(params.parameter.fechaActualizacion);
		generic.noLoading();
	},
	
	'recogerCamposDePantalla' : function() {
		var id = $("#idExploracion").val() != "" ? $("#idExploracion").val() : null;
		var exploracionMovilDTO = {
			id : id,
			nombreUsuario : $("#lblNombreUsuario").html(),
			controlMotorSelectivo : $("#controlMotorSelectivo").val(),
			evaluacionMuscular : $("#evaluacionMuscular").val(),
			nombreUsuario : $("#nombreUsuario").val(),
			idUsuario : generic.getObject("usuario").id,
			fecha : $("#lblFechaExploracion").html(),
			longitudMiembroDerecho : $("#longitudMiembroDerecho").val() + "" != "" ? parseInt($("#longitudMiembroDerecho").val()) : null,
			longitudMiembroIzquierdo : $("#longitudMiembroIzquierdo").val() + "" != "" ? parseInt($("#longitudMiembroIzquierdo").val()) : null,
			puntuacion5Metros : $("#puntuacion5Metros").val()+ "" != "" ? parseInt($("#puntuacion5Metros").val()) : null,
			puntuacion50Metros : $("#puntuacion50Metros").val()+ "" != "" ? parseInt($("#puntuacion50Metros").val()) : null,
			puntuacion500Metros : $("#puntuacion500Metros").val()+ "" != "" ? parseInt($("#puntuacion500Metros").val()) : null,
			analisisObservacionalMarcha : $("input:radio[name ='analisisObservacionalMarcha']:checked").length > 0 ? parseInt($("input:radio[name ='analisisObservacionalMarcha']:checked").val()) : null,
			caderaFlexionIzquierda : $("#caderaFlexionIzquierda").val() != "" ? $("#caderaFlexionIzquierda").val() : null,
			caderaFlexionDerecha : $("#caderaFlexionDerecha").val() != "" ? $("#caderaFlexionDerecha").val() : null,
			caderaInflexionIzquierda : $("#caderaInflexionIzquierda").val() != "" ? $("#caderaInflexionIzquierda").val() : null,
			caderaInflexionDerecha : $("#caderaInflexionDerecha").val() != "" ? $("#caderaInflexionDerecha").val() : null,
			rodillaFlexionIzquierda : $("#rodillaFlexionIzquierda").val() != "" ? $("#rodillaFlexionIzquierda").val() : null,
			rodillaFlexionDerecha : $("#rodillaFlexionDerecha").val() != "" ? $("#rodillaFlexionDerecha").val() : null,
			rodillaInflexionIzquierda : $("#rodillaInflexionIzquierda").val() != "" ? $("#rodillaInflexionIzquierda").val() : null,
			rodillaInflexionDerecha : $("#rodillaInflexionDerecha").val() != "" ? $("#rodillaInflexionDerecha").val() : null,
			tobilloFlexionIzquierda : $("#tobilloFlexionIzquierda").val() != "" ? $("#tobilloFlexionIzquierda").val() : null,
			tobilloFlexionDerecha : $("#tobilloFlexionDerecha").val() != "" ? $("#tobilloFlexionDerecha").val() : null,
			tobilloInflexionIzquierda : $("#tobilloInflexionIzquierda").val() != "" ? $("#tobilloInflexionIzquierda").val() : null,
			tobilloInflexionDerecha : $("#tobilloInflexionDerecha").val() != "" ? $("#tobilloInflexionDerecha").val() : null
		};
		var errores = "";
		if (exploracionMovilDTO.longitudMiembroDerecho == null) {
			errores += " - Debe indicar la longitud del miembro derecho<br/>";
		}
		if (exploracionMovilDTO.longitudMiembroIzquierdo == null) {
			errores += " - Debe indicar la longitud del miembro izquierdo<br/>";
		}
		if (exploracionMovilDTO.puntuacion5Metros == null) {
			errores += " - Debe indicar la puntuacion para 5 metros<br/>";
		}
		if (exploracionMovilDTO.puntuacion50Metros == null) {
			errores += " - Debe indicar la puntuacion para 50 metros<br/>";
		}
		if (exploracionMovilDTO.puntuacion500Metros == null) {
			errores += " - Debe indicar la puntuacion para 500 metros<br/>";
		}
		if (errores != "") {
			errores = "Se han producido los siguientes errores:<br/>" + errores;
			generic.alert("Error gestión de exploraciones", errores, null);
			return null;
		}
		return exploracionMovilDTO;
	},
	
	'irAVideo' : function(idVideo, num) {
		var params = {};
		if (idVideo) {
			params = {
				'idPaciente' : $("#idPaciente").val(),
				'idExploracion' : $("#idExploracion").val(),
				'idVideo' : idVideo,
				'num' : num
			};
			generic.changePage("video_detalle.html", params);
		}
		else {
			params = {
				'idPaciente' : $("#idPaciente").val(),
				'idExploracion' : $("#idExploracion").val()
			};
			generic.changePage("video_nuevo.html", params);
		}
	},
	
	'irAPaginaAuxiliarDeExploracion' : function(pagina){
		var idExploracion = $("#idExploracion").val();
		if (idExploracion != null && idExploracion != ""){
			params = {
				'idPaciente' : $("#idPaciente").val(),
				'idExploracion' : idExploracion
			};
			generic.changePage(pagina, params);
		}
		else{
			generic.alert("Acceso no permitido", "Para acceder a esta funcionalidad debe guardar la exploracion previamente.");
		}
	}
};
