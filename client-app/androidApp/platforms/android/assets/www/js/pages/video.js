var video = {
	'prepararSubida' : function(){
		$("#idPaciente").val(generic.getURLParameter("idPaciente"));
    	$("#idExploracion").val(generic.getURLParameter("idExploracion"));
		generic.noLoading()
	},
    'recuperar' : function (){
    	videojs.options.flash.swf = "video-js.swf";
    	var idVideo = generic.getURLParameter("idVideo");
    	$("#idPaciente").val(generic.getURLParameter("idPaciente"));
    	$("#idExploracion").val(generic.getURLParameter("idExploracion"));
    	$("#idVideo").val(idVideo);
    	if (idVideo != null){
			generic.loading();
			server.get("pacientemovil/" + $("#idPaciente").val() + "/exploracion/" + $("#idExploracion").val() + "/video/" + idVideo, null, video.recuperarCallback);
		}
		else{
			generic.noLoading();
		}
	},
	
	'recuperarCallback' : function(parameters){
		window.videoPlayer.play(server.URI + "pacientemovil/" + $("#idPaciente").val() + "/exploracion/" + $("#idExploracion").val() + "/reproductor/" + $("#idVideo").val());
		var numero = generic.getURLParameter("num");
		$("#reproductorVideo").append("<source src='" + server.URI + "pacientemovil/" + $("#idPaciente").val() + "/exploracion/" + $("#idExploracion").val() + "/videoreproduce/" + $("#idVideo").val() + "' type='video/mp4' />");
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
		var params = {};
		params.descripcion = "mi descripcion";
		options.params = params;
        
        ft.upload(path,
            encodeURI(server.URI + "pacientemovil/" + $("#idPaciente").val() + "/exploracion/" + $("#idExploracion").val() + "/videoupload"),
            video.subirAlServidorSuccess,
            video.subirAlServidorError,
            options);
    },

	'subirAlServidorSuccess' : function(result){
        console.log('Upload success: ' + result.responseCode);
        console.log(result.bytesSent + ' bytes sent');
        generic.alert("Grabacion correcta", "El video se ha grabado y se ha subido correctamente al servidor", null);
        exploracionFisica.recuperarListadoVideos();
    },
    
    'subirAlServidorError' : function(error){
    	generic.alert("Grabacion fallida", "Se ha producido un error durante la subida del video al servidor", null);
    	console.log("An error has occurred: Code = " + error.code);
        console.log("upload error source " + error.source);
        console.log("upload error target " + error.target);
        console.log('Error uploading file ' + path + ': ' + error.code);
    }
};