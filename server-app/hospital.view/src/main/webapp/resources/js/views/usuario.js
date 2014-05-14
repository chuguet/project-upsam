var usuario = {
	'rowID' : null,
	
	'formatForm' : function() {
		$("#btnCancel").button().click(function() {
			generic.getList('usuario');
		});

		$("#btnSaveUsuario").button().click(function() {
			usuario.getParams();
		});

		$("#rol").buttonset();
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var user = $("input[id=usuario]").val();
		var password = $("input[id=password]").val();
		var nombre = $("input[id=nombre]").val();
		var apellidos = $("input[id=apellidos]").val();
		var email = $("input[id=email]").val();
		var rol = $("input:radio[name='rol']:checked").attr("id");
		
//		var errores = '';
//		if (nombre == '') {
//			errores += '- Debe introducir el nombre<br/>';
//		}
//		if (apellidos == '') {
//			errores += '- Debe introducir los apellidos<br/>';
//		}
//		if($("input:radio[name='rol']").is(":checked")==false){
//			errores += '- Debe seleccionar un rol<br/>';
//		}
//		if (!validarEmail(email)){
//			errores += '- Debe introducir un correo electr&oacute;nico correcto<br/>';
//		}
//		if (user == '') {
//			errores += '- Debe introducir un usuario<br/>';
//		}
//		if (password == '') {
//			errores += '- Debe introducir una contrase&ntilde;a<br/>';
//		}
//		if (rol == null) {
//			errores += '- Debe seleccionar un rol';
//		}
//		if (errores != '') {
//			generic.alert(errores, "Validaci&oacute;n");
//		}
//		else {
			var data = {
				id : id,
				nombre : nombre,
				apellidos : apellidos,
				email : email,
				user : user,
				password : password,
				rol : rol
			};
			var entity = (id != null) ? 'usuario/' + id : 'usuario';
			generic.post(entity, data, function() {
				generic.getList('usuario');
			});
		//};
	}
};
function validarEmail(valor) {
	  if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(valor)){
		  return true;
	  } else {
		  return false;
	  }
};