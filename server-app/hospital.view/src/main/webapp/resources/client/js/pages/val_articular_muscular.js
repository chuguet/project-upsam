var valoracionArticularMuscular = {
	'recuperar' : function(){
		var idPaciente = generic.getURLParameter("idPaciente");
		var idExploracion = generic.getURLParameter("idExploracion");
		$("#idPaciente").val(idPaciente);
		$("#idExploracion").val(idExploracion);
		generic.loading();
		server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion + "/valoracionArticularMuscular", null, valoracionArticularMuscular.recuperarCallback);
		if (idExploracion != null){
			server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion + "/restriccion", null, generic.recuperarRestriccionesCallback);
		}
	},
	
	'recuperarCallback' : function(valoracion){
		if (valoracion.id != null){
			$("#idValoracion").val(valoracion.id);
			$("#subtitle").html("Consulta de Valoraci&oacute;n Articular y Muscular");
			$("#btnGuardar").text("Modificar");
			$("input#var_1_1").val(valoracion.var_1_1);
			$("input#var_1_2").val(valoracion.var_1_2);
			$("input#var_1_3").val(valoracion.var_1_3);
			$("input#var_1_4").val(valoracion.var_1_4);
			$("input#var_1_5").val(valoracion.var_1_5);
			$("input#var_1_6").val(valoracion.var_1_6);
			$("input#var_2_1").val(valoracion.var_2_1);
			$("input#var_2_2").val(valoracion.var_2_2);
			$("input#var_2_3").val(valoracion.var_2_3);
			$("input#var_2_4").val(valoracion.var_2_4);
			$("input#var_2_5").val(valoracion.var_2_5);
			$("input#var_2_6").val(valoracion.var_2_6);
			$("input#var_3_1").val(valoracion.var_3_1);
			$("input#var_3_2").val(valoracion.var_3_2);
			$("input#var_3_3").val(valoracion.var_3_3);
			$("input#var_3_4").val(valoracion.var_3_4);
			$("input#var_3_5").val(valoracion.var_3_5);
			$("input#var_3_6").val(valoracion.var_3_6);
			$("input#var_4_1").val(valoracion.var_4_1);
			$("input#var_4_2").val(valoracion.var_4_2);
			$("input#var_4_3").val(valoracion.var_4_3);
			$("input#var_4_4").val(valoracion.var_4_4);
			$("input#var_4_5").val(valoracion.var_4_5);
			$("input#var_4_6").val(valoracion.var_4_6);
			$("input#var_5_1").val(valoracion.var_5_1);
			$("input#var_5_2").val(valoracion.var_5_2);
			$("input#var_5_3").val(valoracion.var_5_3);
			$("input#var_5_4").val(valoracion.var_5_4);
			$("input#var_5_5").val(valoracion.var_5_5);
			$("input#var_5_6").val(valoracion.var_5_6);
			$("input#var_6_1").val(valoracion.var_6_1);
			$("input#var_6_2").val(valoracion.var_6_2);
			$("input#var_6_3").val(valoracion.var_6_3);
			$("input#var_6_4").val(valoracion.var_6_4);
			$("input#var_6_5").val(valoracion.var_6_5);
			$("input#var_6_6").val(valoracion.var_6_6);
			$("input#var_7_1").val(valoracion.var_7_1);
			$("input#var_7_2").val(valoracion.var_7_2);
			$("input#var_7_3").val(valoracion.var_7_3);
			$("input#var_7_4").val(valoracion.var_7_4);
			$("input#var_7_5").val(valoracion.var_7_5);
			$("input#var_7_6").val(valoracion.var_7_6);
			$("input#var_8_1").val(valoracion.var_8_1);
			$("input#var_8_2").val(valoracion.var_8_2);
			$("input#var_8_3").val(valoracion.var_8_3);
			$("input#var_8_4").val(valoracion.var_8_4);
			$("input#var_8_5").val(valoracion.var_8_5);
			$("input#var_8_6").val(valoracion.var_8_6);
			$("input#var_9_1").val(valoracion.var_9_1);
			$("input#var_9_2").val(valoracion.var_9_2);
			$("input#var_9_3").val(valoracion.var_9_3);
			$("input#var_9_4").val(valoracion.var_9_4);
			$("input#var_9_5").val(valoracion.var_9_5);
			$("input#var_9_6").val(valoracion.var_9_6);
			$("input#var_10_1").val(valoracion.var_10_1);
			$("input#var_10_2").val(valoracion.var_10_2);
			$("input#var_10_3").val(valoracion.var_10_3);
			$("input#var_10_4").val(valoracion.var_10_4);
			$("input#var_10_5").val(valoracion.var_10_5);
			$("input#var_10_6").val(valoracion.var_10_6);
			$("input#var_11_1").val(valoracion.var_11_1);
			$("input#var_11_2").val(valoracion.var_11_2);
			$("input#var_11_3").val(valoracion.var_11_3);
			$("input#var_11_4").val(valoracion.var_11_4);
			$("input#var_11_5").val(valoracion.var_11_5);
			$("input#var_11_6").val(valoracion.var_11_6);
			$("input#var_12_1").val(valoracion.var_12_1);
			$("input#var_12_2").val(valoracion.var_12_2);
			$("input#var_12_3").val(valoracion.var_12_3);
			$("input#var_12_4").val(valoracion.var_12_4);
			$("input#var_12_5").val(valoracion.var_12_5);
			$("input#var_12_6").val(valoracion.var_12_6);
			$("input#var_13_1").val(valoracion.var_13_1);
			$("input#var_13_2").val(valoracion.var_13_2);
			$("input#var_13_3").val(valoracion.var_13_3);
			$("input#var_13_4").val(valoracion.var_13_4);
			$("input#var_13_5").val(valoracion.var_13_5);
			$("input#var_13_6").val(valoracion.var_13_6);
			
		}
		generic.noLoading();
	},
	
	'insertar' : function() {
		var valoracionMovilDTO = valoracionArticularMuscular.recogerCamposDePantalla();
		var idPaciente = $("#idPaciente").val();
		var idExploracion = $("#idExploracion").val();
		
		
		if (valoracionMovilDTO != null) {
			generic.loading();
			if (valoracionMovilDTO.id == null) {
				// insert
				server.post("pacientemovil/" + idPaciente + "/exploracion/" + idExploracion + "/valoracionArticularMuscular", valoracionMovilDTO, valoracionArticularMuscular.insertarCallback);
			}
			else {
				// update
				server.post("pacientemovil/" + idPaciente + "/exploracion/" + idExploracion + "/valoracionArticularMuscular/" + valoracionMovilDTO.id, valoracionMovilDTO, valoracionArticularMuscular.actualizarCallback);
			}
		}
	},

	'insertarCallback' : function(params) {
		$("#subtitle").html("Consulta de Valoraci&oacute;n Articular y Muscular");
		$("#btnGuardar").text("Modificar");
		$("#idValoracion").val(params.parameter.id);
		generic.noLoading();
	},
	
	'actualizarCallback' : function(params) {
		generic.noLoading();
	},
	
	'recogerCamposDePantalla' : function() {
		var valoracionMovilDTO = {
			id : $("#idValoracion").val() != "" ? $("#idValoracion").val() : null,
			idExploracion : $("#idExploracion").val(),
			var_1_1 : $("input#var_1_1").val() != "" ? $("input#var_1_1").val() : null,
			var_1_2 : $("input#var_1_2").val() != "" ? $("input#var_1_2").val() : null,
			var_1_3 : $("input#var_1_3").val() != "" ? $("input#var_1_3").val() : null,
			var_1_4 : $("input#var_1_4").val() != "" ? $("input#var_1_4").val() : null,
			var_1_5 : $("input#var_1_5").val() != "" ? $("input#var_1_5").val() : null,
			var_1_6 : $("input#var_1_6").val() != "" ? $("input#var_1_6").val() : null,
			var_2_1 : $("input#var_2_1").val() != "" ? $("input#var_2_1").val() : null,
			var_2_2 : $("input#var_2_2").val() != "" ? $("input#var_2_2").val() : null,
			var_2_3 : $("input#var_2_3").val() != "" ? $("input#var_2_3").val() : null,
			var_2_4 : $("input#var_2_4").val() != "" ? $("input#var_2_4").val() : null,
			var_2_5 : $("input#var_2_5").val() != "" ? $("input#var_2_5").val() : null,
			var_2_6 : $("input#var_2_6").val() != "" ? $("input#var_2_6").val() : null,
			var_3_1 : $("input#var_3_1").val() != "" ? $("input#var_3_1").val() : null,
			var_3_2 : $("input#var_3_2").val() != "" ? $("input#var_3_2").val() : null,
			var_3_3 : $("input#var_3_3").val() != "" ? $("input#var_3_3").val() : null,
			var_3_4 : $("input#var_3_4").val() != "" ? $("input#var_3_4").val() : null,
			var_3_5 : $("input#var_3_5").val() != "" ? $("input#var_3_5").val() : null,
			var_3_6 : $("input#var_3_6").val() != "" ? $("input#var_3_6").val() : null,
			var_4_1 : $("input#var_4_1").val() != "" ? $("input#var_4_1").val() : null,
			var_4_2 : $("input#var_4_2").val() != "" ? $("input#var_4_2").val() : null,
			var_4_3 : $("input#var_4_3").val() != "" ? $("input#var_4_3").val() : null,
			var_4_4 : $("input#var_4_4").val() != "" ? $("input#var_4_4").val() : null,
			var_4_5 : $("input#var_4_5").val() != "" ? $("input#var_4_5").val() : null,
			var_4_6 : $("input#var_4_6").val() != "" ? $("input#var_4_6").val() : null,
			var_5_1 : $("input#var_5_1").val() != "" ? $("input#var_5_1").val() : null,
			var_5_2 : $("input#var_5_2").val() != "" ? $("input#var_5_2").val() : null,
			var_5_3 : $("input#var_5_3").val() != "" ? $("input#var_5_3").val() : null,
			var_5_4 : $("input#var_5_4").val() != "" ? $("input#var_5_4").val() : null,
			var_5_5 : $("input#var_5_5").val() != "" ? $("input#var_5_5").val() : null,
			var_5_6 : $("input#var_5_6").val() != "" ? $("input#var_5_6").val() : null,
			var_6_1 : $("input#var_6_1").val() != "" ? $("input#var_6_1").val() : null,
			var_6_2 : $("input#var_6_2").val() != "" ? $("input#var_6_2").val() : null,
			var_6_3 : $("input#var_6_3").val() != "" ? $("input#var_6_3").val() : null,
			var_6_4 : $("input#var_6_4").val() != "" ? $("input#var_6_4").val() : null,
			var_6_5 : $("input#var_6_5").val() != "" ? $("input#var_6_5").val() : null,
			var_6_6 : $("input#var_6_6").val() != "" ? $("input#var_6_6").val() : null,
			var_7_1 : $("input#var_7_1").val() != "" ? $("input#var_7_1").val() : null,
			var_7_2 : $("input#var_7_2").val() != "" ? $("input#var_7_2").val() : null,
			var_7_3 : $("input#var_7_3").val() != "" ? $("input#var_7_3").val() : null,
			var_7_4 : $("input#var_7_4").val() != "" ? $("input#var_7_4").val() : null,
			var_7_5 : $("input#var_7_5").val() != "" ? $("input#var_7_5").val() : null,
			var_7_6 : $("input#var_7_6").val() != "" ? $("input#var_7_6").val() : null,
			var_8_1 : $("input#var_8_1").val() != "" ? $("input#var_8_1").val() : null,
			var_8_2 : $("input#var_8_2").val() != "" ? $("input#var_8_2").val() : null,
			var_8_3 : $("input#var_8_3").val() != "" ? $("input#var_8_3").val() : null,
			var_8_4 : $("input#var_8_4").val() != "" ? $("input#var_8_4").val() : null,
			var_8_5 : $("input#var_8_5").val() != "" ? $("input#var_8_5").val() : null,
			var_8_6 : $("input#var_8_6").val() != "" ? $("input#var_8_6").val() : null,
			var_9_1 : $("input#var_9_1").val() != "" ? $("input#var_9_1").val() : null,
			var_9_2 : $("input#var_9_2").val() != "" ? $("input#var_9_2").val() : null,
			var_9_3 : $("input#var_9_3").val() != "" ? $("input#var_9_3").val() : null,
			var_9_4 : $("input#var_9_4").val() != "" ? $("input#var_9_4").val() : null,
			var_9_5 : $("input#var_9_5").val() != "" ? $("input#var_9_5").val() : null,
			var_9_6 : $("input#var_9_6").val() != "" ? $("input#var_9_6").val() : null,
			var_10_1 : $("input#var_10_1").val() != "" ? $("input#var_10_1").val() : null,
			var_10_2 : $("input#var_10_2").val() != "" ? $("input#var_10_2").val() : null,
			var_10_3 : $("input#var_10_3").val() != "" ? $("input#var_10_3").val() : null,
			var_10_4 : $("input#var_10_4").val() != "" ? $("input#var_10_4").val() : null,
			var_10_5 : $("input#var_10_5").val() != "" ? $("input#var_10_5").val() : null,
			var_10_6 : $("input#var_10_6").val() != "" ? $("input#var_10_6").val() : null,
			var_11_1 : $("input#var_11_1").val() != "" ? $("input#var_11_1").val() : null,
			var_11_2 : $("input#var_11_2").val() != "" ? $("input#var_11_2").val() : null,
			var_11_3 : $("input#var_11_3").val() != "" ? $("input#var_11_3").val() : null,
			var_11_4 : $("input#var_11_4").val() != "" ? $("input#var_11_4").val() : null,
			var_11_5 : $("input#var_11_5").val() != "" ? $("input#var_11_5").val() : null,
			var_11_6 : $("input#var_11_6").val() != "" ? $("input#var_11_6").val() : null,
			var_12_1 : $("input#var_12_1").val() != "" ? $("input#var_12_1").val() : null,
			var_12_2 : $("input#var_12_2").val() != "" ? $("input#var_12_2").val() : null,
			var_12_3 : $("input#var_12_3").val() != "" ? $("input#var_12_3").val() : null,
			var_12_4 : $("input#var_12_4").val() != "" ? $("input#var_12_4").val() : null,
			var_12_5 : $("input#var_12_5").val() != "" ? $("input#var_12_5").val() : null,
			var_12_6 : $("input#var_12_6").val() != "" ? $("input#var_12_6").val() : null,
			var_13_1 : $("input#var_13_1").val() != "" ? $("input#var_13_1").val() : null,
			var_13_2 : $("input#var_13_2").val() != "" ? $("input#var_13_2").val() : null,
			var_13_3 : $("input#var_13_3").val() != "" ? $("input#var_13_3").val() : null,
			var_13_4 : $("input#var_13_4").val() != "" ? $("input#var_13_4").val() : null,
			var_13_5 : $("input#var_13_5").val() != "" ? $("input#var_13_5").val() : null,
			var_13_6 : $("input#var_13_6").val() != "" ? $("input#var_13_6").val() : null
		};
		
		return valoracionMovilDTO;
	},
};