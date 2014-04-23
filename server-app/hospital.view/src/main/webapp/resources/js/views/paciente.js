var paciente = {
	'rowID' : null,
	'formatList' : function() {
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Nombre", "Apellidos", "Num. Identificaci&oacute;n", "Telefono", "Fecha Nacimiento"
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
					}, {
						name : 'numeroIdentificacion',
						index : 'numeroIdentificacion',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					}, {
						name : 'telefono',
						index : 'telefono',
						width : 20,
						sorttype : 'string',
						sortable : true,
						align : 'right'
					}, {
						name : 'fechaNacimiento',
						index : 'fechaNacimiento',
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
		$("#escolarizacion").buttonset();
		$("#sexo").buttonset();
		
		$("#btnCancel").button().click(function() {
			generic.getList('paciente');
		});
		
		$("#btnSavePaciente").button().click(function(e) {
			if($("#id").val() != "") {
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
			} else{
            	paciente.submitForm();
			}
		});
		var datePickerParams = {
                "dateFormat" : 'dd/mm/yy',
                "yearRange":"-90:+0",
                "dayNamesMin" : [
                                "D", "L", "M", "X", "J", "V", "S"
                ],
                "firstDay" : 1,
                "monthNames" : [
                                "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
                ],
                monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun',
                                  'Jul', 'Ago', 'Sep', 'Oct', 'Nov', 'Dic'],
        		changeMonth: true,
        		changeYear: true,
        };
		$("#fechaEvaluacion").datepicker(datePickerParams);
		$("#fechaNacimiento").datepicker(datePickerParams);
		$("#lista").jqGrid({
			datatype : 'local',
			data : [],
			colNames : [
					"Id", "Nombre usuario", "Fecha"
			],
			colModel : [
					{
						name : 'id',
						index : 'id',
						width : 0,
						hidden : true
					}, {
						name : 'nombreUsuario',
						index : 'nombreUsuario',
						width : 40,
						sorttype : 'string',
						sortable : true,
						align : 'left'
					}, {
						name : 'fecha',
						index : 'fecha',
						width : 30,
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
			sortname : 'nombreUsuario',
			caption : "Exploraciones",
			sortorder : 'asc',
			viewrecords : true,
			rownumbers : false,
			onSelectRow : function(rowid, status) {
				$("#uploader").show();
			},
			scroll : false
		});
		$(window).bind('resize', function() {
			$('#lista').setGridWidth($('.ui-jqgrid').parent().innerWidth() - 30);
		}).trigger('resize');
	},
	'prepareUploader' : function(idPaciente){
		$("#uploader").pluploadQueue({
	        // General settings
	        runtimes : 'html4',
	        url : "../paciente",
	 
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
	            {title : "Zip files", extensions : "zip,avi"},
	            {title : "3D", extensions : "mdx,emt"}
	        ],
	 
	        // Rename files by clicking on their titles
	        rename: false,
	         
	        // Sort files
	        sortable: true,
	 
	        // Enable ability to drag'n'drop files onto the widget (currently
			// only HTML5 supports that)
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
		         if(total_upload_files == 0 && res.response.indexOf('"correcto":false')==-1){
		        	 paciente.submitForm();
		         }else{
		        	 var mensaje = res.response.substring(res.response.indexOf('"mensaje":"')+11,res.response.indexOf('","parameter"'));
		        	 generic.alert(mensaje, "Error");
		        	 uploader.splice();
		        	 uploader.refresh();
		         }
		 });
		
		 uploader.bind('QueueChanged', function(up, files) {
		     total_upload_files = uploader.files.length;
		 });
		 
		 uploader.bind('BeforeUpload', function(uploader, file) {
				var myGrid = $('#lista');
				var selectedRowId = myGrid.jqGrid ('getGridParam', 'selrow');
				var cellValue = myGrid.jqGrid ('getCell', selectedRowId, 'id');
			    uploader.settings.url = "../paciente/" + $("#id").val() + "/exploracion/" + cellValue + "/fileUpload";
			});
		 $("#uploader").hide();
	},
	'submitForm' : function() {
		var data = paciente.getParams();
		if (data != null){
			var entity = (data.id != null) ? 'paciente/' + id : 'paciente';
			generic.post(entity, data, function() {
				generic.getList('paciente');
			});
		}
	},
	'getParams' : function() {
		var id = ($("#id").val()) ? $("#id").val() : null;
		var numeroIdentificacion = $("input[id=numeroIdentificacion]").val();
		var nombre = $("input[id=nombre]").val();
		var apellidos = $("input[id=apellidos]").val();
		var curso = $("input[id=curso]").val();
		var escolarizacion = $("input:radio[name='escolarizacion']:checked").val();
		var examinador = $("input[id=examinador]").val();
		var fechaEvaluacion = $("input[id=fechaEvaluacion]").val();
		var fechaNacimiento = $("input[id=fechaNacimiento]").val();
		var sexo = $("input:radio[name='sexo']:checked").val();
		var telefono = $("input[id=telefono]").val();
		var fichero = $("input[id=fichero]").val();
		var exploraciones = null;

		var errores = '';
		if (nombre == '') {
			errores += '- Debe introducir el nombre<br/>';
		}
		if (apellidos == '') {
			errores += '- Debe introducir los apellidos<br/>';
		}
		if ($("input[name='sexo']").is(":checked")==false) {
			errores += '- Debe seleccionar el sexo<br/>';
		}
		if ($("input[name='escolarizacion']").is(":checked")==false) {
			errores += '- Debe seleccionar la escolarizaci&oacute;n<br/>';
		}
		if (fechaNacimiento == '') {
			errores += '- Debe introducir la fecha de nacimiento<br/>';
		}
		if (examinador == '') {
			errores += '- Debe introducir un examinador<br/>';
		}
		if (curso == ''){
			errores += '- Debe introducir el curso<br/>';
		}
		if (numeroIdentificacion == ''){
			errores += '- Debe introducir el n&uacute;mero de identificaci&oacute;n<br/>';
		}
		if (telefono == ''){
			errores += '- Debe introducir el n&uacute;mero de telef&oacute;no<br/>';
		}
		if (errores != '') {
			generic.alert(errores, "Validaci&oacute;n");
			return null;
		}
		else {
			var data = {
				id : id,
				numeroIdentificacion : numeroIdentificacion,
				nombre : nombre,
				apellidos : apellidos,
				curso : curso,
				escolarizacion : escolarizacion,
				examinador : examinador,
				fechaEvaluacion : fechaEvaluacion,
				fechaNacimiento : fechaNacimiento,
				sexo : sexo,
				telefono : telefono,
				fichero : fichero,
				exploraciones : exploraciones
			};
			return data;
		}
	}
};