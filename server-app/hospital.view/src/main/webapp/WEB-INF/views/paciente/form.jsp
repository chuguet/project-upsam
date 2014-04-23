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
		}else if (p.sexo==1){
			$('#mujer').prop('checked', true).button("refresh");
		}
		if(p.escolarizacion==0){
			$('#educacion_especial').prop('checked', true).button("refresh");
		}else if (p.escolarizacion==1){
			$('#integracion').prop('checked', true).button("refresh");
		}else if (p.escolarizacion==2){
			$('#sin_adaptaciones').prop('checked', true).button("refresh");
		}
		$("#lista").setGridParam({
			data : p.exploraciones
		}).trigger("reloadGrid");
		paciente.prepareUploader(p.id);
	};

	</c:if>
</script>
	<fieldset>
		<legend>
			<c:choose>
				<c:when test="${operacion == 'new'}">Alta de Paciente</c:when>
				<c:otherwise>Edici&oacute;n de Paciente</c:otherwise>
			</c:choose>
		</legend>
		<input type="hidden" id="id" />
		<div class="displayTable">
			<p>
				<label for="nombre">Nombre:</label> 
				<input id="nombre" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="apellidos">Apellidos:</label> 
				<input id="apellidos" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaNacimiento">Fecha de nacimiento:</label>
				<input id="fechaNacimiento" type="textbox" maxlength="200" readonly class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaEvaluacion">Fecha de &uacute;ltima evaluaci&oacute;n:</label>
				<input id="fechaEvaluacion" type="textbox" maxlength="200" readonly class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<div id="sexo">
					<label for="sexo">Sexo:</label>
					<label for="hombre">Hombre</label>
				    <input type="radio" id="hombre" name="sexo" value="0"/>
					<label for="mujer">Mujer</label>
				    <input type="radio" id="mujer" name="sexo" value="1"/>
				</div>
			</p>
		</div>
		<div class="displayTable">
			<p>
				<label for="examinador">Examinador:</label>
				<input id="examinador" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="curso">Curso:</label>
				<input id="curso" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="numeroIdentificacion">N&uacute;mero de identificaci&oacute;n:</label>
				<input id="numeroIdentificacion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="telefono">N&uacute;mero de tel&eacute;fono:</label>
				<input id="telefono" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<div id="escolarizacion">
					<label for="escolarizacion">Escolarizaci&oacute;n:</label>
					<label for="educacion_especial">Educaci&oacute;n especial</label>
				    <input type="radio" id="educacion_especial" name="escolarizacion" value="0"/>
					<label for="integracion">Esc. de integraci&oacute;n</label>
				    <input type="radio" id="integracion" name="escolarizacion" value="1"/>
					<label for="sin_adaptaciones">Sin adaptaciones</label>
				    <input type="radio" id="sin_adaptaciones" name="escolarizacion" value="2"/>
				</div>
			</p>
		</div>
		<c:choose>
			<c:when test="${operacion == 'edit'}">
				<table id="lista"></table>
				<div id="paginadorLista"></div>
				<div id="uploader">
				    <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
				</div>
			</c:when>
		</c:choose>
		<div class="botonera">
			<c:choose>
				<c:when test="${operacion == 'new'}">
					<input type="button" id="btnSavePaciente" value="Guardar" />
				</c:when>
				<c:otherwise>
					<input type="button" id="btnSavePaciente" value="Modificar" />
				</c:otherwise>
			</c:choose>
			<input type="button" id="btnCancel" value="Cancelar" />
		</div>
	</fieldset>

