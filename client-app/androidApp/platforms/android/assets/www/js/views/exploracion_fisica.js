var exploracion_fisica = {
	'postForm' : function() {
		var apellidos = $("#apellidos").val();
		var curso = $("#curso").val();
		var escolarizacion = $("#escolarizacion option:selected").text();
		var examinador = $("#examinador option:selected").text();
		var fechaEvaluacion = $("#fecEval").val();
		var fechaNacimiento = $("#fecNac").val();
		var nombre = $("#nombre").val();
		var numeroIdentificacion = $("#numID").val();
		var sexo = $("#sexo option:selected").text();
		var paciente = {
			apellidos : apellidos,
			curso : curso,
			escolarizacion : escolarizacion,
			examinador : examinador,
			fechaEvaluacion : fechaEvaluacion,
			fechaNacimiento : fechaNacimiento,
			nombre : nombre,
			numeroIdentificacion : numeroIdentificacion,
			sexo : sexo
		};
		if (exploracion_fisica.validate(paciente)){
			server.post("paciente", paciente, null);
		}
	},
	'validate' : function(paciente){
		
		return true;
	}
}