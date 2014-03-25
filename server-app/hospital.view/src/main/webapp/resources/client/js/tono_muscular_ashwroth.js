//Muestra/Oculta la tabla de puntuaciones del tono muscular
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