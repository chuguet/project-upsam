var recordarPassword = {
	'enviarUsuarioEmail' : function(){
		if ($("#txtUsuarioEmail").val().length == 0){
			generic.alert("Error de recordatorio", "Debe introducir su usuario o contrase&ntilde;a", null);
			return;
		}
		generic.loading();
		var params = {value : $("#txtUsuarioEmail").val()};
		server.post('usuario/forget', params, recordarPassword.enviarUsuarioEmailCallback);
	},
	'enviarUsuarioEmailCallback' : function(parameters) {
		generic.noLoading();
		if (parameters.correcto){
			$("#containerUsuarioEmail").hide();
			$("#containerPassword").show();
		}
	},
	'enviarNuevoPassword' : function(){
		if ($("#txtToken").val().length == 0){
			generic.alert("Error de recordatorio", "Debe introducir la llave de seguridad que se le envió por email", null);
			return;
		}
		if ($("#txtPassword").val().length == 0 || $("#txtPasswordNueva").val().length == 0){
			generic.alert("Error de recordatorio", "Debe introducir la contraseña y repetirla", null);
			return;
		}
		var params = {password : $("#txtPassword").val(), token : $("#txtToken").val()};
		server.post('usuario/changePassword', params, recordarPassword.enviarNuevoPasswordCallback);
	},
	'enviarNuevoPasswordCallback' : function(parameters){
		if (parameters.correcto){
			generic.changePage("login.html");
		}
	}
};