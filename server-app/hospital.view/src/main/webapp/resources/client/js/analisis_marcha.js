var analisis_marcha = {

	'server' : function() {
		var pacienteDTO = {
			id : "2",
			analisisObserMarcha : $("#analisisObserMarcha").val()
		};

		server.post(pacienteDTO.id, pacienteDTO, null);
	}
};
