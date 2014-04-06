//Si el tipo de ayuda es 'OTROS' se muestra el campo asociado
function onchangeAyuda() {
	if ($('#ayudasMarcha').val() == '3') {
		$('#divOtraAyuda').show();
	}
	else {
		$('#divOtraAyuda').hide();
	}
}

// Si el tipo de Ortesis es 'OTROS' se muestra el campo asociado
function onchangeOrtesis() {
	if ($('#ortesis').val() == '3') {
		$('#divOtraOrtesis').show();
	}
	else {
		$('#divOtraOrtesis').hide();
	}
}