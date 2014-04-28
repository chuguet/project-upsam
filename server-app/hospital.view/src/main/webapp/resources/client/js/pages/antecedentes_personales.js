define([
		"../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"
], function($) {
	generic.initialize();
	antecedentesPersonales.recuperar();
});

var antecedentesPersonales = {
		'recuperar' : function(){
			var idPaciente = generic.getURLParameter("idPaciente");
			var idExploracion = generic.getURLParameter("idExploracion");
			$("#idPaciente").val(idPaciente);
			$("#idExploracion").val(idExploracion);
			generic.loading();
			server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion + "/antecedentesPersonales", null, antecedentesPersonales.recuperarCallback);
		},
		
		'recuperarCallback' : function(antecedentes){
			if (antecedentes.id != null){
				$("#idAntecedentes").val(antecedentes.id);
				$(".subtitle").html("Consulta de Antecedentes Personales");
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
				$(".subtitle").html("Nuevos Antecedentes Personales");
			}
			generic.noLoading();
		},
		
		//En caso de tener epilepsia se muestran campos asociados:
		'onChangeEpilepsia' : function() {
			if ($('#epilepsia').val() == '1') {
				$('#divEpilepsia').show();
			}
			else {
				$('#divEpilepsia').hide();
				$("#tipoEpilepsia").val("");
				$("#fechaUltimaCrisis").val("");
				$("#fechaUltimaConvulsion").val("");
				$("#numeroCrisis").val(0);
			}
		},

		//En caso de tener caidas por encima de la media se muestran campos asociados:
		'onChangeHistorialCaidas' : function() {

			if ($('#caidas').val() == '1') {
				$('#divCaidas').show();
			}
			else {
				$('#divCaidas').hide();
				$("#numeroCaidas").val(0);
				$("#fechaUltimaCaida").val("");
			}
		},
		
		'onChangeLenguaje' : function() {
			if ($('#lenguajeCognicion').val() == '1') {
				$('#divLenguajeCognicion').show();
			}
			else {
				$('#divLenguajeCognicion').hide();
				$("#entiendeOrdenesSimples option[value=0]").attr("selected", true).change();
				$("#entiendeOrdenesComplejas option[value=0]").attr("selected", true).change();
				$("#expresarNecesidadDolor option[value=0]").attr("selected", true).change();
			}
		},
		
		'insertar' : function() {
			var antecedentesPersonalesDTO = antecedentesPersonales.recogerCamposDePantalla();
			var idPaciente = $("#idPaciente").val();
			var idExploracion = $("#idExploracion").val();
			
			if (antecedentesPersonalesDTO != null) {
				generic.loading();
				var uri = "pacientemovil/" + idPaciente + "/exploracion/" + idExploracion + "/antecedentesPersonales";
				if (antecedentesPersonalesDTO.id == null) {
					// insert
					server.post(uri, antecedentesPersonalesDTO, antecedentesPersonales.insertarCallback);
				}
				else {
					// update
					server.post(uri + "/" + antecedentesPersonalesDTO.id, antecedentesPersonalesDTO, antecedentesPersonales.actualizarCallback);
				}
			}
		},

		'insertarCallback' : function(params) {
			$("#subtitle").html("Consulta de antecedentes personales");
			$("#btnGuardar").text("Modificar");
			$("#idAntecedentes").val(params.parameter.id);
			generic.noLoading();
		},
		
		'actualizarCallback' : function(params) {
			generic.noLoading();
		},
		
		'recogerCamposDePantalla' : function() {
			var antecedentesPersonalesDTO = {
				id : $("#idAntecedentes").val() != "" ? parseInt($("#idAntecedentes").val()) : null,
				idExploracion : $("#idExploracion").val() != "" ? parseInt($("#idExploracion").val()) : null,
				epilepsia : $("#epilepsia").val() + "" != "" ? parseInt($("#epilepsia").val()) : null,
				tipoEpilepsia : $("#tipoEpilepsia").val() + "" != "" ? $("#tipoEpilepsia").val() : null,
				fechaUltimaCrisis : $("#fechaUltimaCrisis").val() + "" != "" ?$("#fechaUltimaCrisis").val() : null,
				fechaUltimaConvulsion : $("#fechaUltimaConvulsion").val() + "" != "" ? $("#fechaUltimaConvulsion").val() : null,
				numeroCrisis : $("#numeroCrisis").val() + "" != "" ? parseInt($("#numeroCrisis").val()) : null,
				caidas : $("#caidas").val() + "" != "" ? parseInt($("#caidas").val()): null,
				numeroCaidas : $("#numeroCaidas").val() + "" != "" ? parseInt($("#numeroCaidas").val()) : null,
				fechaUltimaCaida : $("#fechaUltimaCaida").val() + "" != "" ? $("#fechaUltimaCaida").val() : null,
				audicion : $("#audicion").val() + "" != "" ? $("#audicion").val() : null,
				vision : $("#vision").val() + "" != "" ? $("#vision").val() : null,
				lenguajeCognicion : $("#lenguajeCognicion").val() + "" != "" ? parseInt($("#lenguajeCognicion").val()) : null,
				comprension : $("input:radio[name ='comprension']:checked").length > 0 ? $("input:radio[name ='comprension']:checked").val() : null,
				entiendeOrdenesSimples : $("#entiendeOrdenesSimples").val() + "" != "" ? parseInt($("#entiendeOrdenesSimples").val()) : null,
				entiendeOrdenesComplejas : $("#entiendeOrdenesComplejas").val() + "" != "" ? parseInt($("#entiendeOrdenesComplejas").val()) : null,
				expresarNecesidadDolor : $("#expresarNecesidadDolor").val() + "" != "" ?parseInt( $("#expresarNecesidadDolor").val()) : null,
				numeroInyecciones : $("#numeroInyecciones").val() + "" != "" ? parseInt($("#numeroInyecciones").val()) : null,
				fechaUltimaSesion : $("#fechaUltimaSesion").val() + "" != "" ? $("#fechaUltimaSesion").val() : null,
				fechaPenultimaSesion : $("#fechaPenultimaSesion").val() + "" != "" ? $("#fechaPenultimaSesion").val() : null,
				localizacionTratamiento : $("#localizacionTratamiento").val() + "" != "" ? parseInt($("#localizacionTratamiento").val()) : null,
				alergias : $("#alergias").val() + "" != "" ? $("#alergias").val() : null,
				tratamiento : $("#tratamiento").val() + "" != "" ? $("#tratamiento").val() : null
			};
			
			var errores = "";
			if (antecedentesPersonalesDTO.fechaUltimaCrisis != null && !generic.validateDate(antecedentesPersonalesDTO.fechaUltimaCrisis)){
				errores += " - La fecha de la ultima crisis no tiene un formato valido (dd/mm/aaaa)";
			}
			if (antecedentesPersonalesDTO.fechaUltimaConvulsion != null && !generic.validateDate(antecedentesPersonalesDTO.fechaUltimaConvulsion)){
				errores += " - La fecha de la ultima convulsion no tiene un formato valido (dd/mm/aaaa)";
			}
			if (antecedentesPersonalesDTO.fechaUltimaSesion != null && !generic.validateDate(antecedentesPersonalesDTO.fechaUltimaSesion)){
				errores += " - La fecha de la ultima sesion no tiene un formato valido (dd/mm/aaaa)";
			}
			if (antecedentesPersonalesDTO.fechaPenultimaSesion != null && !generic.validateDate(antecedentesPersonalesDTO.fechaPenultimaSesion)){
				errores += " - La fecha de la penultima sesion no tiene un formato valido (dd/mm/aaaa)";
			}
			if (errores != "") {
				errores = "Se han producido los siguientes errores:<br/>" + errores;
				generic.alert("Error en antecedentes personales", errores, null);
				return null;
			}
			return antecedentesPersonalesDTO;
		}
};