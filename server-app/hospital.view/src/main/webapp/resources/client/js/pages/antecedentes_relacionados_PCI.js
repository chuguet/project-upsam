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
			if (antecedentes.cuadriplejiaEspatica){
				$("#cuadriplejiaEspatica").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.triplejiaEspatica){
				$("#triplejiaEspatica").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.diplejiaEspatica){
				$("#diplejiaEspatica").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.pciMixta){
				$("#pciMixta").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.otra){
				$("#otra").attr('checked', 'checked').checkboxradio('refresh');
				$("#divEspecificar").show();
				$("#diagnosticoEspecificar").val(antecedentes.diagnosticoEspecificar);
			}
			$("#etiologia").val(antecedentes.etiologia);
			$("#localizacion").val(antecedentes.localizacion);
			
			if (antecedentes.gradoI){
				$("#grado1").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.gradoII){
				$("#grado2").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.gradoIII){
				$("#grado3").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.gradoIV){
				$("#grado4").attr('checked', 'checked').checkboxradio('refresh');
			}
			if (antecedentes.gradoV){
				$("#grado5").attr('checked', 'checked').checkboxradio('refresh');
			}
			
			$("#pruebasComplementarias").val(antecedentes.pruebasComplementarias);
			$("#equipamiento").val(antecedentes.equipamiento);
			$("#ayudasMarcha option[value=" + antecedentes.ayudasMarcha + "]").attr("selected", true).change();
			if(antecedentes.ayudasMarcha == 3){
				$("#divOtraAyuda").show();
				$("#otras").val(antecedentes.otras);
			}
			
			$("#interiores").val(antecedentes.interiores);
			$("#exteriores").val(antecedentes.exteriores);
			$("#dispositivoMasUsado").val(antecedentes.dispositivoMasUsado);
			$("#ortesisDiurna option[value=" + antecedentes.ortesisDiurna + "]").attr("selected", true).change();
			if(antecedentes.ortesisDiurna == 3){
				$("#divOtraOrtesis").show();
				$("#otraOrtesis").val(antecedentes.otraOrtesis);
			}
			$("#ortesisNocturna").val(antecedentes.ortesisNocturna);
			$("#tratamientoActual").val(antecedentes.tratamientoActual);
			$("#terapiasHabituales").val(antecedentes.terapiasHabituales);
			if (antecedentes.fisioterapiaSesiones != null){
				$("#fisioterapiaSesiones").val(antecedentes.fisioterapiaSesiones);
				$("#fisioterapiaSesiones").slider("refresh");
			}
			$("#fisioterapiaDuracion").val(antecedentes.fisioterapiaDuracion);
			
			if (antecedentes.terapiaOcupacionalSesiones != null){
				$("#terapiaOcupacionalSesiones").val(antecedentes.terapiaOcupacionalSesiones);
				$("#terapiaOcupacionalSesiones").slider("refresh");
			}
			$("#terapiaOcupacionalDuracion").val(antecedentes.terapiaOcupacionalDuracion);
			
			if (antecedentes.lgSesiones != null){
				$("#lgSesiones").val(antecedentes.lgSesiones);
				$("#lgSesiones").slider("refresh");
			}
			$("#lgDuracion").val(antecedentes.lgDuracion);
			$("#hidroterapia").val(antecedentes.hidroterapia);
			$("#otrasTerapias").val(antecedentes.otrasTerapias);
			$("#deportes").val(antecedentes.deportes);
		}
		else{
			//Entramos en modo alta
			$(".subtitle").html("Nuevos Antecedentes Relacionados con PCI");
		}
		generic.noLoading();
	},
	'onChangeOtrosDiagnosticos' : function() {
		if ($("#otra").is(':checked')) {
			$('#divEspecificar').show();
		}
		else {
			$('#divEspecificar').hide();
		}
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
		if ($('#ortesisDiurna').val() == '3') {
			$('#divOtraOrtesis').show();
		}
		else {
			$('#divOtraOrtesis').hide();
		}
	},
	
	'insertar' : function() {
		var antecedentesDTO = antecedentesRelacionadosPCI.recogerCamposDePantalla();
		var idPaciente = $("#idPaciente").val();
		var idExploracion = $("#idExploracion").val();
		
		if (antecedentesDTO != null) {
			generic.loading();
			var uri = "pacientemovil/" + idPaciente + "/exploracion/" + idExploracion + "/antecedentesRelacionadosPCI";
			if (antecedentesDTO.id == null) {
				// insert
				server.post(uri, antecedentesDTO, antecedentesRelacionadosPCI.insertarCallback);
			}
			else {
				// update
				server.post(uri + "/" + antecedentesDTO.id, antecedentesDTO, antecedentesRelacionadosPCI.actualizarCallback);
			}
		}
	},

	'insertarCallback' : function(params) {
		$(".subtitle").html("Consulta de Antecedentes relacionados con PCI");
		$("#btnGuardar").text("Modificar");
		$("#idAntecedentes").val(params.parameter.id);
		generic.noLoading();
	},
	
	'actualizarCallback' : function(params) {
		generic.noLoading();
	},
	
	'recogerCamposDePantalla' : function() {
		var antecedentesDTO = {
			id : $("#idAntecedentes").val() != "" ? parseInt($("#idAntecedentes").val()) : null,
			idExploracion : $("#idExploracion").val() != "" ? parseInt($("#idExploracion").val()) : null,
			cuadriplejiaEspatica: $("#cuadriplejiaEspatica").is(':checked'),	
			triplejiaEspatica: $("#triplejiaEspatica").is(':checked'),
			diplejiaEspatica: $("#diplejiaEspatica").is(':checked'),
			pciMixta: $("#pciMixta").is(':checked'),
			otra: $("#otra").is(':checked'),
			diagnosticoEspecificar : $("#diagnosticoEspecificar").val() + "" != "" ? $("#diagnosticoEspecificar").val() : null,
			etiologia : $("#etiologia").val() + "" != "" ? $("#etiologia").val() : null,
			localizacion : $("#localizacion").val() + "" != "" ? $("#localizacion").val() : null,
			gradoI : $("#grado1").is(':checked'),
			gradoII : $("#grado2").is(':checked'),
			gradoIII : $("#grado3").is(':checked'),
			gradoIV : $("#grado4").is(':checked'),
			gradoV : $("#grado5").is(':checked'),
			pruebasComplementarias : $("#pruebasComplementarias").val() + "" != "" ? $("#pruebasComplementarias").val() : null,
			equipamiento : $("#equipamiento").val() + "" != "" ? $("#equipamiento").val() : null,		
			ayudasMarcha : $("#ayudasMarcha").val() + "" != "" ? parseInt($("#ayudasMarcha").val()) : null,				
			otras : $("#otras").val() + "" != "" ? $("#otras").val() : null,			
			interiores : $("#interiores").val() + "" != "" ? $("#interiores").val() : null,
			exteriores : $("#exteriores").val() + "" != "" ? $("#exteriores").val() : null,
			dispositivoMasUsado : $("#dispositivoMasUsado").val() + "" != "" ? $("#dispositivoMasUsado").val() : null,
			ortesisDiurna : $("#ortesisDiurna").val() + "" != "" ? parseInt($("#ortesisDiurna").val()) : null,
			otraOrtesis  : $("#otraOrtesis").val() + "" != "" ? $("#otraOrtesis").val() : null,
			exteriores : $("#exteriores").val() + "" != "" ? $("#exteriores").val() : null,
			ortesisNocturna : $("#ortesisNocturna").val() + "" != "" ? $("#ortesisNocturna").val() : null,
			tratamientoActual : $("#tratamientoActual").val() + "" != "" ? $("#tratamientoActual").val() : null,
			terapiasHabituales : $("#terapiasHabituales").val() + "" != "" ? $("#terapiasHabituales").val() : null,
			fisioterapiaSesiones : $("#fisioterapiaSesiones").val() + "" != "" ? parseInt($("#fisioterapiaSesiones").val()) : null,
			fisioterapiaDuracion : $("#fisioterapiaDuracion").val() + "" != "" ? $("#fisioterapiaDuracion").val() : null,
			terapiaOcupacionalSesiones : $("#terapiaOcupacionalSesiones").val() + "" != "" ? parseInt($("#terapiaOcupacionalSesiones").val()) : null,
			terapiaOcupacionalDuracion : $("#terapiaOcupacionalDuracion").val() + "" != "" ? $("#terapiaOcupacionalDuracion").val() : null,
			lgSesiones : $("#lgSesiones").val() + "" != "" ? parseInt($("#lgSesiones").val()) : null,
			lgDuracion : $("#lgDuracion").val() + "" != "" ? $("#lgDuracion").val() : null,
			hidroterapia : $("#hidroterapia").val() + "" != "" ? $("#hidroterapia").val() : null,
			otrasTerapias : $("#otrasTerapias").val() + "" != "" ? $("#otrasTerapias").val() : null,
			deportes : $("#deportes").val() + "" != "" ? $("#deportes").val() : null
		};
		
		var errores = "";
		
		if (antecedentesDTO.otra && antecedentesDTO.diagnosticoEspecificar == null) {
			errores += " - Debe especificar el otro diagnóstico PCI tipo";
		}
		
		if (antecedentesDTO.ayudasMarcha == 3 && antecedentesDTO.otras == null) {
			errores += " - Debe especificar las otras ayudas a la marcha que ha recibido";
		}
		
		if (antecedentesDTO.ortesisDiurna == 3 && antecedentesDTO.otraOrtesis == null) {
			errores += " - Debe especificar la otra ortesis diurna";
		}
		
		if (errores != "") {
			errores = "Se han producido los siguientes errores:<br/>" + errores;
			generic.alert("Error en antecedentes personales", errores, null);
			return null;
		}
		return antecedentesDTO;
	}
};