var server = {
		//"URI" : "http://192.168.2.179:8080/hospitalServer/",
	//"URI" : "http://lab.atsistemas.com/hospitalServer/",
	"URI" : "http://192.168.0.154:8080/hospitalServer/",
	"post" : function(action, params, callbackSuccess, callbackError) {
		this.executeJSon('POST', action, params, callbackSuccess, callbackError);
	},
	"get" : function(entity, item, callbackSuccess, callbackError) {
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
		this.executeJSon('GET', action, null, callbackSuccess, callbackError);
	},
	"executeJSon" : function($method, action, data, callbackSuccess, callbackError) {
		
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
			success : function(response, textStatus, x, y) {
				server.verifyActiveSession(response, this.url);
				
				if ($method == 'GET') {
					if (callbackSuccess) {
						var param = new Array();
						param.push(response);
						callbackSuccess.apply(this, param);
					}
				}
				else {
					var cabeceraMensaje;
					if (response.correcto) {
						generic.alert('Operacion correcta', response.mensaje, null);
						if (callbackSuccess) {
							var param = new Array();
							param.push(response);
							callbackSuccess.apply(this, param);
						}
					}
					else {
						generic.alert('Operacion incorrecta', response.mensaje, null);
						generic.noLoading();
					}
				}
			},
			error : function(e) {
				var message = 'Se ha producido un error de servidor al realizar la acci&oacute;n. Si sigue sucediendo, p&oacute;ngase en contacto con el administrador del sistema';
				switch (e.status) {
				case 404:
					message = 'La pagina a la que intenta acceder no existe';
					break;
				case 403:
					message = 'No tiene permisos para acceder a esta funcionalidad';
					break;
				}
				generic.alert('Error de conexion', message, null);
				generic.noLoading();
				if (callbackError) {
					var param = new Array();
					param.push(e);
					callbackError.apply(this, param);
				}
			},
			complete : function(e) {
				console.log(this.url);
			}
		});
	},
	
	'verifyActiveSession' : function(response, url){
		if (server.isEmptyObject(response)){
			var iframe = $('<iframe />', {
			    name: 'myFrame',
			    id:   'myFrame',
			    src: url,
			    style: 'display:none;'
			});
			iframe.appendTo('body');
	
		    
		    iframe.load(function(){
		    	var sessionLose = ($("#myFrame").contents().find("form#f").length == 1);
		    	iframe.remove();
		    	if (sessionLose){
		    		generic.alert("Sesion Finalizada", "Su sesion ha finalizado. Vuelva a logarse", function(){window.location.href="login.html";})
		    		
		    	}
		    });
		}
	},
	
	'isEmptyObject' : function (obj) {
		for(var prop in obj) {
			if (Object.prototype.hasOwnProperty.call(obj, prop)) {
				return false;
		    }
		}
		return true;
	}
};