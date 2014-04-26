define([
		"../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"
], function($) {
	generic.initialize();
	antecedentesRelacionadosPCI.recuperar();
});

var antecedentesRelacionadosPCI = {
		'recuperar' : function(){
			var idPaciente = generic.getURLParameter("idPaciente");
			var idExploracion = generic.getURLParameter("idExploracion");
			$("#idPaciente").val(idPaciente);
			$("#idExploracion").val(idExploracion);
			generic.loading();
			server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion + "/antecedentesRelacionadosPCI", null, antecedentesRelacionadosPCI.recuperarCallback);
		},
		
		'recuperarCallback' : function(antecedentes){
			if (antecedentes.id != null){
				$("#idAntecedentes").val(antecedentes.id);
				$(".subtitle").html("Consulta de Antecedentes relacionados con PCI");
				$("#btnGuardar").text("Modificar");
				if (antecedentes.epilepsia){
					$("#divEpilepsia").show();
					$("#epilepsia option[value=1]").attr("selected", true).change();
					$("#tipoEpilepsia").val(antecedentes.tipoEpilepsia);
					$("#fechaUltimaCrisis").val(antecedentes.fechaUltimaCrisis);
					$("#fechaUltimaConvulsion").val(antecedentes.fechaUltimaConvulsion);
					$("#numeroCrisis").val(antecedentes.numeroCrisis);
					$("#numeroCrisis").slider( "refresh" );
				}
				else{
					$("#divEpilepsia").hide();
					$("#epilepsia option[value=0]").attr("selected", true).change();
					$("#tipoEpilepsia").val("");
					$("#fechaUltimaCrisis").val("");
					$("#fechaUltimaConvulsion").val("");
					$("#numeroCrisis").val(0);
					$("#numeroCrisis").slider( "refresh" );
				}
				
				if (antecedentes.caidas){
					$("#divCaidas").show();
					$("#caidas option[value=1]").attr("selected", true).change();
					$("#numeroCaidas").val(antecedentes.numeroCaidas);
					$("#numeroCaidas").slider( "refresh" );
					$("#fechaUltimaCaida").val(antecedentes.fechaUltimaCaida);
					
				}
				else{
					$('#divCaidas').hide();
					$("#caidas option[value=0]").attr("selected", true).change();
					$("#numeroCaidas").val(0);
					$("#fechaUltimaCaida").val("");
				}
				
				$("#audicion").val(antecedentes.audicion);
				$("#vision").val(antecedentes.vision);
				
				if (antecedentes.lenguajeCognicion){
					$("#divLenguajeCognicion").show();
					$("#lenguajeCognicion option[value=1]").attr("selected", true).change();
					$("input[name=comprension][value='" + antecedentes.comprension + "']").prop("checked", true).checkboxradio("refresh");
					$("#entiendeOrdenesSimples option[value=" + Number(antecedentes.entiendeOrdenesSimples) + "]").attr("selected", true).change();
					$("#entiendeOrdenesComplejas option[value=" + Number(antecedentes.entiendeOrdenesComplejas) + "]").attr("selected", true).change();
					$("#expresarNecesidadDolor option[value=" + Number(antecedentes.expresarNecesidadDolor) + "]").attr("selected", true).change();
					
				}
				else{
					$('#divLenguajeCognicion').hide();
					$("#lenguajeCognicion option[value=0]").attr("selected", true).change();
					$("#entiendeOrdenesSimples option[value=0]").attr("selected", true).change();
				}
				
				$("#numeroInyecciones").val(antecedentes.numeroInyecciones);
				$("#numeroInyecciones").slider( "refresh" );
				$("#fechaUltimaSesion").val(antecedentes.fechaUltimaSesion);
				$("#fechaPenultimaSesion").val(antecedentes.fechaPenultimaSesion);
				$("#localizacionTratamiento option[value=" + antecedentes.localizacionTratamiento + "]").attr("selected", true).change();
				
				$("#alergias").val(antecedentes.alergias);
				$("#tratamiento").val(antecedentes.tratamiento);
			}
			else{
				//Entramos en modo alta
				$(".subtitle").html("Nuevos Antecedentes Relacionados con PCI");
			}
			generic.noLoading();
		},
	'onChangeAyuda' : function() {
		if ($('#ayudasMarcha').val() == '3') {
			$('#divOtraAyuda').show();
		}
		else {
			$('#divOtraAyuda').hide();
		}
	},

	// Si el tipo de Ortesis es 'OTROS' se muestra el campo asociado
	'onChangeOrtesis' : function() {
		if ($('#ortesis').val() == '3') {
			$('#divOtraOrtesis').show();
		}
		else {
			$('#divOtraOrtesis').hide();
		}
	}
};