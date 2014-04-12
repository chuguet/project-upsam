var login = {
				'acceso' : function(){
					$.ajax({
						type : 'POST',
						url : server.URI + "j_spring_security_check",
						data : {'j_username': $("#txtUsuario").val(), 'j_password': $("#txtPassword").val()},
						dataType : 'json',
						beforeSend: function (request) {
							$.mobile.loading( 'show', {
	  						text: 'Procesando',
	  						textVisible: true,
	  						theme: "b",
	  						textonly: false
	  						});
			                request.setRequestHeader("X-Ajax-call", true);
			            },
			            complete : function(jqXHR, textStatus) {
			            	$.mobile.loading('hide');
	            			if (jqXHR.statusText == "No Autorizado") {
	            				generic.alert("Error de acceso", "Usuario y/o contraseña incorrectos");
	            			}
	            			else if (jqXHR.statusText == "OK") {
	            				generic.setObject("usuario", eval('(' + jqXHR.responseText + ')'));
	            				generic.changePage('home.html');
	            			}
	            			else{
	            				generic.alert("Error de servidor", "Se ha producido un error interno en el servidor");
	            			}
		            	}
					});
				}
			}