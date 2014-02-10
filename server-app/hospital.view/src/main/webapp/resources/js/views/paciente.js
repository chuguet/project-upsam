var paciente = {
	'rowID' : null,
	'formatList' : function() {
		
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Nombre", "Apellidos", "Email", "Expediente"
			],
			colModel : [
					{
						name : 'id',
						index : 'id',
						width : 0,
						hidden : true
					}, {
						name : 'nombre',
						index : 'nombre',
						width : 30,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'apellidos',
						index : 'apellidos',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},  {
						name : 'email',
						index : 'email',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					},{
						name : 'expediente',
						index : 'expediente',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					}
			],
			rowNum : 6,
			rowList : [
					3,6
			],
			pager : '#paginadorLista',
			sortname : 'nombre',
			sortorder : 'asc',
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnEditar").button("enable");
				$("#btnEliminar").button("enable");
				paciente.rowID = rowid;
			}
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		/**
		 * *****Configuración de los botones del formulario de
		 * pacientes**********
		 */
		$("#btnAlta").button().click(function() {
			generic.getForm('paciente');
		});
		$("#btnEditar").button().click(function() {
			generic.getForm('paciente', $('#lista').jqGrid('getRowData', paciente.rowID).id);
		});
		$("#btnEditar").button("disable");

		$("#btnEliminar").button().click(function() {
			generic.delete('paciente', $('#lista').jqGrid('getRowData', paciente.rowID).id, function() {
				generic.getList('paciente');
			});
		});
		$("#btnEliminar").button("disable");
	},

	'formatForm' : function() {
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		$("#btnCancel").button().click(function() {
			generic.getList('paciente');
		});

		$("#btnSavePaciente").button().click(function() {
			paciente.getParams();
		});
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var nombre = $("input[id=nombre]").val();
		var apellidos = $("input[id=apellidos]").val();
		var email = $("input[id=email]").val();
		var expediente = $("input[id=expediente]").val();
		var fichero = $("input[id=fichero]").val();
		var errores = '';
		if (nombre == '') {
			errores += '- Debe introducir el nombre<br/>';
		}
		if (apellidos == '') {
			errores += '- Debe introducir los apellidos<br/>';
		}
		if (!validarEmail(email)){
			errores += '- Debe introducir un correo electronico correcto<br/>';
		}
		if (expediente == '') {
			errores += '- Debe introducir un c&oacute;digo de expediente<br/>';
		}
		if (errores != '') {
			jAlert(errores, "Validaci&oacute;n");
		}
		else {
			var data = {
				id : id,
				nombre : nombre,
				apellidos : apellidos,
				email : email,
				expediente : expediente,
				fichero : fichero
			};
			var entity = (id != null) ? 'paciente/' + id : 'paciente';
			generic.post(entity, data, function() {
				generic.getList('paciente');
			});
		};
	}
};
function validarEmail(valor) {
	  if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(valor)){
		  return true;
	  } else {
		  return false;
	  }
};