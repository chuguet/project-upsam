var video = {
	'buscarListado' : function(){
		server.get('pacientemovil/1/video', null, video.buscarListadoCallback);
    },
	        
    'buscarListadoCallback' : function(parameters){
    	$("#listaVideos li").remove();
    	for (var i = 0; i < parameters.length; i++){
    		$("#listaVideos").append("<li><a rel='external' alt='Acceder al video' href='video_detalle.html?id=" + parameters[i].id + "&numero=" + (i + 1) + "' data-transition='fade'>Video " + (i + 1) + "<br><span class='videoFeatures'>" + parameters[i].nombre +" | " + parameters[i].duracion + "</span></a></li>");
    		
    	}
    	$("#listaVideos").listview('refresh');
    },
    
    'recuperar' : function (){
    	videojs.options.flash.swf = "video-js.swf";
    	var id = generic.getURLParameter("id");
    	if (id != null){
			generic.loading();
			server.get('pacientemovil/1/video', id, video.recuperarCallback);
			//server.get('pacientemovil/1/video/' + id, null, video.recuperarCallback);
		}
		else{
			generic.noLoading();
		}
	},
	
	'recuperarCallback' : function(parameters){
		var numero = generic.getURLParameter("numero");
		
		$("#reproductorVideo").append("<source src='" + server.URI + "pacientemovil/1/videoreproduce/" + parameters.id + "' type='video/mp4' />");
		$("#numeroVideo").html("Video  " + numero);
		$("#nombreVideo").html("Archivo: " + parameters.nombre);
		$("#duracionVideo").html("Duraci&oacute;n: " + parameters.duracion);
		generic.noLoading();
	}
};