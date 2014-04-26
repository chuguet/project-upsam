define([
		"../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"
], function($) {
	generic.initialize();
	exploracionFisica.recuperar();
});

var antecedentesPersonales = {
		'recuperar' : function(){
//			var idPaciente = generic.getURLParameter("idPaciente");
//			var idExploracion = generic.getURLParameter("idExploracion");
//			$("#idPaciente").val(idPaciente);
//			server.get('pacientemovil/' + idPaciente, null, exploracionFisica.recuperarPacienteCallback);
//			if (idExploracion != null){
//				$("#idExploracion").val(idExploracion);
//				//Entramos en modo edicion
//				generic.loading();
//				$("#subtitle").html("Consulta de Exploraci&oacute;n");
//				server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion, null, exploracionFisica.recuperarCallback);
//				$("#listaVideos").show();
//			}
//			else{
//				//Entramos en modo alta
//				$("#subtitle").html("Nueva Exploraci&oacute;n");
//				$("#lblFechaExploracion").html(generic.getActualDate());
//				$("#listaVideos").hide();
//				generic.noLoading();
//			}
		},
		
		//En caso de tener epilepsia se muestran campos asociados:
		'onChangeEpilepsia' : function() {

			if ($('#epilepsia').val() == '1') {
				$('#divEpilepsia').show();
			}
			else {
				$('#divEpilepsia').hide();
			}
		},

		//En caso de tener caidas por encima de la media se muestran campos asociados:
		'onChangeHistorialCaidas' : function() {

			if ($('#caidas').val() == '1') {
				$('#divCaidas').show();
			}
			else {
				$('#divCaidas').hide();
			}
		}
};


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