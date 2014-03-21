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
		$('input[id=escolarizacion]').val(p.escolarizacion);
		$('input[id=examinador]').val(p.examinador);
		$('input[id=fechaEvaluacion]').val(p.fechaEvaluacion);
		$('input[id=fechaNacimiento]').val(p.fechaNacimiento);
		$('input[id=sexo]').val(p.sexo);
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
				<label for="curso">Curso:</label>
				<input id="curso" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="sexo">Sexo:</label>
				<input id="sexo" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="numeroIdentificacion">N&uacute;mero de identificaci&oacute;n:</label>
				<input id="numeroIdentificacion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<div class="displayTable">
			<p>
				<label for="escolarizacion">Escolarizaci&oacute;n:</label>
				<input id="escolarizacion" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="examinador">Examinador:</label>
				<input id="examinador" type="textbox" maxlength="200" class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaEvaluacion">Fecha de evaluaci&oacute;n:</label>
				<input id="fechaEvaluacion" type="textbox" maxlength="200" readonly class="text ui-widget-content ui-corner-all" />
			</p>
			<p>
				<label for="fechaNacimiento">Fecha de Nacimiento:</label>
				<input id="fechaNacimiento" type="textbox" maxlength="200" readonly class="text ui-widget-content ui-corner-all" />
			</p>
		</div>
		<c:choose><c:when test="${operacion == 'edit'}">
			<div id="uploader">
			    <p>Your browser doesn't have Flash, Silverlight or HTML5 support.</p>
			</div>
		</c:when></c:choose>
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

