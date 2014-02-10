<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript">
	paciente.formatForm();
	<c:if test="${operacion == 'edit'}">
	function showInformationIntoView(paciente) {
		$('input[id=id]').val(paciente.id);
		$('input[id=nombre]').val(paciente.nombre);
		$('input[id=apellidos]').val(paciente.apellidos);
		$('input[id=email]').val(paciente.email);
		$('input[id=expediente]').val(paciente.expediente);
	};
	</c:if>
</script>
<form id="alta">
	<fieldset>
		<legend>
			<c:choose>
				<c:when test="${operacion == 'new'}">Alta de Paciente</c:when>
				<c:otherwise>Edici&oacute;n de Paciente</c:otherwise>
			</c:choose>
		</legend>
		<input type="hidden" id="id" />
		<p>
			<label for="nombre">Nombre:</label> <input id="nombre" type="textbox"
				maxlength="200" class="text ui-widget-content ui-corner-all" />
		</p>
		<p>
			<label for="apellidos">Apellidos:</label> <input id="apellidos"
				type="textbox" maxlength="200"
				class="text ui-widget-content ui-corner-all" />
		</p>
		<p>
			<label for="email">Email:</label> <input id="email" type="textbox"
				maxlength="200" class="text ui-widget-content ui-corner-all" />
		</p>
		<p>
			<label for="expediente">Expediente:</label> <input id="expediente"
				type="textbox" maxlength="200"
				class="text ui-widget-content ui-corner-all" />
		</p>
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
</form>

<form method="POST" action="paciente/fileUpload" enctype="multipart/form-data">
	<input id="file" type="file" name="file"/> 
	<input type="submit" />
</form>