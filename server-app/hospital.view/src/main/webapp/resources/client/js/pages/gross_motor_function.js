define([
		"../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"
], function($) {
	generic.initialize();
	grossMotorFunction.recuperar();
});

var grossMotorFunction = {
	'recuperar' : function(){
		var idPaciente = generic.getURLParameter("idPaciente");
		var idExploracion = generic.getURLParameter("idExploracion");
		$("#idPaciente").val(idPaciente);
		$("#idExploracion").val(idExploracion);
		generic.loading();
		server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion + "/grossMotorFunction", null, grossMotorFunction.recuperarCallback);
	},
	
	'recuperarCallback' : function(gross){
		if (gross != null){
			$("#idGross").val(gross.id);
			$("#subtitle").html("Consulta de Gross Motor Function");
			$("#btnGuardar").text("Modificar");
			if (gross.var1 != null){
				$("input[name=1][value='" + gross.var1 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var2 != null){
				$("input[name=2][value='" + gross.var2 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var3 != null){
				$("input[name=3][value='" + gross.var3 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var4 != null){
				$("input[name=4][value='" + gross.var4 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var5 != null){
				$("input[name=5][value='" + gross.var5 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var6 != null){
				$("input[name=6][value='" + gross.var6 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var7 != null){
				$("input[name=7][value='" + gross.var7 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var8 != null){
				$("input[name=8][value='" + gross.var8 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var9 != null){
				$("input[name=9][value='" + gross.var9 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var10 != null){
				$("input[name=10][value='" + gross.var10 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var11 != null){
				$("input[name=11][value='" + gross.var11 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var12 != null){
				$("input[name=12][value='" + gross.var12 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var13 != null){
				$("input[name=13][value='" + gross.var13 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var14 != null){
				$("input[name=14][value='" + gross.var14 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var15 != null){
				$("input[name=15][value='" + gross.var15 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var16 != null){
				$("input[name=16][value='" + gross.var16 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var17 != null){
				$("input[name=17][value='" + gross.var17 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var18 != null){
				$("input[name=18][value='" + gross.var18 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var19 != null){
				$("input[name=19][value='" + gross.var19 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var20 != null){
				$("input[name=20][value='" + gross.var20 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var21 != null){
				$("input[name=21][value='" + gross.var21 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var22 != null){
				$("input[name=22][value='" + gross.var22 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var23 != null){
				$("input[name=23][value='" + gross.var23 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var24 != null){
				$("input[name=24][value='" + gross.var24 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var25 != null){
				$("input[name=25][value='" + gross.var25 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var26 != null){
				$("input[name=26][value='" + gross.var26 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var27 != null){
				$("input[name=27][value='" + gross.var27 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var28 != null){
				$("input[name=28][value='" + gross.var28 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var29 != null){
				$("input[name=29][value='" + gross.var29 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var30 != null){
				$("input[name=30][value='" + gross.var30 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var31 != null){
				$("input[name=31][value='" + gross.var31 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var32 != null){
				$("input[name=32][value='" + gross.var32 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var33 != null){
				$("input[name=33][value='" + gross.var33 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var34 != null){
				$("input[name=34][value='" + gross.var34 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var35 != null){
				$("input[name=35][value='" + gross.var35 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var36 != null){
				$("input[name=36][value='" + gross.var36 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.var37 != null){
				$("input[name=37][value='" + gross.var37 + "']").prop("checked", true).checkboxradio("refresh");
			}
			if (gross.comentarios != null){
				$("#comentarios").val(gross.comentarios);
			}
			if (gross.evaluacionIndicativa != null){
				var eval = (gross.evaluacionIndicativa) ? 1 : 0;
				$("#evaluacionIndicativa").val(eval);
				$("#evaluacionIndicativa").slider("refresh");
			}
			
		}
		generic.noLoading();
	},
	
	'insertar' : function() {
		var grossMovilDTO = grossMotorFunction.recogerCamposDePantalla();
		var idPaciente = $("#idPaciente").val();
		var idExploracion = $("#idExploracion").val();
		
		
		if (grossMovilDTO != null) {
			generic.loading();
			if (grossMovilDTO.id == null) {
				// insert
				server.post("pacientemovil/" + idPaciente + "/exploracion/" + idExploracion + "/grossMotorFunction", grossMovilDTO, grossMotorFunction.insertarCallback);
			}
			else {
				// update
				server.post("pacientemovil/" + idPaciente + "/exploracion/" + idExploracion + "/grossMotorFunction/" + grossMovilDTO.id, grossMovilDTO, grossMotorFunction.actualizarCallback);
			}
		}
	},

	'insertarCallback' : function(params) {
		$("#subtitle").html("Consulta de Gross Motor Function Classification System");
		$("#btnGuardar").text("Modificar");
		$("#idGross").val(params.parameter.id);
		generic.noLoading();
	},
	
	'actualizarCallback' : function(params) {
		generic.noLoading();
	},
	
	'recogerCamposDePantalla' : function() {
		for (var i =1; i < 38; i++){
			$("#lbl" + i).css("background-color", "transparent");
			$("#lbl" + i).css("color", "#056994");
		}
		var grossMovilDTO = {
			id : $("#idGross").val() != "" ? $("#idGross").val() : null,
			idExploracion : $("#idExploracion").val(),
			var1 : $("input:radio[name ='1']:checked").length > 0 ? parseInt($("input:radio[name ='1']:checked").val()) : null,
			var2 : $("input:radio[name ='2']:checked").length > 0 ? parseInt($("input:radio[name ='2']:checked").val()) : null,
			var3 : $("input:radio[name ='3']:checked").length > 0 ? parseInt($("input:radio[name ='3']:checked").val()) : null,
			var4 : $("input:radio[name ='4']:checked").length > 0 ? parseInt($("input:radio[name ='4']:checked").val()) : null,
			var5 : $("input:radio[name ='5']:checked").length > 0 ? parseInt($("input:radio[name ='5']:checked").val()) : null,
			var6 : $("input:radio[name ='6']:checked").length > 0 ? parseInt($("input:radio[name ='6']:checked").val()) : null,
			var7 : $("input:radio[name ='7']:checked").length > 0 ? parseInt($("input:radio[name ='7']:checked").val()) : null,
			var8 : $("input:radio[name ='8']:checked").length > 0 ? parseInt($("input:radio[name ='8']:checked").val()) : null,
			var9 : $("input:radio[name ='9']:checked").length > 0 ? parseInt($("input:radio[name ='9']:checked").val()) : null,
			var10 : $("input:radio[name ='10']:checked").length > 0 ? parseInt($("input:radio[name ='10']:checked").val()) : null,
			var11 : $("input:radio[name ='11']:checked").length > 0 ? parseInt($("input:radio[name ='11']:checked").val()) : null,
			var12 : $("input:radio[name ='12']:checked").length > 0 ? parseInt($("input:radio[name ='12']:checked").val()) : null,
			var13 : $("input:radio[name ='13']:checked").length > 0 ? parseInt($("input:radio[name ='13']:checked").val()) : null,
			var14 : $("input:radio[name ='14']:checked").length > 0 ? parseInt($("input:radio[name ='14']:checked").val()) : null,
			var15 : $("input:radio[name ='15']:checked").length > 0 ? parseInt($("input:radio[name ='15']:checked").val()) : null,
			var16 : $("input:radio[name ='16']:checked").length > 0 ? parseInt($("input:radio[name ='16']:checked").val()) : null,
			var17 : $("input:radio[name ='17']:checked").length > 0 ? parseInt($("input:radio[name ='17']:checked").val()) : null,
			var18 : $("input:radio[name ='18']:checked").length > 0 ? parseInt($("input:radio[name ='18']:checked").val()) : null,
			var19 : $("input:radio[name ='19']:checked").length > 0 ? parseInt($("input:radio[name ='19']:checked").val()) : null,
			var20 : $("input:radio[name ='20']:checked").length > 0 ? parseInt($("input:radio[name ='20']:checked").val()) : null,
			var21 : $("input:radio[name ='21']:checked").length > 0 ? parseInt($("input:radio[name ='21']:checked").val()) : null,
			var22 : $("input:radio[name ='22']:checked").length > 0 ? parseInt($("input:radio[name ='22']:checked").val()) : null,
			var23 : $("input:radio[name ='23']:checked").length > 0 ? parseInt($("input:radio[name ='23']:checked").val()) : null,
			var24 : $("input:radio[name ='24']:checked").length > 0 ? parseInt($("input:radio[name ='24']:checked").val()) : null,
			var25 : $("input:radio[name ='25']:checked").length > 0 ? parseInt($("input:radio[name ='25']:checked").val()) : null,
			var26 : $("input:radio[name ='26']:checked").length > 0 ? parseInt($("input:radio[name ='26']:checked").val()) : null,
			var27 : $("input:radio[name ='27']:checked").length > 0 ? parseInt($("input:radio[name ='27']:checked").val()) : null,
			var28 : $("input:radio[name ='28']:checked").length > 0 ? parseInt($("input:radio[name ='28']:checked").val()) : null,
			var29 : $("input:radio[name ='29']:checked").length > 0 ? parseInt($("input:radio[name ='29']:checked").val()) : null,
			var30 : $("input:radio[name ='30']:checked").length > 0 ? parseInt($("input:radio[name ='30']:checked").val()) : null,
			var31 : $("input:radio[name ='31']:checked").length > 0 ? parseInt($("input:radio[name ='31']:checked").val()) : null,
			var32 : $("input:radio[name ='32']:checked").length > 0 ? parseInt($("input:radio[name ='32']:checked").val()) : null,
			var33 : $("input:radio[name ='33']:checked").length > 0 ? parseInt($("input:radio[name ='33']:checked").val()) : null,
			var34 : $("input:radio[name ='34']:checked").length > 0 ? parseInt($("input:radio[name ='34']:checked").val()) : null,
			var35 : $("input:radio[name ='35']:checked").length > 0 ? parseInt($("input:radio[name ='35']:checked").val()) : null,
			var36 : $("input:radio[name ='36']:checked").length > 0 ? parseInt($("input:radio[name ='36']:checked").val()) : null,
			var37 : $("input:radio[name ='37']:checked").length > 0 ? parseInt($("input:radio[name ='37']:checked").val()) : null,
			comentarios : $("#comentarios").val(),
			evaluacionIndicativa : $("#evaluacionIndicativa").val() == 1 ? true : false
			
		};
		var errores = "";
		for (var i =1; i < 38; i++){
			if ($("input:radio[name ='" + i + "']:checked").length == 0){
				errores = " - Tiene que contestar todas las preguntas del test";
				$("#lbl" + i).css("background-color", "red");
				$("#lbl" + i).css("color", "white");
			}
		}
		
		
		if (errores != "") {
			errores = "Se han producido los siguientes errores:<br/>" + errores;
			generic.alert("Error gestión de exploraciones", errores, null);
			return null;
		}
		return grossMovilDTO;
	},
};