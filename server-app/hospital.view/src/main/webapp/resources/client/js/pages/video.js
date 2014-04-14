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
	},
	
	'grabar' : function() {
        navigator.device.capture.captureVideo(video.grabarSuccess, video.grabarError, {limit: 2});
    },
	
	'grabarSuccess' : function(mediaFiles) {
    	for (var i = 0; i < mediaFiles.length; i++) {
            video.subirAlServidor(mediaFiles[i]);
        }
    },

    // Called if something bad happens.
    'grabarError' : function() {
    	generic.alert("Grabacion fallida", "Se ha producido un error durante la grabacion de video", null);
    },

    'subirAlServidor': function(mediaFile) {
        var ft = new FileTransfer();
        var path = mediaFile.fullPath;
        var options = new FileUploadOptions();
        options.fileKey = "file";
        options.fileName = mediaFile.name;
        options.mimeType = "multipart/form-data";
        options.chunkedMode = false;
        options.headers = { Connection: "close" };
        
        ft.upload(path,
            encodeURI(server.URI + "pacientemovil/1/videoupload"),
            video.subirAlServidorSuccess,
            video.subirAlServidorError,
            options);
    },

	'subirAlServidorSuccess' : function(result){
        console.log('Upload success: ' + result.responseCode);
        console.log(result.bytesSent + ' bytes sent');
        generic.alert("Grabacion correcta", "El video se ha grabado y se ha subido correctamente al servidor", null);
    },
    
    'subirAlServidorError' : function(error){
    	generic.alert("Grabacion fallida", "Se ha producido un error durante la subida del video al servidor", null);
    	console.log("An error has occurred: Code = " + error.code);
        console.log("upload error source " + error.source);
        console.log("upload error target " + error.target);
        console.log('Error uploading file ' + path + ': ' + error.code);
    }
};