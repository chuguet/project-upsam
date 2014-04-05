var server = {
	"URI" : "http://localhost:8080/hospitalServer/paciente/",
	"post" : function(action, params, callback) {
		this.executeJSon('POST', action, params, callback);
	},
	"get" : function(entity, item, callback) {
		var action = entity;
		if (item && item != null) {
			if (typeof item == "object") {
				action += "?";
				var count = 1;
				for( var o in item) {
					if (count > 1)
						action += "&";
					action += o + "=" + item[o];
					count++;
				}
				params = item;
			}
			else {
				action += '/' + item;
			}
		}
		this.executeJSon('GET', action, null, callback);
	},
	"executeJSon" : function($method, action, data, callback) {
		$("body").addClass("loading");
		
		if (data != null) {
			data = JSON.stringify(data);
		}
		$.ajaxSetup({
			headers : {
				"Content-Type" : 'application/json',
				"Accept" : 'application/json'
			}
		});
		
		var url = (action != null) ? server.URI + action : server.URI;
		
		$.ajax({
			type : $method,
			url : url,
			data : data,
			dataType : 'json',
			success : function(response) {
				if ($method == 'GET') {
					if (callback) {
						var param = new Array();
						param.push(response);
						callback.apply(this, param);
					}
				}
				else {
					var cabeceraMensaje;
					if (response.correcto) {
						cabeceraMensaje = 'Operacion correcta';
					}
					else {
						cabeceraMensaje = 'Operacion incorrecta';
					}
					navigator.notification.alert(response.mensaje, null, cabeceraMensaje);
					if (response.correcto) {
						if (callback) {
							var param = new Array();
							param.push(response);
							callback.apply(this, param);
						}
					}
				}
			},
			error : function(e) {
				var message = 'Se ha producido el siguiente error al procesar la accion: '+ e.responseText;
				switch (e.status) {
				case 404:
					message = 'La pagina a la que intenta acceder no existe';
					break;
				case 403:
					message = 'No tiene permisos para acceder a esta funcionalidad';
					break;
				}
				navigator.notification.alert(message, null, 'Error de conexion');
			},
			complete : function() {
				$("body").removeClass("loading");
			}
		});
	}
};