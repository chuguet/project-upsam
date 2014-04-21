define(["../../cordova", "../index", "../jquery/jquery-1.9.1.min", "../jquery/jquery.mobile-1.4.1", "../ctrl.generic", "../server"], function($) {
	generic.initialize();
	exploracionFisica.recuperar();
});

var exploracionFisica = {
	'recuperar' : function(){
		var idPaciente = generic.getURLParameter("idPaciente");
		var idExploracion = generic.getURLParameter("idExploracion");
		$("#idPaciente").val(idPaciente);
		if (idExploracion != null){
			//Entramos en modo edicion
			generic.loading();
			$("#subtitle").html("Consulta de Exploraci&oacute;n");
			server.get('paciente/' + idPaciente + "/exploracion/", idExploracion, exploracion.recuperarCallback);
			$("#videos").show();
		}
		else{
			//Entramos en modo alta
			$("#subtitle").html("Nueva Exploraci&oacute;n");
			$("#videos").hide();
			generic.noLoading();
		}
	}
};
