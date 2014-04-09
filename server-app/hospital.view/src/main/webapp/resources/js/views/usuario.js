var usuario = {
	'rowID' : null,
	'formatList' : function() {
		
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Nombre", "Apellidos", "Email", "Usuario", "Rol"
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
						name : 'user',
						index : 'user',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'rol',
						index : 'rol',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'center'
					}
			],
			rowNum : 6,
			rowList : [
					3,6
			],
			pager : '#paginadorLista',
			sortname : 'nombre',
			sortorder : 'asc',
			ondblClickRow : function(rowid){generic.getForm('usuario', rowid);},
			viewrecords : true,
			rownumbers : false,
			scroll : false,
			onSelectRow : function(rowid, status) {
				$("#btnEditar").button("enable");
				$("#btnEliminar").button("enable");
				usuario.rowID = rowid;
			}
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
		
		/**
		 * *****Configuraci�n de los botones del formulario de
		 * usuarios**********
		 */
		$("#btnAlta").button().click(function() {
			generic.getForm('usuario');
		});
		$("#btnEditar").button().click(function() {
			generic.getForm('usuario', $('#lista').jqGrid('getRowData', usuario.rowID).id);
		});
		$("#btnEditar").button("disable");

		$("#btnEliminar").button().click(function() {
			generic.delete('usuario', $('#lista').jqGrid('getRowData', usuario.rowID).id, function() {
				generic.getList('usuario');
			});
		});
		$("#btnEliminar").button("disable");
	},
	'formatForm' : function() {
		$("#btnCancel").button().click(function() {
			generic.getList('usuario');
		});

		$("#btnSaveUsuario").button().click(function() {
			usuario.getParams();
		});

		$("#rol").buttonset();
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var user = $("input[id=usuario]").val();
		var password = $("input[id=pwd]").val();
		var nombre = $("input[id=nombre]").val();
		var apellidos = $("input[id=apellidos]").val();
		var email = $("input[id=email]").val();
		var rol = $("input:radio[name='rol']:checked").val();
		var errores = '';
		if (nombre == '') {
			errores += '- Debe introducir el nombre<br/>';
		}
		if (apellidos == '') {
			errores += '- Debe introducir los apellidos<br/>';
		}
		if($("input:radio[name='rol']").is(":checked")==false){
			errores += '- Debe seleccionar un rol<br/>';
		}
		if (!validarEmail(email)){
			errores += '- Debe introducir un correo electr&oacute;nico correcto<br/>';
		}
		if (user == '') {
			errores += '- Debe introducir un usuario<br/>';
		}
		if (password == '') {
			errores += '- Debe introducir una contrase&ntilde;a<br/>';
		}
		if (rol == null) {
			errores += '- Debe seleccionar un rol';
		}
		if (errores != '') {
			generic.alert(errores, "Validaci&oacute;n");
		}
		else {
			var data = {
				id : id,
				nombre : nombre,
				apellidos : apellidos,
				email : email,
				user : user,
				password : password,
				rol : rol
			};
			var entity = (id != null) ? 'usuario/' + id : 'usuario';
			generic.post(entity, data, function() {
				generic.getList('usuario');
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