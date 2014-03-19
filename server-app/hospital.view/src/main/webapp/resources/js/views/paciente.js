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
			ondblClickRow : function(rowid){generic.getForm('paciente', rowid);},
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
		$("#btnSavePaciente").button().click(function(e) {
			var uploader = $('#uploader').pluploadQueue();
			 
	        // Validate number of uploaded files
	        if (uploader.total.uploaded == 0) {
	            // Files in queue upload them first
	            if (uploader.files.length > 0) {
	                uploader.start();
	            } else{
	            	paciente.submitForm();
	            }
	 
	            e.preventDefault();
	        }
		});
	},
	'prepareUploader' : function(idPaciente){
		$("#uploader").pluploadQueue({
	        // General settings
	        runtimes : 'html4',
	        url : "../paciente/fileUpload/" + idPaciente,
	 
	        // Maximum file size
	        max_file_size : '2mb',
	 
	        chunk_size: '1mb',
	 
	        // Resize images on clientside if we can
	        resize : {
	            width : 200,
	            height : 200,
	            quality : 90,
	            crop: true // crop to exact dimensions
	        },
	 
	        // Specify what files to browse for
	        filters : [
	            {title : "Image files", extensions : "jpg,gif,png"},
	            {title : "Zip files", extensions : "zip,avi"}
	        ],
	 
	        // Rename files by clicking on their titles
	        rename: false,
	         
	        // Sort files
	        sortable: true,
	 
	        // Enable ability to drag'n'drop files onto the widget (currently only HTML5 supports that)
	        dragdrop: true,
	 
	        // Views to activate
	        views: {
	            list: true,
	            thumbs: false, // Show thumbs
	            active: 'list'
	        }
	    });
	 
		
		var uploader = $('#uploader').pluploadQueue();
		
		var total_upload_files = 0;
		uploader.bind('FileUploaded', function(up, file, res) {
		     total_upload_files--;
		         if(total_upload_files == 0){
		        	 paciente.submitForm();
		         }
		 });
		
		 uploader.bind('QueueChanged', function(up, files) {
		     total_upload_files = uploader.files.length;
		 });
	},
	'submitForm' : function() {
		var data = paciente.getParams();
		if (data != null){
			var entity = (id != null) ? 'paciente/' + id : 'paciente';
			generic.post(entity, data, function() {
				generic.getList('paciente');
			});
		}
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
			return null;
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
			return data;
		}
	}
};
function validarEmail(valor) {
	  if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/.test(valor)){
		  return true;
	  } else {
		  return false;
	  }
};