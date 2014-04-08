var longitud_miembros_inferiores = {

	'server' : function() {
		var pacienteDTO = {
			id : "2",
			lonMiembroInfDcho : $("#lonMiembroInfDcho").val(),
			lonMiembroInfIzdo : $("#lonMiembroInfIzdo").val()
		};

		server.post(pacienteDTO.id, pacienteDTO, null);
	}
};
