$("body").on({
	// When ajaxStart is fired, add 'loading' to body class
	ajaxStart : function() {
		$(this).addClass("loading");
	},
	// When ajaxStop is fired, rmeove 'loading' from body class
	ajaxStop : function() {
		$(this).removeClass("loading");
	}
});
var generic = {
	"getList" : function(entity, parameters) {
		var action = entity + '/form/list';
		this.executeHtml('GET', action, function() {
			generic.get(entity, parameters, generic.showInformation);
		});
	},
	"getForm" : function(entity, item) {
		if (item) {
			var action = entity + '/form/edit';
			this.executeHtml('GET', action, function() {
				generic.get(entity, item, generic.showInformation);
			});
		}
		else {
			var action = entity + '/form/new';
			this.executeHtml('GET', action, null);
		}
	},
	"get" : function(entity, item, callback) {
		var action = entity;
		if (item && item != null) {
			if (typeof item == "object") {
				action += "?";
				var count = 1;
				for( var o in item) {
					if (count > 1)
						action += "&";
					action += o + "=" + item[o];
					count++;
				}
				params = item;
			}
			else {
				action += '/' + item;
			}
		}
		this.executeJSon('GET', action, null, callback);
	},
	"post" : function(action, params, callback) {
		this.executeJSon('POST', action, params, callback);
	},
	"put" : function(action, params, callback) {
		this.executeJSon('PUT', action, params, callback);
	},
	"delete" : function(entity, id, callback) {
		var params = {
			'id' : id
		};
		this.executeJSon('DELETE', entity + '/' + id, params, callback);
	},
	"executeJSon" : function($method, action, data, callback) {
		$("body").addClass("loading");
		if (data != null) {
			data = JSON.stringify(data);
		}
		$.ajaxSetup({
			headers : {
				"Content-Type" : 'application/json',
				"Accept" : 'application/json'
			}
		});
		$.ajax({
			type : $method,
			url : action,
			data : data,
			dataType : 'json',
			success : function(response) {
				if ($method == 'GET') {
					if (callback) {
						var param = new Array();
						param.push(response);
						callback.apply(this, param);
					}
				}
				else {
					var cabeceraMensaje;
					if (response.correcto) {
						cabeceraMensaje = 'Operaci&oacute;n correcta';
					}
					else {
						cabeceraMensaje = 'Operaci&oacute;n incorrecta';
					}
					generic.alert(response.mensaje, cabeceraMensaje);
					if (response.correcto) {
						if (callback) {
							var param = new Array();
							param.push(response);
							callback.apply(this, param);
						}
					}
				}
			},
			error : function(e) {
				var message = 'Se ha producido un error al procesar la acci&oacute;n';
				switch (e.status) {
				case 404:
					message = 'La p&aacute;gina a la que intenta acceder no existe';
					break;
				case 403:
					message = 'No tiene permisos para acceder a esta funcionalidad';
					break;
				}
				generic.alert(message, 'Error');
			},
			complete : function() {
				$("body").removeClass("loading");
			}
		});
	},
	"executeHtml" : function($method, action, callback) {
		$("body").addClass("loading");
		$.ajaxSetup({
			headers : {
				"Content-Type" : 'text/html;charset=UTF-8',
				"Accept" : 'text/html;charset=UTF-8'
			}
		});
		$.ajax({
			type : $method,
			url : action,
			dataType : 'html',
			success : function(response) {
				if (response.indexOf('Pantalla de acceso al sistema') != -1) {
					generic.alert('Ha finalizado la sesi&oacute;n. Por favor, vuelva a acceder al sistema', 'Finalizaci&oacute;n de sesi&oacute;n', function() {
						window.location.reload(true);
					});
				}
				else {
					$('#ajax-content').html(response);
					if (callback) {
						callback.apply(this, arguments);
					}
				}
			},
			error : function(e) {
				var message = 'Se ha producido un error al procesar la acci&oacute;n';
				switch (e.status) {
				case 404:
					message = 'La p&aacute;gina a la que intenta acceder no existe';
					break;
				case 403:
					message = 'No tiene permisos para acceder a esta funcionalidad';
					break;
				}
				generic.alert(message, 'Error');
			},
			complete : function() {
				$("body").removeClass("loading");
			}
		});
	},
	'showInformation' : function() {
		var information = arguments[0];
		showInformationIntoView(information);
	},
	'preloadNecessaryFiles' : function() {
		if (!jQuery.browser.mobile) {
			require([
					"resources/js/mobile/jquery.mobile-1.2.0.min", "resources/js/mobile/jquery.mobile.jqGrid.min"
			]);
		}
		else {
			require([
					"", "resources/js/jquery.jqGrid.min"
			]);
		}
	},
	'resizeEvent' : function() {
		$(window).resize(function() {
			generic.resizeContent();
		});
		this.resizeContent();
	},
	'resizeContent' : function() {
		var bodyHeight = $('body').height();
		$('#content').height(bodyHeight - 103);
	},
	'alert' : function (output_msg, title_msg) {
		if (!title_msg)
			title_msg = 'Alerta';

		if (!output_msg)
			output_msg = 'Sin informaci&oacute;n.';

		$("div#alertModal h4.modal-title").html(title_msg);
		$("div#alertModal div.modal-body").html(output_msg);
		$('div#alertModal').modal('show');
	},
	'processTable' : function(entity, onclickRow){
		LoadDataTablesScripts(generic.AllTables);
		
		$('table.table tbody').on('click', 'tr', function () {
			var clickedRow = $(this);
			$("table.table tbody tr.selected").each(function(){
				if (clickedRow != $(this)){
					$(this).removeClass("selected");
				}
			});
			clickedRow.toggleClass('selected');
			if (typeof onclickRow + "" != "undefined"){
				var id = $("table.table tbody tr.selected input[type=hidden]").val();
				onclickRow.call(undefined, id);
			}
			else{
				$("#btnEditar").removeClass("disabled");
				$("#btnEliminar").removeClass("disabled");
			}
		});
		
		$("#btnAlta").button().click(function() {
			generic.getForm(entity);
		});
		$("#btnEditar").button().click(function() {
			var id = $("table.table tbody tr.selected input[type=hidden]").val();
			generic.getForm(entity, id);
		});

		$("#btnEliminar").button().click(function() {
			var id = $("table.table tbody tr.selected input[type=hidden]").val();
			generic.delete(entity, id, function() {
				generic.getList(entity);
			});
		});
	},
	
	'AllTables' : function(){
		TestTable1();
		LoadSelect2Script(generic.MakeSelect2);
	},
	
	'MakeSelect2' : function(){
		$('select').select2();
		$('.dataTables_filter').each(function(){
			$(this).find('label input[type=text]').attr('placeholder', 'Buscar');
		});
	}
};
