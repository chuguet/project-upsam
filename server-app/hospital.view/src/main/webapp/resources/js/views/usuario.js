var usuario = {
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var user = $("input[id=usuario]").val();
		var password = $("input[id=password]").val();
		var nombre = $("input[id=nombre]").val();
		var apellidos = $("input[id=apellidos]").val();
		var email = $("input[id=email]").val();
		var rol = $("input:radio[name='rol']:checked").attr("id");
		

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
	}
};