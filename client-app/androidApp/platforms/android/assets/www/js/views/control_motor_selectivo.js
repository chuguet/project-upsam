//Muestra/Oculta la tabla de puntuaciones del control motor selectivo
function puntuaciones() {
	if ($('#divPuntuaciones').css('display') == 'none') {
		$('#divPuntuaciones').show();
		$('#textPuntuaciones').text('Ocultar puntuaciones');
	}
	else {
		$('#textPuntuaciones').text('Ver puntuaciones');
		$('#divPuntuaciones').hide();
	}
}

function server() {
	var pacienteDTO = {
		id : "1",
		expediente : $("#valoracionCtrlMotor").val()
	}
	generic.post(pacienteDTO.id, pacienteDTO, null);
}