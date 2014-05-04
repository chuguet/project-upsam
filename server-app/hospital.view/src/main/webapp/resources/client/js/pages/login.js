/*define(["../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server", "../jquery/jquery.jqplot", "../jquery/jquery.video-4.3.0",
        "../pages/antecedentes_personales", "../pages/antecedentes_relacionados_PCI", "../pages/exploracion_fisica", "../pages/grafica", "../pages/gross_motor_function", "../pages/paciente", "../pages/recordar_contrasenna"
        , "../pages/val_articular_muscular", "../pages/video", "../jquery/iscroll", "../jquery/jquery.mobile.iscrollview"
        ], function($) {
    generic.initialize();
});*/

var login = {
	'acceso' : function(){
		var usuario = $("#txtUsuario").val();
		var password = $("#txtPassword").val();
		if (usuario + "" == "" || password + "" == ""){
			generic.alert("Error de acceso", "Debe introducir el usuario y la contrase&ntilde;a");
			return false;
		}
		$.ajax({
			type : 'POST',
			url : server.URI + "j_spring_security_check",
			data : {'j_username': usuario, 'j_password': password},
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
    				generic.alert("Error de acceso", "Usuario y/o contrase&ntilde;a incorrectos", null);
    			}
    			else if (jqXHR.statusText == "OK") {
    				generic.setObject("usuario", eval('(' + jqXHR.responseText + ')'));
    				generic.changePage('home.html');
    			}
    			else{
    				generic.alert("Error de servidor", "Se ha producido un error interno en el servidor", null);
    			}
        	}
		});
	}
};