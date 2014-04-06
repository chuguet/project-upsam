//En caso de tener epilepsia se muestran campos asociados:
function onchangeEpilepsia() {

	if ($('#epilepsia').val() == '1') {
		$('#divEpilepsia').show();
	}
	else {
		$('#divEpilepsia').hide();
	}
}

// En caso de tener Alteraciones (Lenguaje/Cognicion) se muestran campos
// asociados:
function onchangeLenguaje() {
	if ($('#lenguaje').val() == '1') {
		$('#divLenguaje').show();
	}
	else {
		$('#divLenguaje').hide();
	}
}