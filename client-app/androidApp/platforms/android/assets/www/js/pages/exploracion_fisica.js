var evaluacion_muscular_manual = {
	'puntuaciones' : function() {
		if ($('#divPuntuaciones').css('display') == 'none') {
			$('#divPuntuaciones').show();
			$('#textPuntuaciones').text('Ocultar puntuaciones');
		}
		else {
			$('#textPuntuaciones').text('Ver puntuaciones');
			$('#divPuntuaciones').hide();
		}
	},
	'server' : function() {
		var pacienteDTO = {
			id : "2",
			evalMuscularManual : $("#evalMuscularManual").val()
		};

		server.post(pacienteDTO.id, pacienteDTO, null);
	}
};
