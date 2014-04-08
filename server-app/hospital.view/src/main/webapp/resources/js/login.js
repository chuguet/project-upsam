$(document).ready(function() {
	$("#submit").button();
	$("#reset").button();
	$("#forgot").button().click(function() {
		$("<div title='Recuperar contraseña'>" + "<p>Introduzca su correo electr&oacute;nico: </p>" + "<input id='email' type='text' class='text ui-widget-content ui-corner-all'></input>" + "</div>").dialog({
			resizable : false,
			width : "auto",
			modal : true,
			buttons : {
				"Aceptar" : function() {
					if (validarEmail($("#email").val())) {
						var data = {
							value : $("#email").val()
						};
						generic.post("/hospitalServer/usuario/forget", data, null);
						$(this).dialog("close");
					}
					else {
						generic.alert("Correo incorrecto", "Error");
					}
				},
				"Cancelar" : function() {
					$(this).dialog("close");
				}
			}
		});
	});
	$("#user").focus();
});
function validarEmail(valor) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(valor)) {
		return true;
	}
	else {
		return false;
	}
};