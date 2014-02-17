<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="format-detection" content="telephone=no" />
        <title>Login</title>
        <script src="resources/js/jquery-1.8.2.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            //app.initialize();

            function login() {
				$.ajax({
					type : 'POST',
					url : "http://localhost:8080/hospitalServer/j_spring_security_check",
					data : {'j_username': $("#txtUsuario").val(), 'j_password': $("#txtPwd").val()},
					dataType : 'json',
					beforeSend: function (request) {
						$.mobile.loading( 'show', {
  						text: 'Procesando',
  						textVisible: true,
  						theme: $.mobile.loader.prototype.options.theme,
  						textonly: false
  						});
		                request.setRequestHeader("xX-Ajax-call", true);
		            },
		            complete : function(jqXHR, textStatus) {
		            	$.mobile.loading('hide');
            			if (jqXHR.statusText == "No Autorizado") {
                  			alert("Usuario y/o contraseña incorrectos");
            			}
            			else if (jqXHR.statusText == "OK") {
                  			$.mobile.changePage('home.html','#loginpage', { transition: "slide"} ); 
            			}
            			else{
            				alert("Se ha producido un error en servidor");
            			}
	            	}
				});
			}
        </script>
    </head>
    <body>
        <fieldset class="login">
			<h1>Acceso de usuarios</h1>
			<form id="login">
	            <span>Usuario:</span> <input type="text" id="txtUsuario" />
	            <span>Contrase&ntilde;a:</span><input type="password" id="txtPwd" />
	            <input type="button" value="Aceptar" id="btnAceptar" onclick="javascript:login();" />
	            <input type="reset" value="Cancelar" id="btnReset" />
            </form>
        </fieldset>
    </body>
</html>
