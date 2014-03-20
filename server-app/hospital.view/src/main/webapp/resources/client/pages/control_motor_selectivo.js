function server() {
	var pacienteDTO = {
		id : "1",
		expediente : $("#valoracionCtrlMotor").val()
	}
	generic.post(pacienteDTO.id, pacienteDTO, null);
}
