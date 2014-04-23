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
		if (idExploracion != null){
			$("#idExploracion").val(idExploracion);
			//Entramos en modo edicion
			generic.loading();
			$("#subtitle").html("Consulta de Exploraci&oacute;n");
			server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion, null, exploracionFisica.recuperarCallback);
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
			if (exploracion.fecha != null){
				$("#lblFechaExploracion").html(exploracion.fecha);
			}
			
			if (exploracion.nombreUsuario != null){
				$("#lblNombreUsuario").html(exploracion.nombreUsuario);
			}
			
			if (exploracion.controlMotorSelectivo != null){
				$("#cmbControlMotorSelectivo option[value=" + exploracion.controlMotorSelectivo + "]").attr("selected", true).change();
			}
			
			if (exploracion.evaluacionMuscular != null){
				$("#cmbevaluacionMuscularManual option[value=" + exploracion.evaluacionMuscular + "]").attr("selected", true).change();
			}
			
			if (exploracion.longitudMiembroDerecho != null){
				$("#longitudMiembroDerecho").val(exploracion.longitudMiembroDerecho);
				$("#longitudMiembroDerecho").slider( "refresh" );
			}
			
			if (exploracion.longitudMiembroIzquierdo != null){
				$("#longitudMiembroIzquierdo").val(exploracion.longitudMiembroIzquierdo);
				$("#longitudMiembroIzquierdo").slider( "refresh" );
			}
			
			if (exploracion.longitudMiembroIzquierdo != null){
				$("#puntuacion5Metros").val(exploracion.puntuacion5Metros);
				$("#puntuacion5Metros").slider( "refresh" );
			}
			
			if (exploracion.longitudMiembroIzquierdo != null){
				$("#puntuacion50Metros").val(exploracion.puntuacion50Metros);
				$("#puntuacion50Metros").slider( "refresh" );
			}
			
			if (exploracion.longitudMiembroIzquierdo != null){
				$("#puntuacion500Metros").val(exploracion.puntuacion500Metros);
				$("#puntuacion500Metros").slider( "refresh" );
			}
			
			if (exploracion.caderaFlexionIzquierda != null){
				$("#caderaFlexionIzquierda option[value=" + exploracion.caderaFlexionIzquierda + "]").attr("selected", true).change();
			}
			
			if (exploracion.caderaFlexionDerecha != null){
				$("#caderaFlexionDerecha option[value=" + exploracion.caderaFlexionDerecha + "]").attr("selected", true).change();
			}
			
			if (exploracion.caderaInflexionIzquierda != null){
				$("#caderaInflexionIzquierda option[value=" + exploracion.caderaInflexionIzquierda + "]").attr("selected", true).change();
			}
			
			if (exploracion.caderaInflexionDerecha != null){
				$("#caderaInflexionDerecha option[value=" + exploracion.caderaInflexionDerecha + "]").attr("selected", true).change();
			}
			
			if (exploracion.rodillaFlexionIzquierda != null){
				$("#rodillaFlexionIzquierda option[value=" + exploracion.rodillaFlexionIzquierda + "]").attr("selected", true).change();
			}
			
			if (exploracion.rodillaFlexionDerecha != null){
				$("#rodillaFlexionDerecha option[value=" + exploracion.rodillaFlexionDerecha + "]").attr("selected", true).change();
			}
			
			if (exploracion.rodillaInflexionIzquierda != null){
				$("#rodillaInflexionIzquierda option[value=" + exploracion.rodillaInflexionIzquierda + "]").attr("selected", true).change();
			}
			
			if (exploracion.rodillaInflexionDerecha != null){
				$("#rodillaInflexionDerecha option[value=" + exploracion.rodillaInflexionDerecha + "]").attr("selected", true).change();
			}
			
			if (exploracion.tobilloFlexionIzquierda != null){
				$("#tobilloFlexionIzquierda option[value=" + exploracion.tobilloFlexionIzquierda + "]").attr("selected", true).change();
			}
			
			if (exploracion.tobilloFlexionDerecha != null){
				$("#tobilloFlexionDerecha option[value=" + exploracion.tobilloFlexionDerecha + "]").attr("selected", true).change();
			}
			
			if (exploracion.tobilloInflexionIzquierda != null){
				$("#tobilloInflexionIzquierda option[value=" + exploracion.tobilloInflexionIzquierda + "]").attr("selected", true).change();
			}
			
			if (exploracion.tobilloInflexionDerecha != null){
				$("#tobilloInflexionDerecha option[value=" + exploracion.tobilloInflexionDerecha + "]").attr("selected", true).change();
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
		params = {
			'idPaciente' : $("#idPaciente").val(),
			'idExploracion' : $("#idExploracion").val()
		};
		generic.changePage(pagina, params);
	}
};
