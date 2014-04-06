var tono_muscular_ashworth = {
	'puntuaciones' : function() {
		if ($('#divPuntuaciones').css('display') == 'none') {
			$('#divPuntuaciones').show();
			$('#textPuntuaciones').text('Ocultar puntuaciones');
		}
		else {
			$('#textPuntuaciones').text('Ver puntuaciones');
			$('#divPuntuaciones').hide();
		}
	},
	'server' : function() {
		var ashworthDTO = {
			id : "2",

			// cadera:
			caderaIzFlex : $("#caderaIzFlex").val(),
			caderaDerFlex : $("#caderaDerFlex").val(),
			caderaIzInflex : $("#caderaIzInflex").val(),
			caderaDerInflex : $("#caderaDerInflex").val(),

			// rodilla:
			rodillaIzFlex : $("#rodillaIzFlex").val(),
			rodillaDerFlex : $("#rodillaDerFlex").val(),
			rodillaIzInflex : $("#rodillaIzInflex").val(),
			rodillaDerInflex : $("#rodillaDerInflex").val(),

			// tobillo:
			tobilloIzflex : $("#tobilloIzflex").val(),
			tobilloDerflex : $("#tobilloDerflex").val(),
			tobilloIzInflex : $("#tobilloIzInflex").val(),
			tobilloDerInflex : $("#tobilloDerInflex").val()

		};

		alert('hago la llamada');

		// server.post(pacienteDTO.id, pacienteDTO, null);
	}
};
