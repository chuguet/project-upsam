var paciente = {
	'rowID' : null,
	'formatForm' : function() {
		$('#fechaEvaluacion').datetimepicker({
            pickTime: false,
            language : 'es'
        });
		$('#fechaNacimiento').datetimepicker({
            pickTime: false,
            language : 'es'
        });
	},
	'openUploader' : function(idExploracion){
		$("#idExploracionSelect").val(idExploracion);
		$('#uploaderModal').modal('show');
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
		        	 $('#uploaderModal').modal('hide');
		        	 up.destroy();
		        	 paciente.prepareUploader();
		        	 generic.alert("Fichos subidos correctamente","Subida correcta");
		         }
		         else{
		        	 var mensaje = res.response.substring(res.response.indexOf('"mensaje":"')+11,res.response.indexOf('","parameter"'));
		        	 generic.alert(mensaje, "Error");
		        	 up.splice();
		        	 up.refresh();
		         }
		 });
		
		 uploader.bind('QueueChanged', function(up, files) {
		     total_upload_files = uploader.files.length;
		 });
		 
		 uploader.bind('BeforeUpload', function(uploader, file) {
			var idPaciente =  $("#id").val();
			var idExploracion = $("#idExploracionSelect").val();
		    uploader.settings.url = "../paciente/" + idPaciente + "/exploracion/" + idExploracion + "/fileUpload";
		});
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
			
			var entity = (data.id != null) ? 'paciente/' + id : 'paciente';
			generic.post(entity, data, function() {
				generic.getList('paciente');
			});
		}
	}
};