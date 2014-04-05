var control_motor_selectivo = {
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
			controlMotorSelectivo : $("#valoracionCtrlMotor").val()
		};

		server.post(pacienteDTO.id, pacienteDTO, null);
	}
};
