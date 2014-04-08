var analisis_marcha = {

	'server' : function() {
		var pacienteDTO = {
			id : "2",
			analisisObserMarcha : $("#analisisObserMarcha").val()
		};

		server.post("paciente/" + pacienteDTO.id, pacienteDTO, null);
	}
};
