var restricciones = {
	'recuperar' : function(){
		var idPaciente = generic.getURLParameter("idPaciente");
		var idExploracion = generic.getURLParameter("idExploracion");
		if (idPaciente != null && idExploracion != null){
			server.get('pacientemovil/' + idPaciente + "/exploracion/" + idExploracion + "/restriccion", null, restricciones.recuperarCallback);
		}
	},
	'recuperarCallback' : function(restricciones){
		if (restricciones.warningMessages != null && restricciones.warningMessages.length > 0){
			$("#iconRestricciones").show();
			$("#messageRestricciones").html(restricciones.warningMessages);
	    	generic.blink();    
		}
		else{
			$("#iconRestricciones").hide();
			$("#messageRestricciones").html("");
		}
		
		if (restricciones.infoMessages != null && restricciones.infoMessages.length > 0){
			$("#iconInfo").show();
			$("#messageInfo").html(restricciones.infoMessages);
		}
		else{
			$("#iconInfo").hide();
			$("#messageInfo").html("");
		}
	}
};