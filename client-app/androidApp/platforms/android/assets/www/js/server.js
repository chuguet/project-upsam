var server = {
	"URI" : "http://localhost:8080/hospitalServer/paciente/",
	"post" : function(action, params, callback) {
		this.executeJSon('POST', action, params, callback);
	},
	"executeJSon" : function($method, action, data, callback) {
		if (data != null) {
			data = JSON.stringify(data);
		}
		$.ajaxSetup({
			headers : {
				"Content-Type" : 'application/json',
				"Accept" : 'application/json'
			}
		});
		var url;
		if (action != null) {
			url = server.URI + action;
		}
		else {
			url = server.URI;
		}
		$.ajax({
			type : $method,
			url : url,
			data : data,
			dataType : 'json',
			success : function(response) {
				var cabeceraMensaje;
				if (response.correcto) {
					cabeceraMensaje = 'Operaci&oacute;n correcta';
				}
				else {
					cabeceraMensaje = 'Operaci&oacute;n incorrecta';
				}
				alert(response.mensaje, cabeceraMensaje);
				if (response.correcto) {
					if (callback) {
						var param = new Array();
						param.push(response);
						callback.apply(this, param);
					}
				}
			},
			error : function(e) {
				alert('Se ha producido un error al procesar la acci&oacute;n', 'Error de operaci&oacute;n');
			}
		});
	}
};