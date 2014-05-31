<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	paciente.formatForm();
	
	<c:if test="${operacion == 'edit'}">
	function showInformationIntoView(p) {
		$('input[id=id]').val(p.id);
		$('input[id=numeroIdentificacion]').val(p.numeroIdentificacion);
		$('input[id=nombre]').val(p.nombre);
		$('input[id=apellidos]').val(p.apellidos);
		$('input[id=curso]').val(p.curso);
		$('input[id=examinador]').val(p.examinador);
		$('input[id=fechaEvaluacion]').val(p.fechaEvaluacion);
		$('input[id=fechaNacimiento]').val(p.fechaNacimiento);
		$('input[id=telefono]').val(p.telefono);
		if(p.sexo==0){
			$('#hombre').prop('checked', true).button("refresh");
		}
		else if (p.sexo==1){
			$('#mujer').prop('checked', true).button("refresh");
		}
		
		if(p.escolarizacion==0){
			$('#educacion_especial').prop('checked', true).button("refresh");
		}
		else if (p.escolarizacion==1){
			$('#integracion').prop('checked', true).button("refresh");
		}
		else if (p.escolarizacion==2){
			$('#sin_adaptaciones').prop('checked', true).button("refresh");
		}
		
		if (p.exploraciones != null){
			for (var i = 0; i < p.exploraciones.length; i++){
				$("table.table tbody").append("<tr><td><input type='hidden' id='id" + i + "' value='" + p.exploraciones[i].id + "' />" + p.exploraciones[i].nombreUsuario + "</td><td>" + p.exploraciones[i].fecha + "</td></tr>");
			}
			generic.processTable("paciente", paciente.openUploader);
			paciente.prepareUploader(p.id);
		}
		else{
			$("datatable-1").hide();
		}

		
	};

	</c:if>
</script>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="<c:url value="/home" />">Inicio</a></li>
			<li><a href="javascript:void" onclick="javascript:generic.getList('paciente');">Pacientes</a></li>
			<li>
			<c:choose>
				<c:when test="${operacion == 'new'}">Nuevo</c:when>
				<c:otherwise>Modificar</c:otherwise>
			</c:choose>
			</li>
		</ol>
	</div>
</div>

<form class="form-horizontal" role="form" action="javascript:paciente.getParams();">
	<input type="hidden" id="id" />
	
	<div class="form-group">
		<label for="nombre" class="col-sm-2 control-label">Nombre</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="nombre" placeholder="Nombre" required autofocus maxlength="200" />
	    </div>
	</div>
	
	<div class="form-group">
		<label for="apellidos" class="col-sm-2 control-label">Apellidos</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="apellidos" placeholder="Apellidos" required maxlength="200" />
	    </div>
	</div>
	
	<div class="form-group">
		<label for="fechaNacimiento" class="col-sm-2 control-label">Fecha de nacimiento</label>
	    <div class="col-sm-10">
	    	<div class='input-group date' data-date-format="DD/MM/YYYY">
                <input type='text' id='fechaNacimiento' class="form-control" />
                <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
            </div>
	    </div>
	    <script type="text/javascript">
            /* $(function () {
                $('#fechaNacimiento').datetimepicker({
                    pickTime: false
                });
            }); */
        </script>
	</div>

	<div class="form-group">
		<label for="fechaEvaluacion" class="col-sm-2 control-label">&Uacute;ltima evaluaci&oacute;n</label>
	    <div class="col-sm-10">
	    	<div class='input-group date' data-date-format="DD/MM/YYYY">
                <input type='text' id='fechaEvaluacion' class="form-control" />
                <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
            </div>
	    </div>
	</div>

	<div class="form-group">
		<label for="sexo" class="col-sm-2 control-label">Sexo</label>
		<div class="col-sm-10">
			<div class="radio">
				<label>
			    	<input value="0" type="radio" name="sexo" id="0" checked />
			    	Hombre
			  	</label>
			</div>
			<div class="radio">
		 		<label>
		   			<input value="1" type="radio" name="sexo" id="1" />
		   			Mujer
		 		</label>
			</div>
		</div>
	</div>

	<div class="form-group">
		<label for="examinador" class="col-sm-2 control-label">Examinador</label>
	    <div class="col-sm-10">
			<input type="text" class="form-control" id="examinador" placeholder="Examinador" maxlength="200" />
	    </div>
	</div>
	
	<div class="form-group">
		<label for="curso" class="col-sm-2 control-label">Curso</label>
	    <div class="col-sm-10">
			<input type="text" class="form-control" id="curso" placeholder="Curso" maxlength="200" />
	    </div>
	</div>
		
	<div class="form-group">
		<label for="numeroIdentificacion" class="col-sm-2 control-label">N&uacute;mero de identificaci&oacute;n</label>
	    <div class="col-sm-10">
			<input type="text" class="form-control" id="numeroIdentificacion" placeholder="N&uacute;mero de identificaci&oacute;n" />
	    </div>
	</div>
			
	<div class="form-group">
		<label for="telefono" class="col-sm-2 control-label">N&uacute;mero de tel&eacute;fono</label>
	    <div class="col-sm-10">
			<input type="text" class="form-control" id="telefono" placeholder="Tel&eacute;fono" />
	    </div>
	</div>		
			
	<div class="form-group">
		<label for="usuario" class="col-sm-2 control-label">Escolarizaci&oacute;n</label>
		<div class="col-sm-10">
			<div class="radio">
				<label>
			    	<input value="0" type="radio" name="escolarizacion" id="0" checked />
			    	Educaci&oacute;n especial
			  	</label>
			</div>
			<div class="radio">
		 		<label>
		   			<input value="1" type="radio" name="escolarizacion" id="1" />
		   			Escuela de integraci&oacute;n
		 		</label>
			</div>
			<div class="radio">
		 		<label>
		   			<input value="2" type="radio" name="escolarizacion" id="2" />
		   			Sin adaptaciones
		 		</label>
			</div>
		</div>
	</div>
	
	<c:choose>
		<c:when test="${operacion == 'edit'}">
			<div class="box-content no-padding">
				<table class="table table-bordered table-striped table-hover table-heading table-datatable" id="datatable-1">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Fecha</th>
						</tr>
					</thead>
					
					<tbody></tbody>
					
					<tfoot>
						<tr>
							<th>Nombre</th>
							<th>Fecha</th>
						</tr>
					</tfoot>
				</table>
			</div>
		
			<div class="modal" id="uploaderModal">
				<div class="modal-dialog uploadModal">
					<input type="hidden" id="idExploracionSelect" />
			      	<div class="modal-content">
			        	<div class="modal-header">
			          		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			          		<h4 class="modal-title">Subida de ficheros</h4>
			        	</div>
			        	<div class="modal-body">
			          		<div id="uploader">
					    		<p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
							</div>
			        	</div>
			      </div>
			    </div>
			</div>	
		</c:when>
	</c:choose>
	
	<div class="botonera">
		<c:choose>
			<c:when test="${operacion == 'new'}">
				<button class="btn btn-default" id="btnSavePaciente" type="submit"><i class='fa fa-check fa-fw'></i>Guardar</button>
			</c:when>
			<c:otherwise>
				<button class="btn btn-default" id="btnSavePaciente" type="submit"><i class='fa fa-check fa-fw'></i>Modificar</button>
			</c:otherwise>
		</c:choose>
		<button class="btn btn-default" id="btnCancel" onclick="javascript:generic.getList('paciente');"><i class='fa fa-times fa-fw'></i>Cancelar</button>
	</div>
</form>